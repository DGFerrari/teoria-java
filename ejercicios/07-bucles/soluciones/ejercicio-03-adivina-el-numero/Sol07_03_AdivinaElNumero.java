/*
 * TEMA 07 · Ejercicio 03 · Adivina el número  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol07_03_AdivinaElNumero.java
 */
import java.util.Random;
import java.util.Scanner;

public class Sol07_03_AdivinaElNumero {

    public static void main(String[] args) {

        final int MINIMO = 1;
        final int MAXIMO = 100;
        final int MAX_INTENTOS = 7;
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int secreto = random.nextInt(MINIMO, MAXIMO + 1);   // El límite superior no se incluye

        int intentos = 0;
        boolean acertado = false;

        System.out.println("He pensado un número del " + MINIMO + " al " + MAXIMO
                + ". Tienes " + MAX_INTENTOS + " intentos.");

        // Dos formas de terminar, ambas en la condición: sin break
        while (intentos < MAX_INTENTOS && !acertado) {
            System.out.print("Intento " + (intentos + 1) + " de " + MAX_INTENTOS + ": ");
            int numero = teclado.nextInt();

            if (numero < MINIMO || numero > MAXIMO) {
                System.out.println("  Fuera de rango (" + MINIMO + "-" + MAXIMO + "). Este intento no cuenta.");
            } else {
                intentos++;
                if (numero < secreto) {
                    System.out.println("  El número es MAYOR");
                } else if (numero > secreto) {
                    System.out.println("  El número es MENOR");
                } else {
                    System.out.println("  ¡Correcto!");
                    acertado = true;          // La condición del while será false en la próxima comprobación
                }
            }
        }

        // La bandera nos dice por cuál de las dos salidas ha terminado el bucle
        if (acertado) {
            System.out.println("¡Has ganado en " + intentos + " intentos!");
        } else {
            System.out.println("Has perdido. El número era " + secreto);
        }

        teclado.close();
    }
}
