/*
 * TEMA 19 · Ejercicio 01 · Filtros con lambdas  (dificultad: 1/5)
 *
 * Objetivo: escribir lambdas de tipo Predicate, combinarlas y usarlas con listas.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej19_01_FiltrosConLambdas.java
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ej19_01_FiltrosConLambdas {

    // TODO 1: devuelve una lista nueva con los números que cumplen la condición (condicion.test(n))
    static List<Integer> filtrar(List<Integer> numeros, Predicate<Integer> condicion) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        // NO TOCAR: los datos
        List<Integer> numeros = List.of(4, 9, 15, 22, 7, 30, 11, 18, 3);

        // TODO 2: crea tres Predicate<Integer> con lambdas: esPar, mayorQue10 y multiploDe3

        // TODO 3: muestra los filtrados (mira la salida esperada). Para las combinaciones,
        //         usa and, or y negate. Para "acaban en 1", escribe la lambda directamente en la llamada

        // TODO 4: en una COPIA modificable de la lista, borra con removeIf los menores que 10

        // TODO 5: con forEach, muestra el doble de cada número de la copia
    }
}
