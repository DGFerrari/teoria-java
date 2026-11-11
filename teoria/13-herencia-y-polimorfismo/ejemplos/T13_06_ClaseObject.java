/*
 * TEMA 13 · Herencia y polimorfismo
 * Ejemplo 06: LA CLASE Object: toString, equals Y hashCode
 *
 * Cómo ejecutarlo:  java T13_06_ClaseObject.java
 */
import java.util.Objects;

public class T13_06_ClaseObject {

    // Sin sobrescribir nada: usa los métodos de Object
    static class LibroSinMetodos {
        private final String isbn;
        private final String titulo;

        public LibroSinMetodos(String isbn, String titulo) {
            this.isbn = isbn;
            this.titulo = titulo;
        }
    }

    // Con toString, equals y hashCode sobrescritos
    static class Libro {
        private final String isbn;
        private final String titulo;
        private final int paginas;

        public Libro(String isbn, String titulo, int paginas) {
            this.isbn = isbn;
            this.titulo = titulo;
            this.paginas = paginas;
        }

        @Override
        public String toString() {
            return "\"" + titulo + "\" (ISBN " + isbn + ", " + paginas + " págs.)";
        }

        // Dos libros son iguales si tienen el mismo ISBN (lo decidimos nosotros)
        @Override
        public boolean equals(Object otro) {          // ¡El parámetro es Object!
            if (this == otro) {
                return true;                          // Es el mismo objeto
            }
            if (!(otro instanceof Libro libro)) {
                return false;                         // null o de otro tipo
            }
            return isbn.equals(libro.isbn);
        }

        // Si dos objetos son equals, DEBEN tener el mismo hashCode: mismos atributos que en equals
        @Override
        public int hashCode() {
            return Objects.hash(isbn);
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Lo que heredamos de Object sin hacer nada
        // ------------------------------------------------------------
        LibroSinMetodos s1 = new LibroSinMetodos("978-84-376-0494-7", "Cien años de soledad");
        LibroSinMetodos s2 = new LibroSinMetodos("978-84-376-0494-7", "Cien años de soledad");

        System.out.println("toString por defecto: " + s1);
        System.out.println("equals por defecto (igual que ==): " + s1.equals(s2));    // false
        System.out.println("hashCode: " + s1.hashCode() + " y " + s2.hashCode());     // Distintos
        System.out.println();

        // ------------------------------------------------------------
        // 2. Con los métodos sobrescritos
        // ------------------------------------------------------------
        Libro a = new Libro("978-84-376-0494-7", "Cien años de soledad", 471);
        Libro b = new Libro("978-84-376-0494-7", "Cien Años De Soledad (edición de bolsillo)", 496);
        Libro c = new Libro("978-84-204-8318-1", "La sombra del viento", 565);

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("a == b      → " + (a == b));            // false: objetos distintos
        System.out.println("a.equals(b) → " + a.equals(b));         // true: mismo ISBN
        System.out.println("a.equals(c) → " + a.equals(c));         // false
        System.out.println("a.equals(null) → " + a.equals(null));   // false, sin NullPointerException
        System.out.println("a.equals(\"texto\") → " + a.equals("texto"));   // false: otro tipo
        System.out.println("hashCode de a y b: " + a.hashCode() + " y " + b.hashCode() + " (iguales)");
        System.out.println();

        // ------------------------------------------------------------
        // 3. Un uso típico: buscar en un array con equals
        // ------------------------------------------------------------
        Libro[] estanteria = {c, a};
        Libro buscado = new Libro("978-84-376-0494-7", "", 0);      // Solo sabemos el ISBN
        boolean loTenemos = false;
        for (int i = 0; i < estanteria.length && !loTenemos; i++) {
            loTenemos = estanteria[i].equals(buscado);
        }
        System.out.println("¿Tenemos el libro con ISBN 978-84-376-0494-7? " + loTenemos);

        // Todos los objetos son Object: un array de Object admite cualquier cosa
        Object[] cosas = {a, "un texto", 42, 3.5};
        for (Object o : cosas) {
            System.out.println("  " + o + " → clase " + o.getClass().getSimpleName());
        }
        // (42 y 3.5 se guardan como objetos Integer y Double: lo verás en el tema 16)
    }
}
