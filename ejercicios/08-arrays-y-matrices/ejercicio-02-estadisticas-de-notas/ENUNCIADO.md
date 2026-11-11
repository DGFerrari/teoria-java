# Ejercicio 02 · Estadísticas de notas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** crear un array con el tamaño que indica el usuario, rellenarlo desde teclado, media, máximo, mínimo, contar

## Enunciado

Completa [`Ej08_02_EstadisticasDeNotas.java`](Ej08_02_EstadisticasDeNotas.java):

1. Pregunta **cuántos alumnos** hay y crea un array `double[]` de ese tamaño.
2. Pide la nota de cada alumno y guárdala en el array.
3. Calcula y muestra:
   - la **media**,
   - la nota **más alta** y la **más baja**, indicando **qué alumno** la tiene,
   - cuántos han **aprobado** (nota ≥ 5).
4. Muestra los alumnos que están **por encima de la media**.

Los alumnos se numeran desde **1** para el usuario, aunque en el array empiecen en 0.

## Salida esperada

```
¿Cuántos alumnos hay? 5
Nota del alumno 1: 7,5
Nota del alumno 2: 4
Nota del alumno 3: 9
Nota del alumno 4: 6
Nota del alumno 5: 8

Media: 6,90
Nota más alta: 9,00 (alumno 3)
Nota más baja: 4,00 (alumno 2)
Aprobados: 4 de 5
Por encima de la media: alumno 1 (7,50) alumno 3 (9,00) alumno 5 (8,00)
```

## Pistas

<details>
<summary>Pista 1</summary>

El tamaño de un array puede ser una variable: `double[] notas = new double[cantidad];`.

</details>

<details>
<summary>Pista 2</summary>

Al pedir las notas, el número que ve el usuario es `i + 1`.

</details>

<details>
<summary>Pista 3</summary>

Para saber quién supera la media, primero hay que **conocer** la media. Por eso hace falta un **segundo recorrido** del array después de calcularla. Es una de las grandes ventajas de guardar los datos en un array: puedes recorrerlos tantas veces como necesites.

</details>

## Cómo ejecutarlo

```bash
java Ej08_02_EstadisticasDeNotas.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-estadisticas-de-notas/SOLUCION.md).
