/*
 * TEMA 10 · Ejercicio 04 · Laboratorio de recursividad  (dificultad: 4/5)
 *
 * Objetivo: escribir ocho métodos RECURSIVOS (sin bucles).
 * El main los prueba automáticamente: ✅ = correcto, ❌ = incorrecto.
 *
 * Lee el ENUNCIADO.md antes de empezar (ahí está la definición de cada uno).
 * Cómo ejecutarlo:  java Ej10_04_LaboratorioDeRecursividad.java
 */
public class Ej10_04_LaboratorioDeRecursividad {

    // NO TOCAR: contador de pruebas superadas y método de comprobación.
    // (Las variables "static" fuera de los métodos y el tipo Object, que acepta
    //  cualquier valor, los entenderás en los temas 12 y 13. Aquí solo se usan.)
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

    // NO TOCAR: las pruebas
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

    // ============================================================
    // TODO: escribe cada método de forma RECURSIVA (sin bucles)
    // ============================================================

    static long factorial(int n) {
        return 0;
    }

    static long potencia(int base, int exponente) {
        return 0;
    }

    static int sumarCifras(int n) {
        return 0;
    }

    static int contarCifras(int n) {
        return 0;
    }

    static int mcd(int a, int b) {
        return 0;
    }

    static String invertir(String texto) {
        return "";
    }

    static boolean esPalindromo(String texto) {
        return false;
    }

    static int sumarDesde(int[] datos, int indice) {
        return 0;
    }
}
