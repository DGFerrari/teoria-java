# Ejercicio 02 · Nóminas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** sobrescribir métodos con `@Override`, ampliar con `super.metodo()`, `toString` heredado y sobrescrito

## Enunciado

En [`Ej13_02_Nominas.java`](Ej13_02_Nominas.java) tienes la clase `Empleado` y el esqueleto de dos subclases. Completa:

| Clase | `calcularSueldo()` | `toString()` |
|---|---|---|
| `Empleado` (hecha) | El sueldo base | `"Ana · 1.500,00 €"` |
| `Comercial` | Sueldo base + un % de comisión sobre sus ventas | El de `Empleado` + `" (comercial, ventas: 40.000,00 €)"` |
| `Gerente` | Sueldo base + un bonus fijo + 50 € por cada persona a su cargo | El de `Empleado` + `" (gerente de 6 personas)"` |

Las dos subclases deben **reutilizar** el código de `Empleado` con `super.calcularSueldo()` y `super.toString()`.

## Salida esperada

```
Ana · 1.500,00 €
Jorge · 2.900,00 € (comercial, ventas: 40.000,00 €)
Marta · 3.600,00 € (gerente de 6 personas)
Total de nóminas: 8.000,00 €
```

## Pistas

<details>
<summary>Pista 1</summary>

```java
@Override
public double calcularSueldo() {
    return super.calcularSueldo() + ventas * porcentajeComision / 100;
}
```

</details>

<details>
<summary>Pista 2</summary>

`Empleado.toString()` ya llama a `calcularSueldo()`. Gracias al polimorfismo, cuando el objeto es un `Comercial`, se usa **su** `calcularSueldo()`, así que `super.toString()` ya muestra el sueldo correcto.

</details>

## Cómo ejecutarlo

```bash
java Ej13_02_Nominas.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-nominas/SOLUCION.md).
