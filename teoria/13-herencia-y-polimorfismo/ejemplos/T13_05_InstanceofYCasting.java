/*
 * TEMA 13 · Herencia y polimorfismo
 * Ejemplo 05: UPCASTING, DOWNCASTING E instanceof
 *
 * Cómo ejecutarlo:  java T13_05_InstanceofYCasting.java
 */
public class T13_05_InstanceofYCasting {

    static class Empleado {
        protected final String nombre;
        protected final double sueldo;

        public Empleado(String nombre, double sueldo) {
            this.nombre = nombre;
            this.sueldo = sueldo;
        }

        public String getNombre() {
            return nombre;
        }
    }

    static class Programador extends Empleado {
        private final String lenguaje;

        public Programador(String nombre, double sueldo, String lenguaje) {
            super(nombre, sueldo);
            this.lenguaje = lenguaje;
        }

        public String getLenguaje() {
            return lenguaje;
        }
    }

    static class Comercial extends Empleado {
        private final double ventas;

        public Comercial(String nombre, double sueldo, double ventas) {
            super(nombre, sueldo);
            this.ventas = ventas;
        }

        public double getVentas() {
            return ventas;
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Upcasting (automático) y downcasting (explícito)
        // ------------------------------------------------------------
        Empleado e = new Programador("Lucía", 2800, "Java");   // Upcasting: automático
        // e.getLenguaje();                                    // ❌ Error: Empleado no tiene ese método

        Programador p = (Programador) e;                       // Downcasting: hay que pedirlo
        System.out.println(p.getNombre() + " programa en " + p.getLenguaje());

        // Un downcasting equivocado compila, pero falla al ejecutar:
        // Comercial c = (Comercial) e;   // ❌ ClassCastException: Programador cannot be cast to Comercial
        System.out.println();

        // ------------------------------------------------------------
        // 2. instanceof: comprobar antes de convertir
        // ------------------------------------------------------------
        Empleado[] plantilla = {
                new Programador("Lucía", 2800, "Java"),
                new Comercial("Jorge", 1900, 125_000),
                new Empleado("Ana", 1600),
                new Programador("Pablo", 2500, "Python")
        };

        System.out.println("=== Forma clásica ===");
        for (Empleado emp : plantilla) {
            if (emp instanceof Programador) {
                Programador prog = (Programador) emp;          // Seguro: ya sabemos que lo es
                System.out.println(prog.getNombre() + " → programador de " + prog.getLenguaje());
            } else if (emp instanceof Comercial) {
                Comercial com = (Comercial) emp;
                System.out.println(com.getNombre() + " → comercial con " + com.getVentas() + " € en ventas");
            } else {
                System.out.println(emp.getNombre() + " → empleado");
            }
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3. instanceof con PATRÓN (Java 16+): comprueba y convierte a la vez
        // ------------------------------------------------------------
        System.out.println("=== Con patrón ===");
        int programadoresJava = 0;
        for (Empleado emp : plantilla) {
            if (emp instanceof Programador prog && prog.getLenguaje().equals("Java")) {
                programadoresJava++;                           // "prog" ya es un Programador
            }
        }
        System.out.println("Programadores de Java: " + programadoresJava);
        System.out.println();

        // ------------------------------------------------------------
        // 4. switch con patrones de tipo (Java 21+)
        // ------------------------------------------------------------
        System.out.println("=== switch con patrones ===");
        for (Empleado emp : plantilla) {
            String descripcion = switch (emp) {
                case Programador prog -> "💻 " + prog.getNombre() + " (" + prog.getLenguaje() + ")";
                case Comercial com -> "📈 " + com.getNombre() + " (" + com.getVentas() + " €)";
                default -> "👤 " + emp.getNombre();
            };
            System.out.println(descripcion);
        }

        // instanceof también responde true con la superclase:
        System.out.println();
        System.out.println("¿Lucía es un Empleado? " + (plantilla[0] instanceof Empleado));   // true
        System.out.println("¿Ana es una Programadora? " + (plantilla[2] instanceof Programador)); // false

        // Consejo: si usas muchos instanceof para decidir qué hacer, plantéate un método
        // sobrescrito en cada subclase (polimorfismo). Lo verás en los ejercicios.
    }
}
