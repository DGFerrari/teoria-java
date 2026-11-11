/*
 * TEMA 17 · Ejercicio 04 · Pila genérica  (dificultad: 4/5)
 *
 * Objetivo: implementar una estructura de datos genérica y usarla con varios tipos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej17_04_PilaGenerica.java
 */
import java.util.ArrayList;
import java.util.List;

public class Ej17_04_PilaGenerica {

    // TODO 1: excepción unchecked con el mensaje "La pila está vacía"
    static class PilaVaciaException extends RuntimeException {
    }

    // TODO 2: pila genérica guardada en una List<T> (la cima es el final de la lista):
    //         apilar, desapilar y cima (estas dos lanzan PilaVaciaException si está vacía),
    //         estaVacia, tamanio y toString ("[uno, dos, tres ← cima]" o "[]")
    static class Pila<T> {
        private final List<T> elementos = new ArrayList<>();
    }

    // TODO 3: usa una Pila<Character> para devolver el texto al revés
    static String alReves(String texto) {
        return "";
    }

    // TODO 4: evalúa una expresión en notación polaca inversa con una Pila<Double>.
    //         Si al final la pila no tiene exactamente 1 elemento:
    //         IllegalArgumentException("Expresión incompleta: sobran números")
    static double evaluarRPN(String expresion) {
        return 0;
    }

    // NO TOCAR: aplica un operador
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
        // TODO 5: prueba la pila con "uno", "dos", "tres" (mira la salida esperada)

        // TODO 6: muestra "genéricos" al revés

        // NO TOCAR: las expresiones
        String[] expresiones = {"3 4 + 2 *", "5 1 2 + 4 * + 3 -", "2 3 4", "1 +", "4 0 /"};

        // TODO 7: evalúa cada expresión capturando los errores (PilaVaciaException → "Faltan números para operar")
    }
}
