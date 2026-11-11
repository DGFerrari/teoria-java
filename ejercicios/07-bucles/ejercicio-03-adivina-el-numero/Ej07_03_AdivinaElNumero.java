/*
 * TEMA 07 · Ejercicio 03 · Adivina el número  (dificultad: 3/5)
 *
 * Objetivo: un juego con intentos limitados que termina por su condición (sin break).
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej07_03_AdivinaElNumero.java
 */
import java.util.Random;
import java.util.Scanner;

public class Ej07_03_AdivinaElNumero {

    public static void main(String[] args) {

        // Ya hecho: constantes y herramientas
        final int MINIMO = 1;
        final int MAXIMO = 100;
        final int MAX_INTENTOS = 7;
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();      // Pon una semilla, p. ej. new Random(1), para probar

        // TODO 1: genera el número secreto entre MINIMO y MAXIMO (ambos incluidos).

        // Ya hecho: variables de control
        int intentos = 0;
        boolean acertado = false;

        System.out.println("He pensado un número del " + MINIMO + " al " + MAXIMO
                + ". Tienes " + MAX_INTENTOS + " intentos.");

        // TODO 2: while que siga mientras queden intentos Y no se haya acertado.
        //   Dentro:
        //   a) pide el número mostrando "Intento X de 7: "
        //   b) si está fuera de rango → avisa (no se cuenta el intento)
        //   c) si no → intentos++ y compara con el secreto (MAYOR / MENOR / ¡Correcto!)
        //      Si acierta, acertado = true.

        // TODO 3: mensaje final según "acertado".

        teclado.close();
    }
}
