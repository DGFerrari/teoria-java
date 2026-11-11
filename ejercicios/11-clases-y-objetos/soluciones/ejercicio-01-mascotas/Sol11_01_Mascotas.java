/*
 * TEMA 11 · Ejercicio 01 · Mascotas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol11_01_Mascotas.java
 */
public class Sol11_01_Mascotas {

    static class Mascota {

        String nombre;
        String especie;
        int edad;

        String presentarse() {
            return "Soy " + nombre + ", un " + especie + " de " + edad + " años";
        }

        void cumplirAnios() {
            edad++;                     // La edad de ESTA mascota
        }

        boolean esJoven() {
            return edad < 2;
        }
    }

    public static void main(String[] args) {

        Mascota toby = new Mascota();
        toby.nombre = "Toby";
        toby.especie = "perro";
        toby.edad = 3;

        Mascota misi = new Mascota();
        misi.nombre = "Misi";
        misi.especie = "gato";
        misi.edad = 1;

        System.out.println(toby.presentarse());
        System.out.println("¿" + toby.nombre + " es joven? " + toby.esJoven());
        System.out.println(misi.presentarse());
        System.out.println("¿" + misi.nombre + " es joven? " + misi.esJoven());

        System.out.println(misi.nombre + " cumple años...");
        misi.cumplirAnios();
        System.out.println(misi.presentarse());
        System.out.println("¿" + misi.nombre + " es joven? " + misi.esJoven());
    }
}
