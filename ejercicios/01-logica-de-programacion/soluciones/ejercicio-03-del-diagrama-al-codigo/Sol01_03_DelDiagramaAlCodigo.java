/*
 * TEMA 01 · Ejercicio 03 · Del diagrama al código  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol01_03_DelDiagramaAlCodigo.java
 */
public class Sol01_03_DelDiagramaAlCodigo {

    public static void main(String[] args) {

        // INICIO
        //     LEER edad, esFestivo
        //     SI edad < 12 ENTONCES precio ← 3
        //     SINO SI edad >= 65 ENTONCES precio ← 2
        //     SINO precio ← 5
        //     SI esFestivo ENTONCES precio ← precio + 1
        //     ESCRIBIR precio
        // FIN

        // ENTRADA
        int edad = 30;
        boolean esFestivo = true;

        int precio = 0;

        // PROCESO · Decisión 1: precio base según la edad
        if (edad < 12) {
            precio = 3;            // Niños
        } else if (edad >= 65) {
            precio = 2;            // Jubilados
        } else {
            precio = 5;            // Resto (de 12 a 64 años)
        }

        // PROCESO · Decisión 2: recargo de festivo (se comprueba SIEMPRE)
        if (esFestivo) {
            precio = precio + 1;
        }

        // SALIDA
        System.out.println("Edad: " + edad + " | Festivo: " + esFestivo);
        System.out.println("Precio de la entrada: " + precio + " euros");
    }
}
