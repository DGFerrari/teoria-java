/*
 * TEMA 12 · Ejercicio 02 · Bombilla inteligente  (dificultad: 2/5)
 *
 * Objetivo: una clase cuyo estado solo cambia a través de métodos con reglas.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej12_02_BombillaInteligente.java
 */
public class Ej12_02_BombillaInteligente {

    static class Bombilla {

        // TODO 1: atributos privados (ubicacion es final)

        // TODO 2: constructor (apagada, brillo 50, 0 veces encendida)
        public Bombilla(String ubicacion) {
        }

        // TODO 3
        public void encender() {
        }

        public void apagar() {
        }

        // TODO 4: solo si está encendida y 0 <= valor <= 100
        public boolean setBrillo(int valor) {
            return false;
        }

        // TODO 5: sin pasarse de los límites, y solo si está encendida
        public void subirBrillo(int paso) {
        }

        public void bajarBrillo(int paso) {
        }

        // TODO 6: getters
        public boolean isEncendida() {
            return false;
        }

        public int getBrillo() {
            return 0;
        }

        public int getVecesEncendida() {
            return 0;
        }

        public String getUbicacion() {
            return "";
        }

        // TODO 7: "Salón: ENCENDIDA al 80%" o "Salón: apagada"
        @Override
        public String toString() {
            return "";
        }
    }

    // NO TOCAR
    public static void main(String[] args) {
        Bombilla salon = new Bombilla("Salón");
        System.out.println(salon);
        System.out.println("¿Brillo a 80 con la bombilla apagada? " + salon.setBrillo(80));

        salon.encender();
        System.out.println(salon);
        salon.subirBrillo(30);
        salon.subirBrillo(40);
        System.out.println(salon);
        System.out.println("¿Brillo a 150? " + salon.setBrillo(150));
        salon.bajarBrillo(35);
        System.out.println(salon);

        salon.apagar();
        System.out.println(salon);
        salon.encender();
        salon.encender();          // Ya estaba encendida: no cuenta
        System.out.println(salon);
        System.out.println("Veces encendida: " + salon.getVecesEncendida());
    }
}
