/*
 * TEMA 19 · Ejercicio 05 · Clasificación de liga  (dificultad: 5/5)
 *
 * Objetivo: un programa completo con streams: leer y validar datos, flatMap,
 *           agrupar, resumir, ordenar con varios criterios y Optional.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej19_05_ClasificacionDeLiga.java
 */
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ej19_05_ClasificacionDeLiga {

    // NO TOCAR: los tres records
    record Partido(String local, String visitante, int golesLocal, int golesVisitante) {
        int totalGoles() {
            return golesLocal + golesVisitante;
        }

        @Override
        public String toString() {
            return local + " " + golesLocal + "-" + golesVisitante + " " + visitante;
        }
    }

    record Resultado(String equipo, int golesFavor, int golesContra) {
        boolean ganado() {
            return golesFavor > golesContra;
        }

        boolean empatado() {
            return golesFavor == golesContra;
        }

        boolean perdido() {
            return golesFavor < golesContra;
        }
    }

    record Fila(String equipo, int jugados, int ganados, int empatados, int perdidos, int golesFavor, int golesContra) {
        int puntos() {
            return ganados * 3 + empatados;
        }

        int diferencia() {
            return golesFavor - golesContra;
        }
    }

    // TODO 1: "Atlético;Betis;2;1" → Optional con el Partido. Si no tiene 4 partes o los goles
    //         no son números, Optional.empty()
    static Optional<Partido> parsear(String linea) {
        return Optional.empty();
    }

    // TODO 2: un Stream con DOS resultados: el del equipo local y el del visitante
    static Stream<Resultado> resultados(Partido p) {
        return Stream.empty();
    }

    // TODO 3: construye la Fila de un equipo a partir de todos sus resultados (con streams)
    static Fila resumir(String equipo, List<Resultado> resultados) {
        return new Fila(equipo, 0, 0, 0, 0, 0, 0);
    }

    // TODO 4: flatMap(resultados) → groupingBy(equipo) → una Fila por equipo → ordenar por
    //         puntos, diferencia de goles y goles a favor (todos de mayor a menor) y, por último, nombre
    static List<Fila> clasificacion(List<Partido> partidos) {
        return List.of();
    }

    public static void main(String[] args) {
        // NO TOCAR: los resultados (hay dos líneas mal escritas)
        String datos = """
                Atlético;Betis;2;1
                Celta;Rayo;0;0
                Betis;Celta;3;1
                Rayo;Atlético;1;1
                Atlético;Celta;4;0
                Betis;Rayo;dos;1
                Rayo;Betis;2;2
                Celta;Atlético;1;2
                Betis;Atlético;2;0
                Rayo;Celta;3
                Celta;Betis;1;1
                """;

        // TODO 5: convierte las líneas (datos.lines()) en una List<Partido> descartando las incorrectas
        //         (flatMap(Optional::stream)) y muestra cuántas se han leído y cuántas se han descartado

        // TODO 6: muestra la clasificación con printf (mira la salida esperada)

        // TODO 7: partido con más goles, media de goles por partido, número de empates,
        //         equipos invictos y equipos que han ganado algún partido fuera de casa
    }
}
