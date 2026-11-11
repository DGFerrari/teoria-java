/*
 * TEMA 05 · Ejercicio 03 · Encuesta rota  (dificultad: 3/5)
 *
 * Este programa compila y se ejecuta, pero algunas preguntas se saltan solas.
 * Objetivo: entender por qué, arreglarlo y completar la encuesta.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej05_03_EncuestaRota.java
 */
import java.util.Scanner;

public class Ej05_03_EncuestaRota {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("=== ENCUESTA DE BIENVENIDA ===");

        System.out.print("Nombre completo: ");
        String nombre = teclado.nextLine();

        System.out.print("Edad: ");
        int edad = teclado.nextInt();

        // TODO 1: esta pregunta se salta sola. ¿Por qué? Arréglalo.
        // Explicación: ...
        System.out.print("Ciudad: ");
        String ciudad = teclado.nextLine();

        System.out.print("Número de hermanos: ");
        int hermanos = teclado.nextInt();

        // TODO 2: esta también se salta. Arréglalo.
        System.out.print("Comida favorita: ");
        String comida = teclado.nextLine();

        // TODO 3: pregunta y lee la letra del grupo (char).

        // TODO 4: muestra el resumen con printf (mira la salida esperada).
        System.out.println();
        System.out.println("--- Resumen ---");

        teclado.close();
    }
}
