/*
 * TEMA 08 · Ejercicio 03 · Buscar y ordenar  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol08_03_BuscarYOrdenar.java
 */
import java.util.Arrays;
import java.util.Scanner;

public class Sol08_03_BuscarYOrdenar {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int[] numeros = {23, 7, 42, 7, 15, 8, 42, 4, 16, 7};
        System.out.println("Array: " + Arrays.toString(numeros));

        // 1. Buscar TODAS las apariciones: recorremos el array entero
        System.out.print("¿Qué número buscas? ");
        int buscado = teclado.nextInt();

        int veces = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                if (veces == 0) {
                    System.out.print("Aparece en las posiciones:");
                }
                System.out.print(" " + i);
                veces++;
            }
        }
        if (veces > 0) {
            System.out.println();
            System.out.println("Aparece " + veces + " veces");
        } else {
            System.out.println("El " + buscado + " no está en el array");
        }

        // 2. Copia invertida (array nuevo: el original no cambia)
        int[] invertido = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            invertido[i] = numeros[numeros.length - 1 - i];
        }
        System.out.println("Invertido: " + Arrays.toString(invertido));

        // 3. Burbuja sobre una COPIA, contando intercambios
        int[] burbuja = Arrays.copyOf(numeros, numeros.length);
        int intercambios = 0;
        boolean hayCambios = true;
        int pasada = 0;
        while (hayCambios) {
            hayCambios = false;
            for (int i = 0; i < burbuja.length - 1 - pasada; i++) {
                if (burbuja[i] > burbuja[i + 1]) {
                    int auxiliar = burbuja[i];
                    burbuja[i] = burbuja[i + 1];
                    burbuja[i + 1] = auxiliar;
                    intercambios++;
                    hayCambios = true;
                }
            }
            pasada++;
        }
        System.out.println("Burbuja:   " + Arrays.toString(burbuja) + " (" + intercambios + " intercambios)");

        // 4. Arrays.sort sobre otra copia y comparación de CONTENIDOS
        int[] ordenadoSort = numeros.clone();
        Arrays.sort(ordenadoSort);
        System.out.println("Arrays.sort: " + Arrays.toString(ordenadoSort));
        System.out.println("¿Coinciden? " + Arrays.equals(burbuja, ordenadoSort));

        System.out.println("Original sin cambios: " + Arrays.toString(numeros));

        teclado.close();
    }
}
