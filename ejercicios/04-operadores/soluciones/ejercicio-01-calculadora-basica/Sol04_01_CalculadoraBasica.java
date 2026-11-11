/*
 * TEMA 04 · Ejercicio 01 · Calculadora básica  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol04_01_CalculadoraBasica.java
 */
public class Sol04_01_CalculadoraBasica {

    public static void main(String[] args) {

        int a = 23;
        int b = 4;

        int suma = a + b;
        int resta = a - b;
        int multiplicacion = a * b;
        int cociente = a / b;                 // División entera
        int resto = a % b;                    // Lo que sobra de la división
        double division = (double) a / b;     // Convertimos ANTES de dividir

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("Cociente (división entera): " + cociente);
        System.out.println("Resto: " + resto);
        System.out.println("División con decimales: " + division);

        // cociente * divisor + resto siempre da el dividendo
        System.out.println("Comprobación: " + cociente + " * " + b + " + " + resto + " = " + (cociente * b + resto));
    }
}
