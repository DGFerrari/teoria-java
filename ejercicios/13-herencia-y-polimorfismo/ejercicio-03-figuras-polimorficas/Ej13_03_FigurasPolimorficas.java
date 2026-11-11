/*
 * TEMA 13 · Ejercicio 03 · Figuras polimórficas  (dificultad: 3/5)
 *
 * Objetivo: subclases que sobrescriben métodos y código general que trabaja con la superclase.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej13_03_FigurasPolimorficas.java
 */
public class Ej13_03_FigurasPolimorficas {

    // NO TOCAR: la superclase
    static class Figura {
        public String getNombre() {
            return "Figura";
        }

        public double area() {
            return 0;
        }

        public double perimetro() {
            return 0;
        }

        @Override
        public String toString() {
            return String.format("%-24s área %6.2f | perímetro %6.2f", getNombre(), area(), perimetro());
        }
    }

    // TODO 1: completa las cuatro subclases sobrescribiendo getNombre(), area() y perimetro()

    static class Circulo extends Figura {
        private final double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }
    }

    static class Rectangulo extends Figura {
        protected final double ancho;
        protected final double alto;

        public Rectangulo(double ancho, double alto) {
            this.ancho = ancho;
            this.alto = alto;
        }
    }

    static class Cuadrado extends Rectangulo {
        public Cuadrado(double lado) {
            super(lado, lado);
        }
    }

    static class TrianguloRectangulo extends Figura {
        private final double cateto1;
        private final double cateto2;

        public TrianguloRectangulo(double cateto1, double cateto2) {
            this.cateto1 = cateto1;
            this.cateto2 = cateto2;
        }
    }

    // TODO 2: métodos que trabajan con CUALQUIER figura

    static double areaTotal(Figura[] figuras) {
        return 0;
    }

    static Figura laMayor(Figura[] figuras) {
        return figuras[0];
    }

    static int contarCirculos(Figura[] figuras) {
        return 0;
    }

    static int contarRectangulos(Figura[] figuras) {
        return 0;
    }

    static void ordenarPorArea(Figura[] figuras) {
    }

    // NO TOCAR
    public static void main(String[] args) {
        Figura[] figuras = {
                new Circulo(1.5),
                new Rectangulo(4, 2.5),
                new Cuadrado(3),
                new TrianguloRectangulo(3, 4),
                new Circulo(0.5)
        };

        for (Figura f : figuras) {
            System.out.println(f);
        }
        System.out.printf("Área total: %.2f%n", areaTotal(figuras));
        System.out.println("La mayor: " + laMayor(figuras).getNombre());
        System.out.println("Círculos: " + contarCirculos(figuras)
                + " | Rectángulos (incluidos cuadrados): " + contarRectangulos(figuras));

        ordenarPorArea(figuras);
        System.out.println("--- Ordenadas por área ---");
        for (Figura f : figuras) {
            System.out.println(f);
        }
    }
}
