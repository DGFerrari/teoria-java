/*
 * TEMA 06 · Condicionales
 * Ejemplo 04: switch CLÁSICO (con break)
 *
 * Recuerda: en este repositorio, break solo se usa dentro de un switch.
 *
 * Cómo ejecutarlo:  java T06_04_SwitchClasico.java
 */
public class T06_04_SwitchClasico {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Estructura básica
        // ------------------------------------------------------------
        int dia = 3;

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;                    // Termina el switch
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:                      // Ningún case coincide
                System.out.println("Día no válido");
                break;
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. Fall-through: sin break, la ejecución "cae" al siguiente case
        // ------------------------------------------------------------
        int nivel = 1;
        System.out.println("Ventajas desbloqueadas con nivel " + nivel + ":");
        switch (nivel) {
            case 3:
                System.out.println("  - Skin dorada");
            case 2:
                System.out.println("  - Doble experiencia");
            case 1:
                System.out.println("  - Acceso al chat");
                break;
            default:
                System.out.println("  - Ninguna");
                break;
        }
        // Con nivel 3 se mostrarían las tres ventajas; con nivel 1, solo la última.
        // Usar el fall-through así es poco habitual: casi siempre es un despiste.
        System.out.println();

        // ------------------------------------------------------------
        // 3. Agrupar casos (el uso "bueno" del fall-through)
        // ------------------------------------------------------------
        int mes = 8;

        switch (mes) {
            case 12:
            case 1:
            case 2:
                System.out.println("Mes " + mes + ": invierno");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Mes " + mes + ": primavera");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Mes " + mes + ": verano");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Mes " + mes + ": otoño");
                break;
            default:
                System.out.println("Mes no válido");
                break;
        }
        System.out.println();

        // ------------------------------------------------------------
        // 4. switch con char
        // ------------------------------------------------------------
        char opcion = 'b';

        switch (opcion) {
            case 'a':
            case 'A':
                System.out.println("Has elegido: nueva partida");
                break;
            case 'b':
            case 'B':
                System.out.println("Has elegido: cargar partida");
                break;
            default:
                System.out.println("Opción desconocida");
                break;
        }

        // PRUEBA: borra el break del "case 3" del primer switch y ejecuta. ¿Qué sale?
    }
}
