/*
 * TEMA 07 · Ejercicio 05 · Calculadora con menú  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol07_05_CalculadoraConMenu.java
 */
import java.util.Scanner;

public class Sol07_05_CalculadoraConMenu {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int operaciones = 0;
        int errores = 0;
        int opcionesNoValidas = 0;
        double sumaResultados = 0;
        double maximo = 0;

        int opcion;     // Fuera del do: se usa en la condición del while

        do {
            System.out.println();
            System.out.println("===== CALCULADORA =====");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Salir");

            // Leer la opción validando que sea un int
            System.out.print("Opción: ");
            while (!teclado.hasNextInt()) {
                System.out.print("  '" + teclado.next() + "' no es una opción. Otra vez: ");
            }
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1, 2, 3, 4 -> {
                    System.out.print("Primer número: ");
                    while (!teclado.hasNextDouble()) {
                        System.out.print("  '" + teclado.next() + "' no es un número válido. Otra vez: ");
                    }
                    double a = teclado.nextDouble();

                    System.out.print("Segundo número: ");
                    while (!teclado.hasNextDouble()) {
                        System.out.print("  '" + teclado.next() + "' no es un número válido. Otra vez: ");
                    }
                    double b = teclado.nextDouble();

                    boolean divisionPorCero = opcion == 4 && b == 0;
                    if (divisionPorCero) {
                        System.out.println("Error: no se puede dividir entre 0");
                        errores++;
                    } else {
                        double resultado = switch (opcion) {
                            case 1 -> a + b;
                            case 2 -> a - b;
                            case 3 -> a * b;
                            default -> a / b;       // Solo puede ser 4
                        };
                        System.out.printf("Resultado: %.2f%n", resultado);

                        // Máximo: el primer resultado se guarda sin comparar
                        if (operaciones == 0 || resultado > maximo) {
                            maximo = resultado;
                        }
                        operaciones++;
                        sumaResultados += resultado;
                    }
                }
                case 0 -> System.out.println();     // Nada más: el do-while terminará solo
                default -> {
                    System.out.println("Opción no válida");
                    opcionesNoValidas++;
                }
            }
        } while (opcion != 0);

        // Estadísticas
        System.out.println("===== ESTADÍSTICAS =====");
        System.out.println("Operaciones realizadas: " + operaciones);
        System.out.println("Errores: " + errores);
        System.out.println("Opciones no válidas: " + opcionesNoValidas);
        System.out.printf("Suma de resultados: %.2f%n", sumaResultados);
        if (operaciones > 0) {
            System.out.printf("Resultado más alto: %.2f%n", maximo);
            System.out.printf("Media de resultados: %.2f%n", sumaResultados / operaciones);
        } else {
            System.out.println("No se ha realizado ninguna operación");
        }
        System.out.println("¡Hasta pronto!");

        teclado.close();
    }
}
