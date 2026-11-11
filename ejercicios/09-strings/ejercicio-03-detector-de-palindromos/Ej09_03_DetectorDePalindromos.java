/*
 * TEMA 09 · Ejercicio 03 · Detector de palíndromos  (dificultad: 3/5)
 *
 * Objetivo: normalizar un texto y comprobar si es palíndromo de dos formas.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej09_03_DetectorDePalindromos.java
 */
import java.util.Scanner;

public class Ej09_03_DetectorDePalindromos {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Escribe una frase: ");
        String frase = teclado.nextLine();

        // TODO 1: pasa la frase a minúsculas y quita las tildes (y la diéresis).
        String sinTildes = frase;

        // TODO 2: construye "normalizada" con solo letras y dígitos (StringBuilder).
        String normalizada = sinTildes;

        // TODO 3: dale la vuelta con StringBuilder.reverse().
        String alReves = "";

        System.out.println("Normalizada: " + normalizada);
        System.out.println("Al revés:    " + alReves);

        // TODO 4: compara con equals.

        // TODO 5: segunda forma: dos índices desde los extremos hacia el centro,
        //         parando en cuanto encuentres una diferencia (bandera, sin break).

        teclado.close();
    }
}
