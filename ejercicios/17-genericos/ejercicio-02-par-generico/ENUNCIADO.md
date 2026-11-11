# Ejercicio 02 · Par genérico

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** clase con **dos** parámetros de tipo, un método que cambia el orden de los tipos, métodos genéricos `static <A, B>`, listas de objetos genéricos

## Enunciado

Completa [`Ej17_02_ParGenerico.java`](Ej17_02_ParGenerico.java):

**1. `Par<A, B>`** inmutable: guarda dos valores de tipos que pueden ser distintos. Tiene getters, `toString()` con el formato `(primero, segundo)` e `invertir()`, que devuelve un **`Par<B, A>`** nuevo.

**2. Dos métodos genéricos** en la clase principal:

| Método | Qué hace |
|---|---|
| `emparejar(List<A> primeros, List<B> segundos)` | Devuelve una `List<Par<A, B>>` uniendo las dos listas posición a posición. Si una es más larga, los que sobran se ignoran |
| `buscarPorPrimero(List<Par<A, B>> pares, A clave)` | Devuelve el primer par cuyo primer elemento es igual a `clave`, o `null` |

## Salida esperada

```
Par: (Ana, 15) → invertido: (15, Ana)
Emparejados: [(Ana, 15), (Luis, 17), (Marta, 16)]
Edad de Luis: 17
¿Y Pablo? null
Coordenadas: [(1, A), (2, B), (3, C)]
```

## Pistas

<details>
<summary>Pista 1</summary>

```java
Par<B, A> invertir() {
    return new Par<>(segundo, primero);
}
```

El diamante deduce `Par<B, A>` a partir del tipo de retorno.

</details>

<details>
<summary>Pista 2</summary>

La cabecera de `emparejar`:

```java
static <A, B> List<Par<A, B>> emparejar(List<A> primeros, List<B> segundos)
```

Recorre hasta `Math.min(primeros.size(), segundos.size())`.

</details>

<details>
<summary>Pista 3</summary>

En `buscarPorPrimero` puedes usar el propio resultado como bandera: `for (int i = 0; i < pares.size() && encontrado == null; i++)`.

</details>

## Cómo ejecutarlo

```bash
java Ej17_02_ParGenerico.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-par-generico/SOLUCION.md).
