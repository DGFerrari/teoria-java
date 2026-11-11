/*
 * TEMA 16 · Ejercicio 04 · Contador de palabras  (dificultad: 4/5)
 *
 * Objetivo: el patrón contador con un Map, mapas de listas y ordenar con Comparable.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej16_04_ContadorDePalabras.java
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ej16_04_ContadorDePalabras {

    // TODO 1: implementa Comparable<Frecuencia>: más veces primero; si empatan, orden alfabético
    static class Frecuencia {
        private final String palabra;
        private final int veces;

        Frecuencia(String palabra, int veces) {
            this.palabra = palabra;
            this.veces = veces;
        }

        @Override
        public String toString() {
            return palabra + " (" + veces + ")";
        }
    }

    // NO TOCAR: divide el texto en palabras en minúsculas y sin signos de puntuación
    static String[] palabras(String texto) {
        String limpio = texto.toLowerCase().replace(",", " ").replace(".", " ").strip();
        return limpio.split("\\s+");
    }

    // TODO 2: cuenta cuántas veces aparece cada palabra (TreeMap y getOrDefault)
    static Map<String, Integer> contar(String[] palabras) {
        return new TreeMap<>();
    }

    // TODO 3: un mapa nuevo solo con las palabras que aparecen más de una vez
    static Map<String, Integer> soloRepetidas(Map<String, Integer> frecuencias) {
        return new TreeMap<>();
    }

    // TODO 4: pasa los pares del mapa a una List<Frecuencia>, ordénala con Collections.sort
    //         y devuelve las "cuantas" primeras
    static List<Frecuencia> top(Map<String, Integer> frecuencias, int cuantas) {
        return new ArrayList<>();
    }

    // TODO 5: inicial en mayúscula → lista de palabras que empiezan por ella (en orden alfabético)
    static Map<Character, List<String>> indicePorInicial(Map<String, Integer> frecuencias) {
        return new TreeMap<>();
    }

    public static void main(String[] args) {
        // NO TOCAR: el texto
        String texto = """
                En un lugar de la Mancha, de cuyo nombre no quiero acordarme,
                no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero,
                adarga antigua, rocín flaco y galgo corredor.
                """;

        String[] lista = palabras(texto);

        // TODO 6: muestra el total de palabras y las distintas, las repetidas, el top 3,
        //         el índice por inicial (usa String.join(", ", lista)) y la palabra más larga
    }
}
