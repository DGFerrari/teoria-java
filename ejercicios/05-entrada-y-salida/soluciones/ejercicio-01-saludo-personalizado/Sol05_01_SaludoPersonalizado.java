/*
 * TEMA 05 · Ejercicio 01 · Saludo personalizado  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol05_01_SaludoPersonalizado.java
 */
import java.util.Scanner;

public class Sol05_01_SaludoPersonalizado {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // ENTRADA (primero el texto y luego el número: así no hay problema con nextLine)
        System.out.print("¿Cómo te llamas? ");
        String nombre = teclado.nextLine();

        System.out.print("¿Cuántos años tienes? ");
        int edad = teclado.nextInt();

        // PROCESO
        int edadEnDiezAnios = edad + 10;
        int diasVividos = edad * 365;

        // SALIDA
        System.out.printf("Hola, %s.%n", nombre);
        System.out.printf("Dentro de 10 años tendrás %d años.%n", edadEnDiezAnios);
        System.out.printf("Has vivido aproximadamente %,d días.%n", diasVividos);   // %,d → 5.475

        teclado.close();
    }
}
