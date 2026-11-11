# Solución · Ejercicio 03 · Conversor de unidades

[⬅️ Enunciado](../../ejercicio-03-conversor-de-unidades/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Cada conversión es una multiplicación o división por una cifra fija. Las diferencias están en **qué tipo** queremos obtener al final:

| Conversión | Resultado exacto | Queremos | Herramienta |
|---|---|---|---|
| 42.195 km → millas | 26.218... | 26 (cortar) | `(int)` |
| 180 cm → pulgadas | 70.866... | 71 (redondear) | `Math.round` |
| 135 min → horas | 2.25 | 2.25 y 2 | `/ 60.0` y `/ 60` |
| 38 ºC → ºF | 100.4 | Comparar `int` y `double` | `/ 5` y `/ 5.0` |

## Código explicado

**Constantes:**

```java
final double KM_A_MILLAS = 0.621371;
final double CM_POR_PULGADA = 2.54;
final int MINUTOS_POR_HORA = 60;
```

**Cortar frente a redondear:**

```java
int millasCompletas = (int) (kmMaraton * KM_A_MILLAS);   // (int) 26.218... = 26
long pulgadas = Math.round(alturaCm / CM_POR_PULGADA);   // Math.round(70.866...) = 71
```

Los paréntesis alrededor de la multiplicación son **imprescindibles**: `(int) kmMaraton * KM_A_MILLAS` convertiría a `int` solo `kmMaraton` (42) y luego multiplicaría, dando un `double` que no cabe en `int` → error de compilación.

En `alturaCm / CM_POR_PULGADA` no hay división entera: `alturaCm` es `int` pero `CM_POR_PULGADA` es `double`, así que el resultado es `double`.

**División entera frente a decimal:**

```java
double horasDecimal = (double) minutosPelicula / MINUTOS_POR_HORA;   // 2.25
int horasCompletas = minutosPelicula / MINUTOS_POR_HORA;             // 2
```

Aquí la división entera es justo lo que queremos para las horas completas.

**La fórmula de la temperatura:**

```java
int fahrenheitEntero = celsius * 9 / 5 + 32;       // 342 / 5 = 68 → 100
double fahrenheitDecimal = celsius * 9 / 5.0 + 32; // 342 / 5.0 = 68.4 → 100.4
```

Con enteros se pierde 0.4 grados **sin ningún aviso**. Es un error lógico muy típico.

Ojo con el orden: `celsius * (9 / 5)` sería todavía peor, porque `9 / 5` es `1` y el resultado sería `70`.

## Errores comunes

- `double horasDecimal = minutosPelicula / MINUTOS_POR_HORA;` → guarda `2.0`. La división se hace en `int` **antes** de guardarla en el `double`.
- `int pulgadas = Math.round(...);` → error: `Math.round` con un `double` devuelve `long`. Usa `long` o haz casting `(int)`.
- Escribir `0.621371` directamente en la fórmula en lugar de la constante: funciona, pero es menos legible.

## Código completo

📄 [Sol03_03_ConversorDeUnidades.java](Sol03_03_ConversorDeUnidades.java)
