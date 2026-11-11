/*
 * TEMA 17 · Genéricos
 * Ejemplo 05: interfaces genéricas
 *
 * Cómo ejecutarlo:  java T17_05_InterfacesGenericas.java
 */
import java.util.ArrayList;
import java.util.List;

public class T17_05_InterfacesGenericas {

    // Una interfaz genérica: transforma un T en un R
    interface Transformador<T, R> {
        R transformar(T entrada);
    }

    // Implementación que FIJA los tipos: String → Integer
    static class ContadorDeLetras implements Transformador<String, Integer> {
        @Override
        public Integer transformar(String entrada) {
            return entrada.length();
        }
    }

    // Implementación que FIJA los tipos: Double → String
    static class FormateadorDeEuros implements Transformador<Double, String> {
        @Override
        public String transformar(Double entrada) {
            return String.format("%.2f €", entrada);
        }
    }

    // Un método genérico que funciona con CUALQUIER transformador
    static <T, R> List<R> transformarTodos(List<T> entradas, Transformador<T, R> t) {
        List<R> salida = new ArrayList<>();
        for (T entrada : entradas) {
            salida.add(t.transformar(entrada));
        }
        return salida;
    }

    // Otra interfaz genérica: un almacén de elementos
    interface Repositorio<T> {
        void guardar(T elemento);

        T buscar(int posicion);

        int cantidad();
    }

    // Implementación que SIGUE SIENDO genérica
    static class RepositorioEnMemoria<T> implements Repositorio<T> {
        private final List<T> datos = new ArrayList<>();

        @Override
        public void guardar(T elemento) {
            datos.add(elemento);
        }

        @Override
        public T buscar(int posicion) {
            T resultado = null;
            if (posicion >= 0 && posicion < datos.size()) {
                resultado = datos.get(posicion);
            }
            return resultado;
        }

        @Override
        public int cantidad() {
            return datos.size();
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Interfaz genérica con los tipos fijados en cada clase
        // ------------------------------------------------------------
        List<String> palabras = List.of("sol", "estrella", "luna");
        List<Integer> longitudes = transformarTodos(palabras, new ContadorDeLetras());
        System.out.println("1. " + palabras + " → " + longitudes);

        List<String> precios = transformarTodos(List.of(3.5, 12.0, 0.99), new FormateadorDeEuros());
        System.out.println("   Precios: " + precios);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Una clase anónima (tema 14) que implementa la interfaz genérica
        // ------------------------------------------------------------
        Transformador<Integer, String> aEstrellas = new Transformador<>() {
            @Override
            public String transformar(Integer entrada) {
                return "★".repeat(entrada);
            }
        };
        System.out.println("2. Valoraciones: " + transformarTodos(List.of(3, 5, 1), aEstrellas));
        System.out.println("   (En el tema 19 esto se escribirá en una línea con una lambda)");
        System.out.println();

        // ------------------------------------------------------------
        // 3. Una implementación genérica sirve para cualquier tipo
        // ------------------------------------------------------------
        Repositorio<String> nombres = new RepositorioEnMemoria<>();
        nombres.guardar("Ana");
        nombres.guardar("Luis");
        Repositorio<Double> medidas = new RepositorioEnMemoria<>();
        medidas.guardar(1.5);
        System.out.println("3. Nombres: " + nombres.cantidad() + " · el segundo es " + nombres.buscar(1));
        System.out.println("   Medidas: " + medidas.cantidad() + " · la primera es " + medidas.buscar(0));
        System.out.println("   Posición inexistente: " + nombres.buscar(7));
    }
}
