/*
 * TEMA 11 · Ejercicio 02 · Canciones  (dificultad: 2/5)
 *
 * Objetivo: escribir constructores (con this y this(...)) y toString.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej11_02_Canciones.java
 */
public class Ej11_02_Canciones {

    static class Cancion {

        String titulo;
        String artista;
        int duracionSegundos;
        int reproducciones;

        // TODO 1: constructor completo (titulo, artista, duracionSegundos).
        //         Usa this para distinguir atributos y parámetros.
        Cancion(String titulo, String artista, int duracionSegundos) {
        }

        // TODO 2: constructor corto (titulo, artista) que llame al completo con this(...).
        Cancion(String titulo, String artista) {
            this(titulo, artista, -1);   // Cambia el -1 por el valor correcto
        }

        // TODO 3: suma una reproducción y muestra "▶ Reproduciendo: <título>"
        void reproducir() {
        }

        // TODO 4: devuelve "m:ss" o "?:??" si la duración es 0
        String duracionFormateada() {
            return "";
        }

        // TODO 5: "Título - Artista [m:ss] (N reproducciones)"
        @Override
        public String toString() {
            return "";
        }
    }

    // NO TOCAR
    public static void main(String[] args) {
        Cancion bohemian = new Cancion("Bohemian Rhapsody", "Queen", 355);
        Cancion despacito = new Cancion("Despacito", "Luis Fonsi", 228);
        Cancion nueva = new Cancion("Canción nueva", "Artista desconocido");

        bohemian.reproducir();
        bohemian.reproducir();
        despacito.reproducir();

        System.out.println(bohemian);
        System.out.println(despacito);
        System.out.println(nueva);
    }
}
