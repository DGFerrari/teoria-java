/*
 * TEMA 05 · Entrada y salida
 * Ejemplo 02: TABLAS ALINEADAS CON printf
 *
 * Cómo ejecutarlo:  java T05_02_TablasConFormato.java
 */
public class T05_02_TablasConFormato {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Con \t las columnas se descuadran si los textos son largos
        // ------------------------------------------------------------
        System.out.println("=== Con tabulaciones ===");
        System.out.println("Producto\tUds.\tPrecio");
        System.out.println("Pan\t2\t1.2");
        System.out.println("Chocolate negro\t10\t2.5");   // Se descuadra
        System.out.println();

        // ------------------------------------------------------------
        // 2. Con printf y anchos fijos, todo queda alineado
        // ------------------------------------------------------------
        // Diseño de columnas:
        //   Producto: 16 caracteres, a la izquierda  → %-16s
        //   Uds.:      5 caracteres, a la derecha    → %5d
        //   Precio:    8 caracteres, 2 decimales     → %8.2f
        //   Total:     9 caracteres, 2 decimales     → %9.2f
        String formatoFila = "%-16s %5d %8.2f %9.2f%n";
        String formatoCabecera = "%-16s %5s %8s %9s%n";

        System.out.println("=== Con printf ===");
        System.out.printf(formatoCabecera, "Producto", "Uds.", "Precio", "Total");
        System.out.println("-".repeat(41));                          // Repite "-" 41 veces
        System.out.printf(formatoFila, "Pan", 2, 1.2, 2 * 1.2);
        System.out.printf(formatoFila, "Chocolate negro", 10, 2.5, 10 * 2.5);
        System.out.printf(formatoFila, "Leche", 6, 0.95, 6 * 0.95);
        System.out.println("-".repeat(41));
        System.out.printf("%-16s %24.2f%n", "TOTAL", 2 * 1.2 + 10 * 2.5 + 6 * 0.95);
        System.out.println();

        // printf REDONDEA al mostrar, sin cambiar el valor de la variable.
        // Por eso nunca verás cosas como 5.699999999999999 en la tabla.
        System.out.println("6 * 0.95 con println: " + (6 * 0.95));
        System.out.printf("6 * 0.95 con printf:  %.2f%n", 6 * 0.95);
        System.out.println();

        // ------------------------------------------------------------
        // 3. Números con ceros a la izquierda y porcentajes
        // ------------------------------------------------------------
        System.out.println("=== Clasificación ===");
        System.out.printf("%3s  %-10s %6s%n", "Pos", "Equipo", "Victorias");
        System.out.printf("%03d  %-10s %5.1f%%%n", 1, "Leones", 87.5);
        System.out.printf("%03d  %-10s %5.1f%%%n", 2, "Águilas", 74.25);
        System.out.printf("%03d  %-10s %5.1f%%%n", 3, "Tiburones", 9.0);

        // PRUEBA: añade una columna "Puntos" a la clasificación con ancho 7.
    }
}
