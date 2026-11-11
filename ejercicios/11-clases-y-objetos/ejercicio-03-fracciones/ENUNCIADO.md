# Ejercicio 03 · Fracciones

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** constructor que valida y normaliza, métodos que reciben otro objeto y devuelven uno **nuevo**, `toString`

## Enunciado

Completa la clase `Fraccion` de [`Ej11_03_Fracciones.java`](Ej11_03_Fracciones.java). Una fracción tiene **numerador** y **denominador** (que supondremos distinto de 0).

1. **Constructor**: guarda la fracción **simplificada** y con el signo en el numerador:
   - `new Fraccion(6, 8)` → `3/4`
   - `new Fraccion(4, -2)` → `-2/1`
2. `sumar(otra)`, `restar(otra)`, `multiplicar(otra)` y `dividir(otra)`: devuelven una **fracción nueva**; ni `this` ni `otra` cambian.
3. `valorDecimal()`: el valor como `double`.
4. `esIgualA(otra)`: `true` si representan el mismo número.
5. `toString()`: `"3/4"`, o solo el numerador si el denominador es 1 (`"-2"`).

El método `mcd` (máximo común divisor) ya está hecho.

| Operación | Fórmula |
|---|---|
| a/b + c/d | (a·d + c·b) / (b·d) |
| a/b − c/d | (a·d − c·b) / (b·d) |
| a/b × c/d | (a·c) / (b·d) |
| a/b ÷ c/d | (a·d) / (b·c) |

## Salida esperada

```
a = 1/2 | b = 3/4
a + b = 5/4
a - b = -1/4
a * b = 3/8
a / b = 2/3
6/8 se guarda como 3/4
4/-2 se guarda como -2
b vale 0.75
¿3/4 es igual a 6/8? true
¿a sigue valiendo 1/2? 1/2
```

## Pistas

<details>
<summary>Pista 1</summary>

En el constructor: calcula `int divisor = mcd(Math.abs(numerador), Math.abs(denominador));` y divide los dos entre él. Si el denominador queda negativo, cambia el signo de los dos.

</details>

<details>
<summary>Pista 2</summary>

Como el constructor ya simplifica, cada operación solo tiene que aplicar la fórmula y crear la fracción resultante:

```java
Fraccion sumar(Fraccion otra) {
    return new Fraccion(numerador * otra.denominador + otra.numerador * denominador,
                        denominador * otra.denominador);
}
```

</details>

<details>
<summary>Pista 3</summary>

Como las fracciones están siempre simplificadas y con el signo arriba, dos fracciones son iguales si tienen el **mismo numerador y el mismo denominador**.

</details>

## Cómo ejecutarlo

```bash
java Ej11_03_Fracciones.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-fracciones/SOLUCION.md).
