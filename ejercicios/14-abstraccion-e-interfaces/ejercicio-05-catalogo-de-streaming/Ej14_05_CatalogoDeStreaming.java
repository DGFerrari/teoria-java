/*
 * TEMA 14 · Ejercicio 05 · Catálogo de streaming  (dificultad: 5/5)
 *
 * Objetivo: una jerarquía sealed de contenidos, una interfaz de capacidad (Valorable),
 *           una clase abstracta con la lógica común y un switch exhaustivo.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej14_05_CatalogoDeStreaming.java
 */
import java.util.Arrays;

public class Ej14_05_CatalogoDeStreaming {

    // TODO 1: haz Contenido sealed (permits Pelicula, Serie, Podcast) y que extienda Comparable<Contenido>.
    //         Añade un compareTo default que ordene por duración.
    interface Contenido {
        String getTitulo();

        int getDuracionMinutos();

        default String duracionTexto() {
            return formatearMinutos(getDuracionMinutos());
        }

        // TODO 2: "35 min", "1 h 36 min" o "12 h"
        static String formatearMinutos(int minutos) {
            return minutos + " min";
        }
    }

    interface Valorable {
        boolean valorar(int estrellas);

        double getMedia();

        int getNumeroValoraciones();

        // TODO 3: tantas ★ como la media redondeada y el resto ☆ (5 en total)
        default String estrellas() {
            return "";
        }
    }

    // TODO 4: lógica común de las valoraciones (solo se aceptan de 1 a 5 estrellas)
    abstract static class ConValoraciones implements Valorable {
        @Override
        public boolean valorar(int estrellas) {
            return false;
        }

        @Override
        public double getMedia() {
            return 0;
        }

        @Override
        public int getNumeroValoraciones() {
            return 0;
        }
    }

    // TODO 5: completa las tres clases (final). Pelicula y Serie son valorables; Podcast no.

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

        // TODO 6: temporadas × episodios × minutos
        @Override
        public int getDuracionMinutos() {
            return 0;
        }

        int getTemporadas() {
            return temporadas;
        }

        int getEpisodios() {
            return temporadas * episodiosPorTemporada;
        }
    }

    static final class Podcast implements Contenido {
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

    // TODO 7: switch con patrones SIN default (posible cuando Contenido sea sealed)
    static String describir(Contenido c) {
        return "";
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

        // TODO 8: ordena el catálogo por duración, muéstralo (con las valoraciones de los
        //         que sean Valorable) y calcula el tiempo total y el mejor valorado.
    }
}
