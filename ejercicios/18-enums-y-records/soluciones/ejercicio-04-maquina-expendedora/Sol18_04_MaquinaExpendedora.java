/*
 * TEMA 18 · Ejercicio 04 · Máquina expendedora  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol18_04_MaquinaExpendedora.java
 */
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sol18_04_MaquinaExpendedora {

    // Declaradas de MAYOR a MENOR: values() las recorre en ese orden (necesario para el cambio)
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
        private final int precio;                  // En céntimos, para evitar errores de redondeo

        Producto(String codigo, int precio) {
            this.codigo = codigo;
            this.precio = precio;
        }

        int getPrecio() {
            return precio;
        }

        static Producto porCodigo(String codigo) {
            Producto encontrado = null;
            Producto[] todos = values();
            for (int i = 0; i < todos.length && encontrado == null; i++) {
                if (todos[i].codigo.equals(codigo)) {
                    encontrado = todos[i];
                }
            }
            return encontrado;
        }
    }

    // El resultado de una compra: datos inmutables
    record Venta(Producto producto, int pagado, int cambio) { }

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

        Venta comprar(String codigo, List<Moneda> monedas) {
            Producto producto = Producto.porCodigo(codigo);
            if (producto == null) {
                throw new IllegalArgumentException("Código desconocido: " + codigo);
            }
            if (stock.getOrDefault(producto, 0) == 0) {
                throw new IllegalStateException(producto + " agotado");
            }
            int pagado = 0;
            for (Moneda m : monedas) {
                pagado += m.getCentimos();
            }
            if (pagado < producto.getPrecio()) {
                throw new IllegalArgumentException("Importe insuficiente: faltan " + euros(producto.getPrecio() - pagado));
            }
            stock.put(producto, stock.get(producto) - 1);
            recaudado += producto.getPrecio();
            ventas++;
            return new Venta(producto, pagado, pagado - producto.getPrecio());
        }

        // Algoritmo voraz: siempre la moneda más grande que quepa
        static Map<Moneda, Integer> desglose(int centimos) {
            Map<Moneda, Integer> monedas = new EnumMap<>(Moneda.class);
            int pendiente = centimos;
            for (Moneda m : Moneda.values()) {
                int cuantas = pendiente / m.getCentimos();
                if (cuantas > 0) {
                    monedas.put(m, cuantas);
                    pendiente = pendiente % m.getCentimos();
                }
            }
            return monedas;
        }

        Set<Producto> agotados() {
            Set<Producto> resultado = EnumSet.noneOf(Producto.class);
            for (Map.Entry<Producto, Integer> par : stock.entrySet()) {
                if (par.getValue() == 0) {
                    resultado.add(par.getKey());
                }
            }
            return resultado;
        }

        void mostrarResumen() {
            System.out.println("=== Resumen ===");
            System.out.println("Ventas: " + ventas + " · recaudado: " + euros(recaudado));
            System.out.println("Stock: " + stock);
            System.out.println("Agotados: " + agotados());
        }
    }

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
