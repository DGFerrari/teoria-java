/*
 * TEMA 20 · Ficheros
 * Ejemplo 03: las excepciones de los ficheros
 *
 * Cómo ejecutarlo:  java T20_03_ExcepcionesDeFicheros.java
 */
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class T20_03_ExcepcionesDeFicheros {

    // Un método "de bajo nivel": no sabe qué hacer si falla, así que DECLARA la excepción
    static int contarLineas(Path ruta) throws IOException {
        return Files.readAllLines(ruta).size();
    }

    // Un método que SÍ sabe qué hacer: si no existe, usa un valor por defecto
    static String leerConfiguracion(Path ruta) throws IOException {
        String contenido = "modo=normal";                      // Valor por defecto
        if (Files.exists(ruta)) {                              // "No existe" es un caso normal: se comprueba
            contenido = Files.readString(ruta).strip();
        }
        return contenido;
    }

    public static void main(String[] args) throws IOException {
        Path carpeta = Files.createTempDirectory("tema20");
        Path fichero = carpeta.resolve("datos.txt");
        Path noExiste = carpeta.resolve("no-existe.txt");

        // ------------------------------------------------------------
        // 1. NoSuchFileException: leer algo que no existe
        // ------------------------------------------------------------
        try {
            Files.readString(noExiste);
        } catch (NoSuchFileException e) {                      // La concreta primero...
            System.out.println("1. NoSuchFileException: no existe " + Path.of(e.getMessage()).getFileName());
        } catch (IOException e) {                              // ...la general después
            System.out.println("1. Otro error: " + e.getMessage());
        }

        // ------------------------------------------------------------
        // 2. FileAlreadyExistsException: crear algo que ya existe
        // ------------------------------------------------------------
        Files.writeString(fichero, "primera versión\n");
        try {
            Files.writeString(fichero, "esto machacaría el fichero\n", StandardOpenOption.CREATE_NEW);
        } catch (FileAlreadyExistsException e) {
            System.out.println("2. FileAlreadyExistsException con CREATE_NEW: el fichero está protegido");
        }
        System.out.println("   Sigue diciendo: " + Files.readString(fichero).strip());

        Path subcarpeta = carpeta.resolve("copias");
        Files.createDirectory(subcarpeta);
        try {
            Files.createDirectory(subcarpeta);
        } catch (FileAlreadyExistsException e) {
            System.out.println("   createDirectory dos veces → FileAlreadyExistsException");
        }
        Files.createDirectories(subcarpeta);                   // Este no falla si ya existe
        System.out.println("   createDirectories dos veces → sin error");

        // ------------------------------------------------------------
        // 3. DirectoryNotEmptyException: borrar una carpeta con contenido
        // ------------------------------------------------------------
        Path dentro = subcarpeta.resolve("copia.txt");
        Files.writeString(dentro, "copia");
        try {
            Files.delete(subcarpeta);
        } catch (DirectoryNotEmptyException e) {
            System.out.println("3. DirectoryNotEmptyException: primero hay que vaciar la carpeta");
        }

        // ------------------------------------------------------------
        // 4. Declarar (throws) y capturar donde se pueda reaccionar
        // ------------------------------------------------------------
        try {
            System.out.println("4. datos.txt tiene " + contarLineas(fichero) + " línea(s)");
            System.out.println("   no-existe.txt tiene " + contarLineas(noExiste) + " línea(s)");
        } catch (NoSuchFileException e) {
            System.out.println("   ✘ No se puede contar: el fichero no existe");
        }

        // ------------------------------------------------------------
        // 5. Comprobar antes cuando "no existe" es un caso normal
        // ------------------------------------------------------------
        Path config = carpeta.resolve("config.txt");
        System.out.println("5. Sin fichero de configuración: " + leerConfiguracion(config));
        Files.writeString(config, "modo=oscuro\n");
        System.out.println("   Con fichero de configuración: " + leerConfiguracion(config));

        // Limpieza: deleteIfExists no falla si no existe
        Files.deleteIfExists(dentro);
        Files.deleteIfExists(subcarpeta);
        Files.deleteIfExists(config);
        Files.deleteIfExists(fichero);
        System.out.println("   ¿Se ha borrado no-existe.txt? " + Files.deleteIfExists(noExiste));
        Files.delete(carpeta);
    }
}
