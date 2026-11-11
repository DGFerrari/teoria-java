/*
 * TEMA 06 · Ejercicio 05 · Piedra, papel o tijera  (dificultad: 5/5)
 *
 * Objetivo: jugar una ronda contra el ordenador usando todos los condicionales.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej06_05_PiedraPapelTijera.java
 */
import java.util.Random;
import java.util.Scanner;

public class Ej06_05_PiedraPapelTijera {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        // Ya hecho: lectura de la jugada, sin espacios y en minúsculas
        System.out.print("Tu jugada (piedra, papel o tijera): ");
        String jugador = teclado.nextLine().trim().toLowerCase();

        // TODO 1: calcula si la jugada es válida (boolean).

        // TODO 2: if (!jugadaValida) → muestra "Jugada no válida: X"
        //         else → todo lo demás (TODO 3 a TODO 6) va dentro de este else.

            // TODO 3: jugada del ordenador: número aleatorio 0-2 convertido
            //         en texto con un switch como expresión.

            // TODO 4: decide el resultado: "EMPATE", "VICTORIA" o "DERROTA".

            // TODO 5: puntos según el resultado, con otro switch (3, 1 o 0).

            // TODO 6: muestra las jugadas, el resultado con printf
            //         y la frase final elegida con un ternario.

        teclado.close();
    }
}
