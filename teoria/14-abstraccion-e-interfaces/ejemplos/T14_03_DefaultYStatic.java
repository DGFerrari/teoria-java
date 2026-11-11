/*
 * TEMA 14 · Abstracción e interfaces
 * Ejemplo 03: MÉTODOS default, static Y private EN INTERFACES
 *
 * Cómo ejecutarlo:  java T14_03_DefaultYStatic.java
 */
public class T14_03_DefaultYStatic {

    interface Recargable {

        int NIVEL_BAJO = 20;

        // Abstractos: el contrato
        int getBateria();

        void cargar(int porcentaje);

        String getNombre();

        // default: implementación por defecto, basada en los métodos abstractos
        default boolean necesitaCarga() {
            return getBateria() < NIVEL_BAJO;
        }

        default String estado() {
            return getNombre() + ": " + barra(getBateria()) + " " + getBateria() + "%"
                    + (necesitaCarga() ? " ⚠ ¡cárgame!" : "");
        }

        // static: utilidad de la interfaz (se llama Recargable.cargarTodos(...))
        static void cargarTodos(Recargable[] dispositivos, int porcentaje) {
            for (Recargable r : dispositivos) {
                r.cargar(porcentaje);
            }
        }

        // private (Java 9+): ayuda interna para los default; las clases no lo ven
        private String barra(int nivel) {
            int bloques = nivel / 10;
            return "[" + "█".repeat(bloques) + "·".repeat(10 - bloques) + "]";
        }
    }

    static class Movil implements Recargable {
        private int bateria;

        Movil(int bateria) {
            this.bateria = bateria;
        }

        @Override
        public int getBateria() {
            return bateria;
        }

        @Override
        public void cargar(int porcentaje) {
            bateria = Math.min(100, bateria + porcentaje);
        }

        @Override
        public String getNombre() {
            return "Móvil";
        }
        // Usa los default tal cual
    }

    static class Patinete implements Recargable {
        private int bateria;

        Patinete(int bateria) {
            this.bateria = bateria;
        }

        @Override
        public int getBateria() {
            return bateria;
        }

        @Override
        public void cargar(int porcentaje) {
            bateria = Math.min(100, bateria + porcentaje / 2);   // Carga más despacio
        }

        @Override
        public String getNombre() {
            return "Patinete";
        }

        // Sobrescribe un default: el patinete necesita carga antes (para no quedarse tirado)
        @Override
        public boolean necesitaCarga() {
            return getBateria() < 40;
        }
    }

    public static void main(String[] args) {

        Recargable[] dispositivos = {new Movil(15), new Patinete(35), new Movil(80)};

        System.out.println("Antes de cargar:");
        for (Recargable r : dispositivos) {
            System.out.println("  " + r.estado());     // estado() es default
        }

        Recargable.cargarTodos(dispositivos, 30);      // Método static de la interfaz

        System.out.println("Después de cargar un 30%:");
        for (Recargable r : dispositivos) {
            System.out.println("  " + r.estado());
        }

        System.out.println("Nivel considerado bajo: " + Recargable.NIVEL_BAJO + "%");

        // ¿Por qué existen los default? Si mañana se añade un método nuevo a Recargable,
        // con default las clases que ya la implementan siguen compilando sin cambios.
    }
}
