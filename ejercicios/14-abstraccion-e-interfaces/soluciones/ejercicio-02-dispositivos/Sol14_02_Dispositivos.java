/*
 * TEMA 14 · Ejercicio 02 · Dispositivos  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol14_02_Dispositivos.java
 */
public class Sol14_02_Dispositivos {

    interface Encendible {
        void encender();

        void apagar();

        boolean estaEncendido();
    }

    interface Recargable {
        int getBateria();

        void cargar(int porcentaje);

        default boolean necesitaCarga() {
            return getBateria() < 20;        // Usa el método abstracto: lo implementará cada clase
        }
    }

    static class Lampara implements Encendible {
        private boolean encendida = false;

        @Override
        public void encender() {
            encendida = true;
        }

        @Override
        public void apagar() {
            encendida = false;
        }

        @Override
        public boolean estaEncendido() {
            return encendida;
        }

        @Override
        public String toString() {
            return "Lámpara: " + (encendida ? "encendida" : "apagada");
        }
    }

    static class Movil implements Encendible, Recargable {
        private boolean encendido = false;
        private int bateria = 0;

        @Override
        public void encender() {
            if (bateria > 0) {               // Sin batería no se enciende
                encendido = true;
            }
        }

        @Override
        public void apagar() {
            encendido = false;
        }

        @Override
        public boolean estaEncendido() {
            return encendido;
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
        public String toString() {
            return "Móvil: " + (encendido ? "encendido" : "apagado") + ", batería " + bateria + "%"
                    + (necesitaCarga() ? " (necesita carga)" : "");
        }
    }

    static class PowerBank implements Recargable {
        private int bateria;

        PowerBank(int bateria) {
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
        public String toString() {
            return "PowerBank: batería " + bateria + "%" + (necesitaCarga() ? " (necesita carga)" : "");
        }
    }

    public static void main(String[] args) {
        Object[] dispositivos = {new Lampara(), new Movil(), new PowerBank(15)};

        ((Lampara) dispositivos[0]).encender();
        ((Movil) dispositivos[1]).encender();
        mostrar(dispositivos);

        System.out.println("--- Cargando todos los recargables un 50% ---");
        for (Object d : dispositivos) {
            if (d instanceof Recargable r) {
                r.cargar(50);
            }
        }
        ((Movil) dispositivos[1]).encender();
        mostrar(dispositivos);

        System.out.println("--- Apagando todos los encendibles ---");
        for (Object d : dispositivos) {
            if (d instanceof Encendible e) {
                e.apagar();
            }
        }
        mostrar(dispositivos);
    }

    static void mostrar(Object[] dispositivos) {
        for (Object d : dispositivos) {
            System.out.println(d);
        }
    }
}
