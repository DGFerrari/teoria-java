# Solución · Ejercicio 02 · Gestor de notas

[⬅️ Enunciado](../../ejercicio-02-gestor-de-notas/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Los recorridos son los mismos del tema 08 (acumulador, máximo, contador). Lo nuevo es:

- La lista guarda `Double` (objetos), pero se puede trabajar con `double` gracias al **autoboxing** y al **unboxing**.
- Para **borrar** mientras se recorre hay que usar un `Iterator`.

## Código explicado

**Del array a la lista:**

```java
List<Double> notas = new ArrayList<>();
for (double dato : datos) {
    notas.add(dato);          // double → Double automáticamente
}
```

**Recorrer con unboxing:**

```java
static double media(List<Double> notas) {
    double suma = 0;
    for (double nota : notas) {
        suma += nota;
    }
    double resultado = 0;
    if (!notas.isEmpty()) {
        resultado = suma / notas.size();
    }
    return resultado;
}
```

La comprobación de `isEmpty()` evita dividir entre 0 (con `double` daría `NaN`).

**Borrar con `Iterator`:**

```java
Iterator<Double> it = notas.iterator();
while (it.hasNext()) {
    if (it.next() < 5) {
        it.remove();
    }
}
```

`it.remove()` borra el último elemento devuelto por `next()` y deja el iterador preparado para seguir. Si en su lugar llamas a `notas.remove(...)` dentro de un for-each, Java lanza `ConcurrentModificationException`.

| Vuelta | `next()` | ¿`< 5`? | Lista después |
|---|---|---|---|
| 1 | 6.5 | No | [6.5, 4.0, 8.75, ...] |
| 2 | 4.0 | Sí → `remove` | [6.5, 8.75, 3.5, ...] |
| 3 | 8.75 | No | |
| 4 | 3.5 | Sí → `remove` | [6.5, 8.75, 9.0, ...] |
| ... | | | |

## Errores comunes

- `List<double>` → no compila: los tipos de las colecciones tienen que ser clases.
- Borrar con un `for` con índice que avanza siempre → al borrar, los elementos se desplazan y te **saltas** el siguiente. (Funcionaría recorriendo del final al principio, pero el `Iterator` es la forma estándar.)
- `maxima` empezando en `0` en lugar de en el primer elemento → falla si todas las notas fueran negativas (en otros problemas).

## Código completo

📄 [Sol16_02_GestorDeNotas.java](Sol16_02_GestorDeNotas.java)
