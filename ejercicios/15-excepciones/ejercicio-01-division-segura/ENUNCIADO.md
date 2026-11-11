# Ejercicio 01 · División segura

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** `try`, varios `catch`, `finally`, `getMessage()`

## Enunciado

Completa [`Ej15_01_DivisionSegura.java`](Ej15_01_DivisionSegura.java) para que lea dos números enteros (con `nextLine` y `Integer.parseInt`) y muestre la división entera y el resto. El programa **no puede terminar con un error**:

- Si alguno de los dos no es un número → `✘ Eso no es un número entero: <mensaje>`.
- Si el divisor es 0 → `✘ No se puede dividir entre cero`.
- Pase lo que pase, al final se muestra `Fin de la operación` (con `finally`).

## Salida esperada

```
Dividendo: 17
Divisor: 4
17 / 4 = 4 (resto 1)
Fin de la operación
```

```
Dividendo: 17
Divisor: 0
✘ No se puede dividir entre cero
Fin de la operación
```

```
Dividendo: diecisiete
✘ Eso no es un número entero: For input string: "diecisiete"
Fin de la operación
```

## Pistas

<details>
<summary>Pista 1</summary>

Pon **todo** (lecturas y cálculo) dentro del `try`. Si falla el primer `parseInt`, el resto del `try` no se ejecuta: por eso, en el tercer caso, no se llega a pedir el divisor.

</details>

<details>
<summary>Pista 2</summary>

Dos `catch`: `NumberFormatException` y `ArithmeticException`. Y un `finally` para el mensaje final.

</details>

## Cómo ejecutarlo

```bash
java Ej15_01_DivisionSegura.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-division-segura/SOLUCION.md).
