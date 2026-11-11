# Solución · Ejercicio 03 · Evaluador de condiciones

[⬅️ Enunciado](../../ejercicio-03-evaluador-de-condiciones/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Traduce la regla palabra por palabra: "y" → `&&`, "o" → `||`, "no" → `!`, "entre" → `>=` y `<=`. Después, revisa los paréntesis.

## Código explicado

```java
boolean puedeComprarFoto = saldo >= precioFotografia;                 // 12.5 >= 10 → true
boolean puedeEntrar = tieneEntrada && (edad >= 18 || esVip);          // true && (false || false) → false
boolean tieneDescuento = edad < 18 || edad >= 65;                     // true || false → true
boolean puedeSubirMontania = alturaCm >= 140 && alturaCm <= 195;      // true && true → true
boolean esBisiesto = (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
boolean debeIrEnfermeria = temperaturaCorporal < 36 || temperaturaCorporal > 37.5;
boolean esVisitanteNormal = !esVip && !(edad >= 18);
```

### Los paréntesis en `puedeEntrar`

Sin paréntesis, `tieneEntrada && edad >= 18 || esVip` se evalúa como `(tieneEntrada && edad >= 18) || esVip`, porque `&&` va antes que `||`. Un VIP **sin entrada** podría pasar. Con los paréntesis, la entrada es obligatoria siempre.

### El año bisiesto

| Año | `% 4 == 0` | `% 100 != 0` | `% 400 == 0` | Resultado |
|---|---|---|---|---|
| 1900 | true | false | false | (true && false) \|\| false → **false** |
| 2000 | true | false | true | (true && false) \|\| true → **true** |
| 2023 | false | true | false | (false && true) \|\| false → **false** |
| 2024 | true | true | false | (true && true) \|\| false → **true** |

Aquí los paréntesis no cambian el resultado (por la precedencia, `&&` ya iba primero), pero dejan clara la intención.

### Dentro y fuera de un rango

Son condiciones opuestas:

```java
boolean dentro = t >= 36 && t <= 37.5;
boolean fuera  = t < 36 || t > 37.5;     // Lo mismo que !dentro
```

Al negar, `>=` pasa a `<`, `<=` pasa a `>` y `&&` pasa a `||`. Es la **ley de De Morgan**: `!(a && b)` equivale a `!a || !b`.

### esVisitanteNormal

`!esVip && !(edad >= 18)` también se puede escribir `!(esVip || edad >= 18)` (De Morgan otra vez) o `!esVip && edad < 18`. Las tres son equivalentes.

## Errores comunes

- `140 <= alturaCm <= 195` → no compila en Java.
- `temperaturaCorporal < 36 && temperaturaCorporal > 37.5` → siempre `false` (ningún número es a la vez menor que 36 y mayor que 37.5).
- `anio % 4 = 0` → con un solo `=` es una asignación y no compila.

## Código completo

📄 [Sol04_03_EvaluadorDeCondiciones.java](Sol04_03_EvaluadorDeCondiciones.java)
