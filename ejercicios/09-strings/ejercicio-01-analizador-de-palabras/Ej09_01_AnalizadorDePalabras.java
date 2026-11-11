/*
 * TEMA 09 · Ejercicio 01 · Analizador de palabras  (dificultad: 1/5)
 *
 * Objetivo: practicar los métodos básicos de String.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej09_01_AnalizadorDePalabras.java
 */
import java.util.Scanner;

public class Ej09_01_AnalizadorDePalabras {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Ya hecho: lectura de la palabra (sin espacios alrededor)
        System.out.print("Escribe una palabra: ");
        String palabra = teclado.nextLine().strip();

        // TODO: muestra, una por línea:
        //   1. la longitud
        //   2. la primera y la última letra
        //   3. la palabra en mayúsculas y en minúsculas
        //   4. la primera mitad
        //   5. la posición de la primera 'a' (sin importar mayúsculas)
        //   6. si contiene "gram"

        teclado.close();
    }
}
