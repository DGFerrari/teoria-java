# Ejercicio 01 · Ficha de personaje

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** declarar e inicializar variables, elegir el tipo adecuado

## Enunciado

Estás creando un videojuego de rol. Completa [`Ej03_01_FichaDePersonaje.java`](Ej03_01_FichaDePersonaje.java) declarando **una variable por dato**, con el **tipo más adecuado** para cada uno, y muestra la ficha.

| Dato | Valor |
|---|---|
| Nombre | Aria |
| Clase (inicial) | M (de Maga) |
| Nivel | 12 |
| Puntos de vida | 87.5 |
| Oro acumulado | 3 500 000 000 |
| ¿Está envenenada? | no |

## Salida esperada

```
=== FICHA DE PERSONAJE ===
Nombre: Aria
Clase: M
Nivel: 12
Vida: 87.5
Oro: 3500000000
Envenenada: false
```

## Pistas

<details>
<summary>Pista 1</summary>

Tipos posibles: `String`, `char`, `int`, `double`, `long`, `boolean`. Hay uno para cada dato.

</details>

<details>
<summary>Pista 2</summary>

3 500 000 000 es mayor que el máximo de un `int` (unos 2 100 millones). Necesitas `long` y el sufijo `L` en el literal.

</details>

## Cómo ejecutarlo

```bash
java Ej03_01_FichaDePersonaje.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-ficha-de-personaje/SOLUCION.md).
