/*
 * TEMA 08 · Arrays y matrices
 * Ejemplo 04: REFERENCIAS, COPIAS Y LA CLASE Arrays
 *
 * Cómo ejecutarlo:  java T08_04_ReferenciasYClaseArrays.java
 *                   java T08_04_ReferenciasYClaseArrays.java Ana Luis   (con argumentos)
 */
import java.util.Arrays;

public class T08_04_ReferenciasYClaseArrays {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Un array es una REFERENCIA: = no copia
        // ------------------------------------------------------------
        int[] original = {1, 2, 3};
        int[] mismo = original;            // Las dos variables apuntan al MISMO array

        mismo[0] = 99;
        System.out.println("original: " + Arrays.toString(original));   // [99, 2, 3] 😱
        System.out.println("mismo:    " + Arrays.toString(mismo));
        System.out.println("¿original == mismo? " + (original == mismo)); // true: misma referencia
        System.out.println();

        // ------------------------------------------------------------
        // 2. Copias independientes
        // ------------------------------------------------------------
        int[] datos = {10, 20, 30, 40, 50};
        int[] copia1 = Arrays.copyOf(datos, datos.length);
        int[] copia2 = datos.clone();
        int[] trozo = Arrays.copyOfRange(datos, 1, 4);     // Índices 1, 2 y 3 (el 4 no se incluye)
        int[] masLarga = Arrays.copyOf(datos, 7);          // Los dos nuevos huecos valen 0

        copia1[0] = -1;                                    // No afecta a "datos"
        System.out.println("datos:    " + Arrays.toString(datos));
        System.out.println("copia1:   " + Arrays.toString(copia1));
        System.out.println("copia2:   " + Arrays.toString(copia2));
        System.out.println("trozo:    " + Arrays.toString(trozo));
        System.out.println("masLarga: " + Arrays.toString(masLarga));
        System.out.println();

        // ------------------------------------------------------------
        // 3. Comparar: == frente a Arrays.equals
        // ------------------------------------------------------------
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println("a == b → " + (a == b));                       // false: son dos arrays distintos
        System.out.println("Arrays.equals(a, b) → " + Arrays.equals(a, b)); // true: mismo contenido
        System.out.println();

        // ------------------------------------------------------------
        // 4. Mostrar y rellenar
        // ------------------------------------------------------------
        System.out.println("println(a) directamente: " + a);              // Algo como [I@1b6d3586
        System.out.println("Arrays.toString(a): " + Arrays.toString(a));

        char[] linea = new char[10];
        Arrays.fill(linea, '*');
        System.out.println("fill con '*': " + Arrays.toString(linea));
        System.out.println("Como texto:   " + new String(linea));         // Un char[] se puede convertir en String
        System.out.println();

        // ------------------------------------------------------------
        // 5. String[] args: los argumentos del programa
        // ------------------------------------------------------------
        System.out.println("Argumentos recibidos: " + args.length);
        for (String argumento : args) {
            System.out.println("  Hola, " + argumento);
        }
        // Ejecuta:  java T08_04_ReferenciasYClaseArrays.java Ana Luis
    }
}
