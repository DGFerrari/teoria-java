# Solución · Ejercicio 03 · Utilidades genéricas

[⬅️ Enunciado](../../ejercicio-03-utilidades-genericas/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

La pregunta para cada método es: **¿qué necesito hacer con los elementos?**

| Necesito... | Método que uso | Lo tienen... | Declaración |
|---|---|---|---|
| Compararlos por igualdad | `equals` | Todos los objetos | `<T>` |
| Saber cuál es mayor | `compareTo` | Solo los `Comparable` | `<T extends Comparable<T>>` |
| Operar con su valor | `doubleValue` | Solo los `Number` | `<T extends Number>` |

Si usas un método que `T` no garantiza, el compilador da `cannot find symbol`. Acotar el tipo es la forma de prometerle que ese método existe.

## Código explicado

**Sin acotar: solo `equals`:**

```java
static <T> List<T> sinDuplicados(List<T> lista) {
    List<T> resultado = new ArrayList<>();
    for (T elemento : lista) {
        if (!resultado.contains(elemento)) {     // contains usa equals
            resultado.add(elemento);
        }
    }
    return resultado;
}
```

(También podrías hacer `new ArrayList<>(new LinkedHashSet<>(lista))`, del tema 16.)

**Acotado a `Comparable`:**

```java
static <T extends Comparable<T>> T maximo(List<T> lista) {
    T mayor = null;
    for (T elemento : lista) {
        if (mayor == null || elemento.compareTo(mayor) > 0) {
            mayor = elemento;
        }
    }
    return mayor;
}
```

Gracias al `||` con cortocircuito, `compareTo` nunca se llama sobre `null`: si `mayor == null` es `true`, la segunda parte no se evalúa.

```java
static <T extends Comparable<T>> boolean estaOrdenada(List<T> lista) {
    boolean ordenada = true;
    for (int i = 0; i < lista.size() - 1 && ordenada; i++) {
        ordenada = lista.get(i).compareTo(lista.get(i + 1)) <= 0;
    }
    return ordenada;
}
```

**Acotado a `Number`:**

```java
static <T extends Number> double media(List<T> lista) {
    double suma = 0;
    for (T numero : lista) {
        suma += numero.doubleValue();
    }
    return lista.isEmpty() ? 0 : suma / lista.size();
}
```

`Integer`, `Double`, `Long`... heredan de `Number`, que define `doubleValue()`.

## Errores comunes

- `static <T> T maximo(...)` y usar `compareTo` → `cannot find symbol`.
- Escribir `<T implements Comparable<T>>` → en los genéricos siempre es `extends`.
- Modificar la lista recibida en `invertida` (con `Collections.reverse`) → con `List.of` lanza `UnsupportedOperationException`, y además cambia los datos de quien llama.
- Inicializar `maximo` con `lista.get(0)` → falla con la lista vacía.

## Código completo

📄 [Sol17_03_UtilidadesGenericas.java](Sol17_03_UtilidadesGenericas.java)
