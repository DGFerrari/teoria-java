# Ejercicio 04 · Números primos

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** bucles anidados, bandera en la condición, validación con `do-while`, contador y acumulador

## Enunciado

Un número **primo** es un entero mayor que 1 que solo es divisible entre 1 y entre sí mismo (2, 3, 5, 7, 11...).

Completa [`Ej07_04_NumerosPrimos.java`](Ej07_04_NumerosPrimos.java):

1. Pide el **inicio** y el **fin** de un rango. Repite la pregunta (con `do-while`) mientras el inicio sea menor que 1 o el fin sea menor que el inicio.
2. Recorre el rango y, para cada número, comprueba si es primo con un **bucle interior** que busque divisores.
3. El bucle interior debe **dejar de buscar** en cuanto encuentre un divisor, usando una bandera en su condición (sin `break`).
4. Muestra los primos separados por espacios, **10 por línea**.
5. Al final, muestra cuántos primos hay y cuánto suman.

## Salida esperada

```
Inicio del rango: 10
Fin del rango: 30
Primos entre 10 y 30:
11 13 17 19 23 29
Total: 6 primos | Suma: 112
```

```
Inicio del rango: 0
Fin del rango: 5
  El inicio debe ser al menos 1 y el fin no puede ser menor que el inicio.
Inicio del rango: 1
Fin del rango: 50
Primos entre 1 y 50:
2 3 5 7 11 13 17 19 23 29
31 37 41 43 47
Total: 15 primos | Suma: 328
```

## Pistas

<details>
<summary>Pista 1</summary>

Para saber si `n` es primo, prueba divisores desde 2. Si alguno divide a `n` (`n % divisor == 0`), no es primo.

```java
boolean esPrimo = n > 1;
int divisor = 2;
while (divisor < n && esPrimo) {
    ...
}
```

</details>

<details>
<summary>Pista 2</summary>

No hace falta probar todos los divisores hasta `n - 1`: basta con llegar hasta la **raíz cuadrada** de `n`. Si `n` tuviera un divisor mayor que su raíz, tendría también otro menor, que ya habríamos encontrado. La condición queda: `divisor * divisor <= n && esPrimo`.

</details>

<details>
<summary>Pista 3</summary>

Para los 10 por línea, usa el contador de primos: después de mostrar uno, si `contador % 10 == 0`, salta de línea.

</details>

## Cómo ejecutarlo

```bash
java Ej07_04_NumerosPrimos.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-numeros-primos/SOLUCION.md).
