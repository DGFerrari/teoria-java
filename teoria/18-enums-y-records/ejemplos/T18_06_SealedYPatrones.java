/*
 * TEMA 18 · Enums y records
 * Ejemplo 06: sealed + records + patrones de registro (Java 21)
 *
 * Cómo ejecutarlo:  java T18_06_SealedYPatrones.java
 */
import java.util.List;

public class T18_06_SealedYPatrones {

    // La interfaz dice QUÉ tipos hay; cada record dice QUÉ datos tiene
    sealed interface Figura permits Circulo, Rectangulo, Triangulo { }

    record Circulo(double radio) implements Figura { }

    record Rectangulo(double ancho, double alto) implements Figura { }

    record Triangulo(double base, double altura) implements Figura { }

    // Un record que contiene otros records
    record Punto(int x, int y) { }

    record Linea(Punto inicio, Punto fin) { }

    // switch con patrones de registro: desmonta cada record en sus componentes
    static double area(Figura figura) {
        return switch (figura) {
            case Circulo(double radio) -> Math.PI * radio * radio;
            case Rectangulo(double ancho, double alto) -> ancho * alto;
            case Triangulo(double base, double altura) -> base * altura / 2;
        };                                  // Sin default: Figura es sealed y están todos
    }

    // Patrones con condición (when): el primero que encaje gana
    static String describir(Figura figura) {
        return switch (figura) {
            case Circulo(double radio) when radio == 0 -> "un punto";
            case Circulo(double radio) -> "un círculo de radio " + radio;
            case Rectangulo(double ancho, double alto) when ancho == alto -> "un cuadrado de lado " + ancho;
            case Rectangulo(double ancho, double alto) -> "un rectángulo de " + ancho + " × " + alto;
            case Triangulo t -> "un triángulo de base " + t.base();     // También vale el patrón de tipo
        };
    }

    // Patrones anidados: se desmonta la línea y, dentro, sus dos puntos
    static String tipoDeLinea(Linea linea) {
        return switch (linea) {
            case Linea(Punto(int x1, int y1), Punto(int x2, int y2)) when x1 == x2 && y1 == y2 -> "un solo punto";
            case Linea(Punto(int x1, int y1), Punto(int x2, int y2)) when x1 == x2 -> "vertical";
            case Linea(Punto(int x1, int y1), Punto(int x2, int y2)) when y1 == y2 -> "horizontal";
            case Linea l -> "inclinada";
        };
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Áreas con un switch exhaustivo
        // ------------------------------------------------------------
        List<Figura> figuras = List.of(new Circulo(1.5), new Rectangulo(4, 2.5),
                new Rectangulo(3, 3), new Triangulo(3, 4), new Circulo(0));
        double total = 0;
        for (Figura f : figuras) {
            System.out.printf("1. %-45s área %6.2f%n", f, area(f));
            total += area(f);
        }
        System.out.printf("   Área total: %.2f%n", total);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Patrones con when
        // ------------------------------------------------------------
        for (Figura f : figuras) {
            System.out.println("2. Es " + describir(f));
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3. Patrones anidados
        // ------------------------------------------------------------
        List<Linea> lineas = List.of(
                new Linea(new Punto(0, 0), new Punto(0, 5)),
                new Linea(new Punto(1, 2), new Punto(7, 2)),
                new Linea(new Punto(0, 0), new Punto(3, 3)),
                new Linea(new Punto(4, 4), new Punto(4, 4)));
        for (Linea l : lineas) {
            System.out.println("3. " + l + " → " + tipoDeLinea(l));
        }
        System.out.println();

        // ------------------------------------------------------------
        // 4. Patrones de registro con instanceof
        // ------------------------------------------------------------
        Object algo = new Rectangulo(2, 8);
        if (algo instanceof Rectangulo(double ancho, double alto)) {
            System.out.println("4. Es un rectángulo y su perímetro es " + 2 * (ancho + alto));
        }
    }
}
