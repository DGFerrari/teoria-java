/*
 * TEMA 10 · Métodos
 * Ejemplo 02: DEVOLVER VALORES (return) Y ÁMBITO DE LAS VARIABLES
 *
 * Cómo ejecutarlo:  java T10_02_ReturnYAmbito.java
 */
public class T10_02_ReturnYAmbito {

    // ------------------------------------------------------------
    // 1. Métodos que devuelven un valor: el tipo va antes del nombre
    // ------------------------------------------------------------

    /** Devuelve el área de un círculo. */
    static double areaCirculo(double radio) {
        double area = Math.PI * radio * radio;
        return area;                        // Entrega el valor y termina el método
    }

    /** Devuelve el mayor de dos números. */
    static int maximo(int a, int b) {
        return a > b ? a : b;               // Se puede devolver directamente una expresión
    }

    // ------------------------------------------------------------
    // 2. Métodos boolean: preguntas
    // ------------------------------------------------------------

    /** ¿Es par? */
    static boolean esPar(int n) {
        return n % 2 == 0;
    }

    /** ¿Es primo? Bucle con bandera y un único return al final (sin salir del bucle con return). */
    static boolean esPrimo(int n) {
        boolean primo = n > 1;
        int divisor = 2;
        while (divisor * divisor <= n && primo) {
            primo = n % divisor != 0;
            divisor++;
        }
        return primo;
    }

    // ------------------------------------------------------------
    // 3. Varios return en ramas de un if (todos los caminos deben devolver algo)
    // ------------------------------------------------------------

    /** Devuelve la calificación de una nota. */
    static String calificar(double nota) {
        if (nota < 0 || nota > 10) {
            return "Nota no válida";
        } else if (nota >= 9) {
            return "Sobresaliente";
        } else if (nota >= 7) {
            return "Notable";
        } else if (nota >= 5) {
            return "Aprobado";
        } else {
            return "Suspenso";
        }
        // Si quitas el último else → error: missing return statement
    }

    // ------------------------------------------------------------
    // 4. Ámbito: cada método tiene sus propias variables
    // ------------------------------------------------------------

    static int calcularDoble(int x) {
        int resultado = x * 2;              // "resultado" solo existe dentro de este método
        return resultado;
    }

    static int calcularTriple(int x) {
        int resultado = x * 3;              // Es OTRA variable, aunque se llame igual
        return resultado;
    }

    public static void main(String[] args) {

        // El valor devuelto se puede guardar...
        double area = areaCirculo(2);
        System.out.printf("Área de un círculo de radio 2: %.2f%n", area);

        // ...usar directamente...
        System.out.println("El mayor de 8 y 13 es " + maximo(8, 13));

        // ...o combinar en expresiones (incluso como argumento de otro método)
        System.out.println("El mayor de 4, 9 y 6 es " + maximo(maximo(4, 9), 6));
        System.out.printf("Área total de dos círculos (r=1 y r=3): %.2f%n", areaCirculo(1) + areaCirculo(3));
        System.out.println();

        // Los métodos boolean hacen que los if se lean como frases
        for (int n = 1; n <= 12; n++) {
            if (esPrimo(n)) {
                System.out.println(n + " es primo" + (esPar(n) ? " (y además es par)" : ""));
            }
        }
        System.out.println();

        double[] notas = {9.5, 7.2, 5.0, 3.8, 11};
        for (double nota : notas) {
            System.out.println(nota + " → " + calificar(nota));
        }
        System.out.println();

        // Ámbito
        int resultado = 100;                       // Variable del main
        System.out.println("Doble de 5: " + calcularDoble(5));
        System.out.println("Triple de 5: " + calcularTriple(5));
        System.out.println("La variable 'resultado' del main sigue valiendo " + resultado);

        // ⚠️ Llamar a un método que devuelve algo y no usar el valor no da error, pero no sirve de nada:
        areaCirculo(10);                            // Se calcula... y se pierde

        // PRUEBA: crea "static int sumarCifras(int n)" (con un while, / y %)
        //    y comprueba que sumarCifras(2025) devuelve 9.
    }
}
