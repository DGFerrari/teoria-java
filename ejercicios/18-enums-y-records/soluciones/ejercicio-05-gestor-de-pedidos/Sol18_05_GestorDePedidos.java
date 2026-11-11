/*
 * TEMA 18 · Ejercicio 05 · Gestor de pedidos  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol18_05_GestorDePedidos.java
 */
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Sol18_05_GestorDePedidos {

    // Una máquina de estados: cada estado sabe a cuáles puede pasar
    enum EstadoPedido {
        PENDIENTE, PAGADO, ENVIADO, ENTREGADO, CANCELADO;

        boolean puedePasarA(EstadoPedido nuevo) {
            return switch (this) {
                case PENDIENTE -> nuevo == PAGADO || nuevo == CANCELADO;
                case PAGADO -> nuevo == ENVIADO || nuevo == CANCELADO;
                case ENVIADO -> nuevo == ENTREGADO;
                case ENTREGADO, CANCELADO -> false;          // Estados finales
            };
        }
    }

    record LineaPedido(String producto, double precioUnitario, int cantidad) {
        LineaPedido {
            if (producto == null || producto.isBlank()) {
                throw new IllegalArgumentException("Falta el nombre del producto");
            }
            if (precioUnitario <= 0) {
                throw new IllegalArgumentException("Precio no válido: " + precioUnitario);
            }
            if (cantidad <= 0) {
                throw new IllegalArgumentException("Cantidad no válida: " + cantidad);
            }
        }

        double subtotal() {
            return precioUnitario * cantidad;
        }
    }

    // Solo existen estos tres tipos de descuento, cada uno con sus propios datos
    sealed interface Descuento permits Porcentaje, Fijo, TresPorDos { }

    record Porcentaje(double porcentaje) implements Descuento { }

    record Fijo(double euros) implements Descuento { }

    record TresPorDos(String producto) implements Descuento { }

    // switch con patrones de registro: desmonta cada descuento en sus datos
    static double calcularDescuento(Descuento descuento, List<LineaPedido> lineas, double subtotal) {
        return switch (descuento) {
            case null -> 0;
            case Porcentaje(double porcentaje) -> subtotal * porcentaje / 100;
            case Fijo(double euros) -> Math.min(euros, subtotal);           // Nunca más que el subtotal
            case TresPorDos(String producto) -> {
                double ahorro = 0;
                for (LineaPedido linea : lineas) {
                    if (linea.producto().equals(producto)) {
                        ahorro += (linea.cantidad() / 3) * linea.precioUnitario();   // Uno gratis de cada tres
                    }
                }
                yield ahorro;
            }
        };
    }

    static String describir(Descuento descuento) {
        return switch (descuento) {
            case null -> "sin descuento";
            case Porcentaje(double porcentaje) -> String.format("%.0f %% de descuento", porcentaje);
            case Fijo(double euros) -> String.format("%.2f € de descuento", euros);
            case TresPorDos(String producto) -> "3x2 en " + producto;
        };
    }

    static class Pedido {
        private static int siguienteId = 1;

        private final int id;
        private final List<LineaPedido> lineas;
        private final Descuento descuento;           // Puede ser null
        private EstadoPedido estado = EstadoPedido.PENDIENTE;

        Pedido(List<LineaPedido> lineas, Descuento descuento) {
            this.id = siguienteId;
            siguienteId++;
            this.lineas = List.copyOf(lineas);        // Copia inmutable
            this.descuento = descuento;
        }

        void cambiarEstado(EstadoPedido nuevo) {
            if (!estado.puedePasarA(nuevo)) {
                throw new IllegalStateException("No se puede pasar de " + estado + " a " + nuevo);
            }
            estado = nuevo;
        }

        double subtotal() {
            double suma = 0;
            for (LineaPedido linea : lineas) {
                suma += linea.subtotal();
            }
            return suma;
        }

        double total() {
            return subtotal() - calcularDescuento(descuento, lineas, subtotal());
        }

        int getId() {
            return id;
        }

        EstadoPedido getEstado() {
            return estado;
        }

        void mostrar() {
            System.out.println("Pedido #" + id + " [" + estado + "]");
            for (LineaPedido linea : lineas) {
                System.out.printf("  %d × %-10s %6.2f € = %6.2f €%n",
                        linea.cantidad(), linea.producto(), linea.precioUnitario(), linea.subtotal());
            }
            String parteDescuento = describir(descuento);
            if (descuento != null) {
                parteDescuento += String.format(": -%.2f €", calcularDescuento(descuento, lineas, subtotal()));
            }
            System.out.printf("  Subtotal: %.2f € · %s · Total: %.2f €%n", subtotal(), parteDescuento, total());
        }
    }

    static void intentar(Pedido pedido, EstadoPedido nuevo) {
        try {
            pedido.cambiarEstado(nuevo);
            System.out.println("  #" + pedido.getId() + " → " + nuevo);
        } catch (IllegalStateException e) {
            System.out.println("  #" + pedido.getId() + " ✘ " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Pedido p1 = new Pedido(List.of(
                new LineaPedido("Camiseta", 15.0, 3),
                new LineaPedido("Gorra", 9.5, 1)), new TresPorDos("Camiseta"));
        Pedido p2 = new Pedido(List.of(new LineaPedido("Libro", 20.0, 2)), new Porcentaje(10));
        Pedido p3 = new Pedido(List.of(new LineaPedido("Taza", 6.0, 1)), new Fijo(10));
        Pedido p4 = new Pedido(List.of(new LineaPedido("Cuaderno", 2.5, 4)), null);
        List<Pedido> pedidos = List.of(p1, p2, p3, p4);

        for (Pedido p : pedidos) {
            p.mostrar();
        }
        try {
            new LineaPedido("Lápiz", 0.5, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("✘ Línea rechazada: " + e.getMessage());
        }

        System.out.println("=== Cambios de estado ===");
        intentar(p1, EstadoPedido.PAGADO);
        intentar(p1, EstadoPedido.ENVIADO);
        intentar(p1, EstadoPedido.ENTREGADO);
        intentar(p2, EstadoPedido.ENVIADO);
        intentar(p2, EstadoPedido.CANCELADO);
        intentar(p2, EstadoPedido.PAGADO);
        intentar(p3, EstadoPedido.PAGADO);

        System.out.println("=== Resumen ===");
        Map<EstadoPedido, Integer> porEstado = new EnumMap<>(EstadoPedido.class);
        for (EstadoPedido e : EstadoPedido.values()) {
            porEstado.put(e, 0);
        }
        double facturado = 0;
        for (Pedido p : pedidos) {
            porEstado.put(p.getEstado(), porEstado.get(p.getEstado()) + 1);
            if (p.getEstado() != EstadoPedido.CANCELADO) {
                facturado += p.total();
            }
        }
        System.out.println("Pedidos por estado: " + porEstado);
        System.out.printf("Facturación (sin cancelados): %.2f €%n", facturado);
    }
}
