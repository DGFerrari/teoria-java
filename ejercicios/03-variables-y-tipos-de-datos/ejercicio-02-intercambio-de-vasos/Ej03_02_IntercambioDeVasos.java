/*
 * TEMA 03 · Ejercicio 02 · Intercambio de vasos  (dificultad: 2/5)
 *
 * Objetivo: intercambiar y rotar valores entre variables sin perder ninguno.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej03_02_IntercambioDeVasos.java
 */
public class Ej03_02_IntercambioDeVasos {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // Parte A · Intercambio de dos variables
        // ------------------------------------------------------------
        String vasoA = "zumo";
        String vasoB = "leche";
        System.out.println("Antes:   vasoA = " + vasoA + " | vasoB = " + vasoB);

        // TODO A: intercambia los valores usando una variable auxiliar.
        //         NO escribas "zumo" ni "leche" otra vez.

        System.out.println("Después: vasoA = " + vasoA + " | vasoB = " + vasoB);

        // ------------------------------------------------------------
        // Parte B · Rotación de tres variables
        // ------------------------------------------------------------
        int x = 1;
        int y = 2;
        int z = 3;
        System.out.println("Antes:   x = " + x + " | y = " + y + " | z = " + z);

        // TODO B: rota los valores: x ← y, y ← z, z ← (el x original).
        //         Usa UNA sola variable auxiliar.

        System.out.println("Después: x = " + x + " | y = " + y + " | z = " + z);
    }
}
