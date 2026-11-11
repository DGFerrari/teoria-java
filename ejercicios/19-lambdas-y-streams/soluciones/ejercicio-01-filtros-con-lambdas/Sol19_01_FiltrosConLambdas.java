/*
 * TEMA 19 · Ejercicio 01 · Filtros con lambdas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol19_01_FiltrosConLambdas.java
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Sol19_01_FiltrosConLambdas {

    // Recibe la CONDICIÓN como parámetro: el mismo método sirve para cualquier filtro
    static List<Integer> filtrar(List<Integer> numeros, Predicate<Integer> condicion) {
        List<Integer> resultado = new ArrayList<>();
        for (int n : numeros) {
            if (condicion.test(n)) {
                resultado.add(n);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        List<Integer> numeros = List.of(4, 9, 15, 22, 7, 30, 11, 18, 3);

        Predicate<Integer> esPar = n -> n % 2 == 0;
        Predicate<Integer> mayorQue10 = n -> n > 10;
        Predicate<Integer> multiploDe3 = n -> n % 3 == 0;

        System.out.println("Números: " + numeros);
        System.out.println("Pares: " + filtrar(numeros, esPar));
        System.out.println("Mayores que 10: " + filtrar(numeros, mayorQue10));
        System.out.println("Múltiplos de 3: " + filtrar(numeros, multiploDe3));
        System.out.println("Pares y mayores que 10: " + filtrar(numeros, esPar.and(mayorQue10)));
        System.out.println("Impares o múltiplos de 3: " + filtrar(numeros, esPar.negate().or(multiploDe3)));
        System.out.println("No múltiplos de 3: " + filtrar(numeros, multiploDe3.negate()));
        System.out.println("Acaban en 1 (lambda directa): " + filtrar(numeros, n -> n % 10 == 1));

        List<Integer> copia = new ArrayList<>(numeros);     // List.of es inmutable: se copia antes
        copia.removeIf(n -> n < 10);
        System.out.println("Sin los menores que 10 (removeIf): " + copia);

        System.out.print("Dobles con forEach:");
        copia.forEach(n -> System.out.print(" " + n * 2));
        System.out.println();
    }
}
