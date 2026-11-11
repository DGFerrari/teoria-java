# Ejercicio 02 · Suma de pares

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** bucle, acumulador, contador, `%`

## Enunciado

Completa [`Ej07_02_SumaDePares.java`](Ej07_02_SumaDePares.java) para que pida un número `N` y muestre:

1. La **operación** con todos los pares del 1 al N, separados por ` + `.
2. La **suma** de esos pares.
3. **Cuántos** pares hay.

Hazlo recorriendo **todos** los números del 1 al N y comprobando con `%` cuáles son pares.

## Salida esperada

```
N: 10
2 + 4 + 6 + 8 + 10 = 30
Hay 5 números pares entre 1 y 10
```

Con `N = 1` no hay pares:

```
N: 1
No hay números pares entre 1 y 1
```

## Pistas

<details>
<summary>Pista 1</summary>

Dentro del bucle, un `if (i % 2 == 0)` decide si el número cuenta. Si cuenta: `suma += i;` y `cantidad++;`.

</details>

<details>
<summary>Pista 2</summary>

El truco está en los ` + `: hay uno **entre** cada par de números, pero no antes del primero ni después del último. Muestra el ` + ` **antes** de cada número salvo el primero. ¿Cómo sabes si es el primero? Con el contador: si `cantidad` todavía es 0.

</details>

<details>
<summary>Pista 3</summary>

Muestra `= suma` al terminar el bucle, solo si ha habido algún par.

</details>

## Cómo ejecutarlo

```bash
java Ej07_02_SumaDePares.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-suma-de-pares/SOLUCION.md).
