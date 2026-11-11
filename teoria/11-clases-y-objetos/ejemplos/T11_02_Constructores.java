/*
 * TEMA 11 · Clases y objetos
 * Ejemplo 02: CONSTRUCTORES Y this
 *
 * Cómo ejecutarlo:  java T11_02_Constructores.java
 */
public class T11_02_Constructores {

    static class Libro {

        String titulo;
        String autor;
        int paginas;
        boolean prestado;

        // Constructor completo: mismo nombre que la clase, SIN tipo de retorno
        Libro(String titulo, String autor, int paginas) {
            this.titulo = titulo;       // this.titulo = atributo | titulo = parámetro
            this.autor = autor;
            this.paginas = paginas;
            this.prestado = false;      // Todo libro nuevo empieza disponible
        }

        // Sobrecarga: si no sabemos las páginas, llamamos al constructor completo con this(...)
        Libro(String titulo, String autor) {
            this(titulo, autor, 0);     // Tiene que ser la PRIMERA instrucción
        }

        void prestar() {
            if (prestado) {
                System.out.println("  \"" + titulo + "\" ya está prestado");
            } else {
                prestado = true;
                System.out.println("  Prestado: \"" + titulo + "\"");
            }
        }

        void devolver() {
            prestado = false;
            System.out.println("  Devuelto: \"" + titulo + "\"");
        }

        String describir() {
            String textoPaginas = paginas > 0 ? paginas + " páginas" : "páginas desconocidas";
            return "\"" + titulo + "\" de " + autor + " (" + textoPaginas + ")"
                    + (prestado ? " [PRESTADO]" : " [disponible]");
        }
    }

    // Una clase con un error típico: olvidar this en el constructor
    static class Mascota {
        String nombre;

        Mascota(String nombre) {
            nombre = nombre;            // ⚠️ Asigna el parámetro a sí mismo: el atributo sigue en null
        }
    }

    public static void main(String[] args) {

        // 1. Crear objetos ya inicializados
        Libro quijote = new Libro("El Quijote", "Miguel de Cervantes", 1376);
        Libro principito = new Libro("El principito", "Antoine de Saint-Exupéry");   // Constructor de 2 parámetros

        System.out.println(quijote.describir());
        System.out.println(principito.describir());
        System.out.println();

        // 2. Los métodos cambian el estado de cada objeto
        quijote.prestar();
        quijote.prestar();              // Ya estaba prestado
        System.out.println(quijote.describir());
        quijote.devolver();
        System.out.println(quijote.describir());
        System.out.println();

        // 3. Sin constructor sin parámetros, esto no compila:
        // Libro vacio = new Libro();
        // ❌ error: constructor Libro in class Libro cannot be applied to given types

        // 4. El error de olvidar this
        Mascota toby = new Mascota("Toby");
        System.out.println("Nombre de la mascota: " + toby.nombre);   // null 😱
        // Solución: this.nombre = nombre;

        // PRUEBA: añade a Libro un atributo "anioPublicacion" y un tercer constructor
        //    que lo reciba. Haz que el constructor de 3 parámetros llame a este nuevo.
    }
}
