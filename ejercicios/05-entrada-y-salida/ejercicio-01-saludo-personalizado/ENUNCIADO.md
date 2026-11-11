# Ejercicio 01 · Saludo personalizado

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** `Scanner`, `nextLine()`, `nextInt()`, `printf`

## Enunciado

Completa [`Ej05_01_SaludoPersonalizado.java`](Ej05_01_SaludoPersonalizado.java) para que el programa:

1. Pregunte el **nombre** y la **edad** del usuario.
2. Le salude por su nombre.
3. Le diga cuántos años tendrá **dentro de 10 años**.
4. Le diga cuántos **días** ha vivido aproximadamente (edad × 365), con separador de miles.

## Salida esperada

(Lo que escribe el usuario: `Ana` y `15`.)

```
¿Cómo te llamas? Ana
¿Cuántos años tienes? 15
Hola, Ana.
Dentro de 10 años tendrás 25 años.
Has vivido aproximadamente 5.475 días.
```

## Pistas

<details>
<summary>Pista 1</summary>

Lee primero el nombre con `nextLine()` y después la edad con `nextInt()`. En este orden no hay problema con el salto de línea pendiente.

</details>

<details>
<summary>Pista 2</summary>

El separador de miles se consigue con `%,d` en `printf`.

</details>

## Cómo ejecutarlo

```bash
java Ej05_01_SaludoPersonalizado.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-saludo-personalizado/SOLUCION.md).
