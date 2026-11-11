/*
 * TEMA 17 · Ejercicio 01 · Caja genérica  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol17_01_CajaGenerica.java
 */
public class Sol17_01_CajaGenerica {

    static class Caja<T> {                      // T: el tipo que se decidirá al crear cada caja
        private T contenido;                    // null = vacía

        void guardar(T objeto) {
            contenido = objeto;
        }

        T mirar() {
            return contenido;
        }

        // Devuelve el contenido y deja la caja vacía
        T sacar() {
            T objeto = contenido;
            contenido = null;
            return objeto;
        }

        boolean estaVacia() {
            return contenido == null;
        }

        @Override
        public String toString() {
            return estaVacia() ? "[vacía]" : "[" + contenido + "]";
        }
    }

    public static void main(String[] args) {
        Caja<String> cajaTexto = new Caja<>();
        System.out.println("Caja de texto: " + cajaTexto);
        cajaTexto.guardar("carta");
        System.out.println("Guardo \"carta\" → " + cajaTexto);
        System.out.println("Miro: " + cajaTexto.mirar() + " · ¿Vacía? " + cajaTexto.estaVacia());
        System.out.println("Saco: " + cajaTexto.sacar() + " · ¿Vacía? " + cajaTexto.estaVacia());

        Caja<Integer> cajaNumero = new Caja<>();
        cajaNumero.guardar(7);
        System.out.println("Caja de números: " + cajaNumero);
        int numero = cajaNumero.sacar();                    // Sin casting: el compilador sabe que es Integer
        System.out.println(numero + " al cuadrado: " + numero * numero);
        System.out.println("Saco de una caja vacía: " + cajaNumero.sacar());

        Caja<String> pequenia = new Caja<>();
        pequenia.guardar("sorpresa");
        Caja<Caja<String>> grande = new Caja<>();           // Una caja que guarda cajas
        grande.guardar(pequenia);
        System.out.println("Caja de cajas: " + grande);
    }
}
