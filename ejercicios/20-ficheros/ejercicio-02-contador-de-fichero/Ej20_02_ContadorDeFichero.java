/*
 * TEMA 20 · Ejercicio 02 · Contador de fichero  (dificultad: 2/5)
 *
 * Objetivo: leer un fichero línea a línea con BufferedReader y tratar sus errores.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej20_02_ContadorDeFichero.java
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Ej20_02_ContadorDeFichero {

    record Estadisticas(int lineas, int vacias, int palabras, int caracteres, String masLarga) { }

    // TODO 1: lee el fichero línea a línea con un BufferedReader (en un try-with-resources)
    //         y calcula las estadísticas. Las líneas vacías no tienen palabras
    static Estadisticas analizar(Path ruta) throws IOException {
        return new Estadisticas(0, 0, 0, 0, "");
    }

    // TODO 2: muestra las estadísticas del fichero. Si no existe, "✘ No existe el fichero X"
    //         (captura NoSuchFileException y, después, IOException)
    static void mostrar(Path ruta) {
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

    public static void main(String[] args) throws IOException {
        // NO TOCAR: se crea el fichero de prueba en una carpeta temporal
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
