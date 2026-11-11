/*
 * TEMA 16 · Ejercicio 04 · Contador de palabras  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol16_04_ContadorDePalabras.java
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sol16_04_ContadorDePalabras {

    // Una palabra con sus apariciones. Se ordena de más a menos frecuente y, si empatan, alfabéticamente
    static class Frecuencia implements Comparable<Frecuencia> {
        private final String palabra;
        private final int veces;

        Frecuencia(String palabra, int veces) {
            this.palabra = palabra;
            this.veces = veces;
        }

        @Override
        public int compareTo(Frecuencia otra) {
            int resultado = Integer.compare(otra.veces, veces);     // Más veces primero
            if (resultado == 0) {
                resultado = palabra.compareTo(otra.palabra);         // Desempate alfabético
            }
            return resultado;
        }

        @Override
        public String toString() {
            return palabra + " (" + veces + ")";
        }
    }

    static String[] palabras(String texto) {
        String limpio = texto.toLowerCase().replace(",", " ").replace(".", " ").strip();
        return limpio.split("\\s+");
    }

    // El patrón contador. TreeMap: las claves quedan en orden alfabético
    static Map<String, Integer> contar(String[] palabras) {
        Map<String, Integer> frecuencias = new TreeMap<>();
        for (String palabra : palabras) {
            frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
        }
        return frecuencias;
    }

    static Map<String, Integer> soloRepetidas(Map<String, Integer> frecuencias) {
        Map<String, Integer> repetidas = new TreeMap<>();
        for (Map.Entry<String, Integer> par : frecuencias.entrySet()) {
            if (par.getValue() > 1) {
                repetidas.put(par.getKey(), par.getValue());
            }
        }
        return repetidas;
    }

    // Del mapa a una lista de objetos Comparable, que sí se puede ordenar con Collections.sort
    static List<Frecuencia> top(Map<String, Integer> frecuencias, int cuantas) {
        List<Frecuencia> todas = new ArrayList<>();
        for (Map.Entry<String, Integer> par : frecuencias.entrySet()) {
            todas.add(new Frecuencia(par.getKey(), par.getValue()));
        }
        Collections.sort(todas);
        List<Frecuencia> primeras = new ArrayList<>();
        for (int i = 0; i < cuantas && i < todas.size(); i++) {
            primeras.add(todas.get(i));
        }
        return primeras;
    }

    // Un mapa cuyos valores son listas: inicial → palabras que empiezan por ella
    static Map<Character, List<String>> indicePorInicial(Map<String, Integer> frecuencias) {
        Map<Character, List<String>> indice = new TreeMap<>();
        for (String palabra : frecuencias.keySet()) {          // Ya vienen en orden alfabético
            char inicial = Character.toUpperCase(palabra.charAt(0));
            if (!indice.containsKey(inicial)) {
                indice.put(inicial, new ArrayList<>());
            }
            indice.get(inicial).add(palabra);
        }
        return indice;
    }

    public static void main(String[] args) {
        String texto = """
                En un lugar de la Mancha, de cuyo nombre no quiero acordarme,
                no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero,
                adarga antigua, rocín flaco y galgo corredor.
                """;

        String[] lista = palabras(texto);
        Map<String, Integer> frecuencias = contar(lista);

        System.out.println("Palabras: " + lista.length + " | Distintas: " + frecuencias.size());
        System.out.println("Repetidas: " + soloRepetidas(frecuencias));

        System.out.println("=== Top 3 ===");
        List<Frecuencia> podio = top(frecuencias, 3);
        for (int i = 0; i < podio.size(); i++) {
            System.out.println((i + 1) + ". " + podio.get(i));
        }

        System.out.println("=== Índice por inicial ===");
        Map<Character, List<String>> indice = indicePorInicial(frecuencias);
        for (Map.Entry<Character, List<String>> par : indice.entrySet()) {
            System.out.println(par.getKey() + ": " + String.join(", ", par.getValue()));
        }

        String masLarga = "";
        for (String palabra : frecuencias.keySet()) {
            if (palabra.length() > masLarga.length()) {
                masLarga = palabra;
            }
        }
        System.out.println("Palabra más larga: " + masLarga + " (" + masLarga.length() + " letras)");
    }
}
