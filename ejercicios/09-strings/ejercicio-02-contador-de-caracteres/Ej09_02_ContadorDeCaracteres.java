/*
 * TEMA 09 · Ejercicio 02 · Contador de caracteres  (dificultad: 2/5)
 *
 * Objetivo: recorrer una frase y clasificar cada carácter.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej09_02_ContadorDeCaracteres.java
 */
import java.util.Scanner;

public class Ej09_02_ContadorDeCaracteres {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Escribe una frase: ");
        String frase = teclado.nextLine();

        // Ya hecho: la lista de vocales y los contadores
        final String VOCALES = "aeiouáéíóúü";
        int vocales = 0;
        int consonantes = 0;
        int digitos = 0;
        int espacios = 0;
        int otros = 0;
        StringBuilder sinVocales = new StringBuilder();

        // TODO 1: recorre la frase carácter a carácter y actualiza los contadores.
        //         Añade a "sinVocales" todos los caracteres que no sean vocales.

        // TODO 2: muestra los resultados (mira la salida esperada).

        teclado.close();
    }
}
