/*
 * TEMA 09 · Strings
 * Ejemplo 02: MÉTODOS PRINCIPALES DE String
 *
 * Cómo ejecutarlo:  java T09_02_MetodosDeString.java
 */
public class T09_02_MetodosDeString {

    public static void main(String[] args) {

        String t = "Programar en Java";
        //          01234567890123456

        // ------------------------------------------------------------
        // 1. Información
        // ------------------------------------------------------------
        System.out.println("Texto: \"" + t + "\"");
        System.out.println("length()             → " + t.length());             // 17
        System.out.println("charAt(0)            → " + t.charAt(0));            // P
        System.out.println("charAt(length()-1)   → " + t.charAt(t.length() - 1)); // a
        System.out.println("indexOf(\"a\")         → " + t.indexOf("a"));        // 5
        System.out.println("lastIndexOf(\"a\")     → " + t.lastIndexOf("a"));    // 16
        System.out.println("indexOf(\"Java\")      → " + t.indexOf("Java"));     // 13
        System.out.println("indexOf(\"Python\")    → " + t.indexOf("Python"));   // -1: no está
        System.out.println("indexOf(\"a\", 6)      → " + t.indexOf("a", 6));     // 7: busca desde la posición 6
        System.out.println("contains(\"en\")       → " + t.contains("en"));      // true
        System.out.println("startsWith(\"Pro\")    → " + t.startsWith("Pro"));   // true
        System.out.println("endsWith(\".java\")    → " + t.endsWith(".java"));   // false
        System.out.println();

        // ------------------------------------------------------------
        // 2. substring: el "hasta" NO se incluye
        // ------------------------------------------------------------
        System.out.println("substring(13)        → " + t.substring(13));        // Java
        System.out.println("substring(0, 9)      → " + t.substring(0, 9));      // Programar
        System.out.println("substring(3, 6)      → " + t.substring(3, 6));      // gra (6 - 3 = 3 letras)

        // Combinando indexOf y substring: separar usuario y dominio de un correo
        String correo = "ana.lopez@ejemplo.com";
        int arroba = correo.indexOf("@");
        String usuario = correo.substring(0, arroba);
        String dominio = correo.substring(arroba + 1);
        System.out.println("Usuario: " + usuario + " | Dominio: " + dominio);
        System.out.println();

        // ------------------------------------------------------------
        // 3. Transformaciones (devuelven un String nuevo)
        // ------------------------------------------------------------
        System.out.println("toUpperCase()        → " + t.toUpperCase());
        System.out.println("toLowerCase()        → " + t.toLowerCase());
        System.out.println("replace(\"a\", \"4\")    → " + t.replace("a", "4"));
        System.out.println("replace(' ', '_')    → " + t.replace(' ', '_'));
        System.out.println("\"ja\".repeat(3)       → " + "ja".repeat(3));
        System.out.println("[\"  hola  \".strip()] → [" + "  hola  ".strip() + "]");
        System.out.println();

        // ------------------------------------------------------------
        // 4. Encadenar métodos
        // ------------------------------------------------------------
        String entrada = "   Hola Mundo De Java   ";
        String slug = entrada.strip().toLowerCase().replace(" ", "-");
        System.out.println("Encadenado: \"" + entrada + "\" → \"" + slug + "\"");

        // Poner la primera letra en mayúscula y el resto en minúscula
        String nombre = "mARTA";
        String capitalizado = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
        System.out.println("Capitalizar \"" + nombre + "\" → \"" + capitalizado + "\"");
        System.out.println();

        // ------------------------------------------------------------
        // 5. Conversiones
        // ------------------------------------------------------------
        String desdeNumero = String.valueOf(3.75);
        char[] letras = "Hola".toCharArray();
        String desdeChars = new String(letras);
        System.out.println("String.valueOf(3.75) → " + desdeNumero + " (longitud " + desdeNumero.length() + ")");
        System.out.println("toCharArray() tiene " + letras.length + " elementos; de vuelta: " + desdeChars);

        // Contar cuántas veces aparece una letra con indexOf en un bucle
        String frase = "la casa de la playa";
        int veces = 0;
        int posicion = frase.indexOf("a");
        while (posicion != -1) {
            veces++;
            posicion = frase.indexOf("a", posicion + 1);   // Sigue buscando después de la última
        }
        System.out.println("La 'a' aparece " + veces + " veces en \"" + frase + "\"");

        // PRUEBA: a partir de "Martínez García, Ana", obtén "Ana Martínez García"
        //    usando indexOf(",") y substring.
    }
}
