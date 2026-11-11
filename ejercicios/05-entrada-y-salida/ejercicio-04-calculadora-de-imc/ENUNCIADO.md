# Ejercicio 04 · Calculadora de IMC

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** leer `String`, `double` e `int`; `Math.pow`; división decimal; `boolean`; `printf` con decimales

## Enunciado

El **Índice de Masa Corporal** (IMC) se calcula así:

```
IMC = peso (kg) / altura (m)²
```

Se considera rango saludable un IMC **entre 18.5 y 24.9** (ambos incluidos).

Completa [`Ej05_04_CalculadoraDeImc.java`](Ej05_04_CalculadoraDeImc.java) para que:

1. Pida el **nombre**, el **peso** en kg (con decimales) y la **altura en centímetros** (entero).
2. Convierta la altura a **metros**.
3. Calcule el **IMC** con `Math.pow`.
4. Calcule el **rango de peso saludable** para esa altura: de `18.5 × altura²` a `24.9 × altura²`.
5. Diga con un `boolean` si el IMC está en el rango saludable.
6. Muestre todo con `printf`: el IMC con **1 decimal** y los pesos con **1 decimal**.

> Este programa es un ejercicio de programación, no una herramienta médica.

## Salida esperada

(Lo que escribe el usuario: `Carlos`, `72,5`, `178`.)

```
Nombre: Carlos
Peso (kg): 72,5
Altura (cm): 178

=== Informe de Carlos ===
Altura: 1,78 m
IMC: 22,9
Peso saludable para tu altura: de 58,6 a 78,9 kg
¿IMC en rango saludable? true
```

Prueba también con `Lucía`, `50`, `170` → IMC `17,3`, rango de `53,5` a `72,0` kg, `false`.

## Pistas

<details>
<summary>Pista 1</summary>

`alturaCm / 100` es una división **entera** (178 / 100 = 1). Divide entre `100.0`.

</details>

<details>
<summary>Pista 2</summary>

`Math.pow(alturaM, 2)` es la altura al cuadrado. Guárdala en una variable: la usarás tres veces.

</details>

<details>
<summary>Pista 3</summary>

Si al escribir `72,5` te da `InputMismatchException`, tu sistema está en inglés: escribe `72.5` (sección 8 de la teoría).

</details>

## Cómo ejecutarlo

```bash
java Ej05_04_CalculadoraDeImc.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-calculadora-de-imc/SOLUCION.md).
