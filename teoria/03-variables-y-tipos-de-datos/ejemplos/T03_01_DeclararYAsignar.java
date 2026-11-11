/*
 * TEMA 03 · Variables y tipos de datos
 * Ejemplo 01: DECLARAR, INICIALIZAR Y ASIGNAR
 *
 * Cómo ejecutarlo:  java T03_01_DeclararYAsignar.java
 */
public class T03_01_DeclararYAsignar {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Declarar y después asignar
        // ------------------------------------------------------------
        int puntos;            // Declaramos: la caja existe pero está vacía
        // System.out.println(puntos);  // ❌ Error: might not have been initialized
        puntos = 0;            // Asignamos el primer valor
        System.out.println("Puntos al empezar: " + puntos);   // 0

        // ------------------------------------------------------------
        // 2. Declarar e inicializar a la vez (lo más habitual)
        // ------------------------------------------------------------
        int vidas = 3;
        String jugador = "Ana";
        System.out.println(jugador + " tiene " + vidas + " vidas");

        // ------------------------------------------------------------
        // 3. Reasignar: el valor anterior se pierde
        // ------------------------------------------------------------
        puntos = 100;          // Ya NO se escribe "int": la variable ya existe
        vidas = vidas - 1;     // Usamos el valor actual para calcular el nuevo
        System.out.println("Puntos: " + puntos + " | Vidas: " + vidas);   // 100 | 2

        // int vidas = 5;      // ❌ Error: variable vidas is already defined

        // ------------------------------------------------------------
        // 4. Copiar el valor de una variable en otra
        // ------------------------------------------------------------
        int record = puntos;   // record recibe una COPIA del valor (100)
        puntos = 250;          // Cambiar puntos NO cambia record
        System.out.println("Puntos: " + puntos + " | Récord anterior: " + record);   // 250 | 100

        // ------------------------------------------------------------
        // 5. Nombres válidos y nombres descriptivos
        // ------------------------------------------------------------
        int numeroDeEnemigos = 12;      // ✅ camelCase y descriptivo
        boolean juegoTerminado = false; // ✅ boolean con forma de pregunta/estado
        int _temporal = 1;              // ✅ válido, aunque poco habitual
        // int 2jugadores = 2;          // ❌ no puede empezar por número
        // int mi-variable = 3;         // ❌ el guion no está permitido
        // int class = 4;               // ❌ "class" es una palabra reservada

        System.out.println("Enemigos: " + numeroDeEnemigos + " | Terminado: " + juegoTerminado + " | " + _temporal);

        // PRUEBA: descomenta las líneas marcadas con ❌ una a una y lee el error.
    }
}
