/*
 * TEMA 09 · Ejercicio 05 · Informe de alumnos  (dificultad: 5/5)
 *
 * Objetivo: procesar texto con formato, limpiar los datos y generar un informe.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej09_05_InformeDeAlumnos.java
 */
public class Ej09_05_InformeDeAlumnos {

    public static void main(String[] args) {

        // NO TOCAR: los datos tal y como llegan
        String datos = """
                ana;garcía lópez;7.5,8,9
                LUIS;martín;5,4.5,6
                marta;Ruiz;9.5,10,9
                jorge;pérez sanz;3,4,5.5
                """;

        // Ya hecho: el informe y su cabecera
        final String SEPARADOR = "=".repeat(52);
        StringBuilder informe = new StringBuilder();
        informe.append(SEPARADOR).append("\n");
        informe.append(String.format("%3s  %-20s %-10s %6s  %s%n", "Nº", "Alumno", "Usuario", "Media", "Estado"));
        informe.append(SEPARADOR).append("\n");

        int aprobados = 0;
        String mejorAlumno = "";
        double mejorMedia = 0;

        // TODO 1: divide "datos" en líneas.

        // TODO 2: para cada línea:
        //   a) divídela en campos (nombre, apellidos, notas)
        //   b) capitaliza el nombre
        //   c) capitaliza cada palabra de los apellidos
        //   d) genera el usuario (inicial + primer apellido, minúsculas, sin tildes)
        //   e) calcula la media de las notas
        //   f) decide el estado y actualiza "aprobados" y la mejor media
        //   g) añade la fila al informe con String.format

        // TODO 3: añade el separador final, los aprobados y la mejor media.

        // Ya hecho: mostrar el informe
        System.out.print(informe);
    }
}
