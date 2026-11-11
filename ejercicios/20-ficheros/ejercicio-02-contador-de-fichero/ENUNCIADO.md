# Ejercicio 02 · Contador de fichero

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** `BufferedReader` y `readLine()` hasta `null`, try-with-resources, `NoSuchFileException` frente a `IOException`, un `record` como resultado

## Enunciado

Los sistemas Linux tienen un comando, `wc`, que cuenta las líneas, palabras y caracteres de un fichero. Programa tu versión en [`Ej20_02_ContadorDeFichero.java`](Ej20_02_ContadorDeFichero.java):

1. `analizar(ruta)` lee el fichero **línea a línea** con un `BufferedReader` y devuelve un record `Estadisticas` con:
   - El número de líneas y cuántas están vacías (o solo tienen espacios).
   - El número de palabras (las líneas vacías no tienen ninguna).
   - El número de caracteres, sin contar los saltos de línea.
   - La línea más larga (si hay empate, la primera).
2. `mostrar(ruta)` llama a `analizar` y muestra los resultados. Si el fichero no existe, muestra `✘ No existe el fichero X` en lugar de terminar con un error.

El `main` ya crea un fichero con un poema de Antonio Machado y llama a `mostrar` con él y con un fichero que no existe.

## Salida esperada

```
=== caminante.txt ===
Líneas: 9 (1 vacías)
Palabras: 42
Caracteres (sin saltos de línea): 197
Línea más larga: "Al andar se hace el camino,"
=== no-existe.txt ===
✘ No existe el fichero no-existe.txt
```

## Pistas

<details>
<summary>Pista 1</summary>

El esquema de lectura línea a línea, sin `break`:

```java
try (BufferedReader lector = Files.newBufferedReader(ruta)) {
    String linea = lector.readLine();
    while (linea != null) {
        ...
        linea = lector.readLine();
    }
}
```

</details>

<details>
<summary>Pista 2</summary>

Para contar palabras aunque haya varios espacios seguidos: `linea.strip().split("\\s+").length`. Pero cuidado: `"".split("\\s+")` devuelve un array de **un** elemento vacío; por eso las líneas vacías se tratan aparte.

</details>

<details>
<summary>Pista 3</summary>

`analizar` declara `throws IOException` y `mostrar` la captura. `NoSuchFileException` es subclase de `IOException`: su `catch` va primero.

</details>

## Cómo ejecutarlo

```bash
java Ej20_02_ContadorDeFichero.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-contador-de-fichero/SOLUCION.md).
