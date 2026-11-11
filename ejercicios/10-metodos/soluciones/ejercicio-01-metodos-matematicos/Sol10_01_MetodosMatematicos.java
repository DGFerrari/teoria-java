/*
 * TEMA 10 · Ejercicio 01 · Métodos matemáticos  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol10_01_MetodosMatematicos.java
 */
public class Sol10_01_MetodosMatematicos {

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
        return base * altura;
    }

    /** Devuelve el perímetro de un rectángulo. */
    static double perimetroRectangulo(double base, double altura) {
        return 2 * (base + altura);
    }

    /** Devuelve true si numero es múltiplo de divisor. */
    static boolean esMultiplo(int numero, int divisor) {
        return numero % divisor == 0;        // La comparación ya es un boolean
    }

    /** Devuelve el mayor de tres números (empezando por el primero, como con los arrays). */
    static int maximoDeTres(int a, int b, int c) {
        int maximo = a;
        if (b > maximo) {
            maximo = b;
        }
        if (c > maximo) {
            maximo = c;
        }
        return maximo;
    }

    /** Convierte grados Celsius a Fahrenheit. */
    static double celsiusAFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}
