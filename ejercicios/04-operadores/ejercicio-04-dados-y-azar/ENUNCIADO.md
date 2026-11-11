# Ejercicio 04 · Dados y azar

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** `Random`, rangos de números aleatorios, `/` y `%` para separar cifras, comprobaciones con `boolean`

## Enunciado

Vas a preparar la parte "aleatoria" de un juego de mesa. Completa [`Ej04_04_DadosYAzar.java`](Ej04_04_DadosYAzar.java):

1. **Dos dados** de 6 caras. Muestra cada dado, la suma, si es **doble** (los dos iguales) y si la suma es **par**.
2. **Una carta**: número del 1 al 12 y palo del 0 al 3.
3. **Temperatura** del tablero entre −5.0 y 35.0 ºC, mostrada con **un decimal**.
4. **Código secreto** de tres cifras, entre 100 y 999 (ambos incluidos), usando la **fórmula general** `nextInt(max - min + 1) + min`. Separa sus tres cifras con `/` y `%` y súmalas.
5. **Moneda**: `true` si sale cara.
6. **Comprobaciones**: muestra una línea `boolean` que confirme que **cada** valor está dentro de su rango. Todas deben dar `true` siempre.

Como los valores son aleatorios, cada ejecución dará una salida distinta. Ejecútalo varias veces.

## Salida de ejemplo

```
Dado 1: 4 | Dado 2: 4 | Suma: 8
¿Es doble? true | ¿Suma par? true
Carta: 11 del palo 2
Temperatura: 17.3 ºC
Código secreto: 582 → cifras 5, 8, 2 → suma 15
¿Cara? false
--- Comprobaciones ---
Dados en rango: true
Carta en rango: true
Temperatura en rango: true
Código en rango: true
```

## Pistas

<details>
<summary>Pista 1</summary>

Crea **un solo** objeto `Random` al principio y úsalo para todo. Recuerda que `nextInt(min, max)` **no incluye** `max`: para 1–6 es `nextInt(1, 7)`.

</details>

<details>
<summary>Pista 2</summary>

Con un número de tres cifras `n`:

- centenas: `n / 100`
- decenas: `n / 10 % 10`
- unidades: `n % 10`

</details>

<details>
<summary>Pista 3</summary>

Para un decimal: `Math.round(t * 10) / 10.0`. La temperatura tiene que estar en `[-5, 35)`: `t >= -5 && t < 35`.

</details>

<details>
<summary>Pista 4</summary>

¿Quieres que salga siempre lo mismo mientras pruebas? Crea el generador con una semilla: `new Random(7)`.

</details>

## Cómo ejecutarlo

```bash
java Ej04_04_DadosYAzar.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-dados-y-azar/SOLUCION.md).
