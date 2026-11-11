/*
 * TEMA 18 · Ejercicio 02 · Tienda de camisetas  (dificultad: 2/5)
 *
 * Objetivo: un enum con atributos, constructor, métodos y un método static de búsqueda.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej18_02_TiendaDeCamisetas.java
 */
public class Ej18_02_TiendaDeCamisetas {

    static final double PRECIO_BASE = 12.0;

    // TODO 1: añade a cada constante su pecho máximo (cm) y su recargo (€):
    //         S(92, 0.0), M(100, 0.0), L(108, 1.5), XL(116, 3.0)
    //         con atributos final, constructor, getPechoMaximo(), precio() y
    //         static Talla recomendada(int contornoPecho)
    enum Talla {
        S, M, L, XL
    }

    public static void main(String[] args) {
        // TODO 2: muestra la tabla de tallas y las tallas recomendadas para 97 y 120 cm

        // NO TOCAR: el pedido ("talla;cantidad")
        String[] pedido = {"M;2", "xl;1", "XXL;1", "L;tres", "l;3"};

        // TODO 3: procesa cada línea: talla con valueOf, cantidad con parseInt.
        //         Captura los dos errores posibles (¡cuidado con el orden de los catch!)
        //         y muestra el total y el número de camisetas
    }
}
