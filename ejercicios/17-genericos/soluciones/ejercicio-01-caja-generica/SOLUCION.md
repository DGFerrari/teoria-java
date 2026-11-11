# Solución · Ejercicio 01 · Caja genérica

[⬅️ Enunciado](../../ejercicio-01-caja-generica/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Pasar de `Object` a genéricos es casi mecánico: se añade `<T>` a la clase y se sustituye `Object` por `T` en todo lo que tenga que ver con el contenido. El resto (la lógica de la caja) no cambia.

| Antes | Después |
|---|---|
| `class Caja` | `class Caja<T>` |
| `private Object contenido;` | `private T contenido;` |
| `void guardar(Object objeto)` | `void guardar(T objeto)` |
| `String s = (String) caja.sacar();` | `String s = caja.sacar();` |

## Código explicado

```java
static class Caja<T> {
    private T contenido;

    T sacar() {
        T objeto = contenido;
        contenido = null;
        return objeto;
    }

    boolean estaVacia() {
        return contenido == null;
    }
    ...
}
```

`contenido` puede ser `null` aunque `T` sea `Integer`, porque `T` siempre es una clase. Por eso sirve como marca de "vacía".

**Usarla con distintos tipos:**

```java
Caja<Integer> cajaNumero = new Caja<>();
cajaNumero.guardar(7);
int numero = cajaNumero.sacar();
```

El compilador sabe que `sacar()` devuelve un `Integer` y hace el unboxing a `int`. Si escribieras `cajaNumero.guardar("siete")`, el error saldría **al compilar**.

⚠️ Si sacas un `null` de una `Caja<Integer>` y lo guardas en un `int`, tendrás un `NullPointerException`. Por eso, en el `main`, la segunda llamada a `sacar()` se muestra directamente con `println` sin guardarla en un `int`.

**Cajas dentro de cajas:**

```java
Caja<Caja<String>> grande = new Caja<>();
grande.guardar(pequenia);
```

## Errores comunes

- `Caja<int>` → no compila: usa `Caja<Integer>`.
- Poner `<T>` en cada método además de en la clase → crearías parámetros de tipo **distintos** que ocultan el de la clase.
- Olvidar el diamante: `new Caja()` compila con un aviso (*raw type*) y pierdes las comprobaciones.

## Código completo

📄 [Sol17_01_CajaGenerica.java](Sol17_01_CajaGenerica.java)
