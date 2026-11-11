/*
 * TEMA 02 · Entorno y primer programa
 * Ejemplo 02: print, println Y UNIR TEXTOS
 *
 * Cómo ejecutarlo:  java T02_02_PrintYPrintln.java
 */
public class T02_02_PrintYPrintln {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. println: escribe y SALTA de línea
        // ------------------------------------------------------------
        System.out.println("Primera línea");
        System.out.println("Segunda línea");

        // println() vacío: solo salta de línea (línea en blanco)
        System.out.println();

        // ------------------------------------------------------------
        // 2. print: escribe y se QUEDA en la misma línea
        // ------------------------------------------------------------
        System.out.print("Uno, ");
        System.out.print("dos, ");
        System.out.print("tres");
        System.out.println();          // Ahora sí saltamos de línea
        // Salida: Uno, dos, tres

        System.out.print("Cargando");
        System.out.print(".");
        System.out.print(".");
        System.out.println(".");       // El último con println para terminar la línea
        // Salida: Cargando...

        System.out.println();

        // ------------------------------------------------------------
        // 3. Unir textos con +  (concatenar)
        // ------------------------------------------------------------
        System.out.println("Hola" + " " + "Ana");     // Hola Ana
        System.out.println("Tengo " + 15 + " años");  // Tengo 15 años

        // ------------------------------------------------------------
        // 4. Cuidado: + suma números o une textos según lo que tenga a los lados
        // ------------------------------------------------------------
        System.out.println(2 + 3);                    // 5   (número + número = suma)
        System.out.println("2 + 3 = " + 2 + 3);       // 2 + 3 = 23  (texto + número = texto)
        System.out.println("2 + 3 = " + (2 + 3));     // 2 + 3 = 5   (los paréntesis van primero)
        System.out.println(2 + 3 + " es el total");   // 5 es el total (de izquierda a derecha:
                                                      //   primero 2+3=5, luego 5 + texto)

        // PRUEBA: escribe tu nombre completo usando tres print (nombre, apellido 1,
        //    apellido 2) y que salga todo en la misma línea con espacios.
    }
}
