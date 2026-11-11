/*
 * TEMA 18 · Enums y records
 * Ejemplo 04: records básicos (qué genera Java automáticamente)
 *
 * Cómo ejecutarlo:  java T18_04_RecordsBasico.java
 */
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class T18_04_RecordsBasico {

    // Una clase de datos inmutable "a mano" (lo que se hacía antes de los records)
    static final class PuntoClase {
        private final double x;
        private final double y;

        PuntoClase(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double getX() {
            return x;
        }

        double getY() {
            return y;
        }

        @Override
        public boolean equals(Object otro) {
            boolean iguales = false;
            if (otro instanceof PuntoClase p) {
                iguales = Double.compare(x, p.x) == 0 && Double.compare(y, p.y) == 0;
            }
            return iguales;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "PuntoClase[x=" + x + ", y=" + y + "]";
        }
    }

    // Exactamente lo mismo, en una línea
    record Punto(double x, double y) { }

    record Persona(String nombre, int edad, String ciudad) { }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Constructor y accesores (x(), no getX())
        // ------------------------------------------------------------
        Punto p = new Punto(3, 4);
        PuntoClase pc = new PuntoClase(3, 4);
        System.out.println("1. Record: x = " + p.x() + ", y = " + p.y());
        System.out.println("   Clase:  x = " + pc.getX() + ", y = " + pc.getY());
        System.out.println();

        // ------------------------------------------------------------
        // 2. toString automático
        // ------------------------------------------------------------
        Persona ana = new Persona("Ana", 15, "Toledo");
        System.out.println("2. " + p);
        System.out.println("   " + ana);
        System.out.println();

        // ------------------------------------------------------------
        // 3. equals y hashCode según los DATOS
        // ------------------------------------------------------------
        Punto otro = new Punto(3, 4);
        System.out.println("3. p == otro → " + (p == otro) + " (objetos distintos)");
        System.out.println("   p.equals(otro) → " + p.equals(otro) + " (mismos datos)");
        System.out.println("   Mismo hashCode → " + (p.hashCode() == otro.hashCode()));
        System.out.println();

        // ------------------------------------------------------------
        // 4. Por eso funcionan bien en un HashSet (tema 16)
        // ------------------------------------------------------------
        Set<Punto> visitados = new HashSet<>(List.of(new Punto(0, 0), new Punto(1, 2), new Punto(0, 0)));
        System.out.println("4. Puntos visitados distintos: " + visitados.size());
        System.out.println("   ¿Pasé por (1, 2)? " + visitados.contains(new Punto(1, 2)));
        System.out.println();

        // ------------------------------------------------------------
        // 5. Inmutables: para "cambiar" un dato se crea un record nuevo
        // ------------------------------------------------------------
        // ana.edad = 16;                // ❌ No compila: los atributos son final
        Persona anaMayor = new Persona(ana.nombre(), ana.edad() + 1, ana.ciudad());
        System.out.println("5. Antes:   " + ana);
        System.out.println("   Después: " + anaMayor);
    }
}
