/*
 * TEMA 19 · Lambdas y streams
 * Ejemplo 06: Collectors (agrupar, contar, unir) y flatMap
 *
 * Cómo ejecutarlo:  java T19_06_Collectors.java
 */
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class T19_06_Collectors {

    record Alumno(String nombre, String curso, double nota) { }

    public static void main(String[] args) {
        List<Alumno> alumnos = List.of(
                new Alumno("Marta", "1ºA", 8.5), new Alumno("Luis", "1ºB", 4.0),
                new Alumno("Ana", "1ºA", 9.0), new Alumno("Pablo", "1ºB", 6.5),
                new Alumno("Sara", "1ºA", 3.5), new Alumno("Hugo", "2ºA", 7.0));

        // ------------------------------------------------------------
        // 1. joining: unir textos
        // ------------------------------------------------------------
        String lista = alumnos.stream().map(Alumno::nombre).collect(Collectors.joining(", "));
        String conMarco = alumnos.stream().map(Alumno::nombre).collect(Collectors.joining(" | ", "[ ", " ]"));
        System.out.println("1. " + lista);
        System.out.println("   " + conMarco);
        System.out.println();

        // ------------------------------------------------------------
        // 2. groupingBy: el "mapa de listas" del tema 16 en una línea
        // ------------------------------------------------------------
        Map<String, List<Alumno>> porCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::curso, TreeMap::new, Collectors.toList()));
        porCurso.forEach((curso, grupo) -> System.out.println("2. " + curso + ": "
                + grupo.stream().map(Alumno::nombre).toList()));
        System.out.println();

        // ------------------------------------------------------------
        // 3. groupingBy + un collector para resumir cada grupo
        // ------------------------------------------------------------
        Map<String, Long> cuantosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::curso, TreeMap::new, Collectors.counting()));
        Map<String, Double> mediaPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::curso, TreeMap::new, Collectors.averagingDouble(Alumno::nota)));
        System.out.println("3. Alumnos por curso: " + cuantosPorCurso);
        mediaPorCurso.forEach((curso, media) -> System.out.printf("   Media de %s: %.2f%n", curso, media));
        System.out.println();

        // ------------------------------------------------------------
        // 4. partitioningBy: dos grupos (true / false)
        // ------------------------------------------------------------
        Map<Boolean, List<String>> aprobados = alumnos.stream()
                .collect(Collectors.partitioningBy(a -> a.nota() >= 5,
                        Collectors.mapping(Alumno::nombre, Collectors.toList())));
        System.out.println("4. Aprobados: " + aprobados.get(true));
        System.out.println("   Suspensos: " + aprobados.get(false));
        System.out.println();

        // ------------------------------------------------------------
        // 5. toMap y toSet
        // ------------------------------------------------------------
        Map<String, Double> notaDe = alumnos.stream()
                .collect(Collectors.toMap(Alumno::nombre, Alumno::nota));
        Set<String> cursos = alumnos.stream().map(Alumno::curso).collect(Collectors.toSet());
        System.out.println("5. Nota de Pablo: " + notaDe.get("Pablo"));
        System.out.println("   Número de cursos distintos: " + cursos.size());
        System.out.println();

        // ------------------------------------------------------------
        // 6. flatMap: de una lista de frases a una lista de palabras
        // ------------------------------------------------------------
        List<String> frases = List.of("el sol sale", "la luna sale", "el sol se pone");
        Map<String, Long> frecuencias = frases.stream()
                .flatMap(frase -> Arrays.stream(frase.split(" ")))       // Cada frase → varias palabras
                .collect(Collectors.groupingBy(p -> p, TreeMap::new, Collectors.counting()));
        System.out.println("6. Frecuencias de todas las palabras: " + frecuencias);
    }
}
