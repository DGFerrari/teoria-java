/*
 * TEMA 14 · Ejercicio 03 · Ranking de jugadores  (dificultad: 3/5)
 *
 * Objetivo: implementar Comparable con varios criterios de ordenación.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej14_03_RankingDeJugadores.java
 */
import java.util.Arrays;

public class Ej14_03_RankingDeJugadores {

    // TODO 1: haz que Jugador implemente Comparable<Jugador>
    static class Jugador {
        private final String nombre;
        private final int puntos;
        private final int partidas;

        Jugador(String nombre, int puntos, int partidas) {
            this.nombre = nombre;
            this.puntos = puntos;
            this.partidas = partidas;
        }

        public String getNombre() {
            return nombre;
        }

        // TODO 2: compareTo → más puntos primero; si empatan, menos partidas;
        //         si siguen empatados, nombre alfabético.
        public int compareTo(Jugador otro) {
            return 0;
        }

        @Override
        public String toString() {
            return String.format("%-6s %4d pts · %2d partidas", nombre, puntos, partidas);
        }
    }

    // NO TOCAR
    public static void main(String[] args) {
        Jugador[] jugadores = {
                new Jugador("Lucía", 120, 10),
                new Jugador("Bruno", 95, 8),
                new Jugador("Carla", 120, 12),
                new Jugador("Diego", 120, 10),
                new Jugador("Elena", 60, 5),
                new Jugador("Fran", 95, 8)
        };

        System.out.println("Diego.compareTo(Carla) = " + jugadores[3].compareTo(jugadores[2]) + " → Diego va antes");
        System.out.println("Bruno.compareTo(Fran)  = " + jugadores[1].compareTo(jugadores[5]) + " → Bruno va antes");

        Arrays.sort(jugadores);

        System.out.println("=== Clasificación ===");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println((i + 1) + ". " + jugadores[i]);
        }

        String[] medallas = {"🥇", "🥈", "🥉"};
        System.out.println("=== Podio ===");
        for (int i = 0; i < medallas.length && i < jugadores.length; i++) {
            System.out.println(medallas[i] + " " + jugadores[i].getNombre());
        }
    }
}
