/*
 * TEMA 03 · Variables y tipos de datos
 * Ejemplo 03: char Y String
 *
 * Cómo ejecutarlo:  java T03_03_CharYString.java
 */
public class T03_03_CharYString {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. char: un carácter que, por dentro, es un número
        // ------------------------------------------------------------
        char letra = 'A';
        int codigo = letra;                   // Conversión automática char → int
        System.out.println("La letra " + letra + " tiene el código " + codigo);   // 65

        // Al sumarle un número, el resultado es int. Para volver a char, casting.
        char siguiente = (char) (letra + 1);
        System.out.println("La siguiente letra es " + siguiente);                  // B

        // También se puede crear un char a partir de su código
        char deCodigo = 97;
        System.out.println("El código 97 es la letra " + deCodigo);               // a

        // Los dígitos también son caracteres, con su propio código
        char digito = '7';
        System.out.println("El carácter '7' tiene el código " + (int) digito);     // 55, ¡no 7!
        System.out.println();

        // ------------------------------------------------------------
        // 2. String: una cadena de caracteres
        // ------------------------------------------------------------
        String nombre = "Lucía";
        String apellido = "Martín";
        String vacio = "";                    // Un String puede estar vacío

        // Concatenar
        String nombreCompleto = nombre + " " + apellido;
        System.out.println("Nombre completo: " + nombreCompleto);

        // Algunas operaciones básicas (se ven a fondo en el tema 09)
        System.out.println("Longitud: " + nombreCompleto.length());           // 12
        System.out.println("En mayúsculas: " + nombreCompleto.toUpperCase());
        System.out.println("Primera letra: " + nombreCompleto.charAt(0));      // L (las posiciones empiezan en 0)
        System.out.println("¿Está vacío 'vacio'? " + vacio.isEmpty());         // true
        System.out.println();

        // ------------------------------------------------------------
        // 3. Diferencias clave
        // ------------------------------------------------------------
        char unaA = 'A';       // char: comillas simples
        String textoA = "A";   // String: comillas dobles, aunque sea una sola letra
        System.out.println("char: " + unaA + " | String: " + textoA);

        // ¡Cuidado al "sumar" chars! Dos char se suman como NÚMEROS:
        System.out.println('A' + 'B');          // 131 (65 + 66)
        System.out.println("" + 'A' + 'B');     // AB  (empieza por String → concatena)

        // PRUEBA: muestra la letra que está 5 posiciones después de 'k'.
    }
}
