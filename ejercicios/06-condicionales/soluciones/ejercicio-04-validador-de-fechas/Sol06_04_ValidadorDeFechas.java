/*
 * TEMA 06 · Ejercicio 04 · Validador de fechas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol06_04_ValidadorDeFechas.java
 */
import java.util.Scanner;

public class Sol06_04_ValidadorDeFechas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Día: ");
        int dia = teclado.nextInt();
        System.out.print("Mes: ");
        int mes = teclado.nextInt();
        System.out.print("Año: ");
        int anio = teclado.nextInt();

        // 1. Días del mes (0 si el mes no existe)
        int diasDelMes = switch (mes) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                boolean bisiesto = (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
                yield bisiesto ? 29 : 28;
            }
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            default -> 0;
        };

        // 2. Validez
        boolean esValida = anio > 0 && mes >= 1 && mes <= 12 && dia >= 1 && dia <= diasDelMes;

        if (esValida) {
            // 3a. Fecha con ceros a la izquierda
            System.out.printf("Fecha: %02d/%02d/%04d%n", dia, mes, anio);

            // 3b. ¿Último día del mes?
            boolean esFinDeMes = dia == diasDelMes;
            System.out.println("¿Último día del mes? " + esFinDeMes);

            // 3c. Día siguiente: partimos de la misma fecha y cambiamos lo necesario
            int diaSiguiente = dia + 1;
            int mesSiguiente = mes;
            int anioSiguiente = anio;

            if (esFinDeMes) {
                diaSiguiente = 1;
                if (mes < 12) {
                    mesSiguiente = mes + 1;
                } else {
                    mesSiguiente = 1;           // 31 de diciembre → 1 de enero
                    anioSiguiente = anio + 1;
                }
            }
            System.out.printf("Día siguiente: %02d/%02d/%04d%n", diaSiguiente, mesSiguiente, anioSiguiente);
        } else {
            System.out.println("Fecha no válida");
        }

        teclado.close();
    }
}
