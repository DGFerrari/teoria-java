# Solución · Ejercicio 04 · Detective de tipos

[⬅️ Enunciado](../../ejercicio-04-detective-de-tipos/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Resumen

| Caso | Salida original | Causa | Arreglo |
|---|---|---|---|
| A | `-1141367296` | Desbordamiento de `int` | `long` + literal `100L` |
| B | `7` | División entera | `double` + dividir entre `3.0` |
| C | `110` | `char + int` da `int` | `(char) (letra + 1)` |
| D | `2517` | `String + String` concatena | `Integer.parseInt` |
| E | `19` | `(int)` corta | `Math.round` |

## Caso A · Desbordamiento

```java
long segundosSiglo = 100L * 365 * 24 * 60 * 60;   // 3153600000
```

El resultado real (3 153 600 000) supera el máximo de `int` (2 147 483 647), así que "da la vuelta" y sale negativo.

Si solo cambias la variable (`long segundosSiglo = 100 * 365 * ...`), **sigue fallando**: Java calcula primero la multiplicación con `int` (y desborda), y después guarda el resultado erróneo en el `long`. Con `100L`, la primera multiplicación ya es `long` y todas las siguientes también.

## Caso B · División entera

```java
double media = suma / 3.0;   // 23 / 3.0 = 7.666666666666667
```

Hay dos errores encadenados: `suma / 3` es `int / int` (da `7`), y aunque diera `7.66`, la variable `int` no podría guardarlo. Cambiar solo el tipo de la variable no basta: `double media = suma / 3;` guarda `7.0`.

## Caso C · char como número

```java
System.out.println("C) Letra siguiente a " + letra + ": " + (char) (letra + 1));
```

Un `char` es un número por dentro (`'m'` = 109). Al sumarle `1`, Java lo convierte en `int` (110). El casting `(char)` lo vuelve a convertir en carácter: 110 → `'n'`.

Ojo: `(char) letra + 1` convertiría solo `letra` (que ya es `char`) y después sumaría, dando otra vez `110`.

## Caso D · Texto que parece número

```java
int numeroA = Integer.parseInt(textoA);
int numeroB = Integer.parseInt(textoB);
System.out.println("D) " + numeroA + " + " + numeroB + " = " + (numeroA + numeroB));
```

`"25"` no es el número 25: es un texto con los caracteres `'2'` y `'5'`. Al "sumar" dos textos se pegan. Este caso es muy habitual cuando los datos vienen de un formulario, un fichero o el teclado.

## Caso E · Cortar no es redondear

```java
long redondeado = Math.round(precio);   // 20
```

`(int) 19.99` descarta los decimales y da `19`. `Math.round` busca el entero más cercano. Como devuelve `long`, la variable tiene que ser `long` (o hacer `(int) Math.round(precio)`).

## Código completo

📄 [Sol03_04_DetectiveDeTipos.java](Sol03_04_DetectiveDeTipos.java)
