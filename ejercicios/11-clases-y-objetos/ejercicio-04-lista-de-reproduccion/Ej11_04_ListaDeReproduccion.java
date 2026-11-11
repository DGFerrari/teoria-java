/*
 * TEMA 11 · Ejercicio 04 · Lista de reproducción  (dificultad: 4/5)
 *
 * Objetivo: una clase que gestiona un array de objetos de otra clase.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej11_04_ListaDeReproduccion.java
 *
 * Regla: sin break ni continue, y sin return dentro de los bucles.
 */
public class Ej11_04_ListaDeReproduccion {

    // NO TOCAR: la clase Cancion ya está hecha
    static class Cancion {
        String titulo;
        String artista;
        int duracion;          // En segundos

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
        int cantidad;          // Cuántas posiciones del array están ocupadas

        // TODO 1: crea el array con la capacidad indicada; la lista empieza vacía.
        ListaReproduccion(String nombre, int capacidad) {
            this.nombre = nombre;
        }

        // TODO 2
        boolean agregar(Cancion cancion) {
            return false;
        }

        // TODO 3 (sin importar mayúsculas; null si no está)
        Cancion buscar(String titulo) {
            return null;
        }

        // TODO 4 (desplaza las siguientes a la izquierda)
        boolean eliminar(String titulo) {
            return false;
        }

        // TODO 5
        int duracionTotal() {
            return 0;
        }

        // TODO 6 (null si la lista está vacía)
        Cancion masLarga() {
            return null;
        }

        // TODO 7: "=== Nombre (cantidad/capacidad) ===", canciones numeradas y duración total
        void mostrar() {
        }
    }

    // NO TOCAR
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
