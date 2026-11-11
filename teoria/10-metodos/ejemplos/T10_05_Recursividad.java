/*
 * TEMA 10 · Métodos
 * Ejemplo 05: RECURSIVIDAD (métodos que se llaman a sí mismos)
 *
 * Cómo ejecutarlo:  java T10_05_Recursividad.java
 */
public class T10_05_Recursividad {

    /** n! = n * (n-1)!  con 0! = 1! = 1 */
    static long factorial(int n) {
        if (n <= 1) {
            return 1;                          // CASO BASE
        } else {
            return n * factorial(n - 1);       // CASO RECURSIVO (más pequeño: n - 1)
        }
    }

    /** Igual que factorial, pero mostrando la pila de llamadas. */
    static long factorialConTraza(int n, int nivel) {
        String sangria = "  ".repeat(nivel);
        System.out.println(sangria + "→ factorial(" + n + ")");
        long resultado;
        if (n <= 1) {
            resultado = 1;
        } else {
            resultado = n * factorialConTraza(n - 1, nivel + 1);
        }
        System.out.println(sangria + "← factorial(" + n + ") = " + resultado);
        return resultado;
    }

    /** base^exponente = base * base^(exponente-1), con base^0 = 1 */
    static long potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }

    /** Suma de cifras: la última cifra + la suma de las cifras del resto. */
    static int sumarCifras(int n) {
        if (n < 10) {
            return n;                          // Un solo dígito
        } else {
            return n % 10 + sumarCifras(n / 10);
        }
    }

    /** Invertir un texto: el último carácter + el resto invertido. */
    static String invertir(String texto) {
        if (texto.length() <= 1) {
            return texto;
        } else {
            return texto.charAt(texto.length() - 1) + invertir(texto.substring(0, texto.length() - 1));
        }
    }

    /** Fibonacci: cada número es la suma de los dos anteriores (0, 1, 1, 2, 3, 5, 8...). */
    static long fibonacci(int n) {
        if (n <= 1) {
            return n;                          // fib(0) = 0, fib(1) = 1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);   // Dos llamadas recursivas
        }
    }

    /** Lo mismo con un bucle: mucho más rápido para n grandes. */
    static long fibonacciIterativo(int n) {
        long anterior = 0;
        long actual = 1;
        for (int i = 0; i < n; i++) {
            long siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
        }
        return anterior;
    }

    public static void main(String[] args) {

        System.out.println("5! = " + factorial(5));            // 120
        System.out.println("10! = " + factorial(10));          // 3628800
        System.out.println();

        System.out.println("Pila de llamadas de factorial(4):");
        factorialConTraza(4, 0);
        System.out.println();

        System.out.println("2^10 = " + potencia(2, 10));                 // 1024
        System.out.println("Suma de cifras de 98765 = " + sumarCifras(98765));   // 35
        System.out.println("\"recursivo\" al revés = " + invertir("recursivo"));
        System.out.println();

        System.out.print("Fibonacci recursivo: ");
        for (int i = 0; i <= 15; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        // fibonacci(n) recursivo repite muchísimos cálculos: con n = 45 tarda varios segundos.
        // La versión con bucle es instantánea.
        System.out.println("Fibonacci(80) con bucle = " + fibonacciIterativo(80));

        // ⚠️ Sin caso base, la recursividad no termina:
        //   static int infinito(int n) { return infinito(n - 1); }
        //   → java.lang.StackOverflowError

        // PRUEBA: escribe "contarCifras(int n)" recursivo (caso base: n < 10 → 1 cifra).
    }
}
