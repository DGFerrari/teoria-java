/*
 * TEMA 17 · Genéricos
 * Ejemplo 02: clases genéricas con uno y varios parámetros de tipo
 *
 * Cómo ejecutarlo:  java T17_02_ClasesGenericas.java
 */
import java.util.ArrayList;
import java.util.List;

public class T17_02_ClasesGenericas {

    // Un parámetro de tipo
    static class Caja<T> {
        private T contenido;

        Caja(T contenido) {
            this.contenido = contenido;
        }

        T getContenido() {
            return contenido;
        }

        void setContenido(T contenido) {
            this.contenido = contenido;
        }

        boolean estaVacia() {
            return contenido == null;
        }

        @Override
        public String toString() {
            return estaVacia() ? "Caja vacía" : "Caja con: " + contenido;
        }
    }

    // Dos parámetros de tipo, inmutable
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

        // Devuelve un Par con los tipos intercambiados
        Par<B, A> invertir() {
            return new Par<>(segundo, primero);
        }

        @Override
        public String toString() {
            return "(" + primero + ", " + segundo + ")";
        }
    }

    // Una clase genérica que guarda sus elementos en una colección
    static class Historial<T> {
        private final List<T> elementos = new ArrayList<>();
        private final int capacidad;

        Historial(int capacidad) {
            this.capacidad = capacidad;
        }

        void registrar(T elemento) {
            if (elementos.size() == capacidad) {
                elementos.remove(0);                    // Se olvida el más antiguo
            }
            elementos.add(elemento);
        }

        T ultimo() {
            T resultado = null;
            if (!elementos.isEmpty()) {
                resultado = elementos.get(elementos.size() - 1);
            }
            return resultado;
        }

        @Override
        public String toString() {
            return elementos.toString();
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. La misma clase con distintos tipos
        // ------------------------------------------------------------
        Caja<String> regalo = new Caja<>("una bufanda");
        Caja<Double> hucha = new Caja<>(12.5);
        Caja<String> vacia = new Caja<>(null);
        System.out.println("1. " + regalo + " · " + hucha + " · " + vacia);
        hucha.setContenido(hucha.getContenido() + 2.5);   // Double: se puede operar
        System.out.println("   Tras meter 2,5 € más: " + hucha);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Dos parámetros de tipo
        // ------------------------------------------------------------
        Par<String, Integer> alumno = new Par<>("Ana", 15);
        Par<Double, Double> punto = new Par<>(3.5, -2.0);
        String nombre = alumno.getPrimero();              // El compilador sabe que es String
        int edad = alumno.getSegundo();                   // ...y que esto es Integer
        System.out.println("2. " + nombre + " tiene " + edad + " años");
        System.out.println("   Punto: " + punto + " · invertido: " + punto.invertir());
        Par<Integer, String> alReves = alumno.invertir(); // Par<String, Integer> → Par<Integer, String>
        System.out.println("   Par invertido: " + alReves);
        System.out.println();

        // ------------------------------------------------------------
        // 3. Tipos anidados
        // ------------------------------------------------------------
        Par<String, List<Integer>> notas = new Par<>("Luis", List.of(7, 8, 6));
        Caja<Par<String, Integer>> cajaConPar = new Caja<>(alumno);
        System.out.println("3. " + notas.getPrimero() + " tiene " + notas.getSegundo().size() + " notas: " + notas.getSegundo());
        System.out.println("   " + cajaConPar + " → nombre: " + cajaConPar.getContenido().getPrimero());
        System.out.println();

        // ------------------------------------------------------------
        // 4. Una clase genérica con una colección dentro
        // ------------------------------------------------------------
        Historial<String> busquedas = new Historial<>(3);
        busquedas.registrar("java");
        busquedas.registrar("genéricos");
        busquedas.registrar("colecciones");
        busquedas.registrar("lambdas");
        System.out.println("4. Últimas búsquedas: " + busquedas + " · la última: " + busquedas.ultimo());

        Historial<Integer> temperaturas = new Historial<>(2);
        temperaturas.registrar(18);
        temperaturas.registrar(21);
        temperaturas.registrar(19);
        System.out.println("   Últimas temperaturas: " + temperaturas);
    }
}
