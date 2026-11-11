/*
 * TEMA 07 · Bucles
 * Ejemplo 03: for
 *
 * Cómo ejecutarlo:  java T07_03_For.java
 */
public class T07_03_For {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Estructura: for (inicialización; condición; actualización)
        // ------------------------------------------------------------
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println("  ← del 1 al 5");

        // La i del for solo existe DENTRO del bucle
        // System.out.println(i);   // ❌ Error: cannot find symbol

        // ------------------------------------------------------------
        // 2. Variaciones
        // ------------------------------------------------------------
        for (int i = 0; i < 5; i++) {          // 5 vueltas empezando en 0 (muy habitual)
            System.out.print(i + " ");
        }
        System.out.println("  ← de 0 a 4 (5 vueltas)");

        for (int i = 10; i >= 1; i--) {        // Cuenta atrás
            System.out.print(i + " ");
        }
        System.out.println("  ← cuenta atrás");

        for (int i = 0; i <= 30; i += 5) {     // De 5 en 5
            System.out.print(i + " ");
        }
        System.out.println("  ← de 5 en 5");

        for (int i = 1; i <= 1000; i *= 2) {   // Multiplicando
            System.out.print(i + " ");
        }
        System.out.println("  ← potencias de 2");
        System.out.println();

        // ------------------------------------------------------------
        // 3. Usar la variable del for en cálculos
        // ------------------------------------------------------------
        int numero = 7;
        System.out.println("Tabla del " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("  %2d x %d = %2d%n", i, numero, i * numero);
        }
        System.out.println();

        // Factorial: 6! = 1 * 2 * 3 * 4 * 5 * 6
        int n = 6;
        long factorial = 1;                    // Acumulador de producto: empieza en 1
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(n + "! = " + factorial);   // 720
        System.out.println();

        // ------------------------------------------------------------
        // 4. for con char
        // ------------------------------------------------------------
        for (char letra = 'a'; letra <= 'j'; letra++) {
            System.out.print(letra + " ");
        }
        System.out.println("  ← letras");
        System.out.println();

        // ------------------------------------------------------------
        // 5. for y while son equivalentes
        // ------------------------------------------------------------
        System.out.print("Con for:   ");
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Con while: ");
        int j = 1;
        while (j <= 3) {
            System.out.print(j + " ");
            j++;
        }
        System.out.println();

        // ⚠️ Un ; detrás del for lo deja VACÍO:
        // for (int k = 0; k < 3; k++); { System.out.println("Solo una vez"); }

        // PRUEBA: muestra los múltiplos de 3 entre 1 y 50 de dos formas:
        //    con un for de 3 en 3, y con un for de 1 en 1 + un if.
    }
}
