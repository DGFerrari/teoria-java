/*
 * TEMA 07 · Ejercicio 02 · Suma de pares  (dificultad: 2/5)
 *
 * Objetivo: sumar y contar los números pares del 1 al N mostrando la operación.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej07_02_SumaDePares.java
 */
import java.util.Scanner;

public class Ej07_02_SumaDePares {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("N: ");
        int n = teclado.nextInt();

        // Ya hecho: acumulador y contador
        int suma = 0;
        int cantidad = 0;

        // TODO 1: recorre del 1 al N. Para cada número par:
        //   - muestra " + " antes del número (salvo si es el primero)
        //   - muestra el número (con print, sin saltar de línea)
        //   - actualiza suma y cantidad

        // TODO 2: después del bucle:
        //   - si ha habido pares: muestra " = suma" y la línea "Hay X números pares..."
        //   - si no: "No hay números pares entre 1 y N"

        teclado.close();
    }
}
