# Ejercicio 02 · Desglose de tiempo

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** división entera `/`, módulo `%`, constantes

## Enunciado

Un cronómetro guarda el tiempo en **segundos**. Completa [`Ej04_02_DesgloseDeTiempo.java`](Ej04_02_DesgloseDeTiempo.java) para expresar esa cantidad en **días, horas, minutos y segundos**.

Usa constantes para los segundos que tiene un día, una hora y un minuto.

## Salida esperada

Con `segundosTotales = 200000`:

```
200000 segundos = 2 días, 7 horas, 33 minutos y 20 segundos
```

Prueba también con otros valores:

| `segundosTotales` | Resultado |
|---|---|
| 98765 | 1 días, 3 horas, 26 minutos y 5 segundos |
| 3600 | 0 días, 1 horas, 0 minutos y 0 segundos |
| 59 | 0 días, 0 horas, 0 minutos y 59 segundos |

(Arreglar el "1 días" requiere decisiones, que verás en el tema 06.)

## Pistas

<details>
<summary>Pista 1</summary>

Un día tiene 86 400 segundos, una hora 3 600 y un minuto 60.

</details>

<details>
<summary>Pista 2</summary>

Ve de la unidad más grande a la más pequeña. En cada paso:

- `/` te dice **cuántas** unidades completas caben.
- `%` te dice **cuántos segundos sobran** para el siguiente paso.

```
dias ← segundosTotales / SEGUNDOS_DIA
resto ← segundosTotales % SEGUNDOS_DIA
horas ← resto / SEGUNDOS_HORA
...
```

</details>

## Cómo ejecutarlo

```bash
java Ej04_02_DesgloseDeTiempo.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-desglose-de-tiempo/SOLUCION.md).
