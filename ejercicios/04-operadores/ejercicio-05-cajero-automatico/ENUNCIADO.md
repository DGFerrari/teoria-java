# Ejercicio 05 · Cajero automático

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema (aritméticos, `/` y `%`, `+=`/`-=`, `++`, relacionales, lógicos, `Math`, `Random`) + `long` y céntimos del tema 03

## Enunciado

Simula una retirada en un cajero. Completa [`Ej04_05_CajeroAutomatico.java`](Ej04_05_CajeroAutomatico.java):

1. El cliente tiene un saldo de **1 000 euros**, guardado en **céntimos** con un `long` (para evitar la imprecisión de los `double`).
2. La cantidad a retirar es un número **aleatorio** de euros entre **1 y 500** (ambos incluidos).
3. Desglosa la cantidad en **billetes de 50, 20, 10 y 5** y **monedas de 2 y 1**, usando siempre el mínimo número de piezas.
4. Cuenta el **total de billetes** y el **total de monedas**.
5. Calcula una **comisión del 2 %** de la cantidad, en céntimos, redondeada.
6. Resta del saldo la cantidad y la comisión con `-=`.
7. Suma 1 al contador de operaciones con `++`.
8. Muestra el saldo restante en euros (con decimales).
9. Responde con `boolean`:
   - ¿La operación era válida? (cantidad entre 1 y 500 **y** cantidad + comisión no superaban el saldo inicial)
   - ¿El saldo ha quedado por debajo de 700 euros?
   - ¿La cantidad es múltiplo de 10?

> 💡 Para comprobar tu programa con la salida de abajo, cambia temporalmente la línea del aleatorio por `int cantidad = 387;`.

## Salida esperada (con cantidad = 387)

```
=== CAJERO AUTOMÁTICO ===
Cantidad solicitada: 387 euros
Billetes de 50: 7
Billetes de 20: 1
Billetes de 10: 1
Billetes de 5: 1
Monedas de 2: 1
Monedas de 1: 0
Total de billetes: 10 | Total de monedas: 1
Comisión (2%): 7.74 euros
Saldo restante: 605.26 euros
Operaciones realizadas: 1
¿Operación válida? true
¿Saldo por debajo de 700 euros? true
¿Cantidad múltiplo de 10? false
```

## Pistas

<details>
<summary>Pista 1</summary>

El desglose es igual que el del ejercicio 02: para cada billete, `/` da cuántos y `%` lo que queda.

```
billetes50 ← cantidad / 50
resto ← cantidad % 50
billetes20 ← resto / 20
...
```

</details>

<details>
<summary>Pista 2</summary>

Trabaja todo el dinero del saldo en céntimos:

- Saldo inicial: `100_000L` céntimos.
- Cantidad en céntimos: `cantidad * 100`.
- Comisión en céntimos: `Math.round(cantidad * 100 * 0.02)`.

</details>

<details>
<summary>Pista 3</summary>

Para mostrar céntimos como euros con decimales, divide entre `100.0` (no entre `100`, que sería división entera).

</details>

<details>
<summary>Pista 4</summary>

Para la "operación válida" necesitas el saldo **antes** de restar. Guarda una copia (`long saldoInicial = saldoCentimos;`) o calcula el `boolean` antes del `-=`.

</details>

## Cómo ejecutarlo

```bash
java Ej04_05_CajeroAutomatico.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-cajero-automatico/SOLUCION.md).
