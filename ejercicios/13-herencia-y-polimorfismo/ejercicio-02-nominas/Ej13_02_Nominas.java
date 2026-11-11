/*
 * TEMA 13 · Ejercicio 02 · Nóminas  (dificultad: 2/5)
 *
 * Objetivo: sobrescribir métodos reutilizando la versión de la superclase.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej13_02_Nominas.java
 */
public class Ej13_02_Nominas {

    // NO TOCAR: la superclase
    static class Empleado {
        protected final String nombre;
        protected final double sueldoBase;

        public Empleado(String nombre, double sueldoBase) {
            this.nombre = nombre;
            this.sueldoBase = sueldoBase;
        }

        public double calcularSueldo() {
            return sueldoBase;
        }

        @Override
        public String toString() {
            return String.format("%s · %,.2f €", nombre, calcularSueldo());
        }
    }

    static class Comercial extends Empleado {
        private final double ventas;
        private final double porcentajeComision;

        public Comercial(String nombre, double sueldoBase, double ventas, double porcentajeComision) {
            super(nombre, sueldoBase);
            this.ventas = ventas;
            this.porcentajeComision = porcentajeComision;
        }

        // TODO 1: sobrescribe calcularSueldo() usando super.calcularSueldo()

        // TODO 2: sobrescribe toString() usando super.toString()
    }

    static class Gerente extends Empleado {
        private final double bonus;
        private final int personasACargo;

        public Gerente(String nombre, double sueldoBase, double bonus, int personasACargo) {
            super(nombre, sueldoBase);
            this.bonus = bonus;
            this.personasACargo = personasACargo;
        }

        // TODO 3: sobrescribe calcularSueldo() (base + bonus + 50 € por persona)

        // TODO 4: sobrescribe toString()
    }

    // NO TOCAR
    public static void main(String[] args) {
        Empleado ana = new Empleado("Ana", 1500);
        Comercial jorge = new Comercial("Jorge", 1300, 40000, 4);
        Gerente marta = new Gerente("Marta", 2800, 500, 6);

        System.out.println(ana);
        System.out.println(jorge);
        System.out.println(marta);

        double total = ana.calcularSueldo() + jorge.calcularSueldo() + marta.calcularSueldo();
        System.out.printf("Total de nóminas: %,.2f €%n", total);
    }
}
