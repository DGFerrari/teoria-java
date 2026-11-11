# Ejercicio 02 · Tienda de camisetas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** enum con atributos `final`, constructor y métodos, método `static` que recorre `values()`, `valueOf` con captura de errores, orden de los `catch`

## Enunciado

Una tienda vende camisetas a **12 €** con un recargo según la talla. Completa el enum `Talla` de [`Ej18_02_TiendaDeCamisetas.java`](Ej18_02_TiendaDeCamisetas.java):

| Talla | Pecho máximo | Recargo |
|---|---|---|
| `S` | 92 cm | 0 € |
| `M` | 100 cm | 0 € |
| `L` | 108 cm | 1,50 € |
| `XL` | 116 cm | 3,00 € |

- `precio()`: precio base + recargo.
- `recomendada(contornoPecho)` (`static`): la **primera** talla cuyo pecho máximo sea mayor o igual que el contorno. Si no cabe en ninguna, `XL`.

Después, procesa un pedido en el que cada línea es `talla;cantidad`. La talla puede venir en minúsculas. Si la talla no existe o la cantidad no es un número, muestra el error y sigue con la siguiente línea.

## Salida esperada

```
=== Tallas ===
S  hasta 92 cm de pecho · 12,00 €
M  hasta 100 cm de pecho · 12,00 €
L  hasta 108 cm de pecho · 13,50 €
XL hasta 116 cm de pecho · 15,00 €
Talla recomendada para 97 cm: M
Talla recomendada para 120 cm: XL
=== Pedido ===
2 × M  = 24,00 €
1 × XL = 15,00 €
✘ "XXL;1": talla desconocida
✘ "L;tres": cantidad no válida
3 × L  = 40,50 €
Total: 79,50 € (6 camisetas)
```

## Pistas

<details>
<summary>Pista 1</summary>

```java
enum Talla {
    S(92, 0.0),
    M(100, 0.0),
    ...;                             // ← punto y coma

    private final int pechoMaximo;
    private final double recargo;

    Talla(int pechoMaximo, double recargo) { ... }
}
```

</details>

<details>
<summary>Pista 2</summary>

Un enum anidado puede usar las constantes `static` de la clase que lo contiene, como `PRECIO_BASE`.

</details>

<details>
<summary>Pista 3</summary>

`Talla.valueOf("XXL")` lanza `IllegalArgumentException` e `Integer.parseInt("tres")` lanza `NumberFormatException`, que es **subclase** de la anterior. Su `catch` tiene que ir primero (tema 15).

</details>

## Cómo ejecutarlo

```bash
java Ej18_02_TiendaDeCamisetas.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-tienda-de-camisetas/SOLUCION.md).
