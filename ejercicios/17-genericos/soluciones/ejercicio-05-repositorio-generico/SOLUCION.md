# Solución · Ejercicio 05 · Repositorio genérico

[⬅️ Enunciado](../../ejercicio-05-repositorio-generico/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

El repositorio necesita **una sola cosa** de sus elementos: saber cuál es su clave. Esa necesidad se expresa con una interfaz genérica (`Identificable<K>`) y un **límite** en el parámetro de tipo:

```java
static class Repositorio<K, T extends Identificable<K>>
```

Se lee: "un repositorio con claves de tipo `K` y elementos de tipo `T`, donde `T` es cualquier cosa que sepa dar una clave de tipo `K`". El compilador comprueba que los dos tipos encajan:

| Declaración | ¿Compila? | Por qué |
|---|---|---|
| `Repositorio<String, Producto>` | ✅ | `Producto` es `Identificable<String>` |
| `Repositorio<Integer, Socio>` | ✅ | `Socio` es `Identificable<Integer>` |
| `Repositorio<Integer, Producto>` | ❌ | La clave de `Producto` es `String`, no `Integer` |
| `Repositorio<String, String>` | ❌ | `String` no es `Identificable` |

Así, un único repositorio de ~40 líneas sirve para cualquier entidad presente o futura.

## Código explicado

**Usar lo que garantiza el límite:**

```java
boolean guardar(T elemento) {
    boolean guardado = false;
    if (!datos.containsKey(elemento.getId())) {
        datos.put(elemento.getId(), elemento);
        guardado = true;
    }
    return guardado;
}
```

Sin `extends Identificable<K>`, `elemento.getId()` daría `cannot find symbol`.

**Filtrar con una interfaz genérica:**

```java
List<T> filtrar(Filtro<T> filtro) {
    List<T> resultado = new ArrayList<>();
    for (T elemento : datos.values()) {
        if (filtro.cumple(elemento)) {
            resultado.add(elemento);
        }
    }
    return resultado;
}
```

El repositorio no sabe **qué** condición se aplica: la decide quien llama, pasando un objeto. `productos.filtrar(new SinStock())` compila porque `SinStock` es un `Filtro<Producto>`; `productos.filtrar(new MenorDeEdad())` no compilaría. En el tema 19 verás que, con lambdas, se escribe `productos.filtrar(p -> p.getStock() == 0)` sin crear ninguna clase.

**Método genérico acotado y comodín:**

```java
static <T extends Comparable<T>> List<T> ordenados(Collection<T> elementos) {
    List<T> copia = new ArrayList<>(elementos);
    Collections.sort(copia);
    return copia;
}

static void mostrar(String titulo, List<?> elementos) { ... }
```

`ordenados` necesita poder comparar (por eso el límite). `mostrar` solo necesita `toString`, que tiene cualquier `Object`, así que basta con `List<?>`.

**Implementar dos interfaces genéricas:**

```java
static class Socio implements Identificable<Integer>, Comparable<Socio> {
    @Override
    public Integer getId() {
        return numero;          // int → Integer
    }
    ...
}
```

## Errores comunes

- Declarar `Repositorio<K, T>` sin el límite → `getId()` no compila.
- Escribir `T extends Identificable` (sin `<K>`) → compila con avisos, pero `getId()` devuelve `Object` y no se puede usar como clave `K`.
- `todos()` devolviendo `datos.values()` directamente → quien lo reciba podría borrar elementos del repositorio.
- `public int getId()` en `Socio` → no compila: tiene que devolver exactamente `Integer`.

## Código completo

📄 [Sol17_05_RepositorioGenerico.java](Sol17_05_RepositorioGenerico.java)
