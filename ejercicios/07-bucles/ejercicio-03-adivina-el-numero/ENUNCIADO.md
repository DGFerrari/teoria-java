# Ejercicio 03 · Adivina el número

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** `while` con condición compuesta, bandera, contador, `Random`, condicionales

## Enunciado

El ordenador piensa un número del **1 al 100** y tú tienes **7 intentos** para adivinarlo. Completa [`Ej07_03_AdivinaElNumero.java`](Ej07_03_AdivinaElNumero.java):

1. Genera el número secreto con `Random`.
2. Mientras **queden intentos** y **no hayas acertado**:
   - Pide un número e indica cuántos intentos quedan.
   - Si está **fuera de rango** (menos de 1 o más de 100), avisa y **no cuentes** el intento.
   - Si no, cuenta el intento y di si el secreto es **mayor**, **menor** o si has **acertado**.
3. Al terminar, di si has ganado (y en cuántos intentos) o si has perdido (y cuál era el número).

> 📏 Sin `break`: el bucle debe terminar por su condición, usando una bandera `acertado`.

## Salida de ejemplo

```
He pensado un número del 1 al 100. Tienes 7 intentos.
Intento 1 de 7: 50
  El número es MENOR
Intento 2 de 7: 25
  El número es MAYOR
Intento 3 de 7: 150
  Fuera de rango (1-100). Este intento no cuenta.
Intento 3 de 7: 37
  ¡Correcto!
¡Has ganado en 3 intentos!
```

```
...
Intento 7 de 7: 64
  El número es MAYOR
Has perdido. El número era 71
```

## Pistas

<details>
<summary>Pista 1</summary>

La condición del bucle tiene las dos formas de terminar:

```java
while (intentos < MAX_INTENTOS && !acertado)
```

</details>

<details>
<summary>Pista 2</summary>

El número del intento que se muestra es `intentos + 1` (el que vas a gastar). Como los intentos fuera de rango no suman, el número se repite, que es lo que se ve en la salida de ejemplo.

</details>

<details>
<summary>Pista 3</summary>

Mientras pruebas, usa `new Random(1)` para que el número secreto sea siempre el mismo. Cuando funcione, quita la semilla.

</details>

## Cómo ejecutarlo

```bash
java Ej07_03_AdivinaElNumero.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-adivina-el-numero/SOLUCION.md).
