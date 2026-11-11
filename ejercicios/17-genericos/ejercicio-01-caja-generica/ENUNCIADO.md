# Ejercicio 01 · Caja genérica

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** clase genérica con un parámetro de tipo `<T>`, diamante `<>`, usar la misma clase con varios tipos, tipos anidados

## Enunciado

En [`Ej17_01_CajaGenerica.java`](Ej17_01_CajaGenerica.java) hay una `Caja` que guarda un `Object`. Conviértela en **`Caja<T>`** y complétala:

| Método | Qué hace |
|---|---|
| `guardar(T objeto)` | Guarda el objeto (sustituye al anterior si lo había) |
| `mirar()` | Devuelve el contenido **sin** sacarlo |
| `sacar()` | Devuelve el contenido y deja la caja vacía (`null`) |
| `estaVacia()` | ¿El contenido es `null`? |
| `toString()` | `"[vacía]"` o `"[contenido]"` |

Después, en el `main`, úsala con `String`, con `Integer` y con otra caja dentro.

## Salida esperada

```
Caja de texto: [vacía]
Guardo "carta" → [carta]
Miro: carta · ¿Vacía? false
Saco: carta · ¿Vacía? true
Caja de números: [7]
7 al cuadrado: 49
Saco de una caja vacía: null
Caja de cajas: [[sorpresa]]
```

## Pistas

<details>
<summary>Pista 1</summary>

El parámetro de tipo va junto al nombre de la clase: `static class Caja<T> { private T contenido; ... }`.

</details>

<details>
<summary>Pista 2</summary>

`sacar` necesita una variable auxiliar, como cuando intercambiabas dos valores:

```java
T objeto = contenido;
contenido = null;
return objeto;
```

</details>

<details>
<summary>Pista 3</summary>

`Caja<Caja<String>>` es una caja cuyo `T` es `Caja<String>`. Su `toString` llama al `toString` de la caja de dentro, por eso salen dos corchetes.

</details>

## Cómo ejecutarlo

```bash
java Ej17_01_CajaGenerica.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-caja-generica/SOLUCION.md).
