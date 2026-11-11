/*
 * TEMA 20 · Ejercicio 03 · Boletín desde CSV  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol20_03_BoletinDesdeCsv.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Sol20_03_BoletinDesdeCsv {

    record Alumno(String nombre, double matematicas, double lengua, double ingles) {
        double media() {
            return (matematicas + lengua + ingles) / 3;
        }

        boolean aprobado() {
            return media() >= 5;
        }

        // Puede lanzar IllegalArgumentException (faltan campos) o NumberFormatException (no es un número)
        static Alumno desdeCsv(String linea) {
            String[] partes = linea.split(";");
            if (partes.length != 4) {
                throw new IllegalArgumentException("faltan campos");
            }
            return new Alumno(partes[0], Double.parseDouble(partes[1]),
                    Double.parseDouble(partes[2]), Double.parseDouble(partes[3]));
        }
    }

    static List<Alumno> leerAlumnos(Path ruta) throws IOException {
        List<String> lineas = Files.readAllLines(ruta);
        List<Alumno> alumnos = new ArrayList<>();
        for (int i = 1; i < lineas.size(); i++) {                // i = 1: se salta la cabecera
            try {
                alumnos.add(Alumno.desdeCsv(lineas.get(i)));
            } catch (NumberFormatException e) {                   // Subclase: va primero
                System.out.println("⚠ Línea " + (i + 1) + " ignorada: nota no válida (" + lineas.get(i) + ")");
            } catch (IllegalArgumentException e) {
                System.out.println("⚠ Línea " + (i + 1) + " ignorada: " + e.getMessage() + " (" + lineas.get(i) + ")");
            }
        }
        return alumnos;
    }

    // PrintWriter: printf en un fichero. Es un informe para leer, así que la coma decimal no importa
    static void escribirBoletin(Path destino, List<Alumno> alumnos) throws IOException {
        try (PrintWriter salida = new PrintWriter(Files.newBufferedWriter(destino))) {
            salida.println("=== BOLETÍN DE NOTAS ===");
            salida.printf("%-8s %5s %5s %5s %6s%n", "Alumno", "Mat.", "Leng.", "Ingl.", "Media");
            for (Alumno a : alumnos) {
                salida.printf("%-8s %5.2f %5.2f %5.2f %6.2f %s%n", a.nombre(), a.matematicas(), a.lengua(),
                        a.ingles(), a.media(), a.aprobado() ? "✔" : "✘");
            }
            double mediaClase = alumnos.stream().mapToDouble(Alumno::media).average().orElse(0);
            salida.printf("Media de la clase: %.2f%n", mediaClase);
        }
    }

    // Un CSV para que lo lea otro programa: con PUNTO decimal (concatenando, no con printf)
    static void escribirAprobados(Path destino, List<Alumno> alumnos) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add("nombre;media");
        for (Alumno a : alumnos) {
            if (a.aprobado()) {
                lineas.add(a.nombre() + ";" + Math.round(a.media() * 100) / 100.0);
            }
        }
        Files.write(destino, lineas);
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
            Path notas = carpeta.resolve("notas.csv");
            Files.writeString(notas, """
                    nombre;matematicas;lengua;ingles
                    Ana;8.5;7;9
                    Luis;4;5.5;3.5
                    Marta;9.25;8.75;10
                    Pablo;siete;6;8
                    Sara;6;4.5;5
                    Hugo;5;6
                    """);

            List<Alumno> alumnos = leerAlumnos(notas);
            System.out.println("Alumnos leídos: " + alumnos.size());

            Path boletin = carpeta.resolve("boletin.txt");
            Path aprobados = carpeta.resolve("aprobados.csv");
            escribirBoletin(boletin, alumnos);
            escribirAprobados(aprobados, alumnos);

            System.out.println("--- " + boletin.getFileName() + " ---");
            System.out.print(Files.readString(boletin));
            System.out.println("--- " + aprobados.getFileName() + " ---");
            Files.readAllLines(aprobados).forEach(System.out::println);
        } finally {
            borrarCarpeta(carpeta);
        }
    }
}
