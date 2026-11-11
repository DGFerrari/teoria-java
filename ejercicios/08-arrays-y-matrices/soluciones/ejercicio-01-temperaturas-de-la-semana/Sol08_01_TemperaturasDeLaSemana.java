/*
 * TEMA 08 · Ejercicio 01 · Temperaturas de la semana  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol08_01_TemperaturasDeLaSemana.java
 */
public class Sol08_01_TemperaturasDeLaSemana {

    public static void main(String[] args) {

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        double[] temperaturas = {14.5, 16.0, 13.2, 18.7, 21.3, 22.8, 19.4};

        // Arrays paralelos: necesitamos el índice → for clásico
        for (int i = 0; i < dias.length; i++) {
            System.out.printf("%s: %.1f ºC%n", dias[i], temperaturas[i]);
        }

        // Solo los valores → for-each
        double suma = 0;
        for (double t : temperaturas) {
            suma += t;
        }
        double media = suma / temperaturas.length;

        System.out.printf("Media de la semana: %.1f ºC%n", media);
        System.out.printf("Primer día: %.1f ºC | Último día: %.1f ºC%n",
                temperaturas[0], temperaturas[temperaturas.length - 1]);
    }
}
