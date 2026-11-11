# Ejercicio 01 · Preséntate

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** estructura de un programa, `System.out.println`, compilar y ejecutar

## Enunciado

Completa [`Ej02_01_Presentate.java`](Ej02_01_Presentate.java) para que muestre una pequeña ficha sobre ti. Después, ejecútalo **de las dos formas** que has visto en la teoría:

1. En un paso: `java Ej02_01_Presentate.java`
2. En dos pasos: `javac Ej02_01_Presentate.java` y luego `java Ej02_01_Presentate`

Tras el segundo método, comprueba que en la carpeta ha aparecido un archivo `Ej02_01_Presentate.class`. Bórralo al terminar (es el bytecode y no hace falta guardarlo).

## Salida esperada (con tus datos)

```
==============================
  Hola, me llamo Ana
==============================
Edad: 15 años
Ciudad: Valencia
Lo que más me gusta: la música
Quiero aprender Java para: hacer videojuegos
==============================
```

## Pistas

<details>
<summary>Pista 1</summary>

Cada línea de la salida es un `System.out.println("...");`. Las líneas de `=` también.

</details>

<details>
<summary>Pista 2</summary>

Si al ejecutar en dos pasos escribes `java Ej02_01_Presentate.class`, dará error. Al ejecutar un `.class` se pone **solo el nombre de la clase**, sin extensión.

</details>

## Cómo ejecutarlo

```bash
java Ej02_01_Presentate.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-presentate/SOLUCION.md).
