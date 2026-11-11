/*
 * TEMA 10 · Ejercicio 01 · Métodos matemáticos  (dificultad: 1/5)
 *
 * Objetivo: escribir el contenido de cinco métodos sencillos.
 * El main ya está hecho: cuando completes los métodos, la salida será la del enunciado.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej10_01_MetodosMatematicos.java
 */
public class Ej10_01_MetodosMatematicos {

    // NO TOCAR: el main que usa los métodos
    public static void main(String[] args) {
        System.out.println("Área de 4.5 x 2: " + areaRectangulo(4.5, 2));
        System.out.println("Perímetro de 4.5 x 2: " + perimetroRectangulo(4.5, 2));
        System.out.println("¿15 es múltiplo de 5? " + esMultiplo(15, 5));
        System.out.println("¿15 es múltiplo de 4? " + esMultiplo(15, 4));
        System.out.println("Máximo de 7, 19 y 3: " + maximoDeTres(7, 19, 3));
        System.out.println("Máximo de -2, -8 y -5: " + maximoDeTres(-2, -8, -5));
        System.out.printf("36.6 ºC = %.2f ºF%n", celsiusAFahrenheit(36.6));
    }

    /** Devuelve el área de un rectángulo. */
    static double areaRectangulo(double base, double altura) {
        // TODO 1
        return 0;
    }

    /** Devuelve el perímetro de un rectángulo. */
    static double perimetroRectangulo(double base, double altura) {
        // TODO 2
        return 0;
    }

    /** Devuelve true si numero es múltiplo de divisor. */
    static boolean esMultiplo(int numero, int divisor) {
        // TODO 3
        return false;
    }

    /** Devuelve el mayor de tres números. */
    static int maximoDeTres(int a, int b, int c) {
        // TODO 4
        return 0;
    }

    /** Convierte grados Celsius a Fahrenheit. */
    static double celsiusAFahrenheit(double celsius) {
        // TODO 5
        return 0;
    }
}
