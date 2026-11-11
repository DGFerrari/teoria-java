# Ejercicio 03 · Detector de palíndromos

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** normalizar textos (`toLowerCase`, quitar tildes, filtrar caracteres), `StringBuilder.reverse`, `equals`

## Enunciado

Un **palíndromo** es una palabra o frase que se lee igual de izquierda a derecha que de derecha a izquierda, **sin tener en cuenta** espacios, signos de puntuación, mayúsculas ni tildes: *"Anita lava la tina"*, *"Dábale arroz a la zorra el abad"*.

Completa [`Ej09_03_DetectorDePalindromos.java`](Ej09_03_DetectorDePalindromos.java) para que:

1. Lea una frase.
2. La **normalice**: todo en minúsculas, sin tildes (`á` → `a`, `é` → `e`...; la `ü` → `u`) y **solo con letras y dígitos** (fuera espacios y signos).
3. Le dé la vuelta con `StringBuilder`.
4. Compare las dos versiones y diga si es palíndromo.
5. Además, compruébalo **de una segunda forma**: comparando carácter a carácter desde los dos extremos hacia el centro, **parando en cuanto haya una diferencia** (sin `break`).

## Salida esperada

```
Escribe una frase: Dábale arroz a la zorra el abad
Normalizada: dabalearrozalazorraelabad
Al revés:    dabalearrozalazorraelabad
¿Es palíndromo? (con StringBuilder) true
¿Es palíndromo? (extremos al centro) true
```

```
Escribe una frase: Hola, mundo
Normalizada: holamundo
Al revés:    odnumaloh
¿Es palíndromo? (con StringBuilder) false
¿Es palíndromo? (extremos al centro) false
```

## Pistas

<details>
<summary>Pista 1</summary>

Para quitar las tildes, encadena `replace`:

```java
texto.toLowerCase().replace('á', 'a').replace('é', 'e')...
```

</details>

<details>
<summary>Pista 2</summary>

Para quedarte solo con letras y dígitos, recorre el texto y añade a un `StringBuilder` los caracteres que cumplan `Character.isLetterOrDigit(c)`.

</details>

<details>
<summary>Pista 3</summary>

Para la segunda forma, usa dos índices: `izquierda = 0` y `derecha = longitud - 1`. Mientras `izquierda < derecha` **y** sigan coincidiendo, acércalos al centro.

</details>

## Cómo ejecutarlo

```bash
java Ej09_03_DetectorDePalindromos.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-detector-de-palindromos/SOLUCION.md).
