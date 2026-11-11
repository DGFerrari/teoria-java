/*
 * TEMA 01 · Ejercicio 03 · Del diagrama al código  (dificultad: 3/5)
 *
 * Objetivo: traducir a Java el diagrama de flujo del precio de la piscina.
 *
 * Lee el ENUNCIADO.md antes de empezar (ahí está el diagrama).
 * Cómo ejecutarlo:  java Ej01_03_DelDiagramaAlCodigo.java
 */
public class Ej01_03_DelDiagramaAlCodigo {

    public static void main(String[] args) {

        // TODO 0: escribe aquí el pseudocódigo del diagrama
        // INICIO
        //     ...
        // FIN

        // ------------------------------------------------------------
        // ENTRADA (ya hecho). Cambia estos valores para probar cada caso.
        // ------------------------------------------------------------
        int edad = 30;
        boolean esFestivo = true;   // boolean: solo puede valer true (sí) o false (no)

        // La variable donde guardaremos el precio. Empieza en 0.
        int precio = 0;

        // ------------------------------------------------------------
        // PROCESO
        // ------------------------------------------------------------
        // TODO 1: primera decisión. Según la edad, guarda en "precio"
        //         el precio base (3, 2 o 5). Usa if / else if / else.

        // TODO 2: segunda decisión. Si es festivo, suma 1 al precio.

        // ------------------------------------------------------------
        // SALIDA (ya hecho)
        // ------------------------------------------------------------
        System.out.println("Edad: " + edad + " | Festivo: " + esFestivo);
        System.out.println("Precio de la entrada: " + precio + " euros");
    }
}
