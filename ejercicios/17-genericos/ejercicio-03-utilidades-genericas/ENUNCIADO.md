# Ejercicio 03 · Utilidades genéricas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** métodos genéricos `static <T>`, tipos acotados `<T extends Comparable<T>>` y `<T extends Number>`, inferencia de tipos, banderas

## Enunciado

Escribe en [`Ej17_03_UtilidadesGenericas.java`](Ej17_03_UtilidadesGenericas.java) una pequeña librería de métodos que funcionen con listas de **cualquier** tipo:

| Método | Qué hace | ¿Necesita acotar `T`? |
|---|---|---|
| `contar(lista, buscado)` | Cuántas veces aparece | No |
| `sinDuplicados(lista)` | Lista nueva sin repetidos, en el orden de la primera aparición | No |
| `invertida(lista)` | Lista nueva al revés | No |
| `maximo(lista)` | El mayor, o `null` si está vacía | Sí: tiene que poder **compararse** |
| `estaOrdenada(lista)` | ¿Cada elemento es `<=` que el siguiente? | Sí: tiene que poder **compararse** |
| `media(lista)` | La media, o `0` si está vacía | Sí: tiene que ser un **número** |

Las listas originales **no se modifican** (de hecho, `List.of` no lo permitiría).

## Salida esperada

```
Votos: [sí, no, sí, abstención, sí, no]
  "sí" aparece 3 veces
  Sin duplicados: [sí, no, abstención]
  Invertida: [no, sí, abstención, sí, no, sí]
  Máximo (alfabético): sí
  ¿Ordenada? false
Dados: [3, 6, 1, 6, 2, 6]
  El 6 aparece 3 veces
  Sin duplicados: [3, 6, 1, 2]
  Máximo: 6
  Media: 4,00
  ¿Ordenada? false
Años: [1969, 1989, 2001, 2024]
  ¿Ordenada? true
  Media: 1995,75
Lista vacía → máximo: null
```

Prueba también a llamar a `media(votos)`: el compilador **no te dejará**, porque `String` no es un `Number`.

## Pistas

<details>
<summary>Pista 1</summary>

```java
static <T extends Comparable<T>> T maximo(List<T> lista)
static <T extends Number> double media(List<T> lista)
```

</details>

<details>
<summary>Pista 2</summary>

Para que `maximo` funcione con una lista vacía, empieza con `T mayor = null;` y en el bucle comprueba `mayor == null || elemento.compareTo(mayor) > 0`.

</details>

<details>
<summary>Pista 3</summary>

`estaOrdenada` compara cada elemento con el siguiente, así que el bucle llega hasta `lista.size() - 1`. Añade la bandera a la condición para parar en cuanto encuentres uno desordenado.

</details>

## Cómo ejecutarlo

```bash
java Ej17_03_UtilidadesGenericas.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-utilidades-genericas/SOLUCION.md).
