/*
 * TEMA 11 · Ejercicio 05 · Parking  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol11_05_Parking.java
 */
import java.util.Scanner;

public class Sol11_05_Parking {

    static class Vehiculo {
        String matricula;
        int minutoEntrada;

        Vehiculo(String matricula, int minutoEntrada) {
            this.matricula = matricula.replace(" ", "").toUpperCase();
            this.minutoEntrada = minutoEntrada;
        }

        @Override
        public String toString() {
            return matricula + " (entrada " + Parking.aTextoHora(minutoEntrada) + ")";
        }
    }

    static class Parking {
        Vehiculo[] plazas;            // null = plaza libre
        double tarifaPorMinuto;
        double importeMinimo;
        double recaudado;
        int vehiculosAtendidos;

        Parking(int numeroPlazas, double tarifaPorMinuto, double importeMinimo) {
            this.plazas = new Vehiculo[numeroPlazas];
            this.tarifaPorMinuto = tarifaPorMinuto;
            this.importeMinimo = importeMinimo;
            this.recaudado = 0;
            this.vehiculosAtendidos = 0;
        }

        int plazasLibres() {
            int libres = 0;
            for (Vehiculo v : plazas) {
                if (v == null) {
                    libres++;
                }
            }
            return libres;
        }

        int buscarPlaza(String matricula) {
            String buscada = matricula.replace(" ", "").toUpperCase();
            int posicion = -1;
            int i = 0;
            while (i < plazas.length && posicion == -1) {
                // && en cortocircuito: si la plaza es null, no se mira la matrícula
                if (plazas[i] != null && plazas[i].matricula.equals(buscada)) {
                    posicion = i;
                }
                i++;
            }
            return posicion;
        }

        int aparcar(Vehiculo vehiculo) {
            int resultado;
            if (buscarPlaza(vehiculo.matricula) != -1) {
                resultado = -2;                          // Ya está dentro
            } else {
                int libre = -1;
                int i = 0;
                while (i < plazas.length && libre == -1) {
                    if (plazas[i] == null) {
                        libre = i;
                    }
                    i++;
                }
                if (libre != -1) {
                    plazas[libre] = vehiculo;
                    resultado = libre + 1;               // Para el usuario, desde 1
                } else {
                    resultado = -1;                      // Lleno
                }
            }
            return resultado;
        }

        double retirar(String matricula, int minutoSalida) {
            double importe = -1;
            int plaza = buscarPlaza(matricula);
            if (plaza != -1) {
                int minutos = minutoSalida - plazas[plaza].minutoEntrada;
                importe = Math.max(minutos * tarifaPorMinuto, importeMinimo);   // Con mínimo
                recaudado += importe;
                vehiculosAtendidos++;
                plazas[plaza] = null;                    // La plaza queda libre
            }
            return importe;
        }

        void mostrarEstado() {
            System.out.println("=== Estado del parking (" + plazasLibres() + " libres de " + plazas.length + ") ===");
            for (int i = 0; i < plazas.length; i++) {
                System.out.println("Plaza " + (i + 1) + ": " + (plazas[i] == null ? "libre" : plazas[i]));
            }
        }

        static int aHoraEnMinutos(String hora) {
            return Integer.parseInt(hora.substring(0, 2)) * 60 + Integer.parseInt(hora.substring(3));
        }

        static String aTextoHora(int minutos) {
            return String.format("%02d:%02d", minutos / 60, minutos % 60);
        }

        static boolean esHoraValida(String hora) {
            boolean formato = hora.length() == 5 && hora.charAt(2) == ':'
                    && Character.isDigit(hora.charAt(0)) && Character.isDigit(hora.charAt(1))
                    && Character.isDigit(hora.charAt(3)) && Character.isDigit(hora.charAt(4));
            // Si el formato falla, el cortocircuito evita los parseInt
            return formato
                    && Integer.parseInt(hora.substring(0, 2)) <= 23
                    && Integer.parseInt(hora.substring(3)) <= 59;
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

    static int leerHora(Scanner teclado, String mensaje) {
        String hora = "";
        boolean valida = false;
        while (!valida) {
            System.out.print(mensaje);
            hora = teclado.nextLine().strip();
            valida = Parking.esHoraValida(hora);
            if (!valida) {
                System.out.println("  Formato incorrecto. Usa HH:MM (por ejemplo 09:05).");
            }
        }
        return Parking.aHoraEnMinutos(hora);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Parking parking = new Parking(3, 0.05, 1.0);

        int opcion;
        do {
            System.out.println();
            System.out.println("1. Aparcar  2. Retirar  3. Ver estado  0. Salir");
            opcion = leerEntero(teclado, "Opción: ");

            switch (opcion) {
                case 1 -> {
                    System.out.print("Matrícula: ");
                    String matricula = teclado.nextLine();
                    int entrada = leerHora(teclado, "Hora de entrada (HH:MM): ");
                    Vehiculo vehiculo = new Vehiculo(matricula, entrada);
                    int plaza = parking.aparcar(vehiculo);
                    if (plaza == -2) {
                        System.out.println("  " + vehiculo.matricula + " ya está dentro del parking");
                    } else if (plaza == -1) {
                        System.out.println("  Parking completo");
                    } else {
                        System.out.println("  " + vehiculo.matricula + " aparcado en la plaza " + plaza);
                    }
                }
                case 2 -> {
                    System.out.print("Matrícula: ");
                    String matricula = teclado.nextLine();
                    int plaza = parking.buscarPlaza(matricula);
                    if (plaza == -1) {
                        System.out.println("  Ese vehículo no está en el parking");
                    } else {
                        Vehiculo vehiculo = parking.plazas[plaza];
                        int salida = leerHora(teclado, "Hora de salida (HH:MM): ");
                        if (salida < vehiculo.minutoEntrada) {
                            System.out.println("  La salida no puede ser anterior a la entrada ("
                                    + Parking.aTextoHora(vehiculo.minutoEntrada) + ")");
                        } else {
                            int minutos = salida - vehiculo.minutoEntrada;
                            double importe = parking.retirar(vehiculo.matricula, salida);
                            System.out.printf("  %s sale tras %d minutos. Importe: %.2f €%n",
                                    vehiculo.matricula, minutos, importe);
                        }
                    }
                }
                case 3 -> parking.mostrarEstado();
                case 0 -> System.out.println("Cerrando el parking...");
                default -> System.out.println("  Opción no válida");
            }
        } while (opcion != 0);

        System.out.println("=== Resumen del día ===");
        System.out.println("Vehículos atendidos: " + parking.vehiculosAtendidos);
        System.out.printf("Recaudado: %.2f €%n", parking.recaudado);
        System.out.println("Siguen dentro: " + (parking.plazas.length - parking.plazasLibres()));

        teclado.close();
    }
}
