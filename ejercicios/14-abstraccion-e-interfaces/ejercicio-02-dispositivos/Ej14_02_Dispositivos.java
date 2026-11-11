/*
 * TEMA 14 · Ejercicio 02 · Dispositivos  (dificultad: 2/5)
 *
 * Objetivo: implementar interfaces (varias a la vez) y usar un método default.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej14_02_Dispositivos.java
 *
 * La plantilla no compila hasta que crees Lampara, Movil y PowerBank: es normal.
 */
public class Ej14_02_Dispositivos {

    interface Encendible {
        void encender();

        void apagar();

        boolean estaEncendido();
    }

    interface Recargable {
        int getBateria();

        void cargar(int porcentaje);

        // TODO 1: true si la batería está por debajo del 20 %
        default boolean necesitaCarga() {
            return false;
        }
    }

    // TODO 2: Lampara implements Encendible

    // TODO 3: Movil implements Encendible, Recargable (no se enciende con 0 % de batería)

    // TODO 4: PowerBank implements Recargable

    // NO TOCAR
    public static void main(String[] args) {
        Object[] dispositivos = {new Lampara(), new Movil(), new PowerBank(15)};

        ((Lampara) dispositivos[0]).encender();
        ((Movil) dispositivos[1]).encender();         // Con 0 % no se enciende
        mostrar(dispositivos);

        System.out.println("--- Cargando todos los recargables un 50% ---");
        for (Object d : dispositivos) {
            if (d instanceof Recargable r) {
                r.cargar(50);
            }
        }
        ((Movil) dispositivos[1]).encender();         // Ahora sí
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
