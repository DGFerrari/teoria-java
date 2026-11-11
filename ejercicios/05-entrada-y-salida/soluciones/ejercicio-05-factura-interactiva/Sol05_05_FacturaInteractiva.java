/*
 * TEMA 05 · Ejercicio 05 · Factura interactiva  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol05_05_FacturaInteractiva.java
 */
import java.util.Random;
import java.util.Scanner;

public class Sol05_05_FacturaInteractiva {

    public static void main(String[] args) {

        final int PORCENTAJE_IVA = 21;
        final int ANCHO = 53;
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        // ============================================================
        // ENTRADA
        // ============================================================
        System.out.print("Cliente: ");
        String cliente = teclado.nextLine();

        System.out.print("Producto 1: ");
        String producto1 = teclado.nextLine();
        System.out.print("Unidades: ");
        int unidades1 = teclado.nextInt();
        System.out.print("Precio por unidad: ");
        double precio1 = teclado.nextDouble();
        teclado.nextLine();                        // Limpia el Enter antes del siguiente texto

        System.out.print("Producto 2: ");
        String producto2 = teclado.nextLine();
        System.out.print("Unidades: ");
        int unidades2 = teclado.nextInt();
        System.out.print("Precio por unidad: ");
        double precio2 = teclado.nextDouble();

        System.out.print("Descuento (%): ");
        int porcentajeDescuento = teclado.nextInt();

        // ============================================================
        // PROCESO
        // ============================================================
        int numeroFactura = random.nextInt(1, 10000);               // 1 a 9999
        String codigoFactura = String.format("F-%04d", numeroFactura);

        double importe1 = unidades1 * precio1;
        double importe2 = unidades2 * precio2;
        double subtotal = importe1 + importe2;
        double descuento = subtotal * porcentajeDescuento / 100;    // double * int → double
        double base = subtotal - descuento;
        double iva = base * PORCENTAJE_IVA / 100;
        double total = base + iva;

        int unidadesTotales = 0;
        unidadesTotales += unidades1;
        unidadesTotales += unidades2;

        // ============================================================
        // SALIDA  (fila: 26 + 1 + 5 + 1 + 9 + 1 + 10 = 53 caracteres)
        // ============================================================
        String formatoFila = "%-26s %5s %9s %10s%n";
        String formatoProducto = "%-26s %5d %9.2f %10.2f%n";
        String formatoResumen = "%-26s %26.2f%n";

        System.out.println();
        System.out.println("=".repeat(ANCHO));
        String textoCliente = String.format("Cliente: %s", cliente);
        System.out.printf("%-20s%33s%n", "FACTURA " + codigoFactura, textoCliente);
        System.out.println("=".repeat(ANCHO));

        System.out.printf(formatoFila, "Producto", "Uds.", "Precio", "Importe");
        System.out.println("-".repeat(ANCHO));
        System.out.printf(formatoProducto, producto1, unidades1, precio1, importe1);
        System.out.printf(formatoProducto, producto2, unidades2, precio2, importe2);
        System.out.println("-".repeat(ANCHO));

        System.out.println("Unidades totales: " + unidadesTotales);
        System.out.printf(formatoResumen, "Subtotal", subtotal);
        System.out.printf(formatoResumen, String.format("Descuento (%d%%)", porcentajeDescuento), -descuento);
        System.out.printf(formatoResumen, "Base imponible", base);
        System.out.printf(formatoResumen, String.format("IVA (%d%%)", PORCENTAJE_IVA), iva);
        System.out.printf(formatoResumen, "TOTAL", total);
        System.out.println("=".repeat(ANCHO));

        teclado.close();
    }
}
