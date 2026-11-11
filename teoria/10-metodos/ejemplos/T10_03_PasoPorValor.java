/*
 * TEMA 10 · Métodos
 * Ejemplo 03: PASO POR VALOR (primitivos frente a arrays)
 *
 * Cómo ejecutarlo:  java T10_03_PasoPorValor.java
 */
import java.util.Arrays;

public class T10_03_PasoPorValor {

    // ------------------------------------------------------------
    // 1. Con un primitivo, el método recibe una COPIA del valor
    // ------------------------------------------------------------
    static void intentarDuplicar(int n) {
        n = n * 2;                                   // Cambia la copia, no el original
        System.out.println("  Dentro del método, n = " + n);
    }

    // Si queremos el resultado, lo DEVOLVEMOS
    static int duplicar(int n) {
        return n * 2;
    }

    // ------------------------------------------------------------
    // 2. Con un array, se copia la REFERENCIA: el método ve el MISMO array
    // ------------------------------------------------------------
    /** MODIFICA el array que recibe: multiplica cada elemento por 2. */
    static void duplicarElementos(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = datos[i] * 2;                 // Cambia el array ORIGINAL
        }
    }

    /** NO modifica el array que recibe: crea y devuelve uno nuevo. */
    static int[] copiaDuplicada(int[] datos) {
        int[] nuevo = new int[datos.length];
        for (int i = 0; i < datos.length; i++) {
            nuevo[i] = datos[i] * 2;
        }
        return nuevo;
    }

    // ------------------------------------------------------------
    // 3. Reasignar el parámetro no afecta al original
    // ------------------------------------------------------------
    static void reasignar(int[] datos) {
        datos = new int[]{-1, -1, -1};               // El parámetro apunta ahora a OTRO array...
        System.out.println("  Dentro del método: " + Arrays.toString(datos));
    }                                                // ...pero la variable del main no se entera

    // ------------------------------------------------------------
    // 4. Un String tampoco cambia: es inmutable
    // ------------------------------------------------------------
    static void intentarCambiar(String texto) {
        texto = texto.toUpperCase();                 // Crea un String nuevo y lo asigna a la copia
    }

    public static void main(String[] args) {

        System.out.println("=== 1. Primitivos ===");
        int numero = 5;
        intentarDuplicar(numero);
        System.out.println("  En el main, numero = " + numero + "   ← no ha cambiado");
        numero = duplicar(numero);
        System.out.println("  Con return: numero = " + numero);
        System.out.println();

        System.out.println("=== 2. Arrays ===");
        int[] valores = {1, 2, 3};
        int[] otra = copiaDuplicada(valores);
        System.out.println("  copiaDuplicada → original: " + Arrays.toString(valores) + " | nueva: " + Arrays.toString(otra));

        duplicarElementos(valores);
        System.out.println("  duplicarElementos → original: " + Arrays.toString(valores) + "   ← ¡SÍ ha cambiado!");
        System.out.println();

        System.out.println("=== 3. Reasignar el parámetro ===");
        reasignar(valores);
        System.out.println("  En el main: " + Arrays.toString(valores) + "   ← no ha cambiado");
        System.out.println();

        System.out.println("=== 4. String ===");
        String nombre = "ana";
        intentarCambiar(nombre);
        System.out.println("  nombre sigue siendo: " + nombre);

        // Conclusión: para "sacar" un resultado de un método, lo normal es DEVOLVERLO con return.
        // Modificar un array recibido es útil (p. ej. Arrays.sort lo hace), pero debe quedar claro
        // en el nombre y la documentación del método.
    }
}
