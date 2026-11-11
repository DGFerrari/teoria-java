/*
 * TEMA 19 · Lambdas y streams
 * Ejemplo 02: las interfaces funcionales del JDK (java.util.function)
 *
 * Cómo ejecutarlo:  java T19_02_InterfacesFuncionales.java
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class T19_02_InterfacesFuncionales {

    // Métodos genéricos (tema 17) que reciben interfaces funcionales
    static <T> List<T> filtrar(List<T> lista, Predicate<T> condicion) {
        List<T> resultado = new ArrayList<>();
        for (T elemento : lista) {
            if (condicion.test(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    static <T, R> List<R> transformar(List<T> lista, Function<T, R> funcion) {
        List<R> resultado = new ArrayList<>();
        for (T elemento : lista) {
            resultado.add(funcion.apply(elemento));
        }
        return resultado;
    }

    public static void main(String[] args) {
        List<String> palabras = List.of("sol", "estrella", "luna", "asteroide", "cometa", "astro");

        // ------------------------------------------------------------
        // 1. Predicate<T>: una condición (T → boolean)
        // ------------------------------------------------------------
        Predicate<String> larga = s -> s.length() > 5;
        Predicate<String> empiezaPorA = s -> s.startsWith("a");
        System.out.println("1. Largas: " + filtrar(palabras, larga));
        System.out.println("   Empiezan por a: " + filtrar(palabras, empiezaPorA));
        System.out.println("   Largas Y por a: " + filtrar(palabras, larga.and(empiezaPorA)));
        System.out.println("   Largas O por a: " + filtrar(palabras, larga.or(empiezaPorA)));
        System.out.println("   Cortas (negate): " + filtrar(palabras, larga.negate()));
        System.out.println();

        // ------------------------------------------------------------
        // 2. Function<T, R>: transformar (T → R)
        // ------------------------------------------------------------
        Function<String, Integer> longitud = s -> s.length();
        Function<String, String> inicial = s -> s.substring(0, 1).toUpperCase();
        System.out.println("2. Longitudes: " + transformar(palabras, longitud));
        System.out.println("   Iniciales: " + transformar(palabras, inicial));

        Function<Integer, Integer> doble = x -> x * 2;
        Function<Integer, Integer> masUno = x -> x + 1;
        System.out.println("   doble.andThen(masUno).apply(5) = " + doble.andThen(masUno).apply(5));
        System.out.println("   doble.compose(masUno).apply(5) = " + doble.compose(masUno).apply(5));
        System.out.println();

        // ------------------------------------------------------------
        // 3. Consumer<T>: hacer algo con un dato (T → nada)
        // ------------------------------------------------------------
        Consumer<String> enMayusculas = s -> System.out.print(s.toUpperCase() + " ");
        Consumer<String> conGuion = s -> System.out.print("- ");
        System.out.print("3. ");
        for (String p : palabras) {
            conGuion.andThen(enMayusculas).accept(p);
        }
        System.out.println();
        System.out.println();

        // ------------------------------------------------------------
        // 4. Supplier<T>: producir un dato (nada → T)
        // ------------------------------------------------------------
        Random random = new Random(7);
        Supplier<Integer> dado = () -> random.nextInt(1, 7);
        Supplier<List<String>> listaNueva = () -> new ArrayList<>();
        System.out.print("4. Cinco tiradas:");
        for (int i = 0; i < 5; i++) {
            System.out.print(" " + dado.get());
        }
        System.out.println();
        List<String> vacia = listaNueva.get();
        System.out.println("   Lista nueva: " + vacia + " (vacía: " + vacia.isEmpty() + ")");
        System.out.println();

        // ------------------------------------------------------------
        // 5. UnaryOperator, BinaryOperator y BiFunction
        // ------------------------------------------------------------
        UnaryOperator<String> alReves = s -> new StringBuilder(s).reverse().toString();
        BinaryOperator<Integer> mayor = (a, b) -> a >= b ? a : b;
        BiFunction<String, Integer, String> repetir = (s, n) -> s.repeat(n);
        System.out.println("5. alReves(\"lambda\") = " + alReves.apply("lambda"));
        System.out.println("   mayor(17, 42) = " + mayor.apply(17, 42));
        System.out.println("   repetir(\"ja\", 3) = " + repetir.apply("ja", 3));
    }
}
