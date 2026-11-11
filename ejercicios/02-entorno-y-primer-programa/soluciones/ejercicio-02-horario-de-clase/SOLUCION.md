# Solución · Ejercicio 02 · Horario de clase

[⬅️ Enunciado](../../ejercicio-02-horario-de-clase/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Escribe primero cada línea de la salida y después "pégalas" en un solo texto poniendo `\n` donde había un salto de línea. Luego sustituye los caracteres especiales:

| En la salida | En el código |
|---|---|
| Salto de línea | `\n` |
| Tabulación | `\t` |
| `"` | `\"` |
| `\` | `\\` |

## Código explicado

**Bloque 1:**

```java
System.out.println("HORARIO DEL LUNES\nHora\tAsignatura\tAula\n08:00\tMatemáticas\tA-12\n09:00\tLengua\t\tA-12\n10:00\tProgramación\tLAB-3");
```

Las tabulaciones saltan a la siguiente **posición fija** (normalmente cada 8 caracteres). "Lengua" tiene 6 letras: con un solo `\t` saltaría a la columna 16, pero "Asignatura" ocupa hasta la 18 y "Aula" empieza en la 24. Con dos `\t` llega a la 24 y queda alineado.

**Bloque 2:**

```java
System.out.println("\nRecuerda: \"Sin código no hay recreo\"");
```

El `\n` inicial produce la línea en blanco (el `println` anterior ya había saltado de línea, y este añade otra).

**Bloque 3:**

```java
System.out.println("Apuntes en: C:\\Clase\\Programacion\\Tema02");
```

Cada `\\` se muestra como **una** barra.

## Errores comunes

- Escribir `C:\Clase\...` con una sola barra: `\C` no es una secuencia válida y da error de compilación (`illegal escape character`).
- Escribir `\T` en lugar de `\t`: las secuencias distinguen mayúsculas.
- Usar `/n` (barra normal) en lugar de `\n`: se mostraría literalmente `/n`.

## Otras formas de resolverlo

Sin la condición de "un solo `println`", lo más legible sería usar un `println` por línea, o un **bloque de texto** (`"""`). Este ejercicio fuerza las secuencias para que las practiques.

## Código completo

📄 [Sol02_02_HorarioDeClase.java](Sol02_02_HorarioDeClase.java)
