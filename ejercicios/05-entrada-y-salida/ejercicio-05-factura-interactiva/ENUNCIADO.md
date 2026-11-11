# Ejercicio 05 · Factura interactiva

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema (`Scanner` con textos y números mezclados, salto de línea pendiente, `printf`, `String.format`) + operadores, `Math` y `Random` del tema 04

## Enunciado

Programa una pequeña aplicación de facturación para una tienda de electrónica. Completa [`Ej05_05_FacturaInteractiva.java`](Ej05_05_FacturaInteractiva.java):

**Entrada** (por teclado):

1. Nombre del cliente (puede tener espacios).
2. Para **dos** productos: nombre (con espacios), unidades y precio por unidad.
3. Porcentaje de descuento (entero).

**Proceso:**

- Importe de cada línea = unidades × precio.
- Subtotal = suma de las dos líneas.
- Descuento = subtotal × porcentaje / 100.
- Base imponible = subtotal − descuento.
- IVA (21 %) = base × 21 / 100.
- Total = base + IVA.
- Número de factura **aleatorio** entre 1 y 9999, mostrado como `F-0042` (4 cifras con ceros).
- Unidades totales con `+=`.

**Salida:** la factura alineada con `printf`, de 53 caracteres de ancho. Columnas: producto (26, izquierda), unidades (5), precio (9, 2 decimales) e importe (10, 2 decimales).

## Salida esperada

(Lo que escribe el usuario: `Marta Ruiz`, `Auriculares inalámbricos`, `2`, `39,90`, `Funda de móvil`, `3`, `12,50`, `10`. El número de factura cambia en cada ejecución.)

```
Cliente: Marta Ruiz
Producto 1: Auriculares inalámbricos
Unidades: 2
Precio por unidad: 39,90
Producto 2: Funda de móvil
Unidades: 3
Precio por unidad: 12,50
Descuento (%): 10

=====================================================
FACTURA F-0042                    Cliente: Marta Ruiz
=====================================================
Producto                    Uds.    Precio    Importe
-----------------------------------------------------
Auriculares inalámbricos       2     39,90      79,80
Funda de móvil                 3     12,50      37,50
-----------------------------------------------------
Unidades totales: 5
Subtotal                                       117,30
Descuento (10%)                                -11,73
Base imponible                                 105,57
IVA (21%)                                       22,17
TOTAL                                          127,74
=====================================================
```

## Pistas

<details>
<summary>Pista 1</summary>

Cuidado con el orden de lectura: después de leer el **precio del producto 1** (`nextDouble`) viene el **nombre del producto 2** (`nextLine`). Ahí hay un salto de línea pendiente que limpiar.

</details>

<details>
<summary>Pista 2</summary>

La línea `FACTURA F-0042 ... Cliente: Marta Ruiz` tiene 53 caracteres: el código a la izquierda y el cliente a la derecha. Construye el texto del cliente con `String.format` y luego usa `printf("%-20s%33s%n", ...)`.

</details>

<details>
<summary>Pista 3</summary>

La fila mide 26 + 1 + 5 + 1 + 9 + 1 + 10 = 53. Las líneas del resumen: etiqueta con `%-26s`, un espacio y el número con `%26.2f` (5 + 1 + 9 + 1 + 10 = 26).

</details>

<details>
<summary>Pista 4</summary>

Para que el descuento salga con signo menos, muestra `-descuento`.

</details>

## Cómo ejecutarlo

```bash
java Ej05_05_FacturaInteractiva.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-factura-interactiva/SOLUCION.md).
