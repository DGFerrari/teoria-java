/*
 * TEMA 16 · Colecciones
 * Ejemplo 02: recorrer listas, borrar mientras se recorre y listas inmutables
 *
 * Cómo ejecutarlo:  java T16_02_RecorrerListas.java
 */
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class T16_02_RecorrerListas {

    public static void main(String[] args) {
        List<String> ciudades = new ArrayList<>(List.of("Madrid", "Sevilla", "Bilbao", "Valencia"));

        // ------------------------------------------------------------
        // 1. for con índice: cuando necesitas la posición
        // ------------------------------------------------------------
        System.out.println("1. Con índice:");
        for (int i = 0; i < ciudades.size(); i++) {          // size(), no length
            System.out.println("   " + (i + 1) + ". " + ciudades.get(i));
        }

        // ------------------------------------------------------------
        // 2. for-each: lo más habitual
        // ------------------------------------------------------------
        System.out.print("2. Con for-each:");
        for (String ciudad : ciudades) {
            System.out.print(" " + ciudad.toUpperCase());
        }
        System.out.println();
        System.out.println();

        // ------------------------------------------------------------
        // 3. ❌ Borrar dentro de un for-each
        // ------------------------------------------------------------
        List<Integer> notas = new ArrayList<>(List.of(7, 3, 9, 4, 5, 2, 8));
        System.out.println("3. Notas: " + notas);
        try {
            for (int nota : notas) {
                if (nota < 5) {
                    notas.remove(Integer.valueOf(nota));     // Modifica la lista mientras se recorre
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("   💥 ConcurrentModificationException al borrar dentro del for-each");
        }
        System.out.println("   La lista ha quedado a medias: " + notas);
        System.out.println();

        // ------------------------------------------------------------
        // 4. ✅ Borrar con un Iterator
        // ------------------------------------------------------------
        notas = new ArrayList<>(List.of(7, 3, 9, 4, 5, 2, 8));
        Iterator<Integer> it = notas.iterator();
        while (it.hasNext()) {
            int nota = it.next();
            if (nota < 5) {
                it.remove();                                 // Borra el último devuelto por next()
            }
        }
        System.out.println("4. Aprobados (con Iterator): " + notas);
        System.out.println();

        // ------------------------------------------------------------
        // 5. Listas inmutables con List.of
        // ------------------------------------------------------------
        List<String> dias = List.of("lunes", "martes", "miércoles", "jueves", "viernes");
        System.out.println("5. Días lectivos: " + dias);
        try {
            dias.add("sábado");
        } catch (UnsupportedOperationException e) {
            System.out.println("   💥 UnsupportedOperationException: List.of no se puede modificar");
        }
        List<String> semana = new ArrayList<>(dias);         // Copia modificable
        semana.add("sábado");
        semana.add("domingo");
        System.out.println("   Copia modificable: " + semana);
        System.out.println();

        // ------------------------------------------------------------
        // 6. Una lista de objetos propios
        // ------------------------------------------------------------
        List<Alumno> clase = new ArrayList<>();
        clase.add(new Alumno("Ana", 8.5));
        clase.add(new Alumno("Luis", 4.0));
        clase.add(new Alumno("Marta", 6.25));
        double suma = 0;
        for (Alumno alumno : clase) {
            suma += alumno.getNota();
        }
        System.out.println("6. " + clase);
        System.out.printf("   Media de la clase: %.2f%n", suma / clase.size());
    }

    static class Alumno {
        private final String nombre;
        private final double nota;

        Alumno(String nombre, double nota) {
            this.nombre = nombre;
            this.nota = nota;
        }

        double getNota() {
            return nota;
        }

        @Override
        public String toString() {                           // El toString de la lista usa este
            return nombre + " (" + nota + ")";
        }
    }
}
