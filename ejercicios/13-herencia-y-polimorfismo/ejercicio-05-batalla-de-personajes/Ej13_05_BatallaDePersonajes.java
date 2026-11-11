/*
 * TEMA 13 · Ejercicio 05 · Batalla de personajes  (dificultad: 5/5)
 *
 * Objetivo: una jerarquía de personajes en la que cada uno ataca o se defiende
 *           a su manera, y una batalla que funciona con cualquiera de ellos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej13_05_BatallaDePersonajes.java
 *
 * Regla: sin break ni continue, y sin return dentro de los bucles.
 */
public class Ej13_05_BatallaDePersonajes {

    // NO TOCAR: la superclase
    static class Personaje {
        private final String nombre;
        private final int vidaMaxima;
        private int vida;
        protected final int ataque;
        protected String accion = "golpea a";

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

        protected int calcularDanio() {
            accion = "golpea a";
            return ataque;
        }

        public void recibirDanio(int danio) {
            vida = Math.max(0, vida - danio);
        }

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

    // TODO 1: Guerrero → sobrescribe recibirDanio: la armadura resta daño (mínimo 1)
    static class Guerrero extends Personaje {
        private final int armadura;

        public Guerrero(String nombre, int vida, int ataque, int armadura) {
            super(nombre, vida, ataque);
            this.armadura = armadura;
        }
    }

    // TODO 2: Mago → sobrescribe calcularDanio: con 10 de maná o más, bola de fuego
    //         (ataque x2, gasta 10 de maná); si no, bastonazo (ataque / 2)
    static class Mago extends Personaje {
        private int mana;

        public Mago(String nombre, int vida, int ataque, int mana) {
            super(nombre, vida, ataque);
            this.mana = mana;
        }
    }

    // TODO 3: Arquero → sobrescribe calcularDanio: cada tercer disparo es crítico (ataque x3)
    static class Arquero extends Personaje {
        private int disparos = 0;

        public Arquero(String nombre, int vida, int ataque) {
            super(nombre, vida, ataque);
        }
    }

    // TODO 4: ¿queda alguien vivo en el equipo? (bandera)
    static boolean hayVivos(Personaje[] equipo) {
        return false;
    }

    // TODO 5: primer personaje vivo del equipo, o null
    static Personaje primerVivo(Personaje[] equipo) {
        return null;
    }

    // TODO 6: cada atacante vivo ataca al primer defensor vivo
    //         (para de atacar si ya no quedan defensores vivos)
    static void atacarEquipo(Personaje[] atacantes, Personaje[] defensores) {
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

        // TODO 7: bucle de rondas (máximo 20) mientras los dos equipos tengan vivos.
        //         En cada ronda atacan los héroes y luego los villanos.

        // TODO 8: resultado y estado final de cada personaje
        //         (para el Mago, muestra también el maná que le queda: instanceof con patrón)
    }
}
