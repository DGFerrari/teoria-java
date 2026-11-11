/*
 * TEMA 03 · Ejercicio 04 · Detective de tipos  (dificultad: 4/5)
 *
 * Este programa compila y se ejecuta, pero los 5 resultados son INCORRECTOS.
 * Objetivo: entender por qué falla cada caso y arreglarlo.
 *
 * Lee el ENUNCIADO.md antes de empezar (ahí están los resultados esperados).
 * Cómo ejecutarlo:  java Ej03_04_DetectiveDeTipos.java
 */
public class Ej03_04_DetectiveDeTipos {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // Caso A · Segundos en un siglo
        // ------------------------------------------------------------
        // TODO A: ¿por qué sale un número negativo? Arréglalo.
        // Explicación: ...
        int segundosSiglo = 100 * 365 * 24 * 60 * 60;
        System.out.println("A) Segundos en un siglo: " + segundosSiglo);

        // ------------------------------------------------------------
        // Caso B · Media de tres notas
        // ------------------------------------------------------------
        // TODO B: ¿por qué sale 7? Arréglalo.
        // Explicación: ...
        int nota1 = 7;
        int nota2 = 8;
        int nota3 = 8;
        int suma = nota1 + nota2 + nota3;
        int media = suma / 3;
        System.out.println("B) Media de las notas: " + media);

        // ------------------------------------------------------------
        // Caso C · Letra siguiente
        // ------------------------------------------------------------
        // TODO C: ¿por qué sale un número? Arréglalo.
        // Explicación: ...
        char letra = 'm';
        System.out.println("C) Letra siguiente a " + letra + ": " + (letra + 1));

        // ------------------------------------------------------------
        // Caso D · Suma de números que llegan como texto
        // ------------------------------------------------------------
        // TODO D: ¿por qué sale 2517? Arréglalo.
        // Explicación: ...
        String textoA = "25";
        String textoB = "17";
        System.out.println("D) " + textoA + " + " + textoB + " = " + (textoA + textoB));

        // ------------------------------------------------------------
        // Caso E · Redondear un precio
        // ------------------------------------------------------------
        // TODO E: ¿por qué sale 19? Arréglalo.
        // Explicación: ...
        double precio = 19.99;
        int redondeado = (int) precio;
        System.out.println("E) " + precio + " redondeado: " + redondeado);
    }
}
