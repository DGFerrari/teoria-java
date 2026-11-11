# Solución · Ejercicio 03 · Geometría con records

[⬅️ Enunciado](../../ejercicio-03-geometria-con-records/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Un punto, un segmento o un rectángulo son **datos**: una vez creados, no tiene sentido que cambien. Son candidatos perfectos para records. Lo que en una clase serían unas 30 líneas (atributos, constructor, getters, `equals`, `hashCode`, `toString`) aquí es la cabecera del record, y solo se escribe lo **específico**: la validación y los cálculos.

| Escribes tú | Genera Java |
|---|---|
| Validaciones (constructor compacto) | Atributos `private final` |
| `distancia`, `longitud`, `area`... | Constructor canónico |
| La constante `ORIGEN` | Accesores `x()`, `inicio()`, `ancho()`... |
| | `equals`, `hashCode`, `toString` |

## Código explicado

**Un método que "modifica" devuelve un record nuevo:**

```java
Punto trasladar(double dx, double dy) {
    return new Punto(x + dx, y + dy);
}
```

Por eso, después de `p.trasladar(1, -2)`, `p` sigue valiendo `(3, 4)`.

**Validar en el constructor compacto:**

```java
record Rectangulo(Punto esquina, double ancho, double alto) {
    Rectangulo {
        if (ancho <= 0 || alto <= 0) {
            throw new IllegalArgumentException("Las medidas tienen que ser positivas: " + ancho + " × " + alto);
        }
    }
    ...
}
```

Si se lanza la excepción, el record **no llega a existir**: es imposible tener un rectángulo con medidas incorrectas.

**Records dentro de records:**

```java
Punto puntoMedio() {
    return new Punto((inicio.x() + fin.x()) / 2, (inicio.y() + fin.y()) / 2);
}
```

El `toString` también se anida: `Segmento[inicio=Punto[x=0.0, y=0.0], fin=...]`.

**Igualdad por datos:**

```java
Set<Punto> distintos = new HashSet<>(recorrido);
```

`p`, `new Punto(3, 4)` y `ORIGEN`/`new Punto(0, 0)` son objetos distintos, pero el `equals` y el `hashCode` del record solo miran los datos: quedan 3 puntos distintos.

## Errores comunes

- Escribir `p.getX()` → los accesores de un record se llaman como el componente: `p.x()`.
- Escribir `this.ancho = ancho;` en el constructor compacto → error: la asignación la hace Java al final.
- Añadir un setter `void setX(double x) { this.x = x; }` → no compila: los componentes son `final`.

## Código completo

📄 [Sol18_03_GeometriaConRecords.java](Sol18_03_GeometriaConRecords.java)
