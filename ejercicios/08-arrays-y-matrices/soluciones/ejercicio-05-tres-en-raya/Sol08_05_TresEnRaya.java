/*
 * TEMA 08 · Ejercicio 05 · Tres en raya  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol08_05_TresEnRaya.java
 */
import java.util.Scanner;

public class Sol08_05_TresEnRaya {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        final int TAMANIO = 3;
        final char VACIA = '.';

        // 1. Tablero vacío
        char[][] tablero = new char[TAMANIO][TAMANIO];
        for (int fila = 0; fila < TAMANIO; fila++) {
            for (int columna = 0; columna < TAMANIO; columna++) {
                tablero[fila][columna] = VACIA;
            }
        }

        char jugador = 'X';
        int movimientos = 0;
        boolean hayGanador = false;

        // 2. Partida: termina por su condición (sin break)
        while (!hayGanador && movimientos < TAMANIO * TAMANIO) {

            // a) Mostrar el tablero
            System.out.println("  1 2 3");
            for (int fila = 0; fila < TAMANIO; fila++) {
                System.out.print((fila + 1) + " ");
                for (int columna = 0; columna < TAMANIO; columna++) {
                    System.out.print(tablero[fila][columna] + " ");
                }
                System.out.println();
            }

            // b) Turno
            System.out.println("Turno de " + jugador);

            // c) Pedir una casilla hasta que sea válida
            boolean casillaValida = false;
            int filaElegida = 0;
            int columnaElegida = 0;
            while (!casillaValida) {
                System.out.print("Fila: ");
                filaElegida = teclado.nextInt() - 1;        // El usuario ve 1-3; la matriz usa 0-2
                System.out.print("Columna: ");
                columnaElegida = teclado.nextInt() - 1;

                // Primero el rango: si está fuera, no podemos mirar la casilla
                if (filaElegida < 0 || filaElegida >= TAMANIO || columnaElegida < 0 || columnaElegida >= TAMANIO) {
                    System.out.println("  Esa casilla no existe. Usa números del 1 al 3.");
                } else if (tablero[filaElegida][columnaElegida] != VACIA) {
                    System.out.println("  Esa casilla ya está ocupada.");
                } else {
                    casillaValida = true;
                }
            }

            // d) Colocar la ficha
            tablero[filaElegida][columnaElegida] = jugador;
            movimientos++;

            // e) ¿Tres en raya? Filas y columnas en el mismo bucle
            for (int i = 0; i < TAMANIO; i++) {
                boolean filaCompleta = tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador;
                boolean columnaCompleta = tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador;
                if (filaCompleta || columnaCompleta) {
                    hayGanador = true;
                }
            }
            boolean diagonal = tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador;
            boolean diagonalInversa = tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador;
            if (diagonal || diagonalInversa) {
                hayGanador = true;
            }

            // f) Solo cambiamos de turno si nadie ha ganado
            if (!hayGanador) {
                jugador = jugador == 'X' ? 'O' : 'X';
            }
        }

        // 3. Tablero final y resultado
        System.out.println("  1 2 3");
        for (int fila = 0; fila < TAMANIO; fila++) {
            System.out.print((fila + 1) + " ");
            for (int columna = 0; columna < TAMANIO; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }

        if (hayGanador) {
            System.out.println("¡Gana " + jugador + "!");
        } else {
            System.out.println("Empate");
        }

        teclado.close();
    }
}
