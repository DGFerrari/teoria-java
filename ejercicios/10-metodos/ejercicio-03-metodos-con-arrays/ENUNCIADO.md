# Ejercicio 03 · Métodos con arrays

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** pasar arrays a métodos, métodos que **modifican** un array frente a métodos que **devuelven** uno nuevo, sobrecarga

## Enunciado

Completa los métodos de [`Ej10_03_MetodosConArrays.java`](Ej10_03_MetodosConArrays.java). El `main` ya los usa:

| Método | Tipo | Qué hace |
|---|---|---|
| `rellenarAleatorio(datos, random, min, max)` | `void` | **Modifica** el array: pone en cada posición un aleatorio entre `min` y `max` (incluidos) |
| `mostrar(datos)` | `void` | Muestra el array como `[a, b, c]` |
| `mostrar(datos, titulo)` | `void` | **Sobrecarga**: muestra `titulo: [a, b, c]`. Debe reutilizar la versión anterior |
| `media(datos)` | `double` | Devuelve la media |
| `posicionDelMaximo(datos)` | `int` | Devuelve la posición del mayor |
| `contarMayoresQue(datos, limite)` | `int` | Cuántos superan el límite |
| `filtrarPares(datos)` | `int[]` | **Devuelve un array nuevo** solo con los pares; el original no cambia |

El generador usa una **semilla** (`new Random(42)`), así que todo el mundo obtiene los mismos números.

## Salida esperada

```
Datos: [17, 30, 9, 71, 36, 16, 41, 74, 70, 2]
Media: 36,60
Máximo: 74 (posición 7)
Mayores que 50: 3
Pares: [30, 36, 16, 74, 70, 2]
Datos (sin cambios): [17, 30, 9, 71, 36, 16, 41, 74, 70, 2]
```

(Los números salen así con `new Random(42)` y `nextInt(min, max + 1)`. Si generas los aleatorios de otra forma, por ejemplo con `nextInt(max - min + 1) + min`, obtendrás otros valores igual de válidos.)

## Pistas

<details>
<summary>Pista 1</summary>

`rellenarAleatorio` no necesita `return`: como el array se pasa por referencia, los cambios se ven fuera del método.

</details>

<details>
<summary>Pista 2</summary>

La versión con título de `mostrar` solo tiene que escribir el título con `print` y llamar a la otra versión:

```java
static void mostrar(int[] datos, String titulo) {
    System.out.print(titulo + ": ");
    mostrar(datos);
}
```

</details>

<details>
<summary>Pista 3</summary>

`filtrarPares` necesita **dos** recorridos: el primero para **contar** los pares (y saber el tamaño del nuevo array) y el segundo para **copiarlos**. Usa un índice aparte para ir llenando el nuevo array.

</details>

## Cómo ejecutarlo

```bash
java Ej10_03_MetodosConArrays.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-metodos-con-arrays/SOLUCION.md).
