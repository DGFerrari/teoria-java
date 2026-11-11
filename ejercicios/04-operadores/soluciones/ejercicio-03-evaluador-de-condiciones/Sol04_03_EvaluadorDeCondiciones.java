/*
 * TEMA 04 · Ejercicio 03 · Evaluador de condiciones  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol04_03_EvaluadorDeCondiciones.java
 */
public class Sol04_03_EvaluadorDeCondiciones {

    public static void main(String[] args) {

        int edad = 16;
        double alturaCm = 152;
        boolean tieneEntrada = true;
        boolean esVip = false;
        double saldo = 12.5;
        double precioFotografia = 10;
        int anio = 2024;
        double temperaturaCorporal = 38.2;

        boolean puedeComprarFoto = saldo >= precioFotografia;

        // Paréntesis obligatorios: la entrada se exige siempre
        boolean puedeEntrar = tieneEntrada && (edad >= 18 || esVip);

        boolean tieneDescuento = edad < 18 || edad >= 65;

        // Dentro de un rango: >= mínimo Y <= máximo
        boolean puedeSubirMontania = alturaCm >= 140 && alturaCm <= 195;

        boolean esBisiesto = (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;

        // Fuera de un rango: < mínimo O > máximo
        boolean debeIrEnfermeria = temperaturaCorporal < 36 || temperaturaCorporal > 37.5;

        boolean esVisitanteNormal = !esVip && !(edad >= 18);

        System.out.println("¿Puede comprar la foto? " + puedeComprarFoto);
        System.out.println("¿Puede entrar? " + puedeEntrar);
        System.out.println("¿Tiene descuento? " + tieneDescuento);
        System.out.println("¿Puede subir a la montaña rusa? " + puedeSubirMontania);
        System.out.println("¿" + anio + " es bisiesto? " + esBisiesto);
        System.out.println("¿Debe ir a la enfermería? " + debeIrEnfermeria);
        System.out.println("¿Es visitante normal? " + esVisitanteNormal);
    }
}
