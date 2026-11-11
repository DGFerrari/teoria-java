/**
 * TEMA 02 · Entorno y primer programa
 * Ejemplo 04: COMENTARIOS
 *
 * Esto que estás leyendo es un comentario de DOCUMENTACIÓN (Javadoc):
 * empieza por barra y dos asteriscos. Se pone encima de clases y métodos
 * para explicar qué hacen. La herramienta "javadoc" los convierte en páginas web.
 *
 * Cómo ejecutarlo:  java T02_04_Comentarios.java
 *
 * @author Tu nombre
 */
public class T02_04_Comentarios {

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de la línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        // Esto es un comentario de UNA línea. Empieza con dos barras
        // y llega hasta el final de la línea.

        System.out.println("Los comentarios no se ejecutan");  // También pueden ir al final

        /*
         * Esto es un comentario de VARIAS líneas.
         * Empieza con barra-asterisco y termina con asterisco-barra.
         * Los asteriscos del principio de cada línea son solo decoración.
         */

        // ------------------------------------------------------------
        // Desactivar código temporalmente ("comentar" código)
        // ------------------------------------------------------------
        // La siguiente línea NO se ejecuta porque está comentada:
        // System.out.println("Esta línea no aparecerá");

        /*
        System.out.println("Estas tampoco");
        System.out.println("aparecerán");
        */

        System.out.println("Fin del programa");

        // ------------------------------------------------------------
        // Buenos y malos comentarios
        // ------------------------------------------------------------
        // MAL: repite lo que ya dice el código
        //   System.out.println("Hola");   // Muestra Hola
        //
        // BIEN: explica el PORQUÉ o algo que no es evidente
        //   // El cliente pidió que el saludo saliera siempre en mayúsculas
        //   System.out.println("HOLA");

        // PRUEBA: en VS Code o IntelliJ, selecciona varias líneas y pulsa Ctrl + /
        //    para comentarlas y descomentarlas de golpe.
    }
}
