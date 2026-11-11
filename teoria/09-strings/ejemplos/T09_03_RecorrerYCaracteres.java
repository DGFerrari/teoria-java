/*
 * TEMA 09 · Strings
 * Ejemplo 03: RECORRER TEXTOS, CÓDIGOS DE CARÁCTER Y LA CLASE Character
 *
 * Cómo ejecutarlo:  java T09_03_RecorrerYCaracteres.java
 */
public class T09_03_RecorrerYCaracteres {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Recorrer con for + charAt
        // ------------------------------------------------------------
        String palabra = "Java";
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            System.out.println("Posición " + i + ": '" + c + "' (código " + (int) c + ")");
        }
        System.out.println();

        // Al revés
        System.out.print("Al revés: ");
        for (int i = palabra.length() - 1; i >= 0; i--) {
            System.out.print(palabra.charAt(i));
        }
        System.out.println();
        System.out.println();

        // ------------------------------------------------------------
        // 2. Analizar una frase con la clase Character
        // ------------------------------------------------------------
        String frase = "¡Hola! Tengo 15 años y vivo en Málaga.";
        int letras = 0;
        int mayusculas = 0;
        int digitos = 0;
        int espacios = 0;
        int vocales = 0;
        int otros = 0;

        for (char c : frase.toCharArray()) {             // for-each sobre los caracteres
            if (Character.isLetter(c)) {
                letras++;
                if (Character.isUpperCase(c)) {
                    mayusculas++;
                }
                // ¿Está c en la lista de vocales? (en minúscula para no repetir)
                if ("aeiouáéíóúü".indexOf(Character.toLowerCase(c)) != -1) {
                    vocales++;
                }
            } else if (Character.isDigit(c)) {
                digitos++;
            } else if (Character.isWhitespace(c)) {
                espacios++;
            } else {
                otros++;
            }
        }
        System.out.println("Frase: " + frase);
        System.out.println("Letras: " + letras + " (mayúsculas: " + mayusculas + ", vocales: " + vocales + ")");
        System.out.println("Dígitos: " + digitos + " | Espacios: " + espacios + " | Otros: " + otros);
        System.out.println();

        // ------------------------------------------------------------
        // 3. Aritmética con char
        // ------------------------------------------------------------
        char letra = 'C';
        System.out.println("'" + letra + "' es la letra número " + (letra - 'A' + 1) + " del alfabeto inglés");
        System.out.println("Su minúscula: " + (char) (letra + 32) + " | Con Character: " + Character.toLowerCase(letra));

        String numeroTexto = "2048";
        int sumaCifras = 0;
        for (int i = 0; i < numeroTexto.length(); i++) {
            sumaCifras += numeroTexto.charAt(i) - '0';   // '2' - '0' = 2
        }
        System.out.println("La suma de las cifras de \"" + numeroTexto + "\" es " + sumaCifras);   // 14
        System.out.println();

        // Una pequeña tabla de códigos
        System.out.print("Códigos de 'a' a 'f': ");
        for (char c = 'a'; c <= 'f'; c++) {
            System.out.print(c + "=" + (int) c + " ");
        }
        System.out.println();
        System.out.println();

        // ------------------------------------------------------------
        // 4. Cifrado César: desplazar cada letra N posiciones
        // ------------------------------------------------------------
        String mensaje = "ATAQUE AL AMANECER";
        int desplazamiento = 3;
        String cifrado = "";
        for (char c : mensaje.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // Posición 0-25, desplazamos, volvemos al principio con % 26 y convertimos a letra
                char nueva = (char) ('A' + (c - 'A' + desplazamiento) % 26);
                cifrado += nueva;
            } else {
                cifrado += c;                            // Los espacios se dejan igual
            }
        }
        System.out.println("Original: " + mensaje);
        System.out.println("Cifrado:  " + cifrado);       // DWDTXH DO DPDQHFHU
        // (Aquí usamos += con String porque el texto es corto; en el ejemplo 05 verás StringBuilder.)

        // PRUEBA: escribe el descifrado (desplazar -3). Cuidado con el % y los negativos:
        //    usa (c - 'A' - desplazamiento + 26) % 26.
    }
}
