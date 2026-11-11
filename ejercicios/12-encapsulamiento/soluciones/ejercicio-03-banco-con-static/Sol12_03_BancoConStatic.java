/*
 * TEMA 12 · Ejercicio 03 · Banco con static  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol12_03_BancoConStatic.java
 */
public class Sol12_03_BancoConStatic {

    static class Cuenta {

        // Del banco: una sola copia para todas las cuentas
        private static int siguienteNumero = 1000;
        private static int cuentasCreadas = 0;
        private static double tipoInteres = 0.02;

        // De cada cuenta
        private final int numero;
        private final String titular;
        private double saldo;
        private int movimientos;

        public Cuenta(String titular, double saldoInicial) {
            this.numero = siguienteNumero;     // Número único y automático
            siguienteNumero++;
            cuentasCreadas++;
            this.titular = titular;
            if (saldoInicial >= 0) {
                this.saldo = saldoInicial;
            } else {
                System.out.println("  ⚠ Saldo inicial no válido, se usa 0");
                this.saldo = 0;
            }
            this.movimientos = 0;
        }

        public boolean ingresar(double cantidad) {
            boolean posible = cantidad > 0;
            if (posible) {
                saldo += cantidad;
                movimientos++;
            }
            return posible;
        }

        public boolean retirar(double cantidad) {
            boolean posible = cantidad > 0 && cantidad <= saldo;
            if (posible) {
                saldo -= cantidad;
                movimientos++;
            }
            return posible;
        }

        public boolean transferir(Cuenta destino, double cantidad) {
            boolean hecho = retirar(cantidad);       // De esta cuenta...
            if (hecho) {
                destino.ingresar(cantidad);          // ...a la otra, solo si ha salido bien
            }
            return hecho;
        }

        public void aplicarInteres() {
            saldo += saldo * tipoInteres;            // Un método de instancia puede usar los static
            movimientos++;
        }

        public static void setTipoInteres(double nuevo) {
            if (nuevo >= 0 && nuevo <= 0.1) {
                tipoInteres = nuevo;
            } else {
                System.out.println("  ⚠ Tipo de interés no válido: " + nuevo);
            }
        }

        public static double getTipoInteres() {
            return tipoInteres;
        }

        public static int getCuentasCreadas() {
            return cuentasCreadas;
        }

        public int getNumero() {
            return numero;
        }

        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }

        public int getMovimientos() {
            return movimientos;
        }

        @Override
        public String toString() {
            return String.format("Cuenta %d (%s): %,.2f € - %d movimientos", numero, titular, saldo, movimientos);
        }
    }

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
