/*
 * TEMA 05 · Entrada y salida
 * Ejemplo 03: LEER DEL TECLADO CON Scanner
 *
 * Este programa ESPERA a que escribas. Ejemplo de respuestas:
 *   Ana María
 *   15
 *   1,68        (con punto si tu sistema está en inglés)
 *   Valencia
 *   s
 *
 * Cómo ejecutarlo:  java T05_03_ScannerBasico.java
 */

// Scanner está en java.util: hay que importarla
import java.util.Scanner;

public class T05_03_ScannerBasico {

    public static void main(String[] args) {

        // Creamos el Scanner UNA vez, conectado al teclado (System.in)
        Scanner teclado = new Scanner(System.in);

        // ------------------------------------------------------------
        // 1. nextLine(): una línea completa (con espacios)
        // ------------------------------------------------------------
        System.out.print("¿Cómo te llamas? ");      // print: la respuesta va en la misma línea
        String nombre = teclado.nextLine();         // El programa se detiene hasta que pulses Enter

        // ------------------------------------------------------------
        // 2. nextInt() y nextDouble(): números
        // ------------------------------------------------------------
        System.out.print("¿Cuántos años tienes? ");
        int edad = teclado.nextInt();

        System.out.print("¿Cuánto mides en metros? ");
        double altura = teclado.nextDouble();       // En español se escribe con coma: 1,68

        // ------------------------------------------------------------
        // 3. next(): una sola palabra
        // ------------------------------------------------------------
        System.out.print("¿En qué ciudad vives? (una palabra) ");
        String ciudad = teclado.next();

        // ------------------------------------------------------------
        // 4. Un carácter: next() + charAt(0)
        // ------------------------------------------------------------
        System.out.print("¿Te gusta programar? (s/n) ");
        char respuesta = teclado.next().charAt(0);

        // ------------------------------------------------------------
        // Usamos los datos
        // ------------------------------------------------------------
        System.out.println();
        System.out.println("=== Tus datos ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " (el año que viene, " + (edad + 1) + ")");
        System.out.printf("Altura: %.2f m (%d cm)%n", altura, Math.round(altura * 100));
        System.out.println("Ciudad: " + ciudad);
        System.out.println("¿Le gusta programar? " + respuesta);

        // Cerramos al final (después ya no se podría volver a leer del teclado)
        teclado.close();

        // PRUEBA: cuando te pida la edad, escribe "quince". ¿Qué error aparece?
    }
}
