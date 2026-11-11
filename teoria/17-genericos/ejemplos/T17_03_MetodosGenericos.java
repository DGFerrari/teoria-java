/*
 * TEMA 17 · Genéricos
 * Ejemplo 03: métodos genéricos e inferencia de tipos
 *
 * Cómo ejecutarlo:  java T17_03_MetodosGenericos.java
 */
import java.util.ArrayList;
import java.util.List;

public class T17_03_MetodosGenericos {

    // <T> va ANTES del tipo de retorno: declara el parámetro de tipo del método
    static <T> void mostrarTodos(T[] elementos) {
        System.out.print("   [");
        for (int i = 0; i < elementos.length; i++) {
            System.out.print(elementos[i]);
            if (i < elementos.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println("]");
    }

    static <T> T ultimo(List<T> lista) {
        return lista.get(lista.size() - 1);
    }

    static <T> void intercambiar(T[] array, int i, int j) {
        T auxiliar = array[i];
        array[i] = array[j];
        array[j] = auxiliar;
    }

    static <T> int contar(List<T> lista, T buscado) {
        int veces = 0;
        for (T elemento : lista) {
            if (elemento.equals(buscado)) {
                veces++;
            }
        }
        return veces;
    }

    // Devuelve una lista NUEVA con el elemento repetido n veces
    static <T> List<T> repetir(T elemento, int n) {
        List<T> resultado = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resultado.add(elemento);
        }
        return resultado;
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. El mismo método con arrays de distintos tipos (inferencia)
        // ------------------------------------------------------------
        String[] colores = {"rojo", "verde", "azul"};
        Integer[] primos = {2, 3, 5, 7};               // Integer[], no int[]: T tiene que ser una clase
        Character[] letras = {'J', 'a', 'v', 'a'};
        System.out.println("1. mostrarTodos con tres tipos:");
        mostrarTodos(colores);                          // T = String
        mostrarTodos(primos);                           // T = Integer
        mostrarTodos(letras);                           // T = Character
        System.out.println();

        // ------------------------------------------------------------
        // 2. El tipo de retorno depende del argumento
        // ------------------------------------------------------------
        String ultimoColor = ultimo(List.of("rojo", "verde", "azul"));
        double ultimaNota = ultimo(List.of(6.5, 8.0, 9.25));
        System.out.println("2. Último color: " + ultimoColor.toUpperCase() + " · última nota: " + ultimaNota);
        System.out.println();

        // ------------------------------------------------------------
        // 3. Un algoritmo genérico: intercambiar posiciones
        // ------------------------------------------------------------
        intercambiar(colores, 0, 2);
        intercambiar(primos, 1, 3);
        System.out.println("3. Tras intercambiar:");
        mostrarTodos(colores);
        mostrarTodos(primos);
        System.out.println();

        // ------------------------------------------------------------
        // 4. Contar y crear listas de cualquier tipo
        // ------------------------------------------------------------
        List<String> votos = List.of("sí", "no", "sí", "sí", "abstención");
        System.out.println("4. Votos a favor: " + contar(votos, "sí"));
        System.out.println("   Dados con un 6: " + contar(List.of(6, 2, 6, 1, 6), 6));
        List<String> eco = repetir("hola", 3);
        List<Boolean> interruptores = repetir(false, 4);
        System.out.println("   " + eco + " · " + interruptores);
        System.out.println();

        // ------------------------------------------------------------
        // 5. Indicar el tipo explícitamente (casi nunca hace falta)
        // ------------------------------------------------------------
        List<Double> ceros = T17_03_MetodosGenericos.<Double>repetir(0.0, 3);
        System.out.println("5. Con tipo explícito: " + ceros);
    }
}
