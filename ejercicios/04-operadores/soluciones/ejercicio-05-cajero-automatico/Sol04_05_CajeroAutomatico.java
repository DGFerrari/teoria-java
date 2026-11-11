/*
 * TEMA 04 · Ejercicio 05 · Cajero automático  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol04_05_CajeroAutomatico.java
 */
import java.util.Random;

public class Sol04_05_CajeroAutomatico {

    public static void main(String[] args) {

        final double PORCENTAJE_COMISION = 0.02;
        final int MAXIMO_RETIRADA = 500;
        long saldoCentimos = 100_000L;
        int operaciones = 0;

        Random random = new Random();

        // 1. Cantidad aleatoria entre 1 y 500 (el límite superior de nextInt no se incluye)
        int cantidad = random.nextInt(1, MAXIMO_RETIRADA + 1);
        // int cantidad = 387;   // Descomenta (y comenta la de arriba) para comparar con el enunciado

        // 2. Desglose: "/" da cuántas piezas y "%" lo que queda por repartir
        int billetes50 = cantidad / 50;
        int resto = cantidad % 50;
        int billetes20 = resto / 20;
        resto %= 20;
        int billetes10 = resto / 10;
        resto %= 10;
        int billetes5 = resto / 5;
        resto %= 5;
        int monedas2 = resto / 2;
        resto %= 2;
        int monedas1 = resto;

        // 3. Totales
        int totalBilletes = billetes50 + billetes20 + billetes10 + billetes5;
        int totalMonedas = monedas2 + monedas1;

        // 4. Comisión en céntimos, redondeada
        long comisionCentimos = Math.round(cantidad * 100 * PORCENTAJE_COMISION);
        long cargoTotalCentimos = cantidad * 100L + comisionCentimos;

        // 5. Validez, calculada ANTES de modificar el saldo
        boolean operacionValida = cantidad >= 1 && cantidad <= MAXIMO_RETIRADA
                && cargoTotalCentimos <= saldoCentimos;

        // 6. Actualizar el estado
        saldoCentimos -= cargoTotalCentimos;
        operaciones++;

        // 7. Resto de comprobaciones (700 euros también en céntimos)
        boolean saldoBajo = saldoCentimos < 700 * 100;
        boolean multiploDeDiez = cantidad % 10 == 0;

        // 8. Salida (dividimos entre 100.0 para ver los céntimos como decimales)
        System.out.println("=== CAJERO AUTOMÁTICO ===");
        System.out.println("Cantidad solicitada: " + cantidad + " euros");
        System.out.println("Billetes de 50: " + billetes50);
        System.out.println("Billetes de 20: " + billetes20);
        System.out.println("Billetes de 10: " + billetes10);
        System.out.println("Billetes de 5: " + billetes5);
        System.out.println("Monedas de 2: " + monedas2);
        System.out.println("Monedas de 1: " + monedas1);
        System.out.println("Total de billetes: " + totalBilletes + " | Total de monedas: " + totalMonedas);
        System.out.println("Comisión (2%): " + comisionCentimos / 100.0 + " euros");
        System.out.println("Saldo restante: " + saldoCentimos / 100.0 + " euros");
        System.out.println("Operaciones realizadas: " + operaciones);
        System.out.println("¿Operación válida? " + operacionValida);
        System.out.println("¿Saldo por debajo de 700 euros? " + saldoBajo);
        System.out.println("¿Cantidad múltiplo de 10? " + multiploDeDiez);
    }
}
