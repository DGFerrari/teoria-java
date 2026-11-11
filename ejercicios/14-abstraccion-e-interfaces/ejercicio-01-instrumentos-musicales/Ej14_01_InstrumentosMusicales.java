/*
 * TEMA 14 · Ejercicio 01 · Instrumentos musicales  (dificultad: 1/5)
 *
 * Objetivo: una clase abstracta y tres subclases concretas.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej14_01_InstrumentosMusicales.java
 *
 * La plantilla no compila hasta que crees Guitarra, Piano y Bateria: es normal.
 */
public class Ej14_01_InstrumentosMusicales {

    // TODO 1: haz la clase abstracta y añade los métodos abstractos tocar() y getFamilia()
    static class Instrumento {
        private final String nombre;

        protected Instrumento(String nombre) {
            this.nombre = nombre;
        }

        // NO TOCAR: usa los métodos abstractos
        public String presentar() {
            return nombre + " (" + getFamilia() + ") suena: ♪ " + tocar();
        }
    }

    // TODO 2: crea Guitarra, Piano y Bateria

    // NO TOCAR
    public static void main(String[] args) {
        Instrumento[] orquesta = {new Guitarra(), new Piano(), new Bateria()};
        for (Instrumento i : orquesta) {
            System.out.println(i.presentar());
        }
    }
}
