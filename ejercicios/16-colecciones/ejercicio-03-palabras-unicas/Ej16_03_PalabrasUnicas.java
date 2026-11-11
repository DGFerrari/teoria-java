/*
 * TEMA 16 · Ejercicio 03 · Palabras únicas  (dificultad: 3/5)
 *
 * Objetivo: usar LinkedHashSet, TreeSet y las operaciones de conjuntos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej16_03_PalabrasUnicas.java
 */
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Ej16_03_PalabrasUnicas {

    // NO TOCAR: pasa el texto a minúsculas, quita comas y puntos y lo divide en palabras
    static List<String> palabras(String texto) {
        String limpio = texto.toLowerCase().replace(",", "").replace(".", "").strip();
        return List.of(limpio.split(" +"));
    }

    // TODO 1: devuelve un TreeSet con las palabras que aparecen MÁS DE UNA VEZ.
    //         Pista: add() de un Set devuelve false si el elemento ya estaba.
    static Set<String> repetidas(List<String> palabras) {
        return new TreeSet<>();
    }

    public static void main(String[] args) {
        // NO TOCAR: los textos
        String texto1 = "El sol sale por el este y el sol se pone por el oeste.";
        String texto2 = "La luna sale por la noche y se pone por la mañana.";

        List<String> lista1 = palabras(texto1);
        List<String> lista2 = palabras(texto2);

        // TODO 2: muestra cuántas palabras tiene el texto 1 y cuántas son distintas,
        //         las distintas en orden de aparición (LinkedHashSet) y en orden alfabético (TreeSet)

        // TODO 3: muestra las repetidas del texto 1

        // TODO 4: con TreeSet, calcula las palabras que están en los dos textos,
        //         las que solo están en el 1 y las que solo están en el 2
    }
}
