/*
 * TEMA 16 · Colecciones
 * Ejemplo 05: colas (FIFO) y pilas (LIFO) con ArrayDeque
 *
 * Cómo ejecutarlo:  java T16_05_ColasYPilas.java
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class T16_05_ColasYPilas {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Cola: la sala de espera de una consulta
        // ------------------------------------------------------------
        Deque<String> salaDeEspera = new ArrayDeque<>();
        salaDeEspera.offer("Ana");              // Llegan por orden
        salaDeEspera.offer("Luis");
        salaDeEspera.offer("Marta");
        System.out.println("1. En espera: " + salaDeEspera);
        System.out.println("   Siguiente (peek, sin sacarlo): " + salaDeEspera.peek());

        salaDeEspera.offer("Pablo");            // Llega alguien más: al final
        while (!salaDeEspera.isEmpty()) {       // Se atiende en orden de llegada
            String paciente = salaDeEspera.poll();
            System.out.println("   Pasa a consulta: " + paciente + " · quedan " + salaDeEspera.size());
        }
        System.out.println("   poll() con la cola vacía: " + salaDeEspera.poll());
        System.out.println();

        // ------------------------------------------------------------
        // 2. Pila: el botón "Atrás" del navegador
        // ------------------------------------------------------------
        Deque<String> historial = new ArrayDeque<>();
        String actual = "inicio";
        String[] visitas = {"noticias", "deportes", "resultados"};
        for (String pagina : visitas) {
            historial.push(actual);             // Se apila la página que dejamos
            actual = pagina;
            System.out.println("2. Visito " + actual + " · historial: " + historial);
        }
        for (int i = 0; i < 2; i++) {
            actual = historial.pop();           // Atrás: la última que se apiló
            System.out.println("   ⬅ Atrás → " + actual + " · historial: " + historial);
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3. Una pila para comprobar paréntesis equilibrados
        // ------------------------------------------------------------
        String[] expresiones = {"(a + b) * [c - d]", "{[()]}", "(a + b]", "((x)"};
        for (String expresion : expresiones) {
            System.out.printf("3. %-18s → %s%n", expresion, estaEquilibrada(expresion) ? "equilibrada ✔" : "NO equilibrada ✘");
        }
    }

    // Cada apertura se apila; cada cierre debe coincidir con la última apertura
    static boolean estaEquilibrada(String texto) {
        Deque<Character> pila = new ArrayDeque<>();
        boolean correcta = true;
        for (int i = 0; i < texto.length() && correcta; i++) {
            char c = texto.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) {
                    correcta = false;
                } else {
                    char apertura = pila.pop();
                    correcta = (apertura == '(' && c == ')')
                            || (apertura == '[' && c == ']')
                            || (apertura == '{' && c == '}');
                }
            }
        }
        return correcta && pila.isEmpty();      // Al final no puede quedar nada abierto
    }
}
