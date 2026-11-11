/*
 * TEMA 18 · Ejercicio 02 · Tienda de camisetas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol18_02_TiendaDeCamisetas.java
 */
public class Sol18_02_TiendaDeCamisetas {

    static final double PRECIO_BASE = 12.0;

    enum Talla {
        S(92, 0.0),
        M(100, 0.0),
        L(108, 1.5),
        XL(116, 3.0);

        private final int pechoMaximo;          // cm
        private final double recargo;           // €

        Talla(int pechoMaximo, double recargo) {
            this.pechoMaximo = pechoMaximo;
            this.recargo = recargo;
        }

        int getPechoMaximo() {
            return pechoMaximo;
        }

        double precio() {
            return PRECIO_BASE + recargo;
        }

        // La primera talla en la que cabe; si no cabe en ninguna, la más grande
        static Talla recomendada(int contornoPecho) {
            Talla[] tallas = values();
            Talla elegida = null;
            for (int i = 0; i < tallas.length && elegida == null; i++) {
                if (contornoPecho <= tallas[i].pechoMaximo) {
                    elegida = tallas[i];
                }
            }
            return elegida == null ? XL : elegida;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Tallas ===");
        for (Talla t : Talla.values()) {
            System.out.printf("%-2s hasta %d cm de pecho · %.2f €%n", t, t.getPechoMaximo(), t.precio());
        }
        System.out.println("Talla recomendada para 97 cm: " + Talla.recomendada(97));
        System.out.println("Talla recomendada para 120 cm: " + Talla.recomendada(120));

        String[] pedido = {"M;2", "xl;1", "XXL;1", "L;tres", "l;3"};
        double total = 0;
        int camisetas = 0;
        System.out.println("=== Pedido ===");
        for (String linea : pedido) {
            String[] partes = linea.split(";");
            try {
                Talla talla = Talla.valueOf(partes[0].toUpperCase());
                int cantidad = Integer.parseInt(partes[1]);
                double importe = cantidad * talla.precio();
                System.out.printf("%d × %-2s = %.2f €%n", cantidad, talla, importe);
                total += importe;
                camisetas += cantidad;
            } catch (NumberFormatException e) {              // Subclase de IllegalArgumentException: va PRIMERO
                System.out.println("✘ \"" + linea + "\": cantidad no válida");
            } catch (IllegalArgumentException e) {           // La lanza valueOf
                System.out.println("✘ \"" + linea + "\": talla desconocida");
            }
        }
        System.out.printf("Total: %.2f € (%d camisetas)%n", total, camisetas);
    }
}
