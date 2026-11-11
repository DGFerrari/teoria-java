/*
 * TEMA 08 · Arrays y matrices
 * Ejemplo 01: CREAR UN ARRAY Y ACCEDER A SUS ELEMENTOS
 *
 * Cómo ejecutarlo:  java T08_01_CrearYAcceder.java
 */
public class T08_01_CrearYAcceder {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Crear un array con un tamaño: valores por defecto
        // ------------------------------------------------------------
        int[] enteros = new int[4];             // 4 cajones de int
        double[] decimales = new double[2];
        boolean[] marcas = new boolean[2];
        String[] textos = new String[2];

        System.out.println("int por defecto:     " + enteros[0]);      // 0
        System.out.println("double por defecto:  " + decimales[0]);    // 0.0
        System.out.println("boolean por defecto: " + marcas[0]);       // false
        System.out.println("String por defecto:  " + textos[0]);       // null (no hay texto)
        System.out.println();

        // ------------------------------------------------------------
        // 2. Crear un array con sus valores
        // ------------------------------------------------------------
        int[] notas = {7, 5, 9, 6, 8};
        String[] dias = {"lunes", "martes", "miércoles", "jueves", "viernes"};

        // ------------------------------------------------------------
        // 3. Leer y modificar por índice (empieza en 0)
        // ------------------------------------------------------------
        System.out.println("Primera nota (índice 0): " + notas[0]);   // 7
        System.out.println("Tercera nota (índice 2): " + notas[2]);   // 9
        System.out.println("Tercer día: " + dias[2]);                 // miércoles

        notas[1] = 10;            // Cambiamos la segunda nota
        notas[3]++;               // Cada elemento funciona como una variable normal
        notas[4] += 1;
        System.out.println("Notas tras los cambios: " + notas[0] + ", " + notas[1] + ", "
                + notas[2] + ", " + notas[3] + ", " + notas[4]);      // 7, 10, 9, 7, 9
        System.out.println();

        // ------------------------------------------------------------
        // 4. length: el tamaño del array (sin paréntesis)
        // ------------------------------------------------------------
        System.out.println("Hay " + notas.length + " notas");
        System.out.println("Última nota (índice " + (notas.length - 1) + "): " + notas[notas.length - 1]);
        System.out.println();

        // ------------------------------------------------------------
        // 5. Rellenar un array creado vacío
        // ------------------------------------------------------------
        for (int i = 0; i < enteros.length; i++) {
            enteros[i] = (i + 1) * 10;          // 10, 20, 30, 40
        }
        System.out.println("enteros[3] = " + enteros[3]);   // 40

        // ------------------------------------------------------------
        // 6. Un índice que no existe detiene el programa
        // ------------------------------------------------------------
        // System.out.println(notas[5]);
        // ❌ ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

        // El tamaño es FIJO: no se pueden añadir más cajones a "notas".
        // Para listas que crecen está ArrayList (tema 16).

        // PRUEBA: crea un array con los 12 meses del año y muestra el sexto y el último.
    }
}
