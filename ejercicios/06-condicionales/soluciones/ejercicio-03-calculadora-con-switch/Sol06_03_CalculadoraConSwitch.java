/*
 * TEMA 06 · Ejercicio 03 · Calculadora con switch  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol06_03_CalculadoraConSwitch.java
 */
import java.util.Scanner;

public class Sol06_03_CalculadoraConSwitch {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Primer número: ");
        double a = teclado.nextDouble();
        System.out.print("Operador (+ - * / % ^): ");
        char operador = teclado.next().charAt(0);
        System.out.print("Segundo número: ");
        double b = teclado.nextDouble();

        double resultado = 0;
        boolean hayError = false;

        // switch como instrucción: algunos casos no producen resultado
        switch (operador) {
            case '+' -> resultado = a + b;
            case '-' -> resultado = a - b;
            case '*' -> resultado = a * b;
            case '/', '%' -> {
                // Con double, dividir entre 0 no da error (da Infinity): lo controlamos nosotros
                if (b == 0) {
                    System.out.println("Error: no se puede dividir entre 0");
                    hayError = true;
                } else {
                    resultado = operador == '/' ? a / b : a % b;
                }
            }
            case '^' -> resultado = Math.pow(a, b);
            default -> {
                System.out.println("Operador no válido: " + operador);
                hayError = true;
            }
        }

        if (!hayError) {
            // Ternario: sin decimales si el número es entero, con 2 si no
            String formatoA = a == Math.floor(a) ? "%.0f" : "%.2f";
            String formatoB = b == Math.floor(b) ? "%.0f" : "%.2f";
            String formatoResultado = resultado == Math.floor(resultado) ? "%.0f" : "%.2f";

            String textoA = String.format(formatoA, a);
            String textoB = String.format(formatoB, b);
            String textoResultado = String.format(formatoResultado, resultado);

            System.out.println(textoA + " " + operador + " " + textoB + " = " + textoResultado);
        }

        teclado.close();
    }
}
