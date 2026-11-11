/*
 * TEMA 09 · Strings
 * Ejemplo 05: StringBuilder
 *
 * Cómo ejecutarlo:  java T09_05_StringBuilder.java
 */
public class T09_05_StringBuilder {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Operaciones básicas: StringBuilder SÍ se modifica
        // ------------------------------------------------------------
        StringBuilder sb = new StringBuilder("Hola");
        sb.append(" mundo");                 // "Hola mundo"
        sb.append('!');                      // "Hola mundo!"
        sb.append(2025);                     // Acepta cualquier tipo: "Hola mundo!2025"
        System.out.println("append:      " + sb);

        sb.insert(4, ",");                   // "Hola, mundo!2025"
        System.out.println("insert:      " + sb);

        sb.delete(11, sb.length());          // Borra desde la posición 11 hasta el final: "Hola, mundo"
        System.out.println("delete:      " + sb);

        sb.setCharAt(0, 'h');                // "hola, mundo"
        System.out.println("setCharAt:   " + sb);

        sb.deleteCharAt(4);                  // Borra la coma: "hola mundo"
        System.out.println("deleteCharAt:" + " " + sb);

        sb.reverse();                        // "odnum aloh"
        System.out.println("reverse:     " + sb);

        String resultado = sb.toString();    // Para usarlo como String normal
        System.out.println("toString → String de longitud " + resultado.length());
        System.out.println();

        // Los métodos se pueden encadenar
        String alReves = new StringBuilder("reconocer").reverse().toString();
        System.out.println("\"reconocer\" al revés: " + alReves + " → ¿palíndromo? " + alReves.equals("reconocer"));
        System.out.println();

        // ------------------------------------------------------------
        // 2. Construir un texto en un bucle
        // ------------------------------------------------------------
        StringBuilder lista = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            if (lista.length() > 0) {        // Separador antes de cada número salvo el primero
                lista.append(", ");
            }
            lista.append(i * i);
        }
        System.out.println("Cuadrados: " + lista);
        System.out.println();

        // ------------------------------------------------------------
        // 3. ¿Por qué es más rápido? (los tiempos varían según el ordenador)
        // ------------------------------------------------------------
        final int REPETICIONES = 30_000;

        long inicio = System.nanoTime();     // Hora actual en nanosegundos
        String conString = "";
        for (int i = 0; i < REPETICIONES; i++) {
            conString += "x";                // Crea un String nuevo en cada vuelta
        }
        long tiempoString = System.nanoTime() - inicio;

        inicio = System.nanoTime();
        StringBuilder conBuilder = new StringBuilder();
        for (int i = 0; i < REPETICIONES; i++) {
            conBuilder.append("x");          // Modifica el mismo objeto
        }
        long tiempoBuilder = System.nanoTime() - inicio;

        System.out.printf("Con String += : %,d ms%n", tiempoString / 1_000_000);
        System.out.printf("Con StringBuilder: %,d ms%n", tiempoBuilder / 1_000_000);
        System.out.println("Mismo resultado: " + conString.equals(conBuilder.toString()));

        // PRUEBA: sube REPETICIONES a 100_000 y compara otra vez los tiempos.
    }
}
