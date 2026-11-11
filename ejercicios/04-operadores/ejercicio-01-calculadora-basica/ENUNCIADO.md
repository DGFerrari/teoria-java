# Ejercicio 01 · Calculadora básica

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** `+`, `-`, `*`, `/`, `%`, división con decimales

## Enunciado

Completa [`Ej04_01_CalculadoraBasica.java`](Ej04_01_CalculadoraBasica.java) para que, con `a = 23` y `b = 4`, calcule y muestre las seis operaciones de la salida esperada. Al final, comprueba que **cociente × divisor + resto = dividendo**.

## Salida esperada

```
a = 23, b = 4
Suma: 27
Resta: 19
Multiplicación: 92
Cociente (división entera): 5
Resto: 3
División con decimales: 5.75
Comprobación: 5 * 4 + 3 = 23
```

## Pistas

<details>
<summary>Pista 1</summary>

Guarda cada resultado en su propia variable (`int suma = a + b;`) antes de mostrarlo. Así el código queda más limpio.

</details>

<details>
<summary>Pista 2</summary>

Para la división con decimales, convierte uno de los dos a `double`: `(double) a / b`.

</details>

## Cómo ejecutarlo

```bash
java Ej04_01_CalculadoraBasica.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-calculadora-basica/SOLUCION.md).
