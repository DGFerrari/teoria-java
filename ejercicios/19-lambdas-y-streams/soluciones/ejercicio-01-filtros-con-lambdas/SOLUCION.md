# Solución · Ejercicio 01 · Filtros con lambdas

[⬅️ Enunciado](../../ejercicio-01-filtros-con-lambdas/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Sin lambdas, necesitarías un método por cada filtro: `filtrarPares`, `filtrarMayoresQue10`... todos con el mismo bucle y solo una línea distinta. La lambda permite separar las dos cosas:

| Parte | Quién la escribe |
|---|---|
| **Cómo** se recorre y se construye el resultado | `filtrar`, una sola vez |
| **Qué** condición se aplica | Quien llama, con una lambda |

## Código explicado

**Un método que recibe una condición:**

```java
static List<Integer> filtrar(List<Integer> numeros, Predicate<Integer> condicion) {
    List<Integer> resultado = new ArrayList<>();
    for (int n : numeros) {
        if (condicion.test(n)) {
            resultado.add(n);
        }
    }
    return resultado;
}
```

`condicion.test(n)` ejecuta la lambda que se haya pasado, con `n` como parámetro.

**Lambdas guardadas en variables:**

```java
Predicate<Integer> esPar = n -> n % 2 == 0;
Predicate<Integer> mayorQue10 = n -> n > 10;
```

**Combinar condiciones:**

```java
filtrar(numeros, esPar.and(mayorQue10));
filtrar(numeros, esPar.negate().or(multiploDe3));
```

`and`, `or` y `negate` son métodos `default` de `Predicate` (tema 14) que **devuelven un `Predicate` nuevo**, sin modificar los originales.

**Lambdas en métodos de las listas:**

```java
copia.removeIf(n -> n < 10);
copia.forEach(n -> System.out.print(" " + n * 2));
```

`removeIf` sustituye al bucle con `Iterator` del tema 16.

## Errores comunes

- `Predicate<int>` → los genéricos no admiten primitivos: `Predicate<Integer>`.
- Llamar a `removeIf` sobre la lista de `List.of` → `UnsupportedOperationException`.
- Escribir `condicion(n)` en lugar de `condicion.test(n)` → una lambda es un objeto; se ejecuta llamando a su método.

## Código completo

📄 [Sol19_01_FiltrosConLambdas.java](Sol19_01_FiltrosConLambdas.java)
