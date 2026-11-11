/*
 * TEMA 08 · Arrays y matrices
 * Ejemplo 03: BUSCAR Y ORDENAR
 *
 * Cómo ejecutarlo:  java T08_03_BuscarYOrdenar.java
 */
import java.util.Arrays;

public class T08_03_BuscarYOrdenar {

    public static void main(String[] args) {

        int[] numeros = {23, 7, 42, 15, 8, 4, 16};

        // ------------------------------------------------------------
        // 1. Búsqueda lineal con bandera (para en cuanto lo encuentra, sin break)
        // ------------------------------------------------------------
        int buscado = 15;
        int posicion = -1;                 // -1 = no encontrado (y hace de bandera)
        int i = 0;
        while (i < numeros.length && posicion == -1) {
            if (numeros[i] == buscado) {
                posicion = i;
            }
            i++;
        }
        System.out.println("Array: " + Arrays.toString(numeros));
        if (posicion != -1) {
            System.out.println(buscado + " está en la posición " + posicion + " (se han mirado " + i + " elementos)");
        } else {
            System.out.println(buscado + " no está en el array");
        }

        // ¿Está o no está? (versión boolean)
        int otro = 99;
        boolean encontrado = false;
        for (int j = 0; j < numeros.length && !encontrado; j++) {
            encontrado = numeros[j] == otro;
        }
        System.out.println("¿Está el " + otro + "? " + encontrado);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Ordenar con el método de la burbuja (paso a paso)
        // ------------------------------------------------------------
        int[] v = {5, 1, 4, 2, 8};
        System.out.println("Burbuja. Inicio:  " + Arrays.toString(v));

        boolean hayCambios = true;
        int pasada = 0;
        while (hayCambios) {                           // Termina cuando una pasada no cambia nada
            hayCambios = false;
            for (int k = 0; k < v.length - 1 - pasada; k++) {   // El final ya está ordenado
                if (v[k] > v[k + 1]) {
                    int auxiliar = v[k];               // Intercambio
                    v[k] = v[k + 1];
                    v[k + 1] = auxiliar;
                    hayCambios = true;
                }
            }
            pasada++;
            System.out.println("Tras la pasada " + pasada + ": " + Arrays.toString(v));
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3. Ordenar con Arrays.sort (lo que se usa en la práctica)
        // ------------------------------------------------------------
        int[] copia = Arrays.copyOf(numeros, numeros.length);   // Para no perder el original
        Arrays.sort(copia);
        System.out.println("Original: " + Arrays.toString(numeros));
        System.out.println("Ordenado: " + Arrays.toString(copia));

        String[] nombres = {"Lucía", "Ana", "Pablo", "Carmen"};
        Arrays.sort(nombres);                                    // También con textos (orden alfabético)
        System.out.println("Nombres ordenados: " + Arrays.toString(nombres));
        System.out.println();

        // ------------------------------------------------------------
        // 4. Búsqueda binaria (SOLO en arrays ordenados)
        // ------------------------------------------------------------
        int posicionBinaria = Arrays.binarySearch(copia, 16);
        System.out.println("binarySearch(16) en el ordenado → posición " + posicionBinaria);
        int noEsta = Arrays.binarySearch(copia, 10);
        System.out.println("binarySearch(10) → " + noEsta + " (negativo: no está)");

        // PRUEBA: modifica la burbuja para ordenar de MAYOR a MENOR.
    }
}
