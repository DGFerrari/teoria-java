# Ejercicio 04 · Pila genérica

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** implementar una estructura de datos genérica sobre una `List<T>`, usarla con `Character`, `String` y `Double`, excepciones propias (tema 15), `switch` moderno

## Enunciado

En el tema 16 usaste `ArrayDeque` como pila. Ahora vas a programar **tu propia** pila genérica en [`Ej17_04_PilaGenerica.java`](Ej17_04_PilaGenerica.java) y a usarla en dos problemas clásicos.

**1. `Pila<T>`**, guardando los elementos en una `List<T>` cuyo **final** es la cima:

| Método | Qué hace |
|---|---|
| `apilar(e)` | Pone `e` en la cima |
| `desapilar()` | Quita y devuelve la cima. Si está vacía, lanza `PilaVaciaException` |
| `cima()` | Devuelve la cima sin quitarla. Si está vacía, lanza `PilaVaciaException` |
| `estaVacia()`, `tamanio()` | |
| `toString()` | `[uno, dos, tres ← cima]`, o `[]` si está vacía |

**2. `alReves(texto)`** con una `Pila<Character>`: apila todas las letras y las desapila.

**3. `evaluarRPN(expresion)`** con una `Pila<Double>`. En la **notación polaca inversa** el operador va **después** de sus operandos: `3 4 +` significa `3 + 4`. No necesita paréntesis:

| Expresión normal | En polaca inversa |
|---|---|
| `(3 + 4) * 2` | `3 4 + 2 *` |
| `5 + (1 + 2) * 4 - 3` | `5 1 2 + 4 * + 3 -` |

Algoritmo: recorre los elementos; si es un número, **apílalo**; si es un operador, **desapila dos**, opera y **apila el resultado**. Al terminar, en la pila debe quedar exactamente un número: el resultado.

## Salida esperada

```
Pila: [uno, dos, tres ← cima] (3 elementos)
Desapilo: tres · cima ahora: dos
"genéricos" al revés: sociréneg
3 4 + 2 * = 14.0
5 1 2 + 4 * + 3 - = 14.0
2 3 4 → ✘ Expresión incompleta: sobran números
1 + → ✘ Faltan números para operar
4 0 / → ✘ División por cero
```

## Pistas

<details>
<summary>Pista 1</summary>

¿Por qué una `List<T>` y no un array `T[]`? Porque `new T[10]` no compila (borrado de tipos, sección 8 de la teoría).

</details>

<details>
<summary>Pista 2</summary>

Al desapilar para operar, el primero que sale es el operando de la **derecha**:

```java
double derecha = pila.desapilar();
double izquierda = pila.desapilar();
pila.apilar(operar(izquierda, elemento, derecha));
```

Con `-` y `/` el orden importa: `8 2 -` es `8 - 2`, no `2 - 8`.

</details>

<details>
<summary>Pista 3</summary>

`PilaVaciaException` hereda de `RuntimeException`, igual que `IllegalArgumentException`, pero no hay relación entre ellas: el orden de sus `catch` no importa. En cambio, `NumberFormatException` (de `parseDouble`) **sí** es una `IllegalArgumentException`.

</details>

## Cómo ejecutarlo

```bash
java Ej17_04_PilaGenerica.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-pila-generica/SOLUCION.md).
