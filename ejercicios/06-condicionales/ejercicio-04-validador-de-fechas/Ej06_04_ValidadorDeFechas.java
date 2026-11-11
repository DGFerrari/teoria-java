/*
 * TEMA 06 · Ejercicio 04 · Validador de fechas  (dificultad: 4/5)
 *
 * Objetivo: validar una fecha, detectar el fin de mes y calcular el día siguiente.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej06_04_ValidadorDeFechas.java
 */
import java.util.Scanner;

public class Ej06_04_ValidadorDeFechas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Ya hecho: lectura de la fecha
        System.out.print("Día: ");
        int dia = teclado.nextInt();
        System.out.print("Mes: ");
        int mes = teclado.nextInt();
        System.out.print("Año: ");
        int anio = teclado.nextInt();

        // TODO 1: calcula los días del mes con un switch como expresión.
        //         Febrero: 29 si el año es bisiesto, 28 si no (usa yield).
        //         Mes inexistente: 0.
        int diasDelMes = 0;

        // TODO 2: calcula si la fecha es válida (boolean).

        // TODO 3: si es válida:
        //   a) muestra la fecha con formato dd/mm/aaaa
        //   b) muestra si es el último día del mes
        //   c) calcula el día siguiente (3 casos) y muéstralo
        //   Si no es válida, muestra "Fecha no válida".

        teclado.close();
    }
}
