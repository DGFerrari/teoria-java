/*
 * TEMA 18 · Enums y records
 * Ejemplo 01: enums básicos
 *
 * Cómo ejecutarlo:  java T18_01_EnumBasico.java
 */
public class T18_01_EnumBasico {

    // Un tipo con 7 valores posibles, y solo esos
    enum Dia {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    enum Nivel {
        BAJO, MEDIO, ALTO
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Declarar y comparar (con ==, cada constante es un objeto único)
        // ------------------------------------------------------------
        Dia hoy = Dia.VIERNES;
        System.out.println("1. Hoy es " + hoy);
        System.out.println("   ¿Es viernes? " + (hoy == Dia.VIERNES));
        // Dia otro = "VIERNES";        // ❌ No compila: un String no es un Dia
        // Dia otro = Dia.VIERNESS;     // ❌ No compila: esa constante no existe
        System.out.println();

        // ------------------------------------------------------------
        // 2. switch: se escribe solo el nombre de la constante
        // ------------------------------------------------------------
        for (Dia d : new Dia[]{Dia.LUNES, Dia.VIERNES, Dia.DOMINGO}) {
            String plan = switch (d) {
                case LUNES, MARTES, MIERCOLES, JUEVES -> "clase y deberes";
                case VIERNES -> "clase y cine";
                case SABADO, DOMINGO -> "descanso";
            };                                   // Sin default: están todos los casos (exhaustivo)
            System.out.println("2. " + d + " → " + plan);
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3. values(), ordinal() y name()
        // ------------------------------------------------------------
        System.out.print("3. Todos los días:");
        for (Dia d : Dia.values()) {
            System.out.print(" " + d.ordinal() + "-" + d.name());
        }
        System.out.println();
        System.out.println("   La semana tiene " + Dia.values().length + " días");
        System.out.println();

        // ------------------------------------------------------------
        // 4. valueOf: de texto a constante (¡el texto tiene que coincidir exactamente!)
        // ------------------------------------------------------------
        String[] entradas = {"MARTES", "sabado", "Festivo"};
        for (String entrada : entradas) {
            try {
                Dia leido = Dia.valueOf(entrada.toUpperCase());     // Se normaliza antes
                System.out.println("4. \"" + entrada + "\" → " + leido);
            } catch (IllegalArgumentException e) {
                System.out.println("4. \"" + entrada + "\" → ✘ no es un día");
            }
        }
        System.out.println();

        // ------------------------------------------------------------
        // 5. compareTo: los enums se comparan por orden de declaración
        // ------------------------------------------------------------
        Nivel riesgo = Nivel.MEDIO;
        System.out.println("5. ¿El riesgo " + riesgo + " supera el nivel BAJO? " + (riesgo.compareTo(Nivel.BAJO) > 0));
        System.out.println("   ¿Y el ALTO? " + (riesgo.compareTo(Nivel.ALTO) > 0));
        System.out.println();

        // ------------------------------------------------------------
        // 6. Un enum como parámetro: solo se puede pasar un valor válido
        // ------------------------------------------------------------
        System.out.println("6. " + describir(Dia.SABADO));
        System.out.println("   " + describir(Dia.MIERCOLES));
    }

    static String describir(Dia dia) {
        String tipo = (dia == Dia.SABADO || dia == Dia.DOMINGO) ? "fin de semana" : "laborable";
        return dia + " es el día " + (dia.ordinal() + 1) + " de la semana (" + tipo + ")";
    }
}
