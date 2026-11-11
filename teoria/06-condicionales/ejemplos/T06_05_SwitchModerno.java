/*
 * TEMA 06 · Condicionales
 * Ejemplo 05: switch MODERNO (->), switch COMO EXPRESIÓN y yield
 *
 * Cómo ejecutarlo:  java T06_05_SwitchModerno.java
 */
public class T06_05_SwitchModerno {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Con flechas: sin break y sin fall-through
        // ------------------------------------------------------------
        int dia = 6;

        switch (dia) {
            case 1, 2, 3, 4, 5 -> System.out.println("Día " + dia + ": laborable");
            case 6, 7 -> System.out.println("Día " + dia + ": fin de semana");
            default -> System.out.println("Día no válido");
        }

        // Varias instrucciones en un caso: entre llaves
        switch (dia) {
            case 6, 7 -> {
                System.out.println("  Hoy no hay clase.");
                System.out.println("  ¡Aprovecha para practicar Java!");
            }
            default -> System.out.println("  Hoy toca clase.");
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. switch como EXPRESIÓN: devuelve un valor
        // ------------------------------------------------------------
        String nombreDia = switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Desconocido";   // Obligatorio: hay que cubrir todos los int posibles
        };                              // ← punto y coma: es una asignación
        System.out.println("El día " + dia + " es " + nombreDia);

        // También directamente dentro de un cálculo
        int horasDeClase = switch (dia) {
            case 1, 3 -> 6;
            case 2, 4 -> 5;
            case 5 -> 4;
            default -> 0;
        };
        System.out.println("Horas de clase el " + nombreDia + ": " + horasDeClase);
        System.out.println();

        // ------------------------------------------------------------
        // 3. yield: cuando un caso necesita varias instrucciones para dar su valor
        // ------------------------------------------------------------
        int mes = 2;
        int anio = 2024;

        int diasDelMes = switch (mes) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                boolean bisiesto = (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
                yield bisiesto ? 29 : 28;   // yield entrega el valor de este caso
            }
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            default -> -1;                  // Mes no válido
        };
        System.out.println("El mes " + mes + " de " + anio + " tiene " + diasDelMes + " días");
        System.out.println();

        // ------------------------------------------------------------
        // 4. switch con String (compara el CONTENIDO del texto)
        // ------------------------------------------------------------
        String comando = "ayuda";

        String respuesta = switch (comando) {
            case "jugar" -> "Empezando partida...";
            case "ayuda" -> "Comandos disponibles: jugar, ayuda, salir";
            case "salir" -> "¡Hasta pronto!";
            default -> "Comando desconocido: " + comando;
        };
        System.out.println(respuesta);

        // Ojo: distingue mayúsculas. "AYUDA" iría al default.
        // Para evitarlo: switch (comando.toLowerCase()) { ... }

        // PRUEBA: añade el comando "puntos" que devuelva "Tienes 0 puntos".
    }
}
