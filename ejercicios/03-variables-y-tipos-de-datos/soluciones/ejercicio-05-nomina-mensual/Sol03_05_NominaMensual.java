/*
 * TEMA 03 · Ejercicio 05 · Nómina mensual  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol03_05_NominaMensual.java
 */
public class Sol03_05_NominaMensual {

    public static void main(String[] args) {

        // Datos recibidos del formulario (todo texto, salvo la categoría)
        String nombre = "Lucía";
        char categoria = 'B';
        String horasTexto = "160";
        String precioHoraTexto = "12.5";

        // Constantes de la empresa
        final double RETENCION_IRPF = 0.15;
        final int PLUS_CATEGORIA_B = 50;
        final int PAGAS_ANUALES = 14;

        // 1. Convertir texto → número
        int horas = Integer.parseInt(horasTexto);
        double precioHora = Double.parseDouble(precioHoraTexto);

        // 2-4. Calcular (int * double → double)
        double bruto = horas * precioHora + PLUS_CATEGORIA_B;
        var retencion = bruto * RETENCION_IRPF;     // var: es evidente que es double
        var neto = bruto - retencion;

        // 5. Cortar frente a redondear
        int eurosCompletos = (int) neto;
        long netoRedondeado = Math.round(neto);

        // 6-7. Anual y en céntimos (long por si el número es muy grande)
        double netoAnual = neto * PAGAS_ANUALES;
        long centimosAnuales = Math.round(netoAnual * 100);

        // 8. Porcentaje como entero. Redondeamos (no cortamos) por la imprecisión
        //    de los double: con 0.29 * 100 = 28.999999999999996, (int) daría 28.
        long porcentaje = Math.round(RETENCION_IRPF * 100);

        // Salida
        System.out.println("=== NÓMINA DE " + nombre + " (categoría " + categoria + ") ===");
        System.out.println("Horas trabajadas: " + horas);
        System.out.println("Precio por hora: " + precioHora + " euros");
        System.out.println("Plus de categoría: " + PLUS_CATEGORIA_B + " euros");
        System.out.println("Sueldo bruto: " + bruto + " euros");
        System.out.println("Retención IRPF (" + porcentaje + "%): " + retencion + " euros");
        System.out.println("Sueldo neto: " + neto + " euros");
        System.out.println("  Euros completos: " + eurosCompletos);
        System.out.println("  Redondeado: " + netoRedondeado);
        System.out.println("Neto anual (" + PAGAS_ANUALES + " pagas): " + netoAnual + " euros");
        System.out.println("Neto anual en céntimos: " + centimosAnuales);
    }
}
