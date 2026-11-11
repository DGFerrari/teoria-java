/*
 * TEMA 08 · Ejercicio 02 · Estadísticas de notas  (dificultad: 2/5)
 *
 * Objetivo: guardar notas en un array y calcular estadísticas.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej08_02_EstadisticasDeNotas.java
 */
import java.util.Scanner;

public class Ej08_02_EstadisticasDeNotas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántos alumnos hay? ");
        int cantidad = teclado.nextInt();

        // TODO 1: crea el array de notas con el tamaño "cantidad".

        // TODO 2: pide la nota de cada alumno (numerados desde 1) y guárdala.

        // TODO 3: calcula la suma, la media, el máximo y el mínimo (con sus posiciones)
        //         y cuántos han aprobado.

        // TODO 4: muestra los resultados.

        // TODO 5: recorre otra vez el array para mostrar los que superan la media.

        teclado.close();
    }
}
