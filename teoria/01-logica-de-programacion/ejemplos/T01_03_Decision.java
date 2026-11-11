/*
 * TEMA 01 · Lógica de programación
 * Ejemplo 03: DECISIÓN (condicional)
 *
 * Una decisión hace que el programa elija un camino u otro según si una
 * condición es verdadera (true) o falsa (false).
 *
 * Pseudocódigo:
 *     SI condición ENTONCES
 *         ... camino del SÍ ...
 *     SINO
 *         ... camino del NO ...
 *     FIN SI
 *
 * Java:
 *     if (condición) {
 *         ... camino del SÍ ...
 *     } else {
 *         ... camino del NO ...
 *     }
 *
 * Cómo ejecutarlo:  java T01_03_Decision.java
 */
public class T01_03_Decision {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Decisión con dos caminos: ¿puede votar?
        // ------------------------------------------------------------
        int edad = 17;

        System.out.println("Edad: " + edad);

        // La condición va entre paréntesis.  >=  significa "mayor o igual que"
        if (edad >= 18) {
            // Solo se ejecuta si la condición es VERDADERA
            System.out.println("Puedes votar");
        } else {
            // Solo se ejecuta si la condición es FALSA
            System.out.println("Todavía no puedes votar");
        }
        // Con edad = 17 se muestra: "Todavía no puedes votar"

        System.out.println();

        // ------------------------------------------------------------
        // 2. Decisión con un solo camino (sin "else")
        // ------------------------------------------------------------
        // A veces solo queremos hacer algo SI se cumple la condición,
        // y si no se cumple, no hacemos nada.
        int temperatura = 32;

        System.out.println("Temperatura: " + temperatura + " grados");
        if (temperatura > 30) {
            System.out.println("¡Hace calor! Bebe agua.");
        }
        System.out.println("Fin del informe del tiempo");
        // Esta última línea se ejecuta SIEMPRE, porque está fuera del if.

        System.out.println();

        // ------------------------------------------------------------
        // 3. Más de dos caminos: else if
        // ------------------------------------------------------------
        // Se comprueban las condiciones en orden. En cuanto una es verdadera,
        // se ejecuta su bloque y se ignoran las demás.
        int nota = 7;

        System.out.println("Nota: " + nota);
        if (nota >= 9) {
            System.out.println("Sobresaliente");
        } else if (nota >= 7) {
            System.out.println("Notable");
        } else if (nota >= 5) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Suspenso");
        }
        // Con nota = 7: la primera condición (7 >= 9) es falsa,
        // la segunda (7 >= 7) es verdadera → muestra "Notable" y termina.

        // PRUEBA: cambia edad a 18, temperatura a 25 y nota a 4.
        //    Antes de ejecutar, piensa qué se mostrará. Luego compruébalo.
    }
}
