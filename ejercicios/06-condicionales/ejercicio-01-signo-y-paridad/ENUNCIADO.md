# Ejercicio 01 · Signo y paridad

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** `if`, `else if`, `else`

## Enunciado

Completa [`Ej06_01_SignoYParidad.java`](Ej06_01_SignoYParidad.java) para que, dado un número entero que escribe el usuario, diga:

1. Si es **positivo**, **negativo** o **cero**.
2. Si es **par** o **impar**.

## Salida esperada

```
Escribe un número entero: -7
-7 es negativo
-7 es impar
```

Prueba también:

| Número | Signo | Paridad |
|---|---|---|
| 12 | positivo | par |
| 0 | cero | par |
| -4 | negativo | par |

## Pistas

<details>
<summary>Pista 1</summary>

El signo tiene **tres** casos excluyentes: usa `if` / `else if` / `else`. La paridad tiene **dos**: `if` / `else`.

</details>

<details>
<summary>Pista 2</summary>

Con negativos, `-7 % 2` da `-1`, no `1`. Por eso es más seguro preguntar si `numero % 2 == 0` (par) que si `numero % 2 == 1` (impar).

</details>

## Cómo ejecutarlo

```bash
java Ej06_01_SignoYParidad.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-signo-y-paridad/SOLUCION.md).
