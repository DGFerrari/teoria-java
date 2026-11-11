# Ejercicio 02 · Entradas de cine

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** entrada → proceso → salida, variables, asignación

## Enunciado

Vas al cine con dos amigos. Cada entrada cuesta **7.5 euros** y además compráis **un menú de palomitas** de **6 euros** para compartir.

1. Identifica la **entrada**, el **proceso** y la **salida** del problema y escríbelos en la tabla de comentarios de la plantilla.
2. Escribe el **pseudocódigo**.
3. Completa [`Ej01_02_EntradasDeCine.java`](Ej01_02_EntradasDeCine.java) para que calcule:
   - el precio total de las entradas,
   - el total gastado (entradas + palomitas),
   - y lo muestre por pantalla.

## Salida esperada

```
Entradas: 3 x 7.5 = 22.5 euros
Palomitas: 6.0 euros
Total gastado: 28.5 euros
```

## Pistas

<details>
<summary>Pista 1</summary>

La **entrada** son los datos que ya conoces antes de calcular nada: el número de entradas, su precio y el precio de las palomitas.

</details>

<details>
<summary>Pista 2</summary>

El proceso tiene dos pasos y el **orden importa**: primero calcula el total de las entradas y después súmale las palomitas.

```
totalEntradas ← numeroEntradas * precioEntrada
totalGastado ← ... + ...
```

</details>

<details>
<summary>Pista 3</summary>

En Java, para multiplicar se usa `*` y para sumar `+`. Para mostrar texto y variables juntos se unen con `+`:

```java
System.out.println("Total gastado: " + totalGastado + " euros");
```

</details>

## Cómo ejecutarlo

```bash
java Ej01_02_EntradasDeCine.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-entradas-de-cine/SOLUCION.md).
