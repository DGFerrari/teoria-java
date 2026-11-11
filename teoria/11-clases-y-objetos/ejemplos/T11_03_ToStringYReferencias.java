/*
 * TEMA 11 · Clases y objetos
 * Ejemplo 03: toString, REFERENCIAS, == Y null
 *
 * Cómo ejecutarlo:  java T11_03_ToStringYReferencias.java
 */
public class T11_03_ToStringYReferencias {

    // Una clase SIN toString
    static class PuntoSinTexto {
        int x;
        int y;

        PuntoSinTexto(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // La misma clase CON toString
    static class Punto {
        int x;
        int y;

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void mover(int dx, int dy) {
            x += dx;
            y += dy;
        }

        double distanciaAlOrigen() {
            return Math.sqrt(x * x + y * y);
        }

        // Java llama a este método automáticamente cuando el objeto se usa como texto
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. toString
        // ------------------------------------------------------------
        PuntoSinTexto feo = new PuntoSinTexto(3, 4);
        Punto bonito = new Punto(3, 4);

        System.out.println("Sin toString: " + feo);      // Algo como T11_03_ToStringYReferencias$PuntoSinTexto@1b6d3586
        System.out.println("Con toString: " + bonito);   // (3, 4)
        System.out.println(bonito);                      // println también lo usa
        System.out.printf("Distancia de %s al origen: %.1f%n", bonito, bonito.distanciaAlOrigen());
        System.out.println();

        // ------------------------------------------------------------
        // 2. Las variables guardan REFERENCIAS
        // ------------------------------------------------------------
        Punto a = new Punto(1, 1);
        Punto b = a;                  // NO es una copia: b y a apuntan al mismo objeto
        b.mover(10, 10);
        System.out.println("a = " + a + " | b = " + b);  // Los dos han "cambiado": son el mismo

        Punto c = new Punto(11, 11);  // Otro objeto con los mismos valores
        System.out.println("¿a == b? " + (a == b));      // true: misma referencia
        System.out.println("¿a == c? " + (a == c));      // false: objetos distintos (aunque iguales por dentro)
        // Para comparar CONTENIDOS hace falta un método equals (tema 13).
        System.out.println();

        // Copia de verdad: crear un objeto nuevo con los mismos valores
        Punto copia = new Punto(a.x, a.y);
        copia.mover(-5, 0);
        System.out.println("a = " + a + " | copia = " + copia);   // Ahora son independientes
        System.out.println();

        // ------------------------------------------------------------
        // 3. null: una referencia que no apunta a ningún objeto
        // ------------------------------------------------------------
        Punto ninguno = null;
        System.out.println("ninguno = " + ninguno);      // Muestra "null"
        // ninguno.mover(1, 1);                          // ❌ NullPointerException
        if (ninguno != null) {
            ninguno.mover(1, 1);
        } else {
            System.out.println("No hay punto que mover");
        }

        // PRUEBA: añade un método "Punto simetrico()" que devuelva un Punto NUEVO
        //    con las coordenadas cambiadas de signo, sin modificar el original.
    }
}
