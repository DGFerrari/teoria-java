/*
 * TEMA 06 · Condicionales
 * Ejemplo 01: if E if-else
 *
 * Cómo ejecutarlo:  java T06_01_IfElse.java
 */
public class T06_01_IfElse {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. if sin else: hacer algo SOLO si se cumple la condición
        // ------------------------------------------------------------
        int bateria = 15;

        System.out.println("Batería: " + bateria + "%");
        if (bateria < 20) {
            System.out.println("⚠ Batería baja. Conecta el cargador.");
        }
        System.out.println("Comprobación terminada");   // Se ejecuta siempre
        System.out.println();

        // ------------------------------------------------------------
        // 2. if-else: siempre se ejecuta EXACTAMENTE uno de los dos
        // ------------------------------------------------------------
        int numero = 7;

        if (numero % 2 == 0) {
            System.out.println(numero + " es par");
        } else {
            System.out.println(numero + " es impar");
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3. La condición puede ser cualquier expresión boolean
        // ------------------------------------------------------------
        boolean tieneCarnet = true;
        int edad = 19;

        if (edad >= 18 && tieneCarnet) {
            System.out.println("Puede conducir");
        } else {
            System.out.println("No puede conducir");
        }

        // Una variable boolean ya es una condición: no hace falta "== true"
        if (tieneCarnet) {
            System.out.println("Tiene carnet");
        }
        if (!tieneCarnet) {
            System.out.println("No tiene carnet");   // No se ejecuta
        }
        System.out.println();

        // ------------------------------------------------------------
        // 4. Ámbito: una variable declarada dentro de { } solo existe ahí
        // ------------------------------------------------------------
        int puntos = 120;

        String nivel;                 // Declarada FUERA para usarla después del if
        if (puntos >= 100) {
            nivel = "Experto";
            String felicitacion = "¡Enhorabuena!";   // Solo existe dentro de este bloque
            System.out.println(felicitacion);
        } else {
            nivel = "Principiante";
        }
        System.out.println("Nivel: " + nivel);
        // System.out.println(felicitacion);   // ❌ Error: cannot find symbol
        System.out.println();

        // ------------------------------------------------------------
        // 5. Por qué usar SIEMPRE llaves
        // ------------------------------------------------------------
        int saldo = 50;

        // Sin llaves, solo la PRIMERA línea pertenece al if.
        // La sangría engaña: la segunda línea se ejecuta siempre.
        if (saldo < 0)
            System.out.println("Saldo negativo");
            System.out.println("Avisando al banco... (¡esta línea NO está dentro del if!)");

        // Y un ; detrás del if lo deja vacío: el bloque se ejecuta SIEMPRE
        // if (saldo < 0); {
        //     System.out.println("¡Esto sale aunque el saldo sea positivo!");
        // }

        // PRUEBA: cambia bateria a 80, numero a 10 y puntos a 50, y predice la salida.
    }
}
