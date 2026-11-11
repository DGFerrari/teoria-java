/*
 * TEMA 05 · Entrada y salida
 * Ejemplo 04: EL PROBLEMA DEL SALTO DE LÍNEA PENDIENTE
 *
 * Este programa te pide tres veces la edad y el nombre: una vez con el problema
 * y otra con cada solución. En la primera vez NO podrás escribir el nombre:
 * el programa se lo salta solo. Ejemplo de respuestas:
 *   15 ⏎            (el nombre se salta)
 *   16 ⏎ Luis ⏎
 *   17 ⏎ Marta ⏎
 *
 * Cómo ejecutarlo:  java T05_04_ProblemaNextLine.java
 */
import java.util.Scanner;

public class T05_04_ProblemaNextLine {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // ============================================================
        // 1. EL PROBLEMA
        // ============================================================
        System.out.println("=== 1. Con el problema ===");
        System.out.print("Edad: ");
        int edad1 = teclado.nextInt();         // Se lleva el número, pero deja el Enter (⏎)

        System.out.print("Nombre: ");
        String nombre1 = teclado.nextLine();   // Lee el ⏎ pendiente → texto vacío. ¡No espera!

        System.out.println("Edad: " + edad1 + " | Nombre: [" + nombre1 + "]   ← ¡vacío!");
        System.out.println();

        // Ahora mismo NO queda nada pendiente: el nextLine anterior se llevó el ⏎.

        // ============================================================
        // 2. SOLUCIÓN A: un nextLine() extra para "limpiar"
        // ============================================================
        System.out.println("=== 2. Solución A: limpiar con nextLine() ===");
        System.out.print("Edad: ");
        int edad2 = teclado.nextInt();
        teclado.nextLine();                    // Se come el ⏎ pendiente (no guardamos el resultado)

        System.out.print("Nombre: ");
        String nombre2 = teclado.nextLine();   // ✅ Ahora sí espera

        System.out.println("Edad: " + edad2 + " | Nombre: [" + nombre2 + "]");
        System.out.println();

        // ============================================================
        // 3. SOLUCIÓN B: leer SIEMPRE con nextLine() y convertir
        // ============================================================
        System.out.println("=== 3. Solución B: todo con nextLine() + parseInt ===");
        System.out.print("Edad: ");
        int edad3 = Integer.parseInt(teclado.nextLine());   // Lee la línea entera, ⏎ incluido

        System.out.print("Nombre: ");
        String nombre3 = teclado.nextLine();                // ✅ No había nada pendiente

        System.out.println("Edad: " + edad3 + " | Nombre: [" + nombre3 + "]");

        teclado.close();

        // ¿Cuál elegir?
        //   - A: cómodo si casi todo son números y hay algún texto suelto.
        //   - B: más robusto; nunca deja nada pendiente.
        //        Ojo: Double.parseDouble usa SIEMPRE punto decimal ("1.68").
    }
}
