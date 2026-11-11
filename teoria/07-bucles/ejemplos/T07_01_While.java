/*
 * TEMA 07 · Bucles
 * Ejemplo 01: while
 *
 * Cómo ejecutarlo:  java T07_01_While.java
 */
public class T07_01_While {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Las tres piezas de un bucle
        // ------------------------------------------------------------
        int i = 1;                          // 1. Inicialización
        while (i <= 5) {                    // 2. Condición (se comprueba ANTES de cada vuelta)
            System.out.println("Vuelta " + i);
            i++;                            // 3. Actualización
        }
        System.out.println("Al salir, i vale " + i);   // 6: la primera que no cumple i <= 5
        System.out.println();

        // ------------------------------------------------------------
        // 2. Puede no ejecutarse NINGUNA vez
        // ------------------------------------------------------------
        int entradasDisponibles = 0;
        while (entradasDisponibles > 0) {
            System.out.println("Vendiendo entrada...");   // Nunca se ejecuta
            entradasDisponibles--;
        }
        System.out.println("No quedaban entradas: el while no ha dado ninguna vuelta");
        System.out.println();

        // ------------------------------------------------------------
        // 3. Cuando NO sabemos cuántas vueltas habrá
        // ------------------------------------------------------------
        // ¿Cuántas veces hay que duplicar 1 para superar 1000?
        int valor = 1;
        int veces = 0;
        while (valor <= 1000) {
            valor *= 2;
            veces++;
        }
        System.out.println("Duplicando 1, se supera 1000 tras " + veces + " veces (valor = " + valor + ")");

        // ¿Cuántas cifras tiene un número? Quitamos cifras con / 10 hasta llegar a 0.
        int numero = 908172;
        int copia = numero;      // Trabajamos con una copia para no perder el original
        int cifras = 0;
        while (copia > 0) {
            copia /= 10;
            cifras++;
        }
        System.out.println(numero + " tiene " + cifras + " cifras");
        System.out.println();

        // ------------------------------------------------------------
        // 4. Un ahorro con objetivo (dos formas de terminar en la condición)
        // ------------------------------------------------------------
        double saldo = 1000;
        double objetivo = 1500;
        double interes = 0.05;          // 5 % anual
        int anios = 0;
        int maxAnios = 20;

        while (saldo < objetivo && anios < maxAnios) {
            saldo += saldo * interes;
            anios++;
            System.out.printf("Año %d: %.2f euros%n", anios, saldo);
        }
        System.out.println(saldo >= objetivo
                ? "Objetivo alcanzado en " + anios + " años"
                : "No se alcanzó el objetivo en " + maxAnios + " años");

        // PRUEBA: borra la línea "i++;" del primer bucle y ejecuta.
        //    Verás un bucle infinito. Páralo con Ctrl + C.
    }
}
