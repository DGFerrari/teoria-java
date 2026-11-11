/*
 * TEMA 12 · Ejercicio 04 · Carrito de la compra  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol12_04_CarritoDeLaCompra.java
 */
import java.util.Arrays;

public class Sol12_04_CarritoDeLaCompra {

    // Inmutable: private final, sin setters y "modificaciones" que devuelven objetos nuevos
    static final class Producto {

        private final String nombre;
        private final double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public Producto conDescuento(int porcentaje) {
            return new Producto(nombre, precio * (100 - porcentaje) / 100);
        }
    }

    // Encapsulado: cambia, pero solo con reglas
    static class Carrito {

        public static final int MAX_LINEAS = 10;

        private final Producto[] productos = new Producto[MAX_LINEAS];
        private final int[] cantidades = new int[MAX_LINEAS];
        private int numLineas = 0;
        private int porcentajeCupon = 0;          // 0 = sin cupón

        public boolean agregar(Producto producto, int cantidad) {
            boolean posible = cantidad > 0;
            if (posible) {
                int linea = buscarLinea(producto.getNombre());
                if (linea != -1) {
                    cantidades[linea] += cantidad;   // Ya estaba: sumamos
                } else if (numLineas < MAX_LINEAS) {
                    productos[numLineas] = producto;
                    cantidades[numLineas] = cantidad;
                    numLineas++;
                } else {
                    posible = false;                 // Carrito lleno
                }
            }
            return posible;
        }

        public boolean eliminar(String nombre) {
            int linea = buscarLinea(nombre);
            if (linea != -1) {
                for (int i = linea; i < numLineas - 1; i++) {
                    productos[i] = productos[i + 1];
                    cantidades[i] = cantidades[i + 1];
                }
                productos[numLineas - 1] = null;
                cantidades[numLineas - 1] = 0;
                numLineas--;
            }
            return linea != -1;
        }

        public int getNumeroLineas() {
            return numLineas;
        }

        public double getSubtotal() {
            double subtotal = 0;
            for (int i = 0; i < numLineas; i++) {
                subtotal += productos[i].getPrecio() * cantidades[i];
            }
            return subtotal;
        }

        public boolean aplicarCupon(String codigo) {
            int porcentaje = porcentajeDeCupon(codigo);
            boolean aplicado = porcentajeCupon == 0 && porcentaje > 0;   // Solo un cupón
            if (aplicado) {
                porcentajeCupon = porcentaje;
            }
            return aplicado;
        }

        public double getTotal() {
            return getSubtotal() * (100 - porcentajeCupon) / 100;
        }

        public Producto[] getProductos() {
            return Arrays.copyOf(productos, numLineas);   // Copia defensiva, sin huecos
        }

        // --- Ayuda interna ---
        private int buscarLinea(String nombre) {
            int posicion = -1;
            int i = 0;
            while (i < numLineas && posicion == -1) {
                if (productos[i].getNombre().equalsIgnoreCase(nombre)) {
                    posicion = i;
                }
                i++;
            }
            return posicion;
        }

        private int porcentajeDeCupon(String codigo) {
            return switch (codigo) {
                case "AHORRA10" -> 10;
                case "VERANO25" -> 25;
                default -> 0;
            };
        }
    }

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
        carrito.agregar(raton, 1);
        carrito.agregar(raton, -4);

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
            copia[0] = null;
        }
        System.out.println("Copia modificada desde fuera. Artículos en el carrito: " + carrito.getNumeroLineas());
    }
}
