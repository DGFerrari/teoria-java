/*
 * TEMA 10 · Ejercicio 03 · Métodos con arrays  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol10_03_MetodosConArrays.java
 */
import java.util.Random;

public class Sol10_03_MetodosConArrays {

    public static void main(String[] args) {
        Random random = new Random(42);
        int[] datos = new int[10];

        rellenarAleatorio(datos, random, 0, 80);
        mostrar(datos, "Datos");

        System.out.printf("Media: %.2f%n", media(datos));
        int pos = posicionDelMaximo(datos);
        System.out.println("Máximo: " + datos[pos] + " (posición " + pos + ")");
        System.out.println("Mayores que 50: " + contarMayoresQue(datos, 50));

        int[] pares = filtrarPares(datos);
        mostrar(pares, "Pares");
        mostrar(datos, "Datos (sin cambios)");
    }

    /** MODIFICA el array: cada posición recibe un aleatorio entre min y max (incluidos). */
    static void rellenarAleatorio(int[] datos, Random random, int min, int max) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = random.nextInt(min, max + 1);   // Mismo array que el del main
        }
    }

    /** Muestra el array con el formato [a, b, c] y salta de línea. */
    static void mostrar(int[] datos) {
        StringBuilder texto = new StringBuilder("[");
        for (int i = 0; i < datos.length; i++) {
            if (i > 0) {
                texto.append(", ");
            }
            texto.append(datos[i]);
        }
        texto.append("]");
        System.out.println(texto);
    }

    /** Sobrecarga: muestra "titulo: [a, b, c]". Reutiliza mostrar(datos). */
    static void mostrar(int[] datos, String titulo) {
        System.out.print(titulo + ": ");
        mostrar(datos);
    }

    /** Devuelve la media de los elementos. */
    static double media(int[] datos) {
        int suma = 0;
        for (int dato : datos) {
            suma += dato;
        }
        return (double) suma / datos.length;
    }

    /** Devuelve la posición del elemento más grande. */
    static int posicionDelMaximo(int[] datos) {
        int posicion = 0;
        for (int i = 1; i < datos.length; i++) {
            if (datos[i] > datos[posicion]) {
                posicion = i;
            }
        }
        return posicion;
    }

    /** Devuelve cuántos elementos son mayores que el límite. */
    static int contarMayoresQue(int[] datos, int limite) {
        int cantidad = 0;
        for (int dato : datos) {
            if (dato > limite) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /** Devuelve un array NUEVO con los elementos pares. No modifica el original. */
    static int[] filtrarPares(int[] datos) {
        // 1º recorrido: contar, para saber el tamaño del nuevo array
        int cantidad = 0;
        for (int dato : datos) {
            if (dato % 2 == 0) {
                cantidad++;
            }
        }
        // 2º recorrido: copiar, con un índice propio para el nuevo array
        int[] pares = new int[cantidad];
        int siguiente = 0;
        for (int dato : datos) {
            if (dato % 2 == 0) {
                pares[siguiente] = dato;
                siguiente++;
            }
        }
        return pares;
    }
}
