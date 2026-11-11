/*
 * TEMA 18 · Enums y records
 * Ejemplo 05: personalizar records (validar, métodos, withers, Comparable)
 *
 * Cómo ejecutarlo:  java T18_05_RecordsAvanzado.java
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class T18_05_RecordsAvanzado {

    record Fraccion(int numerador, int denominador) {

        // Constructor compacto: valida y normaliza. Los atributos se asignan solos al final
        Fraccion {
            if (denominador == 0) {
                throw new IllegalArgumentException("El denominador no puede ser 0");
            }
            if (denominador < 0) {                       // -1/-2 → 1/2 · 3/-4 → -3/4
                numerador = -numerador;
                denominador = -denominador;
            }
            int divisor = mcd(Math.abs(numerador), denominador);
            numerador = numerador / divisor;             // Se guarda simplificada
            denominador = denominador / divisor;
        }

        // Método static de fábrica
        static Fraccion entero(int n) {
            return new Fraccion(n, 1);
        }

        private static int mcd(int a, int b) {
            int x = a;
            int y = b;
            while (y != 0) {
                int resto = x % y;
                x = y;
                y = resto;
            }
            return x == 0 ? 1 : x;
        }

        double valor() {
            return (double) numerador / denominador;
        }

        // Las operaciones devuelven records NUEVOS (inmutabilidad)
        Fraccion sumar(Fraccion otra) {
            return new Fraccion(numerador * otra.denominador + otra.numerador * denominador,
                    denominador * otra.denominador);
        }

        Fraccion multiplicar(Fraccion otra) {
            return new Fraccion(numerador * otra.numerador, denominador * otra.denominador);
        }

        @Override
        public String toString() {                       // Se puede sustituir el toString generado
            return denominador == 1 ? String.valueOf(numerador) : numerador + "/" + denominador;
        }
    }

    // Un record que implementa Comparable y tiene un "wither"
    record Alumno(String nombre, double nota) implements Comparable<Alumno> {
        Alumno {
            if (nota < 0 || nota > 10) {
                throw new IllegalArgumentException("Nota fuera de rango: " + nota);
            }
        }

        Alumno conNota(double nuevaNota) {
            return new Alumno(nombre, nuevaNota);
        }

        boolean aprobado() {
            return nota >= 5;
        }

        @Override
        public int compareTo(Alumno otro) {
            return Double.compare(otro.nota, nota);      // De mayor a menor nota
        }
    }

    // Records como claves de un mapa
    record Coordenada(int fila, int columna) implements Comparable<Coordenada> {
        @Override
        public int compareTo(Coordenada otra) {
            int resultado = Integer.compare(fila, otra.fila);
            if (resultado == 0) {
                resultado = Integer.compare(columna, otra.columna);
            }
            return resultado;
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. El constructor compacto normaliza y valida
        // ------------------------------------------------------------
        Fraccion a = new Fraccion(2, 4);
        Fraccion b = new Fraccion(3, -9);
        System.out.println("1. 2/4 se guarda como " + a + " · 3/-9 como " + b);
        System.out.println("   " + a + " + " + b + " = " + a.sumar(b));
        System.out.println("   " + a + " × " + Fraccion.entero(4) + " = " + a.multiplicar(Fraccion.entero(4)));
        System.out.println("   ¿2/4 es igual a 1/2? " + a.equals(new Fraccion(1, 2)) + " (se simplificaron al crearse)");
        try {
            new Fraccion(1, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("   ✘ " + e.getMessage());
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. Withers y Comparable
        // ------------------------------------------------------------
        List<Alumno> clase = new ArrayList<>(List.of(
                new Alumno("Ana", 7.5), new Alumno("Luis", 4.0), new Alumno("Marta", 9.0)));
        Alumno luis = clase.get(1);
        Alumno luisTrasRecuperar = luis.conNota(6.0);
        clase.set(1, luisTrasRecuperar);
        System.out.println("2. Luis antes: " + luis + " · después: " + luisTrasRecuperar);
        Collections.sort(clase);
        System.out.println("   Ranking: " + clase);
        try {
            new Alumno("Error", 11);
        } catch (IllegalArgumentException e) {
            System.out.println("   ✘ " + e.getMessage());
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3. Records como claves: un tablero "disperso"
        // ------------------------------------------------------------
        Map<Coordenada, String> tablero = new TreeMap<>();
        tablero.put(new Coordenada(2, 3), "♞");
        tablero.put(new Coordenada(0, 0), "♜");
        tablero.put(new Coordenada(2, 1), "♝");
        System.out.println("3. Piezas: " + tablero);
        System.out.println("   ¿Qué hay en (2, 3)? " + tablero.get(new Coordenada(2, 3)));
    }
}
