/*
 * TEMA 17 · Genéricos
 * Ejemplo 06: comodines ?, ? extends y ? super
 *
 * Cómo ejecutarlo:  java T17_06_Comodines.java
 */
import java.util.ArrayList;
import java.util.List;

public class T17_06_Comodines {

    // List<?>: una lista de "algo". Solo se puede leer como Object
    static void mostrar(List<?> lista) {
        System.out.print("   " + lista.size() + " elementos:");
        for (Object elemento : lista) {
            System.out.print(" " + elemento);
        }
        System.out.println();
    }

    // ? extends Number: acepta List<Integer>, List<Double>... Se LEE como Number
    static double total(List<? extends Number> numeros) {
        double suma = 0;
        for (Number n : numeros) {
            suma += n.doubleValue();
        }
        return suma;
    }

    // ? super Integer: acepta List<Integer>, List<Number>, List<Object>. Se puede AÑADIR un Integer
    static void rellenar(List<? super Integer> destino, int cuantos) {
        for (int i = 1; i <= cuantos; i++) {
            destino.add(i * 10);
        }
    }

    // Combinando los dos: copia de una lista "productora" a una "consumidora"
    static <T> void copiar(List<? extends T> origen, List<? super T> destino) {
        for (T elemento : origen) {
            destino.add(elemento);
        }
    }

    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(List.of(1, 2, 3));
        List<Double> decimales = List.of(0.5, 1.25);

        // ------------------------------------------------------------
        // 1. List<Integer> NO es una List<Number>
        // ------------------------------------------------------------
        // List<Number> numeros = enteros;   // ❌ No compila
        // Si compilara, se podría hacer numeros.add(2.5) y meter un Double entre los enteros
        System.out.println("1. List<Integer> no se puede asignar a List<Number> (ver el comentario del código)");
        System.out.println();

        // ------------------------------------------------------------
        // 2. List<?>: cualquier lista
        // ------------------------------------------------------------
        System.out.println("2. mostrar acepta cualquier lista:");
        mostrar(enteros);
        mostrar(List.of("a", "b"));
        mostrar(decimales);
        System.out.println();

        // ------------------------------------------------------------
        // 3. ? extends: leer
        // ------------------------------------------------------------
        System.out.println("3. total(enteros) = " + total(enteros));
        System.out.println("   total(decimales) = " + total(decimales));
        System.out.println();

        // ------------------------------------------------------------
        // 4. ? super: añadir
        // ------------------------------------------------------------
        List<Number> numeros = new ArrayList<>();
        List<Object> cosas = new ArrayList<>(List.of("inicio"));
        rellenar(numeros, 3);
        rellenar(cosas, 2);
        rellenar(enteros, 1);
        System.out.println("4. List<Number>: " + numeros);
        System.out.println("   List<Object>: " + cosas);
        System.out.println("   List<Integer>: " + enteros);
        System.out.println();

        // ------------------------------------------------------------
        // 5. Copiar de una lista de Integer a una de Number
        // ------------------------------------------------------------
        List<Number> todos = new ArrayList<>(decimales);
        copiar(enteros, todos);
        System.out.println("5. Decimales + enteros en una List<Number>: " + todos);
        System.out.println("   Regla: si el método SACA datos → extends; si los METE → super");
    }
}
