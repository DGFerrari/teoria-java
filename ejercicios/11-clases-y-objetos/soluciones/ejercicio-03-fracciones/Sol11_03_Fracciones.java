/*
 * TEMA 11 · Ejercicio 03 · Fracciones  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol11_03_Fracciones.java
 */
public class Sol11_03_Fracciones {

    static class Fraccion {

        int numerador;
        int denominador;

        // Toda fracción se guarda simplificada y con el signo en el numerador
        Fraccion(int numerador, int denominador) {
            int divisor = mcd(Math.abs(numerador), Math.abs(denominador));
            numerador /= divisor;
            denominador /= divisor;
            if (denominador < 0) {
                numerador = -numerador;
                denominador = -denominador;
            }
            this.numerador = numerador;
            this.denominador = denominador;
        }

        static int mcd(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return mcd(b, a % b);
            }
        }

        // Las operaciones crean una fracción NUEVA (el constructor ya la simplifica)
        Fraccion sumar(Fraccion otra) {
            return new Fraccion(numerador * otra.denominador + otra.numerador * denominador,
                    denominador * otra.denominador);
        }

        Fraccion restar(Fraccion otra) {
            return new Fraccion(numerador * otra.denominador - otra.numerador * denominador,
                    denominador * otra.denominador);
        }

        Fraccion multiplicar(Fraccion otra) {
            return new Fraccion(numerador * otra.numerador, denominador * otra.denominador);
        }

        Fraccion dividir(Fraccion otra) {
            return new Fraccion(numerador * otra.denominador, denominador * otra.numerador);
        }

        double valorDecimal() {
            return (double) numerador / denominador;
        }

        // Gracias a la normalización, basta comparar numerador y denominador
        boolean esIgualA(Fraccion otra) {
            return numerador == otra.numerador && denominador == otra.denominador;
        }

        @Override
        public String toString() {
            return denominador == 1 ? String.valueOf(numerador) : numerador + "/" + denominador;
        }
    }

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
