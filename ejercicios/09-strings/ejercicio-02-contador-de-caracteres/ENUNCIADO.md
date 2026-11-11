# Ejercicio 02 · Contador de caracteres

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** recorrer un `String`, `charAt` / `toCharArray`, la clase `Character`, `indexOf` para listas de caracteres

## Enunciado

Completa [`Ej09_02_ContadorDeCaracteres.java`](Ej09_02_ContadorDeCaracteres.java) para que lea una frase y cuente:

- **vocales** (con o sin tilde, mayúsculas o minúsculas),
- **consonantes** (letras que no son vocales; la `ñ` es consonante),
- **dígitos**,
- **espacios**,
- **otros** caracteres (signos de puntuación, símbolos...).

Además, muestra la frase **sin vocales**.

## Salida esperada

```
Escribe una frase: Hola, me llamo Ana y tengo 15 años.
Vocales: 11
Consonantes: 13
Dígitos: 2
Espacios: 7
Otros: 2
Sin vocales: Hl, m llm n y tng 15 ñs.
```

## Pistas

<details>
<summary>Pista 1</summary>

Primero pregunta si es letra (`Character.isLetter`). Solo si lo es, decide si es vocal o consonante.

</details>

<details>
<summary>Pista 2</summary>

Para saber si es vocal, pásala a minúscula y búscala en una lista:

```java
final String VOCALES = "aeiouáéíóúü";
boolean esVocal = VOCALES.indexOf(Character.toLowerCase(c)) != -1;
```

</details>

<details>
<summary>Pista 3</summary>

La frase sin vocales se va construyendo con un `StringBuilder`: añade el carácter solo si **no** es vocal.

</details>

## Cómo ejecutarlo

```bash
java Ej09_02_ContadorDeCaracteres.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-contador-de-caracteres/SOLUCION.md).
