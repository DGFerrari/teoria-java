# Solución · Ejercicio 05 · Ticket de compra

[⬅️ Enunciado](../../ejercicio-05-ticket-de-compra/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Aplicamos el esquema **entrada → proceso → salida** del tema 01:

| Parte | Qué hay |
|---|---|
| Entrada | Las cantidades y precios (ya dados) |
| Proceso | 3 importes + el total |
| Salida | Cabecera, tabla, total, despedida |

Y para cada trozo de la salida, elegimos la herramienta del tema 02 que mejor encaja:

| Trozo | Herramienta |
|---|---|
| Cabecera de varias líneas con comillas | Bloque de texto `"""` |
| Tabla | `println` con `+` y `\t` |
| Despedida | `\"` |
| Referencia | `\\` |

## Código explicado

**Javadoc** encima de la clase:

```java
/**
 * Muestra el ticket de compra de la tienda "La Esquina"
 * calculando el importe de cada producto y el total.
 *
 * @author Ana
 */
public class Sol02_05_TicketDeCompra {
```

**Proceso**, antes de cualquier salida:

```java
double importePan = cantidadPan * precioPan;         // 2 * 1.25 = 2.5
double importeLeche = cantidadLeche * precioLeche;   // 4 * 0.75 = 3.0
double importeHuevos = cantidadHuevos * precioHuevos; // 1 * 2.5 = 2.5
double total = importePan + importeLeche + importeHuevos; // 8.0
```

**Cabecera** con bloque de texto: las comillas de `"LA ESQUINA"` van tal cual.

**Líneas de la tabla:** cada una une textos, tabulaciones y variables:

```java
System.out.println("Pan\t\t" + cantidadPan + "\t" + precioPan + "\t" + importePan);
```

Aquí no hay problema con el `+` porque el primer elemento es un texto: todo lo demás se va **pegando** como texto. No queremos sumar nada en esta línea.

**Total:** las tabulaciones saltan a las columnas 8, 16, 24, 32... `"TOTAL:"` ocupa 6 caracteres, así que con **cuatro** `\t` llega a la columna 32, que es donde empieza "Importe".

## Errores comunes

- **Escribir los importes a mano** (`"2.5"`): si cambia un precio, el ticket miente.
- **Calcular dentro del `println` sin paréntesis:** `"Total: " + importePan + importeLeche` pegaría los números (`"Total: 2.53.0"`) en lugar de sumarlos.
- **`VLC\042\T1` sin duplicar barras:** `\0` y `\04` son escapes válidos (octales) que producen caracteres invisibles, y `\T` da error. Sin duplicarlas, la salida no se parecería en nada.

## Otras formas de resolverlo

Con `printf` (tema 05) se puede alinear con mucha más precisión y fijar siempre dos decimales (`2.50` en lugar de `2.5`). Es la forma habitual en programas reales.

## Código completo

📄 [Sol02_05_TicketDeCompra.java](Sol02_05_TicketDeCompra.java)
