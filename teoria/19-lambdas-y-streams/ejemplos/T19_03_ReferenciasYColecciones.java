/*
 * TEMA 19 · Lambdas y streams
 * Ejemplo 03: referencias a métodos, lambdas con colecciones y Comparator
 *
 * Cómo ejecutarlo:  java T19_03_ReferenciasYColecciones.java
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;

public class T19_03_ReferenciasYColecciones {

    record Alumno(String nombre, int edad, double nota) { }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Referencias a métodos: cuando la lambda solo llama a un método
        // ------------------------------------------------------------
        Function<String, Integer> aNumero = Integer::parseInt;          // s -> Integer.parseInt(s)
        Function<String, String> mayusculas = String::toUpperCase;      // s -> s.toUpperCase()
        Supplier<List<String>> nuevaLista = ArrayList::new;             // () -> new ArrayList<>()
        System.out.println("1. \"42\" → " + (aNumero.apply("42") + 1));
        System.out.println("   \"java\" → " + mayusculas.apply("java"));
        System.out.println("   Lista nueva: " + nuevaLista.get());
        System.out.print("   Con System.out::println:");
        System.out.println();
        List.of("uno", "dos").forEach(System.out::println);             // s -> System.out.println(s)
        System.out.println();

        // ------------------------------------------------------------
        // 2. Listas: forEach, removeIf, replaceAll
        // ------------------------------------------------------------
        List<Integer> notas = new ArrayList<>(List.of(7, 3, 9, 4, 5, 2, 8));
        notas.removeIf(n -> n < 5);                                      // Sin Iterator (tema 16)
        System.out.println("2. Aprobados: " + notas);
        notas.replaceAll(n -> Math.min(n + 1, 10));                      // Un punto extra a todos
        System.out.println("   Con un punto extra: " + notas);
        System.out.print("   forEach:");
        notas.forEach(n -> System.out.print(" [" + n + "]"));
        System.out.println();
        System.out.println();

        // ------------------------------------------------------------
        // 3. Mapas: merge, computeIfAbsent y forEach
        // ------------------------------------------------------------
        String texto = "el gato y el perro y el loro";
        Map<String, Integer> contador = new TreeMap<>();
        for (String palabra : texto.split(" ")) {
            contador.merge(palabra, 1, Integer::sum);                    // Si no está: 1; si está: suma 1
        }
        System.out.println("3. Contador con merge: " + contador);

        Map<Integer, List<String>> porLongitud = new TreeMap<>();
        for (String palabra : texto.split(" ")) {
            porLongitud.computeIfAbsent(palabra.length(), k -> new ArrayList<>()).add(palabra);
        }
        System.out.println("   Agrupadas por longitud: " + porLongitud);
        System.out.print("   forEach de un mapa:");
        contador.forEach((palabra, veces) -> System.out.print(" " + palabra + "×" + veces));
        System.out.println();
        System.out.println();

        // ------------------------------------------------------------
        // 4. Comparator: varios criterios de orden sin tocar la clase
        // ------------------------------------------------------------
        List<Alumno> clase = new ArrayList<>(List.of(
                new Alumno("Marta", 16, 8.5), new Alumno("Luis", 15, 6.0),
                new Alumno("Ana", 16, 9.0), new Alumno("Pablo", 15, 8.5)));

        clase.sort(Comparator.comparing(Alumno::nombre));
        System.out.println("4. Por nombre: " + nombres(clase));

        clase.sort(Comparator.comparingDouble(Alumno::nota).reversed());
        System.out.println("   Por nota (de mayor a menor): " + nombres(clase));

        clase.sort(Comparator.comparingInt(Alumno::edad).thenComparing(Alumno::nombre));
        System.out.println("   Por edad y luego por nombre: " + nombres(clase));

        clase.sort(Comparator.comparingDouble(Alumno::nota).reversed().thenComparing(Alumno::edad));
        System.out.println("   Por nota y, si empatan, el más joven: " + nombres(clase));
    }

    static List<String> nombres(List<Alumno> alumnos) {
        List<String> resultado = new ArrayList<>();
        alumnos.forEach(a -> resultado.add(a.nombre() + "(" + a.edad() + ", " + a.nota() + ")"));
        return resultado;
    }
}
