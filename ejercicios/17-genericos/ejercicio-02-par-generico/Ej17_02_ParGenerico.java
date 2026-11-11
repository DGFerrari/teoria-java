/*
 * TEMA 17 · Ejercicio 02 · Par genérico  (dificultad: 2/5)
 *
 * Objetivo: una clase con dos parámetros de tipo y métodos genéricos que la usan.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej17_02_ParGenerico.java
 */
import java.util.ArrayList;
import java.util.List;

public class Ej17_02_ParGenerico {

    // TODO 1: clase inmutable Par<A, B> con:
    //         - atributos final "primero" (A) y "segundo" (B), constructor y getters
    //         - invertir(): devuelve un Par<B, A> con los valores cambiados de sitio
    //         - toString(): "(primero, segundo)"
    static class Par {
    }

    // TODO 2: static <A, B> List<Par<A, B>> emparejar(List<A> primeros, List<B> segundos)
    //         Une las dos listas posición a posición hasta que se acabe la más corta

    // TODO 3: static <A, B> Par<A, B> buscarPorPrimero(List<Par<A, B>> pares, A clave)
    //         El primer par cuyo primer elemento es igual (equals) a la clave, o null. Con bandera

    public static void main(String[] args) {
        // TODO 4: crea el par ("Ana", 15), muéstralo e invertido
        // TODO 5: empareja ["Ana", "Luis", "Marta", "Pablo"] con [15, 17, 16] y muestra el resultado
        // TODO 6: busca la edad de Luis y busca a Pablo
        // TODO 7: empareja [1, 2, 3] con ['A', 'B', 'C', 'D']
    }
}
