# Solución · Ejercicio 02 · Par genérico

[⬅️ Enunciado](../../ejercicio-02-par-generico/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Con dos parámetros de tipo, cada valor del par conserva **su propio** tipo. En `Par<String, Integer>`, el compilador sabe que `getPrimero()` devuelve un `String` y `getSegundo()` un `Integer`, sin casting.

Los métodos genéricos de la clase principal declaran sus propios `<A, B>`, que no tienen nada que ver con los de la clase `Par` aunque se llamen igual: se deducen en cada llamada.

| Llamada | `A` | `B` | Devuelve |
|---|---|---|---|
| `emparejar(nombres, edades)` | `String` | `Integer` | `List<Par<String, Integer>>` |
| `emparejar(List.of(1, 2, 3), List.of('A', ...))` | `Integer` | `Character` | `List<Par<Integer, Character>>` |

## Código explicado

**Invertir también los tipos:**

```java
Par<B, A> invertir() {
    return new Par<>(segundo, primero);
}
```

`ana` es un `Par<String, Integer>`, así que `ana.invertir()` es un `Par<Integer, String>`.

**Emparejar:**

```java
static <A, B> List<Par<A, B>> emparejar(List<A> primeros, List<B> segundos) {
    List<Par<A, B>> pares = new ArrayList<>();
    int cuantos = Math.min(primeros.size(), segundos.size());
    for (int i = 0; i < cuantos; i++) {
        pares.add(new Par<>(primeros.get(i), segundos.get(i)));
    }
    return pares;
}
```

**Buscar con el resultado como bandera:**

```java
Par<A, B> encontrado = null;
for (int i = 0; i < pares.size() && encontrado == null; i++) {
    if (pares.get(i).getPrimero().equals(clave)) {
        encontrado = pares.get(i);
    }
}
return encontrado;
```

Se compara con `equals` porque `A` es un objeto: con `==` compararías referencias.

## Errores comunes

- Declarar `invertir()` con tipo de retorno `Par<A, B>` → no compila, porque `new Par<>(segundo, primero)` es un `Par<B, A>`.
- Olvidar `<A, B>` antes del tipo de retorno de los métodos `static` → `cannot find symbol: class A`.
- Recorrer hasta `primeros.size()` → `IndexOutOfBoundsException` cuando la segunda lista es más corta.

## Código completo

📄 [Sol17_02_ParGenerico.java](Sol17_02_ParGenerico.java)
