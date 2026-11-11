/*
 * TEMA 08 · Ejercicio 04 · Matriz de ventas  (dificultad: 4/5)
 *
 * Objetivo: analizar una matriz por filas y por columnas.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej08_04_MatrizDeVentas.java
 */
public class Ej08_04_MatrizDeVentas {

    public static void main(String[] args) {

        // NO TOCAR: los datos. ventas[vendedor][mes]
        String[] vendedores = {"Ana", "Luis", "Marta", "Jorge"};
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun"};
        int[][] ventas = {
                {12, 15,  9, 20, 18, 22},
                { 8, 11, 14,  9, 13, 10},
                {20, 18, 25, 17, 21, 24},
                {10,  9, 12, 15,  8, 14}
        };

        // TODO 1: crea los arrays totalVendedor (uno por fila) y totalMes (uno por columna)
        //         y la variable totalGeneral.

        // TODO 2: recorre la matriz (bucles anidados) rellenando los totales
        //         y buscando la mejor venta individual (filaMax, columnaMax).

        // TODO 3: muestra la tabla: cabecera, una fila por vendedor con su total
        //         y la fila TOTAL.

        // TODO 4: busca el mejor vendedor en totalVendedor y el mejor mes en totalMes.

        // TODO 5: muestra los tres resultados finales.
    }
}
