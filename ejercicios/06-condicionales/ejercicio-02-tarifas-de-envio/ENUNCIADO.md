# Ejercicio 02 · Tarifas de envío

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** cadenas `else if` con rangos, orden de las condiciones, casos límite

## Enunciado

Una empresa de mensajería cobra según el peso del paquete:

| Peso | Precio |
|---|---|
| 0 kg o menos | ❌ Peso no válido |
| Hasta 1 kg (incluido) | 3.50 € |
| Más de 1 y hasta 5 kg | 6.00 € |
| Más de 5 y hasta 10 kg | 9.50 € |
| Más de 10 y hasta 20 kg | 14.00 € |
| Más de 20 kg | ❌ No se admite (máximo 20 kg) |

Completa [`Ej06_02_TarifasDeEnvio.java`](Ej06_02_TarifasDeEnvio.java) para que lea el peso y muestre el precio con dos decimales, o el mensaje de error que corresponda.

## Salida esperada

```
Peso del paquete (kg): 4,2
Precio del envío: 6,00 euros
```

Prueba también los **casos límite**:

| Peso | Resultado |
|---|---|
| 1 | 3,50 euros |
| 1,01 | 6,00 euros |
| 20 | 14,00 euros |
| 20,5 | `No se admiten paquetes de más de 20 kg` |
| 0 | `Peso no válido` |

## Pistas

<details>
<summary>Pista 1</summary>

Empieza por los dos casos de error y después ve de menor a mayor peso. Gracias al `else if`, en cada condición solo necesitas comprobar el **límite superior**.

</details>

<details>
<summary>Pista 2</summary>

"Hasta 1 kg incluido" es `peso <= 1`. Fíjate en que el límite está incluido en el tramo de abajo.

</details>

## Cómo ejecutarlo

```bash
java Ej06_02_TarifasDeEnvio.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-tarifas-de-envio/SOLUCION.md).
