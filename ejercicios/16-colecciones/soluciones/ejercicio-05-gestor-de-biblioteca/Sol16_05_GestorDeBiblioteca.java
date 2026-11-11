/*
 * TEMA 16 · Ejercicio 05 · Gestor de biblioteca  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol16_05_GestorDeBiblioteca.java
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

public class Sol16_05_GestorDeBiblioteca {

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

        private final Map<String, Libro> catalogo = new LinkedHashMap<>();        // ISBN → libro (orden de alta)
        private final Map<String, List<String>> prestamos = new TreeMap<>();      // socio → ISBN que tiene (por nombre)
        private final Map<String, Deque<String>> esperas = new HashMap<>();       // ISBN → cola de socios

        void agregarLibro(Libro libro) {
            catalogo.put(libro.getIsbn(), libro);
            esperas.put(libro.getIsbn(), new ArrayDeque<>());
        }

        // Devuelve la lista de préstamos del socio, creándola la primera vez
        private List<String> librosDe(String socio) {
            if (!prestamos.containsKey(socio)) {
                prestamos.put(socio, new ArrayList<>());
            }
            return prestamos.get(socio);
        }

        private void entregar(String socio, Libro libro) {
            libro.setPrestadoA(socio);
            librosDe(socio).add(libro.getIsbn());
        }

        String prestar(String socio, String isbn) {
            String mensaje;
            Libro libro = catalogo.get(isbn);
            if (libro == null) {
                mensaje = "✘ No existe el libro " + isbn;
            } else if (socio.equals(libro.getPrestadoA())) {
                mensaje = "✘ " + socio + " ya tiene «" + libro.getTitulo() + "»";
            } else if (librosDe(socio).size() >= MAX_PRESTAMOS) {
                mensaje = "✘ " + socio + " ya tiene " + MAX_PRESTAMOS + " libros";
            } else if (libro.getPrestadoA() == null) {
                entregar(socio, libro);
                mensaje = "✔ " + socio + " se lleva «" + libro.getTitulo() + "»";
            } else {
                Deque<String> cola = esperas.get(isbn);
                if (cola.contains(socio)) {
                    mensaje = "✘ " + socio + " ya está esperando «" + libro.getTitulo() + "»";
                } else {
                    cola.offer(socio);
                    mensaje = "⏳ " + socio + " espera «" + libro.getTitulo() + "» (posición " + cola.size() + ")";
                }
            }
            return mensaje;
        }

        String devolver(String socio, String isbn) {
            String mensaje;
            Libro libro = catalogo.get(isbn);
            if (libro == null) {
                mensaje = "✘ No existe el libro " + isbn;
            } else if (!socio.equals(libro.getPrestadoA())) {
                mensaje = "✘ " + socio + " no tiene «" + libro.getTitulo() + "»";
            } else {
                librosDe(socio).remove(isbn);
                libro.setPrestadoA(null);
                StringBuilder texto = new StringBuilder("✔ " + socio + " devuelve «" + libro.getTitulo() + "»");

                // Se atiende la cola en orden; quien ya tenga el máximo pierde su turno
                Deque<String> cola = esperas.get(isbn);
                boolean entregado = false;
                while (!cola.isEmpty() && !entregado) {
                    String siguiente = cola.poll();
                    if (librosDe(siguiente).size() < MAX_PRESTAMOS) {
                        entregar(siguiente, libro);
                        texto.append("\n   → Pasa a ").append(siguiente).append(", que estaba esperando");
                        entregado = true;
                    } else {
                        texto.append("\n   (").append(siguiente).append(" pierde su turno: ya tiene ")
                                .append(MAX_PRESTAMOS).append(" libros)");
                    }
                }
                mensaje = texto.toString();
            }
            return mensaje;
        }

        void mostrarInforme() {
            System.out.println("=== Préstamos por socio ===");
            for (Map.Entry<String, List<String>> par : prestamos.entrySet()) {
                List<String> titulos = new ArrayList<>();
                for (String isbn : par.getValue()) {
                    titulos.add(catalogo.get(isbn).getTitulo());
                }
                String lista = titulos.isEmpty() ? "(ninguno)" : String.join(", ", titulos);
                System.out.println(par.getKey() + ": " + lista);
            }

            System.out.println("=== Catálogo ===");
            for (Libro libro : catalogo.values()) {
                String estado = libro.getPrestadoA() == null ? "disponible" : libro.getPrestadoA();
                Deque<String> cola = esperas.get(libro.getIsbn());
                if (!cola.isEmpty()) {
                    estado = estado + " · en espera: " + cola;
                }
                System.out.println(libro + " → " + estado);
            }
        }
    }

    public static void main(String[] args) {
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
