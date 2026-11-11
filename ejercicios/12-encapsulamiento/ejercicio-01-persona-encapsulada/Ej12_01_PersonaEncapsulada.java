/*
 * TEMA 12 · Ejercicio 01 · Persona encapsulada  (dificultad: 1/5)
 *
 * Objetivo: proteger los atributos y validar cada cambio.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej12_01_PersonaEncapsulada.java
 */
public class Ej12_01_PersonaEncapsulada {

    static class Persona {

        // TODO 1: haz private los tres atributos
        String nombre;
        int edad;
        String email;

        // TODO 2: valores por defecto y después los setters
        public Persona(String nombre, int edad, String email) {
        }

        // TODO 3: getters
        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return 0;
        }

        public String getEmail() {
            return "";
        }

        // TODO 4: setters con validación
        public void setNombre(String nombre) {
        }

        public void setEdad(int edad) {
        }

        public void setEmail(String email) {
        }

        @Override
        public String toString() {
            return getNombre() + " (" + getEdad() + " años) - " + getEmail();
        }
    }

    // NO TOCAR: desde el main solo se usan los métodos públicos
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
