/*
 * TEMA 20 · Ejercicio 04 · Agenda persistente  (dificultad: 4/5)
 *
 * Objetivo: una clase que guarda su estado en un fichero y lo recupera en la siguiente ejecución.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej20_04_AgendaPersistente.java
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Ej20_04_AgendaPersistente {

    record Contacto(String nombre, String telefono, String email) {
        // TODO 1: aCsv() y static desdeCsv(String linea), con ";" como separador
    }

    static class Agenda {
        private static final String CABECERA = "nombre;telefono;email";

        private final Map<String, Contacto> contactos = new TreeMap<>();     // Ordenados por nombre

        // TODO 2: agregar (false si ya hay un contacto con ese nombre), eliminar (por nombre),
        //         cantidad() y todos() (una copia en una List)

        // TODO 3: static Agenda cargar(Path ruta): si el fichero NO existe, devuelve una agenda vacía;
        //         si existe, la rellena con sus líneas (saltando la cabecera)
        static Agenda cargar(Path ruta) throws IOException {
            return new Agenda();
        }

        // TODO 4: si el fichero ya existe, cópialo antes en "copia" (REPLACE_EXISTING).
        //         Después escribe la cabecera y un contacto por línea
        void guardar(Path ruta, Path copia) throws IOException {
        }
    }

    // NO TOCAR
    static void borrarCarpeta(Path carpeta) throws IOException {
        List<Path> todo;
        try (Stream<Path> recorrido = Files.walk(carpeta)) {
            todo = recorrido.sorted(Comparator.reverseOrder()).toList();
        }
        for (Path p : todo) {
            Files.delete(p);
        }
    }

    public static void main(String[] args) throws IOException {
        Path carpeta = Files.createTempDirectory("ej20");
        try {
            Path fichero = carpeta.resolve("agenda.csv");
            Path copia = carpeta.resolve("agenda.bak");

            // TODO 5: simula tres ejecuciones del programa (mira el ENUNCIADO). En cada "sesión",
            //         la agenda se crea de nuevo con Agenda.cargar(fichero): nada pasa de una sesión
            //         a otra si no es a través del fichero
        } finally {
            borrarCarpeta(carpeta);
        }
    }
}
