/*
 * TEMA 09 · Ejercicio 01 · Analizador de palabras  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol09_01_AnalizadorDePalabras.java
 */
import java.util.Scanner;

public class Sol09_01_AnalizadorDePalabras {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Escribe una palabra: ");
        String palabra = teclado.nextLine().strip();

        System.out.println("Longitud: " + palabra.length());
        System.out.println("Primera letra: " + palabra.charAt(0));
        System.out.println("Última letra: " + palabra.charAt(palabra.length() - 1));   // Último índice = length - 1
        System.out.println("En mayúsculas: " + palabra.toUpperCase());
        System.out.println("En minúsculas: " + palabra.toLowerCase());
        System.out.println("Primera mitad: " + palabra.substring(0, palabra.length() / 2));
        System.out.println("Posición de la primera 'a': " + palabra.toLowerCase().indexOf('a'));
        System.out.println("¿Contiene \"gram\"? " + palabra.contains("gram"));

        teclado.close();
    }
}
