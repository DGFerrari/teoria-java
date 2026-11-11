/*
 * TEMA 07 · Ejercicio 04 · Números primos  (dificultad: 4/5)
 *
 * Objetivo: encontrar los primos de un rango con bucles anidados y banderas (sin break).
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej07_04_NumerosPrimos.java
 */
import java.util.Scanner;

public class Ej07_04_NumerosPrimos {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int inicio;
        int fin;

        // TODO 1: do-while que pida inicio y fin MIENTRAS inicio < 1 o fin < inicio.
        //         Si el rango no es válido, muestra el aviso del enunciado.
        inicio = 1;   // Borra estas dos líneas cuando escribas el do-while
        fin = 1;

        System.out.println("Primos entre " + inicio + " y " + fin + ":");

        int contador = 0;
        int suma = 0;

        // TODO 2: bucle exterior que recorra todos los números del rango.

            // TODO 3: bucle interior que busque divisores mientras
            //         divisor * divisor <= numero Y siga siendo primo.

            // TODO 4: si es primo → muéstralo, actualiza contador y suma,
            //         y salta de línea cada 10 primos.

        // TODO 5: si la última línea no se ha cerrado (contador no es múltiplo de 10),
        //         salta de línea. Después muestra el total y la suma.

        teclado.close();
    }
}
