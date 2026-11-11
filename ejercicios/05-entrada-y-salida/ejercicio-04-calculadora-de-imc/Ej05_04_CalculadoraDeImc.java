/*
 * TEMA 05 · Ejercicio 04 · Calculadora de IMC  (dificultad: 4/5)
 *
 * Objetivo: leer datos de distintos tipos, calcular el IMC y mostrar un informe.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej05_04_CalculadoraDeImc.java
 */
import java.util.Scanner;

public class Ej05_04_CalculadoraDeImc {

    public static void main(String[] args) {

        // Ya hecho: constantes del rango saludable
        final double IMC_MINIMO = 18.5;
        final double IMC_MAXIMO = 24.9;

        Scanner teclado = new Scanner(System.in);

        // ------------------------------------------------------------
        // ENTRADA
        // ------------------------------------------------------------
        // TODO 1: pide y lee el nombre (texto), el peso (double)
        //         y la altura en centímetros (int).

        // ------------------------------------------------------------
        // PROCESO
        // ------------------------------------------------------------
        // TODO 2: convierte la altura a metros y calcula la altura al cuadrado.

        // TODO 3: calcula el IMC y el rango de peso saludable.

        // TODO 4: calcula si el IMC está dentro del rango (boolean).

        // ------------------------------------------------------------
        // SALIDA
        // ------------------------------------------------------------
        // TODO 5: muestra el informe con printf (mira la salida esperada).

        teclado.close();
    }
}
