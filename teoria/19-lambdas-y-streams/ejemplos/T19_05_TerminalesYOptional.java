/*
 * TEMA 19 · Lambdas y streams
 * Ejemplo 05: operaciones terminales y Optional
 *
 * Cómo ejecutarlo:  java T19_05_TerminalesYOptional.java
 */
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class T19_05_TerminalesYOptional {

    record Producto(String nombre, double precio, int stock) { }

    public static void main(String[] args) {
        List<Producto> productos = List.of(
                new Producto("Teclado", 59.90, 12), new Producto("Ratón", 19.50, 30),
                new Producto("Monitor", 189.00, 4), new Producto("Alfombrilla", 8.75, 0),
                new Producto("Webcam", 45.00, 7));

        // ------------------------------------------------------------
        // 1. Contar, sumar y calcular medias
        // ------------------------------------------------------------
        long conStock = productos.stream().filter(p -> p.stock() > 0).count();
        int unidades = productos.stream().mapToInt(Producto::stock).sum();
        double valor = productos.stream().mapToDouble(p -> p.precio() * p.stock()).sum();
        OptionalDouble precioMedio = productos.stream().mapToDouble(Producto::precio).average();
        System.out.println("1. Productos con stock: " + conStock);
        System.out.println("   Unidades totales: " + unidades);
        System.out.printf("   Valor del inventario: %.2f €%n", valor);
        System.out.printf("   Precio medio: %.2f €%n", precioMedio.orElse(0));
        System.out.println();

        // ------------------------------------------------------------
        // 2. anyMatch, allMatch, noneMatch: preguntas de sí o no
        // ------------------------------------------------------------
        System.out.println("2. ¿Alguno agotado? " + productos.stream().anyMatch(p -> p.stock() == 0));
        System.out.println("   ¿Todos cuestan menos de 200 €? " + productos.stream().allMatch(p -> p.precio() < 200));
        System.out.println("   ¿Ninguno es gratis? " + productos.stream().noneMatch(p -> p.precio() == 0));
        System.out.println();

        // ------------------------------------------------------------
        // 3. min, max y findFirst devuelven Optional
        // ------------------------------------------------------------
        Optional<Producto> masCaro = productos.stream().max(Comparator.comparingDouble(Producto::precio));
        Optional<Producto> primeroBarato = productos.stream().filter(p -> p.precio() < 20).findFirst();
        Optional<Producto> deMasDe500 = productos.stream().filter(p -> p.precio() > 500).findFirst();

        masCaro.ifPresent(p -> System.out.println("3. El más caro: " + p.nombre()));
        System.out.println("   Primero de menos de 20 €: " + primeroBarato.map(Producto::nombre).orElse("ninguno"));
        System.out.println("   ¿Hay alguno de más de 500 €? " + deMasDe500.isPresent());
        System.out.println("   Nombre del de más de 500 €: " + deMasDe500.map(Producto::nombre).orElse("ninguno"));
        System.out.println();

        // ------------------------------------------------------------
        // 4. reduce: combinar todos los elementos en uno
        // ------------------------------------------------------------
        int suma = List.of(4, 8, 15, 16, 23, 42).stream().reduce(0, Integer::sum);
        int producto = List.of(1, 2, 3, 4, 5).stream().reduce(1, (a, b) -> a * b);
        String iniciales = productos.stream().map(p -> p.nombre().substring(0, 1)).reduce("", String::concat);
        System.out.println("4. Suma con reduce: " + suma);
        System.out.println("   5! con reduce: " + producto);
        System.out.println("   Iniciales: " + iniciales);
        System.out.println();

        // ------------------------------------------------------------
        // 5. Un stream no se puede reutilizar
        // ------------------------------------------------------------
        var stream = productos.stream().filter(p -> p.stock() > 10);
        System.out.println("5. Primera vez: " + stream.count());
        try {
            System.out.println(stream.count());
        } catch (IllegalStateException e) {
            System.out.println("   💥 IllegalStateException: " + e.getMessage());
        }
    }
}
