/*
 * TEMA 09 · Strings
 * Ejemplo 04: split Y join
 *
 * Cómo ejecutarlo:  java T09_04_SplitYJoin.java
 */
import java.util.Arrays;

public class T09_04_SplitYJoin {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. split: de texto a array
        // ------------------------------------------------------------
        String fecha = "25/12/2025";
        String[] partesFecha = fecha.split("/");
        System.out.println("Partes: " + Arrays.toString(partesFecha));
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int anio = Integer.parseInt(partesFecha[2]);
        System.out.println("Día " + dia + ", mes " + mes + ", año " + anio);
        System.out.println();

        // Palabras de una frase (" +" = uno o más espacios seguidos)
        String frase = "  Me   gusta    programar en Java  ";
        String[] mal = frase.split(" ");
        String[] bien = frase.strip().split(" +");
        System.out.println("split(\" \"):          " + mal.length + " trozos " + Arrays.toString(mal));
        System.out.println("strip().split(\" +\"): " + bien.length + " palabras " + Arrays.toString(bien));
        System.out.println();

        // Caracteres especiales: el punto y la barra vertical necesitan \\
        String ip = "192.168.1.10";
        String[] bytesIp = ip.split("\\.");
        System.out.println("IP por partes: " + Arrays.toString(bytesIp));
        System.out.println();

        // ------------------------------------------------------------
        // 2. String.join: de array a texto
        // ------------------------------------------------------------
        String[] ingredientes = {"harina", "huevos", "leche", "azúcar"};
        System.out.println("Ingredientes: " + String.join(", ", ingredientes));
        System.out.println("Como ruta: " + String.join("/", "home", "ana", "documentos"));
        System.out.println();

        // ------------------------------------------------------------
        // 3. Procesar líneas tipo CSV (un formato muy habitual)
        // ------------------------------------------------------------
        String datos = """
                Ana;García;15;8.5
                Luis;Pérez;16;6.25
                Marta;Ruiz;15;9.75
                """;

        String[] lineas = datos.strip().split("\n");     // Una posición por línea
        System.out.printf("%-8s %-8s %4s %6s%n", "Nombre", "Apellido", "Edad", "Nota");
        double sumaNotas = 0;
        for (String linea : lineas) {
            String[] campos = linea.split(";");
            String nombre = campos[0];
            String apellido = campos[1];
            int edad = Integer.parseInt(campos[2]);
            double nota = Double.parseDouble(campos[3]);   // parseDouble usa SIEMPRE punto
            sumaNotas += nota;
            System.out.printf("%-8s %-8s %4d %6.2f%n", nombre, apellido, edad, nota);
        }
        System.out.printf("Media: %.2f%n", sumaNotas / lineas.length);
        System.out.println();

        // ------------------------------------------------------------
        // 4. Iniciales de un nombre completo
        // ------------------------------------------------------------
        String nombreCompleto = "lucía fernández de la rosa";
        String iniciales = "";
        for (String parte : nombreCompleto.split(" ")) {
            iniciales += Character.toUpperCase(parte.charAt(0)) + ".";
        }
        System.out.println("Iniciales de \"" + nombreCompleto + "\": " + iniciales);   // L.F.D.L.R.

        // PRUEBA: a partir de "rojo,verde,azul", crea el texto "ROJO | VERDE | AZUL".
    }
}
