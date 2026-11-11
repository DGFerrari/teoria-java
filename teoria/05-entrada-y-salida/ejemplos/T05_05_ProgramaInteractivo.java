/*
 * TEMA 05 · Entrada y salida
 * Ejemplo 05: PROGRAMA INTERACTIVO COMPLETO
 *
 * Calcula el consumo y el coste de un viaje en coche.
 * Ejemplo de respuestas:
 *   Valencia - Madrid
 *   355
 *   6,2        (litros cada 100 km; con punto si tu sistema está en inglés)
 *   1,65       (precio del litro)
 *   3          (personas)
 *
 * Cómo ejecutarlo:  java T05_05_ProgramaInteractivo.java
 */
import java.util.Scanner;

public class T05_05_ProgramaInteractivo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("=== CALCULADORA DE VIAJES ===");

        // ------------------------------------------------------------
        // ENTRADA
        // ------------------------------------------------------------
        System.out.print("Trayecto: ");
        String trayecto = teclado.nextLine();          // Primero el texto: así no hay problema con nextLine

        System.out.print("Distancia (km): ");
        int kilometros = teclado.nextInt();

        System.out.print("Consumo (litros cada 100 km): ");
        double consumo = teclado.nextDouble();

        System.out.print("Precio del litro (euros): ");
        double precioLitro = teclado.nextDouble();

        System.out.print("Número de personas: ");
        int personas = teclado.nextInt();

        // ------------------------------------------------------------
        // PROCESO
        // ------------------------------------------------------------
        double litros = kilometros * consumo / 100;
        double coste = litros * precioLitro;
        double costePorPersona = coste / personas;
        double costeIdaYVuelta = coste * 2;

        // ------------------------------------------------------------
        // SALIDA con formato
        // ------------------------------------------------------------
        System.out.println();
        System.out.println("=".repeat(36));
        System.out.printf("Trayecto: %s%n", trayecto);   // Texto de longitud variable: sin ancho fijo
        System.out.println("=".repeat(36));
        System.out.printf("%-22s %10d km%n", "Distancia:", kilometros);
        System.out.printf("%-22s %10.2f l%n", "Combustible:", litros);
        System.out.printf("%-22s %10.2f euros%n", "Coste (solo ida):", coste);
        System.out.printf("%-22s %10.2f euros%n", "Coste ida y vuelta:", costeIdaYVuelta);
        System.out.printf("%-22s %10.2f euros%n", "Por persona (ida):", costePorPersona);
        System.out.println("=".repeat(36));

        teclado.close();
    }
}
