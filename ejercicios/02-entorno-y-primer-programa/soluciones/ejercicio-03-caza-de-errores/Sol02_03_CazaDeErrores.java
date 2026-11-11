/*
 * TEMA 02 · Ejercicio 03 · Caza de errores  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol02_03_CazaDeErrores.java
 */
public class Sol02_03_CazaDeErrores {

    public static void main(String[] args) {

        System.out.println("=== Ficha del videojuego ===");          // Error de compilación: faltaba ;
        System.out.println("Título: \"La leyenda del código\"");
        System.out.println("Género: aventura");                     // Error de compilación: system → System
        System.out.println("Precio: 59.99 euros");                  // Error de compilación: printn → println

        // Hay 3 jugadores y se une 1 más: deberían salir 4
        System.out.println("Jugadores en el modo cooperativo: " + (3 + 1));   // Error lógico: faltaban paréntesis

        int puntosTotales = 1000;
        int jugadores = 4;                                          // Error de ejecución: dividía entre 0

        System.out.println("Puntos por jugador: " + (puntosTotales / jugadores));

        System.out.println("=== Fin de la ficha ===");              // Error de compilación: comillas sin cerrar
    }
}                                                                   // Error de compilación: faltaba esta llave
