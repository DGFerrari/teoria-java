/*
 * TEMA 03 · Variables y tipos de datos
 * Ejemplo 02: LOS 8 TIPOS PRIMITIVOS
 *
 * Cómo ejecutarlo:  java T03_02_TiposPrimitivos.java
 */
public class T03_02_TiposPrimitivos {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Enteros: byte, short, int, long
        // ------------------------------------------------------------
        byte temperaturaMinima = -20;            // -128 a 127
        short alturaMontania = 3_718;            // -32768 a 32767 (el _ solo ayuda a leer)
        int habitantesCiudad = 800_000;          // El entero "por defecto"
        long habitantesMundo = 8_100_000_000L;   // La L indica que el literal es long

        System.out.println("=== Enteros ===");
        System.out.println("byte:  " + temperaturaMinima);
        System.out.println("short: " + alturaMontania);
        System.out.println("int:   " + habitantesCiudad);
        System.out.println("long:  " + habitantesMundo);

        // Límites de cada tipo (constantes de las clases envoltorio)
        System.out.println("int va de " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE);
        System.out.println("long va de " + Long.MIN_VALUE + " a " + Long.MAX_VALUE);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Decimales: float y double
        // ------------------------------------------------------------
        float pesoFloat = 72.5f;                 // La f es obligatoria en float
        double pi = 3.141592653589793;           // El decimal "por defecto"

        System.out.println("=== Decimales ===");
        System.out.println("float:  " + pesoFloat);
        System.out.println("double: " + pi);

        // float tiene menos precisión que double
        float tercioFloat = 1.0f / 3;
        double tercioDouble = 1.0 / 3;
        System.out.println("1/3 en float:  " + tercioFloat);    // 0.33333334
        System.out.println("1/3 en double: " + tercioDouble);   // 0.3333333333333333
        System.out.println();

        // ------------------------------------------------------------
        // 3. char y boolean
        // ------------------------------------------------------------
        char inicial = 'J';                      // Comillas SIMPLES, un solo carácter
        char simbolo = '€';
        boolean tieneCarnet = true;              // Solo true o false, sin comillas
        boolean esFinDeSemana = false;

        System.out.println("=== char y boolean ===");
        System.out.println("char:    " + inicial + " y " + simbolo);
        System.out.println("boolean: " + tieneCarnet + " y " + esFinDeSemana);
        System.out.println();

        // ------------------------------------------------------------
        // 4. Otros literales
        // ------------------------------------------------------------
        int hexadecimal = 0xFF;                  // 255 en base 16
        int binario = 0b1010;                    // 10 en base 2
        double notacionCientifica = 1.5e3;       // 1.5 × 10³ = 1500.0

        System.out.println("=== Otros literales ===");
        System.out.println("0xFF   = " + hexadecimal);
        System.out.println("0b1010 = " + binario);
        System.out.println("1.5e3  = " + notacionCientifica);

        // PRUEBA: intenta guardar 200 en un byte (byte b = 200;). ¿Qué dice el compilador?
    }
}
