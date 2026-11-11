# Ejercicio 02 · Horario de clase

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** secuencias de escape `\n`, `\t`, `\"`, `\\`

## Enunciado

Completa [`Ej02_02_HorarioDeClase.java`](Ej02_02_HorarioDeClase.java) para mostrar exactamente esta salida. La condición es que **cada bloque se escriba con un único `println`**, usando secuencias de escape.

## Salida esperada

```
HORARIO DEL LUNES
Hora	Asignatura	Aula
08:00	Matemáticas	A-12
09:00	Lengua		A-12
10:00	Programación	LAB-3

Recuerda: "Sin código no hay recreo"
Apuntes en: C:\Clase\Programacion\Tema02
```

(Los huecos entre columnas son tabulaciones, no espacios.)

| Bloque | Líneas | Nº de `println` |
|---|---|---|
| 1 | El título y la tabla (5 líneas) | 1 |
| 2 | La línea en blanco y la frase entre comillas | 1 |
| 3 | La ruta de los apuntes | 1 |

## Pistas

<details>
<summary>Pista 1</summary>

Para pasar de línea dentro de un mismo texto usa `\n`. Para separar columnas, `\t`.

</details>

<details>
<summary>Pista 2</summary>

"Lengua" es más corto que las otras asignaturas. Para que "A-12" quede alineado con la columna "Aula" hace falta poner **dos** tabulaciones después de "Lengua".

</details>

<details>
<summary>Pista 3</summary>

Una línea en blanco al principio de un texto es simplemente un `\n` al principio: `"\nRecuerda: ..."`. Para las comillas usa `\"` y para cada barra de la ruta, `\\`.

</details>

## Cómo ejecutarlo

```bash
java Ej02_02_HorarioDeClase.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-horario-de-clase/SOLUCION.md).
