# Ejercicio 05 · Informe de alumnos

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema (`split`, `substring`, `charAt`, mayúsculas/minúsculas, `replace`, `StringBuilder`, `String.format`) + arrays, bucles, conversiones y máximos

## Enunciado

Un instituto exporta los datos de sus alumnos en un texto con este formato, una línea por alumno:

```
nombre;apellidos;nota1,nota2,nota3
```

Los datos están escritos sin cuidado (mayúsculas y minúsculas mezcladas):

```java
String datos = """
        ana;garcía lópez;7.5,8,9
        LUIS;martín;5,4.5,6
        marta;Ruiz;9.5,10,9
        jorge;pérez sanz;3,4,5.5
        """;
```

Completa [`Ej09_05_InformeDeAlumnos.java`](Ej09_05_InformeDeAlumnos.java) para generar un **informe** en un `StringBuilder` y mostrarlo al final. Para cada alumno:

1. **Nombre** con la primera letra en mayúscula y el resto en minúscula: `LUIS` → `Luis`.
2. **Apellidos** con **cada palabra** capitalizada: `garcía lópez` → `García López`.
3. **Usuario**: primera letra del nombre + **primer** apellido, todo en minúsculas y **sin tildes**: `agarcia`.
4. **Media** de sus notas (las notas están separadas por comas y usan punto decimal).
5. **Estado**: `APROBADO` si la media es al menos 5, `SUSPENSO` si no.

Al final del informe: cuántos han aprobado y quién tiene la **mejor media**.

## Salida esperada

```
====================================================
 Nº  Alumno               Usuario     Media  Estado
====================================================
  1  Ana García López     agarcia      8,17  APROBADO
  2  Luis Martín          lmartin      5,17  APROBADO
  3  Marta Ruiz           mruiz        9,50  APROBADO
  4  Jorge Pérez Sanz     jperez       4,17  SUSPENSO
====================================================
Aprobados: 3 de 4
Mejor media: Marta Ruiz (9,50)
```

## Pistas

<details>
<summary>Pista 1</summary>

Primero divide el texto en líneas y cada línea en campos:

```java
String[] lineas = datos.strip().split("\n");
String[] campos = lineas[i].split(";");     // {"ana", "garcía lópez", "7.5,8,9"}
```

</details>

<details>
<summary>Pista 2</summary>

Para capitalizar los apellidos, divídelos por espacios, capitaliza cada palabra y vuelve a unirlas con un `StringBuilder` (o con `String.join`).

```java
String capitalizada = palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
```

</details>

<details>
<summary>Pista 3</summary>

Las notas usan **punto**, así que `Double.parseDouble` las entiende directamente, sin importar la configuración regional.

</details>

<details>
<summary>Pista 4</summary>

Formato de cada fila: `String.format("%3d  %-20s %-10s %6.2f  %s%n", ...)`.

</details>

## Cómo ejecutarlo

```bash
java Ej09_05_InformeDeAlumnos.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-informe-de-alumnos/SOLUCION.md).
