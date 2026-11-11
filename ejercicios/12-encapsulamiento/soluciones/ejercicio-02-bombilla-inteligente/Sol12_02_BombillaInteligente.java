/*
 * TEMA 12 · Ejercicio 02 · Bombilla inteligente  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol12_02_BombillaInteligente.java
 */
public class Sol12_02_BombillaInteligente {

    static class Bombilla {

        private final String ubicacion;
        private boolean encendida;
        private int brillo;
        private int vecesEncendida;

        public Bombilla(String ubicacion) {
            this.ubicacion = ubicacion;
            this.encendida = false;
            this.brillo = 50;
            this.vecesEncendida = 0;
        }

        public void encender() {
            if (!encendida) {                       // Solo cuenta si estaba apagada
                encendida = true;
                vecesEncendida++;
            }
        }

        public void apagar() {
            encendida = false;
        }

        public boolean setBrillo(int valor) {
            boolean posible = encendida && valor >= 0 && valor <= 100;
            if (posible) {
                brillo = valor;
            }
            return posible;
        }

        public void subirBrillo(int paso) {
            if (encendida) {
                brillo = Math.min(100, brillo + paso);
            }
        }

        public void bajarBrillo(int paso) {
            if (encendida) {
                brillo = Math.max(0, brillo - paso);
            }
        }

        public boolean isEncendida() {
            return encendida;
        }

        public int getBrillo() {
            return brillo;
        }

        public int getVecesEncendida() {
            return vecesEncendida;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        @Override
        public String toString() {
            return ubicacion + ": " + (encendida ? "ENCENDIDA al " + brillo + "%" : "apagada");
        }
    }

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
        salon.encender();
        System.out.println(salon);
        System.out.println("Veces encendida: " + salon.getVecesEncendida());
    }
}
