# Solución · Ejercicio 01 · Lista de la compra

[⬅️ Enunciado](../../ejercicio-01-lista-de-la-compra/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Una `ArrayList` es un array que se gestiona solo. Las operaciones que con arrays exigían bucles y desplazamientos (insertar al principio, borrar del medio, buscar) aquí son una llamada a un método:

| Con un array | Con `ArrayList` |
|---|---|
| Desplazar todo a la derecha y escribir en `[0]` | `compra.add(0, "café")` |
| Bucle con bandera para encontrar `"manzanas"` | `compra.indexOf("manzanas")` |
| Desplazar a la izquierda y llevar la cuenta | `compra.remove("pan")` |

## Código explicado

**Crear y añadir:**

```java
List<String> compra = new ArrayList<>();
compra.add("leche");
...
System.out.println("Lista: " + compra + " (" + compra.size() + " productos)");
```

La variable es de tipo `List` (la interfaz) y el objeto es un `ArrayList` (la implementación). `size()` sustituye al contador que llevabas a mano con los arrays.

**Insertar en una posición:**

```java
compra.add(0, "café");
```

La versión de `add` con dos parámetros inserta en esa posición y **desplaza** el resto hacia la derecha.

**Buscar y sustituir:**

```java
int posicion = compra.indexOf("manzanas");
if (posicion != -1) {
    compra.set(posicion, "peras");
}
```

`indexOf` compara con `equals`, así que funciona con textos sin problemas.

**Borrar por valor:**

```java
compra.remove("pan");
```

Solo desaparece el **primer** `pan`. Si quisieras quitar todos, podrías repetir mientras `contains("pan")` sea `true`.

**Recorrer con posición:**

```java
for (int i = 0; i < compra.size(); i++) {
    System.out.println((i + 1) + ". " + compra.get(i));
}
```

## Errores comunes

- Escribir `compra.length` o `compra[i]` → eso es de los arrays; en las listas son `size()` y `get(i)`.
- Olvidar los `import` de `ArrayList` y `List`.
- Llamar a `set` con `-1` cuando el elemento no está → `IndexOutOfBoundsException`.

## Código completo

📄 [Sol16_01_ListaDeLaCompra.java](Sol16_01_ListaDeLaCompra.java)
