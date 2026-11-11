/*
 * TEMA 08 · Ejercicio 05 · Tres en raya  (dificultad: 5/5)
 *
 * Objetivo: el juego del tres en raya para dos jugadores con una matriz char[3][3].
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej08_05_TresEnRaya.java
 *
 * Regla: sin break ni continue. Los bucles terminan por su condición.
 */
import java.util.Scanner;

public class Ej08_05_TresEnRaya {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Ya hecho: tamaño y símbolo de casilla vacía
        final int TAMANIO = 3;
        final char VACIA = '.';

        // TODO 1: crea el tablero char[TAMANIO][TAMANIO] y rellénalo con VACIA.

        // Ya hecho: variables de la partida
        char jugador = 'X';
        int movimientos = 0;
        boolean hayGanador = false;

        // TODO 2: bucle de la partida: while (!hayGanador && movimientos < TAMANIO * TAMANIO)
        //
        //   a) Muestra el tablero con los números de fila y columna (1 a 3).
        //   b) Muestra "Turno de X" (u O).
        //   c) Bucle que pida fila y columna hasta que la casilla sea válida:
        //        - fuera de rango → "  Esa casilla no existe. Usa números del 1 al 3."
        //        - ocupada        → "  Esa casilla ya está ocupada."
        //   d) Coloca la ficha y suma 1 a movimientos.
        //   e) Comprueba filas, columnas y diagonales → hayGanador.
        //   f) Si no ha ganado, cambia de jugador (ternario).

        // TODO 3: muestra el tablero final y el resultado:
        //         "¡Gana X!" / "¡Gana O!" o "Empate".

        teclado.close();
    }
}
