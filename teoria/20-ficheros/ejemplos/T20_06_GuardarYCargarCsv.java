/*
 * TEMA 20 · Ficheros
 * Ejemplo 06: guardar objetos en CSV y volver a cargarlos
 *
 * Cómo ejecutarlo:  java T20_06_GuardarYCargarCsv.java
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class T20_06_GuardarYCargarCsv {

    static final String CABECERA = "codigo;nombre;precio;stock";

    record Producto(String codigo, String nombre, double precio, int stock) {

        // Objeto → línea. Con + los decimales se escriben con PUNTO (lo que espera parseDouble)
        String aCsv() {
            return codigo + ";" + nombre + ";" + precio + ";" + stock;
        }

        // Línea → objeto
        static Producto desdeCsv(String linea) {
            String[] partes = linea.split(";");
            return new Producto(partes[0], partes[1], Double.parseDouble(partes[2]), Integer.parseInt(partes[3]));
        }
    }

    static void guardar(Path ruta, List<Producto> productos) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add(CABECERA);
        for (Producto p : productos) {
            lineas.add(p.aCsv());
        }
        Files.write(ruta, lineas);
    }

    static List<Producto> cargar(Path ruta) throws IOException {
        return Files.readAllLines(ruta).stream()
                .skip(1)                                 // La cabecera no es un producto
                .filter(linea -> !linea.isBlank())
                .map(Producto::desdeCsv)
                .toList();
    }

    public static void main(String[] args) throws IOException {
        Path carpeta = Files.createTempDirectory("tema20");
        Path ruta = carpeta.resolve("inventario.csv");

        // ------------------------------------------------------------
        // 1. Guardar una lista de objetos
        // ------------------------------------------------------------
        List<Producto> inventario = List.of(
                new Producto("P1", "Teclado", 59.9, 12),
                new Producto("P2", "Ratón", 19.5, 30),
                new Producto("P3", "Monitor", 189.0, 4));
        guardar(ruta, inventario);
        System.out.println("1. Contenido de inventario.csv:");
        for (String linea : Files.readAllLines(ruta)) {
            System.out.println("   " + linea);
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. Cargarla de nuevo: los datos vuelven a ser objetos
        // ------------------------------------------------------------
        List<Producto> cargados = cargar(ruta);
        System.out.println("2. Cargados " + cargados.size() + " productos");
        System.out.println("   ¿Iguales a los guardados? " + cargados.equals(inventario) + " (equals de los records)");
        double valor = cargados.stream().mapToDouble(p -> p.precio() * p.stock()).sum();
        System.out.printf("   Valor del inventario: %.2f €%n", valor);
        System.out.println();

        // ------------------------------------------------------------
        // 3. Añadir un producto al final sin reescribir todo
        // ------------------------------------------------------------
        Producto nuevo = new Producto("P4", "Webcam", 45.0, 7);
        Files.writeString(ruta, nuevo.aCsv() + System.lineSeparator(), StandardOpenOption.APPEND);
        System.out.println("3. Tras añadir: " + cargar(ruta).stream().map(Producto::nombre).toList());
        System.out.println();

        // ------------------------------------------------------------
        // 4. ⚠️ Por qué no se guarda con printf
        // ------------------------------------------------------------
        String conFormato = String.format("%.2f", 59.9);
        System.out.println("4. String.format da \"" + conFormato + "\" (con la coma de la configuración regional)");
        try {
            Double.parseDouble(conFormato);
            System.out.println("   En esta configuración, parseDouble lo entiende");
        } catch (NumberFormatException e) {
            System.out.println("   💥 parseDouble no lo entiende: NumberFormatException");
        }

        // Limpieza
        Files.delete(ruta);
        Files.delete(carpeta);
    }
}
