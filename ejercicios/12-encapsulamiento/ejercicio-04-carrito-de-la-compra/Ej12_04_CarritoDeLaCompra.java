/*
 * TEMA 12 · Ejercicio 04 · Carrito de la compra  (dificultad: 4/5)
 *
 * Objetivo: un objeto inmutable y otro que protege sus arrays internos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej12_04_CarritoDeLaCompra.java
 *
 * Regla: sin break ni continue, y sin return dentro de los bucles.
 */
public class Ej12_04_CarritoDeLaCompra {

    static final class Producto {

        // TODO 1: atributos private final, constructor y getters

        public Producto(String nombre, double precio) {
        }

        public String getNombre() {
            return "";
        }

        public double getPrecio() {
            return 0;
        }

        // TODO 2: devuelve un producto NUEVO con el descuento aplicado
        public Producto conDescuento(int porcentaje) {
            return this;
        }
    }

    static class Carrito {

        // TODO 3: constante MAX_LINEAS, arrays privados, numLineas y porcentaje del cupón

        // TODO 4
        public boolean agregar(Producto producto, int cantidad) {
            return false;
        }

        public boolean eliminar(String nombre) {
            return false;
        }

        public int getNumeroLineas() {
            return 0;
        }

        public double getSubtotal() {
            return 0;
        }

        public boolean aplicarCupon(String codigo) {
            return false;
        }

        public double getTotal() {
            return 0;
        }

        // TODO 5: copia con solo las líneas ocupadas
        public Producto[] getProductos() {
            return new Producto[0];
        }

        // TODO 6: métodos privados de ayuda
        private int buscarLinea(String nombre) {
            return -1;
        }

        private int porcentajeDeCupon(String codigo) {
            return 0;
        }
    }

    // NO TOCAR
    public static void main(String[] args) {
        Producto teclado = new Producto("Teclado", 25.0);
        Producto raton = new Producto("Ratón", 12.5);
        Producto alfombrilla = new Producto("Alfombrilla", 8.0);

        Producto oferta = teclado.conDescuento(20);
        System.out.printf("Oferta: %s a %.2f € (el original sigue a %.2f €)%n",
                oferta.getNombre(), oferta.getPrecio(), teclado.getPrecio());

        Carrito carrito = new Carrito();
        carrito.agregar(teclado, 1);
        carrito.agregar(raton, 2);
        carrito.agregar(alfombrilla, 1);
        carrito.agregar(raton, 1);              // Misma línea: ahora 3 ratones
        carrito.agregar(raton, -4);             // Rechazado

        System.out.println("Artículos distintos: " + carrito.getNumeroLineas());
        System.out.printf("Subtotal: %.2f €%n", carrito.getSubtotal());
        System.out.println("¿Cupón FALSO? " + carrito.aplicarCupon("FALSO"));
        System.out.println("¿Cupón AHORRA10? " + carrito.aplicarCupon("AHORRA10"));
        System.out.println("¿Cupón VERANO25? " + carrito.aplicarCupon("VERANO25"));
        System.out.printf("Total: %.2f €%n", carrito.getTotal());

        carrito.eliminar("alfombrilla");
        System.out.printf("Tras eliminar la alfombrilla → Subtotal: %.2f € | Total: %.2f €%n",
                carrito.getSubtotal(), carrito.getTotal());

        Producto[] copia = carrito.getProductos();
        if (copia.length > 0) {
            copia[0] = null;                    // Modificamos la copia...
        }
        System.out.println("Copia modificada desde fuera. Artículos en el carrito: " + carrito.getNumeroLineas());
    }
}
