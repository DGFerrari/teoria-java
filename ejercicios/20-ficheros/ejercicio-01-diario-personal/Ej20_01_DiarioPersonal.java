/*
 * TEMA 20 · Ejercicio 01 · Diario personal  (dificultad: 1/5)
 *
 * Objetivo: escribir, añadir y leer un fichero de texto completo.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej20_01_DiarioPersonal.java
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Ej20_01_DiarioPersonal {

    // TODO 1: añade al FINAL del diario la línea "fecha · texto" (y un salto de línea).
    //         Si el fichero no existe, se tiene que crear (CREATE + APPEND)
    static void anotar(Path diario, String fecha, String texto) throws IOException {
    }

    // TODO 2: devuelve las líneas del diario que contienen la palabra
    static List<String> buscar(Path diario, String palabra) throws IOException {
        return new ArrayList<>();
    }

    // NO TOCAR: borra la carpeta temporal y todo su contenido
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
        Path carpeta = Files.createTempDirectory("ej20");          // NO TOCAR: se trabaja en una carpeta temporal
        try {
            Path diario = carpeta.resolve("diario.txt");

            // TODO 3: comprueba si existe el diario, anota las tres entradas del ENUNCIADO,
            //         muestra el contenido completo (readString), el número de entradas y la última
            //         (readAllLines) y busca "Files" y "Python"
        } finally {
            borrarCarpeta(carpeta);                                // NO TOCAR: limpieza
        }
    }
}
