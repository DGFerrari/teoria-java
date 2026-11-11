# Solución · Ejercicio 01 · Signo y paridad

[⬅️ Enunciado](../../ejercicio-01-signo-y-paridad/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Son dos preguntas **independientes**, así que van en dos estructuras separadas:

| Pregunta | Casos | Estructura |
|---|---|---|
| ¿Qué signo tiene? | positivo / negativo / cero | `if` – `else if` – `else` |
| ¿Es par? | par / impar | `if` – `else` |

## Código explicado

```java
if (numero > 0) {
    System.out.println(numero + " es positivo");
} else if (numero < 0) {
    System.out.println(numero + " es negativo");
} else {
    System.out.println(numero + " es cero");
}
```

El `else` final no necesita condición: si no es mayor ni menor que 0, **tiene que ser** 0.

```java
if (numero % 2 == 0) {
    System.out.println(numero + " es par");
} else {
    System.out.println(numero + " es impar");
}
```

## Errores comunes

- `if (numero % 2 == 1)` para los impares: con `-7` da `-1` y diría que es par.
- Unir las dos preguntas en una misma cadena `else if`: solo se mostraría una de las dos respuestas.
- Olvidar el caso del 0: con solo `if (numero > 0) ... else ...`, el 0 saldría como negativo.

## Código completo

📄 [Sol06_01_SignoYParidad.java](Sol06_01_SignoYParidad.java)
