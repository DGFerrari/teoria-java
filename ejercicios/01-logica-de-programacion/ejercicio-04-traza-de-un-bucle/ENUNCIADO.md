# Ejercicio 04 · Traza de un bucle

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** traza, repetición (`while`), contadores y acumuladores

## Enunciado

Tienes este algoritmo:

```
INICIO
    valor ← 1
    total ← 0
    vuelta ← 1
    MIENTRAS vuelta <= 5 HACER
        total ← total + valor
        valor ← valor * 2
        vuelta ← vuelta + 1
    FIN MIENTRAS
    ESCRIBIR "total = ", total
    ESCRIBIR "valor = ", valor
FIN
```

1. **Sin ejecutar nada**, haz la traza en papel (o en los comentarios de la plantilla) completando esta tabla:

   | Vuelta | `total` después | `valor` después |
   |---|---|---|
   | 1 | ? | ? |
   | 2 | ? | ? |
   | … | … | … |

2. Responde: ¿qué valores se escriben al final? ¿Qué está calculando realmente el algoritmo?
3. Completa [`Ej01_04_TrazaDeUnBucle.java`](Ej01_04_TrazaDeUnBucle.java) para que ejecute el algoritmo y **muestre una línea por vuelta** con los valores de las variables. Así podrás comprobar tu traza.

## Salida esperada (formato)

```
Vuelta 1 -> total = ?, valor = ?
Vuelta 2 -> total = ?, valor = ?
...
Resultado final: total = ?, valor = ?
```

(Los `?` los descubres tú con la traza.)

## Pistas

<details>
<summary>Pista 1</summary>

Dentro del bucle, las tres instrucciones se ejecutan **en orden**. En la vuelta 1, `total` se calcula con el `valor` **antiguo** (1), y solo después `valor` pasa a valer 2.

</details>

<details>
<summary>Pista 2</summary>

Fíjate en los valores que se van sumando a `total`: 1, 2, 4, 8... Cada uno es el doble del anterior.

</details>

<details>
<summary>Pista 3</summary>

Para mostrar los valores en cada vuelta, pon el `System.out.println` **dentro** del `while`, después de actualizar `total` y `valor` pero **antes** de sumar 1 a `vuelta` (si no, mostrarías el número de la vuelta siguiente).

</details>

## Cómo ejecutarlo

```bash
java Ej01_04_TrazaDeUnBucle.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-traza-de-un-bucle/SOLUCION.md).
