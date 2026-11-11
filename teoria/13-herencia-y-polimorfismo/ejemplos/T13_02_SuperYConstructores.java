/*
 * TEMA 13 · Herencia y polimorfismo
 * Ejemplo 02: CONSTRUCTORES, super(...) Y protected
 *
 * Cómo ejecutarlo:  java T13_02_SuperYConstructores.java
 */
public class T13_02_SuperYConstructores {

    static class Persona {
        protected final String nombre;
        protected final int edad;

        public Persona(String nombre, int edad) {
            System.out.println("  1) Constructor de Persona");
            this.nombre = nombre;
            this.edad = edad;
        }

        public String presentarse() {
            return "Me llamo " + nombre + " y tengo " + edad + " años";
        }
    }

    static class Empleado extends Persona {
        protected double sueldo;

        public Empleado(String nombre, int edad, double sueldo) {
            super(nombre, edad);                      // SIEMPRE la primera instrucción
            System.out.println("  2) Constructor de Empleado");
            this.sueldo = sueldo;
        }

        // Sobrecarga de constructores: un empleado en prácticas cobra 800
        public Empleado(String nombre, int edad) {
            this(nombre, edad, 800);                  // this(...) llama a otro constructor de ESTA clase
        }
    }

    static class Jefe extends Empleado {
        private final String departamento;

        public Jefe(String nombre, int edad, double sueldo, String departamento) {
            super(nombre, edad, sueldo);              // Llama al constructor de Empleado
            System.out.println("  3) Constructor de Jefe");
            this.departamento = departamento;
        }

        public String getFicha() {
            // nombre, edad y sueldo son protected: se usan directamente desde la subclase
            return nombre + " (" + edad + ") - jefe de " + departamento + " - " + sueldo + " €";
        }
    }

    // Una subclase que se olvida de llamar a super(...)
    // static class Becario extends Persona {
    //     public Becario(String nombre) { }
    // }
    // ❌ Error: Java pone super() automáticamente, pero Persona no tiene constructor sin parámetros:
    //    constructor Persona in class Persona cannot be applied to given types

    public static void main(String[] args) {

        // Los constructores se ejecutan de ARRIBA ABAJO en la jerarquía
        System.out.println("Creando un Jefe:");
        Jefe jefa = new Jefe("Marta", 45, 3200, "Ventas");
        System.out.println(jefa.getFicha());
        System.out.println(jefa.presentarse());          // Heredado de Persona (a través de Empleado)
        System.out.println();

        System.out.println("Creando un Empleado en prácticas:");
        Empleado becario = new Empleado("Luis", 21);
        System.out.println(becario.presentarse() + " y cobro " + becario.sueldo + " €");
        System.out.println();

        // Un Jefe ES UN Empleado y ES UNA Persona
        System.out.println("¿jefa es un Empleado? " + (jefa instanceof Empleado));
        System.out.println("¿jefa es una Persona? " + (jefa instanceof Persona));

        // PRUEBA: quita el comentario de la clase Becario y lee el error.
        //    Arréglalo añadiendo super(nombre, 18); como primera línea.
    }
}
