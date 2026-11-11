/*
 * TEMA 14 · Abstracción e interfaces
 * Ejemplo 04: Comparable (enseñar a Java a ordenar tus objetos)
 *
 * Cómo ejecutarlo:  java T14_04_Comparable.java
 */
import java.util.Arrays;

public class T14_04_Comparable {

    // Sin Comparable, Arrays.sort no sabe ordenar
    static class Producto {
        final String nombre;

        Producto(String nombre) {
            this.nombre = nombre;
        }
    }

    // Con Comparable<Alumno>: "los alumnos se pueden comparar con otros alumnos"
    static class Alumno implements Comparable<Alumno> {
        private final String nombre;
        private final double nota;

        Alumno(String nombre, double nota) {
            this.nombre = nombre;
            this.nota = nota;
        }

        // Negativo: this va antes | 0: empate | positivo: this va después
        @Override
        public int compareTo(Alumno otro) {
            int porNota = Double.compare(otro.nota, this.nota);   // otro primero → de MAYOR a menor
            if (porNota != 0) {
                return porNota;
            } else {
                return this.nombre.compareTo(otro.nombre);        // Desempate: orden alfabético
            }
        }

        @Override
        public String toString() {
            return String.format("%-6s %5.2f", nombre, nota);
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. compareTo a mano
        // ------------------------------------------------------------
        Alumno ana = new Alumno("Ana", 8.5);
        Alumno luis = new Alumno("Luis", 6.0);
        System.out.println("ana.compareTo(luis) = " + ana.compareTo(luis) + " → Ana va antes (más nota)");
        System.out.println("luis.compareTo(ana) = " + luis.compareTo(ana) + " → Luis va después");
        System.out.println();

        // ------------------------------------------------------------
        // 2. Arrays.sort usa compareTo
        // ------------------------------------------------------------
        Alumno[] clase = {
                new Alumno("Luis", 6.0),
                new Alumno("Marta", 9.25),
                new Alumno("Ana", 8.5),
                new Alumno("Pablo", 8.5),
                new Alumno("Eva", 4.75)
        };

        Arrays.sort(clase);
        System.out.println("=== Ranking ===");
        for (int i = 0; i < clase.length; i++) {
            System.out.println((i + 1) + ". " + clase[i]);
        }
        // Ana y Pablo empatan a 8.5: el desempate por nombre pone a Ana primero.
        System.out.println();

        // ------------------------------------------------------------
        // 3. String, Integer, Double... ya implementan Comparable
        // ------------------------------------------------------------
        String[] palabras = {"pera", "Manzana", "uva", "kiwi"};
        Arrays.sort(palabras);
        System.out.println("Palabras ordenadas: " + Arrays.toString(palabras));   // Mayúsculas primero

        // ------------------------------------------------------------
        // 4. Sin Comparable: error al ejecutar
        // ------------------------------------------------------------
        Producto[] productos = {new Producto("B"), new Producto("A")};
        // Arrays.sort(productos);
        // ❌ ClassCastException: Producto cannot be cast to class java.lang.Comparable
        System.out.println("Hay " + productos.length + " productos sin orden definido");

        // ⚠️ No compares double restando: (int) (8.6 - 8.5) = 0 → los daría por iguales.
        //    Usa Double.compare / Integer.compare.

        // PRUEBA: cambia compareTo para ordenar por nombre de la Z a la A.
    }
}
