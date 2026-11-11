/*
 * TEMA 08 · Arrays y matrices
 * Ejemplo 02: RECORRER UN ARRAY Y ALGORITMOS BÁSICOS
 *
 * Cómo ejecutarlo:  java T08_02_Recorridos.java
 */
public class T08_02_Recorridos {

    public static void main(String[] args) {

        String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
        int[] pasos = {8200, 6500, 10300, 4800, 9100, 15200, 3900};

        // ------------------------------------------------------------
        // 1. for clásico: tenemos el índice (útil para usar dos arrays a la vez)
        // ------------------------------------------------------------
        System.out.println("=== Pasos de la semana ===");
        for (int i = 0; i < pasos.length; i++) {          // i < length, NO <=
            System.out.printf("%s: %,6d%n", dias[i], pasos[i]);
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. for-each: solo los valores (más legible si no hace falta el índice)
        // ------------------------------------------------------------
        int total = 0;
        for (int p : pasos) {          // "para cada p de pasos"
            total += p;
        }
        double media = (double) total / pasos.length;
        System.out.printf("Total: %,d pasos | Media: %,.0f pasos/día%n", total, media);

        // ------------------------------------------------------------
        // 3. Máximo, mínimo y SUS POSICIONES
        // ------------------------------------------------------------
        int maximo = pasos[0];         // Empezamos con el primer elemento
        int minimo = pasos[0];
        int posMaximo = 0;
        int posMinimo = 0;
        for (int i = 1; i < pasos.length; i++) {          // Desde el segundo
            if (pasos[i] > maximo) {
                maximo = pasos[i];
                posMaximo = i;
            }
            if (pasos[i] < minimo) {
                minimo = pasos[i];
                posMinimo = i;
            }
        }
        System.out.println("Día más activo: " + dias[posMaximo] + " (" + maximo + ")");
        System.out.println("Día menos activo: " + dias[posMinimo] + " (" + minimo + ")");

        // ------------------------------------------------------------
        // 4. Contar los que cumplen una condición
        // ------------------------------------------------------------
        final int OBJETIVO = 8000;
        int diasCumplidos = 0;
        for (int p : pasos) {
            if (p >= OBJETIVO) {
                diasCumplidos++;
            }
        }
        System.out.println("Días con al menos " + OBJETIVO + " pasos: " + diasCumplidos);
        System.out.println();

        // ------------------------------------------------------------
        // 5. Modificar el array: necesita el for clásico
        // ------------------------------------------------------------
        int[] copiaPasos = {8200, 6500, 10300};
        for (int i = 0; i < copiaPasos.length; i++) {
            copiaPasos[i] = copiaPasos[i] / 1000;          // Pasos → miles
        }
        System.out.println("En miles: " + copiaPasos[0] + ", " + copiaPasos[1] + ", " + copiaPasos[2]);

        // Con for-each NO funciona: x es una copia del valor, no el cajón
        for (int x : copiaPasos) {
            x = 0;                                         // No cambia nada en el array
        }
        System.out.println("Tras el for-each: " + copiaPasos[0] + ", " + copiaPasos[1] + ", " + copiaPasos[2]);
        System.out.println();

        // ------------------------------------------------------------
        // 6. Recorrer al revés e invertir
        // ------------------------------------------------------------
        System.out.print("Días al revés: ");
        for (int i = dias.length - 1; i >= 0; i--) {
            System.out.print(dias[i] + " ");
        }
        System.out.println();

        int[] numeros = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < numeros.length / 2; i++) {     // Solo hasta la mitad
            int auxiliar = numeros[i];
            numeros[i] = numeros[numeros.length - 1 - i];
            numeros[numeros.length - 1 - i] = auxiliar;
        }
        System.out.print("Array invertido: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();

        // PRUEBA: calcula cuántos días se superó la media de pasos.
    }
}
