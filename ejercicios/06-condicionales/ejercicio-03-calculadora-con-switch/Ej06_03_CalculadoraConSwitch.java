/*
 * TEMA 06 · Ejercicio 03 · Calculadora con switch  (dificultad: 3/5)
 *
 * Objetivo: elegir la operación con un switch moderno y controlar los errores.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej06_03_CalculadoraConSwitch.java
 */
import java.util.Scanner;

public class Ej06_03_CalculadoraConSwitch {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Ya hecho: lectura de los datos
        System.out.print("Primer número: ");
        double a = teclado.nextDouble();
        System.out.print("Operador (+ - * / % ^): ");
        char operador = teclado.next().charAt(0);
        System.out.print("Segundo número: ");
        double b = teclado.nextDouble();

        double resultado = 0;
        boolean hayError = false;

        // TODO 1: switch moderno sobre "operador" que calcule el resultado.
        //         - Para / y %, comprueba antes si b es 0 (y muestra el error).
        //         - default: muestra "Operador no válido: X".
        //         En ambos errores, pon hayError = true.

        // TODO 2: si no hay error, muestra "a op b = resultado".
        //         Usa un ternario para elegir el formato: sin decimales si
        //         el número es entero, con 2 decimales si no.
        //         (Aplica el mismo formato a a y b para que salgan como en el enunciado.)

        teclado.close();
    }
}
