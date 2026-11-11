/*
 * TEMA 03 · Ejercicio 04 · Detective de tipos  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol03_04_DetectiveDeTipos.java
 */
public class Sol03_04_DetectiveDeTipos {

    public static void main(String[] args) {

        // Caso A · El resultado no cabe en int (desbordamiento).
        // Con 100L toda la multiplicación se hace en long desde el principio.
        long segundosSiglo = 100L * 365 * 24 * 60 * 60;
        System.out.println("A) Segundos en un siglo: " + segundosSiglo);

        // Caso B · int / int es división entera. Dividimos entre 3.0
        // y guardamos en double.
        int nota1 = 7;
        int nota2 = 8;
        int nota3 = 8;
        int suma = nota1 + nota2 + nota3;
        double media = suma / 3.0;
        System.out.println("B) Media de las notas: " + media);

        // Caso C · char + int da int. El casting (char) lo devuelve a carácter.
        char letra = 'm';
        System.out.println("C) Letra siguiente a " + letra + ": " + (char) (letra + 1));

        // Caso D · String + String concatena. Hay que convertir a número antes.
        String textoA = "25";
        String textoB = "17";
        int numeroA = Integer.parseInt(textoA);
        int numeroB = Integer.parseInt(textoB);
        System.out.println("D) " + numeroA + " + " + numeroB + " = " + (numeroA + numeroB));

        // Caso E · (int) corta los decimales; Math.round redondea (y devuelve long).
        double precio = 19.99;
        long redondeado = Math.round(precio);
        System.out.println("E) " + precio + " redondeado: " + redondeado);
    }
}
