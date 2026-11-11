# Ejercicio 03 · Conversor de unidades

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** constantes `final`, casting `(int)`, `Math.round`, división entera frente a decimal

## Enunciado

Completa [`Ej03_03_ConversorDeUnidades.java`](Ej03_03_ConversorDeUnidades.java) para hacer cuatro conversiones:

1. **Maratón:** 42.195 km a millas. Muestra solo las **millas completas** (sin redondear, cortando decimales).
2. **Altura:** 180 cm a pulgadas, **redondeando** al entero más cercano.
3. **Película:** 135 minutos a horas, con decimales (2.25) y en **horas completas** (2).
4. **Temperatura:** 38 ºC a Fahrenheit con la fórmula `F = C × 9 / 5 + 32`, calculada de **dos maneras**: solo con enteros y con decimales. Comprueba que salen resultados distintos.

Las cifras de conversión deben ser **constantes** (`final`):

| Constante | Valor |
|---|---|
| `KM_A_MILLAS` | 0.621371 |
| `CM_POR_PULGADA` | 2.54 |
| `MINUTOS_POR_HORA` | 60 |

## Salida esperada

```
Maratón: 42.195 km = 26 millas completas
Altura: 180 cm = 71 pulgadas (redondeado)
Película: 135 min = 2.25 horas (2 horas completas)
Temperatura: 38 ºC
  Con enteros:   100 ºF
  Con decimales: 100.4 ºF
```

## Pistas

<details>
<summary>Pista 1</summary>

- Cortar decimales → `(int) valor`
- Redondear → `Math.round(valor)` (devuelve un `long`)

</details>

<details>
<summary>Pista 2</summary>

`135 / 60` da `2` porque los dos son `int`. Para obtener `2.25`, al menos uno de los dos tiene que ser decimal: `135 / 60.0` o `(double) minutos / MINUTOS_POR_HORA`.

</details>

<details>
<summary>Pista 3</summary>

En la fórmula con enteros, `38 * 9 / 5` da `68` (no 68.4). Para la versión decimal, basta con cambiar el `5` por `5.0`.

</details>

## Cómo ejecutarlo

```bash
java Ej03_03_ConversorDeUnidades.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-conversor-de-unidades/SOLUCION.md).
