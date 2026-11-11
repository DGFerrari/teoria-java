# Solución · Ejercicio 04 · Carrito de la compra

[⬅️ Enunciado](../../ejercicio-04-carrito-de-la-compra/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Dos estrategias distintas de protección:

| Clase | Estrategia | Por qué |
|---|---|---|
| `Producto` | **Inmutable**: nada puede cambiar | Un producto es un dato "de catálogo"; si cambia el precio, es otro producto |
| `Carrito` | **Encapsulado**: cambia, pero solo con reglas | El carrito sí tiene que cambiar (añadir, quitar, cupones) |

## Código explicado

**Producto inmutable:**

```java
static final class Producto {
    private final String nombre;
    private final double precio;
    ...
    public Producto conDescuento(int porcentaje) {
        return new Producto(nombre, precio * (100 - porcentaje) / 100);
    }
}
```

`final` en la clase impide que alguien cree una subclase modificable (tema 13).

**Agregar con reutilización de líneas:**

```java
public boolean agregar(Producto producto, int cantidad) {
    boolean posible = cantidad > 0;
    if (posible) {
        int linea = buscarLinea(producto.getNombre());
        if (linea != -1) {
            cantidades[linea] += cantidad;
        } else if (numLineas < MAX_LINEAS) {
            productos[numLineas] = producto;
            cantidades[numLineas] = cantidad;
            numLineas++;
        } else {
            posible = false;              // Carrito lleno
        }
    }
    return posible;
}
```

**Un solo cupón**, con un método privado que decide el porcentaje:

```java
public boolean aplicarCupon(String codigo) {
    int porcentaje = porcentajeDeCupon(codigo);
    boolean aplicado = porcentajeCupon == 0 && porcentaje > 0;
    if (aplicado) {
        porcentajeCupon = porcentaje;
    }
    return aplicado;
}

private int porcentajeDeCupon(String codigo) {
    return switch (codigo) {
        case "AHORRA10" -> 10;
        case "VERANO25" -> 25;
        default -> 0;
    };
}
```

Las reglas de los cupones son un **detalle interno**: si mañana cambian, el código que usa el carrito no se entera.

**Copia defensiva con solo las líneas ocupadas:**

```java
public Producto[] getProductos() {
    return Arrays.copyOf(productos, numLineas);
}
```

Quien recibe la copia puede hacer con ella lo que quiera (incluso poner `null`): el array interno del carrito no cambia. Y como los `Producto` son inmutables, compartir las referencias es seguro.

## Errores comunes

- `return productos;` en el getter → desde fuera se puede romper el carrito.
- Permitir aplicar varios cupones → `VERANO25` sobre `AHORRA10`.
- Cambiar el precio del producto original en `conDescuento`.

## Código completo

📄 [Sol12_04_CarritoDeLaCompra.java](Sol12_04_CarritoDeLaCompra.java)
