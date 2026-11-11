/*
 * TEMA 04 · Ejercicio 02 · Desglose de tiempo  (dificultad: 2/5)
 *
 * Objetivo: convertir segundos en días, horas, minutos y segundos con / y %.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej04_02_DesgloseDeTiempo.java
 */
public class Ej04_02_DesgloseDeTiempo {

    public static void main(String[] args) {

        // Ya hecho: constantes
        final int SEGUNDOS_MINUTO = 60;
        final int SEGUNDOS_HORA = 60 * SEGUNDOS_MINUTO;   // 3600
        final int SEGUNDOS_DIA = 24 * SEGUNDOS_HORA;      // 86400

        // Cambia este valor para probar otros casos
        int segundosTotales = 200000;

        // Ya hecho: las variables del resultado (tienes que darles su valor)
        int dias = 0;
        int horas = 0;
        int minutos = 0;
        int segundos = 0;

        // TODO 1: calcula los días y guarda en una variable "resto"
        //         los segundos que sobran.

        // TODO 2: con el resto, calcula las horas y actualiza el resto.

        // TODO 3: con el resto, calcula los minutos y los segundos finales.

        // Ya hecho: salida
        System.out.println(segundosTotales + " segundos = " + dias + " días, " + horas + " horas, "
                + minutos + " minutos y " + segundos + " segundos");
    }
}
