/*
 * TEMA 12 · Ejercicio 05 · Reservas de cine  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol12_05_ReservasDeCine.java
 */
import java.util.Scanner;

public class Sol12_05_ReservasDeCine {

    // Comprobante inmutable con identificador automático
    static final class Entrada {

        private static int siguienteId = 1;

        private final int id;
        private final String pelicula;
        private final int fila;
        private final int butaca;
        private final double precio;

        public Entrada(String pelicula, int fila, int butaca, double precio) {
            this.id = siguienteId;
            siguienteId++;
            this.pelicula = pelicula;
            this.fila = fila;
            this.butaca = butaca;
            this.precio = precio;
        }

        public int getId() {
            return id;
        }

        public int getFila() {
            return fila;
        }

        public int getButaca() {
            return butaca;
        }

        public double getPrecio() {
            return precio;
        }

        @Override
        public String toString() {
            return String.format("Entrada #%d · %s · fila %d, butaca %d · %.2f €", id, pelicula, fila, butaca, precio);
        }
    }

    static class Sala {

        public static final int FILAS = 5;
        public static final int BUTACAS = 8;
        private static final double PRECIO_DELANTERA = 5.0;
        private static final double PRECIO_CENTRAL = 7.0;
        private static final double PRECIO_VIP = 9.0;

        private final String pelicula;
        private final boolean[][] ocupadas = new boolean[FILAS][BUTACAS];
        private final Entrada[] vendidas = new Entrada[FILAS * BUTACAS];
        private int numVendidas = 0;

        public Sala(String pelicula) {
            this.pelicula = pelicula;
        }

        public Entrada reservar(int fila, int butaca) {
            Entrada entrada = null;
            // existe() va primero: evita mirar fuera de la matriz
            if (existe(fila, butaca) && !ocupadas[fila - 1][butaca - 1]) {
                ocupadas[fila - 1][butaca - 1] = true;
                entrada = new Entrada(pelicula, fila, butaca, precioDeFila(fila));
                vendidas[numVendidas] = entrada;
                numVendidas++;
            }
            return entrada;
        }

        public boolean cancelar(int id) {
            int posicion = -1;
            int i = 0;
            while (i < numVendidas && posicion == -1) {
                if (vendidas[i].getId() == id) {
                    posicion = i;
                }
                i++;
            }
            if (posicion != -1) {
                Entrada e = vendidas[posicion];
                ocupadas[e.getFila() - 1][e.getButaca() - 1] = false;   // Libera la butaca
                for (int j = posicion; j < numVendidas - 1; j++) {
                    vendidas[j] = vendidas[j + 1];
                }
                vendidas[numVendidas - 1] = null;
                numVendidas--;
            }
            return posicion != -1;
        }

        public int getVendidas() {
            return numVendidas;
        }

        public int getLibres() {
            return FILAS * BUTACAS - numVendidas;
        }

        public double getRecaudacion() {
            double total = 0;
            for (int i = 0; i < numVendidas; i++) {
                total += vendidas[i].getPrecio();
            }
            return total;
        }

        public void mostrarMapa() {
            StringBuilder cabecera = new StringBuilder("       ");   // Mismo ancho que "Fila N "
            for (int b = 1; b <= BUTACAS; b++) {
                cabecera.append(" ").append(b);
            }
            System.out.println(cabecera);
            for (int f = 0; f < FILAS; f++) {
                StringBuilder linea = new StringBuilder("Fila " + (f + 1) + " ");
                for (int b = 0; b < BUTACAS; b++) {
                    linea.append(" ").append(ocupadas[f][b] ? 'X' : '·');
                }
                if (precioDeFila(f + 1) == PRECIO_VIP) {
                    linea.append("   (VIP)");
                }
                System.out.println(linea);
            }
        }

        private boolean existe(int fila, int butaca) {
            return fila >= 1 && fila <= FILAS && butaca >= 1 && butaca <= BUTACAS;
        }

        private double precioDeFila(int fila) {
            if (fila <= 2) {
                return PRECIO_DELANTERA;
            } else if (fila <= 4) {
                return PRECIO_CENTRAL;
            } else {
                return PRECIO_VIP;
            }
        }
    }

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
                    int fila = leerEntero(teclado, "Fila (1-" + Sala.FILAS + "): ");
                    int butaca = leerEntero(teclado, "Butaca (1-" + Sala.BUTACAS + "): ");
                    Entrada entrada = sala.reservar(fila, butaca);
                    if (entrada != null) {
                        System.out.println("  ✔ " + entrada);
                    } else {
                        System.out.println("  ✘ Esa butaca no existe o ya está ocupada");
                    }
                }
                case 3 -> {
                    int id = leerEntero(teclado, "Número de entrada: ");
                    System.out.println(sala.cancelar(id)
                            ? "  ✔ Entrada #" + id + " cancelada"
                            : "  ✘ No hay ninguna entrada #" + id);
                }
                case 0 -> System.out.println("Cerrando taquilla...");
                default -> System.out.println("  Opción no válida");
            }
        } while (opcion != 0);

        System.out.println("=== Resumen ===");
        System.out.println("Entradas vendidas: " + sala.getVendidas());
        System.out.println("Butacas libres: " + sala.getLibres());
        System.out.printf("Recaudación: %.2f €%n", sala.getRecaudacion());

        teclado.close();
    }
}
