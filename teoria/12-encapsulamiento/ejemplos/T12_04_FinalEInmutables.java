/*
 * TEMA 12 · Encapsulamiento
 * Ejemplo 04: ATRIBUTOS final Y CLASES INMUTABLES
 *
 * Cómo ejecutarlo:  java T12_04_FinalEInmutables.java
 */
public class T12_04_FinalEInmutables {

    // ------------------------------------------------------------
    // 1. Atributos final: se asignan una vez y no cambian
    // ------------------------------------------------------------
    static class Estudiante {
        private final String dni;          // No cambia nunca: final y sin setter
        private String correo;             // Puede cambiar: con setter

        public Estudiante(String dni, String correo) {
            this.dni = dni;                // Todo constructor DEBE dar valor a los final
            this.correo = correo;
        }

        public String getDni() {
            return dni;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            if (correo != null && correo.contains("@")) {
                this.correo = correo;
            }
        }

        // public void setDni(String dni) { this.dni = dni; }
        // ❌ Error: cannot assign a value to final variable dni
    }

    // ------------------------------------------------------------
    // 2. Clase INMUTABLE: atributos private final, sin setters,
    //    y los métodos que "modifican" devuelven un objeto nuevo
    // ------------------------------------------------------------
    static final class Dinero {            // final: nadie puede heredar y "romper" la inmutabilidad
        private final long centimos;       // Céntimos en un long: sin imprecisión (tema 03)
        private final String moneda;

        public Dinero(long centimos, String moneda) {
            this.centimos = centimos;
            this.moneda = moneda;
        }

        public static Dinero deEuros(double euros) {           // "Fábrica" static
            return new Dinero(Math.round(euros * 100), "EUR");
        }

        public Dinero sumar(Dinero otro) {
            return new Dinero(centimos + otro.centimos, moneda);    // Nuevo objeto
        }

        public Dinero multiplicar(int veces) {
            return new Dinero(centimos * veces, moneda);
        }

        public boolean esMayorQue(Dinero otro) {
            return centimos > otro.centimos;
        }

        @Override
        public String toString() {
            return String.format("%d.%02d %s", centimos / 100, centimos % 100, moneda);
        }
    }

    public static void main(String[] args) {

        Estudiante e = new Estudiante("12345678Z", "ana@correo.com");
        e.setCorreo("ana.lopez@instituto.es");
        e.setCorreo("correo-sin-arroba");                      // Rechazado
        System.out.println("DNI: " + e.getDni() + " | Correo: " + e.getCorreo());
        System.out.println();

        Dinero precio = Dinero.deEuros(19.99);
        Dinero envio = Dinero.deEuros(4.5);
        Dinero tresUnidades = precio.multiplicar(3);
        Dinero total = tresUnidades.sumar(envio);

        System.out.println("Precio: " + precio);               // No ha cambiado
        System.out.println("3 unidades: " + tresUnidades);
        System.out.println("Con envío: " + total);
        System.out.println("¿Total > 50 €? " + total.esMayorQue(Dinero.deEuros(50)));

        // Igual que con String: los "cambios" devuelven objetos nuevos.
        precio.sumar(envio);                                    // Se calcula y se pierde
        System.out.println("Precio sigue siendo: " + precio);

        // final en una VARIABLE que guarda un objeto: no se puede reasignar la referencia,
        // pero si el objeto fuera modificable, sí se podría cambiar por dentro.
        final Estudiante delegado = new Estudiante("87654321X", "delegado@instituto.es");
        delegado.setCorreo("nuevo@instituto.es");               // ✅ El objeto sí cambia
        // delegado = new Estudiante(...);                      // ❌ La referencia no
        System.out.println("Correo del delegado: " + delegado.getCorreo());
    }
}
