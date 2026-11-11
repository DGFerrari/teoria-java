/*
 * TEMA 02 · Entorno y primer programa
 * Ejemplo 05: TIPOS DE ERRORES
 *
 * Este programa funciona. Los errores están COMENTADOS para que puedas
 * descomentarlos uno a uno, ver qué pasa y volver a comentarlos.
 *
 * Cómo ejecutarlo:  java T02_05_TiposDeErrores.java
 */
public class T02_05_TiposDeErrores {

    public static void main(String[] args) {

        // ============================================================
        // 1. ERRORES DE COMPILACIÓN
        //    El programa NI SIQUIERA llega a ejecutarse.
        //    El compilador te dice el archivo, la línea y qué esperaba.
        // ============================================================

        // a) Falta el punto y coma   →  error: ';' expected
        // System.out.println("Hola")

        // b) Nombre mal escrito      →  error: cannot find symbol
        // system.out.println("Hola");
        // System.out.printn("Hola");

        // c) Comillas sin cerrar     →  error: unclosed string literal
        // System.out.println("Hola);

        // d) Si borras la llave } del final del main o de la clase
        //                            →  error: reached end of file while parsing

        System.out.println("1. Sin errores de compilación");

        // ============================================================
        // 2. ERRORES DE EJECUCIÓN
        //    El programa compila y empieza a ejecutarse, pero se detiene
        //    de golpe ("peta") al llegar a la instrucción problemática.
        // ============================================================

        // Dividir un número entero entre 0 no tiene sentido.
        // Descomenta esta línea: verás que el mensaje "2." de abajo NUNCA se muestra.
        //   Exception in thread "main" java.lang.ArithmeticException: / by zero
        // System.out.println(10 / 0);

        System.out.println("2. Sin errores de ejecución");

        // ============================================================
        // 3. ERRORES LÓGICOS
        //    El programa funciona y no da ningún aviso,
        //    pero el resultado es INCORRECTO. Son los más difíciles de encontrar.
        // ============================================================

        // Queremos la media de 4 y 6, que es 5.
        System.out.println("Media (mal):  " + (4 + 6 / 2));    // 7  ← ¡Mal! Divide antes de sumar
        System.out.println("Media (bien): " + ((4 + 6) / 2));  // 5  ← Los paréntesis lo arreglan

        // Para encontrar errores lógicos: haz la traza (tema 01) y PRUEBA con
        // datos cuyo resultado ya conoces.

        System.out.println("3. Fin del programa");
    }
}
