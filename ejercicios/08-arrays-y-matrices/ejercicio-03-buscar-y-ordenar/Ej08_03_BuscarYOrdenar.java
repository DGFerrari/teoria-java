/*
 * TEMA 08 · Ejercicio 03 · Buscar y ordenar  (dificultad: 3/5)
 *
 * Objetivo: buscar, invertir y ordenar copias de un array sin modificar el original.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej08_03_BuscarYOrdenar.java
 */
import java.util.Arrays;
import java.util.Scanner;

public class Ej08_03_BuscarYOrdenar {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // NO TOCAR: el array original
        int[] numeros = {23, 7, 42, 7, 15, 8, 42, 4, 16, 7};
        System.out.println("Array: " + Arrays.toString(numeros));

        // ------------------------------------------------------------
        // 1. Buscar todas las apariciones
        // ------------------------------------------------------------
        System.out.print("¿Qué número buscas? ");
        int buscado = teclado.nextInt();

        // TODO 1: muestra las posiciones en las que aparece y cuántas veces,
        //         o "El X no está en el array".

        // ------------------------------------------------------------
        // 2. Copia invertida
        // ------------------------------------------------------------
        // TODO 2: crea "invertido" y muéstralo con Arrays.toString.

        // ------------------------------------------------------------
        // 3. Burbuja sobre una copia, contando intercambios
        // ------------------------------------------------------------
        // TODO 3: crea una copia (¡no con =!), ordénala con la burbuja
        //         y cuenta los intercambios.

        // ------------------------------------------------------------
        // 4. Arrays.sort sobre otra copia y comparación
        // ------------------------------------------------------------
        // TODO 4: ordena otra copia con Arrays.sort y compara con Arrays.equals.

        // Ya hecho: comprobación final
        System.out.println("Original sin cambios: " + Arrays.toString(numeros));

        teclado.close();
    }
}
