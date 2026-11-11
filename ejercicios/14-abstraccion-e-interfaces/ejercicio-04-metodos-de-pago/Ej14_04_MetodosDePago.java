/*
 * TEMA 14 · Ejercicio 04 · Métodos de pago  (dificultad: 4/5)
 *
 * Objetivo: combinar una interfaz (el contrato) con una clase abstracta (la parte común).
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej14_04_MetodosDePago.java
 */
public class Ej14_04_MetodosDePago {

    interface MetodoPago {
        String getNombre();

        double calcularComision(double importe);

        boolean puedePagar(double importe);

        boolean pagar(double importe);

        // TODO 1: importe + comisión
        default double costeTotal(double importe) {
            return importe;
        }

        // TODO 2: el método con menor comisión de los que pueden pagar (null si ninguno)
        static MetodoPago elMasBarato(MetodoPago[] metodos, double importe) {
            return null;
        }
    }

    // TODO 3: Tarjeta implementa MetodoPago directamente (límite de crédito, comisión 1,5 %)
    static class Tarjeta implements MetodoPago {
        private final String nombre;
        private final double limite;
        private double gastado = 0;

        Tarjeta(String nombre, double limite) {
            this.nombre = nombre;
            this.limite = limite;
        }

        @Override
        public String getNombre() {
            return nombre;
        }

        @Override
        public double calcularComision(double importe) {
            return 0;
        }

        @Override
        public boolean puedePagar(double importe) {
            return false;
        }

        @Override
        public boolean pagar(double importe) {
            return false;
        }

        @Override
        public String toString() {
            return String.format("%s: gastado %.2f € de %.2f €", nombre, gastado, limite);
        }
    }

    // TODO 4: PagoConSaldo (abstracta) implementa la parte común del contrato.
    //         Completa puedePagar y pagar (usando costeTotal y limitePorOperacion).
    //         Fíjate en que NO implementa calcularComision: cada subclase pone la suya.
    abstract static class PagoConSaldo implements MetodoPago {
        private final String nombre;
        protected double saldo;

        protected PagoConSaldo(String nombre, double saldo) {
            this.nombre = nombre;
            this.saldo = saldo;
        }

        @Override
        public String getNombre() {
            return nombre;
        }

        protected double limitePorOperacion() {
            return Double.MAX_VALUE;
        }

        @Override
        public boolean puedePagar(double importe) {
            return false;
        }

        @Override
        public boolean pagar(double importe) {
            return false;
        }

        @Override
        public String toString() {
            return String.format("%s: saldo %.2f €", nombre, saldo);
        }
    }

    // TODO 5: PayPal (comisión 3,4 % + 0,35 €) y Bizum (sin comisión, máximo 1000 € por operación)
    static class PayPal extends PagoConSaldo {
        PayPal(double saldo) {
            super("PayPal", saldo);
        }

        @Override
        public double calcularComision(double importe) {
            return 0;
        }
    }

    static class Bizum extends PagoConSaldo {
        Bizum(double saldo) {
            super("Bizum", saldo);
        }

        @Override
        public double calcularComision(double importe) {
            return 0;
        }
    }

    // NO TOCAR
    public static void main(String[] args) {
        MetodoPago[] metodos = {new Tarjeta("Visa", 1500), new PayPal(300), new Bizum(500)};
        double[] compras = {49.99, 250, 800, 1200};

        for (double importe : compras) {
            MetodoPago elegido = MetodoPago.elMasBarato(metodos, importe);
            if (elegido != null) {
                double comision = elegido.calcularComision(importe);
                elegido.pagar(importe);
                System.out.printf("Compra de %.2f € → %s (comisión %.2f €)%n", importe, elegido.getNombre(), comision);
            } else {
                System.out.printf("Compra de %.2f € → no hay ningún método de pago disponible%n", importe);
            }
        }

        System.out.println("=== Estado final ===");
        for (MetodoPago m : metodos) {
            System.out.println(m);
        }
    }
}
