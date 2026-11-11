/*
 * TEMA 06 · Ejercicio 02 · Tarifas de envío  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol06_02_TarifasDeEnvio.java
 */
import java.util.Scanner;

public class Sol06_02_TarifasDeEnvio {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Peso del paquete (kg): ");
        double peso = teclado.nextDouble();

        // Primero los casos de error
        if (peso <= 0) {
            System.out.println("Peso no válido");
        } else if (peso > 20) {
            System.out.println("No se admiten paquetes de más de 20 kg");
        } else {
            // Aquí sabemos que 0 < peso <= 20.
            // Cada else if solo comprueba el límite superior del tramo.
            double precio;
            if (peso <= 1) {
                precio = 3.50;
            } else if (peso <= 5) {
                precio = 6.00;
            } else if (peso <= 10) {
                precio = 9.50;
            } else {
                precio = 14.00;
            }
            System.out.printf("Precio del envío: %.2f euros%n", precio);
        }

        teclado.close();
    }
}
