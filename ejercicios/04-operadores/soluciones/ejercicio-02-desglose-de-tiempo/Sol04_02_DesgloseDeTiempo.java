/*
 * TEMA 04 · Ejercicio 02 · Desglose de tiempo  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol04_02_DesgloseDeTiempo.java
 */
public class Sol04_02_DesgloseDeTiempo {

    public static void main(String[] args) {

        final int SEGUNDOS_MINUTO = 60;
        final int SEGUNDOS_HORA = 60 * SEGUNDOS_MINUTO;
        final int SEGUNDOS_DIA = 24 * SEGUNDOS_HORA;

        int segundosTotales = 200000;

        // De la unidad más grande a la más pequeña:
        //   /  → cuántas unidades completas caben
        //   %  → cuántos segundos sobran para el paso siguiente
        int dias = segundosTotales / SEGUNDOS_DIA;
        int resto = segundosTotales % SEGUNDOS_DIA;

        int horas = resto / SEGUNDOS_HORA;
        resto %= SEGUNDOS_HORA;

        int minutos = resto / SEGUNDOS_MINUTO;
        int segundos = resto % SEGUNDOS_MINUTO;

        System.out.println(segundosTotales + " segundos = " + dias + " días, " + horas + " horas, "
                + minutos + " minutos y " + segundos + " segundos");
    }
}
