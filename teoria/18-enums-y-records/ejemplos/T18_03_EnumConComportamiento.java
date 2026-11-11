/*
 * TEMA 18 · Enums y records
 * Ejemplo 03: comportamiento distinto por constante, EnumMap y EnumSet
 *
 * Cómo ejecutarlo:  java T18_03_EnumConComportamiento.java
 */
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class T18_03_EnumConComportamiento {

    // Opción A: switch sobre this
    enum Semaforo {
        VERDE, AMBAR, ROJO;

        Semaforo siguiente() {
            return switch (this) {
                case VERDE -> AMBAR;
                case AMBAR -> ROJO;
                case ROJO -> VERDE;
            };
        }

        int segundos() {
            return switch (this) {
                case VERDE -> 30;
                case AMBAR -> 5;
                case ROJO -> 25;
            };
        }
    }

    // Opción B: un método abstracto que cada constante implementa
    enum Operacion {
        SUMA("+") {
            @Override
            double aplicar(double a, double b) {
                return a + b;
            }
        },
        RESTA("-") {
            @Override
            double aplicar(double a, double b) {
                return a - b;
            }
        },
        MULTIPLICACION("×") {
            @Override
            double aplicar(double a, double b) {
                return a * b;
            }
        },
        POTENCIA("^") {
            @Override
            double aplicar(double a, double b) {
                return Math.pow(a, b);
            }
        };

        private final String simbolo;

        Operacion(String simbolo) {
            this.simbolo = simbolo;
        }

        abstract double aplicar(double a, double b);    // Si una constante no lo implementa, no compila

        String getSimbolo() {
            return simbolo;
        }
    }

    enum Dia {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Un ciclo de semáforo
        // ------------------------------------------------------------
        Semaforo luz = Semaforo.ROJO;
        int total = 0;
        System.out.print("1. Ciclo:");
        for (int i = 0; i < 4; i++) {
            System.out.print(" " + luz + " (" + luz.segundos() + " s)");
            total += luz.segundos();
            luz = luz.siguiente();
        }
        System.out.println();
        System.out.println("   Duración: " + total + " s");
        System.out.println();

        // ------------------------------------------------------------
        // 2. Cada operación sabe calcularse
        // ------------------------------------------------------------
        for (Operacion op : Operacion.values()) {
            System.out.println("2. 3 " + op.getSimbolo() + " 4 = " + op.aplicar(3, 4));
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3. EnumMap: un mapa con claves de un enum (mantiene el orden de declaración)
        // ------------------------------------------------------------
        Map<Dia, Integer> horasDeEstudio = new EnumMap<>(Dia.class);
        horasDeEstudio.put(Dia.VIERNES, 1);
        horasDeEstudio.put(Dia.LUNES, 2);
        horasDeEstudio.put(Dia.MIERCOLES, 3);
        System.out.println("3. Horas de estudio: " + horasDeEstudio + "   ← ordenado por día, no por inserción");
        System.out.println();

        // ------------------------------------------------------------
        // 4. EnumSet: conjuntos de constantes
        // ------------------------------------------------------------
        Set<Dia> finde = EnumSet.of(Dia.SABADO, Dia.DOMINGO);
        Set<Dia> laborables = EnumSet.range(Dia.LUNES, Dia.VIERNES);
        Set<Dia> conEntreno = EnumSet.of(Dia.MARTES, Dia.JUEVES, Dia.SABADO);
        Set<Dia> libres = EnumSet.complementOf(EnumSet.copyOf(conEntreno));
        System.out.println("4. Fin de semana: " + finde);
        System.out.println("   Laborables: " + laborables);
        System.out.println("   Días sin entreno: " + libres);
        System.out.println("   ¿Entreno el sábado? " + conEntreno.contains(Dia.SABADO));
    }
}
