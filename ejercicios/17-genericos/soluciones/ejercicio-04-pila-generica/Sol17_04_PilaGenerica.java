/*
 * TEMA 17 · Ejercicio 04 · Pila genérica  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol17_04_PilaGenerica.java
 */
import java.util.ArrayList;
import java.util.List;

public class Sol17_04_PilaGenerica {

    static class PilaVaciaException extends RuntimeException {
        PilaVaciaException() {
            super("La pila está vacía");
        }
    }

    // Una pila de cualquier tipo, construida sobre una List<T> (no se puede crear un array T[])
    static class Pila<T> {
        private final List<T> elementos = new ArrayList<>();

        void apilar(T elemento) {
            elementos.add(elemento);                    // La cima es el final de la lista
        }

        T desapilar() {
            comprobarQueNoEstaVacia();
            return elementos.remove(elementos.size() - 1);
        }

        T cima() {
            comprobarQueNoEstaVacia();
            return elementos.get(elementos.size() - 1);
        }

        boolean estaVacia() {
            return elementos.isEmpty();
        }

        int tamanio() {
            return elementos.size();
        }

        private void comprobarQueNoEstaVacia() {
            if (elementos.isEmpty()) {
                throw new PilaVaciaException();
            }
        }

        @Override
        public String toString() {
            String texto = "[]";
            if (!elementos.isEmpty()) {
                String lista = elementos.toString();
                texto = lista.substring(0, lista.length() - 1) + " ← cima]";
            }
            return texto;
        }
    }

    // Pila<Character>: lo último que entra es lo primero que sale → texto al revés
    static String alReves(String texto) {
        Pila<Character> pila = new Pila<>();
        for (int i = 0; i < texto.length(); i++) {
            pila.apilar(texto.charAt(i));
        }
        StringBuilder resultado = new StringBuilder();
        while (!pila.estaVacia()) {
            resultado.append(pila.desapilar());
        }
        return resultado.toString();
    }

    // Notación polaca inversa: los números se apilan; cada operador desapila dos y apila el resultado
    static double evaluarRPN(String expresion) {
        Pila<Double> pila = new Pila<>();
        for (String elemento : expresion.split(" ")) {
            switch (elemento) {
                case "+", "-", "*", "/" -> {
                    double derecha = pila.desapilar();      // ¡El de arriba es el SEGUNDO operando!
                    double izquierda = pila.desapilar();
                    pila.apilar(operar(izquierda, elemento, derecha));
                }
                default -> pila.apilar(Double.parseDouble(elemento));
            }
        }
        if (pila.tamanio() != 1) {
            throw new IllegalArgumentException("Expresión incompleta: sobran números");
        }
        return pila.desapilar();
    }

    static double operar(double a, String operador, double b) {
        return switch (operador) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> {
                if (b == 0) {
                    throw new ArithmeticException("División por cero");
                }
                yield a / b;
            }
        };
    }

    public static void main(String[] args) {
        Pila<String> palabras = new Pila<>();
        palabras.apilar("uno");
        palabras.apilar("dos");
        palabras.apilar("tres");
        System.out.println("Pila: " + palabras + " (" + palabras.tamanio() + " elementos)");
        System.out.println("Desapilo: " + palabras.desapilar() + " · cima ahora: " + palabras.cima());

        System.out.println("\"genéricos\" al revés: " + alReves("genéricos"));

        String[] expresiones = {"3 4 + 2 *", "5 1 2 + 4 * + 3 -", "2 3 4", "1 +", "4 0 /"};
        for (String expresion : expresiones) {
            try {
                System.out.println(expresion + " = " + evaluarRPN(expresion));
            } catch (PilaVaciaException e) {
                System.out.println(expresion + " → ✘ Faltan números para operar");
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(expresion + " → ✘ " + e.getMessage());
            }
        }
    }
}
