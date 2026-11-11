# Ejercicio 03 · Evaluador de condiciones

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** operadores relacionales, `&&`, `||`, `!`, precedencia

## Enunciado

Un parque de atracciones usa estas variables para decidir qué puede hacer cada visitante:

```java
int edad = 16;
double alturaCm = 152;
boolean tieneEntrada = true;
boolean esVip = false;
double saldo = 12.5;
double precioFotografia = 10;
int anio = 2024;
double temperaturaCorporal = 38.2;
```

Completa [`Ej04_03_EvaluadorDeCondiciones.java`](Ej04_03_EvaluadorDeCondiciones.java) escribiendo **una expresión `boolean` para cada regla**:

| Variable | Regla |
|---|---|
| `puedeComprarFoto` | El saldo llega para pagar la fotografía |
| `puedeEntrar` | Tiene entrada **y** (es mayor de edad **o** es VIP) |
| `tieneDescuento` | Es menor de 18 **o** tiene 65 años o más |
| `puedeSubirMontania` | Mide entre 140 y 195 cm (ambos incluidos) |
| `esBisiesto` | El año es divisible entre 4 y no entre 100, **o** es divisible entre 400 |
| `debeIrEnfermeria` | La temperatura está **fuera** del rango normal (de 36 a 37.5, ambos incluidos) |
| `esVisitanteNormal` | **No** es VIP **y no** es mayor de edad |

## Salida esperada

```
¿Puede comprar la foto? true
¿Puede entrar? false
¿Tiene descuento? true
¿Puede subir a la montaña rusa? true
¿2024 es bisiesto? true
¿Debe ir a la enfermería? true
¿Es visitante normal? true
```

Comprueba también el año bisiesto con estos valores:

| Año | ¿Bisiesto? |
|---|---|
| 1900 | `false` |
| 2000 | `true` |
| 2023 | `false` |
| 2024 | `true` |

## Pistas

<details>
<summary>Pista 1</summary>

Un rango "entre A y B" es `x >= A && x <= B`. Fuera de un rango es `x < A || x > B`.

</details>

<details>
<summary>Pista 2</summary>

"Divisible entre 4" es `anio % 4 == 0`. "No divisible entre 100" es `anio % 100 != 0`.

</details>

<details>
<summary>Pista 3</summary>

En `puedeEntrar` los paréntesis son obligatorios: `&&` tiene más prioridad que `||`. Sin ellos, un VIP sin entrada podría entrar.

</details>

## Cómo ejecutarlo

```bash
java Ej04_03_EvaluadorDeCondiciones.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-evaluador-de-condiciones/SOLUCION.md).
