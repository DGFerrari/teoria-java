/*
 * TEMA 03 · Ejercicio 03 · Conversor de unidades  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol03_03_ConversorDeUnidades.java
 */
public class Sol03_03_ConversorDeUnidades {

    public static void main(String[] args) {

        // Constantes de conversión
        final double KM_A_MILLAS = 0.621371;
        final double CM_POR_PULGADA = 2.54;
        final int MINUTOS_POR_HORA = 60;

        // Datos de entrada
        double kmMaraton = 42.195;
        int alturaCm = 180;
        int minutosPelicula = 135;
        int celsius = 38;

        // Cortar decimales: casting a int (paréntesis para convertir el RESULTADO)
        int millasCompletas = (int) (kmMaraton * KM_A_MILLAS);

        // Redondear: Math.round devuelve long
        long pulgadas = Math.round(alturaCm / CM_POR_PULGADA);

        // División decimal (convertimos antes de dividir) y división entera
        double horasDecimal = (double) minutosPelicula / MINUTOS_POR_HORA;
        int horasCompletas = minutosPelicula / MINUTOS_POR_HORA;

        // La misma fórmula: con enteros pierde los decimales sin avisar
        int fahrenheitEntero = celsius * 9 / 5 + 32;
        double fahrenheitDecimal = celsius * 9 / 5.0 + 32;

        System.out.println("Maratón: " + kmMaraton + " km = " + millasCompletas + " millas completas");
        System.out.println("Altura: " + alturaCm + " cm = " + pulgadas + " pulgadas (redondeado)");
        System.out.println("Película: " + minutosPelicula + " min = " + horasDecimal + " horas (" + horasCompletas + " horas completas)");
        System.out.println("Temperatura: " + celsius + " ºC");
        System.out.println("  Con enteros:   " + fahrenheitEntero + " ºF");
        System.out.println("  Con decimales: " + fahrenheitDecimal + " ºF");
    }
}
