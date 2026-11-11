# Ejercicio 05 · Hucha con objetivo

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** secuencia, decisión, repetición, contadores, acumuladores, condición compuesta (`&&`), traza

## Enunciado

Quieres ahorrar para comprarte unos auriculares. Las reglas son:

- El **objetivo** es juntar **100 euros**.
- La primera semana metes **10 euros** en la hucha, y cada semana metes **5 euros más** que la anterior (10, 15, 20, 25...).
- Cada **4 semanas** (semana 4, 8, 12...) te das un capricho y **sacas 8 euros** de la hucha.
- Como mucho, ahorrarás durante **12 semanas**.
- Dejas de ahorrar **en cuanto llegas al objetivo** o **se acaban las semanas**, lo que pase primero.

Al terminar, el programa debe decir:
- si has conseguido el objetivo: `Objetivo cumplido en X semanas`,
- si no: `No has llegado. Te faltan Y euros`.

Tareas:

1. Escribe el **pseudocódigo** completo.
2. Haz la **traza** de las primeras semanas para saber qué esperar.
3. Completa [`Ej01_05_HuchaConObjetivo.java`](Ej01_05_HuchaConObjetivo.java).

> 📏 Recuerda la regla del repositorio: **no se puede usar `break`** para salir del bucle. La condición del `while` debe incluir las dos formas de terminar.

## Salida esperada (objetivo = 100)

```
Semana 1: meto 10 -> hucha = 10
Semana 2: meto 15 -> hucha = 25
Semana 3: meto 20 -> hucha = 45
Semana 4: meto 25 -> capricho (-8) -> hucha = 62
Semana 5: meto 30 -> hucha = 92
Semana 6: meto 35 -> hucha = 127
Objetivo cumplido en 6 semanas
```

## Más pruebas

| `objetivo` | Resultado esperado |
|---|---|
| 100 | `Objetivo cumplido en 6 semanas` (hucha = 127) |
| 300 | `Objetivo cumplido en 10 semanas` (hucha = 309) |
| 500 | `No has llegado. Te faltan 74 euros` (hucha = 426) |

## Pistas

<details>
<summary>Pista 1</summary>

Necesitas estas variables: `hucha` (acumulador), `semana` (contador), `aportacion` (lo que metes esta semana) y las constantes del problema (`objetivo`, `maxSemanas`).

</details>

<details>
<summary>Pista 2</summary>

El bucle sigue **mientras** queden semanas **y** no hayas llegado al objetivo:

```
MIENTRAS semana <= maxSemanas Y hucha < objetivo HACER
```

En Java, "Y" se escribe `&&`.

</details>

<details>
<summary>Pista 3</summary>

Para saber si una semana es múltiplo de 4, usa el **resto** de la división: `semana % 4 == 0` (lo usaste en el ejemplo `T01_05` de la teoría).

</details>

<details>
<summary>Pista 4</summary>

Cuando el bucle termina, `semana` vale **una más** que la última semana en la que ahorraste (porque se suma 1 al final de cada vuelta). Tenlo en cuenta al mostrar `Objetivo cumplido en X semanas`.

</details>

## Cómo ejecutarlo

```bash
java Ej01_05_HuchaConObjetivo.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-hucha-con-objetivo/SOLUCION.md).
