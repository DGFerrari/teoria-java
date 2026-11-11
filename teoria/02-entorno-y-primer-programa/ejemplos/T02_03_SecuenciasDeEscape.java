/*
 * TEMA 02 · Entorno y primer programa
 * Ejemplo 03: SECUENCIAS DE ESCAPE Y BLOQUES DE TEXTO
 *
 * Una secuencia de escape es una barra invertida \ seguida de un carácter.
 * Sirve para escribir caracteres "especiales" dentro de un texto.
 *
 * Cómo ejecutarlo:  java T02_03_SecuenciasDeEscape.java
 */
public class T02_03_SecuenciasDeEscape {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // \n  → salto de línea
        // ------------------------------------------------------------
        System.out.println("Línea 1\nLínea 2\nLínea 3");
        System.out.println();

        // ------------------------------------------------------------
        // \t  → tabulación (alinea en columnas)
        // ------------------------------------------------------------
        System.out.println("Producto\tPrecio");
        System.out.println("Pan\t\t1.20");     // Dos \t porque "Pan" es corto
        System.out.println("Leche\t\t0.95");
        System.out.println("Chocolate\t2.50");
        System.out.println();

        // ------------------------------------------------------------
        // \"  → comillas dobles DENTRO del texto
        // ------------------------------------------------------------
        // Sin la barra, Java pensaría que el texto termina en la segunda comilla.
        System.out.println("El profesor dijo: \"Mañana hay examen\"");
        System.out.println();

        // ------------------------------------------------------------
        // \\  → una barra invertida
        // ------------------------------------------------------------
        // Típico en rutas de Windows
        System.out.println("Mis archivos están en C:\\Usuarios\\Ana\\Documentos");
        System.out.println();

        // ------------------------------------------------------------
        // Bloques de texto (Java 15+): entre tres comillas """
        // ------------------------------------------------------------
        // Se respetan los saltos de línea y no hace falta escapar las comillas.
        // La sangría común a todas las líneas se elimina automáticamente.
        System.out.println("""
                +----------------------+
                |   MENÚ DEL DÍA       |
                +----------------------+
                | 1. Sopa "de la casa" |
                | 2. Pescado al horno  |
                | 3. Flan              |
                +----------------------+
                """);

        // PRUEBA: con un solo println y usando \n y \t, muestra:
        //    Nombre:    (tu nombre)
        //    Ciudad:    (tu ciudad)
    }
}
