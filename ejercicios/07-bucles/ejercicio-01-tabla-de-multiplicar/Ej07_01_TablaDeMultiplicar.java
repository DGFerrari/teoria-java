/*
 * TEMA 07 · Ejercicio 01 · Tabla de multiplicar  (dificultad: 1/5)
 *
 * Objetivo: mostrar la tabla de multiplicar de un número con un for.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej07_01_TablaDeMultiplicar.java
 */
import java.util.Scanner;

public class Ej07_01_TablaDeMultiplicar {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Ya hecho: lectura del número y título
        System.out.print("¿Qué tabla quieres ver? ");
        int numero = teclado.nextInt();
        System.out.println("=== Tabla del " + numero + " ===");

        // TODO: escribe un for del 1 al 10 que muestre cada línea de la tabla
        //       con printf("%2d x %2d = %2d%n", ...).

        teclado.close();
    }
}
