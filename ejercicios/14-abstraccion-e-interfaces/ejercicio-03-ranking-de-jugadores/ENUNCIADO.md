# Ejercicio 03 · Ranking de jugadores

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** implementar `Comparable<T>`, `compareTo` con varios criterios, `Integer.compare`, `Arrays.sort`

## Enunciado

Completa la clase `Jugador` de [`Ej14_03_RankingDeJugadores.java`](Ej14_03_RankingDeJugadores.java) para que implemente `Comparable<Jugador>` con este orden:

1. Más **puntos** primero.
2. Si empatan en puntos, el que ha jugado **menos partidas** primero (ha sido más eficiente).
3. Si también empatan, por **nombre** en orden alfabético.

El `main` ya ordena el array con `Arrays.sort` y muestra el ranking y el podio.

## Salida esperada

```
Diego.compareTo(Carla) = -1 → Diego va antes
Bruno.compareTo(Fran)  = -4 → Bruno va antes
=== Clasificación ===
1. Diego   120 pts · 10 partidas
2. Lucía   120 pts · 10 partidas
3. Carla   120 pts · 12 partidas
4. Bruno    95 pts ·  8 partidas
5. Fran     95 pts ·  8 partidas
6. Elena    60 pts ·  5 partidas
=== Podio ===
🥇 Diego
🥈 Lucía
🥉 Carla
```

(El número exacto de `Bruno.compareTo(Fran)` depende de cómo compares los nombres; lo importante es que sea **negativo**.)

## Pistas

<details>
<summary>Pista 1</summary>

```java
@Override
public int compareTo(Jugador otro) {
    int resultado = Integer.compare(otro.puntos, this.puntos);   // De mayor a menor
    if (resultado == 0) {
        resultado = ...;                                          // Partidas, de menor a mayor
    }
    if (resultado == 0) {
        resultado = ...;                                          // Nombre
    }
    return resultado;
}
```

</details>

<details>
<summary>Pista 2</summary>

Para "de menor a mayor", `Integer.compare(this.x, otro.x)`. Para "de mayor a menor", al revés: `Integer.compare(otro.x, this.x)`.

</details>

## Cómo ejecutarlo

```bash
java Ej14_03_RankingDeJugadores.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-ranking-de-jugadores/SOLUCION.md).
