/*
 * TEMA 11 · Ejercicio 02 · Canciones  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol11_02_Canciones.java
 */
public class Sol11_02_Canciones {

    static class Cancion {

        String titulo;
        String artista;
        int duracionSegundos;
        int reproducciones;

        // Constructor completo: aquí está toda la inicialización
        Cancion(String titulo, String artista, int duracionSegundos) {
            this.titulo = titulo;
            this.artista = artista;
            this.duracionSegundos = duracionSegundos;
            this.reproducciones = 0;
        }

        // Constructor corto: delega en el completo
        Cancion(String titulo, String artista) {
            this(titulo, artista, 0);
        }

        void reproducir() {
            reproducciones++;
            System.out.println("▶ Reproduciendo: " + titulo);
        }

        String duracionFormateada() {
            if (duracionSegundos == 0) {
                return "?:??";
            } else {
                return String.format("%d:%02d", duracionSegundos / 60, duracionSegundos % 60);
            }
        }

        @Override
        public String toString() {
            return titulo + " - " + artista + " [" + duracionFormateada() + "] (" + reproducciones + " reproducciones)";
        }
    }

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
