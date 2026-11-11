# Ejercicio 01 · Lista de la compra

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** `ArrayList`, `add`, `add(i, e)`, `get`, `set`, `remove`, `indexOf`, `contains`, `size`

## Enunciado

Completa [`Ej16_01_ListaDeLaCompra.java`](Ej16_01_ListaDeLaCompra.java) siguiendo los pasos marcados con `TODO`:

1. Crea una `List<String>` con `ArrayList` y añade `leche`, `pan`, `huevos`, `manzanas` y `pan` (sí, dos veces: una lista admite duplicados). Muéstrala con su tamaño.
2. Inserta `café` en la **primera** posición.
3. Cambia `manzanas` por `peras`: busca su posición con `indexOf` y sustitúyela con `set`.
4. Quita **un** `pan` con `remove("pan")`.
5. Comprueba si hay `huevos` y si hay `chocolate`.
6. Muestra la lista final numerada.

## Salida esperada

```
Lista: [leche, pan, huevos, manzanas, pan] (5 productos)
Con café al principio: [café, leche, pan, huevos, manzanas, pan]
Cambio manzanas por peras: [café, leche, pan, huevos, peras, pan]
Quito un pan: [café, leche, huevos, peras, pan]
¿Hay huevos? true
¿Hay chocolate? false
=== Lista final ===
1. café
2. leche
3. huevos
4. peras
5. pan
```

## Pistas

<details>
<summary>Pista 1</summary>

Al imprimir una lista con `println` se ve entre corchetes y separada por comas, gracias a su `toString`. No hace falta recorrerla para eso.

</details>

<details>
<summary>Pista 2</summary>

`indexOf` devuelve `-1` si no encuentra el elemento. Compruébalo antes de llamar a `set`, o tendrás un `IndexOutOfBoundsException`.

</details>

<details>
<summary>Pista 3</summary>

`remove("pan")` borra la **primera** aparición. El segundo `pan` se queda.

</details>

## Cómo ejecutarlo

```bash
java Ej16_01_ListaDeLaCompra.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-lista-de-la-compra/SOLUCION.md).
