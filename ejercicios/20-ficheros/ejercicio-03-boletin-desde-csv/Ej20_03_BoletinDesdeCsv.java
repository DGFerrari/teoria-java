/*
 * TEMA 20 · Ejercicio 03 · Boletín desde CSV  (dificultad: 3/5)
 *
 * Objetivo: leer un CSV convirtiendo cada línea en un objeto, tolerar líneas incorrectas
 *           y escribir dos ficheros de salida (un informe y otro CSV).
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej20_03_BoletinDesdeCsv.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Ej20_03_BoletinDesdeCsv {

    record Alumno(String nombre, double matematicas, double lengua, double ingles) {
        double media() {
            return (matematicas + lengua + ingles) / 3;
        }

        boolean aprobado() {
            return media() >= 5;
        }

        // TODO 1: "Ana;8.5;7;9" → Alumno. Si no hay 4 campos: IllegalArgumentException("faltan campos").
        //         parseDouble lanzará NumberFormatException si una nota no es un número
        static Alumno desdeCsv(String linea) {
            return null;
        }
    }

    // TODO 2: lee todas las líneas menos la cabecera. Las incorrectas no detienen la lectura:
    //         muestra "⚠ Línea N ignorada: ..." (mira la salida esperada) y sigue con la siguiente
    static List<Alumno> leerAlumnos(Path ruta) throws IOException {
        return new ArrayList<>();
    }

    // TODO 3: escribe el boletín con un PrintWriter y printf (mira el formato en el ENUNCIADO)
    static void escribirBoletin(Path destino, List<Alumno> alumnos) throws IOException {
    }

    // TODO 4: escribe un CSV "nombre;media" solo con los aprobados, con la media redondeada a 2 decimales
    //         y con PUNTO decimal (no uses printf ni String.format)
    static void escribirAprobados(Path destino, List<Alumno> alumnos) throws IOException {
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
        Path carpeta = Files.createTempDirectory("ej20");
        try {
            // NO TOCAR: el fichero de entrada
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

            // TODO 5: lee los alumnos, escribe boletin.txt y aprobados.csv y muestra el contenido de los dos
        } finally {
            borrarCarpeta(carpeta);
        }
    }
}
