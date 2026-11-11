/*
 * TEMA 09 · Ejercicio 04 · Validador de contraseñas  (dificultad: 4/5)
 *
 * Objetivo: pedir una contraseña hasta que cumpla todas las reglas.
 *
 * Lee el ENUNCIADO.md antes de empezar (ahí está la tabla de reglas).
 * Cómo ejecutarlo:  java Ej09_04_ValidadorDeContrasenias.java
 */
import java.util.Scanner;

public class Ej09_04_ValidadorDeContrasenias {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Ya hecho: lectura del usuario
        System.out.print("Usuario: ");
        String usuario = teclado.nextLine().strip();

        final int LONGITUD_MINIMA = 8;
        int intentos = 0;
        boolean valida = false;

        // TODO 1: do-while que se repita mientras la contraseña no sea válida.
        //
        //   a) Pide la contraseña con nextLine() y suma 1 a intentos.
        //   b) Recorre la contraseña con banderas: mayúscula, minúscula,
        //      dígito, símbolo y espacio.
        //   c) Construye en un StringBuilder los mensajes de las reglas que fallan.
        //   d) valida = (no hay mensajes de error).
        //   e) Si no es válida, muestra "  Contraseña no válida:" y los mensajes.

        // TODO 2: muestra "Contraseña válida tras X intentos".

        teclado.close();
    }
}
