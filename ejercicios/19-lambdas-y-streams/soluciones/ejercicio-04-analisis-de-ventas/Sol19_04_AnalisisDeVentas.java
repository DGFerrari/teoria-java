/*
 * TEMA 19 · Ejercicio 04 · Análisis de ventas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol19_04_AnalisisDeVentas.java
 */
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Sol19_04_AnalisisDeVentas {

    record Venta(String producto, String categoria, String mes, int unidades, double precio) {
        double importe() {
            return unidades * precio;
        }
    }

    static double totalFacturado(List<Venta> ventas) {
        return ventas.stream().mapToDouble(Venta::importe).sum();
    }

    static Map<String, Double> facturacionPorCategoria(List<Venta> ventas) {
        return ventas.stream().collect(Collectors.groupingBy(
                Venta::categoria, TreeMap::new, Collectors.summingDouble(Venta::importe)));
    }

    // LinkedHashMap: los meses quedan en el orden en que aparecen (los datos están ordenados)
    static Map<String, Integer> unidadesPorMes(List<Venta> ventas) {
        return ventas.stream().collect(Collectors.groupingBy(
                Venta::mes, LinkedHashMap::new, Collectors.summingInt(Venta::unidades)));
    }

    static Map<String, Double> facturacionPorMes(List<Venta> ventas) {
        return ventas.stream().collect(Collectors.groupingBy(
                Venta::mes, LinkedHashMap::new, Collectors.summingDouble(Venta::importe)));
    }

    // Se agrupa por producto y después se ordenan los PARES del mapa por su valor
    static List<Map.Entry<String, Double>> topProductos(List<Venta> ventas, int cuantos) {
        Map<String, Double> porProducto = ventas.stream().collect(Collectors.groupingBy(
                Venta::producto, Collectors.summingDouble(Venta::importe)));
        return porProducto.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(cuantos)
                .toList();
    }

    static Map<Boolean, Long> contarGrandes(List<Venta> ventas, double limite) {
        return ventas.stream().collect(Collectors.partitioningBy(v -> v.importe() > limite, Collectors.counting()));
    }

    // Optional: puede que no haya ninguna venta de esa categoría
    static Optional<Venta> mayorVentaDe(List<Venta> ventas, String categoria) {
        return ventas.stream()
                .filter(v -> v.categoria().equals(categoria))
                .max(Comparator.comparingInt(Venta::unidades));
    }

    static Map<String, Set<String>> productosPorCategoria(List<Venta> ventas) {
        return ventas.stream().collect(Collectors.groupingBy(Venta::categoria, TreeMap::new,
                Collectors.mapping(Venta::producto, Collectors.toCollection(TreeSet::new))));
    }

    static String describirMayorVenta(List<Venta> ventas, String categoria) {
        return mayorVentaDe(ventas, categoria)
                .map(v -> v.producto() + " (" + v.unidades() + " uds.)")
                .orElse("sin ventas");
    }

    public static void main(String[] args) {
        List<Venta> ventas = List.of(
                new Venta("El Quijote", "Libros", "Enero", 3, 12.50),
                new Venta("Puzle 1000", "Juguetes", "Enero", 2, 18.00),
                new Venta("Auriculares", "Electrónica", "Enero", 1, 59.90),
                new Venta("Dune", "Libros", "Febrero", 5, 10.95),
                new Venta("Cargador USB", "Electrónica", "Febrero", 4, 15.00),
                new Venta("El Quijote", "Libros", "Febrero", 2, 12.50),
                new Venta("Altavoz", "Electrónica", "Marzo", 2, 79.00),
                new Venta("Puzle 1000", "Juguetes", "Marzo", 6, 18.00),
                new Venta("Dune", "Libros", "Marzo", 1, 10.95),
                new Venta("Auriculares", "Electrónica", "Marzo", 3, 59.90));

        System.out.printf("Total facturado: %.2f €%n", totalFacturado(ventas));

        System.out.println("=== Por categoría ===");
        facturacionPorCategoria(ventas).forEach((categoria, total) ->
                System.out.printf("%-12s %8.2f €%n", categoria, total));

        System.out.println("=== Por mes ===");
        Map<String, Integer> unidades = unidadesPorMes(ventas);
        Map<String, Double> importes = facturacionPorMes(ventas);
        unidades.forEach((mes, uds) -> System.out.printf("%-8s %3d uds. · %7.2f €%n", mes, uds, importes.get(mes)));

        System.out.println("=== Top 3 productos ===");
        List<Map.Entry<String, Double>> top = topProductos(ventas, 3);
        for (int i = 0; i < top.size(); i++) {
            System.out.printf("%d. %s (%.2f €)%n", i + 1, top.get(i).getKey(), top.get(i).getValue());
        }

        Map<Boolean, Long> grandes = contarGrandes(ventas, 100);
        System.out.println("Ventas de más de 100 €: " + grandes.get(true) + " · resto: " + grandes.get(false));
        System.out.printf("Unidades medias por venta: %.2f%n",
                ventas.stream().mapToInt(Venta::unidades).average().orElse(0));
        System.out.println("Mayor venta de Libros: " + describirMayorVenta(ventas, "Libros"));
        System.out.println("Mayor venta de Juegos de mesa: " + describirMayorVenta(ventas, "Juegos de mesa"));
        System.out.println("Productos por categoría: " + productosPorCategoria(ventas));
    }
}
