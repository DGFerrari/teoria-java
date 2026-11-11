/*
 * TEMA 11 · Clases y objetos
 * Ejemplo 01: PRIMERA CLASE (atributos, métodos y objetos)
 *
 * Nota del repositorio: la clase Alumno va DENTRO de la clase principal ("static class")
 * para que todo el ejemplo sea un único archivo. En un proyecto real iría en Alumno.java.
 *
 * Cómo ejecutarlo:  java T11_01_PrimeraClase.java
 */
public class T11_01_PrimeraClase {

    // ============================================================
    // LA CLASE: el molde
    // ============================================================
    static class Alumno {

        // ATRIBUTOS: los datos de CADA alumno
        String nombre;
        int edad;
        double nota;

        // MÉTODOS DE INSTANCIA (sin static): usan los atributos de ESTE alumno
        boolean estaAprobado() {
            return nota >= 5;
        }

        void cumplirAnios() {
            edad++;
        }

        void mostrarFicha() {
            System.out.println(nombre + " | " + edad + " años | nota " + nota
                    + " | " + (estaAprobado() ? "aprobado" : "suspenso"));
        }
    }

    // ============================================================
    // EL PROGRAMA: crea y usa objetos
    // ============================================================
    public static void main(String[] args) {

        // 1. Crear objetos con new (cada uno es independiente)
        Alumno ana = new Alumno();
        ana.nombre = "Ana";
        ana.edad = 15;
        ana.nota = 8.5;

        Alumno luis = new Alumno();
        luis.nombre = "Luis";
        luis.edad = 16;
        luis.nota = 4.25;

        // 2. Usar sus métodos: cada uno responde con SUS datos
        ana.mostrarFicha();
        luis.mostrarFicha();
        System.out.println("¿Ana ha aprobado? " + ana.estaAprobado());
        System.out.println("¿Luis ha aprobado? " + luis.estaAprobado());
        System.out.println();

        // 3. Un método puede cambiar el estado del objeto
        ana.cumplirAnios();
        System.out.println("Tras su cumpleaños, Ana tiene " + ana.edad + " años");
        System.out.println("Luis sigue teniendo " + luis.edad + " años");   // No le afecta
        System.out.println();

        // 4. Atributos sin asignar: tienen valor por defecto
        Alumno nuevo = new Alumno();
        System.out.println("Alumno recién creado → nombre: " + nuevo.nombre
                + ", edad: " + nuevo.edad + ", nota: " + nuevo.nota);   // null, 0, 0.0
        // Para no tener objetos "a medio hacer" existen los constructores (ejemplo 02).

        // 5. Comparación con los arrays paralelos del tema 08:
        //    los datos de cada alumno viajan JUNTOS dentro del objeto.

        // PRUEBA: añade a Alumno un atributo "curso" (String) y muéstralo en mostrarFicha().
    }
}
