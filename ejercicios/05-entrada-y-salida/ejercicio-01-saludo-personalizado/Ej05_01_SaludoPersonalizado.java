/*
 * TEMA 05 · Ejercicio 01 · Saludo personalizado  (dificultad: 1/5)
 *
 * Objetivo: leer un texto y un número del teclado y usarlos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej05_01_SaludoPersonalizado.java
 */
import java.util.Scanner;

public class Ej05_01_SaludoPersonalizado {

    public static void main(String[] args) {

        // Ya hecho: el Scanner conectado al teclado
        Scanner teclado = new Scanner(System.in);

        // Ya hecho: primera pregunta y lectura
        System.out.print("¿Cómo te llamas? ");
        String nombre = teclado.nextLine();

        // TODO 1: pregunta la edad y léela con nextInt().

        // TODO 2: calcula la edad dentro de 10 años y los días vividos (edad * 365).

        // TODO 3: muestra el saludo y los dos resultados (usa printf con %,d para los días).

        teclado.close();
    }
}
