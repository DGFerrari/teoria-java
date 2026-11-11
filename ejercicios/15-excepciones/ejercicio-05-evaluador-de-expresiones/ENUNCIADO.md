# Ejercicio 05 · Evaluador de expresiones

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** excepción propia con **causa** (encadenamiento), traducir excepciones, multi-catch, `throw` dentro de un `switch`, try-with-resources con dos recursos

## Enunciado

Vas a escribir una mini calculadora que lee expresiones de un texto, una por línea, con el formato `número operador número` separados por espacios. Completa [`Ej15_05_EvaluadorDeExpresiones.java`](Ej15_05_EvaluadorDeExpresiones.java):

**1. `ExpresionInvalidaException`** (checked) guarda el número de línea (`getLinea()`) y tiene dos constructores: uno con `(mensaje, linea)` y otro que además recibe la **causa** (`Throwable`), es decir, la excepción original que provocó el problema.

**2. `Informe` implementa `AutoCloseable`.** Su `close()` muestra el resumen. Así el resumen sale **automáticamente** al terminar el `try`.

**3. `operar(a, operador, b)`** usa un switch moderno con `+`, `-`, `*`, `/` y `^` (potencia, con `Math.pow`). Con `double`, dividir entre 0 **no** lanza nada (da `Infinity`), así que lánzala tú: `ArithmeticException("División por cero")`. Si el operador no existe, `IllegalArgumentException("Operador desconocido: " + operador)`.

**4. `evaluar(expresion, linea)`** divide con `split(" +")` (uno o más espacios) y **traduce** cualquier problema a `ExpresionInvalidaException`:

| Problema | Mensaje | Causa |
|---|---|---|
| No hay exactamente 3 partes | `Se esperaban 3 elementos y hay N` | (ninguna) |
| `parseDouble` lanza `NumberFormatException` | `Número no válido` | la `NumberFormatException` |
| `operar` lanza `ArithmeticException` o `IllegalArgumentException` | `Error al operar` | la excepción de `operar` |

**5. El `main`** abre en un mismo try-with-resources un `Scanner` sobre el texto y un `Informe`. Para cada línea muestra el resultado o el error; si el error tiene causa, añade su mensaje entre paréntesis.

## Salida esperada

```
Línea 1: 3 + 4      → 7
Línea 2: 10 / 4     → 2.5
Línea 3: 7 * -2     → -14
Línea 4: 2 ^ 10     → 1024
Línea 5: 8 / 0      ✘ Error al operar (causa: División por cero)
Línea 6: cinco + 2  ✘ Número no válido (causa: For input string: "cinco")
Línea 7: 4 % 3      ✘ Error al operar (causa: Operador desconocido: %)
Línea 8: 9 - 3 - 1  ✘ Se esperaban 3 elementos y hay 5
[Informe] Correctas: 4 | Errores: 4 | Suma de resultados: 1019.5
```

## Pistas

<details>
<summary>Pista 1</summary>

`Exception` ya tiene un constructor `Exception(String mensaje, Throwable causa)`. Llámalo con `super(mensaje, causa)` y luego podrás recuperarla con `e.getCause()`. A esto se le llama **encadenar excepciones**: envuelves el error técnico en uno con más contexto, sin perder el original.

</details>

<details>
<summary>Pista 2</summary>

Un caso de un switch moderno puede lanzar una excepción en lugar de dar un valor:

```java
default -> throw new IllegalArgumentException("Operador desconocido: " + operador);
```

Y en un bloque con `yield` puedes lanzarla antes de llegar al `yield`.

</details>

<details>
<summary>Pista 3</summary>

Traducir una excepción es capturarla y lanzar otra:

```java
try {
    return operar(a, partes[1], b);
} catch (ArithmeticException | IllegalArgumentException e) {
    throw new ExpresionInvalidaException("Error al operar", linea, e);
}
```

</details>

<details>
<summary>Pista 4</summary>

Dos recursos en el mismo `try`, separados por `;`:

```java
try (Scanner lector = new Scanner(expresiones);
     Informe informe = new Informe()) {
    ...
}
```

</details>

## Cómo ejecutarlo

```bash
java Ej15_05_EvaluadorDeExpresiones.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-evaluador-de-expresiones/SOLUCION.md).
