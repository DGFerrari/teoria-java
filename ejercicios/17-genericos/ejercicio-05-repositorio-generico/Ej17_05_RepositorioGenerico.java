/*
 * TEMA 17 · Ejercicio 05 · Repositorio genérico  (dificultad: 5/5)
 *
 * Objetivo: combinar interfaces genéricas, una clase con dos parámetros de tipo (uno acotado),
 *           métodos genéricos acotados y comodines.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej17_05_RepositorioGenerico.java
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ej17_05_RepositorioGenerico {

    // NO TOCAR: las dos interfaces genéricas
    interface Identificable<K> {
        K getId();
    }

    interface Filtro<T> {
        boolean cumple(T elemento);
    }

    // TODO 1: completa el repositorio. Cambia la cabecera a  Repositorio<K, T extends Identificable<K>>
    //         y usa un Map<K, T> (LinkedHashMap) con los métodos:
    //         guardar(T) → boolean (false si el id ya existe), buscar(K) → T o null,
    //         eliminar(K) → boolean, cantidad(), todos() → copia en una List<T>,
    //         filtrar(Filtro<T>) → List<T> con los que cumplen el filtro
    static class Repositorio {
    }

    // TODO 2: Producto implementa Identificable<String> (el id es el código) y Comparable<Producto> (por precio).
    //         toString con String.format: "P1 · Teclado · 59,90 € · stock 12"
    static class Producto {
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
    }

    // TODO 3: Socio implementa Identificable<Integer> (el id es el número) y Comparable<Socio> (por nombre).
    //         toString: "1002 · Andrés (17 años)"
    static class Socio {
        private final int numero;
        private final String nombre;
        private final int edad;

        Socio(int numero, String nombre, int edad) {
            this.numero = numero;
            this.nombre = nombre;
            this.edad = edad;
        }
    }

    // TODO 4: dos filtros: SinStock (Filtro<Producto>) y MenorDeEdad (Filtro<Socio>)

    // TODO 5: static <T extends Comparable<T>> List<T> ordenados(Collection<T> elementos)
    //         Devuelve una copia ordenada (Collections.sort)

    // TODO 6: static void mostrar(String titulo, List<?> elementos): "=== titulo ===" y cada elemento con 2 espacios

    public static void main(String[] args) {
        // TODO 7: crea un Repositorio<String, Producto> con:
        //         P1 Teclado 59.90 (12) · P2 Ratón 19.50 (30) · P3 Monitor 189.00 (4) · P4 Alfombrilla 8.75 (0)
        //         e intenta guardar otro P2 ("Ratón inalámbrico", 24.99, 5). Sigue la salida esperada

        // TODO 8: crea un Repositorio<Integer, Socio> con 1001 Lucía 34 · 1002 Andrés 17 · 1003 Carmen 15
    }
}
