# Solución · Ejercicio 04 · Máquina expendedora

[⬅️ Enunciado](../../ejercicio-04-maquina-expendedora/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Cada herramienta del tema tiene aquí su papel:

| Elemento | Herramienta | Por qué |
|---|---|---|
| Monedas y productos | `enum` con atributos | Son conjuntos **cerrados**: la máquina no acepta monedas de 3 € |
| El resultado de una compra | `record` | Son datos que no cambian una vez hecha la venta |
| El stock | `EnumMap<Producto, Integer>` | Una clave por producto, en orden de declaración |
| Los agotados | `EnumSet<Producto>` | Un conjunto de constantes |
| Los errores | Excepciones | La compra no puede devolver una `Venta` si algo falla |

## Código explicado

**El orden de declaración como herramienta:**

```java
enum Moneda {
    DOS_EUROS(200), UN_EURO(100), CINCUENTA(50), VEINTE(20), DIEZ(10), CINCO(5);
    ...
}
```

Como las monedas están de mayor a menor, `Moneda.values()` ya da el orden que necesita el algoritmo del cambio. Para 310 céntimos:

| Moneda | `310 / valor` | Se usan | Pendiente |
|---|---|---|---|
| 2 € | 1 | 1 | 110 |
| 1 € | 1 | 1 | 10 |
| 50 cts | 0 | | 10 |
| 20 cts | 0 | | 10 |
| 10 cts | 1 | 1 | 0 |

**Validar con excepciones, en orden:**

```java
Producto producto = Producto.porCodigo(codigo);
if (producto == null) {
    throw new IllegalArgumentException("Código desconocido: " + codigo);
}
if (stock.getOrDefault(producto, 0) == 0) {
    throw new IllegalStateException(producto + " agotado");
}
...
if (pagado < producto.getPrecio()) {
    throw new IllegalArgumentException("Importe insuficiente: faltan " + euros(producto.getPrecio() - pagado));
}
```

`IllegalStateException` es la excepción estándar para "la operación es correcta, pero el objeto no está en un estado que la permita" (aquí, sin stock).

Como cada `throw` corta el método, el stock y la recaudación solo cambian si se han pasado las tres comprobaciones.

**El record como resultado:**

```java
return new Venta(producto, pagado, pagado - producto.getPrecio());
```

Un método solo puede devolver un valor; el record permite devolver **tres datos relacionados** de una vez, con nombre.

## Errores comunes

- Guardar los importes en `double` → `2.0 - 1.75` da `0.25`, pero otras restas dan cosas como `0.30000000000000004` y el desglose falla.
- Declarar las monedas de menor a mayor → el cambio se daría en monedas de 5 céntimos.
- Restar el stock antes de comprobar el dinero → la máquina perdería un producto en cada pago insuficiente.

## Código completo

📄 [Sol18_04_MaquinaExpendedora.java](Sol18_04_MaquinaExpendedora.java)
