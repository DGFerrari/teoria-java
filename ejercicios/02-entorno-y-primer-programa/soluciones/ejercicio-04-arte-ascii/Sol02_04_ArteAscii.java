/*
 * TEMA 02 · Ejercicio 04 · Arte ASCII  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol02_04_ArteAscii.java
 */
public class Sol02_04_ArteAscii {

    public static void main(String[] args) {

        // Parte A · Cada \ se escribe \\ y cada " se escribe \"
        System.out.println("Parte A");
        System.out.println(" /\\_/\\");
        System.out.println("( o.o )");
        System.out.println(" > ^ <");
        System.out.println("  \"Miau\"");

        System.out.println();

        // Parte B · Bloque de texto. Las barras invertidas siguen escapándose.
        // La sangría que se elimina la marca la línea con las """ de cierre.
        System.out.println("Parte B");
        System.out.println("""
                    /\\
                   /  \\
                  /____\\
                  | [] |
                  |____|
                """);

        // Parte C · print no salta de línea; el println final sí.
        System.out.println("Parte C");
        System.out.print("|-");
        System.out.print("|-");
        System.out.print("|-");
        System.out.print("|-");
        System.out.print("|-");
        System.out.print("|-");
        System.out.println("|");
    }
}
