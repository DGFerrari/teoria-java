# Ejercicio 04 · Detective de tipos

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** desbordamiento, división entera, `char` como número, `parseInt`, casting y redondeo

## Enunciado

El archivo [`Ej03_04_DetectiveDeTipos.java`](Ej03_04_DetectiveDeTipos.java) **compila y se ejecuta**, pero sus cinco casos dan resultados **incorrectos**. Todos son errores lógicos provocados por los tipos de datos.

Para cada caso:

1. **Antes de ejecutar**, intenta adivinar qué va a mostrar.
2. Ejecuta y compara con el resultado esperado.
3. Escribe en un comentario **por qué** falla.
4. Arréglalo cambiando lo mínimo posible.

| Caso | Qué calcula | Resultado esperado |
|---|---|---|
| A | Segundos que tiene un siglo (100 años de 365 días) | `3153600000` |
| B | Media de tres notas: 7, 8 y 8 | `7.666666666666667` |
| C | Letra que va después de la `m` | `n` |
| D | Suma de dos números que llegan como texto: `"25"` y `"17"` | `42` |
| E | Precio de 19.99 redondeado al euro más cercano | `20` |

## Salida esperada (cuando esté arreglado)

```
A) Segundos en un siglo: 3153600000
B) Media de las notas: 7.666666666666667
C) Letra siguiente a m: n
D) 25 + 17 = 42
E) 19.99 redondeado: 20
```

## Pistas

<details>
<summary>Pista 1 (caso A)</summary>

El resultado es mayor que `Integer.MAX_VALUE`. Pero no basta con cambiar la variable a `long`: la multiplicación se sigue haciendo en `int`. Uno de los números tiene que ser `long` **desde el principio**.

</details>

<details>
<summary>Pista 2 (caso B)</summary>

Dos problemas: la variable `media` es `int`, y la división `suma / 3` es entera. Hay que arreglar los dos.

</details>

<details>
<summary>Pista 3 (caso C)</summary>

`letra + 1` es un `int`. Conviértelo a `char` con un casting... ¡con los paréntesis bien puestos!

</details>

<details>
<summary>Pista 4 (casos D y E)</summary>

- D: el `+` entre dos `String` las **une**. Convierte primero cada texto con `Integer.parseInt`.
- E: `(int)` corta, no redondea.

</details>

## Cómo ejecutarlo

```bash
java Ej03_04_DetectiveDeTipos.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-detective-de-tipos/SOLUCION.md).
