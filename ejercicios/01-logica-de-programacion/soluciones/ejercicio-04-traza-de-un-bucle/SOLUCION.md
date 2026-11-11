# Solución · Ejercicio 04 · Traza de un bucle

[⬅️ Enunciado](../../ejercicio-04-traza-de-un-bucle/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## La traza

Valores iniciales: `valor = 1`, `total = 0`, `vuelta = 1`.

| Vuelta | ¿`vuelta <= 5`? | `total ← total + valor` | `valor ← valor * 2` |
|---|---|---|---|
| 1 | Sí | 0 + 1 = **1** | 1 × 2 = **2** |
| 2 | Sí | 1 + 2 = **3** | 2 × 2 = **4** |
| 3 | Sí | 3 + 4 = **7** | 4 × 2 = **8** |
| 4 | Sí | 7 + 8 = **15** | 8 × 2 = **16** |
| 5 | Sí | 15 + 16 = **31** | 16 × 2 = **32** |
| — | `vuelta` = 6 → **No**, sale | 31 | 32 |

Al final se escribe `total = 31` y `valor = 32`.

## ¿Qué calcula?

- `valor` va tomando las **potencias de 2**: 1, 2, 4, 8, 16... y termina en 32 (2⁵).
- `total` es la **suma** de esas potencias: 1 + 2 + 4 + 8 + 16 = 31.

Curiosidad: la suma siempre es una unidad menos que el siguiente valor (31 = 32 − 1). Esto se cumple con cualquier número de vueltas.

## Código explicado

```java
while (vuelta <= 5) {
    total = total + valor;     // a) acumulador: usa el valor ANTES de duplicarlo
    valor = valor * 2;         // b) duplicamos
    System.out.println("Vuelta " + vuelta + " -> total = " + total + ", valor = " + valor);
    vuelta = vuelta + 1;       // d) avanzamos el contador (así el bucle termina)
}
```

Hay tres tipos de variable en este bucle:

| Variable | Papel | Cómo cambia |
|---|---|---|
| `vuelta` | **Contador**: controla cuántas veces se repite | +1 en cada vuelta |
| `total` | **Acumulador**: va guardando una suma | + `valor` en cada vuelta |
| `valor` | Valor que va cambiando según una regla | × 2 en cada vuelta |

## Errores comunes

- **Cambiar el orden de a) y b):** si duplicas antes de sumar, sumas 2 + 4 + 8 + 16 + 32 = 62.
- **Mostrar después de `vuelta = vuelta + 1`:** las líneas dirían "Vuelta 2" a "Vuelta 6".
- **Olvidar `vuelta = vuelta + 1`:** bucle infinito (y `valor` acaba dando números raros, porque un `int` tiene un límite que verás en el tema 03).
- **Poner `vuelta < 5`:** solo da 4 vueltas.

## Código completo

📄 [Sol01_04_TrazaDeUnBucle.java](Sol01_04_TrazaDeUnBucle.java)
