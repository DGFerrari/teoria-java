/*
 * TEMA 01 · Ejercicio 04 · Traza de un bucle  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol01_04_TrazaDeUnBucle.java
 */
public class Sol01_04_TrazaDeUnBucle {

    public static void main(String[] args) {

        //   Vuelta | total después | valor después
        //   -------+---------------+--------------
        //     1    |       1       |      2
        //     2    |       3       |      4
        //     3    |       7       |      8
        //     4    |      15       |     16
        //     5    |      31       |     32
        //
        //   Calcula la suma de las 5 primeras potencias de 2 (1+2+4+8+16 = 31).

        int valor = 1;
        int total = 0;
        int vuelta = 1;

        while (vuelta <= 5) {
            total = total + valor;     // Acumulamos con el valor actual
            valor = valor * 2;         // Siguiente potencia de 2
            System.out.println("Vuelta " + vuelta + " -> total = " + total + ", valor = " + valor);
            vuelta = vuelta + 1;       // Hace que el bucle termine tras 5 vueltas
        }

        System.out.println("Resultado final: total = " + total + ", valor = " + valor);
    }
}
