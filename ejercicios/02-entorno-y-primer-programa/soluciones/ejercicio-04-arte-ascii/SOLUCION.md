# Solución · Ejercicio 04 · Arte ASCII

[⬅️ Enunciado](../../ejercicio-04-arte-ascii/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Antes de escribir, recorre cada dibujo buscando caracteres "peligrosos" dentro de un texto de Java: `\` y `"`. Son los únicos que hay que cambiar.

## Parte A · Escapes

| Dibujo | Código |
|---|---|
| ` /\_/\` | `" /\\_/\\"` |
| `( o.o )` | `"( o.o )"` |
| ` > ^ <` | `" > ^ <"` |
| `  "Miau"` | `"  \"Miau\""` |

En la última línea hay **tres** comillas al final del código: `\"` (la comilla que se ve) y `"` (la que cierra el texto).

## Parte B · Bloque de texto

```java
System.out.println("""
            /\\
           /  \\
          /____\\
          | [] |
          |____|
        """);
```

- Tras las tres comillas de apertura **hay que saltar de línea**: no se puede escribir texto en esa misma línea.
- Java quita la sangría común. Aquí manda la línea de las comillas de cierre (8 espacios), por eso el dibujo conserva sus espacios iniciales.
- Las barras invertidas **siguen necesitando** `\\`. Lo que ya no hace falta escapar son las comillas sueltas ni los saltos de línea.
- El bloque termina con un salto de línea y `println` añade otro, así que tras la casa queda una línea en blanco.

## Parte C · print

```java
System.out.print("|-");
System.out.print("|-");
System.out.print("|-");
System.out.print("|-");
System.out.print("|-");
System.out.print("|-");
System.out.println("|");
```

Seis instrucciones casi iguales... ¿no habría una forma mejor? Sí: un **bucle**. Lo verás en el [tema 07](../../../../teoria/07-bucles/README.md); de momento, fíjate en que `print` se queda en la misma línea y `println` la termina.

## Errores comunes

- `" /\_/\"`: `\_` no es un escape válido (error de compilación) y `\"` al final se come la comilla de cierre.
- Escribir texto en la misma línea que las `"""` de apertura: error de compilación.
- Terminar la parte C con `print("|")`: la siguiente salida empezaría en la misma línea.

## Código completo

📄 [Sol02_04_ArteAscii.java](Sol02_04_ArteAscii.java)
