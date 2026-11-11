/*
 * TEMA 10 · Métodos
 * Ejemplo 04: SOBRECARGA Y DOCUMENTACIÓN JAVADOC
 *
 * Cómo ejecutarlo:  java T10_04_Sobrecarga.java
 */
public class T10_04_Sobrecarga {

    /**
     * Suma dos enteros.
     *
     * @param a primer sumando
     * @param b segundo sumando
     * @return la suma de a y b
     */
    static int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Suma tres enteros (mismo nombre, distinto NÚMERO de parámetros).
     *
     * @param a primer sumando
     * @param b segundo sumando
     * @param c tercer sumando
     * @return la suma de los tres
     */
    static int sumar(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * Suma dos decimales (mismo nombre, distinto TIPO de parámetros).
     *
     * @param a primer sumando
     * @param b segundo sumando
     * @return la suma de a y b
     */
    static double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Suma todos los elementos de un array.
     *
     * @param numeros los números a sumar
     * @return la suma de todos ellos (0 si el array está vacío)
     */
    static int sumar(int[] numeros) {
        int total = 0;
        for (int n : numeros) {
            total += n;
        }
        return total;
    }

    // ------------------------------------------------------------
    // Sobrecarga práctica: valores "por defecto"
    // ------------------------------------------------------------

    /**
     * Muestra una línea con el símbolo y la longitud indicados.
     *
     * @param simbolo  carácter con el que se dibuja la línea
     * @param longitud número de caracteres
     */
    static void linea(char simbolo, int longitud) {
        System.out.println(String.valueOf(simbolo).repeat(longitud));
    }

    /**
     * Muestra una línea de 30 guiones. Reutiliza la versión completa.
     */
    static void linea() {
        linea('-', 30);
    }

    /**
     * Muestra una línea de 30 caracteres con el símbolo indicado.
     *
     * @param simbolo carácter con el que se dibuja la línea
     */
    static void linea(char simbolo) {
        linea(simbolo, 30);
    }

    // ❌ Esto NO sería sobrecarga válida: solo cambia el tipo de retorno
    // static double sumar(int a, int b) { return a + b; }
    //   error: method sumar(int,int) is already defined

    public static void main(String[] args) {

        // Java elige la versión según los argumentos
        System.out.println("sumar(2, 3)        = " + sumar(2, 3));             // int, int
        System.out.println("sumar(2, 3, 4)     = " + sumar(2, 3, 4));          // int, int, int
        System.out.println("sumar(2.5, 1.25)   = " + sumar(2.5, 1.25));        // double, double
        System.out.println("sumar({1,2,3,4})   = " + sumar(new int[]{1, 2, 3, 4}));   // int[]

        // Con un int y un double, Java convierte el int a double y usa la versión double
        System.out.println("sumar(2, 0.5)      = " + sumar(2, 0.5));
        System.out.println();

        linea();              // 30 guiones
        linea('=');           // 30 iguales
        linea('*', 10);       // 10 asteriscos

        // Ya conocías la sobrecarga: println tiene una versión para cada tipo
        System.out.println(42);
        System.out.println(3.14);
        System.out.println('J');
        System.out.println(true);

        // PRUEBA: pasa el ratón por encima de una llamada a sumar en tu editor:
        //    verás la documentación Javadoc de esa versión concreta.
    }
}
