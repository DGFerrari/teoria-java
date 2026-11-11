# Solución · Ejercicio 05 · Gestor de pedidos

[⬅️ Enunciado](../../ejercicio-05-gestor-de-pedidos/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Cada concepto encaja con un tipo de herramienta distinta:

| Concepto | Herramienta | Por qué |
|---|---|---|
| Estado de un pedido | `enum` | Hay 5 estados y solo 5. Además, cada uno sabe a cuáles puede pasar |
| Línea de un pedido | `record` | Datos que no cambian; la validación garantiza que siempre son correctos |
| Tipos de descuento | `sealed interface` + `record` | Hay 3 tipos fijos, pero **cada uno tiene datos distintos** (un enum no serviría) |
| Pedido | `class` | Su estado **cambia** con el tiempo |

¿Por qué los descuentos no son un enum? Porque un enum tiene un número fijo de **objetos**: no podría haber un `Porcentaje(10)` y un `Porcentaje(25)` a la vez. Con `sealed` + records hay un número fijo de **tipos**, y de cada uno se crean los objetos que hagan falta.

## Código explicado

**La máquina de estados dentro del enum:**

```java
boolean puedePasarA(EstadoPedido nuevo) {
    return switch (this) {
        case PENDIENTE -> nuevo == PAGADO || nuevo == CANCELADO;
        case PAGADO -> nuevo == ENVIADO || nuevo == CANCELADO;
        case ENVIADO -> nuevo == ENTREGADO;
        case ENTREGADO, CANCELADO -> false;
    };
}
```

Si mañana se añade un estado `DEVUELTO`, este `switch` deja de compilar hasta que se decida a qué estados puede pasar. El compilador obliga a no olvidar nada.

**El pedido solo cambia si el enum lo permite:**

```java
void cambiarEstado(EstadoPedido nuevo) {
    if (!estado.puedePasarA(nuevo)) {
        throw new IllegalStateException("No se puede pasar de " + estado + " a " + nuevo);
    }
    estado = nuevo;
}
```

**Desmontar los descuentos:**

```java
return switch (descuento) {
    case null -> 0;
    case Porcentaje(double porcentaje) -> subtotal * porcentaje / 100;
    case Fijo(double euros) -> Math.min(euros, subtotal);
    case TresPorDos(String producto) -> {
        double ahorro = 0;
        for (LineaPedido linea : lineas) {
            if (linea.producto().equals(producto)) {
                ahorro += (linea.cantidad() / 3) * linea.precioUnitario();
            }
        }
        yield ahorro;
    }
};
```

- Sin `default`: `Descuento` es `sealed` y están los tres casos.
- Cada patrón saca los datos del record en variables (`porcentaje`, `euros`, `producto`).
- `case null` evita un `NullPointerException` en el pedido 4.

**Copia inmutable de las líneas:**

```java
this.lineas = List.copyOf(lineas);
```

Las líneas son records (inmutables) y la lista es una copia inmutable: una vez creado, el contenido del pedido no se puede alterar desde fuera (tema 12).

## Errores comunes

- Modelar los descuentos con un enum `TipoDescuento` y un `double valor` aparte → `TresPorDos` necesita un **texto**, no un número, y acabarías con atributos que solo tienen sentido para algunos tipos.
- Olvidar `case null` → `NullPointerException` al calcular el pedido sin descuento.
- `Fijo(10)` aplicado a un pedido de 6 € sin `Math.min` → total negativo.
- Contar en el `EnumMap` sin inicializarlo → `porEstado.get(estado)` devuelve `null` y el `+ 1` lanza `NullPointerException`.

## Código completo

📄 [Sol18_05_GestorDePedidos.java](Sol18_05_GestorDePedidos.java)
