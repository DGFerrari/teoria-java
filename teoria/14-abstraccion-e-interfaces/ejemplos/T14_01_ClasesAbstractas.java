/*
 * TEMA 14 · Abstracción e interfaces
 * Ejemplo 01: CLASES Y MÉTODOS ABSTRACTOS
 *
 * Cómo ejecutarlo:  java T14_01_ClasesAbstractas.java
 */
public class T14_01_ClasesAbstractas {

    // ------------------------------------------------------------
    // Clase abstracta: una base común INCOMPLETA
    // ------------------------------------------------------------
    abstract static class Empleado {
        private final String nombre;
        protected final double sueldoBase;

        protected Empleado(String nombre, double sueldoBase) {   // Constructor para las subclases
            this.nombre = nombre;
            this.sueldoBase = sueldoBase;
        }

        // Métodos abstractos: SIN cuerpo. Cada subclase está OBLIGADA a implementarlos
        public abstract double calcularSueldo();

        public abstract String getPuesto();

        // Métodos normales: se heredan tal cual (y usan los abstractos)
        public String getNombre() {
            return nombre;
        }

        public String generarNomina() {
            return String.format("%-8s %-12s %,10.2f €", nombre, getPuesto(), calcularSueldo());
        }
    }

    // ------------------------------------------------------------
    // Subclases concretas: implementan TODO lo abstracto
    // ------------------------------------------------------------
    static class Fijo extends Empleado {
        public Fijo(String nombre, double sueldo) {
            super(nombre, sueldo);
        }

        @Override
        public double calcularSueldo() {
            return sueldoBase;
        }

        @Override
        public String getPuesto() {
            return "Fijo";
        }
    }

    static class PorHoras extends Empleado {
        private final int horas;

        public PorHoras(String nombre, double precioHora, int horas) {
            super(nombre, precioHora);
            this.horas = horas;
        }

        @Override
        public double calcularSueldo() {
            return sueldoBase * horas;
        }

        @Override
        public String getPuesto() {
            return "Por horas";
        }
    }

    static class Comercial extends Empleado {
        private final double ventas;

        public Comercial(String nombre, double base, double ventas) {
            super(nombre, base);
            this.ventas = ventas;
        }

        @Override
        public double calcularSueldo() {
            return sueldoBase + ventas * 0.05;
        }

        @Override
        public String getPuesto() {
            return "Comercial";
        }
    }

    // Si una subclase no implementa algún método abstracto, no compila:
    // static class Becario extends Empleado {
    //     public Becario(String n) { super(n, 600); }
    //     @Override public double calcularSueldo() { return sueldoBase; }
    // }
    // ❌ error: Becario is not abstract and does not override abstract method getPuesto()

    public static void main(String[] args) {

        // Empleado e = new Empleado("Nadie", 0);
        // ❌ error: Empleado is abstract; cannot be instantiated

        Empleado[] plantilla = {
                new Fijo("Ana", 2100),
                new PorHoras("Luis", 14.5, 120),
                new Comercial("Marta", 1200, 36000)
        };

        double total = 0;
        for (Empleado e : plantilla) {
            System.out.println(e.generarNomina());   // generarNomina es de Empleado, pero usa los métodos de cada subclase
            total += e.calcularSueldo();
        }
        System.out.printf("%-21s %,10.2f €%n", "TOTAL", total);

        // Ventajas frente al tema 13:
        //   1. Ya no se puede crear un "Empleado genérico" sin sentido.
        //   2. El compilador OBLIGA a cada subclase a decir cómo calcula su sueldo.

        // PRUEBA: quita el comentario de la clase Becario y lee el error. Arréglalo.
    }
}
