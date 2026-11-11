/*
 * TEMA 16 · Ejercicio 03 · Palabras únicas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol16_03_PalabrasUnicas.java
 */
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sol16_03_PalabrasUnicas {

    // Pasa el texto a minúsculas, quita comas y puntos y lo divide en palabras
    static List<String> palabras(String texto) {
        String limpio = texto.toLowerCase().replace(",", "").replace(".", "").strip();
        return List.of(limpio.split(" +"));
    }

    // add devuelve false si ya estaba: así se detectan las repetidas
    static Set<String> repetidas(List<String> palabras) {
        Set<String> vistas = new LinkedHashSet<>();
        Set<String> repetidas = new TreeSet<>();
        for (String palabra : palabras) {
            if (!vistas.add(palabra)) {
                repetidas.add(palabra);
            }
        }
        return repetidas;
    }

    public static void main(String[] args) {
        String texto1 = "El sol sale por el este y el sol se pone por el oeste.";
        String texto2 = "La luna sale por la noche y se pone por la mañana.";

        List<String> lista1 = palabras(texto1);
        List<String> lista2 = palabras(texto2);

        // El mismo contenido, con tres órdenes distintos según la implementación
        Set<String> enOrden = new LinkedHashSet<>(lista1);       // Orden de aparición
        Set<String> alfabetico = new TreeSet<>(lista1);          // Ordenado

        System.out.println("Texto 1: " + lista1.size() + " palabras, " + enOrden.size() + " distintas");
        System.out.println("En orden de aparición: " + enOrden);
        System.out.println("En orden alfabético:   " + alfabetico);
        System.out.println("Repetidas en el texto 1: " + repetidas(lista1));

        // Operaciones de conjuntos: se copia antes porque modifican el conjunto
        Set<String> set1 = new TreeSet<>(lista1);
        Set<String> set2 = new TreeSet<>(lista2);

        Set<String> comunes = new TreeSet<>(set1);
        comunes.retainAll(set2);
        Set<String> solo1 = new TreeSet<>(set1);
        solo1.removeAll(set2);
        Set<String> solo2 = new TreeSet<>(set2);
        solo2.removeAll(set1);

        System.out.println("En los dos textos: " + comunes);
        System.out.println("Solo en el texto 1: " + solo1);
        System.out.println("Solo en el texto 2: " + solo2);
    }
}
