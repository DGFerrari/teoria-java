/*
 * TEMA 06 · Condicionales
 * Ejemplo 03: EL OPERADOR TERNARIO   condición ? valorSiTrue : valorSiFalse
 *
 * Cómo ejecutarlo:  java T06_03_OperadorTernario.java
 */
public class T06_03_OperadorTernario {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Mismo resultado con if-else y con ternario
        // ------------------------------------------------------------
        int edad = 16;

        String tipoConIf;
        if (edad >= 18) {
            tipoConIf = "adulto";
        } else {
            tipoConIf = "menor";
        }

        String tipoConTernario = edad >= 18 ? "adulto" : "menor";

        System.out.println("Con if:       " + tipoConIf);
        System.out.println("Con ternario: " + tipoConTernario);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Usos típicos: elegir UN valor
        // ------------------------------------------------------------
        int a = 12;
        int b = 30;
        int mayor = a > b ? a : b;
        System.out.println("El mayor de " + a + " y " + b + " es " + mayor);

        // Singular o plural
        int mensajes = 1;
        System.out.println("Tienes " + mensajes + (mensajes == 1 ? " mensaje nuevo" : " mensajes nuevos"));
        mensajes = 5;
        System.out.println("Tienes " + mensajes + (mensajes == 1 ? " mensaje nuevo" : " mensajes nuevos"));

        // Precio con descuento
        boolean esSocio = true;
        double precio = 40;
        double precioFinal = esSocio ? precio * 0.9 : precio;
        System.out.println("Precio final: " + precioFinal);

        // Texto en lugar de true/false
        boolean aprobado = false;
        System.out.println("Resultado: " + (aprobado ? "APTO" : "NO APTO"));
        System.out.println();

        // ------------------------------------------------------------
        // 3. Cuándo NO usarlo
        // ------------------------------------------------------------
        // Ternarios encadenados: compilan, pero cuesta leerlos.
        int nota = 7;
        String calificacion = nota >= 9 ? "Sobresaliente" : nota >= 7 ? "Notable" : nota >= 5 ? "Aprobado" : "Suspenso";
        System.out.println("Encadenado (difícil de leer): " + calificacion);
        // Para esto, mejor un else if (ejemplo 02) o un switch.

        // Tampoco sirve para EJECUTAR instrucciones; solo para elegir valores:
        // edad >= 18 ? System.out.println("Sí") : System.out.println("No");   // ❌ No compila

        // PRUEBA: con una variable "temperatura", usa un ternario para mostrar
        //    "Lleva abrigo" si es menor que 15 y "No hace falta abrigo" en caso contrario.
    }
}
