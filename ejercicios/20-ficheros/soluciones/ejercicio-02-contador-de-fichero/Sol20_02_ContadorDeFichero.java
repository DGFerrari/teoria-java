/*
 * TEMA 20 · Ejercicio 02 · Contador de fichero  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol20_02_ContadorDeFichero.java
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Sol20_02_ContadorDeFichero {

    record Estadisticas(int lineas, int vacias, int palabras, int caracteres, String masLarga) { }

    // Se lee línea a línea: sirve igual para un fichero de 10 líneas que de 10 millones
    static Estadisticas analizar(Path ruta) throws IOException {
        int lineas = 0;
        int vacias = 0;
        int palabras = 0;
        int caracteres = 0;
        String masLarga = "";
        try (BufferedReader lector = Files.newBufferedReader(ruta)) {
            String linea = lector.readLine();
            while (linea != null) {
                lineas++;
                caracteres += linea.length();
                if (linea.isBlank()) {
                    vacias++;
                } else {
                    palabras += linea.strip().split("\\s+").length;
                }
                if (linea.length() > masLarga.length()) {
                    masLarga = linea;
                }
                linea = lector.readLine();
            }
        }
        return new Estadisticas(lineas, vacias, palabras, caracteres, masLarga);
    }

    static void mostrar(Path ruta) {
        System.out.println("=== " + ruta.getFileName() + " ===");
        try {
            Estadisticas e = analizar(ruta);
            System.out.println("Líneas: " + e.lineas() + " (" + e.vacias() + " vacías)");
            System.out.println("Palabras: " + e.palabras());
            System.out.println("Caracteres (sin saltos de línea): " + e.caracteres());
            System.out.println("Línea más larga: \"" + e.masLarga() + "\"");
        } catch (NoSuchFileException e) {
            System.out.println("✘ No existe el fichero " + ruta.getFileName());
        } catch (IOException e) {
            System.out.println("✘ Error al leer: " + e.getMessage());
        }
    }

    static void borrarCarpeta(Path carpeta) throws IOException {
        List<Path> todo;
        try (Stream<Path> recorrido = Files.walk(carpeta)) {
            todo = recorrido.sorted(Comparator.reverseOrder()).toList();
        }
        for (Path p : todo) {
            Files.delete(p);
        }
    }

    public static void main(String[] args) throws IOException {
        Path carpeta = Files.createTempDirectory("ej20");
        try {
            Path poema = carpeta.resolve("caminante.txt");
            Files.writeString(poema, """
                    Caminante, son tus huellas
                    el camino y nada más;
                    caminante, no hay camino,
                    se hace camino al andar.

                    Al andar se hace el camino,
                    y al volver la vista atrás
                    se ve la senda que nunca
                    se ha de volver a pisar.
                    """);

            mostrar(poema);
            mostrar(carpeta.resolve("no-existe.txt"));
        } finally {
            borrarCarpeta(carpeta);
        }
    }
}
