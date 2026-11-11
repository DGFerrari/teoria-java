/*
 * TEMA 02 · Entorno y primer programa
 * Ejemplo 01: ANATOMÍA DE UN PROGRAMA
 *
 * Cómo ejecutarlo:
 *   - En un paso:   java T02_01_HolaMundo.java
 *   - En dos pasos: javac T02_01_HolaMundo.java   (crea T02_01_HolaMundo.class)
 *                   java T02_01_HolaMundo         (sin extensión)
 */

// "public class T02_01_HolaMundo"
//   - class: definimos una clase. En Java todo el código vive dentro de clases.
//   - El nombre de la clase pública DEBE coincidir con el nombre del archivo.
//   - La llave { abre el bloque de la clase. Se cierra en la última línea.
public class T02_01_HolaMundo {

    // "public static void main(String[] args)"
    //   Es el PUNTO DE ENTRADA. La JVM busca exactamente esta línea
    //   y empieza a ejecutar por la primera instrucción que hay dentro.
    public static void main(String[] args) {

        // Una instrucción: mostrar un texto en la consola.
        //   System     → una clase de Java con utilidades del sistema
        //   out        → la salida estándar (la consola)
        //   println    → "print line": escribe y salta de línea
        //   "..."      → el texto (String) va entre comillas dobles
        //   ;          → toda instrucción termina en punto y coma
        System.out.println("¡Hola, mundo!");

        System.out.println("Este es mi primer programa en Java.");

        // Las instrucciones se ejecutan en orden, de arriba abajo (secuencia, tema 01)
        System.out.println("Y esta es la última línea.");

    } // ← fin del main: aquí termina el programa

} // ← fin de la clase

// PRUEBA (y deshaz el cambio después de cada una):
//   1. Cambia "System" por "system". ¿Qué error da?
//   2. Borra un ";". ¿En qué línea dice el error?
//   3. Cambia el nombre de la clase a "Hola". ¿Qué pasa al ejecutar?
