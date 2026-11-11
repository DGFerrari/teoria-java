/*
 * TEMA 11 · Ejercicio 03 · Fracciones  (dificultad: 3/5)
 *
 * Objetivo: una clase cuyos métodos reciben otro objeto y devuelven uno nuevo.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej11_03_Fracciones.java
 */
public class Ej11_03_Fracciones {

    static class Fraccion {

        int numerador;
        int denominador;

        // TODO 1: guarda la fracción simplificada y con el signo en el numerador.
        Fraccion(int numerador, int denominador) {
            this.numerador = numerador;
            this.denominador = denominador;
        }

        // Ya hecho: máximo común divisor (Euclides, tema 10)
        static int mcd(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return mcd(b, a % b);
            }
        }

        // TODO 2: las cuatro operaciones (devuelven una fracción NUEVA)
        Fraccion sumar(Fraccion otra) {
            return this;
        }

        Fraccion restar(Fraccion otra) {
            return this;
        }

        Fraccion multiplicar(Fraccion otra) {
            return this;
        }

        Fraccion dividir(Fraccion otra) {
            return this;
        }

        // TODO 3
        double valorDecimal() {
            return 0;
        }

        // TODO 4
        boolean esIgualA(Fraccion otra) {
            return false;
        }

        // TODO 5: "3/4" o "-2" si el denominador es 1
        @Override
        public String toString() {
            return numerador + "/" + denominador;
        }
    }

    // NO TOCAR
    public static void main(String[] args) {
        Fraccion a = new Fraccion(1, 2);
        Fraccion b = new Fraccion(3, 4);

        System.out.println("a = " + a + " | b = " + b);
        System.out.println("a + b = " + a.sumar(b));
        System.out.println("a - b = " + a.restar(b));
        System.out.println("a * b = " + a.multiplicar(b));
        System.out.println("a / b = " + a.dividir(b));

        Fraccion c = new Fraccion(6, 8);
        Fraccion d = new Fraccion(4, -2);
        System.out.println("6/8 se guarda como " + c);
        System.out.println("4/-2 se guarda como " + d);
        System.out.println("b vale " + b.valorDecimal());
        System.out.println("¿3/4 es igual a 6/8? " + b.esIgualA(c));
        System.out.println("¿a sigue valiendo 1/2? " + a);
    }
}
