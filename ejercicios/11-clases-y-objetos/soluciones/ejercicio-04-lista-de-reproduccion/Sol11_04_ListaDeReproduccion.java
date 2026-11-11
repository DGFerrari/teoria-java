/*
 * TEMA 11 · Ejercicio 04 · Lista de reproducción  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol11_04_ListaDeReproduccion.java
 */
public class Sol11_04_ListaDeReproduccion {

    static class Cancion {
        String titulo;
        String artista;
        int duracion;

        Cancion(String titulo, String artista, int duracion) {
            this.titulo = titulo;
            this.artista = artista;
            this.duracion = duracion;
        }

        static String formatear(int segundos) {
            return String.format("%d:%02d", segundos / 60, segundos % 60);
        }

        @Override
        public String toString() {
            return titulo + " - " + artista + " [" + formatear(duracion) + "]";
        }
    }

    static class ListaReproduccion {

        String nombre;
        Cancion[] canciones;
        int cantidad;          // Las canciones ocupan las posiciones 0..cantidad-1

        ListaReproduccion(String nombre, int capacidad) {
            this.nombre = nombre;
            this.canciones = new Cancion[capacidad];
            this.cantidad = 0;
        }

        boolean agregar(Cancion cancion) {
            boolean hayHueco = cantidad < canciones.length;
            if (hayHueco) {
                canciones[cantidad] = cancion;      // Primer hueco libre
                cantidad++;
            }
            return hayHueco;
        }

        /** Método auxiliar: posición de la canción o -1 (bandera en la condición). */
        int posicionDe(String titulo) {
            int posicion = -1;
            int i = 0;
            while (i < cantidad && posicion == -1) {
                if (canciones[i].titulo.equalsIgnoreCase(titulo)) {
                    posicion = i;
                }
                i++;
            }
            return posicion;
        }

        Cancion buscar(String titulo) {
            int posicion = posicionDe(titulo);
            return posicion == -1 ? null : canciones[posicion];
        }

        boolean eliminar(String titulo) {
            int posicion = posicionDe(titulo);
            if (posicion != -1) {
                for (int i = posicion; i < cantidad - 1; i++) {
                    canciones[i] = canciones[i + 1];    // Desplazar a la izquierda
                }
                canciones[cantidad - 1] = null;
                cantidad--;
            }
            return posicion != -1;
        }

        int duracionTotal() {
            int total = 0;
            for (int i = 0; i < cantidad; i++) {       // Hasta cantidad, no hasta length
                total += canciones[i].duracion;
            }
            return total;
        }

        Cancion masLarga() {
            Cancion mas = null;
            for (int i = 0; i < cantidad; i++) {
                if (mas == null || canciones[i].duracion > mas.duracion) {
                    mas = canciones[i];
                }
            }
            return mas;
        }

        void mostrar() {
            System.out.println("=== " + nombre + " (" + cantidad + "/" + canciones.length + ") ===");
            for (int i = 0; i < cantidad; i++) {
                System.out.println((i + 1) + ". " + canciones[i]);
            }
            System.out.println("Duración total: " + Cancion.formatear(duracionTotal()));
        }
    }

    public static void main(String[] args) {
        ListaReproduccion lista = new ListaReproduccion("Para correr", 4);
        lista.agregar(new Cancion("Eye of the Tiger", "Survivor", 245));
        lista.agregar(new Cancion("Lose Yourself", "Eminem", 326));
        lista.agregar(new Cancion("Titanium", "David Guetta", 245));
        lista.agregar(new Cancion("Stronger", "Kanye West", 312));

        Cancion thunder = new Cancion("Thunderstruck", "AC/DC", 292);
        System.out.println("¿Añadida \"Thunderstruck\"? " + lista.agregar(thunder));

        lista.mostrar();
        System.out.println("Más larga: " + lista.masLarga());
        System.out.println("Buscar \"titanium\": " + lista.buscar("titanium"));
        System.out.println("Buscar \"Hello\": " + lista.buscar("Hello"));

        System.out.println("¿Eliminada \"Lose Yourself\"? " + lista.eliminar("Lose Yourself"));
        System.out.println("¿Añadida \"Thunderstruck\"? " + lista.agregar(thunder));
        lista.mostrar();
    }
}
