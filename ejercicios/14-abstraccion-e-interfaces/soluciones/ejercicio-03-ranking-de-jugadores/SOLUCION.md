# Solución · Ejercicio 03 · Ranking de jugadores

[⬅️ Enunciado](../../ejercicio-03-ranking-de-jugadores/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

`compareTo` responde a una sola pregunta: **¿`this` va antes o después que `otro`?** Con varios criterios, se aplican **en cascada**: solo si el primero empata (da 0) se mira el segundo, y así sucesivamente.

| Criterio | Orden | Llamada |
|---|---|---|
| Puntos | De mayor a menor | `Integer.compare(otro.puntos, this.puntos)` |
| Partidas | De menor a mayor | `Integer.compare(this.partidas, otro.partidas)` |
| Nombre | Alfabético | `this.nombre.compareTo(otro.nombre)` |

## Código explicado

```java
static class Jugador implements Comparable<Jugador> {
    ...
    @Override
    public int compareTo(Jugador otro) {
        int resultado = Integer.compare(otro.puntos, this.puntos);
        if (resultado == 0) {
            resultado = Integer.compare(this.partidas, otro.partidas);
        }
        if (resultado == 0) {
            resultado = this.nombre.compareTo(otro.nombre);
        }
        return resultado;
    }
}
```

Con un único `return` al final, el método se lee de arriba abajo: primer criterio, desempate, segundo desempate.

**Traza de algunos casos:**

| Comparación | Puntos | Partidas | Nombre | Resultado |
|---|---|---|---|---|
| Diego vs Carla | 120 = 120 → 0 | 10 < 12 → −1 | — | **−1**: Diego antes |
| Diego vs Lucía | 0 | 0 | "Diego" < "Lucía" → negativo | Diego antes |
| Bruno vs Fran | 0 | 0 | "Bruno" < "Fran" → −4 | Bruno antes |

`"Bruno".compareTo("Fran")` da −4 porque compara la primera letra distinta: `'B'` (66) − `'F'` (70) = −4.

## Errores comunes

- Olvidar `implements Comparable<Jugador>`: el método `compareTo` existe, pero `Arrays.sort` no lo sabe → `ClassCastException`.
- Restar puntos (`return otro.puntos - this.puntos;`): funciona con números pequeños, pero con valores muy grandes puede desbordar (tema 03). `Integer.compare` es seguro.
- Mezclar el orden de los argumentos y ordenar al revés.

## Código completo

📄 [Sol14_03_RankingDeJugadores.java](Sol14_03_RankingDeJugadores.java)
