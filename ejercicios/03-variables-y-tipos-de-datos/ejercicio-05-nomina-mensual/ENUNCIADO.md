# Ejercicio 05 · Nómina mensual

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema: tipos primitivos, `String`, `char`, `final`, `var`, `parseInt`/`parseDouble`, casting, `Math.round`, `long`

## Enunciado

Una empresa recibe los datos de sus trabajadores desde un formulario web, así que **todos los números llegan como texto**. Completa [`Ej03_05_NominaMensual.java`](Ej03_05_NominaMensual.java) para calcular la nómina de Lucía.

**Datos (como texto):**

| Dato | Valor |
|---|---|
| Nombre | `"Lucía"` |
| Categoría | `'B'` |
| Horas trabajadas | `"160"` |
| Precio por hora | `"12.5"` |

**Constantes de la empresa** (decláralas con `final`):

| Constante | Valor |
|---|---|
| `RETENCION_IRPF` | 0.15 |
| `PLUS_CATEGORIA_B` | 50 |
| `PAGAS_ANUALES` | 14 |

**Cálculos:**

1. Convierte las horas y el precio por hora a número.
2. `bruto = horas × precioHora + plus`
3. `retencion = bruto × RETENCION_IRPF`
4. `neto = bruto − retencion`
5. Euros completos del neto (cortando) y neto redondeado.
6. `netoAnual = neto × PAGAS_ANUALES`
7. Neto anual en **céntimos**, como número entero (`long`).
8. El porcentaje de retención como número entero (15), calculado a partir de la constante.

Usa `var` **al menos en una** variable donde el tipo sea evidente.

## Salida esperada

```
=== NÓMINA DE Lucía (categoría B) ===
Horas trabajadas: 160
Precio por hora: 12.5 euros
Plus de categoría: 50 euros
Sueldo bruto: 2050.0 euros
Retención IRPF (15%): 307.5 euros
Sueldo neto: 1742.5 euros
  Euros completos: 1742
  Redondeado: 1743
Neto anual (14 pagas): 24395.0 euros
Neto anual en céntimos: 2439500
```

## Pistas

<details>
<summary>Pista 1</summary>

`int horas = Integer.parseInt(horasTexto);` y `double precioHora = Double.parseDouble(precioHoraTexto);`

</details>

<details>
<summary>Pista 2</summary>

Para los céntimos, multiplica por 100 y **redondea** con `Math.round` (que ya devuelve `long`). Si en lugar de redondear cortaras con `(long)`, la imprecisión de los `double` podría hacerte perder un céntimo en otros casos.

</details>

<details>
<summary>Pista 3</summary>

`RETENCION_IRPF * 100` es un `double` (`15.0`). Para tener el entero `15` usa `Math.round(RETENCION_IRPF * 100)`. Mejor redondear que cortar: con otros porcentajes la imprecisión puede jugar en tu contra (por ejemplo, `0.07 * 100` da `7.000000000000001`, y `0.29 * 100` da `28.999999999999996`, que cortado sería 28).

</details>

## Cómo ejecutarlo

```bash
java Ej03_05_NominaMensual.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-nomina-mensual/SOLUCION.md).
