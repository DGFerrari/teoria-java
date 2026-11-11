/*
 * TEMA 17 · Ejercicio 02 · Par genérico  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol17_02_ParGenerico.java
 */
import java.util.ArrayList;
import java.util.List;

public class Sol17_02_ParGenerico {

    static class Par<A, B> {
        private final A primero;
        private final B segundo;

        Par(A primero, B segundo) {
            this.primero = primero;
            this.segundo = segundo;
        }

        A getPrimero() {
            return primero;
        }

        B getSegundo() {
            return segundo;
        }

        // Los tipos también se intercambian: Par<A, B> → Par<B, A>
        Par<B, A> invertir() {
            return new Par<>(segundo, primero);
        }

        @Override
        public String toString() {
            return "(" + primero + ", " + segundo + ")";
        }
    }

    // Une dos listas posición a posición, hasta que se acabe la más corta
    static <A, B> List<Par<A, B>> emparejar(List<A> primeros, List<B> segundos) {
        List<Par<A, B>> pares = new ArrayList<>();
        int cuantos = Math.min(primeros.size(), segundos.size());
        for (int i = 0; i < cuantos; i++) {
            pares.add(new Par<>(primeros.get(i), segundos.get(i)));
        }
        return pares;
    }

    // Devuelve el primer par cuyo primer elemento sea "clave", o null si no hay ninguno
    static <A, B> Par<A, B> buscarPorPrimero(List<Par<A, B>> pares, A clave) {
        Par<A, B> encontrado = null;
        for (int i = 0; i < pares.size() && encontrado == null; i++) {
            if (pares.get(i).getPrimero().equals(clave)) {
                encontrado = pares.get(i);
            }
        }
        return encontrado;
    }

    public static void main(String[] args) {
        Par<String, Integer> ana = new Par<>("Ana", 15);
        Par<Integer, String> alReves = ana.invertir();
        System.out.println("Par: " + ana + " → invertido: " + alReves);

        List<String> nombres = List.of("Ana", "Luis", "Marta", "Pablo");
        List<Integer> edades = List.of(15, 17, 16);
        List<Par<String, Integer>> alumnos = emparejar(nombres, edades);
        System.out.println("Emparejados: " + alumnos);

        Par<String, Integer> luis = buscarPorPrimero(alumnos, "Luis");
        System.out.println("Edad de Luis: " + luis.getSegundo());
        System.out.println("¿Y Pablo? " + buscarPorPrimero(alumnos, "Pablo"));

        List<Par<Integer, Character>> coordenadas = emparejar(List.of(1, 2, 3), List.of('A', 'B', 'C', 'D'));
        System.out.println("Coordenadas: " + coordenadas);
    }
}
