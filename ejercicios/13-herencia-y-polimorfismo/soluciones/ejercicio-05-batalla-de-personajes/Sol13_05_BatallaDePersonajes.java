/*
 * TEMA 13 · Ejercicio 05 · Batalla de personajes  ·  SOLUCIÓN
 *
 * Cómo ejecutarlo:  java Sol13_05_BatallaDePersonajes.java
 */
public class Sol13_05_BatallaDePersonajes {

    static class Personaje {
        private final String nombre;
        private final int vidaMaxima;
        private int vida;
        protected final int ataque;
        protected String accion = "golpea a";       // Las subclases lo cambian en calcularDanio()

        public Personaje(String nombre, int vidaMaxima, int ataque) {
            this.nombre = nombre;
            this.vidaMaxima = vidaMaxima;
            this.vida = vidaMaxima;
            this.ataque = ataque;
        }

        public String getNombre() {
            return nombre;
        }

        public int getVida() {
            return vida;
        }

        public boolean estaVivo() {
            return vida > 0;
        }

        // Las subclases deciden CUÁNTO daño hacen...
        protected int calcularDanio() {
            accion = "golpea a";
            return ataque;
        }

        // ...y CUÁNTO reciben
        public void recibirDanio(int danio) {
            vida = Math.max(0, vida - danio);
        }

        // El "esqueleto" del ataque es igual para todos: final, nadie lo sobrescribe
        public final String atacar(Personaje objetivo) {
            int danio = calcularDanio();
            int vidaAntes = objetivo.getVida();
            objetivo.recibirDanio(danio);
            int recibido = vidaAntes - objetivo.getVida();
            return nombre + " " + accion + " " + objetivo.getNombre() + " (" + recibido + ") → " + objetivo;
        }

        @Override
        public String toString() {
            return nombre + " [" + vida + "/" + vidaMaxima + "]";
        }
    }

    static class Guerrero extends Personaje {
        private final int armadura;

        public Guerrero(String nombre, int vida, int ataque, int armadura) {
            super(nombre, vida, ataque);
            this.armadura = armadura;
        }

        @Override
        public void recibirDanio(int danio) {
            super.recibirDanio(Math.max(1, danio - armadura));   // La armadura absorbe parte
        }
    }

    static class Mago extends Personaje {
        private static final int COSTE_HECHIZO = 10;
        private int mana;

        public Mago(String nombre, int vida, int ataque, int mana) {
            super(nombre, vida, ataque);
            this.mana = mana;
        }

        @Override
        protected int calcularDanio() {
            int danio;
            if (mana >= COSTE_HECHIZO) {
                mana -= COSTE_HECHIZO;
                accion = "lanza una bola de fuego a";
                danio = ataque * 2;
            } else {
                accion = "da un bastonazo a";
                danio = ataque / 2;
            }
            return danio;
        }
    }

    static class Arquero extends Personaje {
        private int disparos = 0;

        public Arquero(String nombre, int vida, int ataque) {
            super(nombre, vida, ataque);
        }

        @Override
        protected int calcularDanio() {
            disparos++;
            boolean critico = disparos % 3 == 0;          // Uno de cada tres es crítico
            accion = critico ? "dispara una flecha CRÍTICA a" : "dispara a";
            return critico ? ataque * 3 : ataque;
        }
    }

    // --- Utilidades de la batalla (trabajan con Personaje: sirven para cualquier subclase) ---

    static boolean hayVivos(Personaje[] equipo) {
        boolean alguno = false;
        for (int i = 0; i < equipo.length && !alguno; i++) {
            alguno = equipo[i].estaVivo();
        }
        return alguno;
    }

    static Personaje primerVivo(Personaje[] equipo) {
        Personaje elegido = null;
        for (int i = 0; i < equipo.length && elegido == null; i++) {
            if (equipo[i].estaVivo()) {
                elegido = equipo[i];
            }
        }
        return elegido;
    }

    static void atacarEquipo(Personaje[] atacantes, Personaje[] defensores) {
        for (int i = 0; i < atacantes.length && hayVivos(defensores); i++) {
            if (atacantes[i].estaVivo()) {
                System.out.println("  " + atacantes[i].atacar(primerVivo(defensores)));
            }
        }
    }

    public static void main(String[] args) {
        Personaje[] heroes = {
                new Guerrero("Brienne", 120, 14, 5),
                new Mago("Merlín", 70, 12, 30)
        };
        Personaje[] villanos = {
                new Arquero("Sombra", 80, 11),
                new Guerrero("Conan", 110, 16, 3)
        };

        final int MAX_RONDAS = 20;
        int ronda = 0;
        while (hayVivos(heroes) && hayVivos(villanos) && ronda < MAX_RONDAS) {
            ronda++;
            System.out.println("--- Ronda " + ronda + " ---");
            atacarEquipo(heroes, villanos);
            atacarEquipo(villanos, heroes);
        }

        System.out.println("=== Resultado ===");
        if (hayVivos(heroes) && !hayVivos(villanos)) {
            System.out.println("¡Ganan los héroes en " + ronda + " rondas!");
        } else if (hayVivos(villanos) && !hayVivos(heroes)) {
            System.out.println("¡Ganan los villanos en " + ronda + " rondas!");
        } else {
            System.out.println("Empate: se acabaron las rondas");
        }

        // Supervivientes: instanceof con patrón para un dato que solo tiene el Mago
        for (Personaje p : heroes) {
            String extra = p instanceof Mago mago ? " (maná restante: " + mago.mana + ")" : "";
            System.out.println(p + extra);
        }
        for (Personaje p : villanos) {
            System.out.println(p);
        }
    }
}
