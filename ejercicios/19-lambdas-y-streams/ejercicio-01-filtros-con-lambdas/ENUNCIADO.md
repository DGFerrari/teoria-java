# Ejercicio 01 · Filtros con lambdas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** lambdas, `Predicate<T>`, pasar una condición como parámetro, `and`, `or`, `negate`, `removeIf`, `forEach`

## Enunciado

En [`Ej19_01_FiltrosConLambdas.java`](Ej19_01_FiltrosConLambdas.java):

1. Completa `filtrar(numeros, condicion)`: devuelve los números que cumplen la condición. El método **no sabe** qué condición es: se la pasan.
2. Crea tres `Predicate<Integer>` con lambdas: `esPar`, `mayorQue10` y `multiploDe3`.
3. Úsalos con `filtrar`, solos y combinados con `and`, `or` y `negate`. El último filtro ("acaban en 1") escríbelo como lambda **directamente** en la llamada.
4. En una copia modificable de la lista, borra los menores que 10 con `removeIf`.
5. Muestra el doble de cada número de la copia con `forEach`.

## Salida esperada

```
Números: [4, 9, 15, 22, 7, 30, 11, 18, 3]
Pares: [4, 22, 30, 18]
Mayores que 10: [15, 22, 30, 11, 18]
Múltiplos de 3: [9, 15, 30, 18, 3]
Pares y mayores que 10: [22, 30, 18]
Impares o múltiplos de 3: [9, 15, 7, 30, 11, 18, 3]
No múltiplos de 3: [4, 22, 7, 11]
Acaban en 1 (lambda directa): [11]
Sin los menores que 10 (removeIf): [15, 22, 30, 11, 18]
Dobles con forEach: 30 44 60 22 36
```

## Pistas

<details>
<summary>Pista 1</summary>

Un `Predicate<Integer>` tiene un método `test` que devuelve `boolean`:

```java
Predicate<Integer> esPar = n -> n % 2 == 0;
esPar.test(4);    // true
```

</details>

<details>
<summary>Pista 2</summary>

"Impares" es "no pares": `esPar.negate()`. Y se puede encadenar: `esPar.negate().or(multiploDe3)`.

</details>

<details>
<summary>Pista 3</summary>

`List.of` crea una lista inmutable: `removeIf` lanzaría `UnsupportedOperationException`. Copia antes: `new ArrayList<>(numeros)`.

</details>

## Cómo ejecutarlo

```bash
java Ej19_01_FiltrosConLambdas.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-filtros-con-lambdas/SOLUCION.md).
