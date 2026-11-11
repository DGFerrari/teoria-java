/*
 * TEMA 18 · Ejercicio 01 · Días de la semana  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol18_01_DiasDeLaSemana.java
 */
public class Sol18_01_DiasDeLaSemana {

    enum Dia {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;

        boolean esFinDeSemana() {
            return this == SABADO || this == DOMINGO;
        }

        // Tras el DOMINGO vuelve el LUNES: el resto (%) hace que el índice "dé la vuelta"
        Dia siguiente() {
            Dia[] dias = values();
            return dias[(ordinal() + 1) % dias.length];
        }

        Dia avanzar(int cuantos) {
            Dia[] dias = values();
            return dias[(ordinal() + cuantos) % dias.length];
        }

        // LUNES → "Lun"
        String abreviatura() {
            return name().charAt(0) + name().substring(1, 3).toLowerCase();
        }
    }

    public static void main(String[] args) {
        int laborables = 0;
        for (Dia d : Dia.values()) {
            String tipo = d.esFinDeSemana() ? "fin de semana" : "laborable";
            System.out.printf("%s · %-9s · %s%n", d.abreviatura(), d, tipo);
            if (!d.esFinDeSemana()) {
                laborables++;
            }
        }
        System.out.println("Días laborables: " + laborables);

        System.out.println("Mañana (desde DOMINGO): " + Dia.DOMINGO.siguiente());
        System.out.println("Dentro de 10 días desde VIERNES: " + Dia.VIERNES.avanzar(10));

        String[] entradas = {"jueves", "Juernes"};
        for (String entrada : entradas) {
            try {
                Dia dia = Dia.valueOf(entrada.toUpperCase());
                System.out.println("\"" + entrada + "\" → " + dia);
            } catch (IllegalArgumentException e) {
                System.out.println("\"" + entrada + "\" → ✘ no es un día");
            }
        }
    }
}
