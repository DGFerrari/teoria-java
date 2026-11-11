/*
 * TEMA 01 · Lógica de programación
 * Ejemplo 05: ALGORITMO COMPLETO (secuencia + decisión + repetición)
 *
 * Problema: mostrar los números del 1 al 10 indicando si cada uno es par o impar,
 * y al final decir cuántos pares ha habido.
 *
 * Pseudocódigo:
 *     INICIO
 *         pares ← 0
 *         numero ← 1
 *         MIENTRAS numero <= 10 HACER
 *             SI numero es par ENTONCES
 *                 ESCRIBIR numero, " es par"
 *                 pares ← pares + 1
 *             SINO
 *                 ESCRIBIR numero, " es impar"
 *             FIN SI
 *             numero ← numero + 1
 *         FIN MIENTRAS
 *         ESCRIBIR "Total de pares: ", pares
 *     FIN
 *
 * Cómo ejecutarlo:  java T01_05_AlgoritmoCompleto.java
 */
public class T01_05_AlgoritmoCompleto {

    public static void main(String[] args) {

        // SECUENCIA: preparamos las variables antes de empezar
        int pares = 0;     // Contador de números pares encontrados
        int numero = 1;    // Número que estamos revisando

        System.out.println("=== Números del 1 al 10 ===");

        // REPETICIÓN: revisamos los números uno a uno
        while (numero <= 10) {

            // DECISIÓN: ¿es par?
            // numero % 2 da el RESTO de dividir entre 2.
            // Si el resto es 0, el número es par. (El operador % se explica en el tema 04.)
            // == significa "es igual a" (comparación).
            if (numero % 2 == 0) {
                System.out.println(numero + " es par");
                pares = pares + 1;
            } else {
                System.out.println(numero + " es impar");
            }

            numero = numero + 1;   // Pasamos al siguiente número
        }

        // SECUENCIA: después del bucle, mostramos el resultado final
        System.out.println("Total de pares: " + pares);   // 5

        // PRUEBA:
        //  - Cambia el 10 por 20. ¿Cuántos pares hay ahora?
        //  - Añade otro contador "impares" y muéstralo al final.
    }
}
