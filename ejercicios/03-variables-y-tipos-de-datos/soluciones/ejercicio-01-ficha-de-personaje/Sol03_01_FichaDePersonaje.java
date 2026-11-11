/*
 * TEMA 03 · Ejercicio 01 · Ficha de personaje  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol03_01_FichaDePersonaje.java
 */
public class Sol03_01_FichaDePersonaje {

    public static void main(String[] args) {

        String nombre = "Aria";           // Texto
        char clase = 'M';                 // Un solo carácter → comillas simples
        int nivel = 12;                   // Entero pequeño
        double vida = 87.5;               // Decimal
        long oro = 3_500_000_000L;        // No cabe en int → long con sufijo L
        boolean envenenada = false;       // Sí / no

        System.out.println("=== FICHA DE PERSONAJE ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Clase: " + clase);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + vida);
        System.out.println("Oro: " + oro);
        System.out.println("Envenenada: " + envenenada);
    }
}
