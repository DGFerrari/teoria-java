/*
 * TEMA 17 · Genéricos
 * Ejemplo 01: el problema de guardar Object y cómo lo resuelven los genéricos
 *
 * Cómo ejecutarlo:  java T17_01_ProblemaSinGenericos.java
 */
public class T17_01_ProblemaSinGenericos {

    // ❌ Sin genéricos: cabe cualquier cosa, pero hay que hacer casting al sacar
    static class CajaDeObjetos {
        private Object contenido;

        void guardar(Object contenido) {
            this.contenido = contenido;
        }

        Object sacar() {
            return contenido;
        }
    }

    // ✅ Con genéricos: una sola clase, y el compilador comprueba el tipo
    static class Caja<T> {
        private T contenido;

        void guardar(T contenido) {
            this.contenido = contenido;
        }

        T sacar() {
            return contenido;
        }
    }

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. La caja de Object funciona... mientras no te equivoques
        // ------------------------------------------------------------
        CajaDeObjetos caja = new CajaDeObjetos();
        caja.guardar("Hola");
        String texto = (String) caja.sacar();          // Casting obligatorio
        System.out.println("1. Saco un texto: " + texto.toUpperCase());

        caja.guardar(42);                               // El compilador no se queja
        try {
            String otro = (String) caja.sacar();        // 💥 Al ejecutar
            System.out.println(otro);
        } catch (ClassCastException e) {
            System.out.println("   💥 ClassCastException: había un Integer y lo traté como String");
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2. La caja genérica: sin casting y sin sorpresas
        // ------------------------------------------------------------
        Caja<String> cajaTexto = new Caja<>();          // T = String
        cajaTexto.guardar("Hola");
        String sinCasting = cajaTexto.sacar();
        System.out.println("2. Caja<String>: " + sinCasting.toUpperCase());
        // cajaTexto.guardar(42);                       // ❌ No compila: incompatible types: int cannot be converted to String

        Caja<Integer> cajaNumero = new Caja<>();        // T = Integer
        cajaNumero.guardar(42);
        int doble = cajaNumero.sacar() * 2;             // Unboxing automático
        System.out.println("   Caja<Integer>: 42 × 2 = " + doble);

        Caja<int[]> cajaArray = new Caja<>();           // Un array también es un objeto
        cajaArray.guardar(new int[]{3, 1, 4});
        System.out.println("   Caja<int[]>: el array tiene " + cajaArray.sacar().length + " elementos");
        System.out.println();

        // ------------------------------------------------------------
        // 3. Las colecciones del tema 16 son genéricas por lo mismo
        // ------------------------------------------------------------
        System.out.println("3. List<String>, Map<String, Integer>... son clases genéricas del JDK:");
        System.out.println("   una sola ArrayList sirve para guardar cualquier tipo, de forma segura.");
    }
}
