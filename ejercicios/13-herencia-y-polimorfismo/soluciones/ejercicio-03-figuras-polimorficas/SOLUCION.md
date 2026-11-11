# Solución · Ejercicio 03 · Figuras polimórficas

[⬅️ Enunciado](../../ejercicio-03-figuras-polimorficas/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Hay dos partes muy distintas:

1. **Las subclases** saben calcular **su** área y **su** perímetro.
2. **Los métodos generales** (`areaTotal`, `laMayor`, `ordenarPorArea`) no saben ni les importa qué figura concreta hay en cada posición: solo llaman a `area()` y confían en que cada objeto responda bien.

Esa separación es la esencia del polimorfismo.

## Código explicado

**Una subclase completa:**

```java
static class TrianguloRectangulo extends Figura {
    ...
    @Override
    public String getNombre() {
        return String.format("Triángulo (%.1f y %.1f)", cateto1, cateto2);
    }

    @Override
    public double area() {
        return cateto1 * cateto2 / 2;
    }

    @Override
    public double perimetro() {
        return cateto1 + cateto2 + Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
    }
}
```

**Cuadrado reutiliza todo lo de Rectangulo:**

```java
static class Cuadrado extends Rectangulo {
    public Cuadrado(double lado) {
        super(lado, lado);
    }

    @Override
    public String getNombre() {
        return String.format("Cuadrado (%.1f)", ancho);
    }
}
```

**Métodos generales:**

```java
static double areaTotal(Figura[] figuras) {
    double total = 0;
    for (Figura f : figuras) {
        total += f.area();           // Cada objeto, su propia versión
    }
    return total;
}

static int contarRectangulos(Figura[] figuras) {
    int cantidad = 0;
    for (Figura f : figuras) {
        if (f instanceof Rectangulo) {   // true también para el Cuadrado
            cantidad++;
        }
    }
    return cantidad;
}
```

**Ordenar referencias de la superclase:**

```java
static void ordenarPorArea(Figura[] figuras) {
    boolean hayCambios = true;
    int pasada = 0;
    while (hayCambios) {
        hayCambios = false;
        for (int i = 0; i < figuras.length - 1 - pasada; i++) {
            if (figuras[i].area() > figuras[i + 1].area()) {
                Figura auxiliar = figuras[i];
                figuras[i] = figuras[i + 1];
                figuras[i + 1] = auxiliar;
                hayCambios = true;
            }
        }
        pasada++;
    }
}
```

El método **modifica** el array que recibe (tema 10), por eso el `main` ve el resultado ordenado.

## Una pregunta para pensar

¿Tiene sentido crear un objeto `new Figura()`? Su área sería 0 y su nombre "Figura": no representa nada real. En el [tema 14](../../../../teoria/14-abstraccion-e-interfaces/README.md) verás cómo declarar `Figura` como **abstracta** para que no se pueda crear y para **obligar** a cada subclase a implementar `area()` y `perimetro()`.

## Código completo

📄 [Sol13_03_FigurasPolimorficas.java](Sol13_03_FigurasPolimorficas.java)
