# Ejercicio 04 · Laboratorio de recursividad

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** métodos recursivos, caso base, caso recursivo, recursividad con `String` y con arrays

## Enunciado

En [`Ej10_04_LaboratorioDeRecursividad.java`](Ej10_04_LaboratorioDeRecursividad.java) hay ocho métodos que tienes que escribir **de forma recursiva** (sin bucles). El `main` ya los prueba con un método `comprobar` que muestra ✅ si el resultado es el esperado y ❌ si no.

| Método | Definición recursiva |
|---|---|
| `factorial(n)` | `0! = 1` · `n! = n × (n−1)!` |
| `potencia(b, e)` | `b⁰ = 1` · `bᵉ = b × bᵉ⁻¹` |
| `sumarCifras(n)` | Si `n < 10`, es `n` · si no, última cifra + `sumarCifras(n / 10)` |
| `contarCifras(n)` | Si `n < 10`, es 1 · si no, 1 + `contarCifras(n / 10)` |
| `mcd(a, b)` | Algoritmo de Euclides: si `b == 0`, es `a` · si no, `mcd(b, a % b)` |
| `invertir(texto)` | Vacío o 1 carácter → el mismo · si no, último carácter + `invertir(resto)` |
| `esPalindromo(texto)` | 0 o 1 caracteres → `true` · si el primero y el último son distintos → `false` · si no, `esPalindromo(texto sin el primero ni el último)` |
| `sumarDesde(datos, i)` | Si `i` llega al final del array → 0 · si no, `datos[i] + sumarDesde(datos, i + 1)` |

## Salida esperada (cuando todo esté bien)

```
✅ factorial(0) = 1
✅ factorial(6) = 720
✅ potencia(3, 4) = 81
✅ potencia(5, 0) = 1
✅ sumarCifras(2025) = 9
✅ contarCifras(98765) = 5
✅ contarCifras(7) = 1
✅ mcd(48, 18) = 6
✅ mcd(17, 5) = 1
✅ invertir("recursivo") = ovisrucer
✅ esPalindromo("reconocer") = true
✅ esPalindromo("java") = false
✅ sumarDesde({3, 1, 4, 1, 5}, 0) = 14
Superadas: 13 de 13
```

## Pistas

<details>
<summary>Pista 1</summary>

Antes de escribir cada método, responde dos preguntas:

1. ¿Cuál es el caso **más pequeño**, que puedo resolver sin recursividad? (caso base)
2. ¿Cómo expreso el problema usando una versión **más pequeña** de sí mismo? (caso recursivo)

</details>

<details>
<summary>Pista 2</summary>

Para `invertir` y `esPalindromo`, los trozos del texto se obtienen con `substring`:

- Todo menos el último: `texto.substring(0, texto.length() - 1)`
- Todo menos el primero y el último: `texto.substring(1, texto.length() - 1)`

</details>

<details>
<summary>Pista 3</summary>

Traza `mcd(48, 18)`: `mcd(18, 48 % 18 = 12)` → `mcd(12, 6)` → `mcd(6, 0)` → **6**.

</details>

## Cómo ejecutarlo

```bash
java Ej10_04_LaboratorioDeRecursividad.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-laboratorio-de-recursividad/SOLUCION.md).
