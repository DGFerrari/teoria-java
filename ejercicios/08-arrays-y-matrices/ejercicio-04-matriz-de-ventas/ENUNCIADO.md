# Ejercicio 04 · Matriz de ventas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** matrices, recorrer por filas y por columnas, totales, máximos con su posición, tablas con `printf`

## Enunciado

Una tienda guarda las unidades vendidas por cada vendedor (filas) en cada mes (columnas):

```java
String[] vendedores = {"Ana", "Luis", "Marta", "Jorge"};
String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun"};
int[][] ventas = {
        {12, 15,  9, 20, 18, 22},
        { 8, 11, 14,  9, 13, 10},
        {20, 18, 25, 17, 21, 24},
        {10,  9, 12, 15,  8, 14}
};
```

Completa [`Ej08_04_MatrizDeVentas.java`](Ej08_04_MatrizDeVentas.java) para mostrar:

1. La tabla completa con el **total de cada vendedor** al final de su fila.
2. Una última fila con el **total de cada mes** y el **total general**.
3. El **mejor vendedor** (mayor total).
4. El **mejor mes** (mayor total).
5. La **mejor venta individual**: el valor más alto de toda la matriz, con el vendedor y el mes.

## Salida esperada

```
Vendedor   Ene   Feb   Mar   Abr   May   Jun  Total
Ana         12    15     9    20    18    22     96
Luis         8    11    14     9    13    10     65
Marta       20    18    25    17    21    24    125
Jorge       10     9    12    15     8    14     68
TOTAL       50    53    60    61    60    70    354

Mejor vendedor: Marta (125 unidades)
Mejor mes: Jun (70 unidades)
Mejor venta individual: 25 (Marta en Mar)
```

## Pistas

<details>
<summary>Pista 1</summary>

Guarda los totales en arrays para usarlos después:

```java
int[] totalVendedor = new int[ventas.length];      // Uno por fila
int[] totalMes = new int[ventas[0].length];        // Uno por columna
```

Con un solo recorrido de la matriz puedes rellenar los dos: `totalVendedor[fila] += ventas[fila][columna];` y `totalMes[columna] += ventas[fila][columna];`.

</details>

<details>
<summary>Pista 2</summary>

Para la mejor venta individual guarda **dos** posiciones (`filaMax` y `columnaMax`), empezando en `0, 0`.

</details>

<details>
<summary>Pista 3</summary>

Formatos de la tabla: `%-8s` para el nombre y `%6d` para cada número (`%7d` para el total).

</details>

## Cómo ejecutarlo

```bash
java Ej08_04_MatrizDeVentas.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-matriz-de-ventas/SOLUCION.md).
