/*
 * TEMA 17 · Ejercicio 05 · Repositorio genérico  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol17_05_RepositorioGenerico.java
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Sol17_05_RepositorioGenerico {

    // Interfaz genérica: cualquier cosa que tenga un identificador de tipo K
    interface Identificable<K> {
        K getId();
    }

    // Interfaz genérica: una condición sobre un T
    interface Filtro<T> {
        boolean cumple(T elemento);
    }

    // Dos parámetros de tipo, uno de ellos acotado: T tiene que ser Identificable con clave K
    static class Repositorio<K, T extends Identificable<K>> {
        private final Map<K, T> datos = new LinkedHashMap<>();

        boolean guardar(T elemento) {
            boolean guardado = false;
            if (!datos.containsKey(elemento.getId())) {      // getId() existe gracias al límite
                datos.put(elemento.getId(), elemento);
                guardado = true;
            }
            return guardado;
        }

        T buscar(K id) {
            return datos.get(id);
        }

        boolean eliminar(K id) {
            return datos.remove(id) != null;
        }

        int cantidad() {
            return datos.size();
        }

        List<T> todos() {
            return new ArrayList<>(datos.values());           // Copia: el mapa interno queda protegido
        }

        List<T> filtrar(Filtro<T> filtro) {
            List<T> resultado = new ArrayList<>();
            for (T elemento : datos.values()) {
                if (filtro.cumple(elemento)) {
                    resultado.add(elemento);
                }
            }
            return resultado;
        }
    }

    static class Producto implements Identificable<String>, Comparable<Producto> {
        private final String codigo;
        private final String nombre;
        private final double precio;
        private final int stock;

        Producto(String codigo, String nombre, double precio, int stock) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        @Override
        public String getId() {
            return codigo;
        }

        int getStock() {
            return stock;
        }

        @Override
        public int compareTo(Producto otro) {
            return Double.compare(precio, otro.precio);
        }

        @Override
        public String toString() {
            return String.format("%s · %s · %.2f € · stock %d", codigo, nombre, precio, stock);
        }
    }

    static class Socio implements Identificable<Integer>, Comparable<Socio> {
        private final int numero;
        private final String nombre;
        private final int edad;

        Socio(int numero, String nombre, int edad) {
            this.numero = numero;
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public Integer getId() {
            return numero;                                    // autoboxing: int → Integer
        }

        String getNombre() {
            return nombre;
        }

        int getEdad() {
            return edad;
        }

        @Override
        public int compareTo(Socio otro) {
            return nombre.compareTo(otro.nombre);
        }

        @Override
        public String toString() {
            return numero + " · " + nombre + " (" + edad + " años)";
        }
    }

    // Filtros concretos: cada uno fija el tipo de Filtro<T>
    static class SinStock implements Filtro<Producto> {
        @Override
        public boolean cumple(Producto p) {
            return p.getStock() == 0;
        }
    }

    static class MenorDeEdad implements Filtro<Socio> {
        @Override
        public boolean cumple(Socio s) {
            return s.getEdad() < 18;
        }
    }

    // Método genérico acotado: ordena una copia de cualquier colección de elementos comparables
    static <T extends Comparable<T>> List<T> ordenados(Collection<T> elementos) {
        List<T> copia = new ArrayList<>(elementos);
        Collections.sort(copia);
        return copia;
    }

    // Comodín: sirve para mostrar una lista de cualquier tipo
    static void mostrar(String titulo, List<?> elementos) {
        System.out.println("=== " + titulo + " ===");
        for (Object elemento : elementos) {
            System.out.println("  " + elemento);
        }
    }

    public static void main(String[] args) {
        Repositorio<String, Producto> productos = new Repositorio<>();
        productos.guardar(new Producto("P1", "Teclado", 59.90, 12));
        productos.guardar(new Producto("P2", "Ratón", 19.50, 30));
        productos.guardar(new Producto("P3", "Monitor", 189.00, 4));
        productos.guardar(new Producto("P4", "Alfombrilla", 8.75, 0));
        boolean repetido = productos.guardar(new Producto("P2", "Ratón inalámbrico", 24.99, 5));

        System.out.println("Productos guardados: " + productos.cantidad() + " (¿Ratón repetido? " + repetido + ")");
        System.out.println("Buscar P3: " + productos.buscar("P3"));
        System.out.println("Buscar P9: " + productos.buscar("P9"));
        mostrar("Productos por precio", ordenados(productos.todos()));
        mostrar("Productos sin stock", productos.filtrar(new SinStock()));
        System.out.println("¿Eliminado P4? " + productos.eliminar("P4") + " · quedan " + productos.cantidad());

        Repositorio<Integer, Socio> socios = new Repositorio<>();
        socios.guardar(new Socio(1001, "Lucía", 34));
        socios.guardar(new Socio(1002, "Andrés", 17));
        socios.guardar(new Socio(1003, "Carmen", 15));

        mostrar("Socios por nombre", ordenados(socios.todos()));
        mostrar("Socios menores de edad", socios.filtrar(new MenorDeEdad()));
        System.out.println("Socio 1001: " + socios.buscar(1001).getNombre());
        // socios.buscar("1001");   // ❌ No compila: la clave de este repositorio es Integer
    }
}
