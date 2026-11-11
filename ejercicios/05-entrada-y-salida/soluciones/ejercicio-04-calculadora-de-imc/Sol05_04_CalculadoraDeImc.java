/*
 * TEMA 05 · Ejercicio 04 · Calculadora de IMC  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol05_04_CalculadoraDeImc.java
 */
import java.util.Scanner;

public class Sol05_04_CalculadoraDeImc {

    public static void main(String[] args) {

        final double IMC_MINIMO = 18.5;
        final double IMC_MAXIMO = 24.9;

        Scanner teclado = new Scanner(System.in);

        // ENTRADA (el texto primero para evitar el problema de nextLine)
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Peso (kg): ");
        double peso = teclado.nextDouble();

        System.out.print("Altura (cm): ");
        int alturaCm = teclado.nextInt();

        // PROCESO
        double alturaM = alturaCm / 100.0;                  // 100.0 → división decimal
        double alturaAlCuadrado = Math.pow(alturaM, 2);
        double imc = peso / alturaAlCuadrado;
        double pesoMinimo = IMC_MINIMO * alturaAlCuadrado;
        double pesoMaximo = IMC_MAXIMO * alturaAlCuadrado;
        boolean enRango = imc >= IMC_MINIMO && imc <= IMC_MAXIMO;

        // SALIDA
        System.out.println();
        System.out.printf("=== Informe de %s ===%n", nombre);
        System.out.printf("Altura: %.2f m%n", alturaM);
        System.out.printf("IMC: %.1f%n", imc);
        System.out.printf("Peso saludable para tu altura: de %.1f a %.1f kg%n", pesoMinimo, pesoMaximo);
        System.out.printf("¿IMC en rango saludable? %b%n", enRango);

        teclado.close();
    }
}
