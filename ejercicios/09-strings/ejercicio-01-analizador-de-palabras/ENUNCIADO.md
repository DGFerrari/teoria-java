# Ejercicio 01 · Analizador de palabras

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** `length`, `charAt`, `toUpperCase`, `toLowerCase`, `substring`, `indexOf`, `contains`

## Enunciado

Completa [`Ej09_01_AnalizadorDePalabras.java`](Ej09_01_AnalizadorDePalabras.java) para que pida una palabra y muestre la información de la salida esperada.

## Salida esperada

```
Escribe una palabra: Programación
Longitud: 12
Primera letra: P
Última letra: n
En mayúsculas: PROGRAMACIÓN
En minúsculas: programación
Primera mitad: Progra
Posición de la primera 'a': 5
¿Contiene "gram"? true
```

## Pistas

<details>
<summary>Pista 1</summary>

La última letra está en la posición `length() - 1`.

</details>

<details>
<summary>Pista 2</summary>

La primera mitad es `substring(0, length() / 2)`. Con 12 letras, `substring(0, 6)`.

</details>

<details>
<summary>Pista 3</summary>

`indexOf` devuelve `-1` si no encuentra la letra. Para buscar sin importar mayúsculas, busca en la versión en minúsculas.

</details>

## Cómo ejecutarlo

```bash
java Ej09_01_AnalizadorDePalabras.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-analizador-de-palabras/SOLUCION.md).
