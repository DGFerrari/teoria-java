/*
 * TEMA 03 · Variables y tipos de datos
 * Ejemplo 04: CONSTANTES (final) E INFERENCIA DE TIPOS (var)
 *
 * Cómo ejecutarlo:  java T03_04_ConstantesYVar.java
 */
public class T03_04_ConstantesYVar {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Constantes con final
        // ------------------------------------------------------------
        // Un valor que NO debe cambiar. Nombre en MAYUSCULAS_CON_GUIONES.
        final double IVA = 0.21;
        final int MINUTOS_POR_HORA = 60;

        double precioSinIva = 50.0;
        double precioConIva = precioSinIva + precioSinIva * IVA;
        System.out.println("Precio sin IVA: " + precioSinIva);
        System.out.println("Precio con IVA: " + precioConIva);   // 60.5

        int horasDePelicula = 2;
        System.out.println("Minutos de película: " + horasDePelicula * MINUTOS_POR_HORA);   // 120

        // IVA = 0.10;   // ❌ Error: cannot assign a value to final variable IVA

        // Comparación: ¿qué se entiende mejor?
        //   precioSinIva * 0.21    → ¿qué es 0.21?
        //   precioSinIva * IVA     → está claro
        System.out.println();

        // ------------------------------------------------------------
        // 2. var: Java deduce el tipo por el valor
        // ------------------------------------------------------------
        var edad = 15;              // int
        var altura = 1.72;          // double
        var inicial = 'M';          // char
        var ciudad = "Sevilla";     // String
        var aprobado = true;        // boolean

        System.out.println("edad: " + edad + " | altura: " + altura + " | inicial: " + inicial);
        System.out.println("ciudad: " + ciudad + " | aprobado: " + aprobado);

        // El tipo deducido es FIJO:
        edad = 16;                  // ✅ sigue siendo un int
        // edad = "dieciséis";      // ❌ Error: incompatible types

        // var sin valor no se puede usar: Java no sabría qué tipo poner
        // var misterio;            // ❌ Error: cannot infer type

        System.out.println("Nueva edad: " + edad);

        // PRUEBA: crea una constante VELOCIDAD_LUZ_KM_S = 299_792 y calcula
        //    cuántos km recorre la luz en un minuto.
    }
}
