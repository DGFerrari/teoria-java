/*
 * TEMA 20 · Ficheros
 * Ejemplo 04: leer y escribir línea a línea
 *
 * Cómo ejecutarlo:  java T20_04_LineaALinea.java
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class T20_04_LineaALinea {

    public static void main(String[] args) throws IOException {
        Path carpeta = Files.createTempDirectory("tema20");
        Path diario = carpeta.resolve("temperaturas.txt");
        Path informe = carpeta.resolve("informe.txt");

        // ------------------------------------------------------------
        // 1. BufferedWriter: write + newLine
        // ------------------------------------------------------------
        int[] temperaturas = {18, 21, 25, 19, 30, 27, 22};
        String[] dias = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
        try (BufferedWriter escritor = Files.newBufferedWriter(diario)) {
            for (int i = 0; i < dias.length; i++) {
                escritor.write(dias[i] + ";" + temperaturas[i]);
                escritor.newLine();
            }
        }                                                   // Aquí se cierra y se vuelca todo al disco
        System.out.println("1. Escritas " + Files.readAllLines(diario).size() + " líneas en temperaturas.txt");
        System.out.println();

        // ------------------------------------------------------------
        // 2. BufferedReader: readLine hasta que devuelva null
        // ------------------------------------------------------------
        int suma = 0;
        int lineas = 0;
        String diaMasCaluroso = "";
        int maxima = Integer.MIN_VALUE;
        try (BufferedReader lector = Files.newBufferedReader(diario)) {
            String linea = lector.readLine();                // Primera lectura ANTES del bucle
            while (linea != null) {                          // null = fin del fichero
                String[] partes = linea.split(";");
                int t = Integer.parseInt(partes[1]);
                suma += t;
                lineas++;
                if (t > maxima) {
                    maxima = t;
                    diaMasCaluroso = partes[0];
                }
                linea = lector.readLine();                   // Siguiente lectura al FINAL de la vuelta
            }
        }
        System.out.printf("2. Media de %d días: %.1f ºC · el más caluroso: %s (%d ºC)%n",
                lineas, (double) suma / lineas, diaMasCaluroso, maxima);
        System.out.println();

        // ------------------------------------------------------------
        // 3. PrintWriter: println y printf en un fichero
        // ------------------------------------------------------------
        try (PrintWriter salida = new PrintWriter(Files.newBufferedWriter(informe))) {
            salida.println("=== Informe semanal ===");
            for (int i = 0; i < dias.length; i++) {
                salida.printf("%-10s %3d ºC %s%n", dias[i], temperaturas[i], "*".repeat(temperaturas[i] / 5));
            }
            salida.printf("Media: %.1f ºC%n", (double) suma / lineas);
        }
        System.out.println("3. Contenido de informe.txt:");
        System.out.print(Files.readString(informe));
        System.out.println();

        // ------------------------------------------------------------
        // 4. Scanner sobre un fichero (como sobre el teclado)
        // ------------------------------------------------------------
        int calurosos = 0;
        try (Scanner lector = new Scanner(diario)) {
            lector.useDelimiter("[;\\r\\n]+");               // Separa por ; y por saltos de línea
            while (lector.hasNext()) {
                lector.next();                                // El día
                if (lector.nextInt() > 24) {                  // La temperatura
                    calurosos++;
                }
            }
        }
        System.out.println("4. Días de más de 24 ºC (leídos con Scanner): " + calurosos);

        // Limpieza
        Files.delete(diario);
        Files.delete(informe);
        Files.delete(carpeta);
    }
}
