/*
 * TEMA 01 · Ejercicio 02 · Entradas de cine  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol01_02_EntradasDeCine.java
 */
public class Sol01_02_EntradasDeCine {

    public static void main(String[] args) {

        //   ENTRADA: número de entradas, precio de la entrada, precio de las palomitas
        //   PROCESO: totalEntradas = entradas * precio ; totalGastado = totalEntradas + palomitas
        //   SALIDA:  total de entradas, palomitas y total gastado

        // ENTRADA
        int numeroEntradas = 3;
        double precioEntrada = 7.5;
        double precioPalomitas = 6.0;

        // PROCESO (el orden importa: totalGastado necesita totalEntradas)
        double totalEntradas = numeroEntradas * precioEntrada;     // 22.5
        double totalGastado = totalEntradas + precioPalomitas;      // 28.5

        // SALIDA
        System.out.println("Entradas: " + numeroEntradas + " x " + precioEntrada + " = " + totalEntradas + " euros");
        System.out.println("Palomitas: " + precioPalomitas + " euros");
        System.out.println("Total gastado: " + totalGastado + " euros");
    }
}
