/*
 * TEMA 02 · Ejercicio 03 · Caza de errores  (dificultad: 3/5)
 *
 * ¡ATENCIÓN! Este archivo NO COMPILA A PROPÓSITO.
 * Tiene 5 errores de compilación, 1 de ejecución y 1 lógico.
 *
 * TODO: encuéntralos y arréglalos uno a uno. Al lado de cada corrección,
 *       deja un comentario:  // Error de compilación / ejecución / lógico
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej02_03_CazaDeErrores.java
 */
public class Ej02_03_CazaDeErrores {

    public static void main(String[] args) {

        System.out.println("=== Ficha del videojuego ===")
        System.out.println("Título: \"La leyenda del código\"");
        system.out.println("Género: aventura");
        System.out.printn("Precio: 59.99 euros");

        // Hay 3 jugadores y se une 1 más: deberían salir 4
        System.out.println("Jugadores en el modo cooperativo: " + 3 + 1);

        // NO TOCAR: los datos para el reparto de puntos
        int puntosTotales = 1000;
        int jugadores = 0;

        System.out.println("Puntos por jugador: " + (puntosTotales / jugadores));

        System.out.println("=== Fin de la ficha ===);
    }
