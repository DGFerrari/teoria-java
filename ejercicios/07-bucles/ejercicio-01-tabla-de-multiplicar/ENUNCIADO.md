# Ejercicio 01 · Tabla de multiplicar

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** `for`, usar la variable del bucle en cálculos, `printf`

## Enunciado

Completa [`Ej07_01_TablaDeMultiplicar.java`](Ej07_01_TablaDeMultiplicar.java) para que pida un número y muestre su tabla de multiplicar del 1 al 10, alineada.

## Salida esperada

```
¿Qué tabla quieres ver? 7
=== Tabla del 7 ===
 7 x  1 =  7
 7 x  2 = 14
 7 x  3 = 21
 7 x  4 = 28
 7 x  5 = 35
 7 x  6 = 42
 7 x  7 = 49
 7 x  8 = 56
 7 x  9 = 63
 7 x 10 = 70
```

## Pistas

<details>
<summary>Pista 1</summary>

Sabes exactamente cuántas vueltas hay (10), así que el bucle adecuado es `for (int i = 1; i <= 10; i++)`.

</details>

<details>
<summary>Pista 2</summary>

Para alinear, usa ancho 2 en los números: `System.out.printf("%2d x %2d = %2d%n", ...)`.

</details>

## Cómo ejecutarlo

```bash
java Ej07_01_TablaDeMultiplicar.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-tabla-de-multiplicar/SOLUCION.md).
