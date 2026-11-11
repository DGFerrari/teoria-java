/*
 * TEMA 13 · Ejercicio 01 · Animales  (dificultad: 1/5)
 *
 * Objetivo: crear dos subclases de Animal.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej13_01_Animales.java
 *
 * Mientras no crees las clases Perro y Gato, el main no compila: es normal.
 * Si quieres probar poco a poco, comenta las líneas del main que aún no funcionen.
 */
public class Ej13_01_Animales {

    // NO TOCAR: la superclase
    static class Animal {
        protected final String nombre;
        protected int edad;

        public Animal(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String describir() {
            return nombre + " (" + edad + " años)";
        }

        public void cumplirAnios() {
            edad++;
        }
    }

    // TODO 1: crea la clase Perro (extends Animal) con raza, ladrar() y getRaza()

    // TODO 2: crea la clase Gato (extends Animal) con casero, maullar() e isCasero()

    // NO TOCAR
    public static void main(String[] args) {
        Perro toby = new Perro("Toby", 3, "Beagle");
        Gato misi = new Gato("Misi", 5, true);
        Gato tigre = new Gato("Tigre", 2, false);

        System.out.println(toby.describir());       // Heredado de Animal
        System.out.println("Raza: " + toby.getRaza());
        System.out.println(toby.ladrar());
        System.out.println(misi.describir());
        System.out.println(misi.maullar());
        System.out.println(tigre.maullar());

        toby.cumplirAnios();                         // Heredado de Animal
        System.out.println("Tras su cumpleaños: " + toby.describir());
    }
}
