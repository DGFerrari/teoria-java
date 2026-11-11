/*
 * TEMA 19 · Ejercicio 02 · Ordenar con Comparator  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol19_02_OrdenarConComparator.java
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Sol19_02_OrdenarConComparator {

    record Jugador(String nombre, String equipo, int goles, int partidos) {
        double promedio() {
            return (double) goles / partidos;
        }
    }

    // Muestra la lista con el formato que se le pase como función
    static void mostrar(String titulo, List<Jugador> jugadores, Function<Jugador, String> formato) {
        List<String> textos = new ArrayList<>();
        jugadores.forEach(j -> textos.add(formato.apply(j)));
        System.out.println(titulo + ": " + String.join(", ", textos));
    }

    public static void main(String[] args) {
        List<Jugador> jugadores = new ArrayList<>(List.of(
                new Jugador("Lucía", "Rayo", 12, 15),
                new Jugador("Andrés", "Atlético", 18, 20),
                new Jugador("Carla", "Rayo", 18, 22),
                new Jugador("Diego", "Betis", 7, 6),
                new Jugador("Elena", "Atlético", 12, 10)));

        jugadores.sort(Comparator.comparing(Jugador::nombre));
        mostrar("Por nombre", jugadores, Jugador::nombre);

        jugadores.sort(Comparator.comparingInt(Jugador::goles).reversed().thenComparing(Jugador::nombre));
        mostrar("Por goles", jugadores, j -> j.nombre() + " (" + j.goles() + ")");

        jugadores.sort(Comparator.comparing(Jugador::equipo)
                .thenComparing(Comparator.comparingInt(Jugador::goles).reversed()));
        mostrar("Por equipo y goles", jugadores, j -> j.nombre() + " (" + j.equipo() + ", " + j.goles() + ")");

        jugadores.sort(Comparator.comparingDouble(Jugador::promedio).reversed());
        mostrar("Por promedio", jugadores, j -> String.format("%s (%.2f)", j.nombre(), j.promedio()));

        // Más goles; si empatan, gana el de MENOS partidos
        Comparator<Jugador> mejorGoleador = Comparator.comparingInt(Jugador::goles)
                .thenComparing(Comparator.comparingInt(Jugador::partidos).reversed());
        System.out.println("Máximo goleador (si empatan, el de menos partidos): "
                + Collections.max(jugadores, mejorGoleador).nombre());
        System.out.println("El que menos marca: " + Collections.min(jugadores, mejorGoleador).nombre());
    }
}
