/*
 * TEMA 13 · Herencia y polimorfismo
 * Ejemplo 01: extends (superclase y subclases)
 *
 * Cómo ejecutarlo:  java T13_01_Extends.java
 */
public class T13_01_Extends {

    // ------------------------------------------------------------
    // SUPERCLASE: lo común a todos los vehículos
    // ------------------------------------------------------------
    static class Vehiculo {
        protected String matricula;          // protected: accesible desde las subclases
        protected int velocidad;
        private int kilometros;              // private: ni las subclases lo tocan directamente

        public Vehiculo(String matricula) {
            this.matricula = matricula;
        }

        public void acelerar(int incremento) {
            velocidad += incremento;
        }

        public void frenar() {
            velocidad = 0;
        }

        public void recorrer(int km) {
            kilometros += km;
        }

        public int getKilometros() {         // Las subclases usan el getter para leerlo
            return kilometros;
        }

        public String describir() {
            return matricula + " a " + velocidad + " km/h (" + kilometros + " km recorridos)";
        }
    }

    // ------------------------------------------------------------
    // SUBCLASES: heredan todo lo de Vehiculo y añaden lo suyo
    // ------------------------------------------------------------
    static class Coche extends Vehiculo {
        private final int numeroPuertas;

        public Coche(String matricula, int numeroPuertas) {
            super(matricula);                // Inicializa la parte de Vehiculo (tema: ejemplo 02)
            this.numeroPuertas = numeroPuertas;
        }

        public void abrirMaletero() {
            System.out.println("  " + matricula + ": maletero abierto");   // Usa un atributo protected heredado
        }

        public int getNumeroPuertas() {
            return numeroPuertas;
        }
    }

    static class Moto extends Vehiculo {
        private boolean caballete;

        public Moto(String matricula) {
            super(matricula);
            this.caballete = true;
        }

        public void quitarCaballete() {
            caballete = false;
            System.out.println("  " + matricula + ": caballete recogido");
        }

        public void hacerCaballito() {
            if (!caballete && velocidad > 20) {
                System.out.println("  " + matricula + ": ¡caballito!");
            } else {
                System.out.println("  " + matricula + ": ahora no se puede hacer un caballito");
            }
            // kilometros = 0;   // ❌ Error: kilometros has private access in Vehiculo
        }
    }

    public static void main(String[] args) {

        Coche coche = new Coche("1234ABC", 5);
        Moto moto = new Moto("5678XYZ");

        // Métodos HEREDADOS de Vehiculo: los dos los tienen
        coche.acelerar(90);
        coche.recorrer(120);
        moto.acelerar(40);
        moto.recorrer(35);

        System.out.println("Coche: " + coche.describir());
        System.out.println("Moto:  " + moto.describir());

        // Métodos PROPIOS de cada subclase
        coche.abrirMaletero();
        System.out.println("  El coche tiene " + coche.getNumeroPuertas() + " puertas");
        moto.hacerCaballito();
        moto.quitarCaballete();
        moto.hacerCaballito();

        // moto.abrirMaletero();    // ❌ Error: Moto no tiene ese método (es de Coche)

        // Un objeto de la superclase NO tiene los métodos de las subclases
        Vehiculo generico = new Vehiculo("0000AAA");
        generico.acelerar(10);
        System.out.println("Genérico: " + generico.describir());
        // generico.abrirMaletero(); // ❌ Error

        // PRUEBA: crea una subclase "Camion" con un atributo "carga" (toneladas)
        //    y un método "cargar(int toneladas)" que no permita pasar de 20.
    }
}
