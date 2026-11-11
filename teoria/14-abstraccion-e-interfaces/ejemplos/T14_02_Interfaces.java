/*
 * TEMA 14 · Abstracción e interfaces
 * Ejemplo 02: INTERFACES (contratos de "lo que se puede hacer")
 *
 * Cómo ejecutarlo:  java T14_02_Interfaces.java
 */
public class T14_02_Interfaces {

    // ------------------------------------------------------------
    // Interfaces: solo dicen QUÉ se puede hacer
    // ------------------------------------------------------------
    interface Volador {
        int ALTURA_MAXIMA = 12_000;       // Constante: public static final automáticamente

        String volar();                    // public abstract automáticamente
    }

    interface Nadador {
        String nadar();
    }

    // ------------------------------------------------------------
    // Clases que las implementan
    // ------------------------------------------------------------
    static class Animal {
        protected final String nombre;

        Animal(String nombre) {
            this.nombre = nombre;
        }
    }

    // Hereda de UNA clase e implementa DOS interfaces
    static class Pato extends Animal implements Volador, Nadador {
        Pato(String nombre) {
            super(nombre);
        }

        @Override
        public String volar() {            // Tiene que ser public
            return nombre + " vuela batiendo las alas";
        }

        @Override
        public String nadar() {
            return nombre + " nada en el estanque";
        }
    }

    static class Pez extends Animal implements Nadador {
        Pez(String nombre) {
            super(nombre);
        }

        @Override
        public String nadar() {
            return nombre + " nada moviendo la cola";
        }
    }

    // No es un animal, pero TAMBIÉN puede volar
    static class Avion implements Volador {
        private final String matricula;

        Avion(String matricula) {
            this.matricula = matricula;
        }

        @Override
        public String volar() {
            return "El avión " + matricula + " vuela a " + ALTURA_MAXIMA + " m";
        }
    }

    // ------------------------------------------------------------
    // Métodos que reciben la INTERFAZ: valen para cualquier clase que la cumpla
    // ------------------------------------------------------------
    static void exhibicionAerea(Volador[] participantes) {
        for (Volador v : participantes) {
            System.out.println("  ✈ " + v.volar());
        }
    }

    static void carreraDeNatacion(Nadador[] participantes) {
        for (Nadador n : participantes) {
            System.out.println("  🏊 " + n.nadar());
        }
    }

    public static void main(String[] args) {

        Pato donald = new Pato("Donald");
        Pez nemo = new Pez("Nemo");
        Avion avion = new Avion("EC-JFK");

        // Un pato se puede guardar como Animal, como Volador o como Nadador
        Volador comoVolador = donald;
        Nadador comoNadador = donald;
        System.out.println(comoVolador.volar());
        System.out.println(comoNadador.nadar());
        // comoVolador.nadar();   // ❌ Error: con una variable Volador solo se ve volar()
        System.out.println();

        System.out.println("Exhibición aérea:");
        exhibicionAerea(new Volador[]{donald, avion});       // Un pato y un avión: nada en común... salvo volar

        System.out.println("Carrera de natación:");
        carreraDeNatacion(new Nadador[]{donald, nemo});
        System.out.println();

        // instanceof también funciona con interfaces
        Object[] cosas = {donald, nemo, avion};
        for (Object o : cosas) {
            String capacidades = "";
            if (o instanceof Volador) {
                capacidades += " vuela";
            }
            if (o instanceof Nadador) {
                capacidades += " nada";
            }
            System.out.println(o.getClass().getSimpleName() + ":" + capacidades);
        }

        // Volador v = new Volador();   // ❌ Error: una interfaz no se puede instanciar

        // PRUEBA: crea la interfaz "Corredor" con "String correr()" y haz que el Pato la implemente.
    }
}
