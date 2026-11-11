/*
 * TEMA 01 · Ejercicio 04 · Traza de un bucle  (dificultad: 4/5)
 *
 * Objetivo: hacer la traza del algoritmo a mano y después comprobarla
 *           ejecutando el mismo algoritmo en Java.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej01_04_TrazaDeUnBucle.java
 */
public class Ej01_04_TrazaDeUnBucle {

    public static void main(String[] args) {

        // TODO 0: haz la traza ANTES de programar. Rellena la tabla:
        //
        //   Vuelta | total después | valor después
        //   -------+---------------+--------------
        //     1    |               |
        //     2    |               |
        //     3    |               |
        //     4    |               |
        //     5    |               |
        //
        //   ¿Qué calcula el algoritmo?  ...

        // Ya hecho: valores iniciales
        int valor = 1;
        int total = 0;
        int vuelta = 1;

        // TODO 1: escribe el bucle while con la condición del pseudocódigo.

            // TODO 2: dentro del bucle, en este orden:
            //   a) suma valor a total
            //   b) duplica valor
            //   c) muestra "Vuelta X -> total = ..., valor = ..."
            //   d) suma 1 a vuelta

        // Ya hecho: resultado final (fuera del bucle)
        System.out.println("Resultado final: total = " + total + ", valor = " + valor);

        // TODO 3: compara la salida con tu traza. ¿Coinciden?
    }
}
