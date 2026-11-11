/*
 * TEMA 15 · Ejercicio 01 · División segura  (dificultad: 1/5)
 *
 * Objetivo: capturar los errores de una división para que el programa no se detenga.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej15_01_DivisionSegura.java
 */
import java.util.Scanner;

public class Ej15_01_DivisionSegura {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // TODO: envuelve este código en un try con dos catch y un finally
        System.out.print("Dividendo: ");
        int dividendo = Integer.parseInt(teclado.nextLine().strip());
        System.out.print("Divisor: ");
        int divisor = Integer.parseInt(teclado.nextLine().strip());
        System.out.println(dividendo + " / " + divisor + " = " + dividendo / divisor + " (resto " + dividendo % divisor + ")");

        teclado.close();
    }
}
