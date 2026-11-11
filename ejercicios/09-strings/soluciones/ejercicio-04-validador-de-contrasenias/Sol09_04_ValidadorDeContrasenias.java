/*
 * TEMA 09 · Ejercicio 04 · Validador de contraseñas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol09_04_ValidadorDeContrasenias.java
 */
import java.util.Scanner;

public class Sol09_04_ValidadorDeContrasenias {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Usuario: ");
        String usuario = teclado.nextLine().strip();

        final int LONGITUD_MINIMA = 8;
        int intentos = 0;
        boolean valida = false;

        do {
            System.out.print("Contraseña: ");
            String contrasenia = teclado.nextLine();      // nextLine: para poder detectar espacios
            intentos++;

            // Un único recorrido activa las banderas de cada tipo de carácter
            boolean tieneMayuscula = false;
            boolean tieneMinuscula = false;
            boolean tieneDigito = false;
            boolean tieneSimbolo = false;
            boolean tieneEspacio = false;
            for (char c : contrasenia.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    tieneMayuscula = true;
                } else if (Character.isLowerCase(c)) {
                    tieneMinuscula = true;
                } else if (Character.isDigit(c)) {
                    tieneDigito = true;
                } else if (Character.isWhitespace(c)) {
                    tieneEspacio = true;
                } else {
                    tieneSimbolo = true;
                }
            }

            // if sueltos: queremos TODAS las reglas que fallen
            StringBuilder errores = new StringBuilder();
            if (contrasenia.length() < LONGITUD_MINIMA) {
                errores.append("  - Debe tener al menos ").append(LONGITUD_MINIMA).append(" caracteres\n");
            }
            if (!tieneMayuscula) {
                errores.append("  - Falta una letra mayúscula\n");
            }
            if (!tieneMinuscula) {
                errores.append("  - Falta una letra minúscula\n");
            }
            if (!tieneDigito) {
                errores.append("  - Falta un número\n");
            }
            if (!tieneSimbolo) {
                errores.append("  - Falta un símbolo\n");
            }
            if (tieneEspacio) {
                errores.append("  - No puede contener espacios\n");
            }
            if (!usuario.isEmpty() && contrasenia.toLowerCase().contains(usuario.toLowerCase())) {
                errores.append("  - No puede contener el nombre de usuario\n");
            }

            valida = errores.length() == 0;
            if (!valida) {
                System.out.println("  Contraseña no válida:");
                System.out.print(errores);                  // Cada mensaje ya termina en \n
            }
        } while (!valida);

        System.out.println("Contraseña válida tras " + intentos + " intentos");

        teclado.close();
    }
}
