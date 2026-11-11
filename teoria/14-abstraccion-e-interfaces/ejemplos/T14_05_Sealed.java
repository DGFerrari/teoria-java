/*
 * TEMA 14 · Abstracción e interfaces
 * Ejemplo 05: JERARQUÍAS sealed Y switch EXHAUSTIVO
 *
 * Cómo ejecutarlo:  java T14_05_Sealed.java
 */
public class T14_05_Sealed {

    // ------------------------------------------------------------
    // Solo Tarjeta, Transferencia y Efectivo pueden implementar Pago
    // ------------------------------------------------------------
    sealed interface Pago permits Tarjeta, Transferencia, Efectivo {
        double importe();
    }

    static final class Tarjeta implements Pago {       // final: nadie hereda de ella
        private final double importe;
        private final String ultimosDigitos;

        Tarjeta(double importe, String ultimosDigitos) {
            this.importe = importe;
            this.ultimosDigitos = ultimosDigitos;
        }

        @Override
        public double importe() {
            return importe;
        }

        String ultimosDigitos() {
            return ultimosDigitos;
        }
    }

    static final class Transferencia implements Pago {
        private final double importe;
        private final String iban;

        Transferencia(double importe, String iban) {
            this.importe = importe;
            this.iban = iban;
        }

        @Override
        public double importe() {
            return importe;
        }

        String iban() {
            return iban;
        }
    }

    static final class Efectivo implements Pago {
        private final double importe;
        private final double entregado;

        Efectivo(double importe, double entregado) {
            this.importe = importe;
            this.entregado = entregado;
        }

        @Override
        public double importe() {
            return importe;
        }

        double cambio() {
            return entregado - importe;
        }
    }

    // static final class Cheque implements Pago { ... }
    // ❌ Error: class is not allowed to extend sealed class: Pago (no está en permits)

    // ------------------------------------------------------------
    // switch con patrones SIN default: el compilador conoce TODOS los casos
    // ------------------------------------------------------------
    static String describir(Pago pago) {
        return switch (pago) {
            case Tarjeta t -> String.format("💳 Tarjeta ****%s: %.2f €", t.ultimosDigitos(), t.importe());
            case Transferencia tr -> String.format("🏦 Transferencia desde %s: %.2f €", tr.iban(), tr.importe());
            case Efectivo e -> String.format("💶 Efectivo: %.2f € (cambio: %.2f €)", e.importe(), e.cambio());
        };
        // Si mañana se añade un cuarto tipo a "permits", este switch dejará de compilar
        // hasta que se trate el caso nuevo. Así ningún caso se queda olvidado.
    }

    static double comision(Pago pago) {
        return switch (pago) {
            case Tarjeta t -> t.importe() * 0.015;
            case Transferencia tr -> 0.50;
            case Efectivo e -> 0;
        };
    }

    public static void main(String[] args) {
        Pago[] pagos = {
                new Tarjeta(59.90, "4821"),
                new Efectivo(12.30, 20),
                new Transferencia(250, "ES91 2100 0418 4502 0005 1332")
        };

        double totalComisiones = 0;
        for (Pago p : pagos) {
            System.out.println(describir(p));
            totalComisiones += comision(p);
        }
        System.out.printf("Comisiones totales: %.2f €%n", totalComisiones);

        // En el tema 18 verás los record, que reducen estas clases a una sola línea cada una.
    }
}
