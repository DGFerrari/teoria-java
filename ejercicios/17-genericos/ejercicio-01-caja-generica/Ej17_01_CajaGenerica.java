/*
 * TEMA 17 · Ejercicio 01 · Caja genérica  (dificultad: 1/5)
 *
 * Objetivo: escribir tu primera clase genérica y usarla con varios tipos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej17_01_CajaGenerica.java
 */
public class Ej17_01_CajaGenerica {

    // TODO 1: convierte esta clase en genérica (Caja<T>) y cambia Object por T donde corresponda.
    //         Añade mirar(), sacar() (devuelve y vacía), estaVacia() y toString() ("[vacía]" o "[contenido]")
    static class Caja {
        private Object contenido;

        void guardar(Object objeto) {
            contenido = objeto;
        }
    }

    public static void main(String[] args) {
        // TODO 2: crea una Caja<String>, muéstrala, guarda "carta", mírala y sácala (mira la salida esperada)

        // TODO 3: crea una Caja<Integer> con un 7, sácalo en un int (sin casting) y muestra su cuadrado.
        //         Después intenta sacar otra vez de la caja ya vacía

        // TODO 4: crea una Caja<Caja<String>> que contenga una caja con "sorpresa"
    }
}
