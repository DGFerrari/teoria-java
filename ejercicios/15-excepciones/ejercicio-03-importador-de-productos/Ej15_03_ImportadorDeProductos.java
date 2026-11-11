/*
 * TEMA 15 · Ejercicio 03 · Importador de productos  (dificultad: 3/5)
 *
 * Objetivo: validar con throw y tratar los errores de cada línea sin detener la importación.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej15_03_ImportadorDeProductos.java
 */
public class Ej15_03_ImportadorDeProductos {

    static class Producto {
        private final String codigo;
        private final String nombre;
        private final double precio;
        private final int stock;

        // TODO 1: valida cada dato y lanza IllegalArgumentException si no es correcto
        public Producto(String codigo, String nombre, double precio, int stock) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        // TODO 2: divide la línea, comprueba que haya 4 campos, convierte y crea el producto
        public static Producto desdeLinea(String linea) {
            return null;
        }

        public double getValor() {
            return precio * stock;
        }

        @Override
        public String toString() {
            return String.format("%s %-18s %6.2f € x %2d", codigo, nombre, precio, stock);
        }
    }

    public static void main(String[] args) {
        // NO TOCAR: los datos
        String datos = """
                P-001;Teclado mecánico;59.90;12
                P-002;Ratón;19.5;30
                P-03;Monitor;189;4
                P-004;;9.99;10
                P-005;Cable HDMI;-3;50
                P-006;Webcam;cuarenta;7
                P-007;Alfombrilla;8.75
                P-008;Hub USB;24.99;-2
                P-009;Altavoces;45;6
                """;
        String[] lineas = datos.strip().split("\n");
        Producto[] importados = new Producto[lineas.length];
        int numImportados = 0;
        int errores = 0;

        // TODO 3: recorre las líneas; importa cada una dentro de un try y muestra los errores
        //         como "Línea N ✘ mensaje". Cuidado con el orden de los catch.

        // TODO 4: resumen (importados, errores, lista y valor total del inventario)
    }
}
