/*
 * TEMA 10 · Ejercicio 05 · El ahorcado  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol10_05_ElAhorcado.java
 */
import java.util.Random;
import java.util.Scanner;

public class Sol10_05_ElAhorcado {

    static final int MAX_FALLOS = 6;

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

    /** Devuelve una palabra al azar del array. */
    static String elegirPalabra(String[] palabras, Random random) {
        return palabras[random.nextInt(palabras.length)];   // Índice entre 0 y length - 1
    }

    /** Devuelve un char[] del tamaño de la palabra lleno de '_'. */
    static char[] crearProgreso(String palabra) {
        char[] progreso = new char[palabra.length()];
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }
        return progreso;
    }

    /** Muestra "Palabra: _ a _ a" (cada carácter seguido de un espacio). */
    static void mostrarProgreso(char[] progreso) {
        StringBuilder texto = new StringBuilder("Palabra: ");
        for (char c : progreso) {
            texto.append(c).append(' ');
        }
        System.out.println(texto.toString().stripTrailing());
    }

    /** Dibuja el ahorcado según el número de fallos (0 a 6). */
    static void dibujarAhorcado(int fallos) {
        // Cada parte aparece a partir de cierto número de fallos
        String cabeza = fallos >= 1 ? "O" : " ";
        String cuerpo = fallos >= 2 ? "|" : " ";
        String brazoIzquierdo = fallos >= 3 ? "/" : " ";
        String brazoDerecho = fallos >= 4 ? "\\" : " ";
        String piernaIzquierda = fallos >= 5 ? "/" : " ";
        String piernaDerecha = fallos >= 6 ? "\\" : " ";

        System.out.println("  +---+");
        System.out.println("  " + cabeza + "   |");
        System.out.println(" " + brazoIzquierdo + cuerpo + brazoDerecho + "  |");
        System.out.println(" " + piernaIzquierda + " " + piernaDerecha + "  |");
        System.out.println("     ===");

        // Mensaje según la gravedad
        String aviso = switch (fallos) {
            case 0, 1, 2 -> "";
            case 3, 4 -> "  (¡Cuidado!)";
            case 5 -> "  (¡Último intento!)";
            default -> "  (Ahorcado)";
        };
        if (!aviso.isEmpty()) {
            System.out.println(aviso);
        }
    }

    /**
     * Pide una letra hasta que sea UNA sola letra y no esté en "usadas".
     * Devuelve la letra en minúscula.
     */
    static char leerLetra(Scanner teclado, String usadas) {
        char letra = ' ';
        boolean valida = false;
        while (!valida) {
            System.out.print("Letra: ");
            String entrada = teclado.nextLine().strip().toLowerCase();
            // El cortocircuito de || evita charAt(0) cuando la entrada está vacía
            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("  Escribe una sola letra.");
            } else if (usadas.indexOf(entrada.charAt(0)) != -1) {
                System.out.println("  Ya has usado la '" + entrada + "'.");
            } else {
                letra = entrada.charAt(0);
                valida = true;
            }
        }
        return letra;
    }

    /**
     * MODIFICA "progreso": destapa la letra en todas las posiciones donde aparece.
     * Devuelve cuántas posiciones ha destapado.
     */
    static int revelar(String palabra, char[] progreso, char letra) {
        int aciertos = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                progreso[i] = letra;          // Es el mismo array que el del main
                aciertos++;
            }
        }
        return aciertos;
    }

    /** ¿Ya no queda ningún '_'? Bandera en la condición y un único return. */
    static boolean estaCompleta(char[] progreso) {
        boolean quedaHueco = false;
        int i = 0;
        while (i < progreso.length && !quedaHueco) {
            quedaHueco = progreso[i] == '_';
            i++;
        }
        return !quedaHueco;
    }
}
