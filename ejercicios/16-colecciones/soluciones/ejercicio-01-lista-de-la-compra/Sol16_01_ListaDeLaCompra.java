/*
 * TEMA 16 · Ejercicio 01 · Lista de la compra  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol16_01_ListaDeLaCompra.java
 */
import java.util.ArrayList;
import java.util.List;

public class Sol16_01_ListaDeLaCompra {

    public static void main(String[] args) {
        // 1. Crear la lista y añadir (los duplicados están permitidos en una List)
        List<String> compra = new ArrayList<>();
        compra.add("leche");
        compra.add("pan");
        compra.add("huevos");
        compra.add("manzanas");
        compra.add("pan");
        System.out.println("Lista: " + compra + " (" + compra.size() + " productos)");

        // 2. Insertar al principio
        compra.add(0, "café");
        System.out.println("Con café al principio: " + compra);

        // 3. Sustituir: primero se busca la posición, después se cambia
        int posicion = compra.indexOf("manzanas");
        if (posicion != -1) {
            compra.set(posicion, "peras");
        }
        System.out.println("Cambio manzanas por peras: " + compra);

        // 4. remove(Object) borra solo la PRIMERA aparición
        compra.remove("pan");
        System.out.println("Quito un pan: " + compra);

        // 5. Buscar
        System.out.println("¿Hay huevos? " + compra.contains("huevos"));
        System.out.println("¿Hay chocolate? " + compra.contains("chocolate"));

        // 6. Lista numerada: for con índice porque necesitamos la posición
        System.out.println("=== Lista final ===");
        for (int i = 0; i < compra.size(); i++) {
            System.out.println((i + 1) + ". " + compra.get(i));
        }
    }
}
