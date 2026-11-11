/*
 * TEMA 06 · Ejercicio 01 · Signo y paridad  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol06_01_SignoYParidad.java
 */
import java.util.Scanner;

public class Sol06_01_SignoYParidad {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Escribe un número entero: ");
        int numero = teclado.nextInt();

        // Pregunta 1: tres casos excluyentes
        if (numero > 0) {
            System.out.println(numero + " es positivo");
        } else if (numero < 0) {
            System.out.println(numero + " es negativo");
        } else {
            System.out.println(numero + " es cero");
        }

        // Pregunta 2 (independiente de la anterior): dos casos
        // % 2 == 0 funciona también con negativos (-7 % 2 es -1, no 1)
        if (numero % 2 == 0) {
            System.out.println(numero + " es par");
        } else {
            System.out.println(numero + " es impar");
        }

        teclado.close();
    }
}
