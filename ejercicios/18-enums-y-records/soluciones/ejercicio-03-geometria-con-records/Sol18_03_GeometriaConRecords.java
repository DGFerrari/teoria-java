/*
 * TEMA 18 · Ejercicio 03 · Geometría con records  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol18_03_GeometriaConRecords.java
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sol18_03_GeometriaConRecords {

    record Punto(double x, double y) {
        static final Punto ORIGEN = new Punto(0, 0);        // Los records sí admiten atributos static

        double distancia(Punto otro) {
            double dx = x - otro.x;
            double dy = y - otro.y;
            return Math.sqrt(dx * dx + dy * dy);
        }

        // Inmutable: devuelve un punto NUEVO
        Punto trasladar(double dx, double dy) {
            return new Punto(x + dx, y + dy);
        }
    }

    record Segmento(Punto inicio, Punto fin) {
        Segmento {
            if (inicio.equals(fin)) {                         // equals generado: compara x e y
                throw new IllegalArgumentException("Un segmento necesita dos puntos distintos");
            }
        }

        double longitud() {
            return inicio.distancia(fin);
        }

        Punto puntoMedio() {
            return new Punto((inicio.x() + fin.x()) / 2, (inicio.y() + fin.y()) / 2);
        }
    }

    record Rectangulo(Punto esquina, double ancho, double alto) {
        Rectangulo {
            if (ancho <= 0 || alto <= 0) {
                throw new IllegalArgumentException("Las medidas tienen que ser positivas: " + ancho + " × " + alto);
            }
        }

        double area() {
            return ancho * alto;
        }

        boolean contiene(Punto p) {
            return p.x() >= esquina.x() && p.x() <= esquina.x() + ancho
                    && p.y() >= esquina.y() && p.y() <= esquina.y() + alto;
        }
    }

    public static void main(String[] args) {
        Punto p = new Punto(3, 4);
        System.out.println("p = " + p);
        System.out.println("Distancia al origen: " + p.distancia(Punto.ORIGEN));
        System.out.println("p trasladado (+1, -2): " + p.trasladar(1, -2));
        System.out.println("¿p sigue igual? " + p);

        Segmento s = new Segmento(Punto.ORIGEN, new Punto(6, 8));
        System.out.println(s);
        System.out.println("  Longitud: " + s.longitud() + " · punto medio: " + s.puntoMedio());
        System.out.println("  ¿El punto medio es p? " + s.puntoMedio().equals(p));
        try {
            new Segmento(new Punto(1, 1), new Punto(1, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("✘ " + e.getMessage());
        }

        Rectangulo r = new Rectangulo(new Punto(1, 1), 4, 3);
        System.out.println("Rectángulo de " + r.ancho() + " × " + r.alto() + " en " + r.esquina() + " · área " + r.area());
        System.out.println("  ¿Contiene p? " + r.contiene(p));
        System.out.println("  ¿Contiene el origen? " + r.contiene(Punto.ORIGEN));
        try {
            new Rectangulo(Punto.ORIGEN, 0, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("✘ " + e.getMessage());
        }

        List<Punto> recorrido = List.of(p, Punto.ORIGEN, new Punto(3, 4), new Punto(6, 8), new Punto(0, 0));
        Set<Punto> distintos = new HashSet<>(recorrido);     // equals y hashCode automáticos
        System.out.println("Puntos del recorrido: " + recorrido.size() + " · distintos: " + distintos.size());
    }
}
