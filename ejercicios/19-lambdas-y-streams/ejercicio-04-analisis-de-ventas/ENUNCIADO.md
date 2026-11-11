# Ejercicio 04 · Análisis de ventas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** `Collectors.groupingBy` con mapa concreto y *downstream* (`summingDouble`, `summingInt`, `mapping`), `partitioningBy`, ordenar los pares de un mapa con `Map.Entry.comparingByValue`, `Optional` con `map` y `orElse`

## Enunciado

Una tienda tiene las ventas del primer trimestre en una lista de records `Venta`. Completa los métodos de [`Ej19_04_AnalisisDeVentas.java`](Ej19_04_AnalisisDeVentas.java) usando **streams** y muestra el informe:

| Método | Devuelve |
|---|---|
| `totalFacturado` | La suma de todos los importes |
| `facturacionPorCategoria` | `TreeMap` categoría → importe total |
| `unidadesPorMes`, `facturacionPorMes` | `LinkedHashMap` mes → unidades / importe (en el orden de los datos) |
| `topProductos(ventas, n)` | Los `n` productos con más importe total, como pares `Map.Entry` |
| `contarGrandes(ventas, limite)` | Cuántas ventas superan el límite (`true`) y cuántas no (`false`) |
| `mayorVentaDe(ventas, categoria)` | `Optional` con la venta de más unidades de esa categoría |
| `productosPorCategoria` | Categoría → conjunto ordenado de productos distintos |

## Salida esperada

```
Total facturado: 729,80 €
=== Por categoría ===
Electrónica    457,60 €
Juguetes       144,00 €
Libros         128,20 €
=== Por mes ===
Enero      6 uds. ·  133,40 €
Febrero   11 uds. ·  139,75 €
Marzo     12 uds. ·  456,65 €
=== Top 3 productos ===
1. Auriculares (239,60 €)
2. Altavoz (158,00 €)
3. Puzle 1000 (144,00 €)
Ventas de más de 100 €: 3 · resto: 7
Unidades medias por venta: 2,90
Mayor venta de Libros: Dune (5 uds.)
Mayor venta de Juegos de mesa: sin ventas
Productos por categoría: {Electrónica=[Altavoz, Auriculares, Cargador USB], Juguetes=[Puzle 1000], Libros=[Dune, El Quijote]}
```

## Pistas

<details>
<summary>Pista 1</summary>

`groupingBy` admite tres argumentos: por qué agrupar, qué tipo de mapa crear y qué hacer con cada grupo:

```java
ventas.stream().collect(Collectors.groupingBy(
        Venta::categoria, TreeMap::new, Collectors.summingDouble(Venta::importe)));
```

</details>

<details>
<summary>Pista 2</summary>

Para el top: primero agrupa por producto; después crea un stream con los **pares** del mapa y ordénalos por su valor:

```java
porProducto.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(cuantos)
        .toList();
```

</details>

<details>
<summary>Pista 3</summary>

`Optional.map` transforma el valor solo si existe, y `orElse` da el texto alternativo:

```java
mayorVentaDe(ventas, categoria)
        .map(v -> v.producto() + " (" + v.unidades() + " uds.)")
        .orElse("sin ventas");
```

</details>

<details>
<summary>Pista 4</summary>

`Collectors.mapping(Venta::producto, Collectors.toCollection(TreeSet::new))` transforma cada venta del grupo en su producto y los guarda en un `TreeSet`.

</details>

## Cómo ejecutarlo

```bash
java Ej19_04_AnalisisDeVentas.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-analisis-de-ventas/SOLUCION.md).
