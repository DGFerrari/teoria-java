/*
 * TEMA 01 · Lógica de programación
 * Ejemplo 01: SECUENCIA
 *
 * La secuencia es la estructura más simple: las instrucciones se ejecutan
 * una detrás de otra, de arriba abajo, en el orden en que están escritas.
 *
 * Cómo ejecutarlo:  java T01_01_Secuencia.java
 */

// No te preocupes todavía por "public class" ni por "main".
// Es el "envoltorio" que todo programa de Java necesita. Lo explicamos en el tema 02.
public class T01_01_Secuencia {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Un algoritmo cotidiano: preparar un vaso de leche con cacao
        // ------------------------------------------------------------
        // System.out.println("...") significa: ESCRIBIR "..." en pantalla.
        // Cada instrucción termina con punto y coma ( ; ).

        System.out.println("=== Preparar un vaso de leche con cacao ===");
        System.out.println("1. Coger un vaso");
        System.out.println("2. Llenar el vaso de leche");
        System.out.println("3. Echar dos cucharadas de cacao");
        System.out.println("4. Remover hasta que no queden grumos");
        System.out.println("5. Beber");

        // Salida esperada: los cinco pasos en el mismo orden en que están escritos.

        // Línea vacía para separar
        System.out.println();

        // ------------------------------------------------------------
        // 2. El orden importa
        // ------------------------------------------------------------
        // Si cambiamos el orden de las instrucciones, cambia el resultado.
        // El ordenador no "entiende" que esto no tiene sentido: lo ejecuta tal cual.

        System.out.println("=== El mismo algoritmo, mal ordenado ===");
        System.out.println("1. Beber");
        System.out.println("2. Coger un vaso");
        System.out.println("3. Remover hasta que no queden grumos");
        System.out.println("4. Llenar el vaso de leche");
        System.out.println("5. Echar dos cucharadas de cacao");

        // PRUEBA: cambia de sitio alguna línea de arriba y vuelve a ejecutar.
        //    Verás que la salida cambia exactamente igual que el orden del código.
    }
}
