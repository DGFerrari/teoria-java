/*
 * TEMA 18 · Ejercicio 05 · Gestor de pedidos  (dificultad: 5/5)
 *
 * Objetivo: combinar un enum como máquina de estados, records validados,
 *           una interfaz sealed con records y switch con patrones de registro.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej18_05_GestorDePedidos.java
 */
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Ej18_05_GestorDePedidos {

    enum EstadoPedido {
        PENDIENTE, PAGADO, ENVIADO, ENTREGADO, CANCELADO;

        // TODO 1: con un switch (this) exhaustivo, ¿se puede pasar de este estado a "nuevo"?
        boolean puedePasarA(EstadoPedido nuevo) {
            return false;
        }
    }

    record LineaPedido(String producto, double precioUnitario, int cantidad) {
        // TODO 2: constructor compacto que rechace (IllegalArgumentException) un producto vacío,
        //         un precio <= 0 ("Precio no válido: X") o una cantidad <= 0 ("Cantidad no válida: X")

        // TODO 3: precio × cantidad
        double subtotal() {
            return 0;
        }
    }

    // NO TOCAR: los tres tipos de descuento
    sealed interface Descuento permits Porcentaje, Fijo, TresPorDos { }

    record Porcentaje(double porcentaje) implements Descuento { }

    record Fijo(double euros) implements Descuento { }

    record TresPorDos(String producto) implements Descuento { }

    // TODO 4: switch con patrones de registro (incluido case null → 0):
    //         Porcentaje → subtotal × porcentaje / 100 · Fijo → como mucho el subtotal ·
    //         TresPorDos → una unidad gratis de cada tres del producto indicado
    static double calcularDescuento(Descuento descuento, List<LineaPedido> lineas, double subtotal) {
        return 0;
    }

    // TODO 5: "sin descuento", "10 % de descuento", "10,00 € de descuento" o "3x2 en Camiseta"
    static String describir(Descuento descuento) {
        return "";
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
            this.lineas = List.copyOf(lineas);
            this.descuento = descuento;
        }

        // TODO 6: si no se puede pasar al nuevo estado,
        //         IllegalStateException("No se puede pasar de PENDIENTE a ENVIADO")
        void cambiarEstado(EstadoPedido nuevo) {
        }

        // TODO 7: subtotal (suma de las líneas) y total (subtotal - descuento)
        double subtotal() {
            return 0;
        }

        double total() {
            return 0;
        }

        int getId() {
            return id;
        }

        EstadoPedido getEstado() {
            return estado;
        }

        // TODO 8: muestra el pedido como en la salida esperada
        void mostrar() {
        }
    }

    // NO TOCAR
    static void intentar(Pedido pedido, EstadoPedido nuevo) {
        try {
            pedido.cambiarEstado(nuevo);
            System.out.println("  #" + pedido.getId() + " → " + nuevo);
        } catch (IllegalStateException e) {
            System.out.println("  #" + pedido.getId() + " ✘ " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // NO TOCAR: los pedidos y los cambios de estado
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

        // TODO 9: cuenta los pedidos de cada estado en un EnumMap (con todos los estados a 0 al principio)
        //         y suma el total de los pedidos que no estén cancelados
        System.out.println("=== Resumen ===");
    }
}
