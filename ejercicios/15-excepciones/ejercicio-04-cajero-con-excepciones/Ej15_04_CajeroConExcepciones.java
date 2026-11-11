/*
 * TEMA 15 · Ejercicio 04 · Cajero con excepciones  (dificultad: 4/5)
 *
 * Objetivo: crear excepciones propias (checked y unchecked), lanzarlas con throw,
 *           declararlas con throws y tratarlas en el main.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej15_04_CajeroConExcepciones.java
 */
public class Ej15_04_CajeroConExcepciones {

    // TODO 1: excepción CHECKED. Guarda "faltan" (double) y crea el mensaje
    //         "Saldo insuficiente: faltan 250,00 €" con String.format. Añade getFaltan()
    static class SaldoInsuficienteException extends Exception {
    }

    // TODO 2: excepción CHECKED. Guarda "intentosRestantes" (int); mensaje
    //         "PIN incorrecto. Intentos restantes: 2". Añade getIntentosRestantes()
    static class PinIncorrectoException extends Exception {
    }

    // TODO 3: excepción UNCHECKED con un constructor que reciba el mensaje
    static class TarjetaBloqueadaException extends RuntimeException {
    }

    static class Tarjeta {
        private static final int MAX_INTENTOS = 3;

        private final String pin;
        private double saldo;
        private int intentosFallidos;
        private boolean bloqueada;

        public Tarjeta(String pin, double saldo) {
            this.pin = pin;
            this.saldo = saldo;
        }

        // TODO 4: añade "throws" con las excepciones checked e implementa las reglas:
        //   1) Si está bloqueada → TarjetaBloqueadaException("Tarjeta bloqueada")
        //   2) Si el PIN no coincide → suma un fallo; al 3º se bloquea y lanza
        //      TarjetaBloqueadaException("Tarjeta bloqueada por demasiados intentos fallidos");
        //      si no, PinIncorrectoException con los intentos que quedan
        //   3) PIN correcto → reinicia los fallos
        //   4) Si la cantidad supera el saldo → SaldoInsuficienteException(cantidad - saldo)
        //   5) Si todo va bien, descuenta la cantidad
        public void retirar(String pinIntroducido, double cantidad) {
        }

        public double getSaldo() {
            return saldo;
        }

        public boolean isBloqueada() {
            return bloqueada;
        }
    }

    public static void main(String[] args) {
        // NO TOCAR: los datos
        Tarjeta tarjeta = new Tarjeta("1234", 300);
        String[] operaciones = {
            "1234;50", "1234;500", "0000;20", "1234;abc",
            "1111;10", "2222;10", "3333;10", "1234;10"
        };
        int procesadas = 0;
        int correctas = 0;

        // TODO 5: para cada operación muestra "Op N [PIN xxxx, cantidad] " y, dentro de un try:
        //         convierte la cantidad, llama a retirar y muestra el resultado.
        //         Un catch por cada tipo de error (mira la salida esperada) y un finally
        //         que cuente las operaciones procesadas.

        // TODO 6: resumen final
    }
}
