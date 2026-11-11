# Ejercicio 05 · Ticket de compra

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema (estructura, `print`/`println`, escapes, bloques de texto, comentarios Javadoc) + variables y cálculos del tema 01

## Enunciado

Programa el ticket de una pequeña tienda. En [`Ej02_05_TicketDeCompra.java`](Ej02_05_TicketDeCompra.java) ya tienes los datos de la compra en variables. Tienes que:

1. Escribir un **comentario Javadoc** encima de la clase que explique qué hace el programa e incluya `@author` con tu nombre.
2. Mostrar la **cabecera** de la tienda con un **bloque de texto**.
3. **Calcular** el importe de cada línea (cantidad × precio) y el total. Nada de escribir los resultados a mano.
4. Mostrar cada línea del ticket con **tabulaciones** para alinear las columnas.
5. Mostrar el total, la frase de despedida (con comillas) y el código de la tienda (con barras invertidas).

## Salida esperada

```
*********************************
*   ULTRAMARINOS "LA ESQUINA"   *
*   C/ Mayor, 12 - Valencia     *
*********************************
Producto	Cant.	Precio	Importe
Pan		2	1.25	2.5
Leche		4	0.75	3.0
Huevos		1	2.5	2.5
-----------------------------
TOTAL:				8.0 euros
-----------------------------
Gracias por su compra. "¡Vuelva pronto!"
Ref. tienda: VLC\042\T1
```

## Pistas

<details>
<summary>Pista 1</summary>

Primero calcula, luego muestra. Necesitas cuatro variables nuevas: `importePan`, `importeLeche`, `importeHuevos` y `total`.

</details>

<details>
<summary>Pista 2</summary>

Una línea de producto mezcla textos y variables. Puedes usar `print` para cada trozo o unirlos con `+` en un solo `println`:

```java
System.out.println("Pan\t\t" + cantidadPan + "\t" + precioPan + "\t" + importePan);
```

</details>

<details>
<summary>Pista 3</summary>

Dentro de un bloque de texto puedes poner comillas `"` sin escapar. La cabecera queda muy limpia así.

</details>

<details>
<summary>Pista 4</summary>

El código de la tienda tiene dos barras invertidas: cada una se escribe `\\`.

</details>

## Cómo ejecutarlo

```bash
java Ej02_05_TicketDeCompra.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-ticket-de-compra/SOLUCION.md).
