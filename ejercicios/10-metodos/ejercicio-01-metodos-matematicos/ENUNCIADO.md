# Ejercicio 01 · Métodos matemáticos

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** definir métodos, parámetros, tipo de retorno, `return`, métodos `boolean`

## Enunciado

En [`Ej10_01_MetodosMatematicos.java`](Ej10_01_MetodosMatematicos.java) el `main` ya está escrito y llama a cinco métodos. Los métodos están declarados, pero devuelven un valor provisional. Escribe el contenido de cada uno:

| Método | Qué devuelve |
|---|---|
| `areaRectangulo(base, altura)` | `base × altura` |
| `perimetroRectangulo(base, altura)` | `2 × (base + altura)` |
| `esMultiplo(numero, divisor)` | `true` si `numero` es múltiplo de `divisor` |
| `maximoDeTres(a, b, c)` | El mayor de los tres |
| `celsiusAFahrenheit(celsius)` | `celsius × 9 / 5 + 32` |

## Salida esperada

```
Área de 4.5 x 2: 9.0
Perímetro de 4.5 x 2: 13.0
¿15 es múltiplo de 5? true
¿15 es múltiplo de 4? false
Máximo de 7, 19 y 3: 19
Máximo de -2, -8 y -5: -2
36.6 ºC = 97.88 ºF
```

## Pistas

<details>
<summary>Pista 1</summary>

Un método que devuelve un `boolean` puede devolver directamente la comparación: `return numero % divisor == 0;`.

</details>

<details>
<summary>Pista 2</summary>

Para el máximo de tres, puedes reutilizar `Math.max` dos veces: `Math.max(a, Math.max(b, c))`. O hacerlo con `if`.

</details>

## Cómo ejecutarlo

```bash
java Ej10_01_MetodosMatematicos.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-metodos-matematicos/SOLUCION.md).
