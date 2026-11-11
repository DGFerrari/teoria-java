/*
 * TEMA 10 · Ejercicio 04 · Laboratorio de recursividad  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol10_04_LaboratorioDeRecursividad.java
 */
public class Sol10_04_LaboratorioDeRecursividad {

    static int superadas = 0;
    static int total = 0;

    static void comprobar(String descripcion, Object obtenido, Object esperado) {
        total++;
        boolean correcto = obtenido.equals(esperado);
        if (correcto) {
            superadas++;
        }
        System.out.println((correcto ? "✅ " : "❌ ") + descripcion + " = " + obtenido
                + (correcto ? "" : "   (se esperaba " + esperado + ")"));
    }

    public static void main(String[] args) {
        comprobar("factorial(0)", factorial(0), 1L);
        comprobar("factorial(6)", factorial(6), 720L);
        comprobar("potencia(3, 4)", potencia(3, 4), 81L);
        comprobar("potencia(5, 0)", potencia(5, 0), 1L);
        comprobar("sumarCifras(2025)", sumarCifras(2025), 9);
        comprobar("contarCifras(98765)", contarCifras(98765), 5);
        comprobar("contarCifras(7)", contarCifras(7), 1);
        comprobar("mcd(48, 18)", mcd(48, 18), 6);
        comprobar("mcd(17, 5)", mcd(17, 5), 1);
        comprobar("invertir(\"recursivo\")", invertir("recursivo"), "ovisrucer");
        comprobar("esPalindromo(\"reconocer\")", esPalindromo("reconocer"), true);
        comprobar("esPalindromo(\"java\")", esPalindromo("java"), false);
        comprobar("sumarDesde({3, 1, 4, 1, 5}, 0)", sumarDesde(new int[]{3, 1, 4, 1, 5}, 0), 14);
        System.out.println("Superadas: " + superadas + " de " + total);
    }

    static long factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    static long potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }

    static int sumarCifras(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + sumarCifras(n / 10);        // Última cifra + suma del resto
        }
    }

    static int contarCifras(int n) {
        if (n < 10) {
            return 1;
        } else {
            return 1 + contarCifras(n / 10);            // Una cifra + las del resto
        }
    }

    static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return mcd(b, a % b);                       // Algoritmo de Euclides
        }
    }

    static String invertir(String texto) {
        if (texto.length() <= 1) {
            return texto;
        } else {
            // char + String → String (si fueran dos char, se sumarían como números)
            return texto.charAt(texto.length() - 1) + invertir(texto.substring(0, texto.length() - 1));
        }
    }

    static boolean esPalindromo(String texto) {
        if (texto.length() <= 1) {
            return true;
        } else if (texto.charAt(0) != texto.charAt(texto.length() - 1)) {
            return false;
        } else {
            return esPalindromo(texto.substring(1, texto.length() - 1));   // Sin los extremos
        }
    }

    static int sumarDesde(int[] datos, int indice) {
        if (indice == datos.length) {
            return 0;                                   // No quedan elementos
        } else {
            return datos[indice] + sumarDesde(datos, indice + 1);
        }
    }
}
