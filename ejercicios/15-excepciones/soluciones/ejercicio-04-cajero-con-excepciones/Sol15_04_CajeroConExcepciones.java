/*
 * TEMA 15 · Ejercicio 04 · Cajero con excepciones  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol15_04_CajeroConExcepciones.java
 */
public class Sol15_04_CajeroConExcepciones {

    // CHECKED (extiende Exception): es un caso previsible del negocio,
    // así que el compilador OBLIGA a quien llama a tratarlo o declararlo
    static class SaldoInsuficienteException extends Exception {
        private final double faltan;

        public SaldoInsuficienteException(double faltan) {
            super(String.format("Saldo insuficiente: faltan %.2f €", faltan));
            this.faltan = faltan;
        }

        public double getFaltan() {
            return faltan;
        }
    }

    // CHECKED: también previsible (el usuario se equivoca de PIN)
    static class PinIncorrectoException extends Exception {
        private final int intentosRestantes;

        public PinIncorrectoException(int intentosRestantes) {
            super("PIN incorrecto. Intentos restantes: " + intentosRestantes);
            this.intentosRestantes = intentosRestantes;
        }

        public int getIntentosRestantes() {
            return intentosRestantes;
        }
    }

    // UNCHECKED (extiende RuntimeException): no hace falta declararla con throws
    static class TarjetaBloqueadaException extends RuntimeException {
        public TarjetaBloqueadaException(String mensaje) {
            super(mensaje);
        }
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

        // El throws avisa de las checked. TarjetaBloqueadaException no hace falta declararla
        public void retirar(String pinIntroducido, double cantidad)
                throws PinIncorrectoException, SaldoInsuficienteException {
            if (bloqueada) {
                throw new TarjetaBloqueadaException("Tarjeta bloqueada");
            }
            if (!pin.equals(pinIntroducido)) {
                intentosFallidos++;
                if (intentosFallidos >= MAX_INTENTOS) {
                    bloqueada = true;
                    throw new TarjetaBloqueadaException("Tarjeta bloqueada por demasiados intentos fallidos");
                }
                throw new PinIncorrectoException(MAX_INTENTOS - intentosFallidos);
            }
            intentosFallidos = 0;                       // PIN correcto: se reinicia el contador
            if (cantidad > saldo) {
                throw new SaldoInsuficienteException(cantidad - saldo);
            }
            saldo -= cantidad;                          // Solo llega aquí si todo está bien
        }

        public double getSaldo() {
            return saldo;
        }

        public boolean isBloqueada() {
            return bloqueada;
        }
    }

    public static void main(String[] args) {
        Tarjeta tarjeta = new Tarjeta("1234", 300);
        String[] operaciones = {
            "1234;50", "1234;500", "0000;20", "1234;abc",
            "1111;10", "2222;10", "3333;10", "1234;10"
        };
        int procesadas = 0;
        int correctas = 0;

        for (int i = 0; i < operaciones.length; i++) {
            String[] partes = operaciones[i].split(";");
            String pin = partes[0];
            String textoCantidad = partes[1];
            System.out.print("Op " + (i + 1) + " [PIN " + pin + ", " + textoCantidad + "] ");
            try {
                double cantidad = Double.parseDouble(textoCantidad);   // Puede: NumberFormatException
                tarjeta.retirar(pin, cantidad);                        // Puede: las tres nuestras
                System.out.printf("✔ Retirados %.2f €. Saldo: %.2f €%n", cantidad, tarjeta.getSaldo());
                correctas++;
            } catch (NumberFormatException e) {
                System.out.println("✘ Cantidad no válida: " + textoCantidad);
            } catch (PinIncorrectoException e) {
                System.out.println("✘ " + e.getMessage());
                if (e.getIntentosRestantes() == 1) {
                    System.out.println("   ⚠ Último intento antes del bloqueo");
                }
            } catch (SaldoInsuficienteException e) {
                System.out.printf("✘ %s. Máximo disponible: %.2f €%n", e.getMessage(), tarjeta.getSaldo());
            } catch (TarjetaBloqueadaException e) {
                System.out.println("⛔ " + e.getMessage());
            } finally {
                procesadas++;                           // Se ejecuta SIEMPRE, haya error o no
            }
        }

        System.out.println("=== Operaciones procesadas: " + procesadas + " | Correctas: " + correctas + " ===");
        System.out.printf("Saldo final: %.2f € | Tarjeta bloqueada: %s%n",
                tarjeta.getSaldo(), tarjeta.isBloqueada() ? "sí" : "no");
    }
}
