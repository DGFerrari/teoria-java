/*
 * TEMA 20 · Ejercicio 04 · Agenda persistente  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol20_04_AgendaPersistente.java
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

public class Sol20_04_AgendaPersistente {

    record Contacto(String nombre, String telefono, String email) {
        String aCsv() {
            return nombre + ";" + telefono + ";" + email;
        }

        static Contacto desdeCsv(String linea) {
            String[] partes = linea.split(";");
            return new Contacto(partes[0], partes[1], partes[2]);
        }
    }

    static class Agenda {
        private static final String CABECERA = "nombre;telefono;email";

        private final Map<String, Contacto> contactos = new TreeMap<>();     // Ordenados por nombre

        boolean agregar(Contacto c) {
            boolean agregado = false;
            if (!contactos.containsKey(c.nombre())) {
                contactos.put(c.nombre(), c);
                agregado = true;
            }
            return agregado;
        }

        boolean eliminar(String nombre) {
            return contactos.remove(nombre) != null;
        }

        int cantidad() {
            return contactos.size();
        }

        List<Contacto> todos() {
            return new ArrayList<>(contactos.values());
        }

        // Si el fichero aún no existe (primera ejecución), se empieza con la agenda vacía
        static Agenda cargar(Path ruta) throws IOException {
            Agenda agenda = new Agenda();
            if (Files.exists(ruta)) {
                List<String> lineas = Files.readAllLines(ruta);
                for (int i = 1; i < lineas.size(); i++) {
                    agenda.agregar(Contacto.desdeCsv(lineas.get(i)));
                }
            }
            return agenda;
        }

        // Antes de sobrescribir, se guarda una copia de la versión anterior
        void guardar(Path ruta, Path copia) throws IOException {
            if (Files.exists(ruta)) {
                Files.copy(ruta, copia, StandardCopyOption.REPLACE_EXISTING);
            }
            List<String> lineas = new ArrayList<>();
            lineas.add(CABECERA);
            for (Contacto c : contactos.values()) {
                lineas.add(c.aCsv());
            }
            Files.write(ruta, lineas);
        }
    }

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

            System.out.println("=== Sesión 1 ===");
            Agenda agenda = Agenda.cargar(fichero);
            System.out.println("Cargados: " + agenda.cantidad() + " contactos (no había fichero)");
            agenda.agregar(new Contacto("Luis", "611222333", "luis@correo.es"));
            agenda.agregar(new Contacto("Ana", "600123456", "ana@correo.es"));
            agenda.agregar(new Contacto("Marta", "622333444", "marta@correo.es"));
            agenda.guardar(fichero, copia);
            System.out.println("Guardados: " + agenda.cantidad() + " · ¿hay copia? " + Files.exists(copia));

            System.out.println("=== Sesión 2 ===");
            agenda = Agenda.cargar(fichero);                       // Como si el programa empezara de nuevo
            System.out.println("Cargados: " + agenda.cantidad() + " contactos");
            System.out.println("¿Añadido Pablo? " + agenda.agregar(new Contacto("Pablo", "633444555", "pablo@correo.es")));
            System.out.println("¿Añadida Ana otra vez? " + agenda.agregar(new Contacto("Ana", "699999999", "otra@correo.es")));
            System.out.println("¿Eliminado Luis? " + agenda.eliminar("Luis"));
            agenda.guardar(fichero, copia);
            System.out.println("Guardados: " + agenda.cantidad() + " · ¿hay copia? " + Files.exists(copia));

            System.out.println("=== Sesión 3 ===");
            agenda = Agenda.cargar(fichero);
            for (Contacto c : agenda.todos()) {
                System.out.println("  " + c.nombre() + " · " + c.telefono() + " · " + c.email());
            }
            System.out.println("--- agenda.csv ---");
            Files.readAllLines(fichero).forEach(System.out::println);
            System.out.println("--- agenda.bak (versión anterior) ---");
            Files.readAllLines(copia).forEach(System.out::println);
        } finally {
            borrarCarpeta(carpeta);
        }
    }
}
