# Solución · Ejercicio 02 · Contador de fichero

[⬅️ Enunciado](../../ejercicio-02-contador-de-fichero/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Leer línea a línea es el patrón del **acumulador** (tema 07) aplicado a un fichero: cada vuelta del bucle procesa una línea y actualiza los contadores. La ventaja frente a `readAllLines` es que en memoria solo hay **una línea** a la vez, así que funciona igual con un poema que con un fichero de varios gigas.

El trabajo se reparte en dos métodos con responsabilidades distintas:

| Método | Responsabilidad | ¿Trata los errores? |
|---|---|---|
| `analizar` | Leer y calcular | No: `throws IOException` |
| `mostrar` | Presentar el resultado al usuario | Sí: sabe qué mensaje mostrar |

## Código explicado

**El bucle de lectura:**

```java
try (BufferedReader lector = Files.newBufferedReader(ruta)) {
    String linea = lector.readLine();
    while (linea != null) {
        lineas++;
        caracteres += linea.length();
        if (linea.isBlank()) {
            vacias++;
        } else {
            palabras += linea.strip().split("\\s+").length;
        }
        if (linea.length() > masLarga.length()) {
            masLarga = linea;
        }
        linea = lector.readLine();
    }
}
```

- `readLine()` devuelve la línea **sin** el salto de línea, por eso `length()` ya no lo cuenta.
- El `>` estricto hace que, con empate, se quede la primera línea más larga.
- El try-with-resources cierra el lector aunque `readLine` lance una excepción a mitad.

**Devolver varios datos con un record:**

```java
record Estadisticas(int lineas, int vacias, int palabras, int caracteres, String masLarga) { }
...
return new Estadisticas(lineas, vacias, palabras, caracteres, masLarga);
```

**Capturar donde se puede reaccionar:**

```java
try {
    Estadisticas e = analizar(ruta);
    ...
} catch (NoSuchFileException e) {
    System.out.println("✘ No existe el fichero " + ruta.getFileName());
} catch (IOException e) {
    System.out.println("✘ Error al leer: " + e.getMessage());
}
```

## Errores comunes

- `while (lector.readLine() != null)` y dentro otro `readLine()` → se salta una línea de cada dos.
- Contar palabras con `split(" ")` → los espacios dobles producen "palabras" vacías.
- Olvidar el try-with-resources → el fichero queda abierto (en Windows, no se podría borrar la carpeta temporal).
- Capturar solo `IOException` → funciona, pero el mensaje no distingue "no existe" de otros problemas.

## Código completo

📄 [Sol20_02_ContadorDeFichero.java](Sol20_02_ContadorDeFichero.java)
