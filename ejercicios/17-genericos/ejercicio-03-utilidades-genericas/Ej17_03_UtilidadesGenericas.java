/*
 * TEMA 17 · Ejercicio 03 · Utilidades genéricas  (dificultad: 3/5)
 *
 * Objetivo: escribir métodos genéricos, algunos con tipos acotados.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej17_03_UtilidadesGenericas.java
 */
import java.util.ArrayList;
import java.util.List;

public class Ej17_03_UtilidadesGenericas {

    // TODO 1: cuántas veces aparece "buscado" en la lista (equals)
    static <T> int contar(List<T> lista, T buscado) {
        return 0;
    }

    // TODO 2: lista NUEVA sin repetidos, en el orden de la primera aparición
    static <T> List<T> sinDuplicados(List<T> lista) {
        return new ArrayList<>();
    }

    // TODO 3: lista NUEVA con los elementos al revés
    static <T> List<T> invertida(List<T> lista) {
        return new ArrayList<>();
    }

    // TODO 4: el mayor elemento, o null si la lista está vacía.
    //         Cambia <T> por el tipo acotado adecuado para poder usar compareTo
    static <T> T maximo(List<T> lista) {
        return null;
    }

    // TODO 5: ¿cada elemento es menor o igual que el siguiente? (con bandera; acota el tipo)
    static <T> boolean estaOrdenada(List<T> lista) {
        return false;
    }

    // TODO 6: la media, o 0 si está vacía. Acota el tipo para poder usar doubleValue()
    static <T> double media(List<T> lista) {
        return 0;
    }

    public static void main(String[] args) {
        // NO TOCAR: los datos
        List<String> votos = List.of("sí", "no", "sí", "abstención", "sí", "no");
        List<Integer> dados = List.of(3, 6, 1, 6, 2, 6);
        List<Integer> anios = List.of(1969, 1989, 2001, 2024);
        List<Double> vacia = new ArrayList<>();

        // TODO 7: muestra los resultados como en la salida esperada
    }
}
