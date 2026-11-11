/*
 * TEMA 04 · Ejercicio 05 · Cajero automático  (dificultad: 5/5)
 *
 * Objetivo: simular una retirada de efectivo usando todos los operadores del tema.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej04_05_CajeroAutomatico.java
 */
import java.util.Random;

public class Ej04_05_CajeroAutomatico {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // NO TOCAR: datos iniciales
        // ------------------------------------------------------------
        final double PORCENTAJE_COMISION = 0.02;   // 2 %
        final int MAXIMO_RETIRADA = 500;
        long saldoCentimos = 100_000L;             // 1000 euros en céntimos
        int operaciones = 0;

        Random random = new Random();

        // TODO 1: genera la cantidad (1 a MAXIMO_RETIRADA, ambos incluidos).
        //         Para probar con el enunciado, usa: int cantidad = 387;
        int cantidad = 0;

        // TODO 2: desglosa la cantidad en billetes de 50, 20, 10, 5
        //         y monedas de 2 y 1 (usa / y %).

        // TODO 3: calcula el total de billetes y el total de monedas.

        // TODO 4: calcula la comisión en céntimos (redondeada).

        // TODO 5: calcula si la operación es válida (ANTES de tocar el saldo).

        // TODO 6: resta del saldo la cantidad y la comisión (en céntimos) con -=
        //         y suma 1 a "operaciones" con ++.

        // TODO 7: calcula los dos boolean restantes (saldo < 700 euros y múltiplo de 10).

        // TODO 8: muestra el resultado (mira la salida esperada).
        System.out.println("=== CAJERO AUTOMÁTICO ===");
        System.out.println("Cantidad solicitada: " + cantidad + " euros");
    }
}
