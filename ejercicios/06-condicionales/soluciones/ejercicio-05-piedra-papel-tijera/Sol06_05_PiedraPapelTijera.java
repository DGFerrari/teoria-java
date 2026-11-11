/*
 * TEMA 06 · Ejercicio 05 · Piedra, papel o tijera  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol06_05_PiedraPapelTijera.java
 */
import java.util.Random;
import java.util.Scanner;

public class Sol06_05_PiedraPapelTijera {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        // Normalizamos al leer: sin espacios alrededor y en minúsculas
        System.out.print("Tu jugada (piedra, papel o tijera): ");
        String jugador = teclado.nextLine().trim().toLowerCase();

        boolean jugadaValida = jugador.equals("piedra") || jugador.equals("papel") || jugador.equals("tijera");

        if (!jugadaValida) {
            System.out.println("Jugada no válida: " + jugador);
        } else {
            // Jugada del ordenador (default cubre el 2 y cualquier otro int)
            String ordenador = switch (random.nextInt(3)) {
                case 0 -> "piedra";
                case 1 -> "papel";
                default -> "tijera";
            };

            // Solo describimos las 3 combinaciones en las que gana el jugador
            boolean ganaJugador = (jugador.equals("piedra") && ordenador.equals("tijera"))
                    || (jugador.equals("tijera") && ordenador.equals("papel"))
                    || (jugador.equals("papel") && ordenador.equals("piedra"));

            String resultado;
            if (jugador.equals(ordenador)) {
                resultado = "EMPATE";
            } else if (ganaJugador) {
                resultado = "VICTORIA";
            } else {
                resultado = "DERROTA";
            }

            int puntos = switch (resultado) {
                case "VICTORIA" -> 3;
                case "EMPATE" -> 1;
                default -> 0;
            };

            System.out.printf("Tú:        %s%n", jugador);
            System.out.printf("Ordenador: %s%n", ordenador);
            System.out.printf("Resultado: %s (+%d puntos)%n", resultado, puntos);
            System.out.println(puntos > 0 ? "¡Bien jugado!" : "Otra vez será...");
        }

        teclado.close();
    }
}
