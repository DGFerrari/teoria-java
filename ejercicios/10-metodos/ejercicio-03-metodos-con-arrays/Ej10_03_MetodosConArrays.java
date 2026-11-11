/*
 * TEMA 10 · Ejercicio 03 · Métodos con arrays  (dificultad: 3/5)
 *
 * Objetivo: escribir métodos que reciben, modifican y devuelven arrays.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej10_03_MetodosConArrays.java
 */
import java.util.Random;

public class Ej10_03_MetodosConArrays {

    // NO TOCAR: el main que usa los métodos
    public static void main(String[] args) {
        Random random = new Random(42);          // Semilla fija: mismos números para todos
        int[] datos = new int[10];

        rellenarAleatorio(datos, random, 0, 80);
        mostrar(datos, "Datos");

        System.out.printf("Media: %.2f%n", media(datos));
        int pos = posicionDelMaximo(datos);
        System.out.println("Máximo: " + datos[pos] + " (posición " + pos + ")");
        System.out.println("Mayores que 50: " + contarMayoresQue(datos, 50));

        int[] pares = filtrarPares(datos);
        mostrar(pares, "Pares");
        mostrar(datos, "Datos (sin cambios)");
    }

    /** MODIFICA el array: cada posición recibe un aleatorio entre min y max (incluidos). */
    static void rellenarAleatorio(int[] datos, Random random, int min, int max) {
        // TODO 1
    }

    /** Muestra el array con el formato [a, b, c] y salta de línea. */
    static void mostrar(int[] datos) {
        // TODO 2 (puedes construir el texto a mano o usar Arrays.toString)
        System.out.println();
    }

    /** Sobrecarga: muestra "titulo: [a, b, c]". Reutiliza mostrar(datos). */
    static void mostrar(int[] datos, String titulo) {
        // TODO 3
    }

    /** Devuelve la media de los elementos. */
    static double media(int[] datos) {
        // TODO 4
        return 0;
    }

    /** Devuelve la posición del elemento más grande. */
    static int posicionDelMaximo(int[] datos) {
        // TODO 5
        return 0;
    }

    /** Devuelve cuántos elementos son mayores que el límite. */
    static int contarMayoresQue(int[] datos, int limite) {
        // TODO 6
        return 0;
    }

    /** Devuelve un array NUEVO con los elementos pares. No modifica el original. */
    static int[] filtrarPares(int[] datos) {
        // TODO 7: primero cuenta los pares, crea el array y luego cópialos
        return new int[0];
    }
}
