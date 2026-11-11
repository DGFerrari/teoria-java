/*
 * TEMA 04 · Ejercicio 04 · Dados y azar  (dificultad: 4/5)
 *
 * Objetivo: generar valores aleatorios en distintos rangos y comprobarlos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej04_04_DadosYAzar.java
 */

// Ya hecho: import necesario para usar Random
import java.util.Random;

public class Ej04_04_DadosYAzar {

    public static void main(String[] args) {

        // Ya hecho: el generador (pon un número entre los paréntesis
        // para usar una semilla y obtener siempre los mismos valores)
        Random random = new Random();

        // ------------------------------------------------------------
        // 1. Dos dados
        // ------------------------------------------------------------
        // TODO 1: genera dado1 y dado2 (1 a 6), su suma,
        //         esDoble y sumaPar (boolean).

        // ------------------------------------------------------------
        // 2. Carta
        // ------------------------------------------------------------
        // TODO 2: genera numeroCarta (1 a 12) y palo (0 a 3).

        // ------------------------------------------------------------
        // 3. Temperatura
        // ------------------------------------------------------------
        // TODO 3: genera temperatura (-5.0 a 35.0) y redondéala a un decimal.

        // ------------------------------------------------------------
        // 4. Código secreto
        // ------------------------------------------------------------
        int min = 100;
        int max = 999;
        // TODO 4: genera el código con la fórmula general,
        //         separa sus tres cifras y súmalas.

        // ------------------------------------------------------------
        // 5. Moneda
        // ------------------------------------------------------------
        // TODO 5: genera "cara" (boolean).

        // ------------------------------------------------------------
        // 6. Salida y comprobaciones
        // ------------------------------------------------------------
        // TODO 6: muestra todo (mira la salida de ejemplo) y las
        //         cuatro comprobaciones de rango.
    }
}
