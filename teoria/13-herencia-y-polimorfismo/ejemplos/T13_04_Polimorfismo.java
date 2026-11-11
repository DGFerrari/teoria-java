/*
 * TEMA 13 · Herencia y polimorfismo
 * Ejemplo 04: POLIMORFISMO
 *
 * Una variable de la superclase puede guardar cualquier subclase,
 * y al llamar a un método se ejecuta la versión del objeto REAL.
 *
 * Cómo ejecutarlo:  java T13_04_Polimorfismo.java
 */
public class T13_04_Polimorfismo {

    static class Figura {
        protected final String nombre;

        public Figura(String nombre) {
            this.nombre = nombre;
        }

        public double area() {
            return 0;                     // Una figura "genérica" no sabe calcularla (tema 14: abstract)
        }

        public double perimetro() {
            return 0;
        }

        @Override
        public String toString() {
            return String.format("%-10s área %7.2f | perímetro %6.2f", nombre, area(), perimetro());
        }
    }

    static class Circulo extends Figura {
        private final double radio;

        public Circulo(double radio) {
            super("Círculo");
            this.radio = radio;
        }

        @Override
        public double area() {
            return Math.PI * radio * radio;
        }

        @Override
        public double perimetro() {
            return 2 * Math.PI * radio;
        }
    }

    static class Rectangulo extends Figura {
        protected final double ancho;
        protected final double alto;

        public Rectangulo(double ancho, double alto) {
            this("Rectángulo", ancho, alto);
        }

        protected Rectangulo(String nombre, double ancho, double alto) {   // Para las subclases
            super(nombre);
            this.ancho = ancho;
            this.alto = alto;
        }

        @Override
        public double area() {
            return ancho * alto;
        }

        @Override
        public double perimetro() {
            return 2 * (ancho + alto);
        }
    }

    // Un cuadrado ES UN rectángulo con los lados iguales
    static class Cuadrado extends Rectangulo {
        public Cuadrado(double lado) {
            super("Cuadrado", lado, lado);
        }
        // No necesita sobrescribir nada: area y perimetro de Rectangulo ya funcionan
    }

    static class Triangulo extends Figura {
        private final double a, b, c;     // Lados

        public Triangulo(double a, double b, double c) {
            super("Triángulo");
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double perimetro() {
            return a + b + c;
        }

        @Override
        public double area() {            // Fórmula de Herón
            double s = perimetro() / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
    }

    // ------------------------------------------------------------
    // Métodos que reciben la SUPERCLASE: valen para cualquier figura
    // ------------------------------------------------------------
    static double areaTotal(Figura[] figuras) {
        double total = 0;
        for (Figura f : figuras) {
            total += f.area();            // Cada objeto usa SU area()
        }
        return total;
    }

    static Figura laMayor(Figura[] figuras) {
        Figura mayor = figuras[0];
        for (Figura f : figuras) {
            if (f.area() > mayor.area()) {
                mayor = f;
            }
        }
        return mayor;
    }

    public static void main(String[] args) {

        // Una variable Figura guardando un Circulo
        Figura f = new Circulo(1);
        System.out.println("f es un " + f.nombre + " con área " + f.area());   // Se ejecuta area() de Circulo
        System.out.println();

        // Un array de la superclase con objetos de varias subclases
        Figura[] figuras = {
                new Circulo(2),
                new Rectangulo(3, 4.5),
                new Cuadrado(3),
                new Triangulo(3, 4, 5)
        };

        for (Figura figura : figuras) {
            System.out.println(figura);   // toString de Figura, que llama al area() de cada subclase
        }
        System.out.printf("Área total: %.2f%n", areaTotal(figuras));
        System.out.println("La mayor: " + laMayor(figuras).nombre);

        // Si mañana se crea "class Hexagono extends Figura", areaTotal y laMayor
        // funcionarán con él sin cambiar ni una línea.

        // Desde una variable Figura solo se puede llamar a lo que tiene Figura:
        // f.radio;        // ❌ Error: Figura no tiene radio (aunque el objeto sea un Circulo)
    }
}
