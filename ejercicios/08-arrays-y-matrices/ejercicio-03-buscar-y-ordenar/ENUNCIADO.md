# Ejercicio 03 · Buscar y ordenar

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** búsqueda de todas las apariciones, copiar arrays, invertir, método de la burbuja, `Arrays.toString`, `Arrays.sort`, `Arrays.equals`

## Enunciado

En [`Ej08_03_BuscarYOrdenar.java`](Ej08_03_BuscarYOrdenar.java) tienes este array:

```java
int[] numeros = {23, 7, 42, 7, 15, 8, 42, 4, 16, 7};
```

Completa el programa para que:

1. Pida un número y muestre **todas las posiciones** en las que aparece y **cuántas veces** está (o que no está).
2. Cree una **copia invertida** del array, sin modificar el original.
3. Cree **otra copia** y la ordene con el **método de la burbuja**, contando cuántos **intercambios** ha hecho.
4. Cree una **tercera copia**, la ordene con `Arrays.sort` y compruebe con `Arrays.equals` que el resultado es el mismo que el de tu burbuja.
5. Muestre al final el original para comprobar que **no ha cambiado**.

## Salida esperada

```
Array: [23, 7, 42, 7, 15, 8, 42, 4, 16, 7]
¿Qué número buscas? 7
Aparece en las posiciones: 1 3 9
Aparece 3 veces
Invertido: [7, 16, 4, 42, 8, 15, 7, 42, 7, 23]
Burbuja:   [4, 7, 7, 7, 8, 15, 16, 23, 42, 42] (24 intercambios)
Arrays.sort: [4, 7, 7, 7, 8, 15, 16, 23, 42, 42]
¿Coinciden? true
Original sin cambios: [23, 7, 42, 7, 15, 8, 42, 4, 16, 7]
```

Con un número que no está:

```
¿Qué número buscas? 100
El 100 no está en el array
```

## Pistas

<details>
<summary>Pista 1</summary>

Para encontrar **todas** las apariciones no hay que parar en la primera: recorre el array entero con un `for` y cuenta las coincidencias.

</details>

<details>
<summary>Pista 2</summary>

Para la copia invertida, crea un array nuevo del mismo tamaño y rellénalo así: `invertido[i] = numeros[numeros.length - 1 - i]`.

</details>

<details>
<summary>Pista 3</summary>

¡Cuidado! `int[] burbuja = numeros;` **no** es una copia: al ordenar `burbuja` estarías ordenando también `numeros`. Usa `Arrays.copyOf` o `clone()`.

</details>

## Cómo ejecutarlo

```bash
java Ej08_03_BuscarYOrdenar.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-buscar-y-ordenar/SOLUCION.md).
