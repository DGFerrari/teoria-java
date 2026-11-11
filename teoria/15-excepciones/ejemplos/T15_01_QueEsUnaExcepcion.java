/*
 * TEMA 15 · Excepciones
 * Ejemplo 01: ¿QUÉ ES UNA EXCEPCIÓN? (las más comunes, capturadas)
 *
 * Cada bloque provoca un error a propósito y lo captura para que el programa siga.
 *
 * Cómo ejecutarlo:  java T15_01_QueEsUnaExcepcion.java
 */
public class T15_01_QueEsUnaExcepcion {

    public static void main(String[] args) {

        System.out.println("=== Excepciones habituales ===");

        // 1. División entera entre 0
        try {
            int divisor = 0;
            System.out.println(10 / divisor);
        } catch (ArithmeticException e) {
            mostrar(e);
        }

        // 2. Texto que no es un número
        try {
            int numero = Integer.parseInt("doce");
            System.out.println(numero);
        } catch (NumberFormatException e) {
            mostrar(e);
        }

        // 3. Índice fuera de un array
        try {
            int[] datos = {1, 2, 3};
            System.out.println(datos[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            mostrar(e);
        }

        // 4. Índice fuera de un texto
        try {
            System.out.println("Hola".charAt(10));
        } catch (StringIndexOutOfBoundsException e) {
            mostrar(e);
        }

        // 5. Usar null
        try {
            String texto = null;
            System.out.println(texto.length());
        } catch (NullPointerException e) {
            mostrar(e);
        }

        // 6. Casting incorrecto
        try {
            Object algo = "soy un texto";
            Integer numero = (Integer) algo;
            System.out.println(numero);
        } catch (ClassCastException e) {
            mostrar(e);
        }
        System.out.println();

        // ------------------------------------------------------------
        // Lo que NO se ejecuta: el resto del try tras el error
        // ------------------------------------------------------------
        System.out.println("=== El try se abandona en el punto del error ===");
        try {
            System.out.println("  Paso 1: antes del error");
            int[] vacio = new int[0];
            System.out.println("  Paso 2: " + vacio[0]);       // 💥
            System.out.println("  Paso 3: esto NO se muestra");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  catch: se ha saltado directamente aquí");
        }
        System.out.println("  El programa continúa con normalidad");
        System.out.println();

        // ------------------------------------------------------------
        // La traza completa (útil para depurar)
        // ------------------------------------------------------------
        System.out.println("=== Traza de error (printStackTrace) ===");
        try {
            metodoQueFalla();
        } catch (IllegalStateException e) {
            e.printStackTrace(System.out);   // Muestra la cadena de llamadas: metodoQueFalla ← main
        }

        // PRUEBA: quita el try-catch del bloque 2 y ejecuta. Verás cómo el programa
        //    se detiene y Java muestra la traza en rojo.
    }

    static void mostrar(Exception e) {
        System.out.println("  " + e.getClass().getSimpleName() + " → " + e.getMessage());
    }

    static void metodoQueFalla() {
        throw new IllegalStateException("algo ha ido mal dentro de metodoQueFalla");
    }
}
