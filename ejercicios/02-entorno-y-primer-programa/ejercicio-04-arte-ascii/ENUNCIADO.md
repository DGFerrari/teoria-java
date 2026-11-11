# Ejercicio 04 · Arte ASCII

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** `print` y `println`, secuencias de escape, bloques de texto

## Enunciado

Vas a dibujar con caracteres. Completa [`Ej02_04_ArteAscii.java`](Ej02_04_ArteAscii.java) en tres partes:

**Parte A · El gato, con `println` y escapes.** Un `println` por línea. Fíjate en que el dibujo tiene barras invertidas `\` y comillas `"`.

```
 /\_/\
( o.o )
 > ^ <
  "Miau"
```

**Parte B · La casa, con un bloque de texto (`"""`).** Un único `println`.

```
    /\
   /  \
  /____\
  | [] |
  |____|
```

**Parte C · La valla, con `print`.** Usa `print` para dibujar `|-` **seis veces en la misma línea** y termina con `|` y un salto de línea.

```
|-|-|-|-|-|-|
```

## Pistas

<details>
<summary>Pista 1</summary>

En la parte A, cada `\` del dibujo se escribe `\\` en el código y cada `"` se escribe `\"`. La primera línea queda así:

```java
System.out.println(" /\\_/\\");
```

</details>

<details>
<summary>Pista 2</summary>

Dentro de un bloque de texto, las comillas simples no hace falta escaparlas, pero **las barras invertidas sí**: `\` sigue siendo el carácter de escape.

</details>

<details>
<summary>Pista 3</summary>

En la parte C, `print("|-")` seis veces y luego `println("|")`. El `println` final es el que salta de línea.

</details>

## Cómo ejecutarlo

```bash
java Ej02_04_ArteAscii.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-arte-ascii/SOLUCION.md).
