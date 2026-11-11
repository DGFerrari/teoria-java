/*
 * TEMA 13 · Ejercicio 01 · Animales  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol13_01_Animales.java
 */
public class Sol13_01_Animales {

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

    static class Perro extends Animal {
        private final String raza;

        public Perro(String nombre, int edad, String raza) {
            super(nombre, edad);              // Primero, la parte de Animal
            this.raza = raza;
        }

        public String ladrar() {
            return nombre + " dice ¡Guau!";   // nombre es protected en Animal
        }

        public String getRaza() {
            return raza;
        }
    }

    static class Gato extends Animal {
        private final boolean casero;

        public Gato(String nombre, int edad, boolean casero) {
            super(nombre, edad);
            this.casero = casero;
        }

        public String maullar() {
            return casero ? nombre + " dice ¡Miau!" : nombre + " dice ¡MIAU! (y se escapa por la ventana)";
        }

        public boolean isCasero() {
            return casero;
        }
    }

    public static void main(String[] args) {
        Perro toby = new Perro("Toby", 3, "Beagle");
        Gato misi = new Gato("Misi", 5, true);
        Gato tigre = new Gato("Tigre", 2, false);

        System.out.println(toby.describir());
        System.out.println("Raza: " + toby.getRaza());
        System.out.println(toby.ladrar());
        System.out.println(misi.describir());
        System.out.println(misi.maullar());
        System.out.println(tigre.maullar());

        toby.cumplirAnios();
        System.out.println("Tras su cumpleaños: " + toby.describir());
    }
}
