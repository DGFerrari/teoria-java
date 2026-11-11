/*
 * TEMA 20 · Ficheros
 * Ejemplo 01: rutas con Path y preguntas al disco con Files
 *
 * Cómo ejecutarlo:  java T20_01_RutasYPath.java
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class T20_01_RutasYPath {

    public static void main(String[] args) throws IOException {   // Si algo falla, el programa termina con la traza

        // ------------------------------------------------------------
        // 1. Crear rutas: Path.of NO toca el disco
        // ------------------------------------------------------------
        Path ruta = Path.of("datos", "2025", "notas.csv");          // Separador correcto en cada sistema
        System.out.println("1. Ruta: " + ruta);
        System.out.println("   Nombre: " + ruta.getFileName());
        System.out.println("   Carpeta: " + ruta.getParent());
        System.out.println("   ¿Es absoluta? " + ruta.isAbsolute());
        System.out.println("   ¿Existe? " + Files.exists(ruta) + " (crear el Path no crea el fichero)");
        System.out.println();

        // ------------------------------------------------------------
        // 2. Combinar y simplificar rutas
        // ------------------------------------------------------------
        Path base = Path.of("proyecto");
        Path dentro = base.resolve("src").resolve("Main.java");
        Path conPuntos = Path.of("proyecto", "src", "..", "docs", ".", "manual.txt");
        System.out.println("2. resolve: " + dentro);
        System.out.println("   Con . y ..: " + conPuntos);
        System.out.println("   normalize(): " + conPuntos.normalize());
        System.out.println();

        // ------------------------------------------------------------
        // 3. El directorio de trabajo: desde donde se resuelven las rutas relativas
        // ------------------------------------------------------------
        Path trabajo = Path.of("").toAbsolutePath();
        System.out.println("3. Directorio de trabajo: " + trabajo.getFileName() + " (depende de dónde ejecutes java)");
        System.out.println("   notas.csv se buscaría en: .../" + trabajo.getFileName() + "/notas.csv");
        System.out.println();

        // ------------------------------------------------------------
        // 4. Preguntar al disco (en una carpeta temporal)
        // ------------------------------------------------------------
        Path carpeta = Files.createTempDirectory("tema20");
        Path fichero = carpeta.resolve("saludo.txt");
        Files.writeString(fichero, "Hola, disco");

        System.out.println("4. Carpeta temporal creada: " + carpeta.getFileName().toString().startsWith("tema20"));
        System.out.println("   ¿Existe saludo.txt? " + Files.exists(fichero));
        System.out.println("   ¿Es una carpeta? " + Files.isDirectory(fichero) + " · ¿es un fichero? " + Files.isRegularFile(fichero));
        System.out.println("   Tamaño: " + Files.size(fichero) + " bytes");
        System.out.println("   ¿La carpeta es una carpeta? " + Files.isDirectory(carpeta));

        // Limpieza: primero el fichero, luego la carpeta (tiene que estar vacía)
        Files.delete(fichero);
        Files.delete(carpeta);
        System.out.println("   Tras borrar: ¿existe la carpeta? " + Files.exists(carpeta));
    }
}
