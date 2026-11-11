/*
 * TEMA 13 · Ejercicio 04 · Agenda sin duplicados  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol13_04_AgendaSinDuplicados.java
 */
import java.util.Objects;

public class Sol13_04_AgendaSinDuplicados {

    static class Contacto {
        private final String nombre;
        private final String telefono;

        public Contacto(String nombre, String telefono) {
            this.nombre = nombre;
            // Normalizado: así equals solo tiene que comparar textos
            this.telefono = telefono.replace(" ", "").replace("-", "").replace(".", "");
        }

        public String getNombre() {
            return nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        @Override
        public boolean equals(Object otro) {
            if (this == otro) {
                return true;
            }
            if (!(otro instanceof Contacto contacto)) {   // false también con null
                return false;
            }
            return telefono.equals(contacto.telefono);
        }

        @Override
        public int hashCode() {
            return Objects.hash(telefono);                 // Mismos atributos que en equals
        }

        @Override
        public String toString() {
            return nombre + " · " + telefono;
        }
    }

    static class Agenda {
        private final Contacto[] contactos = new Contacto[20];
        private int cantidad = 0;

        public boolean contiene(Contacto contacto) {
            boolean encontrado = false;
            for (int i = 0; i < cantidad && !encontrado; i++) {
                encontrado = contactos[i].equals(contacto);
            }
            return encontrado;
        }

        public boolean agregar(Contacto contacto) {
            boolean posible = cantidad < contactos.length && !contiene(contacto);
            if (posible) {
                contactos[cantidad] = contacto;
                cantidad++;
            }
            return posible;
        }

        public void mostrar() {
            System.out.println("=== Agenda (" + cantidad + " contactos) ===");
            for (int i = 0; i < cantidad; i++) {
                System.out.println((i + 1) + ". " + contactos[i]);
            }
        }
    }

    public static void main(String[] args) {
        Contacto c1 = new Contacto("Ana", "600 123 456");
        Contacto c2 = new Contacto("Ana García", "600-123-456");

        System.out.println("c1 == c2: " + (c1 == c2));
        System.out.println("c1.equals(c2): " + c1.equals(c2));
        System.out.println("Mismo hashCode: " + (c1.hashCode() == c2.hashCode()));
        System.out.println("c1.equals(null): " + c1.equals(null));
        System.out.println("c1.equals(\"600123456\"): " + c1.equals("600123456"));

        Agenda agenda = new Agenda();
        System.out.println("Añadir Ana: " + agenda.agregar(c1));
        System.out.println("Añadir Luis: " + agenda.agregar(new Contacto("Luis", "+34 611 222 333")));
        System.out.println("Añadir \"Ana García\" (mismo teléfono que Ana): " + agenda.agregar(c2));
        System.out.println("Añadir Marta: " + agenda.agregar(new Contacto("Marta", "622 333 444")));
        System.out.println("Añadir Luis con otro formato: " + agenda.agregar(new Contacto("Luis M.", "+34611222333")));
        System.out.println("¿Está el 622.333.444? " + agenda.contiene(new Contacto("?", "622.333.444")));
        agenda.mostrar();
    }
}
