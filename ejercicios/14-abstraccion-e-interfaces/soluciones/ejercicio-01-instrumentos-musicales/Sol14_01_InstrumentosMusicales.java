/*
 * TEMA 14 · Ejercicio 01 · Instrumentos musicales  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol14_01_InstrumentosMusicales.java
 */
public class Sol14_01_InstrumentosMusicales {

    abstract static class Instrumento {
        private final String nombre;

        protected Instrumento(String nombre) {
            this.nombre = nombre;
        }

        // Cada instrumento DEBE decir cómo suena y a qué familia pertenece
        public abstract String tocar();

        public abstract String getFamilia();

        public String presentar() {
            return nombre + " (" + getFamilia() + ") suena: ♪ " + tocar();
        }
    }

    static class Guitarra extends Instrumento {
        public Guitarra() {
            super("Guitarra");
        }

        @Override
        public String tocar() {
            return "Tlan, tlan, tlaaan";
        }

        @Override
        public String getFamilia() {
            return "cuerda";
        }
    }

    static class Piano extends Instrumento {
        public Piano() {
            super("Piano");
        }

        @Override
        public String tocar() {
            return "Plin, plon, plin";
        }

        @Override
        public String getFamilia() {
            return "tecla";
        }
    }

    static class Bateria extends Instrumento {
        public Bateria() {
            super("Batería");
        }

        @Override
        public String tocar() {
            return "Pum, tchs, pum-pum, tchs";
        }

        @Override
        public String getFamilia() {
            return "percusión";
        }
    }

    public static void main(String[] args) {
        Instrumento[] orquesta = {new Guitarra(), new Piano(), new Bateria()};
        for (Instrumento i : orquesta) {
            System.out.println(i.presentar());
        }
    }
}
