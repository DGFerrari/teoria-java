# Ejercicio 03 · Calculadora con switch

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** `switch` moderno (`->`), `switch` con `char`, `if` dentro de un caso, operador ternario

## Enunciado

Completa [`Ej06_03_CalculadoraConSwitch.java`](Ej06_03_CalculadoraConSwitch.java) para que el usuario escriba **número, operador y número**, y el programa muestre el resultado.

Operadores admitidos: `+`, `-`, `*`, `/`, `%` (resto) y `^` (potencia).

Reglas:

1. Usa un `switch` **moderno** (con `->`) sobre el operador.
2. Si se divide (o se calcula el resto) entre **0**, muestra `Error: no se puede dividir entre 0`.
3. Si el operador no es ninguno de los anteriores, muestra `Operador no válido: X`.
4. Muestra cada número (los dos de la entrada y el resultado) **sin decimales** si es entero (por ejemplo `8.0` → `8`) y con **2 decimales** si no. Usa un **ternario** para elegir el formato.

## Salida esperada

```
Primer número: 12,5
Operador (+ - * / % ^): /
Segundo número: 4
12,50 / 4 = 3,13
```

Más pruebas:

| Entrada | Salida |
|---|---|
| `2` `^` `10` | `2 ^ 10 = 1024` |
| `7` `%` `0` | `Error: no se puede dividir entre 0` |
| `3` `x` `4` | `Operador no válido: x` |
| `6` `*` `1,5` | `6 * 1,50 = 9` |

## Pistas

<details>
<summary>Pista 1</summary>

Lee el operador con `teclado.next().charAt(0)`. En el `switch`, los casos de `char` van entre comillas simples: `case '+' -> ...`.

</details>

<details>
<summary>Pista 2</summary>

Para que el resultado se pueda mostrar después del `switch`, declara antes una variable `double resultado` y otra `boolean hayError = false`. En los casos de error, pon `hayError = true`.

</details>

<details>
<summary>Pista 3</summary>

Un `double` es entero si `resultado == Math.floor(resultado)`. El formato se puede elegir así:

```java
String formato = resultado == Math.floor(resultado) ? "%.0f" : "%.2f";
String texto = String.format(formato, resultado);
```

Haz lo mismo con los dos números de la entrada.

</details>

## Cómo ejecutarlo

```bash
java Ej06_03_CalculadoraConSwitch.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-calculadora-con-switch/SOLUCION.md).
