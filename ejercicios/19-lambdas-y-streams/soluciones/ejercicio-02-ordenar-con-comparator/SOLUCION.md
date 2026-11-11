# Solución · Ejercicio 02 · Ordenar con Comparator

[⬅️ Enunciado](../../ejercicio-02-ordenar-con-comparator/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Un `Comparator` se construye por piezas, igual que se describiría con palabras:

| Con palabras | Con `Comparator` |
|---|---|
| "por nombre" | `comparing(Jugador::nombre)` |
| "por goles, de más a menos" | `comparingInt(Jugador::goles).reversed()` |
| "...y si empatan, por nombre" | `.thenComparing(Jugador::nombre)` |
| "por equipo y, dentro, por goles de más a menos" | `comparing(Jugador::equipo).thenComparing(comparingInt(Jugador::goles).reversed())` |

Compáralo con el `compareTo` de tres criterios del ranking del tema 14: mismo resultado, sin `if` ni variables intermedias.

## Código explicado

**Invertir todo o solo una parte:**

```java
// reversed() invierte los goles; el desempate por nombre se añade DESPUÉS y queda normal
Comparator.comparingInt(Jugador::goles).reversed().thenComparing(Jugador::nombre)

// Aquí solo se invierte el segundo criterio
Comparator.comparing(Jugador::equipo)
        .thenComparing(Comparator.comparingInt(Jugador::goles).reversed())
```

El orden de las llamadas importa: `reversed()` afecta a todo lo que hay **antes** de él.

**Ordenar por un valor calculado:**

```java
record Jugador(String nombre, String equipo, int goles, int partidos) {
    double promedio() {
        return (double) goles / partidos;
    }
}

jugadores.sort(Comparator.comparingDouble(Jugador::promedio).reversed());
```

Una referencia a método puede apuntar a cualquier método sin parámetros, no solo a los accesores del record.

**Una función como parámetro:**

```java
static void mostrar(String titulo, List<Jugador> jugadores, Function<Jugador, String> formato) {
    List<String> textos = new ArrayList<>();
    jugadores.forEach(j -> textos.add(formato.apply(j)));
    System.out.println(titulo + ": " + String.join(", ", textos));
}
```

Cada llamada decide cómo se muestra cada jugador: `Jugador::nombre`, `j -> j.nombre() + " (" + j.goles() + ")"`...

**Máximo y mínimo con un criterio propio:**

```java
Comparator<Jugador> mejorGoleador = Comparator.comparingInt(Jugador::goles)
        .thenComparing(Comparator.comparingInt(Jugador::partidos).reversed());
Collections.max(jugadores, mejorGoleador);
```

Andrés y Carla tienen 18 goles; con menos partidos (20 frente a 22), Andrés es "mayor".

## Errores comunes

- `(goles / partidos)` sin el casting → división entera: Elena tendría promedio `1.0` y Lucía `0.0`.
- `Comparator.comparing(j -> j.goles()).reversed()` → no compila: con lambdas, el compilador no puede deducir el tipo antes de `reversed()`. Usa la referencia `Jugador::goles` o indica el tipo: `(Jugador j) -> j.goles()`.
- Poner `reversed()` al final de toda la cadena cuando solo querías invertir un criterio.

## Código completo

📄 [Sol19_02_OrdenarConComparator.java](Sol19_02_OrdenarConComparator.java)
