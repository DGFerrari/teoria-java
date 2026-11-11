/*
 * TEMA 18 · Ejercicio 03 · Geometría con records  (dificultad: 3/5)
 *
 * Objetivo: crear records, validarlos con el constructor compacto y añadirles métodos.
 *
 * Lee el ENUNCIADO.md antes de empezar.
 * Cómo ejecutarlo:  java Ej18_03_GeometriaConRecords.java
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ej18_03_GeometriaConRecords {

    // TODO 1: record Punto(double x, double y) con:
    //         - una constante static ORIGEN
    //         - distancia(Punto otro) y trasladar(dx, dy) (devuelve un punto nuevo)

    // TODO 2: record Segmento(Punto inicio, Punto fin) con:
    //         - constructor compacto: si inicio y fin son iguales,
    //           IllegalArgumentException("Un segmento necesita dos puntos distintos")
    //         - longitud() y puntoMedio()

    // TODO 3: record Rectangulo(Punto esquina, double ancho, double alto) con:
    //         - constructor compacto: ancho y alto > 0, si no
    //           IllegalArgumentException("Las medidas tienen que ser positivas: " + ancho + " × " + alto)
    //         - area() y contiene(Punto p) (los bordes cuentan como dentro)

    public static void main(String[] args) {
        // TODO 4: sigue la salida esperada del ENUNCIADO
    }
}
