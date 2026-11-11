# Ejercicio 03 · Encuesta rota

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** `nextLine()` frente a `nextInt()` y `next()`, el salto de línea pendiente, leer un `char`

## Enunciado

El programa [`Ej05_03_EncuestaRota.java`](Ej05_03_EncuestaRota.java) hace una encuesta a los alumnos nuevos, pero **algunas preguntas se saltan solas** y los datos salen vacíos.

1. Ejecútalo tal cual y fíjate en qué preguntas no te dejan escribir.
2. Explica en un comentario **por qué** ocurre en cada caso.
3. Arréglalo usando la **solución A** (limpiar con un `nextLine()` extra) donde haga falta. No cambies el orden de las preguntas.
4. Añade al final una pregunta más: la **letra del grupo** (un `char`).
5. Muestra el resumen con `printf`.

## Salida esperada (cuando esté arreglado)

(Lo que escribe el usuario: `Ana López`, `15`, `San Sebastián`, `2`, `Paella valenciana`, `B`.)

```
=== ENCUESTA DE BIENVENIDA ===
Nombre completo: Ana López
Edad: 15
Ciudad: San Sebastián
Número de hermanos: 2
Comida favorita: Paella valenciana
Grupo (letra): B

--- Resumen ---
Ana López (15 años) vive en San Sebastián.
Tiene 2 hermanos y su comida favorita es: Paella valenciana.
Grupo: B
```

## Pistas

<details>
<summary>Pista 1</summary>

El problema aparece **solo** cuando un `nextLine()` va justo después de un `nextInt()` (o `nextDouble()`, `next()`...). Busca esos pares.

</details>

<details>
<summary>Pista 2</summary>

Hay **dos** sitios donde falta limpiar. El primer `nextLine()` (el nombre) funciona bien: ¿por qué?

</details>

<details>
<summary>Pista 3</summary>

La letra del grupo se lee con `teclado.next().charAt(0)`. Como va después de un `nextLine()`, aquí no hay problema.

</details>

## Cómo ejecutarlo

```bash
java Ej05_03_EncuestaRota.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-encuesta-rota/SOLUCION.md).
