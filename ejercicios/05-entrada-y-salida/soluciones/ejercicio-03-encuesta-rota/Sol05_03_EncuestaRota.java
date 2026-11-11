/*
 * TEMA 05 · Ejercicio 03 · Encuesta rota  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol05_03_EncuestaRota.java
 */
import java.util.Scanner;

public class Sol05_03_EncuestaRota {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("=== ENCUESTA DE BIENVENIDA ===");

        System.out.print("Nombre completo: ");
        String nombre = teclado.nextLine();      // Primera lectura: no hay nada pendiente

        System.out.print("Edad: ");
        int edad = teclado.nextInt();            // Deja el Enter pendiente...
        teclado.nextLine();                      // ...así que lo limpiamos

        System.out.print("Ciudad: ");
        String ciudad = teclado.nextLine();

        System.out.print("Número de hermanos: ");
        int hermanos = teclado.nextInt();
        teclado.nextLine();                      // Misma situación: limpiamos

        System.out.print("Comida favorita: ");
        String comida = teclado.nextLine();

        // next() se salta los saltos de línea iniciales: aquí no hay problema
        System.out.print("Grupo (letra): ");
        char grupo = teclado.next().charAt(0);

        System.out.println();
        System.out.println("--- Resumen ---");
        System.out.printf("%s (%d años) vive en %s.%n", nombre, edad, ciudad);
        System.out.printf("Tiene %d hermanos y su comida favorita es: %s.%n", hermanos, comida);
        System.out.printf("Grupo: %c%n", grupo);

        teclado.close();
    }
}
