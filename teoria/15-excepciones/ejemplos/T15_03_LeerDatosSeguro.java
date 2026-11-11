/*
 * TEMA 15 · Excepciones
 * Ejemplo 03: LEER DATOS DEL TECLADO SIN QUE EL PROGRAMA FALLE
 *
 * Este programa ESPERA datos. Equivócate a propósito:
 *   edad: "quince" → "-4" → "15"
 *   precio: "12,5" → "12.5"
 *
 * Cómo ejecutarlo:  java T15_03_LeerDatosSeguro.java
 */
import java.util.Scanner;

public class T15_03_LeerDatosSeguro {

    /** Pide un entero entre min y max hasta que el usuario escriba uno válido. */
    static int leerEntero(Scanner teclado, String mensaje, int min, int max) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String linea = teclado.nextLine().strip();
            try {
                numero = Integer.parseInt(linea);              // Puede lanzar NumberFormatException
                if (numero < min || numero > max) {
                    System.out.println("  Tiene que estar entre " + min + " y " + max);
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("  '" + linea + "' no es un número entero");
            }
        }
        return numero;
    }

    /** Pide un decimal (con punto) hasta que sea válido y no negativo. */
    static double leerDecimal(Scanner teclado, String mensaje) {
        double numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String linea = teclado.nextLine().strip();
            try {
                numero = Double.parseDouble(linea);            // parseDouble usa SIEMPRE punto
                valido = numero >= 0;
                if (!valido) {
                    System.out.println("  No puede ser negativo");
                }
            } catch (NumberFormatException e) {
                System.out.println("  '" + linea + "' no es un número (usa punto decimal: 12.5)");
            }
        }
        return numero;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int edad = leerEntero(teclado, "Edad: ", 0, 120);
        double precio = leerDecimal(teclado, "Precio de la entrada: ");

        double precioFinal = edad < 12 || edad >= 65 ? precio * 0.5 : precio;
        System.out.printf("Con %d años, pagas %.2f €%n", edad, precioFinal);

        // Comparación con el tema 07: allí usábamos hasNextInt() para comprobar ANTES de leer.
        // Las dos formas son válidas. Leer la línea y capturar NumberFormatException tiene
        // una ventaja: nunca quedan restos en el teclado (el problema de nextLine del tema 05).

        teclado.close();
    }
}
