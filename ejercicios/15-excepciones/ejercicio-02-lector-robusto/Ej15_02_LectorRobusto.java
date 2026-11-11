/*
 * TEMA 15 · Ejercicio 02 · Lector robusto  (dificultad: 2/5)
 *
 * Objetivo: un método que pide un dato hasta que sea válido, sin que el programa falle.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej15_02_LectorRobusto.java
 */
import java.util.Scanner;

public class Ej15_02_LectorRobusto {

    // TODO: pide la nota hasta que sea un entero entre 0 y 10
    static int leerNota(Scanner teclado, String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(teclado.nextLine().strip());
    }

    // NO TOCAR
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
