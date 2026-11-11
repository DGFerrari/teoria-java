/*
 * TEMA 10 · Ejercicio 02 · Utilidades de texto  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol10_02_UtilidadesDeTexto.java
 */
public class Sol10_02_UtilidadesDeTexto {

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
        if (texto.isEmpty()) {
            return texto;                    // Sin esta comprobación, substring(0, 1) fallaría
        } else {
            return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
        }
    }

    /** Devuelve cuántas vocales (con o sin tilde) tiene el texto. */
    static int contarVocales(String texto) {
        final String VOCALES = "aeiouáéíóúü";
        int vocales = 0;
        for (char c : texto.toLowerCase().toCharArray()) {
            if (VOCALES.indexOf(c) != -1) {
                vocales++;
            }
        }
        return vocales;
    }

    /** Devuelve el texto al revés. */
    static String invertir(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }

    /** ¿Se lee igual al revés, ignorando mayúsculas y espacios? Reutiliza invertir(). */
    static boolean esPalindromo(String texto) {
        String preparado = texto.toLowerCase().replace(" ", "");
        return preparado.equals(invertir(preparado));
    }

    /**
     * Repite un texto varias veces, poniendo un separador entre cada repetición.
     *
     * @param texto     el texto que se repite
     * @param veces     cuántas veces se repite
     * @param separador lo que se pone entre una repetición y la siguiente
     * @return el texto repetido, por ejemplo ("ja", 3, "-") → "ja-ja-ja"
     */
    static String repetir(String texto, int veces, String separador) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            if (i > 0) {
                resultado.append(separador);     // Separador antes de cada repetición salvo la primera
            }
            resultado.append(texto);
        }
        return resultado.toString();
    }
}
