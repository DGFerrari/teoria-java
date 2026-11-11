/*
 * TEMA 15 · Excepciones
 * Ejemplo 02: VARIOS catch, MULTI-CATCH Y finally
 *
 * Cómo ejecutarlo:  java T15_02_TryCatchFinally.java
 */
public class T15_02_TryCatchFinally {

    static final int[] DATOS = {10, 5, 0, 8};

    // Intenta dividir 100 entre el elemento de la posición indicada (que llega como texto)
    static void dividirEntre(String textoPosicion) {
        System.out.println("Posición \"" + textoPosicion + "\":");
        try {
            int posicion = Integer.parseInt(textoPosicion);     // Puede: NumberFormatException
            int divisor = DATOS[posicion];                      // Puede: ArrayIndexOutOfBoundsException
            System.out.println("  100 / " + divisor + " = " + (100 / divisor));   // Puede: ArithmeticException
        } catch (NumberFormatException e) {
            System.out.println("  ✘ No es un número");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  ✘ Esa posición no existe (hay " + DATOS.length + ")");
        } catch (ArithmeticException e) {
            System.out.println("  ✘ En esa posición hay un 0");
        } finally {
            System.out.println("  (finally: se ejecuta SIEMPRE)");
        }
    }

    // Multi-catch: varios tipos tratados igual
    static int leerPosicion(String texto) {
        int resultado;
        try {
            resultado = DATOS[Integer.parseInt(texto)];
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("  Valor no válido (" + e.getClass().getSimpleName() + "), se usa -1");
            resultado = -1;
        }
        return resultado;
    }

    // finally se ejecuta incluso con return dentro del try
    static String conReturn() {
        try {
            return "valor devuelto desde el try";
        } finally {
            System.out.println("  finally antes de salir del método");
        }
    }

    public static void main(String[] args) {

        dividirEntre("1");       // Todo bien
        dividirEntre("2");       // División entre 0
        dividirEntre("7");       // Fuera del array
        dividirEntre("dos");     // No es un número
        System.out.println();

        System.out.println("Multi-catch:");
        System.out.println("  leerPosicion(\"3\") = " + leerPosicion("3"));
        System.out.println("  leerPosicion(\"x\") = " + leerPosicion("x"));
        System.out.println("  leerPosicion(\"9\") = " + leerPosicion("9"));
        System.out.println();

        System.out.println("finally con return:");
        System.out.println("  " + conReturn());
        System.out.println();

        // ------------------------------------------------------------
        // El orden de los catch: de lo concreto a lo general
        // ------------------------------------------------------------
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {             // Concreto primero...
            System.out.println("Capturada como NumberFormatException");
        } catch (IllegalArgumentException e) {          // ...general después (es su superclase)
            System.out.println("Capturada como IllegalArgumentException");
        }
        // Al revés no compila: "exception NumberFormatException has already been caught"
    }
}
