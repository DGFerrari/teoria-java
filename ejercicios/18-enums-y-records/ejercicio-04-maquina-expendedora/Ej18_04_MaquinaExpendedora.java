/*
 * TEMA 18 · Ejercicio 04 · Máquina expendedora  (dificultad: 4/5)
 *
 * Objetivo: combinar enums con datos, un record, EnumMap y EnumSet.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej18_04_MaquinaExpendedora.java
 */
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ej18_04_MaquinaExpendedora {

    // NO TOCAR: las monedas, de mayor a menor
    enum Moneda {
        DOS_EUROS(200), UN_EURO(100), CINCUENTA(50), VEINTE(20), DIEZ(10), CINCO(5);

        private final int centimos;

        Moneda(int centimos) {
            this.centimos = centimos;
        }

        int getCentimos() {
            return centimos;
        }

        @Override
        public String toString() {
            return centimos >= 100 ? (centimos / 100) + " €" : centimos + " cts";
        }
    }

    enum Producto {
        AGUA("A1", 90), REFRESCO("A2", 150), ZUMO("B1", 175), CHOCOLATINA("B2", 120), PATATAS("C1", 135);

        private final String codigo;
        private final int precio;                  // En céntimos

        Producto(String codigo, int precio) {
            this.codigo = codigo;
            this.precio = precio;
        }

        int getPrecio() {
            return precio;
        }

        // TODO 1: el producto con ese código, o null si no existe (recorre values() con bandera)
        static Producto porCodigo(String codigo) {
            return null;
        }
    }

    // NO TOCAR: el resultado de una compra
    record Venta(Producto producto, int pagado, int cambio) { }

    // NO TOCAR: 135 → "1,35 €"
    static String euros(int centimos) {
        return String.format("%.2f €", centimos / 100.0);
    }

    static class Maquina {
        private final Map<Producto, Integer> stock = new EnumMap<>(Producto.class);
        private int recaudado;
        private int ventas;

        void reponer(Producto producto, int unidades) {
            stock.put(producto, stock.getOrDefault(producto, 0) + unidades);
        }

        // TODO 2: lanza IllegalArgumentException("Código desconocido: Z9") si no existe,
        //         IllegalStateException("ZUMO agotado") si no hay stock e
        //         IllegalArgumentException("Importe insuficiente: faltan 0,35 €") si no llega.
        //         Si todo va bien: resta stock, suma a lo recaudado y devuelve la Venta
        Venta comprar(String codigo, List<Moneda> monedas) {
            return null;
        }

        // TODO 3: cuántas monedas de cada tipo hay que devolver (siempre la más grande que quepa)
        static Map<Moneda, Integer> desglose(int centimos) {
            return new EnumMap<>(Moneda.class);
        }

        // TODO 4: los productos con stock 0, en un EnumSet
        Set<Producto> agotados() {
            return EnumSet.noneOf(Producto.class);
        }

        // TODO 5: ventas, recaudado, stock y agotados (mira la salida esperada)
        void mostrarResumen() {
        }
    }

    // NO TOCAR: {VEINTE=1, CINCO=1} → "1 × 20 cts, 1 × 5 cts"
    static String textoDesglose(Map<Moneda, Integer> monedas) {
        StringBuilder texto = new StringBuilder();
        for (Map.Entry<Moneda, Integer> par : monedas.entrySet()) {
            if (texto.length() > 0) {
                texto.append(", ");
            }
            texto.append(par.getValue()).append(" × ").append(par.getKey());
        }
        return texto.toString();
    }

    public static void main(String[] args) {
        // NO TOCAR
        Maquina maquina = new Maquina();
        maquina.reponer(Producto.AGUA, 3);
        maquina.reponer(Producto.REFRESCO, 2);
        maquina.reponer(Producto.ZUMO, 1);
        maquina.reponer(Producto.CHOCOLATINA, 0);
        maquina.reponer(Producto.PATATAS, 4);

        String[] codigos = {"A2", "B1", "C1", "Z9", "A1", "B1"};
        List<List<Moneda>> pagos = List.of(
                List.of(Moneda.UN_EURO, Moneda.CINCUENTA),
                List.of(Moneda.DOS_EUROS),
                List.of(Moneda.UN_EURO),
                List.of(Moneda.UN_EURO),
                List.of(Moneda.DOS_EUROS, Moneda.DOS_EUROS),
                List.of(Moneda.DOS_EUROS));

        for (int i = 0; i < codigos.length; i++) {
            System.out.print(codigos[i] + " con " + pagos.get(i) + " → ");
            try {
                Venta venta = maquina.comprar(codigos[i], pagos.get(i));
                System.out.print("✔ " + venta.producto() + " (" + euros(venta.producto().getPrecio()) + ")");
                if (venta.cambio() > 0) {
                    System.out.print(" · cambio " + euros(venta.cambio()) + ": "
                            + textoDesglose(Maquina.desglose(venta.cambio())));
                }
                System.out.println();
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("✘ " + e.getMessage() + " (se devuelve el dinero)");
            }
        }
        maquina.mostrarResumen();
    }
}
