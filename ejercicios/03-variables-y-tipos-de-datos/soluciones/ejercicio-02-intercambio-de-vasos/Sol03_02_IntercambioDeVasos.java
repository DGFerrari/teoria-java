/*
 * TEMA 03 · Ejercicio 02 · Intercambio de vasos  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol03_02_IntercambioDeVasos.java
 */
public class Sol03_02_IntercambioDeVasos {

    public static void main(String[] args) {

        // Parte A · Intercambio de dos variables
        String vasoA = "zumo";
        String vasoB = "leche";
        System.out.println("Antes:   vasoA = " + vasoA + " | vasoB = " + vasoB);

        String auxiliar = vasoA;   // El "tercer vaso": guardamos el zumo
        vasoA = vasoB;             // Ahora ya podemos sobrescribir vasoA
        vasoB = auxiliar;          // Recuperamos el zumo

        System.out.println("Después: vasoA = " + vasoA + " | vasoB = " + vasoB);

        // Parte B · Rotación de tres variables
        int x = 1;
        int y = 2;
        int z = 3;
        System.out.println("Antes:   x = " + x + " | y = " + y + " | z = " + z);

        int auxiliarRotacion = x;  // Guardamos el valor que se pierde primero
        x = y;
        y = z;
        z = auxiliarRotacion;

        System.out.println("Después: x = " + x + " | y = " + y + " | z = " + z);
    }
}
