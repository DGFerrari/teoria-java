/*
 * TEMA 14 · Ejercicio 03 · Ranking de jugadores  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol14_03_RankingDeJugadores.java
 */
import java.util.Arrays;

public class Sol14_03_RankingDeJugadores {

    static class Jugador implements Comparable<Jugador> {
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

        // Criterios en cascada: solo se mira el siguiente si el anterior empata
        @Override
        public int compareTo(Jugador otro) {
            int resultado = Integer.compare(otro.puntos, this.puntos);       // Más puntos primero
            if (resultado == 0) {
                resultado = Integer.compare(this.partidas, otro.partidas);   // Menos partidas primero
            }
            if (resultado == 0) {
                resultado = this.nombre.compareTo(otro.nombre);              // Alfabético
            }
            return resultado;
        }

        @Override
        public String toString() {
            return String.format("%-6s %4d pts · %2d partidas", nombre, puntos, partidas);
        }
    }

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
