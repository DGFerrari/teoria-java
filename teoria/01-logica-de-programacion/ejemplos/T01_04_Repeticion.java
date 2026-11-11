/*
 * TEMA 01 · Lógica de programación
 * Ejemplo 04: REPETICIÓN (bucle)
 *
 * Un bucle repite un grupo de instrucciones MIENTRAS se cumpla una condición.
 *
 * Pseudocódigo:
 *     MIENTRAS condición HACER
 *         ... pasos que se repiten ...
 *     FIN MIENTRAS
 *
 * Java:
 *     while (condición) {
 *         ... pasos que se repiten ...
 *     }
 *
 * Regla del repositorio: un bucle termina SOLO porque su condición se vuelve
 * falsa. No usamos "break" ni "continue" para salir de los bucles.
 *
 * Cómo ejecutarlo:  java T01_04_Repeticion.java
 */
public class T01_04_Repeticion {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Contar del 1 al 5
        // ------------------------------------------------------------
        // Sin bucle tendríamos que escribir 5 líneas casi iguales.
        // Con bucle escribimos el paso UNA vez y lo repetimos.

        int contador = 1;               // Valor inicial

        while (contador <= 5) {         // ¿Seguimos? Mientras contador sea <= 5
            System.out.println("Vuelta número " + contador);
            contador = contador + 1;    // ¡Importante! Cambiamos el contador.
        }                               // Volvemos arriba a comprobar la condición

        // Cuando contador vale 6, la condición (6 <= 5) es falsa y el bucle termina.
        System.out.println("El bucle ha terminado. contador vale " + contador);

        System.out.println();

        // ------------------------------------------------------------
        // 2. Acumular: sumar 1 + 2 + 3 + 4  (la traza del README)
        // ------------------------------------------------------------
        int suma = 0;   // El acumulador empieza en 0
        int n = 1;

        while (n <= 4) {
            suma = suma + n;   // Añadimos n a lo que ya llevábamos
            n = n + 1;
        }
        System.out.println("1 + 2 + 3 + 4 = " + suma);   // 10

        System.out.println();

        // ------------------------------------------------------------
        // 3. Cuenta atrás
        // ------------------------------------------------------------
        // El contador también puede ir hacia abajo.
        int segundos = 3;

        while (segundos > 0) {
            System.out.println(segundos + "...");
            segundos = segundos - 1;
        }
        System.out.println("¡Despegue!");

        System.out.println();

        // ------------------------------------------------------------
        // 4. Salir del bucle "antes de tiempo" SIN break
        // ------------------------------------------------------------
        // Problema: ahorramos 15 euros cada semana durante un máximo de 10 semanas,
        // pero queremos parar en cuanto lleguemos a 50 euros.
        //
        // En lugar de usar break, metemos las DOS ideas en la condición:
        //   - quedan semanas  (semana <= 10)
        //   - y aún no hemos llegado al objetivo (ahorrado < 50)
        // El símbolo  &&  significa "Y" (las dos cosas a la vez).

        int ahorrado = 0;
        int semana = 1;

        while (semana <= 10 && ahorrado < 50) {
            ahorrado = ahorrado + 15;
            System.out.println("Semana " + semana + ": llevo " + ahorrado + " euros");
            semana = semana + 1;
        }
        System.out.println("He dejado de ahorrar con " + ahorrado + " euros");
        // Semana 1: 15, semana 2: 30, semana 3: 45, semana 4: 60 → 60 ya no es < 50, para.

        // CUIDADO con los bucles infinitos:
        //    Si borras la línea "contador = contador + 1;" del primer bucle,
        //    contador valdrá siempre 1 y el programa no terminará nunca.
        //    (Si te pasa, pulsa Ctrl + C en la terminal para pararlo.)
    }
}
