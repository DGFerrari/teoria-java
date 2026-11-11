/*
 * TEMA 16 · Ejercicio 05 · Gestor de biblioteca  (dificultad: 5/5)
 *
 * Objetivo: combinar varias colecciones (Map de objetos, Map de listas, colas) en un mismo programa.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej16_05_GestorDeBiblioteca.java
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ej16_05_GestorDeBiblioteca {

    // NO TOCAR: la clase Libro ya está hecha
    static class Libro {
        private final String isbn;
        private final String titulo;
        private final String autor;
        private String prestadoA;                    // null = disponible

        Libro(String isbn, String titulo, String autor) {
            this.isbn = isbn;
            this.titulo = titulo;
            this.autor = autor;
        }

        String getIsbn() {
            return isbn;
        }

        String getTitulo() {
            return titulo;
        }

        String getPrestadoA() {
            return prestadoA;
        }

        void setPrestadoA(String socio) {
            this.prestadoA = socio;
        }

        @Override
        public String toString() {
            return isbn + " · " + titulo + " · " + autor;
        }
    }

    static class Biblioteca {
        private static final int MAX_PRESTAMOS = 2;

        private final Map<String, Libro> catalogo = new LinkedHashMap<>();        // ISBN → libro
        private final Map<String, List<String>> prestamos = new TreeMap<>();      // socio → ISBN que tiene
        private final Map<String, Deque<String>> esperas = new HashMap<>();       // ISBN → cola de socios

        // TODO 1: guarda el libro en el catálogo y crea su cola de espera (vacía)
        void agregarLibro(Libro libro) {
        }

        // TODO 2: (privado) devuelve la lista de ISBN del socio, creándola si no existe
        // TODO 3: (privado) entregar(socio, libro): marca el libro como prestado y lo añade a la lista del socio

        // TODO 4: aplica las reglas EN ESTE ORDEN y devuelve el mensaje (mira el ENUNCIADO):
        //   el libro no existe / el socio ya lo tiene / el socio ya tiene el máximo /
        //   está disponible (se presta) / está prestado (a la cola, si no estaba ya)
        String prestar(String socio, String isbn) {
            return "";
        }

        // TODO 5: si el socio lo tiene, lo devuelve y el libro pasa al primero de la cola que
        //         pueda llevárselo (los que ya tienen el máximo pierden su turno). Usa una bandera.
        String devolver(String socio, String isbn) {
            return "";
        }

        // TODO 6: préstamos por socio (con títulos, o "(ninguno)") y estado de cada libro del catálogo
        void mostrarInforme() {
        }
    }

    public static void main(String[] args) {
        // NO TOCAR: el catálogo, las operaciones y su procesamiento
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Libro("978-1", "El Quijote", "Miguel de Cervantes"));
        biblioteca.agregarLibro(new Libro("978-2", "Dune", "Frank Herbert"));
        biblioteca.agregarLibro(new Libro("978-3", "1984", "George Orwell"));
        biblioteca.agregarLibro(new Libro("978-4", "Matilda", "Roald Dahl"));
        biblioteca.agregarLibro(new Libro("978-5", "Momo", "Michael Ende"));

        String operaciones = """
                PRESTAR;Ana;978-2
                PRESTAR;Luis;978-2
                PRESTAR;Marta;978-2
                PRESTAR;Luis;978-9
                PRESTAR;Ana;978-1
                PRESTAR;Ana;978-3
                PRESTAR;Marta;978-3
                PRESTAR;Marta;978-4
                DEVOLVER;Luis;978-1
                DEVOLVER;Ana;978-2
                PRESTAR;Ana;978-2
                DEVOLVER;Luis;978-2
                PRESTAR;Ana;978-2
                PRESTAR;Luis;978-3
                RENOVAR;Ana;978-1
                """;

        try (Scanner lector = new Scanner(operaciones)) {
            int numero = 0;
            while (lector.hasNextLine()) {
                String[] partes = lector.nextLine().split(";");
                numero++;
                String resultado = switch (partes[0]) {
                    case "PRESTAR" -> biblioteca.prestar(partes[1], partes[2]);
                    case "DEVOLVER" -> biblioteca.devolver(partes[1], partes[2]);
                    default -> "✘ Operación desconocida: " + partes[0];
                };
                System.out.printf("%2d. %s%n", numero, resultado);
            }
        }
        biblioteca.mostrarInforme();
    }
}
