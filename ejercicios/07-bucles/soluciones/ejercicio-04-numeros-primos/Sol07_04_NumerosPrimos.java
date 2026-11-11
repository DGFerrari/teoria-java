/*
 * TEMA 07 · Ejercicio 04 · Números primos  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol07_04_NumerosPrimos.java
 */
import java.util.Scanner;

public class Sol07_04_NumerosPrimos {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int inicio;
        int fin;

        // 1. Pedir el rango hasta que sea válido
        do {
            System.out.print("Inicio del rango: ");
            inicio = teclado.nextInt();
            System.out.print("Fin del rango: ");
            fin = teclado.nextInt();
            if (inicio < 1 || fin < inicio) {
                System.out.println("  El inicio debe ser al menos 1 y el fin no puede ser menor que el inicio.");
            }
        } while (inicio < 1 || fin < inicio);

        System.out.println("Primos entre " + inicio + " y " + fin + ":");

        int contador = 0;
        int suma = 0;

        // 2. Recorrer el rango
        for (int numero = inicio; numero <= fin; numero++) {

            // 3. ¿Es primo? La bandera se reinicia para CADA número.
            boolean esPrimo = numero > 1;
            int divisor = 2;
            while (divisor * divisor <= numero && esPrimo) {   // Para en cuanto encuentra un divisor
                if (numero % divisor == 0) {
                    esPrimo = false;
                }
                divisor++;
            }

            // 4. Mostrar, contar y sumar
            if (esPrimo) {
                System.out.print(numero + " ");
                contador++;
                suma += numero;
                if (contador % 10 == 0) {
                    System.out.println();          // 10 por línea
                }
            }
        }

        // 5. Cerrar la última línea si quedó a medias
        if (contador % 10 != 0) {
            System.out.println();
        }
        System.out.println("Total: " + contador + " primos | Suma: " + suma);

        teclado.close();
    }
}
