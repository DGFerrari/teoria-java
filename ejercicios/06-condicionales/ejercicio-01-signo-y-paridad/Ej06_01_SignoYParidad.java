/*
 * TEMA 06 · Ejercicio 01 · Signo y paridad  (dificultad: 1/5)
 *
 * Objetivo: decidir el signo y la paridad de un número con if / else if / else.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej06_01_SignoYParidad.java
 */
import java.util.Scanner;

public class Ej06_01_SignoYParidad {

    public static void main(String[] args) {

        // Ya hecho: lectura del número
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escribe un número entero: ");
        int numero = teclado.nextInt();

        // TODO 1: muestra si el número es positivo, negativo o cero.

        // TODO 2: muestra si el número es par o impar.

        teclado.close();
    }
}
