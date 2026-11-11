/*
 * TEMA 07 · Ejercicio 01 · Tabla de multiplicar  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol07_01_TablaDeMultiplicar.java
 */
import java.util.Scanner;

public class Sol07_01_TablaDeMultiplicar {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Qué tabla quieres ver? ");
        int numero = teclado.nextInt();
        System.out.println("=== Tabla del " + numero + " ===");

        // Sabemos el número exacto de vueltas (10): for
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%2d x %2d = %2d%n", numero, i, numero * i);
        }

        teclado.close();
    }
}
