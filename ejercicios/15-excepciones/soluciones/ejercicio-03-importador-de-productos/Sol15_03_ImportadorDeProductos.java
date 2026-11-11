/*
 * TEMA 15 · Ejercicio 03 · Importador de productos  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol15_03_ImportadorDeProductos.java
 */
public class Sol15_03_ImportadorDeProductos {

    static class Producto {
        private final String codigo;
        private final String nombre;
        private final double precio;
        private final int stock;

        // Imposible crear un producto incorrecto: si algo falla, se lanza la excepción
        public Producto(String codigo, String nombre, double precio, int stock) {
            if (!esCodigoValido(codigo)) {
                throw new IllegalArgumentException("Código no válido: " + codigo);
            }
            if (nombre.isBlank()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            }
            if (precio <= 0) {
                throw new IllegalArgumentException("El precio debe ser positivo: " + precio);
            }
            if (stock < 0) {
                throw new IllegalArgumentException("El stock no puede ser negativo: " + stock);
            }
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        private static boolean esCodigoValido(String codigo) {
            boolean valido = codigo.length() == 5 && codigo.startsWith("P-");
            for (int i = 2; i < codigo.length() && valido; i++) {
                valido = Character.isDigit(codigo.charAt(i));
            }
            return valido;
        }

        // Traduce texto a producto. No captura nada: los errores suben a quien llama
        public static Producto desdeLinea(String linea) {
            String[] campos = linea.split(";");
            if (campos.length != 4) {
                throw new IllegalArgumentException("Faltan campos");
            }
            double precio = Double.parseDouble(campos[2].strip());   // Puede: NumberFormatException
            int stock = Integer.parseInt(campos[3].strip());
            return new Producto(campos[0].strip(), campos[1].strip(), precio, stock);
        }

        public double getValor() {
            return precio * stock;
        }

        @Override
        public String toString() {
            return String.format("%s %-18s %6.2f € x %2d", codigo, nombre, precio, stock);
        }
    }

    public static void main(String[] args) {
        String datos = """
                P-001;Teclado mecánico;59.90;12
                P-002;Ratón;19.5;30
                P-03;Monitor;189;4
                P-004;;9.99;10
                P-005;Cable HDMI;-3;50
                P-006;Webcam;cuarenta;7
                P-007;Alfombrilla;8.75
                P-008;Hub USB;24.99;-2
                P-009;Altavoces;45;6
                """;
        String[] lineas = datos.strip().split("\n");
        Producto[] importados = new Producto[lineas.length];
        int numImportados = 0;
        int errores = 0;

        // Un try POR LÍNEA: un error no detiene la importación
        for (int i = 0; i < lineas.length; i++) {
            try {
                importados[numImportados] = Producto.desdeLinea(lineas[i]);
                numImportados++;                                   // Solo si no ha habido excepción
            } catch (NumberFormatException e) {                    // Subclase primero...
                System.out.println("Línea " + (i + 1) + " ✘ Número no válido (" + e.getMessage() + ")");
                errores++;
            } catch (IllegalArgumentException e) {                 // ...superclase después
                System.out.println("Línea " + (i + 1) + " ✘ " + e.getMessage());
                errores++;
            }
        }

        System.out.println("=== Importados: " + numImportados + " | Con errores: " + errores + " ===");
        double valorTotal = 0;
        for (int i = 0; i < numImportados; i++) {
            System.out.println(importados[i]);
            valorTotal += importados[i].getValor();
        }
        System.out.printf("Valor del inventario: %,.2f €%n", valorTotal);
    }
}
