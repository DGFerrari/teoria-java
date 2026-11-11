/*
 * TEMA 20 · Ejercicio 05 · Analizador de logs  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol20_05_AnalizadorDeLogs.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sol20_05_AnalizadorDeLogs {

    enum Nivel { INFO, AVISO, ERROR }

    // "2026-11-10 09:15:02 ERROR [pagos] Tarjeta rechazada"
    record Entrada(String fecha, String hora, Nivel nivel, String modulo, String mensaje) {

        static Optional<Entrada> parsear(String linea) {
            Optional<Entrada> resultado = Optional.empty();
            String[] partes = linea.split(" ", 5);                // Como mucho 5 trozos: el mensaje lleva espacios
            if (partes.length == 5 && partes[3].startsWith("[") && partes[3].endsWith("]")) {
                try {
                    Nivel nivel = Nivel.valueOf(partes[2]);
                    String modulo = partes[3].substring(1, partes[3].length() - 1);
                    resultado = Optional.of(new Entrada(partes[0], partes[1], nivel, modulo, partes[4]));
                } catch (IllegalArgumentException e) {
                    resultado = Optional.empty();                 // Nivel desconocido
                }
            }
            return resultado;
        }
    }

    // Los .log de la carpeta, ordenados. Files.list es un recurso: try-with-resources
    static List<Path> listarLogs(Path carpeta) throws IOException {
        try (Stream<Path> contenido = Files.list(carpeta)) {
            return contenido
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith(".log"))
                    .sorted()
                    .toList();
        }
    }

    // El resultado de leer un fichero: las entradas válidas y cuántas líneas no lo eran
    record Lectura(List<Entrada> validas, int descartadas) { }

    static Lectura leerEntradas(Path fichero) throws IOException {
        List<String> lineas;
        try (Stream<String> stream = Files.lines(fichero)) {      // Files.lines también hay que cerrarlo
            lineas = stream.filter(l -> !l.isBlank()).toList();
        }
        List<Entrada> validas = lineas.stream()
                .map(Entrada::parsear)
                .flatMap(Optional::stream)
                .toList();
        return new Lectura(validas, lineas.size() - validas.size());
    }

    static void escribirResumen(Path destino, Map<Path, List<Entrada>> porFichero, int descartadas) throws IOException {
        List<Entrada> todas = porFichero.values().stream().flatMap(List::stream).toList();

        Map<Nivel, Long> porNivel = new EnumMap<>(Nivel.class);
        for (Nivel n : Nivel.values()) {
            porNivel.put(n, todas.stream().filter(e -> e.nivel() == n).count());
        }
        Map<String, Long> erroresPorModulo = todas.stream()
                .filter(e -> e.nivel() == Nivel.ERROR)
                .collect(Collectors.groupingBy(Entrada::modulo, TreeMap::new, Collectors.counting()));

        try (PrintWriter salida = new PrintWriter(Files.newBufferedWriter(destino))) {
            salida.println("=== RESUMEN DE LOGS ===");
            porFichero.forEach((fichero, entradas) -> salida.printf("%-14s %2d entradas · errores: %d%n",
                    fichero.getFileName(), entradas.size(),
                    entradas.stream().filter(e -> e.nivel() == Nivel.ERROR).count()));
            salida.println("Total: " + todas.size() + " entradas válidas · " + descartadas + " líneas descartadas");
            salida.println("Por nivel: " + porNivel);
            salida.println("Errores por módulo: " + erroresPorModulo);
            todas.stream()
                    .filter(e -> e.nivel() == Nivel.ERROR)
                    .findFirst()
                    .ifPresent(e -> salida.println("Primer error: " + e.fecha() + " " + e.hora() + " [" + e.modulo() + "] " + e.mensaje()));
        }
    }

    // Copia a la carpeta "errores" los ficheros que tienen al menos un ERROR
    static List<String> copiarConErrores(Map<Path, List<Entrada>> porFichero, Path destino) throws IOException {
        Files.createDirectories(destino);
        List<String> copiados = new ArrayList<>();
        for (Map.Entry<Path, List<Entrada>> par : porFichero.entrySet()) {
            boolean tieneErrores = par.getValue().stream().anyMatch(e -> e.nivel() == Nivel.ERROR);
            if (tieneErrores) {
                Path origen = par.getKey();
                Files.copy(origen, destino.resolve(origen.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                copiados.add(origen.getFileName().toString());
            }
        }
        return copiados;
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

    // Crea los ficheros de prueba
    static void prepararDatos(Path logs) throws IOException {
        Files.createDirectories(logs);
        Files.writeString(logs.resolve("lunes.log"), """
                2026-11-09 08:00:01 INFO [web] Servidor arrancado
                2026-11-09 09:15:02 ERROR [pagos] Tarjeta rechazada
                2026-11-09 09:15:40 AVISO [pagos] Reintento de cobro
                2026-11-09 12:30:00 INFO [web] 120 visitas
                """);
        Files.writeString(logs.resolve("martes.log"), """
                2026-11-10 08:00:01 INFO [web] Servidor arrancado
                2026-11-10 10:05:12 AVISO [almacen] Stock bajo: teclados
                línea corrupta sin formato
                2026-11-10 18:45:00 INFO [web] 98 visitas
                """);
        Files.writeString(logs.resolve("miercoles.log"), """
                2026-11-11 08:00:02 INFO [web] Servidor arrancado
                2026-11-11 11:11:11 ERROR [almacen] Base de datos no responde
                2026-11-11 11:12:30 ERROR [web] Error 500 en /carrito
                2026-11-11 11:20:00 DEBUG [web] Nivel desconocido
                2026-11-11 11:30:45 INFO [almacen] Conexión recuperada
                """);
        Files.writeString(logs.resolve("leeme.txt"), "No es un log\n");
    }

    public static void main(String[] args) throws IOException {
        Path carpeta = Files.createTempDirectory("ej20");
        try {
            Path logs = carpeta.resolve("logs");
            prepararDatos(logs);

            List<Path> ficheros = listarLogs(logs);
            System.out.println("Ficheros .log: " + ficheros.stream().map(p -> p.getFileName().toString()).toList());

            Map<Path, List<Entrada>> porFichero = new TreeMap<>();
            int descartadas = 0;
            for (Path fichero : ficheros) {
                try {                                              // Un fichero ilegible no detiene el análisis
                    Lectura lectura = leerEntradas(fichero);
                    porFichero.put(fichero, lectura.validas());
                    descartadas += lectura.descartadas();
                } catch (IOException e) {
                    System.out.println("✘ No se pudo leer " + fichero.getFileName() + ": " + e.getMessage());
                }
            }

            Path resumen = carpeta.resolve("resumen.txt");
            escribirResumen(resumen, porFichero, descartadas);
            System.out.print(Files.readString(resumen));

            List<String> copiados = copiarConErrores(porFichero, carpeta.resolve("errores"));
            System.out.println("Copiados a errores/: " + copiados);
            System.out.println("¿Existe errores/martes.log? " + Files.exists(carpeta.resolve("errores").resolve("martes.log")));
        } finally {
            borrarCarpeta(carpeta);
        }
    }
}
