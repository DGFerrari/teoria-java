# Solución · Ejercicio 01 · Diario personal

[⬅️ Enunciado](../../ejercicio-01-diario-personal/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Un diario **crece**: cada entrada nueva se añade sin borrar las anteriores. Por eso la clave es la opción con la que se escribe:

| Opción | Si no existe | Si existe |
|---|---|---|
| (ninguna) | Lo crea | Lo **sobrescribe** ❌ |
| `APPEND` | Falla (`NoSuchFileException`) ❌ | Añade al final |
| `CREATE, APPEND` | Lo crea | Añade al final ✅ |

## Código explicado

**Añadir una línea:**

```java
static void anotar(Path diario, String fecha, String texto) throws IOException {
    Files.writeString(diario, fecha + " · " + texto + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
}
```

El método declara `throws IOException`: no sabe qué hacer si el disco falla, así que deja que lo decida quien lo llama. El `main` también la declara, y si ocurriera, el programa terminaría mostrando la traza (para un ejercicio, es razonable).

**Leer todo o línea a línea:**

```java
System.out.print(Files.readString(diario));          // Un único String, con los \n
List<String> lineas = Files.readAllLines(diario);    // Una lista, sin los \n
```

**Buscar:**

```java
for (String linea : Files.readAllLines(diario)) {
    if (linea.contains(palabra)) {
        encontradas.add(linea);
    }
}
```

**La carpeta temporal y el `finally`:**

```java
Path carpeta = Files.createTempDirectory("ej20");
try {
    ...
} finally {
    borrarCarpeta(carpeta);
}
```

El `finally` (tema 15) garantiza que la carpeta se borra aunque algo falle por el camino.

## Errores comunes

- Escribir sin `APPEND` → solo queda la última entrada.
- Usar solo `APPEND` → `NoSuchFileException` en la primera entrada.
- Olvidar el `"\n"` → las tres entradas quedan en una sola línea.
- `println(Files.readString(...))` → aparece una línea en blanco de más al final.

## Código completo

📄 [Sol20_01_DiarioPersonal.java](Sol20_01_DiarioPersonal.java)
