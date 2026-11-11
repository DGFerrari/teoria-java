/*
 * TEMA 08 · Ejercicio 04 · Matriz de ventas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol08_04_MatrizDeVentas.java
 */
public class Sol08_04_MatrizDeVentas {

    public static void main(String[] args) {

        String[] vendedores = {"Ana", "Luis", "Marta", "Jorge"};
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun"};
        int[][] ventas = {
                {12, 15,  9, 20, 18, 22},
                { 8, 11, 14,  9, 13, 10},
                {20, 18, 25, 17, 21, 24},
                {10,  9, 12, 15,  8, 14}
        };

        // 1. Arrays de totales (con new empiezan a 0)
        int[] totalVendedor = new int[ventas.length];       // Uno por fila
        int[] totalMes = new int[ventas[0].length];         // Uno por columna
        int totalGeneral = 0;

        // 2. Un único recorrido: cada celda suma en su fila y en su columna
        int filaMax = 0;
        int columnaMax = 0;
        for (int fila = 0; fila < ventas.length; fila++) {
            for (int columna = 0; columna < ventas[fila].length; columna++) {
                int valor = ventas[fila][columna];
                totalVendedor[fila] += valor;
                totalMes[columna] += valor;
                totalGeneral += valor;
                if (valor > ventas[filaMax][columnaMax]) {
                    filaMax = fila;
                    columnaMax = columna;
                }
            }
        }

        // 3. Tabla
        System.out.printf("%-8s", "Vendedor");
        for (String mes : meses) {
            System.out.printf("%6s", mes);
        }
        System.out.printf("%7s%n", "Total");

        for (int fila = 0; fila < ventas.length; fila++) {
            System.out.printf("%-8s", vendedores[fila]);
            for (int columna = 0; columna < ventas[fila].length; columna++) {
                System.out.printf("%6d", ventas[fila][columna]);
            }
            System.out.printf("%7d%n", totalVendedor[fila]);
        }

        System.out.printf("%-8s", "TOTAL");
        for (int total : totalMes) {
            System.out.printf("%6d", total);
        }
        System.out.printf("%7d%n", totalGeneral);
        System.out.println();

        // 4. Máximos sobre los arrays de totales (guardamos la posición)
        int mejorVendedor = 0;
        for (int i = 1; i < totalVendedor.length; i++) {
            if (totalVendedor[i] > totalVendedor[mejorVendedor]) {
                mejorVendedor = i;
            }
        }
        int mejorMes = 0;
        for (int i = 1; i < totalMes.length; i++) {
            if (totalMes[i] > totalMes[mejorMes]) {
                mejorMes = i;
            }
        }

        // 5. Resultados
        System.out.println("Mejor vendedor: " + vendedores[mejorVendedor] + " (" + totalVendedor[mejorVendedor] + " unidades)");
        System.out.println("Mejor mes: " + meses[mejorMes] + " (" + totalMes[mejorMes] + " unidades)");
        System.out.println("Mejor venta individual: " + ventas[filaMax][columnaMax]
                + " (" + vendedores[filaMax] + " en " + meses[columnaMax] + ")");
    }
}
