/*
 * TEMA 20 · Ejercicio 05 · Analizador de logs  (dificultad: 5/5)
 *
 * Objetivo: un programa completo que trabaja con varias carpetas y ficheros: listar, leer con
 *           streams, validar, resumir, escribir un informe y copiar ficheros.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej20_05_AnalizadorDeLogs.java
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

public class Ej20_05_AnalizadorDeLogs {

    enum Nivel { INFO, AVISO, ERROR }

    record Entrada(String fecha, String hora, Nivel nivel, String modulo, String mensaje) {

        // TODO 1: "2026-11-10 09:15:02 ERROR [pagos] Tarjeta rechazada" → Optional con la Entrada.
        //         Vacío si no tiene 5 partes (split(" ", 5)), si el módulo no va entre corchetes
        //         o si el nivel no existe (valueOf lanza IllegalArgumentException)
        static Optional<Entrada> parsear(String linea) {
            return Optional.empty();
        }
    }

    // NO TOCAR: el resultado de leer un fichero
    record Lectura(List<Entrada> validas, int descartadas) { }

    // TODO 2: los ficheros .log de la carpeta, ordenados (Files.list en un try-with-resources)
    static List<Path> listarLogs(Path carpeta) throws IOException {
        return List.of();
    }

    // TODO 3: lee las líneas no vacías con Files.lines (try-with-resources), convierte las válidas
    //         en Entrada y cuenta las que no lo son
    static Lectura leerEntradas(Path fichero) throws IOException {
        return new Lectura(List.of(), 0);
    }

    // TODO 4: escribe el resumen con un PrintWriter (mira el ENUNCIADO): una línea por fichero,
    //         el total, los recuentos por nivel (EnumMap con los tres niveles), los errores por módulo
    //         (TreeMap) y el primer error
    static void escribirResumen(Path destino, Map<Path, List<Entrada>> porFichero, int descartadas) throws IOException {
    }

    // TODO 5: crea la carpeta destino y copia en ella los ficheros con al menos un ERROR.
    //         Devuelve sus nombres
    static List<String> copiarConErrores(Map<Path, List<Entrada>> porFichero, Path destino) throws IOException {
        return new ArrayList<>();
    }

    // NO TOCAR
    static void borrarCarpeta(Path carpeta) throws IOException {
        List<Path> todo;
        try (Stream<Path> recorrido = Files.walk(carpeta)) {
            todo = recorrido.sorted(Comparator.reverseOrder()).toList();
        }
        for (Path p : todo) {
            Files.delete(p);
        }
    }

    // NO TOCAR: crea los ficheros de prueba
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

            // TODO 6: lista los .log, lee cada uno (si uno falla, avisa y sigue con los demás),
            //         guarda las entradas en un TreeMap<Path, List<Entrada>> y suma las descartadas.
            //         Escribe resumen.txt en "carpeta", muéstralo y copia los ficheros con errores
            //         a carpeta/errores
        } finally {
            borrarCarpeta(carpeta);
        }
    }
}
