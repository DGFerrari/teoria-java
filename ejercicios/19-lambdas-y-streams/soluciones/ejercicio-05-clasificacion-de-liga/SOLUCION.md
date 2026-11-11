# Solución · Ejercicio 05 · Clasificación de liga

[⬅️ Enunciado](../../ejercicio-05-clasificacion-de-liga/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

La dificultad está en que un partido afecta a **dos** equipos a la vez. Si intentas agrupar los partidos por equipo, cada partido tendría que estar en dos grupos. La clave es **cambiar de punto de vista**: convertir cada partido en dos `Resultado`, uno por equipo. A partir de ahí, todo es "agrupar por equipo y resumir".

| Partido | Resultados que produce |
|---|---|
| `Atlético 2-1 Betis` | `Atlético: 2 a favor, 1 en contra` · `Betis: 1 a favor, 2 en contra` |
| `Celta 0-0 Rayo` | `Celta: 0, 0` · `Rayo: 0, 0` |

## Código explicado

**Validar sin detener el programa:**

```java
static Optional<Partido> parsear(String linea) {
    Optional<Partido> resultado = Optional.empty();
    String[] partes = linea.split(";");
    if (partes.length == 4) {
        try {
            resultado = Optional.of(new Partido(partes[0], partes[1],
                    Integer.parseInt(partes[2]), Integer.parseInt(partes[3])));
        } catch (NumberFormatException e) {
            resultado = Optional.empty();
        }
    }
    return resultado;
}
```

Devolver un `Optional` (en lugar de lanzar la excepción o devolver `null`) deja claro a quien llama que el resultado **puede no existir**, y encaja con `flatMap(Optional::stream)`.

**Un partido → dos resultados → agrupar:**

```java
Map<String, List<Resultado>> porEquipo = partidos.stream()
        .flatMap(Sol19_05_ClasificacionDeLiga::resultados)
        .collect(Collectors.groupingBy(Resultado::equipo));
```

`map` convierte cada elemento en **otro elemento**; `flatMap` convierte cada elemento en **un stream** y los une todos. Aquí, 9 partidos → 18 resultados.

**Resumir cada grupo:**

```java
return new Fila(equipo,
        resultados.size(),
        (int) resultados.stream().filter(Resultado::ganado).count(),
        ...
        resultados.stream().mapToInt(Resultado::golesFavor).sum(),
        resultados.stream().mapToInt(Resultado::golesContra).sum());
```

Los puntos y la diferencia de goles **no se guardan**: se calculan en métodos de `Fila`. Así es imposible que no cuadren con los partidos.

**Cuatro criterios de orden:**

```java
.sorted(Comparator.comparingInt(Fila::puntos).reversed()
        .thenComparing(Comparator.comparingInt(Fila::diferencia).reversed())
        .thenComparing(Comparator.comparingInt(Fila::golesFavor).reversed())
        .thenComparing(Fila::equipo))
```

**Datos extra en una línea cada uno:**

```java
partidos.stream().max(Comparator.comparingInt(Partido::totalGoles)).ifPresent(...);
partidos.stream().mapToInt(Partido::totalGoles).average().orElse(0);
tabla.stream().filter(f -> f.perdidos() == 0).map(Fila::equipo).collect(Collectors.joining(", "));
```

Hay tres partidos con 4 goles (`Betis 3-1 Celta`, `Atlético 4-0 Celta` y `Rayo 2-2 Betis`); con empates, `max` devuelve el **primero** que encuentra.

## Errores comunes

- Agrupar los **partidos** por equipo local → los partidos como visitante no cuentan.
- Usar `map` en lugar de `flatMap` con `resultados` → obtendrías un `Stream<Stream<Resultado>>`.
- Calcular los goles en contra con `golesVisitante` para todos → el visitante tendría sus propios goles como "en contra".
- `.reversed()` al final de toda la cadena → el desempate por nombre saldría de la Z a la A.

## Código completo

📄 [Sol19_05_ClasificacionDeLiga.java](Sol19_05_ClasificacionDeLiga.java)
