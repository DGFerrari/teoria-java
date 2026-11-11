/*
 * TEMA 09 · Strings
 * Ejemplo 01: CREAR, INMUTABILIDAD Y COMPARAR
 *
 * Cómo ejecutarlo:  java T09_01_CrearYComparar.java
 */
public class T09_01_CrearYComparar {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Crear textos
        // ------------------------------------------------------------
        String saludo = "Hola";
        String vacio = "";
        String nulo = null;

        System.out.println("saludo tiene " + saludo.length() + " caracteres");
        System.out.println("vacio tiene " + vacio.length() + " caracteres (¿vacío? " + vacio.isEmpty() + ")");
        System.out.println("nulo vale " + nulo);
        // System.out.println(nulo.length());   // ❌ NullPointerException: no hay texto
        System.out.println();

        // ------------------------------------------------------------
        // 2. Inmutabilidad: los métodos devuelven un String NUEVO
        // ------------------------------------------------------------
        String nombre = "  lucía  ";
        nombre.strip();                          // Crea "lucía"... y se pierde
        nombre.toUpperCase();                    // Igual
        System.out.println("Sin guardar: [" + nombre + "]");

        nombre = nombre.strip().toUpperCase();   // Ahora sí lo guardamos
        System.out.println("Guardando:   [" + nombre + "]");
        System.out.println();

        // ------------------------------------------------------------
        // 3. == frente a equals
        // ------------------------------------------------------------
        String a = "java";
        String b = "java";                       // Mismo literal → Java reutiliza el objeto
        String c = new String("java");           // Objeto nuevo, mismo texto
        String d = "ja" + "va".toLowerCase();    // Calculado en ejecución → objeto nuevo

        System.out.println("a == b       → " + (a == b));        // true (casualidad del pool)
        System.out.println("a == c       → " + (a == c));        // false
        System.out.println("a == d       → " + (a == d));        // false
        System.out.println("a.equals(c)  → " + a.equals(c));     // true ✅
        System.out.println("a.equals(d)  → " + a.equals(d));     // true ✅
        System.out.println();

        // equalsIgnoreCase: sin distinguir mayúsculas
        String respuesta = "SI";
        System.out.println("¿\"SI\" es \"si\"? equals: " + respuesta.equals("si")
                + " | equalsIgnoreCase: " + respuesta.equalsIgnoreCase("si"));

        // Truco contra null: el literal delante
        String respuestaNula = null;
        System.out.println("\"si\".equals(null) → " + "si".equals(respuestaNula));   // false, sin error
        System.out.println();

        // ------------------------------------------------------------
        // 4. compareTo: orden alfabético
        // ------------------------------------------------------------
        System.out.println("\"ana\".compareTo(\"luis\") = " + "ana".compareTo("luis"));   // Negativo: ana va antes
        System.out.println("\"luis\".compareTo(\"ana\") = " + "luis".compareTo("ana"));   // Positivo: luis va después
        System.out.println("\"ana\".compareTo(\"ana\")  = " + "ana".compareTo("ana"));    // 0: iguales

        // Mayúsculas antes que minúsculas (por sus códigos): 'Z' = 90, 'a' = 97
        System.out.println("\"Zebra\".compareTo(\"abeja\") = " + "Zebra".compareTo("abeja"));
        System.out.println("Ignorando mayúsculas: " + "Zebra".compareToIgnoreCase("abeja"));

        String primero = "pera";
        String segundo = "manzana";
        if (primero.compareTo(segundo) < 0) {
            System.out.println(primero + " va antes que " + segundo);
        } else {
            System.out.println(segundo + " va antes que " + primero);
        }
        System.out.println();

        // ------------------------------------------------------------
        // 5. isEmpty frente a isBlank
        // ------------------------------------------------------------
        String espacios = "   ";
        System.out.println("\"   \".isEmpty() → " + espacios.isEmpty());   // false: tiene 3 caracteres
        System.out.println("\"   \".isBlank() → " + espacios.isBlank());   // true: solo hay espacios

        // PRUEBA: crea dos String con tu nombre, uno en mayúsculas y otro en minúsculas,
        //    y compáralos con equals y con equalsIgnoreCase.
    }
}
