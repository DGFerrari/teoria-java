/*
 * TEMA 19 · Ejercicio 03 · Estadísticas con streams  (dificultad: 3/5)
 *
 * Objetivo: resolver con streams (sin bucles) los cálculos que en el tema 08 hacías con bucles.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej19_03_EstadisticasConStreams.java
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ej19_03_EstadisticasConStreams {

    public static void main(String[] args) {
        // NO TOCAR: los datos
        int[] temperaturas = {12, 15, 9, 18, 21, 17, 14, 22, 25, 19, 16, 11, 20, 23};
        String texto = "Java es un lenguaje orientado a objetos y los streams hacen que procesar datos en Java sea elegante";
        List<String> palabras = Arrays.asList(texto.split(" "));

        // TODO 1: temperaturas con Arrays.stream(temperaturas): media, máxima, mínima,
        //         días de más de 20, días por encima de la media y si hay algún día bajo cero

        // TODO 2: primer día (1, 2, 3...) de más de 24 ºC. Pista: IntStream.range sobre las posiciones

        // TODO 3: las 3 temperaturas más altas en una List<Integer> (boxed, sorted, limit)

        // TODO 4: palabras: total, distintas sin distinguir mayúsculas, la más larga, la longitud media,
        //         las que empiezan por vocal (sin repetir, unidas con ", ")
        //         y las de más de 6 letras en mayúsculas y ordenadas
    }
}
