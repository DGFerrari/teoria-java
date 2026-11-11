/*
 * TEMA 15 · Excepciones
 * Ejemplo 04: LANZAR (throw) Y PROPAGAR (throws) EXCEPCIONES
 *
 * Cómo ejecutarlo:  java T15_04_ThrowYThrows.java
 */
public class T15_04_ThrowYThrows {

    // ------------------------------------------------------------
    // 1. throw para validar: el objeto NUNCA queda en un estado incorrecto
    // ------------------------------------------------------------
    static class Persona {
        private final String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            if (nombre == null || nombre.isBlank()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            }
            this.nombre = nombre;
            setEdad(edad);                         // También valida
        }

        public void setEdad(int edad) {
            if (edad < 0 || edad > 150) {
                throw new IllegalArgumentException("Edad no válida: " + edad);
            }
            this.edad = edad;                      // Solo se llega aquí si es válida
        }

        @Override
        public String toString() {
            return nombre + " (" + edad + ")";
        }
    }

    // ------------------------------------------------------------
    // 2. IllegalStateException: la operación no es posible en el estado actual
    // ------------------------------------------------------------
    static class Puerta {
        private boolean abierta = false;
        private boolean conLlave = true;

        public void abrir() {
            if (conLlave) {
                throw new IllegalStateException("No se puede abrir: está cerrada con llave");
            }
            abierta = true;
        }

        public void quitarLlave() {
            conLlave = false;
        }

        public boolean isAbierta() {
            return abierta;
        }
    }

    // ------------------------------------------------------------
    // 3. Propagación: la excepción sube por la pila hasta que alguien la captura
    // ------------------------------------------------------------
    static int convertirNota(String texto) {
        int nota = Integer.parseInt(texto);        // Si falla, NumberFormatException sube al llamador
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota " + nota + " está fuera de 0-10");
        }
        return nota;
    }

    static double mediaDe(String[] textos) {      // No captura: deja que suba al main
        int suma = 0;
        for (String t : textos) {
            suma += convertirNota(t);
        }
        return (double) suma / textos.length;
    }

    // ------------------------------------------------------------
    // 4. Checked: el compilador OBLIGA a tratarlas o declararlas con throws
    // ------------------------------------------------------------
    static void esperar(int milisegundos) throws InterruptedException {   // Declara que puede lanzarla
        Thread.sleep(milisegundos);                // sleep lanza InterruptedException (checked)
    }

    public static void main(String[] args) {

        System.out.println("=== 1. Validar con throw ===");
        try {
            Persona ana = new Persona("Ana", 30);
            System.out.println("Creada: " + ana);
            ana.setEdad(-5);                                   // 💥
            System.out.println("Esto no se muestra");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            new Persona("   ", 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        System.out.println("=== 2. IllegalStateException ===");
        Puerta puerta = new Puerta();
        try {
            puerta.abrir();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        puerta.quitarLlave();
        puerta.abrir();
        System.out.println("¿Abierta? " + puerta.isAbierta());
        System.out.println();

        System.out.println("=== 3. Propagación hasta el main ===");
        String[][] grupos = {{"7", "8", "9"}, {"7", "ocho", "9"}, {"7", "12", "9"}};
        for (String[] grupo : grupos) {
            try {
                System.out.printf("Media: %.2f%n", mediaDe(grupo));
            } catch (NumberFormatException e) {
                System.out.println("No se pudo calcular: hay una nota que no es un número (" + e.getMessage() + ")");
            } catch (IllegalArgumentException e) {
                System.out.println("No se pudo calcular: " + e.getMessage());
            }
        }
        System.out.println();

        System.out.println("=== 4. Checked ===");
        // esperar(300);   // ❌ No compila: unreported exception InterruptedException
        try {
            System.out.println("Esperando 300 ms...");
            esperar(300);
            System.out.println("¡Listo!");
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida");
        }
    }
}
