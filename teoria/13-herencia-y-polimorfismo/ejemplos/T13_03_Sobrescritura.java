/*
 * TEMA 13 · Herencia y polimorfismo
 * Ejemplo 03: SOBRESCRIBIR MÉTODOS (@Override y super.metodo())
 *
 * Cómo ejecutarlo:  java T13_03_Sobrescritura.java
 */
public class T13_03_Sobrescritura {

    static class Animal {
        protected final String nombre;

        public Animal(String nombre) {
            this.nombre = nombre;
        }

        public String hacerSonido() {
            return "...";
        }

        public String describir() {
            return nombre + " hace " + hacerSonido();
        }

        @Override                                   // Sobrescribe el toString de Object
        public String toString() {
            return "Animal llamado " + nombre;
        }
    }

    static class Perro extends Animal {
        public Perro(String nombre) {
            super(nombre);
        }

        // SUSTITUYE el comportamiento heredado
        @Override
        public String hacerSonido() {
            return "¡Guau!";
        }

        // AMPLÍA el comportamiento heredado con super.metodo()
        @Override
        public String describir() {
            return super.describir() + " y mueve la cola";
        }

        // Un método NUEVO (no es sobrescritura: no existe en Animal)
        public String traerPelota() {
            return nombre + " trae la pelota";
        }
    }

    static class Gato extends Animal {
        public Gato(String nombre) {
            super(nombre);
        }

        @Override
        public String hacerSonido() {
            return "¡Miau!";
        }

        @Override
        public String toString() {
            return "Gato llamado " + nombre;
        }

        // Si te equivocas en el nombre, @Override lo detecta:
        // @Override
        // public String hacersonido() { return "¡Miau!"; }
        // ❌ error: method does not override or implement a method from a supertype
    }

    // Sobrecarga (mismo nombre, distintos parámetros) frente a sobrescritura
    static class Loro extends Animal {
        public Loro(String nombre) {
            super(nombre);
        }

        @Override
        public String hacerSonido() {               // SOBRESCRITURA: mismos parámetros que en Animal
            return "¡Hola, guapo!";
        }

        public String hacerSonido(String palabra) { // SOBRECARGA: otro parámetro
            return "¡" + palabra + "! ¡" + palabra + "!";
        }
    }

    public static void main(String[] args) {

        Animal generico = new Animal("Bicho");
        Perro toby = new Perro("Toby");
        Gato misi = new Gato("Misi");
        Loro paco = new Loro("Paco");

        System.out.println(generico.describir());
        System.out.println(toby.describir());      // Usa SU hacerSonido y SU describir
        System.out.println(misi.describir());      // describir heredado, pero llama al hacerSonido de Gato
        System.out.println(paco.describir());
        System.out.println(paco.hacerSonido("Pipas"));
        System.out.println(toby.traerPelota());
        System.out.println();

        // toString sobrescrito (o heredado)
        System.out.println(generico);              // Animal llamado Bicho
        System.out.println(toby);                  // Animal llamado Toby  ← heredado de Animal
        System.out.println(misi);                  // Gato llamado Misi    ← sobrescrito en Gato

        // Fíjate en misi.describir(): el método está escrito en Animal, pero dentro llama a
        // hacerSonido(), y Java usa la versión del objeto REAL (Gato). Esto es polimorfismo.
    }
}
