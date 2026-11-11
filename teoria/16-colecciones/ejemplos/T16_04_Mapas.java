/*
 * TEMA 16 · Colecciones
 * Ejemplo 04: mapas (Map) - pares clave → valor
 *
 * Cómo ejecutarlo:  java T16_04_Mapas.java
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class T16_04_Mapas {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Operaciones básicas
        // ------------------------------------------------------------
        Map<String, String> capitales = new HashMap<>();
        capitales.put("España", "Madrid");
        capitales.put("Francia", "París");
        capitales.put("Italia", "Milán");
        capitales.put("Italia", "Roma");                 // Misma clave: sustituye el valor

        System.out.println("1. Capital de Italia: " + capitales.get("Italia"));
        System.out.println("   Capital de Japón: " + capitales.get("Japón") + " (no existe)");
        System.out.println("   Con valor por defecto: " + capitales.getOrDefault("Japón", "desconocida"));
        System.out.println("   ¿Está Francia? " + capitales.containsKey("Francia"));
        System.out.println("   ¿Hay alguna capital llamada Roma? " + capitales.containsValue("Roma"));
        capitales.remove("Francia");
        System.out.println("   Tras borrar Francia hay " + capitales.size() + " países");
        System.out.println();

        // ------------------------------------------------------------
        // 2. El patrón contador
        // ------------------------------------------------------------
        String texto = "el perro y el gato y el loro";
        Map<String, Integer> contador = new TreeMap<>();  // TreeMap: claves ordenadas
        for (String palabra : texto.split(" ")) {
            contador.put(palabra, contador.getOrDefault(palabra, 0) + 1);
        }
        System.out.println("2. Frecuencias: " + contador);
        System.out.println();

        // ------------------------------------------------------------
        // 3. Recorrer: claves, valores y pares
        // ------------------------------------------------------------
        Map<String, Double> precios = new LinkedHashMap<>();   // Conserva el orden de inserción
        precios.put("café", 1.40);
        precios.put("tostada", 2.10);
        precios.put("zumo", 2.75);

        System.out.println("3. Claves: " + precios.keySet());
        System.out.println("   Valores: " + precios.values());
        double total = 0;
        for (Map.Entry<String, Double> par : precios.entrySet()) {
            System.out.printf("   %-8s %5.2f €%n", par.getKey(), par.getValue());
            total += par.getValue();
        }
        System.out.printf("   Desayuno completo: %.2f €%n", total);
        System.out.println();

        // ------------------------------------------------------------
        // 4. Cambiar un valor a partir del anterior
        // ------------------------------------------------------------
        Map<String, Integer> stock = new TreeMap<>(Map.of("lápices", 50, "gomas", 20));
        stock.put("lápices", stock.get("lápices") - 12);       // Se venden 12
        System.out.println("4. Stock tras la venta: " + stock);
        System.out.println();

        // ------------------------------------------------------------
        // 5. Un mapa de listas: alumnos agrupados por curso
        // ------------------------------------------------------------
        String[][] alumnos = {{"Ana", "1ºA"}, {"Luis", "1ºB"}, {"Marta", "1ºA"}, {"Pablo", "2ºA"}, {"Sara", "1ºB"}};
        Map<String, List<String>> porCurso = new TreeMap<>();
        for (String[] alumno : alumnos) {
            String nombre = alumno[0];
            String curso = alumno[1];
            if (!porCurso.containsKey(curso)) {
                porCurso.put(curso, new ArrayList<>());       // Primera vez: se crea su lista
            }
            porCurso.get(curso).add(nombre);
        }
        System.out.println("5. Por curso:");
        for (String curso : porCurso.keySet()) {
            List<String> lista = porCurso.get(curso);
            System.out.println("   " + curso + " (" + lista.size() + "): " + lista);
        }
        System.out.println();

        // ------------------------------------------------------------
        // 6. ⚠️ Unboxing de null
        // ------------------------------------------------------------
        try {
            int cantidad = stock.get("rotuladores");          // get devuelve null → no cabe en un int
            System.out.println(cantidad);
        } catch (NullPointerException e) {
            System.out.println("6. 💥 NullPointerException: la clave no existe y null no se puede convertir a int");
        }
    }
}
