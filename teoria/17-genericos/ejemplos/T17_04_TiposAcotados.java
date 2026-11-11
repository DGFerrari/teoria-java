/*
 * TEMA 17 · Genéricos
 * Ejemplo 04: tipos acotados (extends) - exigir algo al tipo
 *
 * Cómo ejecutarlo:  java T17_04_TiposAcotados.java
 */
import java.util.ArrayList;
import java.util.List;

public class T17_04_TiposAcotados {

    // T tiene que ser Number (o una subclase): así se puede llamar a doubleValue()
    static <T extends Number> double sumar(List<T> numeros) {
        double total = 0;
        for (T n : numeros) {
            total += n.doubleValue();
        }
        return total;
    }

    static <T extends Number> double media(List<T> numeros) {
        double resultado = 0;
        if (!numeros.isEmpty()) {
            resultado = sumar(numeros) / numeros.size();
        }
        return resultado;
    }

    // T tiene que poder compararse consigo mismo: así se puede llamar a compareTo()
    static <T extends Comparable<T>> T mayor(List<T> lista) {
        T resultado = lista.get(0);
        for (T elemento : lista) {
            if (elemento.compareTo(resultado) > 0) {
                resultado = elemento;
            }
        }
        return resultado;
    }

    // Burbuja genérica: ordena cualquier lista de elementos comparables
    static <T extends Comparable<T>> void ordenar(List<T> lista) {
        boolean hayCambios = true;
        for (int pasada = 0; pasada < lista.size() - 1 && hayCambios; pasada++) {
            hayCambios = false;
            for (int i = 0; i < lista.size() - 1 - pasada; i++) {
                if (lista.get(i).compareTo(lista.get(i + 1)) > 0) {
                    T auxiliar = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, auxiliar);
                    hayCambios = true;
                }
            }
        }
    }

    // Una clase genérica acotada: solo admite números
    static class Estadistica<T extends Number> {
        private final List<T> datos = new ArrayList<>();

        void agregar(T dato) {
            datos.add(dato);
        }

        double rango() {
            double minimo = datos.get(0).doubleValue();
            double maximo = minimo;
            for (T dato : datos) {
                minimo = Math.min(minimo, dato.doubleValue());
                maximo = Math.max(maximo, dato.doubleValue());
            }
            return maximo - minimo;
        }
    }

    // Una clase propia Comparable funciona con los métodos acotados
    static class Planeta implements Comparable<Planeta> {
        private final String nombre;
        private final double radioKm;

        Planeta(String nombre, double radioKm) {
            this.nombre = nombre;
            this.radioKm = radioKm;
        }

        @Override
        public int compareTo(Planeta otro) {
            return Double.compare(radioKm, otro.radioKm);
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. <T extends Number>: cualquier tipo numérico
        // ------------------------------------------------------------
        List<Integer> goles = List.of(2, 0, 3, 1);
        List<Double> alturas = List.of(1.62, 1.75, 1.80);
        System.out.println("1. Goles totales: " + sumar(goles));
        System.out.printf("   Altura media: %.2f m%n", media(alturas));
        // sumar(List.of("a", "b"));   // ❌ No compila: String no es un Number
        System.out.println();

        // ------------------------------------------------------------
        // 2. <T extends Comparable<T>>: cualquier tipo comparable
        // ------------------------------------------------------------
        System.out.println("2. Mayor texto: " + mayor(List.of("pera", "uva", "manzana")));
        System.out.println("   Mayor número: " + mayor(List.of(17, 42, 8)));
        System.out.println("   Mayor letra: " + mayor(List.of('q', 'z', 'a')));
        System.out.println();

        // ------------------------------------------------------------
        // 3. Funciona también con clases propias que sean Comparable
        // ------------------------------------------------------------
        List<Planeta> planetas = new ArrayList<>(List.of(
                new Planeta("Tierra", 6371), new Planeta("Júpiter", 69911),
                new Planeta("Marte", 3390), new Planeta("Neptuno", 24622)));
        System.out.println("3. El más grande: " + mayor(planetas));
        ordenar(planetas);
        System.out.println("   Ordenados por tamaño: " + planetas);
        List<String> ciudades = new ArrayList<>(List.of("Toledo", "Ávila", "Cádiz", "Burgos"));
        ordenar(ciudades);
        System.out.println("   Ciudades ordenadas: " + ciudades + " (Á va después de Z en compareTo)");
        System.out.println();

        // ------------------------------------------------------------
        // 4. Una clase acotada
        // ------------------------------------------------------------
        Estadistica<Integer> edades = new Estadistica<>();
        edades.agregar(15);
        edades.agregar(12);
        edades.agregar(17);
        System.out.println("4. Rango de edades: " + edades.rango());
        // Estadistica<String> e;     // ❌ No compila: String no está dentro del límite
    }
}
