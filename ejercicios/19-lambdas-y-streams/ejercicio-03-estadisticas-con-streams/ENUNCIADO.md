# Ejercicio 03 · Estadísticas con streams

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** `Arrays.stream`, `IntStream`, `average`/`max`/`min`/`count`, `anyMatch`, `findFirst`, `boxed`, `sorted`, `limit`, `distinct`, `map`, `Collectors.joining`, `Optional`

## Enunciado

En el tema 08 calculabas medias, máximos y recuentos con bucles. Ahora hazlo **sin escribir ningún bucle**, solo con streams, en [`Ej19_03_EstadisticasConStreams.java`](Ej19_03_EstadisticasConStreams.java).

**Temperaturas** (un `int[]` de 14 días):

1. Media, máxima y mínima.
2. Cuántos días superan los 20 ºC y cuántos superan la media.
3. ¿Hay algún día bajo cero?
4. El **primer día** (contando desde 1) que superó los 24 ºC.
5. Las 3 temperaturas más altas, en una `List<Integer>`.

**Palabras** (una frase dividida con `split`):

6. Cuántas hay y cuántas distintas, sin distinguir mayúsculas (`Java` y `java` son la misma).
7. La más larga y la longitud media.
8. Las que empiezan por vocal, sin repetir, unidas con comas.
9. Las de más de 6 letras, en mayúsculas y ordenadas.

## Salida esperada

```
=== Temperaturas de 14 días ===
Media: 17,29 ºC
Máxima: 25 ºC · mínima: 9 ºC
Días de más de 20 ºC: 4
Días por encima de la media: 7
¿Algún día bajo cero? false
Primer día de más de 24 ºC: el 9
Las 3 más altas: [25, 23, 22]
=== Palabras ===
Total: 18 · distintas (sin distinguir mayúsculas): 17
La más larga: orientado
Longitud media: 4,56 letras
Empiezan por vocal: es, un, orientado, a, objetos, en, elegante
Más de 6 letras, en mayúsculas y ordenadas: [ELEGANTE, LENGUAJE, OBJETOS, ORIENTADO, PROCESAR, STREAMS]
```

## Pistas

<details>
<summary>Pista 1</summary>

`Arrays.stream(int[])` da un `IntStream`, que ya tiene `average()`, `max()`, `min()` y `sum()`. Los tres primeros devuelven un `OptionalDouble`/`OptionalInt` (el array podría estar vacío): usa `orElse(...)` o `getAsInt()`.

</details>

<details>
<summary>Pista 2</summary>

Para saber **en qué posición** ocurre algo, recorre las posiciones en lugar de los valores:

```java
IntStream.range(0, temperaturas.length)
        .filter(i -> temperaturas[i] > 24)
        .findFirst()
```

Y para que una lambda pueda usar la media, guárdala antes en una variable que no vuelvas a cambiar (efectivamente final).

</details>

<details>
<summary>Pista 3</summary>

`sorted(Comparator.reverseOrder())` solo funciona con objetos. Convierte antes el `IntStream` en un `Stream<Integer>` con `.boxed()`.

</details>

<details>
<summary>Pista 4</summary>

`max` con un criterio: `palabras.stream().max(Comparator.comparingInt(String::length))`.

</details>

## Cómo ejecutarlo

```bash
java Ej19_03_EstadisticasConStreams.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-estadisticas-con-streams/SOLUCION.md).
