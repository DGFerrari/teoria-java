# Ejercicio 03 · Importador de productos

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** `throw new IllegalArgumentException(...)` para validar, excepciones que se propagan desde un método, orden de los `catch` (subclase antes que superclase)

## Enunciado

Una tienda importa su catálogo desde un texto con el formato `código;nombre;precio;stock`. Algunas líneas tienen errores. Completa [`Ej15_03_ImportadorDeProductos.java`](Ej15_03_ImportadorDeProductos.java):

**1. El constructor de `Producto` valida y lanza `IllegalArgumentException`:**

| Regla | Mensaje |
|---|---|
| El código es `P-` seguido de 3 dígitos | `Código no válido: P-03` |
| El nombre no está vacío | `El nombre no puede estar vacío` |
| El precio es mayor que 0 | `El precio debe ser positivo: -3.0` |
| El stock no es negativo | `El stock no puede ser negativo: -2` |

**2. `Producto.desdeLinea(linea)`** (método `static`): divide la línea; si no tiene 4 campos lanza `IllegalArgumentException("Faltan campos")`; convierte precio y stock (si no son números, `parseDouble`/`parseInt` lanzan `NumberFormatException`, que **se deja propagar**) y crea el producto.

**3. En el `main`**, para cada línea: si todo va bien, guarda el producto; si no, muestra el error con el número de línea. Atención al orden de los `catch`: `NumberFormatException` **es una subclase** de `IllegalArgumentException`.

## Salida esperada

```
Línea 3 ✘ Código no válido: P-03
Línea 4 ✘ El nombre no puede estar vacío
Línea 5 ✘ El precio debe ser positivo: -3.0
Línea 6 ✘ Número no válido (For input string: "cuarenta")
Línea 7 ✘ Faltan campos
Línea 8 ✘ El stock no puede ser negativo: -2
=== Importados: 3 | Con errores: 6 ===
P-001 Teclado mecánico    59,90 € x 12
P-002 Ratón               19,50 € x 30
P-009 Altavoces           45,00 € x  6
Valor del inventario: 1.573,80 €
```

## Pistas

<details>
<summary>Pista 1</summary>

Para validar el código: `codigo.length() == 5 && codigo.startsWith("P-")` y que los tres últimos caracteres sean dígitos (`Character.isDigit`).

</details>

<details>
<summary>Pista 2</summary>

`split(";")` descarta los campos vacíos **del final**, pero no los del medio: `"P-004;;9.99;10"` da 4 campos, con el nombre vacío. Por eso la validación del nombre la hace el constructor.

</details>

<details>
<summary>Pista 3</summary>

```java
try {
    ...
} catch (NumberFormatException e) {          // La subclase primero
    ...
} catch (IllegalArgumentException e) {       // La superclase después
    ...
}
```

</details>

## Cómo ejecutarlo

```bash
java Ej15_03_ImportadorDeProductos.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-importador-de-productos/SOLUCION.md).
