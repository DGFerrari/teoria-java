# Ejercicio 04 · Máquina expendedora

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** enums con datos y búsqueda por código, el orden de `values()`, un `record` como resultado, `EnumMap`, `EnumSet`, excepciones (tema 15)

## Enunciado

Programa una máquina de vending en [`Ej18_04_MaquinaExpendedora.java`](Ej18_04_MaquinaExpendedora.java). Los importes se guardan en **céntimos** (`int`) para evitar los errores de redondeo de `double` (tema 03).

| Elemento | Qué es | Estado |
|---|---|---|
| `Moneda` | Enum con el valor de cada moneda, de **mayor a menor** | Hecho |
| `Producto` | Enum con código y precio | Falta `porCodigo` |
| `Venta` | Record con el producto, lo pagado y el cambio | Hecho |
| `Maquina` | Stock (`EnumMap<Producto, Integer>`), recaudación y ventas | Por hacer |

**`comprar(codigo, monedas)`** comprueba, en este orden:

1. Que el código exista → si no, `IllegalArgumentException("Código desconocido: Z9")`.
2. Que quede stock → si no, `IllegalStateException("ZUMO agotado")`.
3. Que el dinero alcance → si no, `IllegalArgumentException("Importe insuficiente: faltan 0,35 €")`.

Si todo va bien, resta una unidad, suma el precio a lo recaudado y devuelve la `Venta`.

**`desglose(centimos)`** calcula las monedas del cambio con el método de siempre (como en el cajero del tema 04): la moneda más grande que quepa, tantas veces como quepa, y se pasa a la siguiente. Como `Moneda` está declarada de mayor a menor, basta con recorrer `Moneda.values()`.

**`agotados()`** devuelve un `EnumSet` con los productos sin stock.

## Salida esperada

```
A2 con [1 €, 50 cts] → ✔ REFRESCO (1,50 €)
B1 con [2 €] → ✔ ZUMO (1,75 €) · cambio 0,25 €: 1 × 20 cts, 1 × 5 cts
C1 con [1 €] → ✘ Importe insuficiente: faltan 0,35 € (se devuelve el dinero)
Z9 con [1 €] → ✘ Código desconocido: Z9 (se devuelve el dinero)
A1 con [2 €, 2 €] → ✔ AGUA (0,90 €) · cambio 3,10 €: 1 × 2 €, 1 × 1 €, 1 × 10 cts
B1 con [2 €] → ✘ ZUMO agotado (se devuelve el dinero)
=== Resumen ===
Ventas: 3 · recaudado: 4,15 €
Stock: {AGUA=2, REFRESCO=1, ZUMO=0, CHOCOLATINA=0, PATATAS=4}
Agotados: [ZUMO, CHOCOLATINA]
```

## Pistas

<details>
<summary>Pista 1</summary>

Un `EnumMap` se recorre siempre en el **orden de declaración** del enum, aunque las claves se añadieran en otro orden. Por eso el stock y el desglose salen ordenados sin hacer nada.

</details>

<details>
<summary>Pista 2</summary>

```java
for (Moneda m : Moneda.values()) {
    int cuantas = pendiente / m.getCentimos();
    if (cuantas > 0) {
        monedas.put(m, cuantas);
        pendiente = pendiente % m.getCentimos();
    }
}
```

</details>

<details>
<summary>Pista 3</summary>

`EnumSet.noneOf(Producto.class)` crea un conjunto vacío al que puedes ir añadiendo productos con `add`.

</details>

## Cómo ejecutarlo

```bash
java Ej18_04_MaquinaExpendedora.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-maquina-expendedora/SOLUCION.md).
