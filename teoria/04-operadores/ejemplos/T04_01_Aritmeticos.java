/*
 * TEMA 04 · Operadores
 * Ejemplo 01: OPERADORES ARITMÉTICOS, DIVISIÓN ENTERA Y MÓDULO
 *
 * Cómo ejecutarlo:  java T04_01_Aritmeticos.java
 */
public class T04_01_Aritmeticos {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Las cinco operaciones
        // ------------------------------------------------------------
        int a = 17;
        int b = 5;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + (a + b));   // 22
        System.out.println("a - b = " + (a - b));   // 12
        System.out.println("a * b = " + (a * b));   // 85
        System.out.println("a / b = " + (a / b));   // 3   ← cociente (división entera)
        System.out.println("a % b = " + (a % b));   // 2   ← resto
        System.out.println("a / b con decimales = " + ((double) a / b));   // 3.4
        System.out.println();

        // Comprobación: cociente * divisor + resto = dividendo
        System.out.println("Comprobación: " + (a / b) + " * " + b + " + " + (a % b) + " = " + ((a / b) * b + a % b));
        System.out.println();

        // ------------------------------------------------------------
        // 2. Usos típicos del módulo %
        // ------------------------------------------------------------
        int numero = 1234;

        // ¿Par o impar? Un número es par si el resto entre 2 es 0
        System.out.println(numero + " es par: " + (numero % 2 == 0));        // true

        // ¿Múltiplo de 3?
        System.out.println(numero + " es múltiplo de 3: " + (numero % 3 == 0));   // false

        // Última cifra y número sin la última cifra
        System.out.println("Última cifra de " + numero + ": " + (numero % 10));   // 4
        System.out.println(numero + " sin la última cifra: " + (numero / 10));    // 123

        // Segundos → minutos y segundos
        int segundosTotales = 135;
        int minutos = segundosTotales / 60;
        int segundos = segundosTotales % 60;
        System.out.println(segundosTotales + " s = " + minutos + " min " + segundos + " s");   // 2 min 15 s

        // Ciclos: hoy es jueves (día 3, contando lunes = 0). ¿Qué día será dentro de 10 días?
        int hoy = 3;
        int dentroDe10 = (hoy + 10) % 7;   // 13 % 7 = 6 → domingo
        System.out.println("Dentro de 10 días será el día " + dentroDe10 + " (0 = lunes, 6 = domingo)");
        System.out.println();

        // ------------------------------------------------------------
        // 3. Casos especiales
        // ------------------------------------------------------------
        System.out.println("-7 % 3 = " + (-7 % 3));          // -1 (signo del dividendo)
        System.out.println("7.5 % 2 = " + (7.5 % 2));        // 1.5 (también funciona con decimales)
        System.out.println("10.0 / 0 = " + (10.0 / 0));      // Infinity (con double no hay error)
        System.out.println("0.0 / 0 = " + (0.0 / 0));        // NaN (Not a Number)
        // System.out.println(10 / 0);                       // ❌ ArithmeticException con int

        // PRUEBA: calcula la suma de las cifras de 4096 usando solo % y /.
    }
}
