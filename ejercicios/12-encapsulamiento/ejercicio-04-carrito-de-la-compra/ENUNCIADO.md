# Ejercicio 04 · Carrito de la compra

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** clase inmutable, arrays privados, copias defensivas, métodos privados de ayuda, constantes `static final`

## Enunciado

Completa las dos clases de [`Ej12_04_CarritoDeLaCompra.java`](Ej12_04_CarritoDeLaCompra.java).

**`Producto` (inmutable):**

- Atributos `private final`: `nombre` y `precio`.
- Getters, sin setters.
- `conDescuento(porcentaje)`: devuelve un **producto nuevo** con el precio rebajado. El original no cambia.

**`Carrito` (encapsulado):**

| Miembro | Detalle |
|---|---|
| `MAX_LINEAS` | `static final`, vale 10 |
| `productos`, `cantidades` | Arrays privados paralelos de tamaño `MAX_LINEAS`; `numLineas` dice cuántas hay |
| `agregar(producto, cantidad)` | Si ya hay una línea con ese nombre, suma la cantidad; si no, crea una línea nueva. Devuelve `false` si la cantidad es ≤ 0 o el carrito está lleno |
| `eliminar(nombre)` | Quita la línea y desplaza las siguientes |
| `getSubtotal()` | Suma de precio × cantidad |
| `aplicarCupon(codigo)` | Solo se puede aplicar **un** cupón. Códigos válidos: `AHORRA10` (10 %) y `VERANO25` (25 %). Devuelve si se ha aplicado |
| `getTotal()` | Subtotal con el descuento del cupón |
| `getProductos()` | Devuelve una **copia** con solo las líneas ocupadas |
| `buscarLinea(nombre)` y `porcentajeDeCupon(codigo)` | Métodos **privados** de ayuda |

## Salida esperada

```
Oferta: Teclado a 20,00 € (el original sigue a 25,00 €)
Artículos distintos: 3
Subtotal: 70,50 €
¿Cupón FALSO? false
¿Cupón AHORRA10? true
¿Cupón VERANO25? false
Total: 63,45 €
Tras eliminar la alfombrilla → Subtotal: 62,50 € | Total: 56,25 €
Copia modificada desde fuera. Artículos en el carrito: 2
```

## Pistas

<details>
<summary>Pista 1</summary>

`conDescuento` es una sola línea: `return new Producto(nombre, precio * (100 - porcentaje) / 100);`.

</details>

<details>
<summary>Pista 2</summary>

`porcentajeDeCupon` puede usar un `switch` moderno que devuelva `10`, `25` o `0` (no válido).

</details>

<details>
<summary>Pista 3</summary>

¿Por qué la copia de `getProductos()` puede compartir los mismos objetos `Producto` con el carrito? Porque son **inmutables**: aunque alguien tenga la referencia, no puede cambiarlos. Lo que se protege con la copia es el **array**.

</details>

## Cómo ejecutarlo

```bash
java Ej12_04_CarritoDeLaCompra.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-carrito-de-la-compra/SOLUCION.md).
