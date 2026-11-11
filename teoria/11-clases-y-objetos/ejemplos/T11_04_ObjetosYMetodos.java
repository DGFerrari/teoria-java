/*
 * TEMA 11 · Clases y objetos
 * Ejemplo 04: OBJETOS COMO PARÁMETROS, COMO RESULTADO Y DENTRO DE OTROS OBJETOS
 *
 * Cómo ejecutarlo:  java T11_04_ObjetosYMetodos.java
 */
public class T11_04_ObjetosYMetodos {

    static class Rectangulo {
        double ancho;
        double alto;

        Rectangulo(double ancho, double alto) {
            this.ancho = ancho;
            this.alto = alto;
        }

        double area() {
            return ancho * alto;
        }

        double perimetro() {
            return 2 * (ancho + alto);
        }

        // Recibe OTRO objeto de la misma clase
        boolean esMayorQue(Rectangulo otro) {
            return this.area() > otro.area();
        }

        // MODIFICA este objeto
        void escalar(double factor) {
            ancho *= factor;
            alto *= factor;
        }

        // DEVUELVE un objeto nuevo (este no cambia)
        Rectangulo girado() {
            return new Rectangulo(alto, ancho);
        }

        @Override
        public String toString() {
            return "Rectángulo " + ancho + " x " + alto;
        }
    }

    // Método static de la clase principal que crea objetos ("fábrica")
    static Rectangulo crearCuadrado(double lado) {
        return new Rectangulo(lado, lado);
    }

    // ------------------------------------------------------------
    // Objetos dentro de objetos (composición)
    // ------------------------------------------------------------
    static class Direccion {
        String calle;
        String ciudad;

        Direccion(String calle, String ciudad) {
            this.calle = calle;
            this.ciudad = ciudad;
        }

        @Override
        public String toString() {
            return calle + ", " + ciudad;
        }
    }

    static class Persona {
        String nombre;
        Direccion direccion;          // Un atributo que es OTRO objeto

        Persona(String nombre, Direccion direccion) {
            this.nombre = nombre;
            this.direccion = direccion;
        }

        boolean viveEn(String ciudad) {
            return direccion.ciudad.equals(ciudad);
        }

        @Override
        public String toString() {
            return nombre + " (vive en " + direccion + ")";   // Usa el toString de Direccion
        }
    }

    public static void main(String[] args) {

        Rectangulo r1 = new Rectangulo(4, 3);
        Rectangulo r2 = crearCuadrado(3.5);

        System.out.println(r1 + " → área " + r1.area() + ", perímetro " + r1.perimetro());
        System.out.println(r2 + " → área " + r2.area());
        System.out.println("¿r1 es mayor que r2? " + r1.esMayorQue(r2));
        System.out.println();

        Rectangulo girado = r1.girado();
        System.out.println("Original: " + r1 + " | Girado (objeto nuevo): " + girado);

        r1.escalar(2);
        System.out.println("Tras escalar x2: " + r1 + " → área " + r1.area());
        System.out.println("El girado no cambia: " + girado);
        System.out.println();

        // Composición
        Direccion casa = new Direccion("C/ Mayor 5", "Valencia");
        Persona ana = new Persona("Ana", casa);
        Persona luis = new Persona("Luis", new Direccion("Av. del Puerto 20", "Valencia"));

        System.out.println(ana);
        System.out.println(luis);
        System.out.println("¿Ana vive en Valencia? " + ana.viveEn("Valencia"));

        // Encadenar el punto: el atributo direccion de ana, y su atributo ciudad
        System.out.println("Ciudad de Ana: " + ana.direccion.ciudad);

        // Como son referencias, si cambia la dirección compartida, cambia para quien la use
        casa.ciudad = "Alicante";
        System.out.println("Tras la mudanza: " + ana);

        // PRUEBA: crea una clase "Circulo" con un método "boolean cabeEn(Rectangulo r)"
        //    que diga si el círculo cabe dentro del rectángulo (diámetro <= ancho y <= alto).
    }
}
