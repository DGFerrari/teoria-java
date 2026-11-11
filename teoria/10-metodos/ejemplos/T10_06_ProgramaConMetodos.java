/*
 * TEMA 10 · Métodos
 * Ejemplo 06: UN PROGRAMA COMPLETO DIVIDIDO EN MÉTODOS
 *
 * Analiza las notas de una clase. Fíjate en que el main se lee casi como un índice:
 * cada tarea está en su propio método, con un nombre que explica lo que hace.
 *
 * Cómo ejecutarlo:  java T10_06_ProgramaConMetodos.java
 */
public class T10_06_ProgramaConMetodos {

    public static void main(String[] args) {

        String[] alumnos = {"ana garcía", "LUIS martín", "marta ruiz", "jorge PÉREZ", "lucía sanz"};
        double[] notas = {7.5, 4.25, 9.75, 5.0, 6.5};

        mostrarTitulo("INFORME DE NOTAS");
        mostrarTabla(alumnos, notas);

        double media = calcularMedia(notas);
        int posMejor = posicionDelMaximo(notas);

        mostrarTitulo("RESUMEN");
        System.out.printf("Media de la clase: %.2f%n", media);
        System.out.println("Aprobados: " + contarAprobados(notas) + " de " + notas.length);
        System.out.printf("Mejor nota: %s (%.2f)%n", capitalizarNombre(alumnos[posMejor]), notas[posMejor]);
        System.out.println("¿Alguien con un 10? " + (contiene(notas, 10) ? "Sí" : "No"));
    }

    // ============================================================
    // Métodos de presentación (void: muestran por pantalla)
    // ============================================================

    /** Muestra un título enmarcado. */
    static void mostrarTitulo(String titulo) {
        String linea = "=".repeat(titulo.length() + 4);
        System.out.println(linea);
        System.out.println("  " + titulo);
        System.out.println(linea);
    }

    /** Muestra una fila por alumno con su nota y su calificación. */
    static void mostrarTabla(String[] alumnos, double[] notas) {
        for (int i = 0; i < alumnos.length; i++) {
            System.out.printf("%-15s %6.2f  %s%n", capitalizarNombre(alumnos[i]), notas[i], calificar(notas[i]));
        }
    }

    // ============================================================
    // Métodos de cálculo (devuelven un resultado, no muestran nada)
    // ============================================================

    /** Media de un array de notas. */
    static double calcularMedia(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    /** Posición de la nota más alta. */
    static int posicionDelMaximo(double[] notas) {
        int posicion = 0;
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > notas[posicion]) {
                posicion = i;
            }
        }
        return posicion;
    }

    /** Número de notas mayores o iguales que 5. */
    static int contarAprobados(double[] notas) {
        int aprobados = 0;
        for (double nota : notas) {
            if (nota >= 5) {
                aprobados++;
            }
        }
        return aprobados;
    }

    /** ¿Aparece el valor en el array? Bandera en la condición y un único return. */
    static boolean contiene(double[] datos, double valor) {
        boolean encontrado = false;
        int i = 0;
        while (i < datos.length && !encontrado) {
            encontrado = datos[i] == valor;
            i++;
        }
        return encontrado;
    }

    /** Calificación de una nota. */
    static String calificar(double nota) {
        if (nota >= 9) {
            return "Sobresaliente";
        } else if (nota >= 7) {
            return "Notable";
        } else if (nota >= 5) {
            return "Aprobado";
        } else {
            return "Suspenso";
        }
    }

    // ============================================================
    // Métodos de texto (reutilizables en cualquier programa)
    // ============================================================

    /** "mARTA" → "Marta" */
    static String capitalizar(String palabra) {
        if (palabra.isEmpty()) {
            return palabra;
        } else {
            return palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
        }
    }

    /** "ana GARCÍA" → "Ana García" (usa capitalizar para cada palabra) */
    static String capitalizarNombre(String nombreCompleto) {
        String[] palabras = nombreCompleto.strip().split(" +");
        StringBuilder resultado = new StringBuilder();
        for (String palabra : palabras) {
            if (resultado.length() > 0) {
                resultado.append(" ");
            }
            resultado.append(capitalizar(palabra));
        }
        return resultado.toString();
    }
}
