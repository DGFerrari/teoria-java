import java.util.Scanner;

/*
 * TEMA 15 · Ejercicio 05 · Evaluador de expresiones  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol15_05_EvaluadorDeExpresiones.java
 */
public class Sol15_05_EvaluadorDeExpresiones {

    // Excepción propia CHECKED que guarda el número de línea y, opcionalmente, la CAUSA original
    static class ExpresionInvalidaException extends Exception {
        private final int linea;

        public ExpresionInvalidaException(String mensaje, int linea) {
            super(mensaje);
            this.linea = linea;
        }

        public ExpresionInvalidaException(String mensaje, int linea, Throwable causa) {
            super(mensaje, causa);          // Exception guarda la causa: getCause() la devuelve
            this.linea = linea;
        }

        public int getLinea() {
            return linea;
        }
    }

    // Recurso propio: al cerrarse (automáticamente) muestra el resumen
    static class Informe implements AutoCloseable {
        private int correctas;
        private int errores;
        private double suma;

        public void anotarCorrecta(double resultado) {
            correctas++;
            suma += resultado;
        }

        public void anotarError() {
            errores++;
        }

        @Override
        public void close() {
            System.out.println("[Informe] Correctas: " + correctas + " | Errores: " + errores
                    + " | Suma de resultados: " + formatear(suma));
        }
    }

    // Solo sabe calcular. Lanza excepciones estándar (unchecked) si no puede
    static double operar(double a, String operador, double b) {
        return switch (operador) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("División por cero");   // Con double no salta sola
                }
                yield a / b;
            }
            case "^" -> Math.pow(a, b);
            default -> throw new IllegalArgumentException("Operador desconocido: " + operador);
        };
    }

    // Traduce cualquier problema a NUESTRA excepción, añadiendo el contexto (la línea)
    static double evaluar(String expresion, int linea) throws ExpresionInvalidaException {
        String[] partes = expresion.strip().split(" +");
        if (partes.length != 3) {
            throw new ExpresionInvalidaException("Se esperaban 3 elementos y hay " + partes.length, linea);
        }

        double a;
        double b;
        try {
            a = Double.parseDouble(partes[0]);
            b = Double.parseDouble(partes[2]);
        } catch (NumberFormatException e) {
            throw new ExpresionInvalidaException("Número no válido", linea, e);    // Encadenada
        }

        try {
            return operar(a, partes[1], b);
        } catch (ArithmeticException | IllegalArgumentException e) {             // Multi-catch
            throw new ExpresionInvalidaException("Error al operar", linea, e);     // Encadenada
        }
    }

    // 1024.0 → "1024"   ·   2.5 → "2.5"
    static String formatear(double valor) {
        String texto;
        if (valor == Math.floor(valor) && !Double.isInfinite(valor)) {
            texto = String.valueOf((long) valor);
        } else {
            texto = String.valueOf(valor);
        }
        return texto;
    }

    public static void main(String[] args) {
        String expresiones = """
                3 + 4
                10 / 4
                7 * -2
                2 ^ 10
                8 / 0
                cinco + 2
                4 % 3
                9 - 3 - 1
                """;

        // Dos recursos: se cierran en orden INVERSO (primero el informe, luego el Scanner)
        try (Scanner lector = new Scanner(expresiones);
             Informe informe = new Informe()) {
            int numLinea = 0;
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                numLinea++;
                try {
                    double resultado = evaluar(linea, numLinea);
                    System.out.printf("Línea %d: %-10s → %s%n", numLinea, linea, formatear(resultado));
                    informe.anotarCorrecta(resultado);
                } catch (ExpresionInvalidaException e) {
                    String detalle = e.getMessage();
                    if (e.getCause() != null) {
                        detalle = detalle + " (causa: " + e.getCause().getMessage() + ")";
                    }
                    System.out.printf("Línea %d: %-10s ✘ %s%n", e.getLinea(), linea, detalle);
                    informe.anotarError();
                }
            }
        }
    }
}
