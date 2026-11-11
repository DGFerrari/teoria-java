# Ejercicio 01 · Receta en orden

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** algoritmo, secuencia, `System.out.println`

## Enunciado

Un compañero ha apuntado los pasos para **preparar una tostada con tomate**, pero los ha escrito desordenados:

```
- Untar el tomate sobre el pan
- Sacar el pan de la tostadora
- Echar un chorrito de aceite y una pizca de sal
- Cortar una rebanada de pan
- Rallar medio tomate
- Meter el pan en la tostadora y esperar
- Comer la tostada
```

1. Escribe el algoritmo en **pseudocódigo**, con los pasos en el orden correcto y entre `INICIO` y `FIN`.
2. Completa el archivo [`Ej01_01_RecetaEnOrden.java`](Ej01_01_RecetaEnOrden.java) para que muestre por pantalla el título de la receta y los pasos **numerados y en orden**.

## Salida esperada

```
=== Tostada con tomate ===
1. Cortar una rebanada de pan
2. ...
7. Comer la tostada
¡Buen provecho!
```

## Pistas

<details>
<summary>Pista 1</summary>

Pregúntate para cada paso: *¿qué necesito tener hecho antes de poder hacer esto?* No puedes sacar el pan de la tostadora sin haberlo metido antes.

</details>

<details>
<summary>Pista 2</summary>

Hay dos pasos que se pueden hacer en cualquier orden entre sí (rallar el tomate y tostar el pan). Cualquiera de los dos órdenes es válido, siempre que ambos estén antes de untar.

</details>

<details>
<summary>Pista 3</summary>

Cada paso es una instrucción `System.out.println("...");`. Copia la primera línea que ya está hecha en la plantilla y cambia el texto.

</details>

## Cómo ejecutarlo

```bash
java Ej01_01_RecetaEnOrden.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-receta-en-orden/SOLUCION.md).
