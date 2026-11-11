# Ejercicio 03 · Caza de errores

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** errores de compilación, de ejecución y lógicos; leer mensajes de error

## Enunciado

El archivo [`Ej02_03_CazaDeErrores.java`](Ej02_03_CazaDeErrores.java) muestra la ficha de un videojuego, pero tiene **7 errores**:

- **5 errores de compilación**
- **1 error de ejecución**
- **1 error lógico**

Tu trabajo:

1. Ejecuta el archivo y **lee el mensaje de error**. Anota la línea y qué dice.
2. Arregla ese error y vuelve a ejecutar. Repite hasta que compile.
3. Cuando compile, encontrarás el error de ejecución. Arréglalo.
4. Cuando funcione, compara la salida con la esperada y busca el error lógico.
5. Al lado de cada línea que corrijas, deja un comentario indicando **qué tipo de error era**.

> ⚠️ Es normal que tu editor marque el archivo en rojo: **no compila a propósito**.

## Salida esperada (cuando esté todo arreglado)

```
=== Ficha del videojuego ===
Título: "La leyenda del código"
Género: aventura
Precio: 59.99 euros
Jugadores en el modo cooperativo: 4
Puntos por jugador: 250
=== Fin de la ficha ===
```

## Pistas

<details>
<summary>Pista 1</summary>

El compilador no siempre muestra todos los errores a la vez. Cuando arreglas uno, pueden aparecer otros que antes "tapaba". Arregla siempre **el primero de la lista**.

</details>

<details>
<summary>Pista 2</summary>

Los errores de compilación están en este orden: un `;`, una mayúscula, una letra que falta en un nombre, unas comillas y una llave.

</details>

<details>
<summary>Pista 3</summary>

El error de ejecución es una división. ¿Entre qué número se divide? Hay 4 jugadores.

</details>

<details>
<summary>Pista 4</summary>

El error lógico está en la línea de los jugadores: recuerda qué pasa con `"texto" + 3 + 1` (sección 5 de la teoría).

</details>

## Cómo ejecutarlo

```bash
java Ej02_03_CazaDeErrores.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-caza-de-errores/SOLUCION.md).
