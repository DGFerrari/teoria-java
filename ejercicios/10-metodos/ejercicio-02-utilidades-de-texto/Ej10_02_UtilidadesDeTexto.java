/*
 * TEMA 10 · Ejercicio 02 · Utilidades de texto  (dificultad: 2/5)
 *
 * Objetivo: escribir una pequeña biblioteca de métodos para trabajar con textos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej10_02_UtilidadesDeTexto.java
 */
public class Ej10_02_UtilidadesDeTexto {

    // NO TOCAR: pruebas de los métodos
    public static void main(String[] args) {
        System.out.println("capitalizar(\"jAVA\") → " + capitalizar("jAVA"));
        System.out.println("capitalizar(\"\") → " + capitalizar(""));
        System.out.println("contarVocales(\"Murciélago\") → " + contarVocales("Murciélago"));
        System.out.println("invertir(\"hola\") → " + invertir("hola"));
        System.out.println("esPalindromo(\"Ana lava lana\") → " + esPalindromo("Ana lava lana"));
        System.out.println("esPalindromo(\"Hola mundo\") → " + esPalindromo("Hola mundo"));
        System.out.println("repetir(\"ja\", 3, \"-\") → " + repetir("ja", 3, "-"));
        System.out.println("repetir(\"eco\", 1, \" \") → " + repetir("eco", 1, " "));
    }

    /** Devuelve el texto con la primera letra en mayúscula y el resto en minúscula. */
    static String capitalizar(String texto) {
        // TODO 1 (cuidado con el texto vacío)
        return texto;
    }

    /** Devuelve cuántas vocales (con o sin tilde) tiene el texto. */
    static int contarVocales(String texto) {
        // TODO 2
        return 0;
    }

    /** Devuelve el texto al revés. */
    static String invertir(String texto) {
        // TODO 3
        return texto;
    }

    /** ¿Se lee igual al revés, ignorando mayúsculas y espacios? Debe usar invertir(). */
    static boolean esPalindromo(String texto) {
        // TODO 4
        return false;
    }

    // TODO 5: escribe aquí el comentario Javadoc de repetir (con @param y @return)
    static String repetir(String texto, int veces, String separador) {
        // TODO 6
        return texto;
    }
}
