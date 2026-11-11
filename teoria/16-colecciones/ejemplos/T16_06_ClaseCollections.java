/*
 * TEMA 16 · Colecciones
 * Ejemplo 06: la clase Collections (ordenar, invertir, desordenar, analizar)
 *
 * Cómo ejecutarlo:  java T16_06_ClaseCollections.java
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class T16_06_ClaseCollections {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Ordenar, invertir y desordenar
        // ------------------------------------------------------------
        List<Integer> numeros = new ArrayList<>(List.of(42, 7, 19, 3, 25, 7));
        System.out.println("1. Original:  " + numeros);
        Collections.sort(numeros);
        System.out.println("   Ordenada:  " + numeros);
        Collections.reverse(numeros);
        System.out.println("   Invertida: " + numeros);
        Collections.shuffle(numeros, new Random(42));     // Con semilla: siempre el mismo "azar"
        System.out.println("   Barajada:  " + numeros);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Analizar
        // ------------------------------------------------------------
        System.out.println("2. Máximo: " + Collections.max(numeros) + " · mínimo: " + Collections.min(numeros));
        System.out.println("   ¿Cuántos 7? " + Collections.frequency(numeros, 7));
        Collections.swap(numeros, 0, numeros.size() - 1);
        System.out.println("   Primero y último intercambiados: " + numeros);
        System.out.println();

        // ------------------------------------------------------------
        // 3. Textos: orden alfabético (¡cuidado con mayúsculas y tildes!)
        // ------------------------------------------------------------
        List<String> nombres = new ArrayList<>(List.of("marta", "Ana", "Óscar", "luis", "Bea"));
        Collections.sort(nombres);
        System.out.println("3. Orden de String.compareTo: " + nombres);
        System.out.println("   (primero mayúsculas, luego minúsculas y al final las letras con tilde)");
        System.out.println();

        // ------------------------------------------------------------
        // 4. Objetos propios: sort, max y min usan compareTo (Comparable)
        // ------------------------------------------------------------
        List<Corredor> carrera = new ArrayList<>();
        carrera.add(new Corredor("Lucía", 2_412));
        carrera.add(new Corredor("Diego", 2_398));
        carrera.add(new Corredor("Irene", 2_455));
        carrera.add(new Corredor("Hugo", 2_401));
        Collections.sort(carrera);
        System.out.println("4. Clasificación:");
        for (int i = 0; i < carrera.size(); i++) {
            System.out.println("   " + (i + 1) + "º " + carrera.get(i));
        }
        System.out.println("   Ganador: " + Collections.min(carrera).getNombre());
        System.out.println();

        // ------------------------------------------------------------
        // 5. Vista de solo lectura (para getters que no deben dejar modificar)
        // ------------------------------------------------------------
        List<Corredor> soloLectura = Collections.unmodifiableList(carrera);
        try {
            soloLectura.clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("5. 💥 UnsupportedOperationException: la vista no se puede modificar");
        }
        System.out.println("   La original sigue intacta: " + carrera.size() + " corredores");
    }

    static class Corredor implements Comparable<Corredor> {
        private final String nombre;
        private final int segundos;

        Corredor(String nombre, int segundos) {
            this.nombre = nombre;
            this.segundos = segundos;
        }

        String getNombre() {
            return nombre;
        }

        @Override
        public int compareTo(Corredor otro) {
            return Integer.compare(segundos, otro.segundos);   // Menos tiempo, mejor puesto
        }

        @Override
        public String toString() {
            return String.format("%-6s %d:%02d", nombre, segundos / 60, segundos % 60);
        }
    }
}
