/*
 * TEMA 11 · Clases y objetos
 * Ejemplo 05: ARRAYS DE OBJETOS
 *
 * Cómo ejecutarlo:  java T11_05_ArraysDeObjetos.java
 */
public class T11_05_ArraysDeObjetos {

    static class Producto {
        String nombre;
        double precio;
        int stock;

        Producto(String nombre, double precio, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        double valorEnAlmacen() {
            return precio * stock;
        }

        boolean estaAgotado() {
            return stock == 0;
        }

        @Override
        public String toString() {
            return String.format("%-12s %7.2f € x %3d", nombre, precio, stock);
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Crear un array de objetos
        // ------------------------------------------------------------
        Producto[] inventario = {
                new Producto("Teclado", 24.90, 12),
                new Producto("Ratón", 12.50, 0),
                new Producto("Monitor", 149.00, 4),
                new Producto("Auriculares", 39.95, 7),
                new Producto("Webcam", 54.00, 0)
        };

        // Un array creado con tamaño empieza con todas sus posiciones a null
        Producto[] vacio = new Producto[3];
        System.out.println("Posición 0 de un array nuevo: " + vacio[0]);   // null
        System.out.println();

        // ------------------------------------------------------------
        // 2. Recorrer y usar los métodos de cada objeto
        // ------------------------------------------------------------
        System.out.println("=== Inventario ===");
        double valorTotal = 0;
        for (Producto p : inventario) {
            System.out.println(p + (p.estaAgotado() ? "  ← AGOTADO" : ""));
            valorTotal += p.valorEnAlmacen();
        }
        System.out.printf("Valor total del almacén: %.2f €%n", valorTotal);
        System.out.println();

        // ------------------------------------------------------------
        // 3. Buscar un objeto por un atributo (con bandera)
        // ------------------------------------------------------------
        String buscado = "monitor";
        Producto encontrado = null;           // null = todavía no lo hemos encontrado
        int i = 0;
        while (i < inventario.length && encontrado == null) {
            if (inventario[i].nombre.equalsIgnoreCase(buscado)) {
                encontrado = inventario[i];
            }
            i++;
        }
        System.out.println(encontrado != null
                ? "Encontrado: " + encontrado
                : "No hay ningún producto llamado " + buscado);

        // ------------------------------------------------------------
        // 4. El más barato que NO esté agotado
        // ------------------------------------------------------------
        Producto masBarato = null;
        for (Producto p : inventario) {
            if (!p.estaAgotado() && (masBarato == null || p.precio < masBarato.precio)) {
                masBarato = p;
            }
        }
        System.out.println("Más barato disponible: " + masBarato.nombre);
        System.out.println();

        // ------------------------------------------------------------
        // 5. Ordenar por precio (burbuja): cada producto se mueve con TODOS sus datos
        // ------------------------------------------------------------
        boolean hayCambios = true;
        while (hayCambios) {
            hayCambios = false;
            for (int j = 0; j < inventario.length - 1; j++) {
                if (inventario[j].precio > inventario[j + 1].precio) {
                    Producto auxiliar = inventario[j];     // Intercambiamos REFERENCIAS
                    inventario[j] = inventario[j + 1];
                    inventario[j + 1] = auxiliar;
                    hayCambios = true;
                }
            }
        }
        System.out.println("=== Ordenado por precio ===");
        for (Producto p : inventario) {
            System.out.println(p);
        }

        // Con arrays paralelos habría que haber intercambiado tres arrays a la vez.
        // En el tema 19 verás una forma mucho más corta de ordenar objetos.

        // PRUEBA: añade un método "reponer(int unidades)" a Producto y repón 10 unidades
        //    de todos los productos agotados.
    }
}
