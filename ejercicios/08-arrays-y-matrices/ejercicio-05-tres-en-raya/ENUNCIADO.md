# Ejercicio 05 · Tres en raya

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema (matriz `char[][]`, recorridos por filas, columnas y diagonales) + bucles con banderas, validación de entrada y condicionales

## Enunciado

Programa el **tres en raya** para dos jugadores en la consola. Completa [`Ej08_05_TresEnRaya.java`](Ej08_05_TresEnRaya.java):

1. El tablero es una matriz `char[3][3]` que empieza llena de `'.'` (casilla vacía).
2. Empieza `X` y se alternan los turnos con `O`.
3. En cada turno se muestra el tablero y se pide **fila** y **columna** (de **1 a 3** para el usuario).
4. Se repite la pregunta mientras la casilla esté **fuera del tablero** o **ocupada**, explicando el motivo.
5. Tras cada jugada, se comprueba si el jugador ha hecho **tres en raya**: una fila, una columna o una de las dos diagonales con su símbolo.
6. La partida termina cuando alguien gana o cuando se llenan las 9 casillas (**empate**).
7. Al final, se muestra el tablero y el resultado.

> 📏 Sin `break` ni `continue`: el bucle de la partida debe terminar por su condición (`!hayGanador && movimientos < 9`).

## Salida de ejemplo

```
  1 2 3
1 . . .
2 . . .
3 . . .
Turno de X
Fila: 5
Columna: 1
  Esa casilla no existe. Usa números del 1 al 3.
Fila: 1
Columna: 1
  1 2 3
1 X . .
2 . . .
3 . . .
Turno de O
Fila: 1
Columna: 1
  Esa casilla ya está ocupada.
Fila: 2
Columna: 2
...
  1 2 3
1 X X X
2 . O .
3 . . O
¡Gana X!
```

## Pistas

<details>
<summary>Pista 1</summary>

Estructura general:

```java
char jugador = 'X';
int movimientos = 0;
boolean hayGanador = false;
while (!hayGanador && movimientos < 9) {
    // mostrar tablero
    // pedir casilla válida (otro bucle con bandera)
    // colocar ficha, movimientos++
    // comprobar si 'jugador' ha ganado
    // si no ha ganado, cambiar de turno
}
```

</details>

<details>
<summary>Pista 2</summary>

El usuario escribe de 1 a 3, pero la matriz va de 0 a 2: resta 1 antes de usar los números como índices.

</details>

<details>
<summary>Pista 3</summary>

Para comprobar las **filas**, recorre cada fila y mira si sus tres casillas son del jugador:

```java
for (int fila = 0; fila < 3; fila++) {
    if (tablero[fila][0] == jugador && tablero[fila][1] == jugador && tablero[fila][2] == jugador) {
        hayGanador = true;
    }
}
```

Las columnas son iguales intercambiando los índices. Las diagonales son `[0][0], [1][1], [2][2]` y `[0][2], [1][1], [2][0]`.

</details>

<details>
<summary>Pista 4</summary>

Cambiar de turno con un ternario: `jugador = jugador == 'X' ? 'O' : 'X';`. Hazlo **solo** si no ha ganado; así, al salir del bucle, `jugador` es el ganador.

</details>

## Cómo ejecutarlo

```bash
java Ej08_05_TresEnRaya.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-tres-en-raya/SOLUCION.md).
