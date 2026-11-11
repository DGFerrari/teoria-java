/*
 * TEMA 16 · Ejercicio 02 · Gestor de notas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol16_02_GestorDeNotas.java
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Sol16_02_GestorDeNotas {

    static double media(List<Double> notas) {
        double suma = 0;
        for (double nota : notas) {                 // unboxing automático: Double → double
            suma += nota;
        }
        double resultado = 0;
        if (!notas.isEmpty()) {
            resultado = suma / notas.size();
        }
        return resultado;
    }

    static double maxima(List<Double> notas) {
        double mayor = notas.get(0);
        for (double nota : notas) {
            if (nota > mayor) {
                mayor = nota;
            }
        }
        return mayor;
    }

    static int contarAprobados(List<Double> notas) {
        int aprobados = 0;
        for (double nota : notas) {
            if (nota >= 5) {
                aprobados++;
            }
        }
        return aprobados;
    }

    // Borrar mientras se recorre: con Iterator, nunca dentro de un for-each
    static void eliminarSuspensos(List<Double> notas) {
        Iterator<Double> it = notas.iterator();
        while (it.hasNext()) {
            if (it.next() < 5) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        double[] datos = {6.5, 4.0, 8.75, 3.5, 9.0, 5.0, 2.25, 7.0};

        List<Double> notas = new ArrayList<>();
        for (double dato : datos) {
            notas.add(dato);                        // autoboxing: double → Double
        }

        System.out.println("Notas: " + notas);
        System.out.printf("Media: %.2f%n", media(notas));
        System.out.println("Nota más alta: " + maxima(notas) + " (Collections.max: " + Collections.max(notas) + ")");
        System.out.println("Aprobados: " + contarAprobados(notas) + " de " + notas.size());

        eliminarSuspensos(notas);
        System.out.println("Tras eliminar suspensos: " + notas);
        System.out.printf("Nueva media: %.2f%n", media(notas));
    }
}
