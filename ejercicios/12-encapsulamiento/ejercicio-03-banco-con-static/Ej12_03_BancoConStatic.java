/*
 * TEMA 12 · Ejercicio 03 · Banco con static  (dificultad: 3/5)
 *
 * Objetivo: combinar miembros static (de la clase) y de instancia (de cada cuenta).
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej12_03_BancoConStatic.java
 */
public class Ej12_03_BancoConStatic {

    static class Cuenta {

        // TODO 1: miembros static: siguienteNumero (1000), cuentasCreadas (0), tipoInteres (0.02)

        // TODO 2: miembros de instancia: numero y titular (final), saldo y movimientos

        // TODO 3: constructor
        public Cuenta(String titular, double saldoInicial) {
        }

        // TODO 4: operaciones
        public boolean ingresar(double cantidad) {
            return false;
        }

        public boolean retirar(double cantidad) {
            return false;
        }

        public boolean transferir(Cuenta destino, double cantidad) {
            return false;
        }

        public void aplicarInteres() {
        }

        // TODO 5: métodos static
        public static void setTipoInteres(double nuevo) {
        }

        public static double getTipoInteres() {
            return 0;
        }

        public static int getCuentasCreadas() {
            return 0;
        }

        // TODO 6: "Cuenta 1000 (Ana): 721,00 € - 2 movimientos"
        @Override
        public String toString() {
            return "";
        }
    }

    // NO TOCAR
    public static void main(String[] args) {
        Cuenta ana = new Cuenta("Ana", 1000);
        Cuenta luis = new Cuenta("Luis", 250);
        Cuenta marta = new Cuenta("Marta", -50);

        System.out.println("Transferencia de 300 de Ana a Luis: " + ana.transferir(luis, 300));
        System.out.println("Luis retira 1000: " + luis.retirar(1000));
        marta.ingresar(80);

        Cuenta.setTipoInteres(0.5);
        Cuenta.setTipoInteres(0.03);
        System.out.println("Tipo de interés: " + Math.round(Cuenta.getTipoInteres() * 100) + "%");

        ana.aplicarInteres();
        luis.aplicarInteres();
        marta.aplicarInteres();

        System.out.println(ana);
        System.out.println(luis);
        System.out.println(marta);
        System.out.println("Cuentas creadas: " + Cuenta.getCuentasCreadas());
    }
}
