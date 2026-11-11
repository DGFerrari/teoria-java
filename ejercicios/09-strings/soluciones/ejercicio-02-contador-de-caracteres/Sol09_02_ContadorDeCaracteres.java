/*
 * TEMA 09 · Ejercicio 02 · Contador de caracteres  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol09_02_ContadorDeCaracteres.java
 */
import java.util.Scanner;

public class Sol09_02_ContadorDeCaracteres {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Escribe una frase: ");
        String frase = teclado.nextLine();

        final String VOCALES = "aeiouáéíóúü";
        int vocales = 0;
        int consonantes = 0;
        int digitos = 0;
        int espacios = 0;
        int otros = 0;
        StringBuilder sinVocales = new StringBuilder();

        for (char c : frase.toCharArray()) {
            // ¿Está c (en minúscula) en la lista de vocales?
            boolean esVocal = VOCALES.indexOf(Character.toLowerCase(c)) != -1;

            // Cada carácter cae en una sola categoría
            if (Character.isLetter(c)) {
                if (esVocal) {
                    vocales++;
                } else {
                    consonantes++;
                }
            } else if (Character.isDigit(c)) {
                digitos++;
            } else if (Character.isWhitespace(c)) {
                espacios++;
            } else {
                otros++;
            }

            if (!esVocal) {
                sinVocales.append(c);
            }
        }

        System.out.println("Vocales: " + vocales);
        System.out.println("Consonantes: " + consonantes);
        System.out.println("Dígitos: " + digitos);
        System.out.println("Espacios: " + espacios);
        System.out.println("Otros: " + otros);
        System.out.println("Sin vocales: " + sinVocales);

        teclado.close();
    }
}
