/*
 * TEMA 12 · Encapsulamiento
 * Ejemplo 05: MÉTODOS PRIVADOS Y COPIAS DEFENSIVAS
 *
 * Cómo ejecutarlo:  java T12_05_CopiasDefensivas.java
 */
import java.util.Arrays;

public class T12_05_CopiasDefensivas {

    // Versión con una "fuga": el getter entrega el array interno
    static class BoletinConFuga {
        private final double[] notas;

        public BoletinConFuga(double[] notas) {
            this.notas = notas;                       // ⚠️ Guarda la MISMA referencia que le pasan
        }

        public double[] getNotas() {
            return notas;                             // ⚠️ Entrega la referencia interna
        }
    }

    // Versión protegida
    static class Boletin {
        private final String alumno;
        private final double[] notas;

        public Boletin(String alumno, double[] notas) {
            this.alumno = alumno;
            this.notas = Arrays.copyOf(notas, notas.length);   // ✅ Copia al recibir
            corregirNotasFueraDeRango();
        }

        public double[] getNotas() {
            return Arrays.copyOf(notas, notas.length);         // ✅ Copia al entregar
        }

        // Si hace falta consultar algo concreto, mejor un método específico
        public double getNota(int posicion) {
            return notas[posicion];
        }

        public double getMedia() {
            return calcularMedia();
        }

        public String getCalificacion() {
            return calificar(calcularMedia());
        }

        // --- Métodos privados de ayuda: detalles internos ---
        private double calcularMedia() {
            double suma = 0;
            for (double nota : notas) {
                suma += nota;
            }
            return notas.length == 0 ? 0 : suma / notas.length;
        }

        private static String calificar(double media) {
            if (media >= 9) {
                return "Sobresaliente";
            } else if (media >= 7) {
                return "Notable";
            } else if (media >= 5) {
                return "Aprobado";
            } else {
                return "Suspenso";
            }
        }

        private void corregirNotasFueraDeRango() {
            for (int i = 0; i < notas.length; i++) {
                notas[i] = Math.max(0, Math.min(10, notas[i]));   // Recorta al rango 0-10
            }
        }

        @Override
        public String toString() {
            return String.format("%s: %s → media %.2f (%s)", alumno, Arrays.toString(notas), getMedia(), getCalificacion());
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. La fuga: se modifica el estado "privado" desde fuera
        // ------------------------------------------------------------
        double[] misNotas = {7, 8, 9};
        BoletinConFuga conFuga = new BoletinConFuga(misNotas);

        misNotas[0] = 0;                              // Modifico MI array...
        conFuga.getNotas()[1] = -100;                 // ...y el que me devuelve el getter
        System.out.println("Con fuga: " + Arrays.toString(conFuga.getNotas()));   // [0.0, -100.0, 9.0] 😱
        System.out.println();

        // ------------------------------------------------------------
        // 2. Con copias defensivas, el objeto no se deja modificar
        // ------------------------------------------------------------
        double[] notasLuis = {6.5, 12, 4};            // El 12 se corregirá a 10
        Boletin luis = new Boletin("Luis", notasLuis);

        notasLuis[0] = 0;                             // No afecta al boletín
        luis.getNotas()[1] = -100;                    // Modifica una copia que se tira
        System.out.println("Protegido: " + luis);
        System.out.println("Segunda nota: " + luis.getNota(1));

        // luis.calcularMedia();   // Desde otra clase no sería accesible (private)

        // PRUEBA: añade un método público "boolean mejorarNota(int posicion, double nueva)"
        //    que solo acepte la nueva nota si es mayor que la actual y está entre 0 y 10.
    }
}
