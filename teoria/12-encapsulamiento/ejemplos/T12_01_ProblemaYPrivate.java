/*
 * TEMA 12 · Encapsulamiento
 * Ejemplo 01: EL PROBLEMA DE LOS ATRIBUTOS SIN PROTECCIÓN Y EL MODIFICADOR private
 *
 * ¡Ojo! En este ejemplo las clases auxiliares están FUERA de la clase principal
 * (después de ella), para que el compilador aplique de verdad la protección de private.
 * Es la excepción del repositorio: mira la sección 10 de la teoría.
 *
 * Cómo ejecutarlo:  java T12_01_ProblemaYPrivate.java
 */
public class T12_01_ProblemaYPrivate {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Sin encapsular: cualquiera deja el objeto en un estado absurdo
        // ------------------------------------------------------------
        TermostatoSinProteger salon = new TermostatoSinProteger();
        salon.temperatura = 21;
        System.out.println("Salón: " + salon.temperatura + " ºC");

        salon.temperatura = 450;               // 😱 Nadie lo impide
        System.out.println("Salón: " + salon.temperatura + " ºC (¿un horno?)");
        System.out.println();

        // ------------------------------------------------------------
        // 2. Encapsulado: la temperatura solo cambia a través de métodos que comprueban
        // ------------------------------------------------------------
        Termostato dormitorio = new Termostato(20);
        System.out.println("Dormitorio: " + dormitorio.getTemperatura() + " ºC");

        dormitorio.subir();
        dormitorio.subir();
        System.out.println("Tras subir dos veces: " + dormitorio.getTemperatura() + " ºC");

        dormitorio.ajustar(450);               // El propio objeto rechaza el valor
        dormitorio.ajustar(24);
        System.out.println("Tras ajustar: " + dormitorio.getTemperatura() + " ºC");

        // dormitorio.temperatura = 450;
        // ❌ Error de compilación: temperatura has private access in Termostato

        // dormitorio.estaEnRango(450);
        // ❌ Error de compilación: estaEnRango(int) has private access in Termostato

        // PRUEBA: descomenta las dos líneas marcadas con ❌ y lee el error.
    }
}

// ================================================================
// Clases auxiliares fuera de la principal (solo en este ejemplo)
// ================================================================

/** Sin encapsular: el atributo se puede tocar desde cualquier sitio. */
class TermostatoSinProteger {
    int temperatura;
}

/** Encapsulado: atributo privado y métodos públicos que validan. */
class Termostato {

    private static final int MINIMA = 10;
    private static final int MAXIMA = 30;

    private int temperatura;                   // Solo accesible desde DENTRO de esta clase

    public Termostato(int temperaturaInicial) {
        temperatura = MINIMA;                  // Valor seguro por si el inicial no es válido
        ajustar(temperaturaInicial);
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void subir() {
        ajustar(temperatura + 1);
    }

    public void bajar() {
        ajustar(temperatura - 1);
    }

    public void ajustar(int nueva) {
        if (estaEnRango(nueva)) {
            temperatura = nueva;
        } else {
            System.out.println("  ⚠ " + nueva + " ºC no es válido (rango " + MINIMA + "-" + MAXIMA + ")");
        }
    }

    // Método de ayuda interno: private
    private boolean estaEnRango(int valor) {
        return valor >= MINIMA && valor <= MAXIMA;
    }
}
