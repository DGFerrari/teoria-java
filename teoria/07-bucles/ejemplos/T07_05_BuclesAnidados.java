/*
 * TEMA 07 · Bucles
 * Ejemplo 05: BUCLES ANIDADOS
 *
 * Por cada vuelta del bucle exterior, el interior hace TODAS sus vueltas.
 *
 * Cómo ejecutarlo:  java T07_05_BuclesAnidados.java
 */
public class T07_05_BuclesAnidados {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Rectángulo: filas × columnas
        // ------------------------------------------------------------
        int filas = 3;
        int columnas = 5;
        for (int fila = 1; fila <= filas; fila++) {
            for (int columna = 1; columna <= columnas; columna++) {
                System.out.print("# ");
            }
            System.out.println();          // Al terminar cada fila, saltamos de línea
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. Ver el orden de ejecución
        // ------------------------------------------------------------
        for (int exterior = 1; exterior <= 2; exterior++) {
            for (int interior = 1; interior <= 3; interior++) {
                System.out.print("(" + exterior + "," + interior + ") ");
            }
            System.out.println();
        }
        // (1,1) (1,2) (1,3)   ← el interior completa sus 3 vueltas
        // (2,1) (2,2) (2,3)   ← y vuelve a empezar en la siguiente vuelta del exterior
        System.out.println();

        // ------------------------------------------------------------
        // 3. El interior depende del exterior: triángulo
        // ------------------------------------------------------------
        int altura = 5;
        for (int fila = 1; fila <= altura; fila++) {
            for (int i = 1; i <= fila; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // Pirámide centrada: primero espacios, luego asteriscos
        for (int fila = 1; fila <= altura; fila++) {
            for (int i = 1; i <= altura - fila; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= 2 * fila - 1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // ------------------------------------------------------------
        // 4. Tabla de multiplicar completa
        // ------------------------------------------------------------
        System.out.print("    ");
        for (int columna = 1; columna <= 9; columna++) {
            System.out.printf("%4d", columna);
        }
        System.out.println();
        System.out.println("    " + "-".repeat(36));

        for (int fila = 1; fila <= 9; fila++) {
            System.out.printf("%2d |", fila);
            for (int columna = 1; columna <= 9; columna++) {
                System.out.printf("%4d", fila * columna);
            }
            System.out.println();
        }

        // PRUEBA: dibuja un tablero de ajedrez de 8x8 alternando "#" y "."
        //    Pista: (fila + columna) % 2 == 0
    }
}
