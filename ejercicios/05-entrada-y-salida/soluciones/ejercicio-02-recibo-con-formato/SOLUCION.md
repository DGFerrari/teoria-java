# Solución · Ejercicio 02 · Recibo con formato

[⬅️ Enunciado](../../ejercicio-02-recibo-con-formato/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Antes de escribir los `printf`, diseña las columnas en papel:

```
|<---- 15 ---->| |<5>| |<-- 8 ->| |<-- 9 -->|
Producto         Uds.   Precio     Total
Cuaderno            3     2,35      7,05
```

Con los anchos decididos, la cabecera y las filas usan el mismo patrón, cambiando solo el tipo de cada hueco.

## Código explicado

**Número de recibo con `String.format`:**

```java
String cabeceraRecibo = String.format("Recibo nº %05d", numeroRecibo);   // "Recibo nº 00042"
System.out.println(cabeceraRecibo);
```

`%05d`: ancho 5 y relleno con ceros.

**Cabecera y filas:**

```java
System.out.printf("%-15s %5s %8s %9s%n", "Producto", "Uds.", "Precio", "Total");
System.out.printf("%-15s %5d %8.2f %9.2f%n", producto1, unidades1, precio1, total1);
```

- `%-15s`: el `-` alinea a la izquierda (lo normal para textos).
- `%5d`, `%8.2f`, `%9.2f`: sin `-`, a la derecha (lo normal para números: las unidades y los decimales quedan en columna).
- En la cabecera, todo es `%s` porque son textos, pero con **los mismos anchos**.

**Resumen alineado con la columna del total:**

```java
System.out.printf("%-15s %24.2f%n", "Subtotal", subtotal);
System.out.printf("%-15s %24.2f%n", String.format("IVA (%d%%)", PORCENTAJE_IVA), iva);
System.out.printf("%-15s %24.2f%n", "TOTAL", total);
```

El 24 sale de sumar las columnas que hay a la derecha del producto: 5 + 1 + 8 + 1 + 9 = 24.

## ¿Por qué no se ven decimales raros?

`3 * 2.35` en `double` puede dar algo como `7.050000000000001`. `%.2f` **redondea al mostrar**, así que en pantalla se ve `7,05`. El valor de la variable no cambia.

## Errores comunes

- `%5d` con `precio1` (un `double`) → `IllegalFormatConversionException`.
- `"IVA (21%)"` dentro de un `printf` → el `%)` se interpreta como un especificador y da error. Fuera de `printf` (como argumento `%s`) no hay problema; dentro, hay que escribir `%%`.
- Olvidar `%n` → todas las filas se pegan en una línea.

## Código completo

📄 [Sol05_02_ReciboConFormato.java](Sol05_02_ReciboConFormato.java)
