/*
 * TEMA 05 · Ejercicio 02 · Recibo con formato  (dificultad: 2/5)
 *
 * Objetivo: mostrar un recibo alineado usando SOLO printf y String.format.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej05_02_ReciboConFormato.java
 */
public class Ej05_02_ReciboConFormato {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // NO TOCAR: datos y cálculos ya hechos
        // ------------------------------------------------------------
        int numeroRecibo = 42;
        final int PORCENTAJE_IVA = 21;

        String producto1 = "Cuaderno";
        int unidades1 = 3;
        double precio1 = 2.35;

        String producto2 = "Bolígrafo";
        int unidades2 = 10;
        double precio2 = 0.60;

        String producto3 = "Mochila";
        int unidades3 = 1;
        double precio3 = 24.90;

        double total1 = unidades1 * precio1;
        double total2 = unidades2 * precio2;
        double total3 = unidades3 * precio3;
        double subtotal = total1 + total2 + total3;
        double iva = subtotal * PORCENTAJE_IVA / 100;
        double total = subtotal + iva;

        // ------------------------------------------------------------
        // SALIDA
        // ------------------------------------------------------------
        // TODO 1: crea con String.format el texto "Recibo nº 00042" y muéstralo.

        // TODO 2: cabecera de la tabla y línea separadora (40 guiones).
        //         Truco: "-".repeat(40) crea un texto con 40 guiones.

        // TODO 3: una fila por producto con printf.

        // TODO 4: separador, subtotal, IVA (21%) y TOTAL alineados a la derecha.
    }
}
