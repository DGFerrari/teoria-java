/*
 * TEMA 01 · Lógica de programación
 * Ejemplo 02: VARIABLES (cajas con nombre)
 *
 * Una variable es una caja con una etiqueta (su nombre) que guarda un valor.
 * El valor puede cambiar durante el programa, pero solo hay UNO a la vez.
 *
 * Cómo ejecutarlo:  java T01_02_Variables.java
 */
public class T01_02_Variables {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Crear cajas y meter valores
        // ------------------------------------------------------------
        // Pseudocódigo:  edad ← 15
        // En Java hay que decir qué TIPO de dato guarda la caja:
        //   int    → números enteros (sin decimales)
        //   double → números con decimales
        //   String → texto (siempre entre comillas dobles)

        int edad = 15;
        double altura = 1.68;
        String nombre = "Ana";

        // Con el signo + unimos texto y valores para mostrarlos juntos
        System.out.println("Nombre: " + nombre);   // Nombre: Ana
        System.out.println("Edad: " + edad);       // Edad: 15
        System.out.println("Altura: " + altura);   // Altura: 1.68

        System.out.println();

        // ------------------------------------------------------------
        // 2. Cambiar el valor de una caja
        // ------------------------------------------------------------
        // Pseudocódigo:  edad ← edad + 1
        // Se lee de DERECHA a IZQUIERDA:
        //   1) Se calcula edad + 1  → 15 + 1 = 16
        //   2) El resultado se guarda en la caja edad (el 15 desaparece)

        edad = edad + 1;
        System.out.println("Ha pasado un año. Edad: " + edad);   // Edad: 16

        edad = edad + 1;
        System.out.println("Ha pasado otro año. Edad: " + edad); // Edad: 17

        System.out.println();

        // ------------------------------------------------------------
        // 3. Usar variables para calcular (entrada → proceso → salida)
        // ------------------------------------------------------------
        // ENTRADA: los datos (aquí los escribimos directamente en el código)
        int base = 8;
        int alturaRectangulo = 5;

        // PROCESO: el cálculo (* significa multiplicar)
        int area = base * alturaRectangulo;

        // SALIDA: el resultado
        System.out.println("Rectángulo de " + base + " x " + alturaRectangulo);
        System.out.println("Área: " + area);   // Área: 40

        // PRUEBA: cambia los valores de base y alturaRectangulo y vuelve a ejecutar.
    }
}
