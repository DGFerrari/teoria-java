/*
 * TEMA 18 · Enums y records
 * Ejemplo 02: enums con atributos, constructor y métodos
 *
 * Cómo ejecutarlo:  java T18_02_EnumConAtributos.java
 */
public class T18_02_EnumConAtributos {

    enum Talla {
        S("Pequeña", 0.0),
        M("Mediana", 0.0),
        L("Grande", 1.5),
        XL("Muy grande", 3.0);                  // ← ; tras la última constante

        private final String descripcion;
        private final double recargo;

        Talla(String descripcion, double recargo) {   // Siempre private (aunque no se escriba)
            this.descripcion = descripcion;
            this.recargo = recargo;
        }

        String getDescripcion() {
            return descripcion;
        }

        double getRecargo() {
            return recargo;
        }

        boolean esGrande() {
            return this == L || this == XL;
        }
    }

    enum Planeta {
        MERCURIO(3.303e+23, 2.4397e6),
        VENUS(4.869e+24, 6.0518e6),
        TIERRA(5.976e+24, 6.37814e6),
        MARTE(6.421e+23, 3.3972e6),
        JUPITER(1.9e+27, 7.1492e7);

        private static final double G = 6.67300E-11;   // Constante de gravitación universal

        private final double masa;                     // kg
        private final double radio;                    // m

        Planeta(double masa, double radio) {
            this.masa = masa;
            this.radio = radio;
        }

        double gravedad() {
            return G * masa / (radio * radio);
        }

        double pesoEn(double pesoEnLaTierra) {
            return pesoEnLaTierra * gravedad() / TIERRA.gravedad();
        }

        @Override
        public String toString() {                     // Nombre más amigable que el de la constante
            return name().charAt(0) + name().substring(1).toLowerCase();
        }
    }

    enum Provincia {
        MADRID("M", "Madrid"),
        BARCELONA("B", "Barcelona"),
        VALENCIA("V", "Valencia"),
        SEVILLA("SE", "Sevilla");

        private final String codigo;
        private final String nombre;

        Provincia(String codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;
        }

        // Buscar una constante por uno de sus atributos (null si no hay ninguna)
        static Provincia porCodigo(String codigo) {
            Provincia encontrada = null;
            Provincia[] todas = values();
            for (int i = 0; i < todas.length && encontrada == null; i++) {
                if (todas[i].codigo.equalsIgnoreCase(codigo)) {
                    encontrada = todas[i];
                }
            }
            return encontrada;
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. Cada constante con sus datos
        // ------------------------------------------------------------
        double precioBase = 12.0;
        System.out.println("1. Camiseta de " + precioBase + " €:");
        for (Talla t : Talla.values()) {
            System.out.printf("   %-2s %-10s %6.2f €%s%n", t, t.getDescripcion(),
                    precioBase + t.getRecargo(), t.esGrande() ? "  (talla grande)" : "");
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. Métodos con cálculos y toString propio
        // ------------------------------------------------------------
        double miPeso = 60;
        System.out.println("2. Si pesas " + miPeso + " kg en la Tierra:");
        for (Planeta p : Planeta.values()) {
            System.out.printf("   %-9s gravedad %5.2f m/s² → pesarías %6.1f kg%n", p, p.gravedad(), p.pesoEn(miPeso));
        }
        System.out.println("   (name() sigue siendo \"" + Planeta.JUPITER.name() + "\"; toString() da \"" + Planeta.JUPITER + "\")");
        System.out.println();

        // ------------------------------------------------------------
        // 3. Buscar por un atributo
        // ------------------------------------------------------------
        for (String codigo : new String[]{"v", "SE", "Z"}) {
            Provincia p = Provincia.porCodigo(codigo);
            System.out.println("3. Código " + codigo + " → " + (p == null ? "desconocido" : p.nombre));
        }
    }
}
