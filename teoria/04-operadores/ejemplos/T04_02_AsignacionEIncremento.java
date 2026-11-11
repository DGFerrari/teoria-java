/*
 * TEMA 04 · Operadores
 * Ejemplo 02: ASIGNACIÓN COMPUESTA E INCREMENTO
 *
 * Cómo ejecutarlo:  java T04_02_AsignacionEIncremento.java
 */
public class T04_02_AsignacionEIncremento {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Asignación compuesta: operar y guardar en la misma variable
        // ------------------------------------------------------------
        int puntos = 100;
        System.out.println("Puntos iniciales: " + puntos);

        puntos += 50;    // puntos = puntos + 50
        System.out.println("Tras += 50: " + puntos);   // 150

        puntos -= 30;    // puntos = puntos - 30
        System.out.println("Tras -= 30: " + puntos);   // 120

        puntos *= 2;     // puntos = puntos * 2
        System.out.println("Tras *= 2:  " + puntos);   // 240

        puntos /= 7;     // puntos = puntos / 7  (división entera)
        System.out.println("Tras /= 7:  " + puntos);   // 34

        puntos %= 10;    // puntos = puntos % 10
        System.out.println("Tras %= 10: " + puntos);   // 4
        System.out.println();

        // Con textos, += añade al final
        String mensaje = "Hola";
        mensaje += ", mundo";
        mensaje += "!";
        System.out.println(mensaje);   // Hola, mundo!

        // Casting oculto: compila aunque 2.7 sea double, y se pierden decimales
        int entero = 10;
        entero += 2.7;                 // Equivale a entero = (int) (entero + 2.7)
        System.out.println("10 += 2.7 → " + entero);   // 12
        // entero = entero + 2.7;      // ❌ Esto sí da error: lossy conversion
        System.out.println();

        // ------------------------------------------------------------
        // 2. Incremento y decremento en su propia línea (uso recomendado)
        // ------------------------------------------------------------
        int contador = 0;
        contador++;      // contador = contador + 1
        contador++;
        contador--;      // contador = contador - 1
        System.out.println("Contador: " + contador);   // 1
        System.out.println();

        // ------------------------------------------------------------
        // 3. Postincremento (x++) frente a preincremento (++x)
        // ------------------------------------------------------------
        int a = 5;
        int b = a++;     // 1º copia el valor actual de a en b (5), 2º suma 1 a a
        System.out.println("Postincremento → a = " + a + ", b = " + b);   // a = 6, b = 5

        int c = 5;
        int d = ++c;     // 1º suma 1 a c (6), 2º copia el nuevo valor en d
        System.out.println("Preincremento  → c = " + c + ", d = " + d);   // c = 6, d = 6

        // Dentro de un println pasa lo mismo:
        int vidas = 3;
        System.out.println("Vidas (vidas--): " + vidas--);   // Muestra 3 y luego resta
        System.out.println("Vidas ahora:     " + vidas);     // 2
        System.out.println("Vidas (--vidas): " + --vidas);   // Resta y luego muestra: 1

        // Consejo: evita mezclar ++ y -- dentro de otras expresiones.
        // Esto compila, pero ¿sabrías decir qué vale r sin ejecutarlo?
        int x = 2;
        int r = x++ + ++x;   // 2 + 4 = 6 (y x acaba valiendo 4)
        System.out.println("x++ + ++x = " + r + " (x = " + x + ")");

        // PRUEBA: empieza con saldo = 1000 y aplica: +250, -75, *2, /3. ¿Qué queda?
    }
}
