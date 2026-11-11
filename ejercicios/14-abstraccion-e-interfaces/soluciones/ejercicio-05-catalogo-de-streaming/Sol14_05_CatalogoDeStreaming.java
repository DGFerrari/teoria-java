/*
 * TEMA 14 · Ejercicio 05 · Catálogo de streaming  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol14_05_CatalogoDeStreaming.java
 */
import java.util.Arrays;

public class Sol14_05_CatalogoDeStreaming {

    // ------------------------------------------------------------
    // Jerarquía CERRADA de contenidos, ordenables por duración
    // ------------------------------------------------------------
    sealed interface Contenido extends Comparable<Contenido> permits Pelicula, Serie, Podcast {

        String getTitulo();

        int getDuracionMinutos();

        default String duracionTexto() {
            return formatearMinutos(getDuracionMinutos());
        }

        // Un método default puede incluso implementar el contrato de OTRA interfaz
        @Override
        default int compareTo(Contenido otro) {
            return Integer.compare(getDuracionMinutos(), otro.getDuracionMinutos());
        }

        static String formatearMinutos(int minutos) {
            int horas = minutos / 60;
            int resto = minutos % 60;
            if (horas == 0) {
                return resto + " min";
            } else if (resto == 0) {
                return horas + " h";
            } else {
                return horas + " h " + resto + " min";
            }
        }
    }

    // ------------------------------------------------------------
    // Capacidad que solo tienen algunos contenidos
    // ------------------------------------------------------------
    interface Valorable {
        boolean valorar(int estrellas);

        double getMedia();

        int getNumeroValoraciones();

        default String estrellas() {
            int llenas = (int) Math.round(getMedia());
            return "★".repeat(llenas) + "☆".repeat(5 - llenas);
        }
    }

    // La lógica de valorar se escribe UNA vez en una clase abstracta
    abstract static class ConValoraciones implements Valorable {
        private int suma = 0;
        private int cantidad = 0;

        @Override
        public boolean valorar(int estrellas) {
            boolean valida = estrellas >= 1 && estrellas <= 5;
            if (valida) {
                suma += estrellas;
                cantidad++;
            }
            return valida;
        }

        @Override
        public double getMedia() {
            return cantidad == 0 ? 0 : (double) suma / cantidad;
        }

        @Override
        public int getNumeroValoraciones() {
            return cantidad;
        }
    }

    // ------------------------------------------------------------
    // Las tres clases permitidas (final)
    // ------------------------------------------------------------
    static final class Pelicula extends ConValoraciones implements Contenido {
        private final String titulo;
        private final int minutos;
        private final String director;

        Pelicula(String titulo, int minutos, String director) {
            this.titulo = titulo;
            this.minutos = minutos;
            this.director = director;
        }

        @Override
        public String getTitulo() {
            return titulo;
        }

        @Override
        public int getDuracionMinutos() {
            return minutos;
        }

        String getDirector() {
            return director;
        }
    }

    static final class Serie extends ConValoraciones implements Contenido {
        private final String titulo;
        private final int temporadas;
        private final int episodiosPorTemporada;
        private final int minutosPorEpisodio;

        Serie(String titulo, int temporadas, int episodiosPorTemporada, int minutosPorEpisodio) {
            this.titulo = titulo;
            this.temporadas = temporadas;
            this.episodiosPorTemporada = episodiosPorTemporada;
            this.minutosPorEpisodio = minutosPorEpisodio;
        }

        @Override
        public String getTitulo() {
            return titulo;
        }

        @Override
        public int getDuracionMinutos() {
            return temporadas * episodiosPorTemporada * minutosPorEpisodio;
        }

        int getTemporadas() {
            return temporadas;
        }

        int getEpisodios() {
            return temporadas * episodiosPorTemporada;
        }
    }

    static final class Podcast implements Contenido {          // No es Valorable
        private final String titulo;
        private final String presentador;
        private final int minutos;

        Podcast(String titulo, String presentador, int minutos) {
            this.titulo = titulo;
            this.presentador = presentador;
            this.minutos = minutos;
        }

        @Override
        public String getTitulo() {
            return titulo;
        }

        @Override
        public int getDuracionMinutos() {
            return minutos;
        }

        String getPresentador() {
            return presentador;
        }
    }

    // ------------------------------------------------------------
    // switch exhaustivo: SIN default, porque Contenido es sealed
    // ------------------------------------------------------------
    static String describir(Contenido c) {
        return switch (c) {
            case Pelicula p -> "🎬 Película de " + p.getDirector();
            case Serie s -> "📺 Serie de " + s.getTemporadas() + " temporadas (" + s.getEpisodios() + " episodios)";
            case Podcast p -> "🎙 Podcast con " + p.getPresentador();
        };
    }

    public static void main(String[] args) {
        Pelicula dune = new Pelicula("Dune: Parte dos", 166, "Denis Villeneuve");
        Pelicula up = new Pelicula("Up", 96, "Pete Docter");
        Serie dark = new Serie("Dark", 3, 8, 55);
        Serie arcane = new Serie("Arcane", 2, 9, 40);
        Podcast podcast = new Podcast("Entiende tu mente", "Molo Cebrián", 35);

        dune.valorar(5);
        dune.valorar(4);
        dune.valorar(5);
        up.valorar(4);
        up.valorar(3);
        System.out.println("¿Valoración de 6 estrellas aceptada? " + up.valorar(6));
        dark.valorar(5);
        dark.valorar(5);
        dark.valorar(4);
        arcane.valorar(5);

        Contenido[] catalogo = {dune, dark, podcast, up, arcane};
        Arrays.sort(catalogo);                                 // Usa el compareTo default de Contenido

        System.out.println("=== Catálogo (de más corto a más largo) ===");
        int minutosTotales = 0;
        for (Contenido c : catalogo) {
            String valoracion = c instanceof Valorable v
                    ? String.format("%s %.2f (%d)", v.estrellas(), v.getMedia(), v.getNumeroValoraciones())
                    : "sin valoraciones";
            System.out.printf("%-18s %-12s %s · %s%n", c.getTitulo(), c.duracionTexto(), describir(c), valoracion);
            minutosTotales += c.getDuracionMinutos();
        }
        System.out.println("Tiempo total para verlo todo: " + Contenido.formatearMinutos(minutosTotales));

        // El mejor valorado entre los que se pueden valorar
        Valorable mejor = null;
        String tituloMejor = "";
        for (Contenido c : catalogo) {
            if (c instanceof Valorable v && (mejor == null || v.getMedia() > mejor.getMedia())) {
                mejor = v;
                tituloMejor = c.getTitulo();
            }
        }
        System.out.printf("Mejor valorado: %s (%.2f)%n", tituloMejor, mejor.getMedia());
    }
}
