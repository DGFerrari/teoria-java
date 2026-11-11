/*
 * TEMA 13 · Ejercicio 04 · Agenda sin duplicados  (dificultad: 4/5)
 *
 * Objetivo: sobrescribir equals, hashCode y toString y usarlos para evitar duplicados.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej13_04_AgendaSinDuplicados.java
 *
 * Regla: sin break ni continue, y sin return dentro de los bucles.
 */
import java.util.Objects;

public class Ej13_04_AgendaSinDuplicados {

    static class Contacto {
        private final String nombre;
        private final String telefono;

        // TODO 1: guarda el teléfono normalizado (sin espacios, guiones ni puntos)
        public Contacto(String nombre, String telefono) {
            this.nombre = nombre;
            this.telefono = telefono;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        // TODO 2: sobrescribe equals(Object): iguales si tienen el mismo teléfono

        // TODO 3: sobrescribe hashCode() de forma coherente con equals

        // TODO 4: sobrescribe toString(): "Ana García · 600123456"
    }

    static class Agenda {
        private final Contacto[] contactos = new Contacto[20];
        private int cantidad = 0;

        // TODO 5: busca con equals (bandera, sin return dentro del bucle)
        public boolean contiene(Contacto contacto) {
            return false;
        }

        // TODO 6: no añade duplicados
        public boolean agregar(Contacto contacto) {
            return false;
        }

        // TODO 7: "=== Agenda (N contactos) ===" y la lista numerada
        public void mostrar() {
        }
    }

    // NO TOCAR
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
