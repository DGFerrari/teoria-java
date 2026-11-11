/*
 * TEMA 03 · Ejercicio 03 · Conversor de unidades  (dificultad: 3/5)
 *
 * Objetivo: convertir unidades usando constantes, casting y Math.round.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej03_03_ConversorDeUnidades.java
 */
public class Ej03_03_ConversorDeUnidades {

    public static void main(String[] args) {

        // TODO 1: declara las tres constantes con final:
        //         KM_A_MILLAS (0.621371), CM_POR_PULGADA (2.54), MINUTOS_POR_HORA (60)

        // NO TOCAR: datos de entrada
        double kmMaraton = 42.195;
        int alturaCm = 180;
        int minutosPelicula = 135;
        int celsius = 38;

        // TODO 2: maratón → millas completas (corta los decimales)
        int millasCompletas = 0;

        // TODO 3: altura → pulgadas redondeadas
        long pulgadas = 0;

        // TODO 4: película → horas con decimales y horas completas
        double horasDecimal = 0;
        int horasCompletas = 0;

        // TODO 5: temperatura con la fórmula F = C * 9 / 5 + 32
        //         a) solo con enteros    b) con decimales
        int fahrenheitEntero = 0;
        double fahrenheitDecimal = 0;

        // Ya hecho: salida
        System.out.println("Maratón: " + kmMaraton + " km = " + millasCompletas + " millas completas");
        System.out.println("Altura: " + alturaCm + " cm = " + pulgadas + " pulgadas (redondeado)");
        System.out.println("Película: " + minutosPelicula + " min = " + horasDecimal + " horas (" + horasCompletas + " horas completas)");
        System.out.println("Temperatura: " + celsius + " ºC");
        System.out.println("  Con enteros:   " + fahrenheitEntero + " ºF");
        System.out.println("  Con decimales: " + fahrenheitDecimal + " ºF");
    }
}
