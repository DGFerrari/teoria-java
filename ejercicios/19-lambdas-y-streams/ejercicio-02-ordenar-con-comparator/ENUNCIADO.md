# Ejercicio 02 · Ordenar con Comparator

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** `Comparator.comparing`, `comparingInt`, `comparingDouble`, `reversed`, `thenComparing`, referencias a métodos (`Jugador::nombre`), `Function<T, R>` como parámetro

## Enunciado

En [`Ej19_02_OrdenarConComparator.java`](Ej19_02_OrdenarConComparator.java) hay una lista de jugadores. En el tema 14 habrías tenido que elegir **un** orden con `Comparable`; con `Comparator` puedes ordenarlos de todas las formas que quieras sin tocar el record.

1. Completa `promedio()` (goles por partido) y `mostrar(titulo, jugadores, formato)`, que recibe una **función** que convierte cada jugador en texto.
2. Ordena la lista con `jugadores.sort(...)` y muéstrala:
   - Por nombre.
   - Por goles, de más a menos. Si empatan, por nombre.
   - Por equipo y, dentro de cada equipo, por goles de más a menos.
   - Por promedio, de mayor a menor.
3. Crea un `Comparator<Jugador>` llamado `mejorGoleador`: más goles es mejor y, si empatan, es mejor el que ha jugado **menos** partidos. Úsalo con `Collections.max` y `Collections.min`.

## Salida esperada

```
Por nombre: Andrés, Carla, Diego, Elena, Lucía
Por goles: Andrés (18), Carla (18), Elena (12), Lucía (12), Diego (7)
Por equipo y goles: Andrés (Atlético, 18), Elena (Atlético, 12), Diego (Betis, 7), Carla (Rayo, 18), Lucía (Rayo, 12)
Por promedio: Elena (1,20), Diego (1,17), Andrés (0,90), Carla (0,82), Lucía (0,80)
Máximo goleador (si empatan, el de menos partidos): Andrés
El que menos marca: Diego
```

## Pistas

<details>
<summary>Pista 1</summary>

```java
jugadores.sort(Comparator.comparing(Jugador::nombre));
mostrar("Por nombre", jugadores, Jugador::nombre);
```

La referencia `Jugador::nombre` sirve a la vez como "criterio de orden" y como "función de formato".

</details>

<details>
<summary>Pista 2</summary>

`reversed()` invierte **todo** el comparador que tiene delante. Para invertir solo el segundo criterio, crea ese criterio aparte y pásalo a `thenComparing`:

```java
Comparator.comparing(Jugador::equipo)
        .thenComparing(Comparator.comparingInt(Jugador::goles).reversed())
```

</details>

<details>
<summary>Pista 3</summary>

`Collections.max(lista, comparador)` devuelve el elemento **mayor** según ese comparador. Con `mejorGoleador`, "mayor" significa "mejor goleador".

</details>

## Cómo ejecutarlo

```bash
java Ej19_02_OrdenarConComparator.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-ordenar-con-comparator/SOLUCION.md).
