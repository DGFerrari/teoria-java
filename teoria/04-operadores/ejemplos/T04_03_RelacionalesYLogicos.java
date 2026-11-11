/*
 * TEMA 04 · Operadores
 * Ejemplo 03: OPERADORES RELACIONALES Y LÓGICOS
 *
 * Cómo ejecutarlo:  java T04_03_RelacionalesYLogicos.java
 */
public class T04_03_RelacionalesYLogicos {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Relacionales: comparan y devuelven boolean
        // ------------------------------------------------------------
        int edad = 17;

        System.out.println("edad = " + edad);
        System.out.println("edad == 18 → " + (edad == 18));   // false
        System.out.println("edad != 18 → " + (edad != 18));   // true
        System.out.println("edad > 18  → " + (edad > 18));    // false
        System.out.println("edad < 18  → " + (edad < 18));    // true
        System.out.println("edad >= 17 → " + (edad >= 17));   // true
        System.out.println("edad <= 16 → " + (edad <= 16));   // false
        System.out.println();

        // El resultado se puede guardar en una variable boolean
        boolean esMayorDeEdad = edad >= 18;
        System.out.println("¿Es mayor de edad? " + esMayorDeEdad);
        System.out.println();

        // ------------------------------------------------------------
        // 2. Lógicos: && (Y), || (O), ! (NO)
        // ------------------------------------------------------------
        boolean tieneEntrada = true;
        boolean vaAcompaniado = true;

        // && : las dos condiciones a la vez
        boolean puedeEntrarSolo = esMayorDeEdad && tieneEntrada;
        System.out.println("¿Puede entrar solo? " + puedeEntrarSolo);   // false

        // || : al menos una de las dos
        boolean cumpleEdad = esMayorDeEdad || vaAcompaniado;
        System.out.println("¿Cumple el requisito de edad (o va acompañado)? " + cumpleEdad);   // true

        // Combinación
        boolean puedeEntrar = tieneEntrada && (esMayorDeEdad || vaAcompaniado);
        System.out.println("¿Puede entrar? " + puedeEntrar);   // true

        // ! : invierte
        System.out.println("¿Es menor de edad? " + !esMayorDeEdad);   // true
        System.out.println();

        // ------------------------------------------------------------
        // 3. Rangos: hay que usar && (no se puede escribir 0 <= nota <= 10)
        // ------------------------------------------------------------
        double nota = 7.5;
        boolean notaValida = nota >= 0 && nota <= 10;
        boolean esNotable = nota >= 7 && nota < 9;
        System.out.println("Nota " + nota + " → válida: " + notaValida + ", notable: " + esNotable);

        // Fuera de un rango: < mínimo O > máximo
        int temperatura = 42;
        boolean temperaturaPeligrosa = temperatura < 0 || temperatura > 40;
        System.out.println("Temperatura " + temperatura + " → peligrosa: " + temperaturaPeligrosa);
        System.out.println();

        // ------------------------------------------------------------
        // 4. Cortocircuito: && no evalúa la derecha si la izquierda es false
        // ------------------------------------------------------------
        int numero = 10;
        int divisor = 0;

        // Si divisor es 0, la parte de la derecha NO se ejecuta → no hay división entre 0
        boolean esDivisible = divisor != 0 && numero % divisor == 0;
        System.out.println("¿" + numero + " es divisible entre " + divisor + "? " + esDivisible);   // false

        // boolean peligro = numero % divisor == 0 && divisor != 0;   // ❌ ArithmeticException
        // ¡El orden importa! Primero la comprobación de seguridad.
        System.out.println();

        // ------------------------------------------------------------
        // 5. Cuidado con los decimales y ==
        // ------------------------------------------------------------
        double suma = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 == 0.3 → " + (suma == 0.3));                       // false
        System.out.println("Con margen      → " + (Math.abs(suma - 0.3) < 0.000001));   // true

        // PRUEBA: crea una variable anio y una expresión boolean que diga si es bisiesto:
        //    divisible entre 4 y no entre 100, o divisible entre 400.
    }
}
