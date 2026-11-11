/*
 * TEMA 01 · Ejercicio 01 · Receta en orden  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol01_01_RecetaEnOrden.java
 */
public class Sol01_01_RecetaEnOrden {

    public static void main(String[] args) {

        // Pseudocódigo:
        // INICIO
        //     ESCRIBIR título
        //     ESCRIBIR los 7 pasos en orden
        //     ESCRIBIR despedida
        // FIN

        System.out.println("=== Tostada con tomate ===");

        // Cada paso depende de los anteriores, por eso este orden:
        System.out.println("1. Cortar una rebanada de pan");
        System.out.println("2. Meter el pan en la tostadora y esperar");
        System.out.println("3. Rallar medio tomate");                      // Mientras se tuesta el pan
        System.out.println("4. Sacar el pan de la tostadora");
        System.out.println("5. Untar el tomate sobre el pan");             // Necesita pan tostado y tomate rallado
        System.out.println("6. Echar un chorrito de aceite y una pizca de sal");
        System.out.println("7. Comer la tostada");

        System.out.println("¡Buen provecho!");
    }
}
