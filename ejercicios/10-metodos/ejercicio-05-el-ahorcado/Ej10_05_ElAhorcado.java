/*
 * TEMA 10 · Ejercicio 05 · El ahorcado  (dificultad: 5/5)
 *
 * Objetivo: escribir los métodos que usa el main para jugar al ahorcado.
 *
 * Lee el ENUNCIADO.md antes de empezar (ahí está la tabla de métodos).
 * Cómo ejecutarlo:  java Ej10_05_ElAhorcado.java
 *
 * Regla: sin break ni continue, y sin return dentro de los bucles.
 */
import java.util.Random;
import java.util.Scanner;

public class Ej10_05_ElAhorcado {

    static final int MAX_FALLOS = 6;

    // NO TOCAR: el main se lee como un resumen del juego
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        String[] palabras = {"programa", "variable", "funcion", "bucle", "objeto", "compilar", "matriz"};
        String palabra = elegirPalabra(palabras, random);
        char[] progreso = crearProgreso(palabra);
        String usadas = "";
        int fallos = 0;

        System.out.println("=== EL AHORCADO ===");
        while (fallos < MAX_FALLOS && !estaCompleta(progreso)) {
            System.out.println();
            dibujarAhorcado(fallos);
            mostrarProgreso(progreso);
            System.out.println("Letras usadas: " + usadas);
            System.out.println("Fallos: " + fallos + " de " + MAX_FALLOS);

            char letra = leerLetra(teclado, usadas);
            usadas += letra;

            int aciertos = revelar(palabra, progreso, letra);
            if (aciertos > 0) {
                System.out.println("  ¡Bien! La '" + letra + "' aparece " + aciertos + " vez/veces.");
            } else {
                System.out.println("  La '" + letra + "' no está.");
                fallos++;
            }
        }

        System.out.println();
        dibujarAhorcado(fallos);
        if (estaCompleta(progreso)) {
            System.out.println("¡Has ganado! La palabra era: " + palabra);
        } else {
            System.out.println("Has perdido. La palabra era: " + palabra);
        }
        teclado.close();
    }

    // ============================================================
    // TODO: escribe el contenido de cada método
    // ============================================================

    /** Devuelve una palabra al azar del array. */
    static String elegirPalabra(String[] palabras, Random random) {
        // TODO 1
        return palabras[0];
    }

    /** Devuelve un char[] del tamaño de la palabra lleno de '_'. */
    static char[] crearProgreso(String palabra) {
        // TODO 2
        return new char[0];
    }

    /** Muestra "Palabra: _ a _ a" (cada carácter seguido de un espacio). */
    static void mostrarProgreso(char[] progreso) {
        // TODO 3
    }

    /** Dibuja el ahorcado según el número de fallos (0 a 6). Usa un switch. */
    static void dibujarAhorcado(int fallos) {
        // TODO 4
    }

    /**
     * Pide una letra hasta que sea UNA sola letra y no esté en "usadas".
     * Devuelve la letra en minúscula.
     */
    static char leerLetra(Scanner teclado, String usadas) {
        // TODO 5 (bucle con bandera)
        System.out.print("Letra: ");
        return teclado.nextLine().charAt(0);
    }

    /**
     * MODIFICA "progreso": destapa la letra en todas las posiciones donde aparece en la palabra.
     * Devuelve cuántas posiciones ha destapado.
     */
    static int revelar(String palabra, char[] progreso, char letra) {
        // TODO 6
        return 0;
    }

    /** ¿Ya no queda ningún '_'? (bandera en la condición, sin return dentro del bucle) */
    static boolean estaCompleta(char[] progreso) {
        // TODO 7
        return true;
    }
}
