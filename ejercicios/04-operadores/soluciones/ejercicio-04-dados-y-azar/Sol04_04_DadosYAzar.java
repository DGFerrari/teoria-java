/*
 * TEMA 04 · Ejercicio 04 · Dados y azar  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol04_04_DadosYAzar.java
 */
import java.util.Random;

public class Sol04_04_DadosYAzar {

    public static void main(String[] args) {

        Random random = new Random();

        // 1. Dos dados (el límite superior de nextInt no se incluye)
        int dado1 = random.nextInt(1, 7);
        int dado2 = random.nextInt(1, 7);
        int suma = dado1 + dado2;
        boolean esDoble = dado1 == dado2;
        boolean sumaPar = suma % 2 == 0;

        // 2. Carta
        int numeroCarta = random.nextInt(1, 13);
        int palo = random.nextInt(4);

        // 3. Temperatura con un decimal (comprobamos el rango con la original)
        double temperatura = random.nextDouble(-5, 35);
        double temperaturaRedondeada = Math.round(temperatura * 10) / 10.0;

        // 4. Código secreto con la fórmula general (min y max incluidos)
        int min = 100;
        int max = 999;
        int codigo = random.nextInt(max - min + 1) + min;
        int centenas = codigo / 100;
        int decenas = codigo / 10 % 10;
        int unidades = codigo % 10;
        int sumaCifras = centenas + decenas + unidades;

        // 5. Moneda
        boolean cara = random.nextBoolean();

        // 6. Salida
        System.out.println("Dado 1: " + dado1 + " | Dado 2: " + dado2 + " | Suma: " + suma);
        System.out.println("¿Es doble? " + esDoble + " | ¿Suma par? " + sumaPar);
        System.out.println("Carta: " + numeroCarta + " del palo " + palo);
        System.out.println("Temperatura: " + temperaturaRedondeada + " ºC");
        System.out.println("Código secreto: " + codigo + " → cifras " + centenas + ", " + decenas + ", "
                + unidades + " → suma " + sumaCifras);
        System.out.println("¿Cara? " + cara);

        // Comprobaciones: deben dar true SIEMPRE
        boolean dadosEnRango = dado1 >= 1 && dado1 <= 6 && dado2 >= 1 && dado2 <= 6;
        boolean cartaEnRango = numeroCarta >= 1 && numeroCarta <= 12 && palo >= 0 && palo <= 3;
        boolean temperaturaEnRango = temperatura >= -5 && temperatura < 35;
        boolean codigoEnRango = codigo >= min && codigo <= max;

        System.out.println("--- Comprobaciones ---");
        System.out.println("Dados en rango: " + dadosEnRango);
        System.out.println("Carta en rango: " + cartaEnRango);
        System.out.println("Temperatura en rango: " + temperaturaEnRango);
        System.out.println("Código en rango: " + codigoEnRango);
    }
}
