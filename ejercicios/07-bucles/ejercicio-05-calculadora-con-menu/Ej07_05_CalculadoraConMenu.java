/*
 * TEMA 07 · Ejercicio 05 · Calculadora con menú  (dificultad: 5/5)
 *
 * Objetivo: calculadora con menú repetitivo, validación de entrada y estadísticas.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej07_05_CalculadoraConMenu.java
 *
 * Regla: sin continue y con break solo dentro de un switch.
 */
import java.util.Scanner;

public class Ej07_05_CalculadoraConMenu {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Ya hecho: variables para las estadísticas
        int operaciones = 0;
        int errores = 0;
        int opcionesNoValidas = 0;
        double sumaResultados = 0;
        double maximo = 0;

        int opcion;

        // TODO 1: do-while que se repita mientras la opción no sea 0.
        //
        //   a) Muestra el menú (ya tienes el texto en el enunciado).
        //
        //   b) Lee la opción validando que sea un int (hasNextInt).
        //      Para que compile mientras programas, de momento:
        opcion = 0;
        //
        //   c) switch sobre la opción:
        //      - 1, 2, 3, 4: lee dos números (validando con hasNextDouble),
        //        calcula. Si es una división entre 0 → error.
        //        Si no → muestra el resultado y actualiza operaciones,
        //        sumaResultados y maximo.
        //      - 0: no hace nada (el bucle terminará solo).
        //      - default: "Opción no válida" y opcionesNoValidas++.

        // TODO 2: muestra las estadísticas (mira la salida esperada).
        //         Cuidado: la media solo se puede calcular si operaciones > 0.

        teclado.close();
    }
}
