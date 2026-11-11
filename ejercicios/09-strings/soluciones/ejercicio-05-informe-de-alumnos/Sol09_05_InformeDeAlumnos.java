/*
 * TEMA 09 · Ejercicio 05 · Informe de alumnos  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol09_05_InformeDeAlumnos.java
 */
public class Sol09_05_InformeDeAlumnos {

    public static void main(String[] args) {

        String datos = """
                ana;garcía lópez;7.5,8,9
                LUIS;martín;5,4.5,6
                marta;Ruiz;9.5,10,9
                jorge;pérez sanz;3,4,5.5
                """;

        final String SEPARADOR = "=".repeat(52);
        StringBuilder informe = new StringBuilder();
        informe.append(SEPARADOR).append("\n");
        informe.append(String.format("%3s  %-20s %-10s %6s  %s%n", "Nº", "Alumno", "Usuario", "Media", "Estado"));
        informe.append(SEPARADOR).append("\n");

        int aprobados = 0;
        String mejorAlumno = "";
        double mejorMedia = 0;

        // 1. Una posición por alumno (strip quita el salto de línea final)
        String[] lineas = datos.strip().split("\n");

        for (int i = 0; i < lineas.length; i++) {

            // 2a. Campos
            String[] campos = lineas[i].strip().split(";");

            // 2b. Nombre capitalizado
            String nombre = campos[0].substring(0, 1).toUpperCase() + campos[0].substring(1).toLowerCase();

            // 2c. Cada apellido capitalizado
            String[] palabrasApellidos = campos[1].strip().split(" +");
            StringBuilder apellidos = new StringBuilder();
            for (String palabra : palabrasApellidos) {
                if (apellidos.length() > 0) {
                    apellidos.append(" ");
                }
                apellidos.append(palabra.substring(0, 1).toUpperCase()).append(palabra.substring(1).toLowerCase());
            }
            String nombreCompleto = nombre + " " + apellidos;

            // 2d. Usuario: inicial + primer apellido, minúsculas y sin tildes
            String usuario = (nombre.charAt(0) + palabrasApellidos[0]).toLowerCase()
                    .replace('á', 'a').replace('é', 'e').replace('í', 'i')
                    .replace('ó', 'o').replace('ú', 'u').replace('ü', 'u');

            // 2e. Media (parseDouble usa siempre punto decimal)
            String[] notas = campos[2].split(",");
            double suma = 0;
            for (String nota : notas) {
                suma += Double.parseDouble(nota);
            }
            double media = suma / notas.length;

            // 2f. Estado y estadísticas
            String estado = media >= 5 ? "APROBADO" : "SUSPENSO";
            if (media >= 5) {
                aprobados++;
            }
            if (i == 0 || media > mejorMedia) {
                mejorMedia = media;
                mejorAlumno = nombreCompleto;
            }

            // 2g. Fila del informe
            informe.append(String.format("%3d  %-20s %-10s %6.2f  %s%n", i + 1, nombreCompleto, usuario, media, estado));
        }

        // 3. Pie del informe
        informe.append(SEPARADOR).append("\n");
        informe.append("Aprobados: ").append(aprobados).append(" de ").append(lineas.length).append("\n");
        informe.append(String.format("Mejor media: %s (%.2f)%n", mejorAlumno, mejorMedia));

        System.out.print(informe);
    }
}
