/*
 * TEMA 20 · Ejercicio 01 · Diario personal  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol20_01_DiarioPersonal.java
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Sol20_01_DiarioPersonal {

    // Añade una entrada al final. CREATE: si el fichero no existe, lo crea
    static void anotar(Path diario, String fecha, String texto) throws IOException {
        Files.writeString(diario, fecha + " · " + texto + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    static List<String> buscar(Path diario, String palabra) throws IOException {
        List<String> encontradas = new ArrayList<>();
        for (String linea : Files.readAllLines(diario)) {
            if (linea.contains(palabra)) {
                encontradas.add(linea);
            }
        }
        return encontradas;
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
            Path diario = carpeta.resolve("diario.txt");
            System.out.println("¿Existe diario.txt al empezar? " + Files.exists(diario));

            anotar(diario, "2026-11-01", "Empiezo el tema de ficheros");
            anotar(diario, "2026-11-02", "Hoy he aprendido a usar Files.readString");
            anotar(diario, "2026-11-03", "Mi programa en Java ya guarda datos");

            System.out.println("=== Contenido de " + diario.getFileName() + " ===");
            System.out.print(Files.readString(diario));

            List<String> lineas = Files.readAllLines(diario);
            System.out.println("Entradas: " + lineas.size());
            System.out.println("Última: " + lineas.get(lineas.size() - 1));
            System.out.println("Con la palabra \"Files\": " + buscar(diario, "Files"));
            System.out.println("Con la palabra \"Python\": " + buscar(diario, "Python"));
        } finally {
            borrarCarpeta(carpeta);
        }
    }
}
