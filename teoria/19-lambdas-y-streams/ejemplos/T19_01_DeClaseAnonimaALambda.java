/*
 * TEMA 19 · Lambdas y streams
 * Ejemplo 01: de la clase anónima a la lambda
 *
 * Cómo ejecutarlo:  java T19_01_DeClaseAnonimaALambda.java
 */
import java.util.ArrayList;
import java.util.List;

public class T19_01_DeClaseAnonimaALambda {

    // Una interfaz funcional: un único método abstracto
    @FunctionalInterface
    interface Condicion {
        boolean cumple(int numero);
    }

    @FunctionalInterface
    interface Operacion {
        double aplicar(double a, double b);
    }

    // 1) Con una clase con nombre
    static class EsPar implements Condicion {
        @Override
        public boolean cumple(int numero) {
            return numero % 2 == 0;
        }
    }

    // Un método que recibe "qué hacer" como parámetro
    static List<Integer> filtrar(int[] numeros, Condicion condicion) {
        List<Integer> resultado = new ArrayList<>();
        for (int n : numeros) {
            if (condicion.cumple(n)) {
                resultado.add(n);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] numeros = {3, 8, 15, 22, 7, 40, 11};

        // ------------------------------------------------------------
        // 1. La misma idea, de tres formas
        // ------------------------------------------------------------
        Condicion conClase = new EsPar();

        Condicion conAnonima = new Condicion() {          // 2) Clase anónima (tema 14)
            @Override
            public boolean cumple(int numero) {
                return numero % 2 == 0;
            }
        };

        Condicion conLambda = n -> n % 2 == 0;            // 3) Lambda: solo lo importante

        System.out.println("1. Con clase:    " + filtrar(numeros, conClase));
        System.out.println("   Con anónima:  " + filtrar(numeros, conAnonima));
        System.out.println("   Con lambda:   " + filtrar(numeros, conLambda));
        System.out.println();

        // ------------------------------------------------------------
        // 2. La lambda se puede escribir directamente en la llamada
        // ------------------------------------------------------------
        System.out.println("2. Mayores que 10: " + filtrar(numeros, n -> n > 10));
        System.out.println("   Acaban en 1 o 3: " + filtrar(numeros, n -> n % 10 == 1 || n % 10 == 3));
        System.out.println();

        // ------------------------------------------------------------
        // 3. Formas de la sintaxis
        // ------------------------------------------------------------
        Operacion suma = (a, b) -> a + b;                         // Dos parámetros, una expresión
        Operacion hipotenusa = (a, b) -> Math.sqrt(a * a + b * b);
        Operacion mediaPonderada = (nota, peso) -> {              // Bloque: llaves y return
            double resultado = nota * peso;
            return Math.round(resultado * 100) / 100.0;
        };
        Operacion conTipos = (double a, double b) -> a * b;       // Tipos explícitos (casi nunca hace falta)
        System.out.println("3. suma(3, 4) = " + suma.aplicar(3, 4));
        System.out.println("   hipotenusa(3, 4) = " + hipotenusa.aplicar(3, 4));
        System.out.println("   mediaPonderada(7.25, 0.4) = " + mediaPonderada.aplicar(7.25, 0.4));
        System.out.println("   conTipos(2.5, 4) = " + conTipos.aplicar(2.5, 4));
        System.out.println();

        // ------------------------------------------------------------
        // 4. Captura de variables: tienen que ser efectivamente finales
        // ------------------------------------------------------------
        int minimo = 10;                                          // No cambia → se puede usar
        Condicion superaMinimo = n -> n > minimo;
        System.out.println("4. Mayores que " + minimo + ": " + filtrar(numeros, superaMinimo));
        // minimo = 20;   // ❌ Si se descomenta, la lambda deja de compilar:
        //                //    "local variables referenced from a lambda expression must be final or effectively final"
        System.out.println();

        // ------------------------------------------------------------
        // 5. Las lambdas se guardan en variables, arrays, listas...
        // ------------------------------------------------------------
        List<Operacion> operaciones = List.of((a, b) -> a + b, (a, b) -> a - b, (a, b) -> a * b);
        String[] nombres = {"suma", "resta", "producto"};
        for (int i = 0; i < operaciones.size(); i++) {
            System.out.println("5. " + nombres[i] + "(6, 3) = " + operaciones.get(i).aplicar(6, 3));
        }
    }
}
