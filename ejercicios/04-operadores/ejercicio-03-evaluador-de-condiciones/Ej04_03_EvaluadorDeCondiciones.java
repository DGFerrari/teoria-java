/*
 * TEMA 04 · Ejercicio 03 · Evaluador de condiciones  (dificultad: 3/5)
 *
 * Objetivo: traducir reglas en expresiones boolean.
 *
 * Lee el ENUNCIADO.md antes de empezar (ahí está la tabla de reglas).
 * Cómo ejecutarlo:  java Ej04_03_EvaluadorDeCondiciones.java
 */
public class Ej04_03_EvaluadorDeCondiciones {

    public static void main(String[] args) {

        // NO TOCAR (salvo para probar otros casos): datos del visitante
        int edad = 16;
        double alturaCm = 152;
        boolean tieneEntrada = true;
        boolean esVip = false;
        double saldo = 12.5;
        double precioFotografia = 10;
        int anio = 2024;
        double temperaturaCorporal = 38.2;

        // TODO: sustituye cada "false" por la expresión correcta.
        boolean puedeComprarFoto = false;
        boolean puedeEntrar = false;
        boolean tieneDescuento = false;
        boolean puedeSubirMontania = false;
        boolean esBisiesto = false;
        boolean debeIrEnfermeria = false;
        boolean esVisitanteNormal = false;

        // Ya hecho: salida
        System.out.println("¿Puede comprar la foto? " + puedeComprarFoto);
        System.out.println("¿Puede entrar? " + puedeEntrar);
        System.out.println("¿Tiene descuento? " + tieneDescuento);
        System.out.println("¿Puede subir a la montaña rusa? " + puedeSubirMontania);
        System.out.println("¿" + anio + " es bisiesto? " + esBisiesto);
        System.out.println("¿Debe ir a la enfermería? " + debeIrEnfermeria);
        System.out.println("¿Es visitante normal? " + esVisitanteNormal);
    }
}
