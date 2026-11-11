/*
 * TEMA 04 · Operadores
 * Ejemplo 05: NÚMEROS ALEATORIOS (Random y Math.random)
 *
 * Cada vez que lo ejecutes saldrán números distintos (salvo en la parte de la semilla).
 *
 * Cómo ejecutarlo:  java T04_05_NumerosAleatorios.java
 */

// Random no está disponible por defecto: hay que importarla.
// Los import van SIEMPRE antes de la clase.
import java.util.Random;

public class T04_05_NumerosAleatorios {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Crear el generador (UNA vez) y pedirle números
        // ------------------------------------------------------------
        Random random = new Random();

        // nextInt(n) → de 0 a n-1
        int deCeroANueve = random.nextInt(10);
        System.out.println("Entre 0 y 9: " + deCeroANueve);

        // Un dado: nextInt(6) da 0..5, así que sumamos 1 → 1..6
        int dado = random.nextInt(6) + 1;
        System.out.println("Dado (nextInt(6) + 1): " + dado);

        // Java 17+: nextInt(min, max) → de min a max-1 (¡el máximo no se incluye!)
        int otroDado = random.nextInt(1, 7);
        System.out.println("Dado (nextInt(1, 7)):  " + otroDado);

        // Fórmula general para un entero entre min y max, AMBOS incluidos
        int min = 10;
        int max = 20;
        int entreDiezYVeinte = random.nextInt(max - min + 1) + min;
        System.out.println("Entre " + min + " y " + max + ": " + entreDiezYVeinte);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Otros tipos
        // ------------------------------------------------------------
        double decimal = random.nextDouble();              // 0.0 a 1.0 (sin llegar a 1)
        double temperatura = random.nextDouble(-5, 35);    // -5.0 a 35.0 (sin llegar a 35)
        boolean cara = random.nextBoolean();               // true o false

        System.out.println("Decimal entre 0 y 1: " + decimal);
        System.out.println("Temperatura: " + Math.round(temperatura * 10) / 10.0 + " ºC");
        System.out.println("¿Ha salido cara? " + cara);
        System.out.println();

        // Comprobar que un número está en el rango esperado (útil para probar)
        System.out.println("¿El dado está entre 1 y 6? " + (dado >= 1 && dado <= 6));   // Siempre true
        System.out.println();

        // ------------------------------------------------------------
        // 3. Semilla: la misma secuencia en cada ejecución
        // ------------------------------------------------------------
        Random conSemilla = new Random(42);
        System.out.println("Con semilla 42 (siempre igual): "
                + conSemilla.nextInt(100) + ", "
                + conSemilla.nextInt(100) + ", "
                + conSemilla.nextInt(100));
        // Ejecuta el programa varias veces: estos tres números no cambian.
        System.out.println();

        // ------------------------------------------------------------
        // 4. Math.random(): sin import, pero menos cómodo
        // ------------------------------------------------------------
        double aleatorio = Math.random();                  // 0.0 a 1.0 (sin llegar a 1)
        int dadoConMath = (int) (Math.random() * 6) + 1;   // Escalar, cortar y desplazar
        System.out.println("Math.random(): " + aleatorio);
        System.out.println("Dado con Math.random(): " + dadoConMath);

        // ¿Por qué funciona la fórmula?
        //   Math.random()          → 0.0 ... 0.999
        //   * 6                    → 0.0 ... 5.999
        //   (int)                  → 0, 1, 2, 3, 4, 5
        //   + 1                    → 1, 2, 3, 4, 5, 6

        // PRUEBA: simula una carta: un número del 1 al 12 y un palo del 0 al 3.
    }
}
