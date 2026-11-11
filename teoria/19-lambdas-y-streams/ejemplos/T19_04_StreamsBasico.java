/*
 * TEMA 19 · Lambdas y streams
 * Ejemplo 04: crear streams y encadenar operaciones intermedias
 *
 * Cómo ejecutarlo:  java T19_04_StreamsBasico.java
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class T19_04_StreamsBasico {

    record Alumno(String nombre, String curso, double nota) { }

    public static void main(String[] args) {
        List<Alumno> alumnos = List.of(
                new Alumno("Marta", "1ºA", 8.5), new Alumno("Luis", "1ºB", 4.0),
                new Alumno("Ana", "1ºA", 9.0), new Alumno("Pablo", "1ºB", 6.5),
                new Alumno("Sara", "1ºA", 3.5), new Alumno("Hugo", "1ºB", 7.0));

        // ------------------------------------------------------------
        // 1. Un pipeline: filtrar → transformar → ordenar → recoger
        // ------------------------------------------------------------
        List<String> aprobados = alumnos.stream()
                .filter(a -> a.nota() >= 5)
                .map(Alumno::nombre)
                .sorted()
                .toList();
        System.out.println("1. Aprobados en orden alfabético: " + aprobados);
        System.out.println("   La lista original no cambia: " + alumnos.size() + " alumnos");
        System.out.println();

        // ------------------------------------------------------------
        // 2. sorted con Comparator y limit
        // ------------------------------------------------------------
        List<String> podio = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::nota).reversed())
                .limit(3)
                .map(a -> a.nombre() + " (" + a.nota() + ")")
                .toList();
        System.out.println("2. Podio: " + podio);
        System.out.println();

        // ------------------------------------------------------------
        // 3. map a otro tipo, distinct y skip
        // ------------------------------------------------------------
        List<String> cursos = alumnos.stream().map(Alumno::curso).distinct().toList();
        System.out.println("3. Cursos distintos: " + cursos);
        List<Integer> longitudes = Stream.of("lambda", "stream", "map", "filter", "map")
                .map(String::length)
                .toList();
        System.out.println("   Longitudes: " + longitudes);
        System.out.println("   Saltando las 2 primeras notas: "
                + alumnos.stream().skip(2).map(Alumno::nota).toList());
        System.out.println();

        // ------------------------------------------------------------
        // 4. Otras fuentes: arrays, rangos, textos
        // ------------------------------------------------------------
        int[] temperaturas = {18, 21, 25, 19, 30, 27};
        System.out.println("4. Temperaturas > 20 al cuadrado: "
                + Arrays.stream(temperaturas).filter(t -> t > 20).map(t -> t * t).boxed().toList());
        System.out.println("   Cuadrados del 1 al 5: " + IntStream.rangeClosed(1, 5).map(i -> i * i).boxed().toList());
        System.out.println("   Suma del 1 al 100: " + IntStream.rangeClosed(1, 100).sum());
        String frase = "Los streams procesan datos";
        System.out.println("   Vocales en \"" + frase + "\": "
                + frase.toLowerCase().chars().filter(c -> "aeiou".indexOf(c) >= 0).count());
        System.out.println();

        // ------------------------------------------------------------
        // 5. Las intermedias son perezosas: sin terminal, no pasa nada
        // ------------------------------------------------------------
        Stream<String> sinTerminar = alumnos.stream()
                .map(a -> {
                    System.out.println("   (procesando " + a.nombre() + ")");
                    return a.nombre();
                });
        System.out.println("5. Stream creado, pero aún no se ha procesado nadie...");
        System.out.println("   Ahora pido solo los 2 primeros:");
        List<String> dos = sinTerminar.limit(2).toList();
        System.out.println("   Resultado: " + dos + " (los demás ni se tocaron)");
    }
}
