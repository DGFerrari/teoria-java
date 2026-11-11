# Ejercicio 01 · Días de la semana

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** declarar un `enum`, añadirle métodos, `values()`, `ordinal()`, `name()`, `valueOf()` y comparar constantes con `==`

## Enunciado

En [`Ej18_01_DiasDeLaSemana.java`](Ej18_01_DiasDeLaSemana.java), crea el enum `Dia` con los siete días (sin tildes: `MIERCOLES`, `SABADO`) y estos métodos:

| Método | Qué devuelve |
|---|---|
| `esFinDeSemana()` | `true` para `SABADO` y `DOMINGO` |
| `siguiente()` | El día siguiente. Después del `DOMINGO` va el `LUNES` |
| `avanzar(cuantos)` | El día que será dentro de `cuantos` días |
| `abreviatura()` | Las tres primeras letras, solo la primera en mayúscula: `"Lun"` |

En el `main`, muestra la tabla de días, cuenta los laborables, prueba `siguiente` y `avanzar`, y convierte textos en días con `valueOf`.

## Salida esperada

```
Lun · LUNES     · laborable
Mar · MARTES    · laborable
Mie · MIERCOLES · laborable
Jue · JUEVES    · laborable
Vie · VIERNES   · laborable
Sab · SABADO    · fin de semana
Dom · DOMINGO   · fin de semana
Días laborables: 5
Mañana (desde DOMINGO): LUNES
Dentro de 10 días desde VIERNES: LUNES
"jueves" → JUEVES
"Juernes" → ✘ no es un día
```

## Pistas

<details>
<summary>Pista 1</summary>

Dentro de un método del enum, `this` es la constante sobre la que se llama: `return this == SABADO || this == DOMINGO;`.

</details>

<details>
<summary>Pista 2</summary>

`values()` devuelve un array con las constantes en orden. El siguiente día está en la posición `(ordinal() + 1) % 7`: el resto hace que después de la posición 6 se vuelva a la 0.

</details>

<details>
<summary>Pista 3</summary>

`valueOf` exige el nombre exacto. Pasa el texto a mayúsculas antes y captura `IllegalArgumentException` para los textos que no son días.

</details>

## Cómo ejecutarlo

```bash
java Ej18_01_DiasDeLaSemana.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-dias-de-la-semana/SOLUCION.md).
