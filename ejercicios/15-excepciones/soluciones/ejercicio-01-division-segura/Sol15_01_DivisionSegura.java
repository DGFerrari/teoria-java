/*
 * TEMA 15 · Ejercicio 01 · División segura  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol15_01_DivisionSegura.java
 */
import java.util.Scanner;

public class Sol15_01_DivisionSegura {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.print("Dividendo: ");
            int dividendo = Integer.parseInt(teclado.nextLine().strip());   // Puede: NumberFormatException
            System.out.print("Divisor: ");
            int divisor = Integer.parseInt(teclado.nextLine().strip());
            System.out.println(dividendo + " / " + divisor + " = " + dividendo / divisor   // Puede: ArithmeticException
                    + " (resto " + dividendo % divisor + ")");
        } catch (NumberFormatException e) {
            System.out.println("✘ Eso no es un número entero: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("✘ No se puede dividir entre cero");
        } finally {
            System.out.println("Fin de la operación");                     // Siempre
        }

        teclado.close();
    }
}
