/*
 * TEMA 03 · Variables y tipos de datos
 * Ejemplo 05: CONVERSIONES, CASTING, DESBORDAMIENTO E IMPRECISIÓN
 *
 * Cómo ejecutarlo:  java T03_05_Conversiones.java
 */
public class T03_05_Conversiones {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Conversión implícita (de pequeño a grande): automática
        // ------------------------------------------------------------
        int entero = 42;
        long enteroLargo = entero;     // int → long
        double decimal = entero;       // int → double (42.0)
        System.out.println("int: " + entero + " | long: " + enteroLargo + " | double: " + decimal);

        // ------------------------------------------------------------
        // 2. Casting (de grande a pequeño): hay que pedirlo
        // ------------------------------------------------------------
        double nota = 7.9;
        int notaCortada = (int) nota;          // 7  → CORTA los decimales
        long notaRedondeada = Math.round(nota); // 8  → redondea
        System.out.println("Nota: " + nota + " | (int): " + notaCortada + " | Math.round: " + notaRedondeada);

        double negativo = -3.7;
        System.out.println("(int) -3.7 = " + (int) negativo);   // -3 (corta hacia el cero)
        System.out.println();

        // ------------------------------------------------------------
        // 3. Mezclar tipos: el resultado es del tipo más grande
        // ------------------------------------------------------------
        int a = 7;
        int b = 2;
        System.out.println("7 / 2 (int / int)           = " + (a / b));             // 3
        System.out.println("7 / 2.0 (int / double)      = " + (a / 2.0));           // 3.5
        System.out.println("(double) 7 / 2              = " + ((double) a / b));    // 3.5
        System.out.println("(double) (7 / 2)            = " + ((double) (a / b)));  // 3.0 ← ¡ya se perdió!
        System.out.println();

        // ------------------------------------------------------------
        // 4. De texto a número y de número a texto
        // ------------------------------------------------------------
        String textoEdad = "15";
        String textoPrecio = "9.99";

        System.out.println("\"15\" + 1 como texto:  " + (textoEdad + 1));          // 151
        int edad = Integer.parseInt(textoEdad);
        double precio = Double.parseDouble(textoPrecio);
        System.out.println("15 + 1 como número:     " + (edad + 1));               // 16
        System.out.println("9.99 * 2 como número:   " + (precio * 2));             // 19.98

        String deVuelta = String.valueOf(edad);
        System.out.println("Número convertido a texto: " + deVuelta + " (longitud " + deVuelta.length() + ")");

        // Integer.parseInt("quince");   // ❌ Error de ejecución: NumberFormatException
        System.out.println();

        // ------------------------------------------------------------
        // 5. Desbordamiento: el número "da la vuelta"
        // ------------------------------------------------------------
        int maximo = Integer.MAX_VALUE;
        System.out.println("Máximo int:     " + maximo);
        System.out.println("Máximo int + 1: " + (maximo + 1));   // -2147483648

        long malo = 1_000_000 * 1_000_000;     // Se calcula en int → desborda
        long bueno = 1_000_000L * 1_000_000;   // Se calcula en long → correcto
        System.out.println("Sin L: " + malo + " | Con L: " + bueno);

        long grande = 3_000_000_000L;
        System.out.println("(int) 3000000000L = " + (int) grande);   // Número sin sentido
        System.out.println();

        // ------------------------------------------------------------
        // 6. Imprecisión de los decimales
        // ------------------------------------------------------------
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));   // 0.30000000000000004
        System.out.println("1.0 - 0.9 = " + (1.0 - 0.9));   // 0.09999999999999998

        // PRUEBA: ¿cuántos segundos tiene un siglo? Calcúlalo con int y con long.
    }
}
