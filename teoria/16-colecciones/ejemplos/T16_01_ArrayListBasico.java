/*
 * TEMA 16 · Colecciones
 * Ejemplo 01: ArrayList, clases envoltorio y autoboxing
 *
 * Cómo ejecutarlo:  java T16_01_ArrayListBasico.java
 */
import java.util.ArrayList;
import java.util.List;

public class T16_01_ArrayListBasico {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Crear una lista y añadir elementos: crece sola
        // ------------------------------------------------------------
        List<String> compra = new ArrayList<>();      // Variable de tipo interfaz, objeto de la clase
        System.out.println("1. Lista nueva: " + compra + " (vacía: " + compra.isEmpty() + ")");
        compra.add("pan");
        compra.add("leche");
        compra.add("tomates");
        compra.add(0, "huevos");                      // Inserta al principio y desplaza el resto
        System.out.println("   Tras añadir: " + compra + " → " + compra.size() + " elementos");
        System.out.println();

        // ------------------------------------------------------------
        // 2. Leer, modificar y buscar
        // ------------------------------------------------------------
        System.out.println("2. Posición 1: " + compra.get(1));
        compra.set(1, "pan integral");                // Sustituye
        System.out.println("   Tras set(1, ...): " + compra);
        System.out.println("   ¿Hay leche? " + compra.contains("leche"));
        System.out.println("   ¿En qué posición? " + compra.indexOf("leche"));
        System.out.println("   ¿Y el chocolate? " + compra.indexOf("chocolate") + " (no está)");
        System.out.println();

        // ------------------------------------------------------------
        // 3. Borrar por posición y por valor
        // ------------------------------------------------------------
        String quitado = compra.remove(0);            // Devuelve el elemento borrado
        System.out.println("3. Borrado por posición: " + quitado + " → " + compra);
        boolean borrado = compra.remove("leche");     // Devuelve si lo ha encontrado
        System.out.println("   ¿Borrada la leche? " + borrado + " → " + compra);
        System.out.println("   ¿Borrado el chocolate? " + compra.remove("chocolate"));
        System.out.println();

        // ------------------------------------------------------------
        // 4. Envoltorios y autoboxing: List<Integer>, nunca List<int>
        // ------------------------------------------------------------
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);                              // autoboxing: int → Integer
        numeros.add(20);
        numeros.add(30);
        int suma = 0;
        for (int n : numeros) {                       // unboxing: Integer → int
            suma += n;
        }
        System.out.println("4. " + numeros + " suman " + suma);

        // ⚠️ remove(int) borra por POSICIÓN; remove(Object) borra por VALOR
        numeros.remove(1);                            // Posición 1 (el 20)
        System.out.println("   remove(1): " + numeros);
        numeros.remove(Integer.valueOf(30));          // El valor 30
        System.out.println("   remove(Integer.valueOf(30)): " + numeros);
        System.out.println();

        // ------------------------------------------------------------
        // 5. Comparar envoltorios: equals, no ==
        // ------------------------------------------------------------
        Integer a = 1000;
        Integer b = 1000;
        Integer c = 100;
        Integer d = 100;
        System.out.println("5. 1000 == 1000 → " + (a == b) + "   (son objetos distintos)");
        System.out.println("   1000 equals 1000 → " + a.equals(b));
        System.out.println("   100 == 100 → " + (c == d) + "   (funciona por casualidad: caché de -128 a 127)");
        System.out.println();

        // ------------------------------------------------------------
        // 6. Añadir otra colección y vaciar
        // ------------------------------------------------------------
        List<String> mas = List.of("café", "arroz");
        compra.addAll(mas);
        System.out.println("6. Con addAll: " + compra);
        compra.clear();
        System.out.println("   Tras clear: " + compra + " (" + compra.size() + " elementos)");
    }
}
