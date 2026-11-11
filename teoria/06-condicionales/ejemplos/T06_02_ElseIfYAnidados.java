/*
 * TEMA 06 · Condicionales
 * Ejemplo 02: else if Y CONDICIONALES ANIDADOS
 *
 * Este programa ESPERA a que escribas una nota (por ejemplo 7,5) y una edad.
 *
 * Cómo ejecutarlo:  java T06_02_ElseIfYAnidados.java
 */
import java.util.Scanner;

public class T06_02_ElseIfYAnidados {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // ------------------------------------------------------------
        // 1. Cadena else if: casos excluyentes, comprobados en orden
        // ------------------------------------------------------------
        System.out.print("Escribe una nota (0-10): ");
        double nota = teclado.nextDouble();

        // Primero descartamos lo inválido; luego, de la nota más alta a la más baja.
        // Al llegar a cada else if ya sabemos que las condiciones anteriores eran false.
        if (nota < 0 || nota > 10) {
            System.out.println("Nota no válida");
        } else if (nota >= 9) {
            System.out.println("Sobresaliente");
        } else if (nota >= 7) {          // Aquí ya sabemos que nota < 9
            System.out.println("Notable");
        } else if (nota >= 6) {
            System.out.println("Bien");
        } else if (nota >= 5) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Suspenso");
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. ¿Por qué importa el orden?
        // ------------------------------------------------------------
        // Si la comprobación más "amplia" va primero, tapa a las demás:
        double notaEjemplo = 9.5;
        if (notaEjemplo >= 5) {
            System.out.println("Orden incorrecto → Aprobado (¡pero es un 9.5!)");
        } else if (notaEjemplo >= 9) {
            System.out.println("Sobresaliente (nunca se llega aquí)");
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3. Anidados: la segunda pregunta solo tiene sentido si la primera se cumple
        // ------------------------------------------------------------
        System.out.print("¿Qué edad tienes? ");
        int edad = teclado.nextInt();
        boolean tieneEntrada = true;

        if (tieneEntrada) {
            if (edad >= 18) {
                System.out.println("Puedes entrar al concierto");
            } else if (edad >= 14) {
                System.out.println("Puedes entrar acompañado de un adulto");
            } else {
                System.out.println("El concierto es para mayores de 14 años");
            }
        } else {
            System.out.println("Primero tienes que comprar una entrada");
        }
        System.out.println();

        // ------------------------------------------------------------
        // 4. Aplanar: el mismo resultado con && suele leerse mejor
        // ------------------------------------------------------------
        if (!tieneEntrada) {
            System.out.println("Primero tienes que comprar una entrada");
        } else if (edad >= 18) {
            System.out.println("Puedes entrar al concierto");
        } else if (edad >= 14) {
            System.out.println("Puedes entrar acompañado de un adulto");
        } else {
            System.out.println("El concierto es para mayores de 14 años");
        }

        teclado.close();
    }
}
