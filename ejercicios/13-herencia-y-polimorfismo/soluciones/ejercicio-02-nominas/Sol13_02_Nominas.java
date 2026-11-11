/*
 * TEMA 13 · Ejercicio 02 · Nóminas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol13_02_Nominas.java
 */
public class Sol13_02_Nominas {

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
            // calcularSueldo() se resuelve con el objeto REAL (polimorfismo)
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

        @Override
        public double calcularSueldo() {
            return super.calcularSueldo() + ventas * porcentajeComision / 100;
        }

        @Override
        public String toString() {
            return super.toString() + String.format(" (comercial, ventas: %,.2f €)", ventas);
        }
    }

    static class Gerente extends Empleado {
        private final double bonus;
        private final int personasACargo;

        public Gerente(String nombre, double sueldoBase, double bonus, int personasACargo) {
            super(nombre, sueldoBase);
            this.bonus = bonus;
            this.personasACargo = personasACargo;
        }

        @Override
        public double calcularSueldo() {
            return super.calcularSueldo() + bonus + 50 * personasACargo;
        }

        @Override
        public String toString() {
            return super.toString() + " (gerente de " + personasACargo + " personas)";
        }
    }

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
