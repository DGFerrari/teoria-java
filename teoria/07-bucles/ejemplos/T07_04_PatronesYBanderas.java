/*
 * TEMA 07 · Bucles
 * Ejemplo 04: PATRONES (contador, acumulador, máximo, mínimo) Y BANDERAS
 *
 * Cómo ejecutarlo:  java T07_04_PatronesYBanderas.java
 */
import java.util.Random;

public class T07_04_PatronesYBanderas {

    public static void main(String[] args) {

        // Semilla fija: los "aleatorios" son siempre los mismos y puedes comprobar la salida
        Random random = new Random(2024);

        // ------------------------------------------------------------
        // 1. Contador, acumulador, máximo y mínimo a la vez
        // ------------------------------------------------------------
        // Simulamos las temperaturas de 7 días (entre -5 y 30)
        int dias = 7;

        int primera = random.nextInt(-5, 31);
        System.out.println("Día 1: " + primera + " ºC");

        int suma = primera;          // Acumulador (ya incluye el primer día)
        int maxima = primera;        // Máximo y mínimo: empiezan con el PRIMER valor
        int minima = primera;
        int diasBajoCero = primera < 0 ? 1 : 0;   // Contador condicional

        for (int dia = 2; dia <= dias; dia++) {
            int temperatura = random.nextInt(-5, 31);
            System.out.println("Día " + dia + ": " + temperatura + " ºC");

            suma += temperatura;
            if (temperatura > maxima) {
                maxima = temperatura;
            }
            if (temperatura < minima) {
                minima = temperatura;
            }
            if (temperatura < 0) {
                diasBajoCero++;
            }
        }

        double media = (double) suma / dias;
        System.out.printf("Media: %.1f | Máxima: %d | Mínima: %d | Días bajo cero: %d%n",
                media, maxima, minima, diasBajoCero);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Bandera: parar en cuanto encontramos algo (SIN break)
        // ------------------------------------------------------------
        // Buscar el primer múltiplo de 7 entre 50 y 100
        boolean encontrado = false;
        int numero = 50;

        while (numero <= 100 && !encontrado) {    // Las DOS formas de terminar, a la vista
            if (numero % 7 == 0) {
                encontrado = true;                // Esto hará que la condición sea false
            } else {
                numero++;
            }
        }

        if (encontrado) {
            System.out.println("Primer múltiplo de 7 entre 50 y 100: " + numero);   // 56
        } else {
            System.out.println("No hay múltiplos de 7 entre 50 y 100");
        }

        // La misma idea con un for: la bandera también puede ir en su condición
        int primerCuadradoMayorQue200 = 0;
        boolean hallado = false;
        for (int i = 1; i <= 100 && !hallado; i++) {
            if (i * i > 200) {
                primerCuadradoMayorQue200 = i;
                hallado = true;
            }
        }
        System.out.println("Primer número cuyo cuadrado supera 200: " + primerCuadradoMayorQue200);   // 15
        System.out.println();

        // ------------------------------------------------------------
        // 3. "Saltar" vueltas SIN continue: el resto de la vuelta va en un if
        // ------------------------------------------------------------
        System.out.print("Del 1 al 20, sin los múltiplos de 3: ");
        for (int i = 1; i <= 20; i++) {
            if (i % 3 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // PRUEBA: cambia la semilla (2024) por otro número. ¿Cambian las temperaturas?
    }
}
