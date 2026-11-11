# Solución · Ejercicio 03 · Estadísticas con streams

[⬅️ Enunciado](../../ejercicio-03-estadisticas-con-streams/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Cada pregunta se traduce en una cadena "origen → pasos → resultado":

| Pregunta | Stream |
|---|---|
| ¿Cuántos días de más de 20 ºC? | `stream → filter(t > 20) → count()` |
| ¿Algún día bajo cero? | `stream → anyMatch(t < 0)` |
| Las 3 más altas | `stream → boxed → sorted(al revés) → limit(3) → toList()` |
| Las que empiezan por vocal | `stream → filter(vocal) → distinct → joining(", ")` |

Compáralo con el tema 08: cada línea sustituye a un bucle con su contador, su acumulador o su bandera.

## Código explicado

**Estadísticas de un `IntStream`:**

```java
double media = Arrays.stream(temperaturas).average().orElse(0);
Arrays.stream(temperaturas).max().getAsInt();
```

Un stream se consume al usarlo, así que para cada pregunta se crea uno nuevo con `Arrays.stream(...)`. Es barato: no copia el array.

**Usar un valor calculado dentro de una lambda:**

```java
double media = ...;
Arrays.stream(temperaturas).filter(t -> t > media).count();
```

`media` no cambia después de asignarse, así que la lambda puede leerla.

**Buscar una posición:**

```java
int primerDiaCaluroso = IntStream.range(0, temperaturas.length)
        .filter(i -> temperaturas[i] > 24)
        .findFirst()
        .orElse(-1);
```

`findFirst` **para** en cuanto encuentra el primero: es la búsqueda con bandera del tema 07, sin bandera.

**De primitivos a objetos para ordenar al revés:**

```java
Arrays.stream(temperaturas)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .limit(3)
        .toList();
```

**Palabras:**

```java
palabras.stream().map(String::toLowerCase).distinct().count();
palabras.stream().max(Comparator.comparingInt(String::length)).orElse("");
palabras.stream()
        .filter(p -> "aeiouAEIOU".indexOf(p.charAt(0)) >= 0)
        .distinct()
        .collect(Collectors.joining(", "));
```

El orden importa: en la primera, `map` va **antes** de `distinct` para que `Java` y `java` se consideren iguales.

## Errores comunes

- Guardar un stream en una variable y usarlo dos veces → `IllegalStateException`.
- `Arrays.stream(temperaturas).sorted(Comparator.reverseOrder())` sin `boxed()` → no compila: `IntStream.sorted()` no admite comparador.
- `distinct()` antes de `map(String::toLowerCase)` → contaría `Java` y `java` como distintas.
- Usar `max().get()` en lugar de `getAsInt()` → en un `IntStream`, `max()` devuelve un `OptionalInt`.

## Código completo

📄 [Sol19_03_EstadisticasConStreams.java](Sol19_03_EstadisticasConStreams.java)
