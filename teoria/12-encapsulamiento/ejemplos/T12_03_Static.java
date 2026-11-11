/*
 * TEMA 12 · Encapsulamiento
 * Ejemplo 03: MIEMBROS static (de la clase) FRENTE A MIEMBROS DE INSTANCIA (de cada objeto)
 *
 * Cómo ejecutarlo:  java T12_03_Static.java
 */
public class T12_03_Static {

    static class Pedido {

        // static: UNA sola copia compartida por todos los pedidos
        public static final double IVA = 0.21;           // Constante compartida
        private static int pedidosCreados = 0;           // Contador común
        private static double facturacionTotal = 0;

        // De instancia: cada pedido tiene los suyos
        private final int numero;                         // Identificador único y automático
        private final String cliente;
        private final double importeSinIva;

        public Pedido(String cliente, double importeSinIva) {
            pedidosCreados++;                             // Modifica el contador COMÚN
            this.numero = pedidosCreados;                 // Cada pedido se queda con su número
            this.cliente = cliente;
            this.importeSinIva = importeSinIva;
            facturacionTotal += getImporteConIva();
        }

        // Método de instancia: usa los datos de ESTE pedido
        public double getImporteConIva() {
            return importeSinIva * (1 + IVA);
        }

        // Métodos static: no dependen de ningún pedido concreto
        public static int getPedidosCreados() {
            return pedidosCreados;
        }

        public static double getFacturacionTotal() {
            return facturacionTotal;
        }

        public static String formatearEuros(double cantidad) {   // Método de utilidad
            return String.format("%,.2f €", cantidad);
        }

        // ❌ Un método static NO puede usar atributos de instancia ni this:
        // public static String getCliente() { return cliente; }
        //   error: non-static variable cliente cannot be referenced from a static context

        @Override
        public String toString() {
            return "Pedido #" + numero + " de " + cliente + ": " + formatearEuros(getImporteConIva());
        }
    }

    // Un contador SIN static: no funciona como se espera
    static class ContadorMal {
        private int creados = 0;                          // Cada objeto tiene el suyo

        public ContadorMal() {
            creados++;
        }

        public int getCreados() {
            return creados;
        }
    }

    public static void main(String[] args) {

        // Los miembros static se usan con el NOMBRE DE LA CLASE (sin crear objetos)
        System.out.println("IVA aplicado: " + Math.round(Pedido.IVA * 100) + "%");
        System.out.println("Pedidos antes de empezar: " + Pedido.getPedidosCreados());
        System.out.println();

        Pedido p1 = new Pedido("Ana", 100);
        Pedido p2 = new Pedido("Luis", 250.5);
        Pedido p3 = new Pedido("Marta", 49.99);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println();

        System.out.println("Pedidos creados: " + Pedido.getPedidosCreados());       // 3
        System.out.println("Facturación total: " + Pedido.formatearEuros(Pedido.getFacturacionTotal()));
        System.out.println();

        // Sin static, cada objeto cuenta solo "su" creación
        ContadorMal a = new ContadorMal();
        ContadorMal b = new ContadorMal();
        ContadorMal c = new ContadorMal();
        System.out.println("ContadorMal: " + a.getCreados() + ", " + b.getCreados() + ", " + c.getCreados()
                + "   ← siempre 1: el atributo no es compartido");

        // Ya conocías muchos miembros static de Java:
        System.out.println("Math.PI = " + Math.PI + " | Integer.MAX_VALUE = " + Integer.MAX_VALUE);

        // PRUEBA: añade a Pedido un método static "getImporteMedio()" que devuelva
        //    facturacionTotal / pedidosCreados (cuidado si no hay pedidos).
    }
}
