/*
 * TEMA 04 · Operadores
 * Ejemplo 04: PRECEDENCIA Y LA CLASE Math
 *
 * Cómo ejecutarlo:  java T04_04_PrecedenciaYMath.java
 */
public class T04_04_PrecedenciaYMath {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Precedencia: * / % antes que + -
        // ------------------------------------------------------------
        System.out.println("2 + 3 * 4     = " + (2 + 3 * 4));       // 14
        System.out.println("(2 + 3) * 4   = " + ((2 + 3) * 4));     // 20
        System.out.println("10 - 4 - 3    = " + (10 - 4 - 3));      // 3  (de izquierda a derecha)
        System.out.println("10 - (4 - 3)  = " + (10 - (4 - 3)));    // 9
        System.out.println("20 / 2 * 5    = " + (20 / 2 * 5));      // 50 (izquierda a derecha, no 2)
        System.out.println();

        // Ejemplo real: media de tres notas
        int n1 = 6;
        int n2 = 8;
        int n3 = 10;
        System.out.println("Media mal:  " + (n1 + n2 + n3 / 3.0));     // 17.33... ¡solo divide n3!
        System.out.println("Media bien: " + ((n1 + n2 + n3) / 3.0));   // 8.0
        System.out.println();

        // Relacionales antes que lógicos, y && antes que ||
        boolean r = 5 > 3 && 2 > 4 || 1 == 1;   // (true && false) || true → true
        System.out.println("5 > 3 && 2 > 4 || 1 == 1 → " + r);
        System.out.println();

        // ------------------------------------------------------------
        // 2. La clase Math
        // ------------------------------------------------------------
        System.out.println("Math.pow(2, 10)  = " + Math.pow(2, 10));    // 1024.0
        System.out.println("Math.sqrt(81)    = " + Math.sqrt(81));      // 9.0
        System.out.println("Math.abs(-7)     = " + Math.abs(-7));       // 7
        System.out.println("Math.max(3, 9)   = " + Math.max(3, 9));     // 9
        System.out.println("Math.min(3, 9)   = " + Math.min(3, 9));     // 3
        System.out.println("Math.PI          = " + Math.PI);
        System.out.println();

        // Tres formas de "quitar decimales"
        double valor = 2.6;
        System.out.println("valor = " + valor);
        System.out.println("  (int)      → " + (int) valor);           // 2   (corta)
        System.out.println("  Math.floor → " + Math.floor(valor));     // 2.0 (hacia abajo)
        System.out.println("  Math.ceil  → " + Math.ceil(valor));      // 3.0 (hacia arriba)
        System.out.println("  Math.round → " + Math.round(valor));     // 3   (al más cercano)

        // Con negativos, (int) y floor NO son lo mismo
        double negativo = -2.6;
        System.out.println("valor = " + negativo);
        System.out.println("  (int)      → " + (int) negativo);        // -2 (hacia el cero)
        System.out.println("  Math.floor → " + Math.floor(negativo));  // -3.0 (hacia abajo)
        System.out.println();

        // Redondear a 2 decimales
        double precio = 12.34567;
        double precioRedondeado = Math.round(precio * 100) / 100.0;
        System.out.println(precio + " con 2 decimales → " + precioRedondeado);   // 12.35

        // Ejemplo: área de un círculo de radio 3 y distancia entre dos puntos
        double radio = 3;
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("Área del círculo de radio 3: " + Math.round(area * 100) / 100.0);   // 28.27

        double distancia = Math.sqrt(Math.pow(4 - 1, 2) + Math.pow(6 - 2, 2));   // De (1,2) a (4,6)
        System.out.println("Distancia de (1,2) a (4,6): " + distancia);          // 5.0

        // PRUEBA: calcula la hipotenusa de un triángulo de catetos 5 y 12.
    }
}
