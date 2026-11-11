/*
 * TEMA 06 · Ejercicio 02 · Tarifas de envío  (dificultad: 2/5)
 *
 * Objetivo: elegir el precio según el tramo de peso con una cadena else if.
 *
 * Lee el ENUNCIADO.md antes de empezar (ahí está la tabla de tarifas).
 * Cómo ejecutarlo:  java Ej06_02_TarifasDeEnvio.java
 */
import java.util.Scanner;

public class Ej06_02_TarifasDeEnvio {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Ya hecho: lectura del peso
        System.out.print("Peso del paquete (kg): ");
        double peso = teclado.nextDouble();

        // TODO 1: escribe la cadena if / else if / else que:
        //   - muestre "Peso no válido" si peso <= 0
        //   - muestre "No se admiten paquetes de más de 20 kg" si peso > 20
        //   - en otro caso, muestre el precio del tramo con printf y 2 decimales:
        //       System.out.printf("Precio del envío: %.2f euros%n", ...);

        teclado.close();
    }
}
