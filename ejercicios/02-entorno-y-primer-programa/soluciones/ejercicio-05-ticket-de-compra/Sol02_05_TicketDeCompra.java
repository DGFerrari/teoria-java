/**
 * TEMA 02 · Ejercicio 05 · Ticket de compra  ·  SOLUCIÓN
 *
 * Muestra el ticket de compra de la tienda "La Esquina"
 * calculando el importe de cada producto y el total.
 *
 * Cómo ejecutarlo:  java Sol02_05_TicketDeCompra.java
 *
 * @author Ana
 */
public class Sol02_05_TicketDeCompra {

    public static void main(String[] args) {

        // ENTRADA: datos de la compra
        int cantidadPan = 2;
        double precioPan = 1.25;

        int cantidadLeche = 4;
        double precioLeche = 0.75;

        int cantidadHuevos = 1;
        double precioHuevos = 2.5;

        // PROCESO: primero calculamos todo
        double importePan = cantidadPan * precioPan;
        double importeLeche = cantidadLeche * precioLeche;
        double importeHuevos = cantidadHuevos * precioHuevos;
        double total = importePan + importeLeche + importeHuevos;

        // SALIDA
        // Bloque de texto: las comillas de "LA ESQUINA" no necesitan escape
        System.out.print("""
                *********************************
                *   ULTRAMARINOS "LA ESQUINA"   *
                *   C/ Mayor, 12 - Valencia     *
                *********************************
                """);

        System.out.println("Producto\tCant.\tPrecio\tImporte");
        System.out.println("Pan\t\t" + cantidadPan + "\t" + precioPan + "\t" + importePan);
        System.out.println("Leche\t\t" + cantidadLeche + "\t" + precioLeche + "\t" + importeLeche);
        System.out.println("Huevos\t\t" + cantidadHuevos + "\t" + precioHuevos + "\t" + importeHuevos);

        System.out.println("-----------------------------");
        System.out.println("TOTAL:\t\t\t\t" + total + " euros");
        System.out.println("-----------------------------");

        System.out.println("Gracias por su compra. \"¡Vuelva pronto!\"");
        System.out.println("Ref. tienda: VLC\\042\\T1");
    }
}
