/*
 * TEMA 19 · Ejercicio 02 · Ordenar con Comparator  (dificultad: 2/5)
 *
 * Objetivo: construir criterios de orden con Comparator y referencias a métodos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej19_02_OrdenarConComparator.java
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Ej19_02_OrdenarConComparator {

    record Jugador(String nombre, String equipo, int goles, int partidos) {
        // TODO 1: goles por partido (cuidado con la división entera)
        double promedio() {
            return 0;
        }
    }

    // TODO 2: muestra "titulo: texto1, texto2, ..." aplicando la función "formato" a cada jugador
    static void mostrar(String titulo, List<Jugador> jugadores, Function<Jugador, String> formato) {
    }

    public static void main(String[] args) {
        // NO TOCAR: los datos
        List<Jugador> jugadores = new ArrayList<>(List.of(
                new Jugador("Lucía", "Rayo", 12, 15),
                new Jugador("Andrés", "Atlético", 18, 20),
                new Jugador("Carla", "Rayo", 18, 22),
                new Jugador("Diego", "Betis", 7, 6),
                new Jugador("Elena", "Atlético", 12, 10)));

        // TODO 3: ordena con jugadores.sort(...) y muestra en cada caso (mira la salida esperada):
        //         - por nombre
        //         - por goles, de más a menos (si empatan, por nombre)
        //         - por equipo y, dentro de cada equipo, por goles de más a menos
        //         - por promedio, de mayor a menor

        // TODO 4: con un Comparator "mejorGoleador" (más goles; si empatan, menos partidos),
        //         usa Collections.max y Collections.min
    }
}
