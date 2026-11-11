# Ejercicio 02 · Intercambio de vasos

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** asignación, copiar valores entre variables, variable auxiliar

## Enunciado

Tienes dos vasos: uno con **zumo** y otro con **leche**. Quieres intercambiar su contenido. En la vida real necesitarías un **tercer vaso** vacío; en programación pasa lo mismo.

Completa [`Ej03_02_IntercambioDeVasos.java`](Ej03_02_IntercambioDeVasos.java):

1. **Parte A:** intercambia el contenido de `vasoA` y `vasoB` (dos `String`).
2. **Parte B:** con tres números `x = 1`, `y = 2`, `z = 3`, haz una **rotación**: que `x` acabe valiendo lo que tenía `y`, `y` lo que tenía `z`, y `z` lo que tenía `x`.

No vale volver a escribir los valores a mano (`vasoA = "leche";`): hay que **mover** los valores entre variables.

## Salida esperada

```
Antes:   vasoA = zumo | vasoB = leche
Después: vasoA = leche | vasoB = zumo
Antes:   x = 1 | y = 2 | z = 3
Después: x = 2 | y = 3 | z = 1
```

## Pistas

<details>
<summary>Pista 1</summary>

¿Qué pasa si haces directamente `vasoA = vasoB;`? El zumo se pierde para siempre, porque una variable solo guarda un valor. Antes de sobrescribir `vasoA`, guarda su contenido en otra variable.

</details>

<details>
<summary>Pista 2</summary>

Los tres pasos del intercambio:

```
auxiliar ← vasoA
vasoA ← vasoB
vasoB ← auxiliar
```

</details>

<details>
<summary>Pista 3</summary>

La rotación de tres también necesita **una sola** variable auxiliar. Guarda `x`, y luego ve "subiendo" los valores.

</details>

## Cómo ejecutarlo

```bash
java Ej03_02_IntercambioDeVasos.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-intercambio-de-vasos/SOLUCION.md).
