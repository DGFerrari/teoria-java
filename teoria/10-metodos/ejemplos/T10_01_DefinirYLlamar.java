/*
 * TEMA 10 · Métodos
 * Ejemplo 01: DEFINIR Y LLAMAR MÉTODOS
 *
 * Cómo ejecutarlo:  java T10_01_DefinirYLlamar.java
 */
public class T10_01_DefinirYLlamar {

    // ------------------------------------------------------------
    // Los métodos se definen DENTRO de la clase y FUERA del main.
    // "static" de momento siempre (lo entenderás en los temas 11 y 12).
    // "void" significa que no devuelven ningún valor.
    // ------------------------------------------------------------

    /** Muestra una línea separadora. */
    static void mostrarSeparador() {
        System.out.println("------------------------------");
    }

    /** Muestra un mensaje de bienvenida. Llama a otro método. */
    static void mostrarBienvenida() {
        mostrarSeparador();                      // Un método puede llamar a otro
        System.out.println("   Bienvenido al programa");
        mostrarSeparador();
    }

    /** Saluda a una persona. Recibe un dato: el nombre. */
    static void saludar(String nombre) {
        System.out.println("¡Hola, " + nombre + "!");
    }

    /** Muestra un texto enmarcado. Recibe dos datos: el texto y el símbolo del marco. */
    static void enmarcar(String texto, char simbolo) {
        String linea = String.valueOf(simbolo).repeat(texto.length() + 4);
        System.out.println(linea);
        System.out.println(simbolo + " " + texto + " " + simbolo);
        System.out.println(linea);
    }

    /** Muestra la tabla de multiplicar de un número, hasta un límite. */
    static void mostrarTabla(int numero, int hasta) {
        for (int i = 1; i <= hasta; i++) {
            System.out.println(numero + " x " + i + " = " + numero * i);
        }
    }

    public static void main(String[] args) {

        System.out.println("1. Empieza el main");

        // Al llamar, el programa SALTA al método, lo ejecuta y VUELVE aquí
        mostrarBienvenida();

        System.out.println("2. Hemos vuelto al main");
        System.out.println();

        // Mismo método, distintos argumentos
        saludar("Ana");
        saludar("Luis");

        String usuario = "Marta";
        saludar(usuario);                        // El argumento puede ser una variable...
        saludar(usuario.toUpperCase());          // ...o una expresión
        System.out.println();

        // Varios parámetros: se asignan POR ORDEN
        enmarcar("Java mola", '*');
        enmarcar("Métodos", '#');
        System.out.println();

        mostrarTabla(7, 5);
        // mostrarTabla("7", 5);                 // ❌ Error: el primer parámetro es int
        // mostrarTabla(7);                      // ❌ Error: faltan argumentos

        System.out.println();
        System.out.println("3. Fin del main");

        // PRUEBA: crea un método "contarHasta(int n)" que muestre los números del 1 al n
        //    en una sola línea, y llámalo con 5 y con 10.
    }
}
