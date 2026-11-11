# Ejercicio 01 · Diario personal

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** `Path`, `Files.exists`, `Files.writeString` con `CREATE` y `APPEND`, `Files.readString`, `Files.readAllLines`, `throws IOException`

## Enunciado

Programa un diario que guarda cada entrada en una línea de `diario.txt`. Completa [`Ej20_01_DiarioPersonal.java`](Ej20_01_DiarioPersonal.java):

1. `anotar(diario, fecha, texto)` añade **al final** del fichero la línea `fecha · texto`. Si el fichero no existe todavía, lo crea.
2. `buscar(diario, palabra)` devuelve las líneas que contienen esa palabra.
3. En el `main`:
   - Comprueba si el diario existe (al empezar, no).
   - Anota estas tres entradas:

     | Fecha | Texto |
     |---|---|
     | `2026-11-01` | `Empiezo el tema de ficheros` |
     | `2026-11-02` | `Hoy he aprendido a usar Files.readString` |
     | `2026-11-03` | `Mi programa en Java ya guarda datos` |

   - Muestra el fichero completo, cuántas entradas tiene, la última y las búsquedas.

> El programa trabaja en una **carpeta temporal** que se borra al final (está hecho en el `finally`). Así puedes ejecutarlo tantas veces como quieras y siempre empieza sin diario.

## Salida esperada

```
¿Existe diario.txt al empezar? false
=== Contenido de diario.txt ===
2026-11-01 · Empiezo el tema de ficheros
2026-11-02 · Hoy he aprendido a usar Files.readString
2026-11-03 · Mi programa en Java ya guarda datos
Entradas: 3
Última: 2026-11-03 · Mi programa en Java ya guarda datos
Con la palabra "Files": [2026-11-02 · Hoy he aprendido a usar Files.readString]
Con la palabra "Python": []
```

## Pistas

<details>
<summary>Pista 1</summary>

```java
Files.writeString(diario, fecha + " · " + texto + "\n",
        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
```

Solo con `APPEND`, la primera llamada fallaría con `NoSuchFileException` porque el fichero aún no existe.

</details>

<details>
<summary>Pista 2</summary>

`Files.readString` devuelve el texto **con** los saltos de línea: usa `print`, no `println`, para no dejar una línea en blanco al final. `Files.readAllLines` devuelve las líneas **sin** los saltos.

</details>

## Cómo ejecutarlo

```bash
java Ej20_01_DiarioPersonal.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-diario-personal/SOLUCION.md).
