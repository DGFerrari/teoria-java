/*
 * TEMA 08 · Arrays y matrices
 * Ejemplo 05: MATRICES (arrays de dos dimensiones)
 *
 * Cómo ejecutarlo:  java T08_05_Matrices.java
 */
import java.util.Arrays;

public class T08_05_Matrices {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Crear una matriz con un tamaño: [filas][columnas]
        // ------------------------------------------------------------
        int[][] vacia = new int[2][3];          // 2 filas, 3 columnas, todo a 0
        System.out.println("Matriz vacía: " + Arrays.deepToString(vacia));

        // ------------------------------------------------------------
        // 2. Crear una matriz con valores: cada fila entre sus llaves
        // ------------------------------------------------------------
        // Notas de 3 alumnos (filas) en 4 asignaturas (columnas)
        int[][] notas = {
                {7, 8, 6, 9},     // Alumno 0
                {5, 9, 7, 6},     // Alumno 1
                {8, 6, 9, 10}     // Alumno 2
        };

        System.out.println("Filas: " + notas.length);              // 3
        System.out.println("Columnas: " + notas[0].length);        // 4
        System.out.println("Nota del alumno 1 en la asignatura 2: " + notas[1][2]);   // 7

        notas[1][0] = 6;                       // Cambiamos un elemento: [fila][columna]
        System.out.println("Tras corregir: " + Arrays.deepToString(notas));
        System.out.println();

        // ------------------------------------------------------------
        // 3. Recorrer con bucles anidados: filas fuera, columnas dentro
        // ------------------------------------------------------------
        System.out.println("=== Tabla de notas ===");
        for (int fila = 0; fila < notas.length; fila++) {
            for (int columna = 0; columna < notas[fila].length; columna++) {
                System.out.printf("%4d", notas[fila][columna]);
            }
            System.out.println();
        }
        System.out.println();

        // ------------------------------------------------------------
        // 4. Suma (y media) de cada FILA → media de cada alumno
        // ------------------------------------------------------------
        for (int fila = 0; fila < notas.length; fila++) {
            int sumaFila = 0;                                  // Se reinicia en cada fila
            for (int columna = 0; columna < notas[fila].length; columna++) {
                sumaFila += notas[fila][columna];
            }
            System.out.printf("Media del alumno %d: %.2f%n", fila, (double) sumaFila / notas[fila].length);
        }
        System.out.println();

        // ------------------------------------------------------------
        // 5. Suma de cada COLUMNA → media de cada asignatura (bucles intercambiados)
        // ------------------------------------------------------------
        for (int columna = 0; columna < notas[0].length; columna++) {
            int sumaColumna = 0;
            for (int fila = 0; fila < notas.length; fila++) {
                sumaColumna += notas[fila][columna];
            }
            System.out.printf("Media de la asignatura %d: %.2f%n", columna, (double) sumaColumna / notas.length);
        }
        System.out.println();

        // ------------------------------------------------------------
        // 6. Matriz cuadrada: diagonal principal (fila == columna)
        // ------------------------------------------------------------
        int[][] cuadrada = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int diagonal = 0;
        int diagonalSecundaria = 0;
        for (int i = 0; i < cuadrada.length; i++) {
            diagonal += cuadrada[i][i];                              // 1 + 5 + 9
            diagonalSecundaria += cuadrada[i][cuadrada.length - 1 - i];   // 3 + 5 + 7
        }
        System.out.println("Diagonal principal: " + diagonal);           // 15
        System.out.println("Diagonal secundaria: " + diagonalSecundaria); // 15
        System.out.println();

        // ------------------------------------------------------------
        // 7. Recorrer con for-each: cada fila es un int[]
        // ------------------------------------------------------------
        System.out.println("Con for-each:");
        for (int[] fila : cuadrada) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println();

        // ------------------------------------------------------------
        // 8. Matriz irregular: filas de distinto tamaño
        // ------------------------------------------------------------
        int[][] triangulo = {
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1}
        };
        for (int fila = 0; fila < triangulo.length; fila++) {
            for (int columna = 0; columna < triangulo[fila].length; columna++) {   // length de CADA fila
                System.out.print(triangulo[fila][columna] + " ");
            }
            System.out.println();
        }

        // PRUEBA: calcula la "traspuesta" de la matriz cuadrada
        //    (lo que era fila pasa a ser columna) y muéstrala.
    }
}
