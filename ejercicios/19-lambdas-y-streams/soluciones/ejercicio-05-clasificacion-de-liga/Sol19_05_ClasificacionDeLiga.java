/*
 * TEMA 19 · Ejercicio 05 · Clasificación de liga  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol19_05_ClasificacionDeLiga.java
 */
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sol19_05_ClasificacionDeLiga {

    record Partido(String local, String visitante, int golesLocal, int golesVisitante) {
        int totalGoles() {
            return golesLocal + golesVisitante;
        }

        @Override
        public String toString() {
            return local + " " + golesLocal + "-" + golesVisitante + " " + visitante;
        }
    }

    // Lo que le pasó a UN equipo en UN partido
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

    // Una fila de la clasificación
    record Fila(String equipo, int jugados, int ganados, int empatados, int perdidos, int golesFavor, int golesContra) {
        int puntos() {
            return ganados * 3 + empatados;
        }

        int diferencia() {
            return golesFavor - golesContra;
        }
    }

    // Una línea mal escrita no detiene el programa: devuelve un Optional vacío
    static Optional<Partido> parsear(String linea) {
        Optional<Partido> resultado = Optional.empty();
        String[] partes = linea.split(";");
        if (partes.length == 4) {
            try {
                resultado = Optional.of(new Partido(partes[0], partes[1],
                        Integer.parseInt(partes[2]), Integer.parseInt(partes[3])));
            } catch (NumberFormatException e) {
                resultado = Optional.empty();
            }
        }
        return resultado;
    }

    // Cada partido produce DOS resultados: uno para cada equipo
    static Stream<Resultado> resultados(Partido p) {
        return Stream.of(
                new Resultado(p.local(), p.golesLocal(), p.golesVisitante()),
                new Resultado(p.visitante(), p.golesVisitante(), p.golesLocal()));
    }

    static Fila resumir(String equipo, List<Resultado> resultados) {
        return new Fila(equipo,
                resultados.size(),
                (int) resultados.stream().filter(Resultado::ganado).count(),
                (int) resultados.stream().filter(Resultado::empatado).count(),
                (int) resultados.stream().filter(Resultado::perdido).count(),
                resultados.stream().mapToInt(Resultado::golesFavor).sum(),
                resultados.stream().mapToInt(Resultado::golesContra).sum());
    }

    static List<Fila> clasificacion(List<Partido> partidos) {
        Map<String, List<Resultado>> porEquipo = partidos.stream()
                .flatMap(Sol19_05_ClasificacionDeLiga::resultados)
                .collect(Collectors.groupingBy(Resultado::equipo));
        return porEquipo.entrySet().stream()
                .map(par -> resumir(par.getKey(), par.getValue()))
                .sorted(Comparator.comparingInt(Fila::puntos).reversed()
                        .thenComparing(Comparator.comparingInt(Fila::diferencia).reversed())
                        .thenComparing(Comparator.comparingInt(Fila::golesFavor).reversed())
                        .thenComparing(Fila::equipo))
                .toList();
    }

    public static void main(String[] args) {
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

        List<String> lineas = datos.lines().toList();
        List<Partido> partidos = lineas.stream()
                .map(Sol19_05_ClasificacionDeLiga::parsear)
                .flatMap(Optional::stream)                 // Optional vacío → 0 elementos; con valor → 1
                .toList();
        System.out.println("Partidos leídos: " + partidos.size() + " · líneas descartadas: "
                + (lineas.size() - partidos.size()));

        List<Fila> tabla = clasificacion(partidos);
        System.out.println("=== Clasificación ===");
        System.out.println("   Equipo     PJ  G  E  P  GF  GC  DG  Pts");
        for (int i = 0; i < tabla.size(); i++) {
            Fila f = tabla.get(i);
            System.out.printf("%d. %-9s %3d %2d %2d %2d %3d %3d %+3d %4d%n", i + 1, f.equipo(), f.jugados(),
                    f.ganados(), f.empatados(), f.perdidos(), f.golesFavor(), f.golesContra(), f.diferencia(), f.puntos());
        }

        partidos.stream()
                .max(Comparator.comparingInt(Partido::totalGoles))
                .ifPresent(p -> System.out.println("Partido con más goles: " + p + " (" + p.totalGoles() + ")"));
        System.out.printf("Media de goles por partido: %.2f%n",
                partidos.stream().mapToInt(Partido::totalGoles).average().orElse(0));
        System.out.println("Empates: " + partidos.stream().filter(p -> p.golesLocal() == p.golesVisitante()).count());
        System.out.println("Invictos: " + tabla.stream()
                .filter(f -> f.perdidos() == 0)
                .map(Fila::equipo)
                .collect(Collectors.joining(", ")));
        System.out.println("Ganaron fuera de casa: " + partidos.stream()
                .filter(p -> p.golesVisitante() > p.golesLocal())
                .map(Partido::visitante)
                .distinct()
                .sorted()
                .toList());
    }
}
