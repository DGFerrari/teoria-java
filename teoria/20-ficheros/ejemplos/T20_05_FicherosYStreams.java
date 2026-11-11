/*
 * TEMA 20 · Ficheros
 * Ejemplo 05: Files.lines, Files.list, Files.walk y operaciones con ficheros
 *
 * Cómo ejecutarlo:  java T20_05_FicherosYStreams.java
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class T20_05_FicherosYStreams {

    // Borra una carpeta con todo su contenido: primero lo de dentro (orden inverso)
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
        Path raiz = Files.createTempDirectory("tema20");

        // ------------------------------------------------------------
        // 1. Crear una estructura de carpetas y ficheros
        // ------------------------------------------------------------
        Path logs = raiz.resolve("logs");
        Path antiguos = logs.resolve("2025").resolve("antiguos");
        Files.createDirectories(antiguos);                        // Crea las tres de una vez
        Files.writeString(logs.resolve("lunes.log"), "INFO inicio\nERROR disco lleno\nINFO fin\n");
        Files.writeString(logs.resolve("martes.log"), "INFO inicio\nINFO fin\n");
        Files.writeString(logs.resolve("miercoles.log"), "ERROR red\nERROR red\nINFO fin\n");
        Files.writeString(logs.resolve("leeme.txt"), "Carpeta de registros\n");
        Files.writeString(antiguos.resolve("enero.log"), "INFO viejo\n");
        System.out.println("1. Estructura creada");
        System.out.println();

        // ------------------------------------------------------------
        // 2. Files.list: el contenido directo de una carpeta
        // ------------------------------------------------------------
        List<String> soloLogs;
        try (Stream<Path> contenido = Files.list(logs)) {
            soloLogs = contenido
                    .filter(Files::isRegularFile)
                    .map(p -> p.getFileName().toString())
                    .filter(nombre -> nombre.endsWith(".log"))
                    .sorted()
                    .toList();
        }
        System.out.println("2. Ficheros .log en logs/: " + soloLogs);

        // ------------------------------------------------------------
        // 3. Files.walk: todo lo que hay dentro, a cualquier profundidad
        // ------------------------------------------------------------
        long totalLogs;
        try (Stream<Path> recorrido = Files.walk(logs)) {
            totalLogs = recorrido.filter(p -> p.toString().endsWith(".log")).count();
        }
        System.out.println("3. Ficheros .log en logs/ y subcarpetas: " + totalLogs);
        System.out.println();

        // ------------------------------------------------------------
        // 4. Files.lines: procesar un fichero con un stream
        // ------------------------------------------------------------
        for (String nombre : soloLogs) {
            try (Stream<String> lineas = Files.lines(logs.resolve(nombre))) {
                long errores = lineas.filter(l -> l.startsWith("ERROR")).count();
                System.out.println("4. " + nombre + ": " + errores + " error(es)");
            }
        }
        System.out.println();

        // ------------------------------------------------------------
        // 5. Copiar, mover y borrar
        // ------------------------------------------------------------
        Path copias = Files.createDirectories(raiz.resolve("copias"));
        Files.copy(logs.resolve("lunes.log"), copias.resolve("lunes.log"));
        Files.copy(logs.resolve("lunes.log"), copias.resolve("lunes.log"), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("5. Copiado lunes.log (la segunda vez, con REPLACE_EXISTING)");

        Files.move(logs.resolve("leeme.txt"), raiz.resolve("LEEME.txt"));     // Mover y renombrar a la vez
        System.out.println("   ¿leeme.txt sigue en logs/? " + Files.exists(logs.resolve("leeme.txt")));
        System.out.println("   ¿Existe LEEME.txt en la raíz? " + Files.exists(raiz.resolve("LEEME.txt")));

        System.out.println("   deleteIfExists(martes.log): " + Files.deleteIfExists(logs.resolve("martes.log")));
        System.out.println("   deleteIfExists(martes.log) otra vez: " + Files.deleteIfExists(logs.resolve("martes.log")));

        // Limpieza de todo
        borrarCarpeta(raiz);
        System.out.println("   Carpeta temporal borrada: " + !Files.exists(raiz));
    }
}
