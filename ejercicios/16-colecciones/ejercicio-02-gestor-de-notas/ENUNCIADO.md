# Ejercicio 02 · Gestor de notas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** `List<Double>`, autoboxing y unboxing, métodos que reciben una lista, `Iterator` para borrar mientras se recorre, `Collections.max`

## Enunciado

Completa [`Ej16_02_GestorDeNotas.java`](Ej16_02_GestorDeNotas.java):

| Método | Qué hace |
|---|---|
| `media(notas)` | La media. Si la lista está vacía, 0 |
| `maxima(notas)` | La nota más alta, con un recorrido tuyo |
| `contarAprobados(notas)` | Cuántas notas son `>= 5` |
| `eliminarSuspensos(notas)` | Borra **de la propia lista** las notas `< 5`, usando un `Iterator` |

En el `main`, pasa los datos del array a una `List<Double>` y muestra los resultados. Compara tu `maxima` con `Collections.max`.

## Salida esperada

```
Notas: [6.5, 4.0, 8.75, 3.5, 9.0, 5.0, 2.25, 7.0]
Media: 5,75
Nota más alta: 9.0 (Collections.max: 9.0)
Aprobados: 5 de 8
Tras eliminar suspensos: [6.5, 8.75, 9.0, 5.0, 7.0]
Nueva media: 7,25
```

(La lista se muestra con punto decimal porque usa `toString`; las medias, con coma porque usan `printf`, que sigue la configuración regional.)

## Pistas

<details>
<summary>Pista 1</summary>

Puedes recorrer una `List<Double>` con `for (double nota : notas)`: Java hace el unboxing en cada vuelta.

</details>

<details>
<summary>Pista 2</summary>

```java
Iterator<Double> it = notas.iterator();
while (it.hasNext()) {
    if (it.next() < 5) {
        it.remove();
    }
}
```

</details>

<details>
<summary>Pista 3</summary>

`eliminarSuspensos` no devuelve nada: modifica la lista que recibe. Como la lista es un objeto, el método trabaja con la **misma** lista que el `main` (tema 10, paso por valor de referencias).

</details>

## Cómo ejecutarlo

```bash
java Ej16_02_GestorDeNotas.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-gestor-de-notas/SOLUCION.md).
