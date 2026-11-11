/*
 * TEMA 05 · Ejercicio 05 · Factura interactiva  (dificultad: 5/5)
 *
 * Objetivo: pedir los datos de una compra, calcular la factura y mostrarla alineada.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej05_05_FacturaInteractiva.java
 */
import java.util.Random;
import java.util.Scanner;

public class Ej05_05_FacturaInteractiva {

    public static void main(String[] args) {

        // Ya hecho: constantes y herramientas
        final int PORCENTAJE_IVA = 21;
        final int ANCHO = 53;                      // Ancho total de la factura
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        // ------------------------------------------------------------
        // ENTRADA
        // ------------------------------------------------------------
        // TODO 1: lee el nombre del cliente.

        // TODO 2: lee nombre, unidades y precio del producto 1.

        // TODO 3: lee nombre, unidades y precio del producto 2.
        //         ¡Cuidado con el salto de línea pendiente!

        // TODO 4: lee el porcentaje de descuento.

        // ------------------------------------------------------------
        // PROCESO
        // ------------------------------------------------------------
        // TODO 5: genera el número de factura (1 a 9999) y crea el código
        //         "F-0042" con String.format.

        // TODO 6: calcula los importes, el subtotal, el descuento, la base,
        //         el IVA y el total.

        // TODO 7: calcula las unidades totales usando +=.

        // ------------------------------------------------------------
        // SALIDA
        // ------------------------------------------------------------
        // Ya hecho: la primera línea de la factura
        System.out.println();
        System.out.println("=".repeat(ANCHO));

        // TODO 8: muestra el resto de la factura (mira la salida esperada).

        teclado.close();
    }
}
