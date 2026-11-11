/*
 * TEMA 16 · Colecciones
 * Ejemplo 03: conjuntos (Set) - sin duplicados
 *
 * Cómo ejecutarlo:  java T16_03_Conjuntos.java
 */
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class T16_03_Conjuntos {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Un Set no admite duplicados
        // ------------------------------------------------------------
        Set<String> votantes = new HashSet<>();
        System.out.println("1. add(\"Ana\")  → " + votantes.add("Ana"));
        System.out.println("   add(\"Luis\") → " + votantes.add("Luis"));
        System.out.println("   add(\"Ana\")  → " + votantes.add("Ana") + " (ya estaba)");
        System.out.println("   Tamaño: " + votantes.size());
        System.out.println("   ¿Ha votado Luis? " + votantes.contains("Luis"));
        System.out.println();

        // ------------------------------------------------------------
        // 2. Tres implementaciones, tres órdenes distintos
        // ------------------------------------------------------------
        List<String> frutas = List.of("pera", "manzana", "kiwi", "pera", "uva", "manzana", "fresa");
        System.out.println("2. Original:    " + frutas);
        System.out.println("   LinkedHashSet: " + new LinkedHashSet<>(frutas) + "  ← orden de inserción");
        System.out.println("   TreeSet:       " + new TreeSet<>(frutas) + "  ← ordenado");
        System.out.println("   HashSet:       " + new HashSet<>(frutas).size() + " elementos, en un orden que no está garantizado");
        System.out.println();

        // ------------------------------------------------------------
        // 3. Operaciones de conjuntos (copiando antes, porque modifican)
        // ------------------------------------------------------------
        Set<String> anaSabe = new TreeSet<>(List.of("java", "python", "sql", "html"));
        Set<String> luisSabe = new TreeSet<>(List.of("python", "c", "sql"));

        Set<String> union = new TreeSet<>(anaSabe);
        union.addAll(luisSabe);
        Set<String> comunes = new TreeSet<>(anaSabe);
        comunes.retainAll(luisSabe);
        Set<String> soloAna = new TreeSet<>(anaSabe);
        soloAna.removeAll(luisSabe);

        System.out.println("3. Ana:  " + anaSabe);
        System.out.println("   Luis: " + luisSabe);
        System.out.println("   Entre los dos (unión):     " + union);
        System.out.println("   Los dos (intersección):    " + comunes);
        System.out.println("   Solo Ana (diferencia):     " + soloAna);
        System.out.println("   ¿Ana sabe todo lo común?   " + anaSabe.containsAll(comunes));
        System.out.println();

        // ------------------------------------------------------------
        // 4. Objetos propios: HashSet usa equals y hashCode
        // ------------------------------------------------------------
        Set<PuntoSinEquals> malos = new HashSet<>();
        malos.add(new PuntoSinEquals(1, 2));
        malos.add(new PuntoSinEquals(1, 2));
        Set<Punto> buenos = new HashSet<>();
        buenos.add(new Punto(1, 2));
        buenos.add(new Punto(1, 2));
        System.out.println("4. Sin equals/hashCode: " + malos.size() + " puntos (¡duplicado!)");
        System.out.println("   Con equals/hashCode: " + buenos.size() + " punto");
        System.out.println();

        // ------------------------------------------------------------
        // 5. TreeSet con números: ordenado y con métodos de "vecindad"
        // ------------------------------------------------------------
        TreeSet<Integer> puntuaciones = new TreeSet<>(List.of(70, 95, 40, 88, 95, 62));
        System.out.println("5. Puntuaciones distintas: " + puntuaciones);
        System.out.println("   La más baja: " + puntuaciones.first() + " · la más alta: " + puntuaciones.last());
        System.out.println("   La primera por encima de 80: " + puntuaciones.higher(80));
    }

    static class PuntoSinEquals {
        private final int x;
        private final int y;

        PuntoSinEquals(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Punto {
        private final int x;
        private final int y;

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object otro) {
            boolean iguales = false;
            if (otro instanceof Punto p) {
                iguales = x == p.x && y == p.y;
            }
            return iguales;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
