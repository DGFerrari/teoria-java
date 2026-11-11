/*
 * TEMA 12 · Ejercicio 01 · Persona encapsulada  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol12_01_PersonaEncapsulada.java
 */
public class Sol12_01_PersonaEncapsulada {

    static class Persona {

        private String nombre;
        private int edad;
        private String email;

        public Persona(String nombre, int edad, String email) {
            // Primero valores seguros; después, los setters validan los datos recibidos
            this.nombre = "Sin nombre";
            this.edad = 0;
            this.email = "sin-email@ejemplo.com";
            setNombre(nombre);
            setEdad(edad);
            setEmail(email);
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public String getEmail() {
            return email;
        }

        public void setNombre(String nombre) {
            if (nombre != null && !nombre.isBlank()) {     // El cortocircuito evita NullPointerException
                this.nombre = nombre.strip();
            } else {
                System.out.println("  ⚠ Nombre no válido: \"" + nombre + "\"");
            }
        }

        public void setEdad(int edad) {
            if (edad >= 0 && edad <= 150) {
                this.edad = edad;
            } else {
                System.out.println("  ⚠ Edad no válida: " + edad);
            }
        }

        public void setEmail(String email) {
            if (email != null && email.contains("@")) {
                this.email = email;
            } else {
                System.out.println("  ⚠ Email no válido: " + email);
            }
        }

        @Override
        public String toString() {
            return getNombre() + " (" + getEdad() + " años) - " + getEmail();
        }
    }

    public static void main(String[] args) {
        Persona ana = new Persona("  Ana García ", 25, "ana@correo.com");
        System.out.println(ana);

        ana.setEdad(-3);
        ana.setEmail("correo-sin-arroba");
        ana.setNombre("   ");
        ana.setEdad(26);
        ana.setEmail("ana.garcia@correo.com");
        System.out.println(ana);

        Persona luis = new Persona("", 200, "luis@correo.com");
        System.out.println(luis);
    }
}
