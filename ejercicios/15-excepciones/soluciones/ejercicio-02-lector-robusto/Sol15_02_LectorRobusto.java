/*
 * TEMA 15 · Ejercicio 02 · Lector robusto  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol15_02_LectorRobusto.java
 */
import java.util.Scanner;

public class Sol15_02_LectorRobusto {

    static int leerNota(Scanner teclado, String mensaje) {
        int nota = 0;
        boolean valida = false;
        while (!valida) {                                  // El try va DENTRO del bucle
            System.out.print(mensaje);
            String linea = teclado.nextLine().strip();     // Fuera del try: lo usamos en el catch
            try {
                nota = Integer.parseInt(linea);
                if (nota < 0 || nota > 10) {
                    System.out.println("  ✘ La nota tiene que estar entre 0 y 10");
                } else {
                    valida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("  ✘ \"" + linea + "\" no es un número");
            }
        }
        return nota;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int suma = 0;
        for (int i = 1; i <= 3; i++) {
            suma += leerNota(teclado, "Nota " + i + ": ");
        }
        System.out.printf("Media: %.2f%n", suma / 3.0);
        teclado.close();
    }
}
