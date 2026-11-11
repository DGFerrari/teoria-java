/*
 * TEMA 13 · Ejercicio 03 · Figuras polimórficas  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol13_03_FigurasPolimorficas.java
 */
public class Sol13_03_FigurasPolimorficas {

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

    static class Circulo extends Figura {
        private final double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        @Override
        public String getNombre() {
            return String.format("Círculo (r=%.1f)", radio);
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
            this.ancho = ancho;
            this.alto = alto;
        }

        @Override
        public String getNombre() {
            return String.format("Rectángulo (%.1f x %.1f)", ancho, alto);
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

    // Un cuadrado ES UN rectángulo: solo cambia el nombre
    static class Cuadrado extends Rectangulo {
        public Cuadrado(double lado) {
            super(lado, lado);
        }

        @Override
        public String getNombre() {
            return String.format("Cuadrado (%.1f)", ancho);
        }
    }

    static class TrianguloRectangulo extends Figura {
        private final double cateto1;
        private final double cateto2;

        public TrianguloRectangulo(double cateto1, double cateto2) {
            this.cateto1 = cateto1;
            this.cateto2 = cateto2;
        }

        @Override
        public String getNombre() {
            return String.format("Triángulo (%.1f y %.1f)", cateto1, cateto2);
        }

        @Override
        public double area() {
            return cateto1 * cateto2 / 2;
        }

        @Override
        public double perimetro() {
            return cateto1 + cateto2 + Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
        }
    }

    // Métodos generales: funcionan con cualquier figura, presente o futura
    static double areaTotal(Figura[] figuras) {
        double total = 0;
        for (Figura f : figuras) {
            total += f.area();
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

    static int contarCirculos(Figura[] figuras) {
        int cantidad = 0;
        for (Figura f : figuras) {
            if (f instanceof Circulo) {
                cantidad++;
            }
        }
        return cantidad;
    }

    static int contarRectangulos(Figura[] figuras) {
        int cantidad = 0;
        for (Figura f : figuras) {
            if (f instanceof Rectangulo) {    // El Cuadrado también cuenta: ES UN Rectangulo
                cantidad++;
            }
        }
        return cantidad;
    }

    static void ordenarPorArea(Figura[] figuras) {
        boolean hayCambios = true;
        int pasada = 0;
        while (hayCambios) {
            hayCambios = false;
            for (int i = 0; i < figuras.length - 1 - pasada; i++) {
                if (figuras[i].area() > figuras[i + 1].area()) {
                    Figura auxiliar = figuras[i];
                    figuras[i] = figuras[i + 1];
                    figuras[i + 1] = auxiliar;
                    hayCambios = true;
                }
            }
            pasada++;
        }
    }

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
