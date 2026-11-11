# Ejercicio 04 · Validador de fechas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** `switch` como expresión con `yield`, condicionales anidados, condiciones compuestas, casos límite

## Enunciado

Completa [`Ej06_04_ValidadorDeFechas.java`](Ej06_04_ValidadorDeFechas.java) para que el programa lea un **día**, un **mes** y un **año**, y:

1. Calcule cuántos días tiene ese mes con un **`switch` como expresión**. Febrero tiene 29 días en los años **bisiestos** (usa `yield`). Si el mes no existe, el `switch` devuelve `0`.
2. Diga si la fecha es **válida**: año mayor que 0, mes entre 1 y 12 y día entre 1 y los días del mes.
3. Si es válida:
   - La muestre con formato `dd/mm/aaaa` (con ceros: `05/03/2025`).
   - Diga si es el **último día del mes**.
   - Calcule y muestre el **día siguiente** (cuidado con el cambio de mes y de año).
4. Si no es válida, muestre `Fecha no válida`.

## Salida esperada

```
Día: 28
Mes: 2
Año: 2024
Fecha: 28/02/2024
¿Último día del mes? false
Día siguiente: 29/02/2024
```

Más pruebas:

| Entrada | Salida |
|---|---|
| 29 / 2 / 2023 | `Fecha no válida` (2023 no es bisiesto) |
| 31 / 12 / 2025 | Último día: `true`, siguiente: `01/01/2026` |
| 30 / 4 / 2025 | Último día: `true`, siguiente: `01/05/2025` |
| 31 / 4 / 2025 | `Fecha no válida` |
| 15 / 13 / 2025 | `Fecha no válida` |

## Pistas

<details>
<summary>Pista 1</summary>

```java
int diasDelMes = switch (mes) {
    case 4, 6, 9, 11 -> 30;
    case 2 -> {
        boolean bisiesto = ...;
        yield ...;
    }
    case 1, 3, 5, 7, 8, 10, 12 -> 31;
    default -> 0;
};
```

Si el mes no existe, `diasDelMes` vale 0, así que ningún día cumplirá `dia <= diasDelMes`. La validación del mes sale "gratis".

</details>

<details>
<summary>Pista 2</summary>

El día siguiente tiene tres casos:

1. No es el último día del mes → mismo mes, `dia + 1`.
2. Es el último día pero no es diciembre → día 1 del mes siguiente.
3. Es el 31 de diciembre → 1 de enero del año siguiente.

Crea las variables `diaSiguiente`, `mesSiguiente` y `anioSiguiente` con los valores de partida y cambia solo lo necesario.

</details>

<details>
<summary>Pista 3</summary>

Para mostrar con ceros: `System.out.printf("%02d/%02d/%04d%n", dia, mes, anio);`

</details>

## Cómo ejecutarlo

```bash
java Ej06_04_ValidadorDeFechas.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-validador-de-fechas/SOLUCION.md).
