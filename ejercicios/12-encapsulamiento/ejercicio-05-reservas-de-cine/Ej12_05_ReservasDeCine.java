/*
 * TEMA 12 · Ejercicio 05 · Reservas de cine  (dificultad: 5/5)
 *
 * Objetivo: una sala de cine encapsulada que vende entradas inmutables.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej12_05_ReservasDeCine.java
 *
 * Regla: sin break (salvo en switch clásico), sin continue y sin return dentro de bucles.
 * Desde el main, usa SOLO los métodos públicos de Sala y Entrada.
 */
import java.util.Scanner;

public class Ej12_05_ReservasDeCine {

    static final class Entrada {

        // TODO 1: contador static para los id y atributos private final

        public Entrada(String pelicula, int fila, int butaca, double precio) {
        }

        public int getId() {
            return 0;
        }

        public int getFila() {
            return 0;
        }

        public int getButaca() {
            return 0;
        }

        public double getPrecio() {
            return 0;
        }

        // TODO 2: "Entrada #1 · Dune · fila 3, butaca 4 · 7,00 €"
        @Override
        public String toString() {
            return "";
        }
    }

    static class Sala {

        public static final int FILAS = 5;
        public static final int BUTACAS = 8;

        // TODO 3: atributos privados: pelicula, matriz ocupadas, array vendidas y su contador

        public Sala(String pelicula) {
        }

        // TODO 4: devuelve la entrada o null
        public Entrada reservar(int fila, int butaca) {
            return null;
        }

        // TODO 5
        public boolean cancelar(int id) {
            return false;
        }

        public int getVendidas() {
            return 0;
        }

        public int getLibres() {
            return FILAS * BUTACAS;
        }

        public double getRecaudacion() {
            return 0;
        }

        // TODO 6: mapa con · y X
        public void mostrarMapa() {
        }

        // TODO 7: métodos privados de ayuda
        private boolean existe(int fila, int butaca) {
            return false;
        }

        private double precioDeFila(int fila) {
            return 0;
        }
    }

    // Ya hecho: lee una línea hasta que sea un número entero
    static int leerEntero(Scanner teclado, String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String linea = teclado.nextLine().strip();
            valido = !linea.isEmpty();
            for (int i = 0; i < linea.length() && valido; i++) {
                valido = Character.isDigit(linea.charAt(i));
            }
            if (valido) {
                numero = Integer.parseInt(linea);
            } else {
                System.out.println("  Escribe un número.");
            }
        }
        return numero;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Sala sala = new Sala("Dune");

        int opcion;
        do {
            System.out.println();
            System.out.println("1. Ver mapa  2. Reservar  3. Cancelar  0. Salir");
            opcion = leerEntero(teclado, "Opción: ");
            switch (opcion) {
                case 1 -> sala.mostrarMapa();
                case 2 -> {
                    // TODO 8: pide fila y butaca, reserva y muestra la entrada o el error
                }
                case 3 -> {
                    // TODO 9: pide el número de entrada y cancela
                }
                case 0 -> System.out.println("Cerrando taquilla...");
                default -> System.out.println("  Opción no válida");
            }
        } while (opcion != 0);

        // TODO 10: resumen (vendidas, libres y recaudación)

        teclado.close();
    }
}
