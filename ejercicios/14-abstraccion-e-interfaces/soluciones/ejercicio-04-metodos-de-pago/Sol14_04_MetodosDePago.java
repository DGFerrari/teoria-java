/*
 * TEMA 14 · Ejercicio 04 · Métodos de pago  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol14_04_MetodosDePago.java
 */
public class Sol14_04_MetodosDePago {

    // El CONTRATO que cumple cualquier forma de pago
    interface MetodoPago {
        String getNombre();

        double calcularComision(double importe);

        boolean puedePagar(double importe);

        boolean pagar(double importe);

        default double costeTotal(double importe) {
            return importe + calcularComision(importe);
        }

        // Utilidad: el método más barato de los que pueden pagar (null si ninguno)
        static MetodoPago elMasBarato(MetodoPago[] metodos, double importe) {
            MetodoPago elegido = null;
            for (MetodoPago m : metodos) {
                if (m.puedePagar(importe)
                        && (elegido == null || m.calcularComision(importe) < elegido.calcularComision(importe))) {
                    elegido = m;
                }
            }
            return elegido;
        }
    }

    // Implementación directa de la interfaz: crédito con límite
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
            return importe * 0.015;
        }

        @Override
        public boolean puedePagar(double importe) {
            return importe > 0 && gastado + costeTotal(importe) <= limite;
        }

        @Override
        public boolean pagar(double importe) {
            boolean posible = puedePagar(importe);
            if (posible) {
                gastado += costeTotal(importe);
            }
            return posible;
        }

        @Override
        public String toString() {
            return String.format("%s: gastado %.2f € de %.2f €", nombre, gastado, limite);
        }
    }

    // Clase abstracta: implementa la parte COMÚN de los métodos con saldo
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

        // Por defecto no hay límite por operación; las subclases pueden cambiarlo
        protected double limitePorOperacion() {
            return Double.MAX_VALUE;
        }

        @Override
        public boolean puedePagar(double importe) {
            return importe > 0 && importe <= limitePorOperacion() && costeTotal(importe) <= saldo;
        }

        @Override
        public boolean pagar(double importe) {
            boolean posible = puedePagar(importe);
            if (posible) {
                saldo -= costeTotal(importe);
            }
            return posible;
        }

        @Override
        public String toString() {
            return String.format("%s: saldo %.2f €", nombre, saldo);
        }
    }

    // Las concretas solo escriben lo que las distingue
    static class PayPal extends PagoConSaldo {
        PayPal(double saldo) {
            super("PayPal", saldo);
        }

        @Override
        public double calcularComision(double importe) {
            return importe * 0.034 + 0.35;
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

        @Override
        protected double limitePorOperacion() {
            return 1000;
        }
    }

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
