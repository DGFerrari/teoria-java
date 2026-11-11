/*
 * TEMA 05 · Ejercicio 02 · Recibo con formato  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol05_02_ReciboConFormato.java
 */
public class Sol05_02_ReciboConFormato {

    public static void main(String[] args) {

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

        // Número de recibo: ancho 5 con ceros a la izquierda
        String cabeceraRecibo = String.format("Recibo nº %05d", numeroRecibo);
        System.out.println(cabeceraRecibo);

        // Mismos anchos en cabecera y filas: 15 | 5 | 8 | 9  (total 40 con los espacios)
        System.out.printf("%-15s %5s %8s %9s%n", "Producto", "Uds.", "Precio", "Total");
        System.out.println("-".repeat(40));
        System.out.printf("%-15s %5d %8.2f %9.2f%n", producto1, unidades1, precio1, total1);
        System.out.printf("%-15s %5d %8.2f %9.2f%n", producto2, unidades2, precio2, total2);
        System.out.printf("%-15s %5d %8.2f %9.2f%n", producto3, unidades3, precio3, total3);
        System.out.println("-".repeat(40));

        // El número ocupa las columnas de la derecha: 5 + 1 + 8 + 1 + 9 = 24
        System.out.printf("%-15s %24.2f%n", "Subtotal", subtotal);
        System.out.printf("%-15s %24.2f%n", String.format("IVA (%d%%)", PORCENTAJE_IVA), iva);
        System.out.printf("%-15s %24.2f%n", "TOTAL", total);
    }
}
