/*
 * TEMA 17 · Ejercicio 03 · Utilidades genéricas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol17_03_UtilidadesGenericas.java
 */
import java.util.ArrayList;
import java.util.List;

public class Sol17_03_UtilidadesGenericas {

    static <T> int contar(List<T> lista, T buscado) {
        int veces = 0;
        for (T elemento : lista) {
            if (elemento.equals(buscado)) {
                veces++;
            }
        }
        return veces;
    }

    // Conserva el orden de la primera aparición
    static <T> List<T> sinDuplicados(List<T> lista) {
        List<T> resultado = new ArrayList<>();
        for (T elemento : lista) {
            if (!resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    // Lista NUEVA; la original no cambia
    static <T> List<T> invertida(List<T> lista) {
        List<T> resultado = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            resultado.add(lista.get(i));
        }
        return resultado;
    }

    // Acotado: T tiene que poder compararse. null si la lista está vacía
    static <T extends Comparable<T>> T maximo(List<T> lista) {
        T mayor = null;
        for (T elemento : lista) {
            if (mayor == null || elemento.compareTo(mayor) > 0) {
                mayor = elemento;
            }
        }
        return mayor;
    }

    static <T extends Comparable<T>> boolean estaOrdenada(List<T> lista) {
        boolean ordenada = true;
        for (int i = 0; i < lista.size() - 1 && ordenada; i++) {
            ordenada = lista.get(i).compareTo(lista.get(i + 1)) <= 0;
        }
        return ordenada;
    }

    // Acotado: T tiene que ser un número
    static <T extends Number> double media(List<T> lista) {
        double suma = 0;
        for (T numero : lista) {
            suma += numero.doubleValue();
        }
        return lista.isEmpty() ? 0 : suma / lista.size();
    }

    public static void main(String[] args) {
        List<String> votos = List.of("sí", "no", "sí", "abstención", "sí", "no");
        System.out.println("Votos: " + votos);
        System.out.println("  \"sí\" aparece " + contar(votos, "sí") + " veces");
        System.out.println("  Sin duplicados: " + sinDuplicados(votos));
        System.out.println("  Invertida: " + invertida(votos));
        System.out.println("  Máximo (alfabético): " + maximo(votos));
        System.out.println("  ¿Ordenada? " + estaOrdenada(votos));

        List<Integer> dados = List.of(3, 6, 1, 6, 2, 6);
        System.out.println("Dados: " + dados);
        System.out.println("  El 6 aparece " + contar(dados, 6) + " veces");
        System.out.println("  Sin duplicados: " + sinDuplicados(dados));
        System.out.println("  Máximo: " + maximo(dados));
        System.out.printf("  Media: %.2f%n", media(dados));
        System.out.println("  ¿Ordenada? " + estaOrdenada(dados));

        List<Integer> anios = List.of(1969, 1989, 2001, 2024);
        System.out.println("Años: " + anios);
        System.out.println("  ¿Ordenada? " + estaOrdenada(anios));
        System.out.printf("  Media: %.2f%n", media(anios));

        List<Double> vacia = new ArrayList<>();
        System.out.println("Lista vacía → máximo: " + maximo(vacia));
    }
}
