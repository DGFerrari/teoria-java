# Ejercicio 02 · Lector robusto

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** `try`/`catch` dentro de un bucle, bandera, métodos reutilizables

## Enunciado

Completa el método `leerNota` de [`Ej15_02_LectorRobusto.java`](Ej15_02_LectorRobusto.java). Debe pedir una nota entera **hasta que sea válida**:

- Si no es un número → `  ✘ "abc" no es un número`.
- Si no está entre 0 y 10 → `  ✘ La nota tiene que estar entre 0 y 10`.

El `main` ya usa el método para leer tres notas y mostrar la media.

## Salida esperada

```
Nota 1: abc
  ✘ "abc" no es un número
Nota 1: 11
  ✘ La nota tiene que estar entre 0 y 10
Nota 1: 7
Nota 2: -1
  ✘ La nota tiene que estar entre 0 y 10
Nota 2: 8
Nota 3: 9
Media: 8,00
```

## Pistas

<details>
<summary>Pista 1</summary>

Es el mismo patrón que `leerEntero` del ejemplo [T15_03](../../../teoria/15-excepciones/ejemplos/T15_03_LeerDatosSeguro.java): un `while (!valida)` con el `try` dentro.

</details>

<details>
<summary>Pista 2</summary>

Si `parseInt` falla, el `catch` muestra el error y el bucle vuelve a preguntar. Si no falla, compruebas el rango con un `if`.

</details>

## Cómo ejecutarlo

```bash
java Ej15_02_LectorRobusto.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-lector-robusto/SOLUCION.md).
