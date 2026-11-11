/*
 * TEMA 01 · Ejercicio 05 · Hucha con objetivo  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol01_05_HuchaConObjetivo.java
 */
public class Sol01_05_HuchaConObjetivo {

    public static void main(String[] args) {

        // Datos del problema
        int objetivo = 100;
        int maxSemanas = 12;
        int aportacionInicial = 10;
        int incrementoSemanal = 5;
        int capricho = 8;

        // Variables de trabajo
        int hucha = 0;                       // Acumulador
        int semana = 1;                      // Contador
        int aportacion = aportacionInicial;  // Lo que meto esta semana

        // Dos formas de terminar, las dos en la condición (sin break):
        //   - se acaban las semanas      → semana <= maxSemanas pasa a ser falso
        //   - llego al objetivo          → hucha < objetivo pasa a ser falso
        while (semana <= maxSemanas && hucha < objetivo) {

            hucha = hucha + aportacion;

            if (semana % 4 == 0) {
                // Semanas 4, 8, 12: capricho
                hucha = hucha - capricho;
                System.out.println("Semana " + semana + ": meto " + aportacion
                        + " -> capricho (-" + capricho + ") -> hucha = " + hucha);
            } else {
                System.out.println("Semana " + semana + ": meto " + aportacion + " -> hucha = " + hucha);
            }

            aportacion = aportacion + incrementoSemanal;   // La semana que viene, 5 más
            semana = semana + 1;
        }

        // Al salir, "semana" vale una más que la última semana ahorrada
        if (hucha >= objetivo) {
            System.out.println("Objetivo cumplido en " + (semana - 1) + " semanas");
        } else {
            System.out.println("No has llegado. Te faltan " + (objetivo - hucha) + " euros");
        }
    }
}
