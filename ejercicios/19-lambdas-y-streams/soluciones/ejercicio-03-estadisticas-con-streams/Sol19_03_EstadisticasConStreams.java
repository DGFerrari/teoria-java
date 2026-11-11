/*
 * TEMA 19 · Ejercicio 03 · Estadísticas con streams  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol19_03_EstadisticasConStreams.java
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sol19_03_EstadisticasConStreams {

    public static void main(String[] args) {
        int[] temperaturas = {12, 15, 9, 18, 21, 17, 14, 22, 25, 19, 16, 11, 20, 23};

        // IntStream: sum, average, max y min ya vienen hechos
        double media = Arrays.stream(temperaturas).average().orElse(0);
        System.out.println("=== Temperaturas de " + temperaturas.length + " días ===");
        System.out.printf("Media: %.2f ºC%n", media);
        System.out.println("Máxima: " + Arrays.stream(temperaturas).max().getAsInt()
                + " ºC · mínima: " + Arrays.stream(temperaturas).min().getAsInt() + " ºC");
        System.out.println("Días de más de 20 ºC: " + Arrays.stream(temperaturas).filter(t -> t > 20).count());
        System.out.println("Días por encima de la media: " + Arrays.stream(temperaturas).filter(t -> t > media).count());
        System.out.println("¿Algún día bajo cero? " + Arrays.stream(temperaturas).anyMatch(t -> t < 0));

        // Un stream de POSICIONES para saber en qué día ocurre algo
        int primerDiaCaluroso = IntStream.range(0, temperaturas.length)
                .filter(i -> temperaturas[i] > 24)
                .findFirst()
                .orElse(-1);
        System.out.println("Primer día de más de 24 ºC: el " + (primerDiaCaluroso + 1));

        List<Integer> top3 = Arrays.stream(temperaturas)
                .boxed()                                   // int → Integer, para poder usar un Comparator
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println("Las 3 más altas: " + top3);

        String texto = "Java es un lenguaje orientado a objetos y los streams hacen que procesar datos en Java sea elegante";
        List<String> palabras = Arrays.asList(texto.split(" "));

        System.out.println("=== Palabras ===");
        System.out.println("Total: " + palabras.size() + " · distintas (sin distinguir mayúsculas): "
                + palabras.stream().map(String::toLowerCase).distinct().count());
        System.out.println("La más larga: " + palabras.stream().max(Comparator.comparingInt(String::length)).orElse(""));
        System.out.printf("Longitud media: %.2f letras%n", palabras.stream().mapToInt(String::length).average().orElse(0));
        System.out.println("Empiezan por vocal: " + palabras.stream()
                .filter(p -> "aeiouAEIOU".indexOf(p.charAt(0)) >= 0)
                .distinct()
                .collect(Collectors.joining(", ")));
        System.out.println("Más de 6 letras, en mayúsculas y ordenadas: " + palabras.stream()
                .filter(p -> p.length() > 6)
                .map(String::toUpperCase)
                .sorted()
                .toList());
    }
}
