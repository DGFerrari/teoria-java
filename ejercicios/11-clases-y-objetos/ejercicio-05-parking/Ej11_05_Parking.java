/*
 * TEMA 11 · Ejercicio 05 · Parking  (dificultad: 5/5)
 *
 * Objetivo: varias clases que colaboran para gestionar un parking con menú.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej11_05_Parking.java
 *
 * Regla: sin break (salvo en switch clásico), sin continue y sin return dentro de bucles.
 */
import java.util.Scanner;

public class Ej11_05_Parking {

    static class Vehiculo {
        String matricula;
        int minutoEntrada;

        // TODO 1: constructor (guarda la matrícula sin espacios y en mayúsculas)
        Vehiculo(String matricula, int minutoEntrada) {
        }

        // TODO 2: "1234ABC (entrada 09:15)"  (usa Parking.aTextoHora)
        @Override
        public String toString() {
            return "";
        }
    }

    static class Parking {
        Vehiculo[] plazas;
        double tarifaPorMinuto;
        double importeMinimo;
        double recaudado;
        int vehiculosAtendidos;

        // TODO 3: constructor
        Parking(int numeroPlazas, double tarifaPorMinuto, double importeMinimo) {
            plazas = new Vehiculo[numeroPlazas];
        }

        // TODO 4: número de plazas a null
        int plazasLibres() {
            return 0;
        }

        // TODO 5: posición (0..n-1) del vehículo con esa matrícula, o -1
        int buscarPlaza(String matricula) {
            return -1;
        }

        // TODO 6: -2 si ya está dentro, -1 si está lleno, o el nº de plaza (desde 1)
        int aparcar(Vehiculo vehiculo) {
            return -1;
        }

        // TODO 7: -1 si no está; si está, libera la plaza y devuelve el importe
        double retirar(String matricula, int minutoSalida) {
            return -1;
        }

        // TODO 8: "=== Estado del parking (X libres de N) ===" y una línea por plaza
        void mostrarEstado() {
        }

        // TODO 9: "09:15" → 555
        static int aHoraEnMinutos(String hora) {
            return 0;
        }

        // TODO 10: 555 → "09:15"
        static String aTextoHora(int minutos) {
            return "";
        }

        // TODO 11: ¿la hora tiene el formato HH:MM y está en rango?
        static boolean esHoraValida(String hora) {
            return true;
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

    // TODO 12: lee una línea hasta que sea una hora válida y la devuelve en minutos
    static int leerHora(Scanner teclado, String mensaje) {
        System.out.print(mensaje);
        return Parking.aHoraEnMinutos(teclado.nextLine().strip());
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
                    // TODO 13: pide matrícula y hora, crea el Vehiculo, aparca y
                    //          muestra el resultado según el número devuelto.
                }
                case 2 -> {
                    // TODO 14: pide matrícula y hora de salida, comprueba que no sea
                    //          anterior a la entrada, retira y muestra el importe.
                }
                case 3 -> parking.mostrarEstado();
                case 0 -> System.out.println("Cerrando el parking...");
                default -> System.out.println("  Opción no válida");
            }
        } while (opcion != 0);

        // TODO 15: resumen del día (atendidos, recaudado y cuántos siguen dentro)

        teclado.close();
    }
}
