# Ejercicio 03 · Palabras únicas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** `Set` sin duplicados, `LinkedHashSet` frente a `TreeSet`, el valor que devuelve `add`, unión, intersección y diferencia (`retainAll`, `removeAll`)

## Enunciado

En [`Ej16_03_PalabrasUnicas.java`](Ej16_03_PalabrasUnicas.java) tienes dos frases y un método `palabras(texto)` que ya las convierte en una `List<String>` en minúsculas y sin signos de puntuación.

1. Del texto 1, muestra cuántas palabras tiene, cuántas son **distintas** y cuáles son, primero en **orden de aparición** y después en **orden alfabético**.
2. Completa `repetidas(palabras)`: devuelve, ordenadas, las palabras que aparecen más de una vez.
3. Compara los dos textos: palabras que están **en los dos**, **solo en el 1** y **solo en el 2**.

## Salida esperada

```
Texto 1: 14 palabras, 9 distintas
En orden de aparición: [el, sol, sale, por, este, y, se, pone, oeste]
En orden alfabético:   [el, este, oeste, pone, por, sale, se, sol, y]
Repetidas en el texto 1: [el, por, sol]
En los dos textos: [pone, por, sale, se, y]
Solo en el texto 1: [el, este, oeste, sol]
Solo en el texto 2: [la, luna, mañana, noche]
```

## Pistas

<details>
<summary>Pista 1</summary>

Un conjunto se puede crear directamente a partir de una lista: `new LinkedHashSet<>(lista1)`. Los duplicados desaparecen solos.

</details>

<details>
<summary>Pista 2</summary>

Para las repetidas, recorre la lista guardando cada palabra en un conjunto de "vistas". Si `vistas.add(palabra)` devuelve `false`, es que ya la habías visto.

</details>

<details>
<summary>Pista 3</summary>

`retainAll` y `removeAll` **modifican** el conjunto sobre el que se llaman. Trabaja siempre sobre una copia:

```java
Set<String> comunes = new TreeSet<>(set1);
comunes.retainAll(set2);
```

</details>

## Cómo ejecutarlo

```bash
java Ej16_03_PalabrasUnicas.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-palabras-unicas/SOLUCION.md).
