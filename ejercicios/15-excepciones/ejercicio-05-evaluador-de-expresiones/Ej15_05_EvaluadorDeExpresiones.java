import java.util.Scanner;

/*
 * TEMA 15 · Ejercicio 05 · Evaluador de expresiones  (dificultad: 5/5)
 *
 * Objetivo: combinar todo el tema: excepción propia con causa, traducir excepciones,
 *           multi-catch, switch que lanza excepciones y try-with-resources con dos recursos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej15_05_EvaluadorDeExpresiones.java
 */
public class Ej15_05_EvaluadorDeExpresiones {

    // TODO 1: excepción CHECKED con un campo "linea" (int), getLinea() y DOS constructores:
    //         (String mensaje, int linea) y (String mensaje, int linea, Throwable causa)
    static class ExpresionInvalidaException extends Exception {
    }

    // TODO 2: haz que implemente AutoCloseable. close() debe mostrar:
    //         "[Informe] Correctas: 4 | Errores: 4 | Suma de resultados: 1019.5"
    static class Informe {
        private int correctas;
        private int errores;
        private double suma;

        public void anotarCorrecta(double resultado) {
            correctas++;
            suma += resultado;
        }

        public void anotarError() {
            errores++;
        }
    }

    // TODO 3: switch moderno con + - * / ^
    //         "/" con divisor 0 → ArithmeticException("División por cero")
    //         operador desconocido → IllegalArgumentException("Operador desconocido: %")
    static double operar(double a, String operador, double b) {
        return 0;
    }

    // TODO 4: añade "throws" y traduce cada problema a ExpresionInvalidaException:
    //         - si no hay 3 partes → "Se esperaban 3 elementos y hay N" (sin causa)
    //         - NumberFormatException → "Número no válido" (con causa)
    //         - ArithmeticException o IllegalArgumentException de operar → "Error al operar" (con causa)
    static double evaluar(String expresion, int linea) {
        return 0;
    }

    // NO TOCAR: 1024.0 → "1024"   ·   2.5 → "2.5"
    static String formatear(double valor) {
        String texto;
        if (valor == Math.floor(valor) && !Double.isInfinite(valor)) {
            texto = String.valueOf((long) valor);
        } else {
            texto = String.valueOf(valor);
        }
        return texto;
    }

    public static void main(String[] args) {
        // NO TOCAR: los datos
        String expresiones = """
                3 + 4
                10 / 4
                7 * -2
                2 ^ 10
                8 / 0
                cinco + 2
                4 % 3
                9 - 3 - 1
                """;

        // TODO 5: try-with-resources con un Scanner sobre "expresiones" y un Informe.
        //         Lee línea a línea, evalúa cada una dentro de su propio try y muestra
        //         el resultado o el error (con su causa, si la tiene). Mira la salida esperada.
    }
}
