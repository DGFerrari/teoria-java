/*
 * TEMA 19 · Ejercicio 04 · Análisis de ventas  (dificultad: 4/5)
 *
 * Objetivo: agrupar, resumir y ordenar datos con streams y Collectors.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej19_04_AnalisisDeVentas.java
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

public class Ej19_04_AnalisisDeVentas {

    record Venta(String producto, String categoria, String mes, int unidades, double precio) {
        double importe() {
            return unidades * precio;
        }
    }

    // TODO 1: suma de los importes
    static double totalFacturado(List<Venta> ventas) {
        return 0;
    }

    // TODO 2: categoría → suma de importes (TreeMap)
    static Map<String, Double> facturacionPorCategoria(List<Venta> ventas) {
        return new TreeMap<>();
    }

    // TODO 3: mes → suma de unidades y mes → suma de importes (LinkedHashMap, para conservar el orden)
    static Map<String, Integer> unidadesPorMes(List<Venta> ventas) {
        return new LinkedHashMap<>();
    }

    static Map<String, Double> facturacionPorMes(List<Venta> ventas) {
        return new LinkedHashMap<>();
    }

    // TODO 4: agrupa por producto (suma de importes) y devuelve los "cuantos" pares con más importe
    static List<Map.Entry<String, Double>> topProductos(List<Venta> ventas, int cuantos) {
        return List.of();
    }

    // TODO 5: cuántas ventas superan el límite (true) y cuántas no (false), con partitioningBy
    static Map<Boolean, Long> contarGrandes(List<Venta> ventas, double limite) {
        return Map.of();
    }

    // TODO 6: la venta con más unidades de esa categoría (puede no haber ninguna)
    static Optional<Venta> mayorVentaDe(List<Venta> ventas, String categoria) {
        return Optional.empty();
    }

    // TODO 7: categoría → productos distintos y ordenados (groupingBy + mapping + toCollection(TreeSet::new))
    static Map<String, Set<String>> productosPorCategoria(List<Venta> ventas) {
        return new TreeMap<>();
    }

    public static void main(String[] args) {
        // NO TOCAR: los datos
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

        // TODO 8: muestra el informe como en la salida esperada
    }
}
