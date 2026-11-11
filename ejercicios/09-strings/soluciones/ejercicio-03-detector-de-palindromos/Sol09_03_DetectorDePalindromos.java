/*
 * TEMA 09 · Ejercicio 03 · Detector de palíndromos  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol09_03_DetectorDePalindromos.java
 */
import java.util.Scanner;

public class Sol09_03_DetectorDePalindromos {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Escribe una frase: ");
        String frase = teclado.nextLine();

        // 1. Minúsculas y sin tildes (cada replace devuelve un String nuevo)
        String sinTildes = frase.toLowerCase()
                .replace('á', 'a').replace('é', 'e').replace('í', 'i')
                .replace('ó', 'o').replace('ú', 'u').replace('ü', 'u');

        // 2. Solo letras y dígitos
        StringBuilder limpia = new StringBuilder();
        for (char c : sinTildes.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                limpia.append(c);
            }
        }
        String normalizada = limpia.toString();

        // 3. Al revés
        String alReves = new StringBuilder(normalizada).reverse().toString();

        System.out.println("Normalizada: " + normalizada);
        System.out.println("Al revés:    " + alReves);

        // 4. Primera forma: comparar los dos textos
        System.out.println("¿Es palíndromo? (con StringBuilder) " + normalizada.equals(alReves));

        // 5. Segunda forma: extremos hacia el centro, parando en la primera diferencia
        int izquierda = 0;
        int derecha = normalizada.length() - 1;
        boolean coinciden = true;
        while (izquierda < derecha && coinciden) {
            if (normalizada.charAt(izquierda) != normalizada.charAt(derecha)) {   // char: != es correcto
                coinciden = false;
            }
            izquierda++;
            derecha--;
        }
        System.out.println("¿Es palíndromo? (extremos al centro) " + coinciden);

        teclado.close();
    }
}
