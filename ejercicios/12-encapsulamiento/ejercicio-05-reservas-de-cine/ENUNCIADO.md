# Ejercicio 05 · Reservas de cine

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema (encapsulamiento, validación, `static` para identificadores y constantes, `final`, objetos inmutables, métodos privados) + matrices, menú con `do-while`/`switch` y validación de entrada

## Enunciado

Programa las reservas de una sala de cine de **5 filas × 8 butacas**. Completa [`Ej12_05_ReservasDeCine.java`](Ej12_05_ReservasDeCine.java):

**`Entrada` (inmutable)**

- `id` automático (1, 2, 3...) con un contador `static`.
- `pelicula`, `fila`, `butaca` y `precio`, todos `private final`.
- `toString()`: `"Entrada #1 · Dune · fila 3, butaca 4 · 7,00 €"`.

**`Sala` (encapsulada)**

| Miembro | Detalle |
|---|---|
| `FILAS`, `BUTACAS` | Constantes `static final` (5 y 8) |
| `ocupadas` | Matriz `boolean[FILAS][BUTACAS]` privada |
| `vendidas` | Array privado de `Entrada` (hasta `FILAS × BUTACAS`) y su contador |
| `reservar(fila, butaca)` | Si la butaca existe y está libre, la ocupa y devuelve la `Entrada`. Si no, devuelve `null` |
| `cancelar(id)` | Libera la butaca de esa entrada, la quita de `vendidas` y devuelve `true`. Si no existe, `false` |
| `precioDeFila(fila)` | **Privado**. Filas 1-2: 5 €; filas 3-4: 7 €; fila 5 (VIP): 9 € |
| `existe(fila, butaca)` | **Privado**. ¿Está dentro de la sala? |
| `getLibres()`, `getRecaudacion()` | Libres y suma de los precios de las entradas vendidas |
| `mostrarMapa()` | `·` libre, `X` ocupada, con números de fila y butaca |

Las filas y butacas van de **1** en adelante para el usuario.

El `main` tiene un menú: `1. Ver mapa`, `2. Reservar`, `3. Cancelar`, `0. Salir` (con un resumen al final).

## Salida de ejemplo (resumida)

```
Opción: 2
Fila (1-5): 3
Butaca (1-8): 4
  ✔ Entrada #1 · Dune · fila 3, butaca 4 · 7,00 €
...
Opción: 2
Fila (1-5): 3
Butaca (1-8): 4
  ✘ Esa butaca no existe o ya está ocupada
...
Opción: 1
        1 2 3 4 5 6 7 8
Fila 1  · · · · · · · ·
Fila 2  · · · · · · · ·
Fila 3  · · · X · · · ·
Fila 4  · · · · · · · ·
Fila 5  · · · · · · · X   (VIP)
...
Opción: 0
=== Resumen ===
Entradas vendidas: 1
Butacas libres: 39
Recaudación: 9,00 €
```

## Pistas

<details>
<summary>Pista 1</summary>

El usuario ve las filas desde 1; la matriz empieza en 0. Haz la conversión **dentro** de `Sala` (`ocupadas[fila - 1][butaca - 1]`), así el resto del programa siempre trabaja con los números "humanos".

</details>

<details>
<summary>Pista 2</summary>

`reservar` devuelve `null` en los dos casos de error. Así el `main` solo tiene que comprobar `if (entrada != null)`.

</details>

<details>
<summary>Pista 3</summary>

`cancelar(id)` busca la posición de la entrada en `vendidas` (bandera), libera su butaca en la matriz y desplaza las siguientes hacia la izquierda, como en la lista de reproducción del tema 11.

</details>

## Cómo ejecutarlo

```bash
java Ej12_05_ReservasDeCine.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-reservas-de-cine/SOLUCION.md).
