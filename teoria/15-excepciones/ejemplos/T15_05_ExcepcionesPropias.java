/*
 * TEMA 15 · Excepciones
 * Ejemplo 05: EXCEPCIONES PROPIAS
 *
 * Cómo ejecutarlo:  java T15_05_ExcepcionesPropias.java
 */
public class T15_05_ExcepcionesPropias {

    // ------------------------------------------------------------
    // Checked (extends Exception): situación normal del negocio que
    // quien llama DEBE tratar
    // ------------------------------------------------------------
    static class SaldoInsuficienteException extends Exception {
        private final double faltan;

        public SaldoInsuficienteException(double saldo, double pedido) {
            super(String.format("Saldo insuficiente: tienes %.2f € y pides %.2f €", saldo, pedido));
            this.faltan = pedido - saldo;
        }

        public double getFaltan() {               // Información extra para quien la captura
            return faltan;
        }
    }

    // ------------------------------------------------------------
    // Unchecked (extends RuntimeException): uso incorrecto que el
    // programador debería haber evitado
    // ------------------------------------------------------------
    static class CuentaBloqueadaException extends RuntimeException {
        public CuentaBloqueadaException(String titular) {
            super("La cuenta de " + titular + " está bloqueada");
        }
    }

    static class Cuenta {
        private final String titular;
        private double saldo;
        private boolean bloqueada = false;

        Cuenta(String titular, double saldo) {
            this.titular = titular;
            this.saldo = saldo;
        }

        // La checked aparece en la cabecera: quien llame está avisado
        public void retirar(double cantidad) throws SaldoInsuficienteException {
            if (bloqueada) {
                throw new CuentaBloqueadaException(titular);      // Unchecked: no hace falta declararla
            }
            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser positiva: " + cantidad);
            }
            if (cantidad > saldo) {
                throw new SaldoInsuficienteException(saldo, cantidad);
            }
            saldo -= cantidad;
        }

        public void bloquear() {
            bloqueada = true;
        }

        public double getSaldo() {
            return saldo;
        }
    }

    static void intentarRetirar(Cuenta cuenta, double cantidad) {
        System.out.printf("Retirar %.2f € → ", cantidad);
        try {
            cuenta.retirar(cantidad);
            System.out.printf("OK. Saldo: %.2f €%n", cuenta.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.printf("✘ %s (faltan %.2f €)%n", e.getMessage(), e.getFaltan());
        } catch (IllegalArgumentException | CuentaBloqueadaException e) {
            System.out.println("✘ " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Ana", 200);

        intentarRetirar(cuenta, 50);
        intentarRetirar(cuenta, 500);
        intentarRetirar(cuenta, -10);
        cuenta.bloquear();
        intentarRetirar(cuenta, 20);

        // cuenta.retirar(10);
        // ❌ No compila fuera de un try: unreported exception SaldoInsuficienteException;
        //    must be caught or declared to be thrown
    }
}
