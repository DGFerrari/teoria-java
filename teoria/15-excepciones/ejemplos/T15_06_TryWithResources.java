/*
 * TEMA 15 · Excepciones
 * Ejemplo 06: try-with-resources (cierre automático de recursos)
 *
 * Cómo ejecutarlo:  java T15_06_TryWithResources.java
 */
import java.util.Scanner;

public class T15_06_TryWithResources {

    // Un "recurso" de juguete: implementa AutoCloseable, así que puede ir en un try-with-resources
    static class Conexion implements AutoCloseable {
        private final String nombre;

        Conexion(String nombre) {
            this.nombre = nombre;
            System.out.println("  🔌 Abriendo " + nombre);
        }

        void enviar(String mensaje) {
            if (mensaje.isEmpty()) {
                throw new IllegalArgumentException("Mensaje vacío");
            }
            System.out.println("  📤 [" + nombre + "] " + mensaje);
        }

        @Override
        public void close() {                      // Lo llama Java automáticamente al salir del try
            System.out.println("  🔒 Cerrando " + nombre);
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Sin errores: se cierra al terminar el bloque
        // ------------------------------------------------------------
        System.out.println("1. Todo bien:");
        try (Conexion c = new Conexion("servidor A")) {
            c.enviar("Hola");
            c.enviar("¿Qué tal?");
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. Con error: también se cierra (ANTES de entrar en el catch)
        // ------------------------------------------------------------
        System.out.println("2. Con un error:");
        try (Conexion c = new Conexion("servidor B")) {
            c.enviar("Primer mensaje");
            c.enviar("");                              // 💥
            c.enviar("Esto no se envía");
        } catch (IllegalArgumentException e) {
            System.out.println("  ✘ Error: " + e.getMessage());
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3. Varios recursos: se cierran en orden INVERSO
        // ------------------------------------------------------------
        System.out.println("3. Varios recursos:");
        try (Conexion base = new Conexion("base de datos");
             Conexion cache = new Conexion("caché")) {
            base.enviar("SELECT ...");
            cache.enviar("GUARDAR ...");
        }
        System.out.println();

        // ------------------------------------------------------------
        // 4. Un recurso real: Scanner leyendo un texto (en el tema 20, un fichero)
        // ------------------------------------------------------------
        System.out.println("4. Scanner sobre un texto:");
        String datos = """
                manzanas;3
                peras;5
                uvas;dos
                kiwis;4
                """;
        int total = 0;
        try (Scanner lector = new Scanner(datos)) {
            while (lector.hasNextLine()) {
                String[] partes = lector.nextLine().split(";");
                try {
                    total += Integer.parseInt(partes[1]);
                } catch (NumberFormatException e) {
                    System.out.println("  Línea ignorada (" + partes[0] + "): '" + partes[1] + "' no es un número");
                }
            }
        }
        System.out.println("  Total de piezas de fruta: " + total);

        // Equivalente "a mano" con finally (más largo y fácil de olvidar):
        //   Conexion c = new Conexion("X");
        //   try { ... } finally { c.close(); }
    }
}
