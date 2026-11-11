/*
 * TEMA 12 · Encapsulamiento
 * Ejemplo 02: GETTERS, SETTERS Y VALIDACIÓN
 *
 * Recuerda: como CuentaBancaria está DENTRO de la clase principal, Java dejaría al main
 * acceder a sus private. No lo hacemos: desde el main solo usamos los métodos públicos.
 *
 * Cómo ejecutarlo:  java T12_02_GettersYSetters.java
 */
public class T12_02_GettersYSetters {

    static class CuentaBancaria {

        private String titular;
        private double saldo;
        private String pin;
        private boolean bloqueada;

        public CuentaBancaria(String titular, String pin) {
            setTitular(titular);               // El constructor reutiliza las validaciones
            this.saldo = 0;
            this.pin = esPinValido(pin) ? pin : "0000";
            this.bloqueada = false;
        }

        // --- Getters: leer ---
        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }

        public boolean isBloqueada() {         // boolean → is...
            return bloqueada;
        }

        // No hay getPin(): el PIN no se debe poder consultar

        // --- Setter con validación ---
        public void setTitular(String titular) {
            if (titular != null && !titular.isBlank()) {
                this.titular = titular.strip();
            } else {
                System.out.println("  ⚠ Titular no válido; se mantiene el anterior");
            }
        }

        // No hay setSaldo(): el saldo solo cambia con ingresar y retirar

        // --- Operaciones que validan y avisan con un boolean ---
        public boolean ingresar(double cantidad) {
            boolean posible = !bloqueada && cantidad > 0;
            if (posible) {
                saldo += cantidad;
            }
            return posible;
        }

        public boolean retirar(double cantidad, String pinIntroducido) {
            boolean posible = !bloqueada && pin.equals(pinIntroducido) && cantidad > 0 && cantidad <= saldo;
            if (posible) {
                saldo -= cantidad;
            }
            return posible;
        }

        public boolean cambiarPin(String pinActual, String pinNuevo) {
            boolean cambiado = pin.equals(pinActual) && esPinValido(pinNuevo);
            if (cambiado) {
                pin = pinNuevo;
            }
            return cambiado;
        }

        public void bloquear() {
            bloqueada = true;
        }

        // --- Método de ayuda privado ---
        private boolean esPinValido(String p) {
            boolean valido = p != null && p.length() == 4;
            for (int i = 0; i < 4 && valido; i++) {
                valido = Character.isDigit(p.charAt(i));
            }
            return valido;
        }

        @Override
        public String toString() {
            return String.format("%s: %.2f €%s", titular, saldo, bloqueada ? " [BLOQUEADA]" : "");
        }
    }

    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria("  Ana López ", "1234");
        System.out.println(cuenta);

        System.out.println("Ingresar 500: " + cuenta.ingresar(500));
        System.out.println("Ingresar -20: " + cuenta.ingresar(-20));                 // Rechazado
        System.out.println("Retirar 100 con PIN correcto: " + cuenta.retirar(100, "1234"));
        System.out.println("Retirar 100 con PIN incorrecto: " + cuenta.retirar(100, "9999"));
        System.out.println("Retirar 5000: " + cuenta.retirar(5000, "1234"));        // Sin saldo
        System.out.println(cuenta);
        System.out.println();

        System.out.println("Cambiar PIN a \"12a4\": " + cuenta.cambiarPin("1234", "12a4"));   // No válido
        System.out.println("Cambiar PIN a \"4321\": " + cuenta.cambiarPin("1234", "4321"));
        System.out.println("Retirar 50 con el PIN nuevo: " + cuenta.retirar(50, "4321"));
        System.out.println();

        cuenta.setTitular("   ");                                                    // Rechazado
        cuenta.setTitular("Ana López García");
        cuenta.bloquear();
        System.out.println("Ingresar con la cuenta bloqueada: " + cuenta.ingresar(10));
        System.out.println(cuenta);
        System.out.println("¿Bloqueada? " + cuenta.isBloqueada());

        // Sin encapsular, cualquiera podría haber hecho cuenta.saldo = 1000000;
        // Aquí la única forma de cambiar el saldo es ingresar o retirar, y las dos validan.
    }
}
