# Solución · Ejercicio 04 · Contador de palabras

[⬅️ Enunciado](../../ejercicio-04-contador-de-palabras/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Hay tres estructuras, cada una para una pregunta distinta:

| Pregunta | Estructura |
|---|---|
| ¿Cuántas veces aparece cada palabra? | `Map<String, Integer>` (palabra → veces) |
| ¿Cuáles son las más frecuentes? | `List<Frecuencia>` ordenada con `Comparable` |
| ¿Qué palabras empiezan por cada letra? | `Map<Character, List<String>>` (inicial → palabras) |

Un `Map` está organizado por sus **claves**: un `TreeMap` las ordena alfabéticamente, pero no puede ordenarse por los **valores**. Para obtener el top se pasan los pares a una lista de objetos que sepan compararse.

## Código explicado

**Contar:**

```java
Map<String, Integer> frecuencias = new TreeMap<>();
for (String palabra : palabras) {
    frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
}
```

La primera vez que aparece una palabra, `getOrDefault` devuelve 0 y se guarda 1. Las siguientes, suma 1 a lo que había.

**Filtrar un mapa recorriendo sus pares:**

```java
for (Map.Entry<String, Integer> par : frecuencias.entrySet()) {
    if (par.getValue() > 1) {
        repetidas.put(par.getKey(), par.getValue());
    }
}
```

**Ordenar por frecuencia:**

```java
@Override
public int compareTo(Frecuencia otra) {
    int resultado = Integer.compare(otra.veces, veces);
    if (resultado == 0) {
        resultado = palabra.compareTo(otra.palabra);
    }
    return resultado;
}
```

```java
List<Frecuencia> todas = new ArrayList<>();
for (Map.Entry<String, Integer> par : frecuencias.entrySet()) {
    todas.add(new Frecuencia(par.getKey(), par.getValue()));
}
Collections.sort(todas);
```

`en`, `no` y `un` aparecen 2 veces; el desempate alfabético deja `en` y `no` en el podio.

La condición `i < cuantas && i < todas.size()` evita salirse de la lista si hubiera menos palabras que las pedidas.

**Un mapa de listas:**

```java
for (String palabra : frecuencias.keySet()) {
    char inicial = Character.toUpperCase(palabra.charAt(0));
    if (!indice.containsKey(inicial)) {
        indice.put(inicial, new ArrayList<>());
    }
    indice.get(inicial).add(palabra);
}
```

`indice.get(inicial)` devuelve la **misma** lista que está guardada en el mapa, así que el `add` la modifica dentro del mapa. La clave es `Character` (el envoltorio de `char`), con autoboxing.

## Errores comunes

- `frecuencias.put(palabra, frecuencias.get(palabra) + 1)` → la primera vez `get` devuelve `null` y el unboxing lanza `NullPointerException`.
- Intentar `Collections.sort(frecuencias)` → no compila: `sort` es para listas.
- Olvidar `implements Comparable<Frecuencia>` → `Collections.sort` no compila.
- Hacer `indice.put(inicial, new ArrayList<>())` en cada vuelta → borra la lista anterior.

## Código completo

📄 [Sol16_04_ContadorDePalabras.java](Sol16_04_ContadorDePalabras.java)
