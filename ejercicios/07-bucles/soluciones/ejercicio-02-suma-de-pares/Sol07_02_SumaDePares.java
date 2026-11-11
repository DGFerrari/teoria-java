/*
 * TEMA 07 · Ejercicio 02 · Suma de pares  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol07_02_SumaDePares.java
 */
import java.util.Scanner;

public class Sol07_02_SumaDePares {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("N: ");
        int n = teclado.nextInt();

        int suma = 0;        // Acumulador
        int cantidad = 0;    // Contador (y nos dice si ya hemos mostrado algún número)

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                if (cantidad > 0) {
                    System.out.print(" + ");    // Separador antes de cada número salvo el primero
                }
                System.out.print(i);
                suma += i;
                cantidad++;
            }
        }

        if (cantidad > 0) {
            System.out.println(" = " + suma);
            System.out.println("Hay " + cantidad + " números pares entre 1 y " + n);
        } else {
            System.out.println("No hay números pares entre 1 y " + n);
        }

        teclado.close();
    }
}
