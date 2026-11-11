/*
 * TEMA 07 · Bucles
 * Ejemplo 06: VALIDAR LA ENTRADA DEL USUARIO
 *
 * Este programa ESPERA datos. Prueba a equivocarte a propósito:
 *   en la edad escribe  -5  y después  150  y después  42
 *   en el número escribe  hola  y después  7
 *
 * Cómo ejecutarlo:  java T07_06_ValidarEntrada.java
 */
import java.util.Scanner;

public class T07_06_ValidarEntrada {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // ------------------------------------------------------------
        // 1. Validar un RANGO con do-while
        // ------------------------------------------------------------
        int edad;
        do {
            System.out.print("Edad (0-120): ");
            edad = teclado.nextInt();
            if (edad < 0 || edad > 120) {
                System.out.println("  Edad fuera de rango, prueba otra vez");
            }
        } while (edad < 0 || edad > 120);   // Se repite MIENTRAS el dato NO sea válido

        System.out.println("Edad aceptada: " + edad);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Validar el TIPO con hasNextInt()
        // ------------------------------------------------------------
        // Si escribes letras y llamas a nextInt(), el programa falla (InputMismatchException).
        // hasNextInt() mira lo siguiente SIN leerlo y dice si es un int.
        System.out.print("Escribe un número entero: ");
        while (!teclado.hasNextInt()) {
            String descartado = teclado.next();      // Hay que consumirlo; si no, se queda ahí para siempre
            System.out.print("  '" + descartado + "' no es un número. Otra vez: ");
        }
        int numero = teclado.nextInt();              // Ahora sabemos que es seguro

        System.out.println("Número aceptado: " + numero + " (su cuadrado es " + numero * numero + ")");

        // ------------------------------------------------------------
        // 3. Combinando las dos: tipo Y rango
        // ------------------------------------------------------------
        // Mientras no tengamos un dato válido, seguimos preguntando.
        // La bandera "valido" resume si ya lo tenemos.
        int puntuacion = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print("Puntuación (1-10): ");
            if (teclado.hasNextInt()) {
                puntuacion = teclado.nextInt();
                valido = puntuacion >= 1 && puntuacion <= 10;
                if (!valido) {
                    System.out.println("  Tiene que estar entre 1 y 10");
                }
            } else {
                System.out.println("  '" + teclado.next() + "' no es un número");
            }
        }
        System.out.println("Puntuación aceptada: " + puntuacion);

        teclado.close();
    }
}
