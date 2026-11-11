/*
 * TEMA 08 · Arrays y matrices
 * Ejemplo 06: MATRICES APLICADAS (un tablero y una tabla con cabeceras)
 *
 * Cómo ejecutarlo:  java T08_06_MatricesAplicadas.java
 */
import java.util.Random;

public class T08_06_MatricesAplicadas {

    public static void main(String[] args) {

        // ============================================================
        // 1. Un tablero de juego: char[][]
        // ============================================================
        final int TAMANIO = 5;
        char[][] tablero = new char[TAMANIO][TAMANIO];

        // Rellenar todo con agua '~'
        for (int fila = 0; fila < TAMANIO; fila++) {
            for (int columna = 0; columna < TAMANIO; columna++) {
                tablero[fila][columna] = '~';
            }
        }

        // Colocar 4 barcos en casillas aleatorias (sin repetir casilla)
        Random random = new Random(3);           // Semilla: siempre el mismo tablero
        int barcosColocados = 0;
        while (barcosColocados < 4) {
            int fila = random.nextInt(TAMANIO);
            int columna = random.nextInt(TAMANIO);
            if (tablero[fila][columna] == '~') {  // Solo si la casilla está libre
                tablero[fila][columna] = 'B';
                barcosColocados++;
            }
        }

        // Mostrar con números de fila y columna
        System.out.print("   ");
        for (int columna = 0; columna < TAMANIO; columna++) {
            System.out.print(columna + " ");
        }
        System.out.println();
        for (int fila = 0; fila < TAMANIO; fila++) {
            System.out.print(fila + "  ");
            for (int columna = 0; columna < TAMANIO; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }

        // ¿Hay algún barco en la fila 2? (búsqueda con bandera)
        boolean hayBarco = false;
        for (int columna = 0; columna < TAMANIO && !hayBarco; columna++) {
            hayBarco = tablero[2][columna] == 'B';
        }
        System.out.println("¿Hay barco en la fila 2? " + hayBarco);
        System.out.println();

        // ============================================================
        // 2. Tabla de datos con cabeceras en arrays aparte
        // ============================================================
        String[] tiendas = {"Centro", "Norte", "Playa"};
        String[] trimestres = {"T1", "T2", "T3", "T4"};
        double[][] ventas = {                       // [tienda][trimestre], en miles de euros
                {12.5, 14.0, 18.2, 20.1},
                {8.3, 9.1, 10.4, 12.0},
                {5.0, 15.6, 25.8, 7.2}
        };

        // Cabecera
        System.out.printf("%-8s", "Tienda");
        for (String t : trimestres) {
            System.out.printf("%8s", t);
        }
        System.out.printf("%9s%n", "Total");

        // Filas con su total, y buscamos la mejor tienda
        int mejorTienda = 0;
        double mejorTotal = 0;
        for (int tienda = 0; tienda < ventas.length; tienda++) {
            System.out.printf("%-8s", tiendas[tienda]);
            double totalTienda = 0;
            for (int trimestre = 0; trimestre < ventas[tienda].length; trimestre++) {
                System.out.printf("%8.1f", ventas[tienda][trimestre]);
                totalTienda += ventas[tienda][trimestre];
            }
            System.out.printf("%9.1f%n", totalTienda);

            if (tienda == 0 || totalTienda > mejorTotal) {
                mejorTotal = totalTienda;
                mejorTienda = tienda;
            }
        }
        System.out.printf("Mejor tienda: %s (%.1f mil euros)%n", tiendas[mejorTienda], mejorTotal);

        // PRUEBA: añade una fila final con el total de cada trimestre (suma por columnas).
    }
}
