/*
 * TEMA 08 · Ejercicio 02 · Estadísticas de notas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol08_02_EstadisticasDeNotas.java
 */
import java.util.Scanner;

public class Sol08_02_EstadisticasDeNotas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántos alumnos hay? ");
        int cantidad = teclado.nextInt();

        // 1. El tamaño del array lo decide el usuario
        double[] notas = new double[cantidad];

        // 2. Rellenar (el usuario ve los alumnos desde 1)
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota del alumno " + (i + 1) + ": ");
            notas[i] = teclado.nextDouble();
        }

        // 3. Estadísticas: guardamos las POSICIONES del máximo y del mínimo
        double suma = 0;
        int posMaxima = 0;
        int posMinima = 0;
        int aprobados = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
            if (notas[i] > notas[posMaxima]) {
                posMaxima = i;
            }
            if (notas[i] < notas[posMinima]) {
                posMinima = i;
            }
            if (notas[i] >= 5) {
                aprobados++;
            }
        }
        double media = suma / notas.length;

        // 4. Resultados
        System.out.println();
        System.out.printf("Media: %.2f%n", media);
        System.out.printf("Nota más alta: %.2f (alumno %d)%n", notas[posMaxima], posMaxima + 1);
        System.out.printf("Nota más baja: %.2f (alumno %d)%n", notas[posMinima], posMinima + 1);
        System.out.println("Aprobados: " + aprobados + " de " + notas.length);

        // 5. Segundo recorrido: ahora sí conocemos la media
        System.out.print("Por encima de la media:");
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > media) {
                System.out.printf(" alumno %d (%.2f)", i + 1, notas[i]);
            }
        }
        System.out.println();

        teclado.close();
    }
}
