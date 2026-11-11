/*
 * TEMA 07 · Bucles
 * Ejemplo 02: do-while CON UN MENÚ
 *
 * Este programa ESPERA a que elijas opciones. Prueba, por ejemplo: 1, 2, 7, 1, 3
 *
 * Cómo ejecutarlo:  java T07_02_DoWhile.java
 */
import java.util.Scanner;

public class T07_02_DoWhile {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int contadorVisitas = 0;
        int opcion;                     // Declarada FUERA: se usa en la condición del while

        // El menú se muestra AL MENOS UNA VEZ: por eso do-while
        do {
            System.out.println();
            System.out.println("===== MENÚ =====");
            System.out.println("1. Saludar");
            System.out.println("2. Ver visitas");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = teclado.nextInt();

            // switch dentro del bucle: aquí sí usamos break (es un switch clásico)
            switch (opcion) {
                case 1:
                    contadorVisitas++;
                    System.out.println("¡Hola! Esta es la visita número " + contadorVisitas);
                    break;
                case 2:
                    System.out.println("Has saludado " + contadorVisitas + " veces");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción " + opcion + " no válida");
                    break;
            }
        } while (opcion != 3);          // ← punto y coma obligatorio

        // El break del switch solo termina el SWITCH, no el bucle.
        // El bucle termina únicamente cuando su condición (opcion != 3) es false.

        System.out.println("Programa terminado. Visitas totales: " + contadorVisitas);
        teclado.close();
    }
}
