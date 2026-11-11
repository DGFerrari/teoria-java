/*
 * TEMA 05 · Entrada y salida
 * Ejemplo 01: SALIDA CON FORMATO (printf y String.format)
 *
 * Nota: si tu sistema está en español, los decimales de printf saldrán con COMA.
 *
 * Cómo ejecutarlo:  java T05_01_Printf.java
 */
public class T05_01_Printf {

    public static void main(String[] args) {

        String nombre = "Teclado";
        double precio = 24.5;
        int unidades = 3;

        // ------------------------------------------------------------
        // 1. Con + frente a printf
        // ------------------------------------------------------------
        System.out.println("El producto " + nombre + " cuesta " + precio + " euros (" + unidades + " uds.)");
        System.out.printf("El producto %s cuesta %.2f euros (%d uds.)%n", nombre, precio, unidades);
        // Los huecos se rellenan EN ORDEN: %s ← nombre, %.2f ← precio, %d ← unidades
        System.out.println();

        // ------------------------------------------------------------
        // 2. Especificadores básicos
        // ------------------------------------------------------------
        System.out.printf("Entero:            %d%n", 42);
        System.out.printf("Decimal (%%f):      %f%n", Math.PI);        // 6 decimales
        System.out.printf("Decimal (%%.2f):    %.2f%n", Math.PI);      // 2 decimales, redondeado
        System.out.printf("Decimal (%%.0f):    %.0f%n", 2.5);          // Sin decimales (redondea)
        System.out.printf("Texto:             %s%n", "Hola");
        System.out.printf("Carácter:          %c%n", 'J');
        System.out.printf("Boolean:           %b%n", true);
        System.out.printf("Porcentaje:        %d%%%n", 21);            // %% muestra un %
        System.out.printf("Miles:             %,d%n", 1234567);        // Separador de miles
        System.out.println();

        // ------------------------------------------------------------
        // 3. Ancho y alineación (los corchetes son para ver los espacios)
        // ------------------------------------------------------------
        System.out.printf("[%5d]   ancho 5, derecha%n", 42);
        System.out.printf("[%-5d]   ancho 5, izquierda%n", 42);
        System.out.printf("[%05d]   ancho 5, con ceros%n", 42);
        System.out.printf("[%10s]   texto a la derecha%n", "Ana");
        System.out.printf("[%-10s]   texto a la izquierda%n", "Ana");
        System.out.printf("[%8.2f]   decimal, ancho 8, 2 decimales%n", 3.5);
        System.out.println();

        // ------------------------------------------------------------
        // 4. printf NO salta de línea solo
        // ------------------------------------------------------------
        System.out.printf("Sin %%n... ");
        System.out.printf("...todo sale en la misma línea%n");
        System.out.println();

        // ------------------------------------------------------------
        // 5. String.format: mismo formato, pero devuelve un String
        // ------------------------------------------------------------
        String codigo = String.format("F-%04d", 7);
        String resumen = String.format("%s x%d = %.2f", nombre, unidades, precio * unidades);
        System.out.println("Código: " + codigo);       // F-0007
        System.out.println("Resumen: " + resumen);     // Teclado x3 = 73,50

        // Java 15+: el mismo resultado con formatted()
        String otro = "Quedan %d unidades".formatted(unidades);
        System.out.println(otro);

        // ❌ Tipo incorrecto: %d con un double → IllegalFormatConversionException
        // System.out.printf("%d%n", precio);

        // PRUEBA: muestra tu altura con 3 decimales y tu edad con 3 cifras (015).
    }
}
