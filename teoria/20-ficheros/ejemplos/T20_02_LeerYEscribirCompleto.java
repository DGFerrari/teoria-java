/*
 * TEMA 20 · Ficheros
 * Ejemplo 02: leer y escribir un fichero completo
 *
 * Cómo ejecutarlo:  java T20_02_LeerYEscribirCompleto.java
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class T20_02_LeerYEscribirCompleto {

    public static void main(String[] args) throws IOException {
        Path carpeta = Files.createTempDirectory("tema20");
        Path notas = carpeta.resolve("notas.txt");
        Path compra = carpeta.resolve("compra.txt");

        // ------------------------------------------------------------
        // 1. writeString / readString: un texto completo
        // ------------------------------------------------------------
        Files.writeString(notas, "Repasar genéricos\nHacer el ejercicio 3\n");
        String contenido = Files.readString(notas);
        System.out.println("1. Contenido de notas.txt:");
        System.out.print(contenido);
        System.out.println("   (" + contenido.length() + " caracteres)");
        System.out.println();

        // ------------------------------------------------------------
        // 2. Escribir otra vez SOBRESCRIBE
        // ------------------------------------------------------------
        Files.writeString(notas, "Solo queda esto\n");
        System.out.println("2. Tras escribir otra vez: " + Files.readString(notas).strip());
        System.out.println();

        // ------------------------------------------------------------
        // 3. APPEND: añadir al final
        // ------------------------------------------------------------
        Files.writeString(notas, "Y esto se añade\n", StandardOpenOption.APPEND);
        Files.writeString(notas, "Y esto también\n", StandardOpenOption.APPEND);
        System.out.println("3. Con APPEND:");
        System.out.print(Files.readString(notas));
        System.out.println();

        // ------------------------------------------------------------
        // 4. write / readAllLines: una lista de líneas
        // ------------------------------------------------------------
        List<String> productos = List.of("pan", "leche", "huevos", "café");
        Files.write(compra, productos);                       // Un elemento por línea
        List<String> leidas = Files.readAllLines(compra);     // Sin los saltos de línea
        System.out.println("4. Leídas " + leidas.size() + " líneas: " + leidas);
        System.out.println("   ¿Igual que la lista original? " + leidas.equals(productos));
        System.out.println();

        // ------------------------------------------------------------
        // 5. Leer, modificar y volver a guardar
        // ------------------------------------------------------------
        List<String> modificada = new ArrayList<>(Files.readAllLines(compra));
        modificada.remove("leche");
        modificada.add("tomates");
        Files.write(compra, modificada);
        System.out.println("5. Tras modificar: " + Files.readAllLines(compra));
        System.out.println();

        // ------------------------------------------------------------
        // 6. Las tildes y los emojis se guardan sin problema (UTF-8)
        // ------------------------------------------------------------
        Path especiales = carpeta.resolve("especiales.txt");
        Files.writeString(especiales, "Año, cigüeña, acción, 😀");
        System.out.println("6. " + Files.readString(especiales));

        // Limpieza
        Files.delete(notas);
        Files.delete(compra);
        Files.delete(especiales);
        Files.delete(carpeta);
    }
}
