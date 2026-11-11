/*
 * TEMA 01 · Ejercicio 05 · Hucha con objetivo  (dificultad: 5/5)
 *
 * Objetivo: simular semana a semana una hucha hasta llegar al objetivo
 *           o hasta que se acaben las semanas.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej01_05_HuchaConObjetivo.java
 *
 * Regla: NO uses break. La condición del while decide cuándo parar.
 */
public class Ej01_05_HuchaConObjetivo {

    public static void main(String[] args) {

        // TODO 0: escribe el pseudocódigo aquí
        // INICIO
        //     ...
        // FIN

        // ------------------------------------------------------------
        // Datos del problema (ya hecho). Cambia "objetivo" para probar.
        // ------------------------------------------------------------
        int objetivo = 100;
        int maxSemanas = 12;
        int aportacionInicial = 10;
        int incrementoSemanal = 5;
        int capricho = 8;

        // TODO 1: crea e inicializa las variables que vas a necesitar:
        //         hucha, semana y aportacion.

        // TODO 2: escribe el bucle while. Debe seguir MIENTRAS queden
        //         semanas Y la hucha no haya llegado al objetivo.

            // TODO 3: dentro del bucle:
            //   a) mete la aportación de esta semana en la hucha
            //   b) si la semana es múltiplo de 4, saca el capricho
            //      (y muestra la línea con "capricho (-8)")
            //      si no, muestra la línea normal
            //   c) prepara la aportación de la semana siguiente (+5)
            //   d) pasa a la semana siguiente

        // TODO 4: fuera del bucle, decide qué mensaje mostrar:
        //   - si hucha >= objetivo  → "Objetivo cumplido en X semanas"
        //   - si no                 → "No has llegado. Te faltan Y euros"
    }
}
