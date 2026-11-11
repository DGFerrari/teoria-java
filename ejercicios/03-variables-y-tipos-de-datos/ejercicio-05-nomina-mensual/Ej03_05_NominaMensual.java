/*
 * TEMA 03 · Ejercicio 05 · Nómina mensual  (dificultad: 5/5)
 *
 * Objetivo: calcular una nómina a partir de datos que llegan como texto.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej03_05_NominaMensual.java
 */
public class Ej03_05_NominaMensual {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // NO TOCAR: datos recibidos del formulario (¡todo es texto!)
        // ------------------------------------------------------------
        String nombre = "Lucía";
        char categoria = 'B';
        String horasTexto = "160";
        String precioHoraTexto = "12.5";

        // TODO 1: declara las constantes RETENCION_IRPF, PLUS_CATEGORIA_B
        //         y PAGAS_ANUALES con final.

        // TODO 2: convierte horasTexto y precioHoraTexto a número.

        // TODO 3: calcula bruto, retencion y neto.

        // TODO 4: calcula los euros completos del neto (cortando)
        //         y el neto redondeado.

        // TODO 5: calcula el neto anual y el neto anual en céntimos (long).

        // TODO 6: calcula el porcentaje de retención como entero (15)
        //         a partir de RETENCION_IRPF.

        // TODO 7: muestra la nómina (mira la salida esperada).
        //         Usa var al menos en una variable.
        System.out.println("=== NÓMINA DE " + nombre + " (categoría " + categoria + ") ===");
    }
}
