# Ejercicio 01 · Temperaturas de la semana

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** acceder por índice, `length`, recorrer con `for` y con for-each

## Enunciado

En [`Ej08_01_TemperaturasDeLaSemana.java`](Ej08_01_TemperaturasDeLaSemana.java) tienes dos arrays: los nombres de los días y sus temperaturas máximas. Completa el programa para que:

1. Muestre cada día con su temperatura (usa un `for` clásico: necesitas el mismo índice en los dos arrays).
2. Calcule la **media** de la semana recorriendo las temperaturas con un **for-each**.
3. Muestre la temperatura del **primer** y del **último** día usando `length` (sin escribir el 6 a mano).

## Salida esperada

```
Lunes: 14,5 ºC
Martes: 16,0 ºC
Miércoles: 13,2 ºC
Jueves: 18,7 ºC
Viernes: 21,3 ºC
Sábado: 22,8 ºC
Domingo: 19,4 ºC
Media de la semana: 18,0 ºC
Primer día: 14,5 ºC | Último día: 19,4 ºC
```

## Pistas

<details>
<summary>Pista 1</summary>

```java
for (int i = 0; i < dias.length; i++) {
    System.out.printf("%s: %.1f ºC%n", dias[i], temperaturas[i]);
}
```

</details>

<details>
<summary>Pista 2</summary>

El último elemento está en `temperaturas[temperaturas.length - 1]`.

</details>

## Cómo ejecutarlo

```bash
java Ej08_01_TemperaturasDeLaSemana.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-temperaturas-de-la-semana/SOLUCION.md).
