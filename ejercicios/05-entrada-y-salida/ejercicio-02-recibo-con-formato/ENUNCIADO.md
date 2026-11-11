# Ejercicio 02 · Recibo con formato

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** `printf`: `%-Ns`, `%Nd`, `%N.2f`, `%05d`, `%%`, `String.format`

## Enunciado

Una papelería quiere imprimir sus recibos bien alineados. En [`Ej05_02_ReciboConFormato.java`](Ej05_02_ReciboConFormato.java) ya tienes los datos y los cálculos. Tu trabajo es **solo la salida**, usando `printf`:

- Número de recibo con **5 cifras** y ceros a la izquierda.
- Columnas: producto (15, izquierda), unidades (5, derecha), precio (8, 2 decimales), total (9, 2 decimales).
- El IVA mostrado como porcentaje entero con el símbolo `%`.
- Guarda la línea del número de recibo en una variable con `String.format` antes de mostrarla.

No puedes usar `\t` ni concatenar con `+` para alinear.

## Salida esperada

```
Recibo nº 00042
Producto         Uds.   Precio     Total
----------------------------------------
Cuaderno            3     2,35      7,05
Bolígrafo          10     0,60      6,00
Mochila             1    24,90     24,90
----------------------------------------
Subtotal                           37,95
IVA (21%)                           7,97
TOTAL                              45,92
```

(Con el sistema en inglés, los decimales salen con punto.)

## Pistas

<details>
<summary>Pista 1</summary>

Haz que la cabecera y las filas usen **los mismos anchos**: la cabecera con `%s` y las filas con `%d` y `%.2f`.

```java
System.out.printf("%-15s %5s %8s %9s%n", "Producto", "Uds.", "Precio", "Total");
System.out.printf("%-15s %5d %8.2f %9.2f%n", ...);
```

</details>

<details>
<summary>Pista 2</summary>

La fila completa mide 15 + 1 + 5 + 1 + 8 + 1 + 9 = 40 caracteres. Para las líneas del resumen, el texto ocupa 15, un espacio, y el número tiene que acabar en la columna 40: `%-15s %24.2f%n`.

</details>

<details>
<summary>Pista 3</summary>

Para que el IVA aparezca como `21%` dentro de un texto, necesitas `%d%%`. Y como "IVA (21%)" es la etiqueta de la izquierda, puedes construirla con `String.format("IVA (%d%%)", ...)`.

</details>

## Cómo ejecutarlo

```bash
java Ej05_02_ReciboConFormato.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-recibo-con-formato/SOLUCION.md).
