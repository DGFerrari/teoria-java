# Tema 20 · Ficheros

[⬅️ Tema anterior](../19-lambdas-y-streams/README.md) · [🏠 Índice](../../INDICE.md)

Todos los programas que has escrito hasta ahora **olvidan todo** al terminar: la agenda, el inventario o la clasificación de la liga desaparecen en cuanto se cierra el programa. Para que los datos **persistan** hay que guardarlos en **ficheros**. En este tema aprenderás a leer y escribir ficheros de texto con la API moderna de Java (`java.nio.file`), a trabajar con carpetas y a tratar los errores que aparecen al hablar con el disco.

## 🎯 Objetivos

- Representar rutas con **`Path`** y entender las rutas relativas y absolutas.
- Leer y escribir un fichero completo con **`Files.readString`**, **`Files.writeString`**, **`readAllLines`** y **`write`**.
- Añadir contenido al final de un fichero con **`StandardOpenOption.APPEND`**.
- Leer y escribir **línea a línea** con `BufferedReader` y `BufferedWriter`/`PrintWriter`.
- Procesar ficheros con **streams** (`Files.lines`).
- Tratar las **`IOException`** y cerrar los recursos con **try-with-resources**.
- Crear, listar, copiar, mover y borrar ficheros y carpetas.
- Guardar y cargar objetos en formato **CSV**.

## 📚 Contenido

1. [¿Por qué ficheros?](#1-por-qué-ficheros)
2. [Rutas: Path](#2-rutas-path)
3. [Leer y escribir un fichero completo](#3-leer-y-escribir-un-fichero-completo)
4. [Las excepciones de los ficheros](#4-las-excepciones-de-los-ficheros)
5. [Leer línea a línea](#5-leer-línea-a-línea)
6. [Escribir línea a línea](#6-escribir-línea-a-línea)
7. [Ficheros y streams](#7-ficheros-y-streams)
8. [Carpetas y operaciones con ficheros](#8-carpetas-y-operaciones-con-ficheros)
9. [Guardar objetos: el formato CSV](#9-guardar-objetos-el-formato-csv)
10. [Codificación de caracteres](#10-codificación-de-caracteres)
11. [Buenas prácticas](#11-buenas-prácticas)
12. [Errores típicos](#12-errores-típicos)
13. [Resumen](#13-resumen)

---

## 1. ¿Por qué ficheros?

| Memoria (variables, colecciones) | Fichero |
|---|---|
| Muy rápida | Más lenta |
| Se pierde al terminar el programa | **Permanece** en el disco |
| Solo la ve tu programa | La pueden leer otros programas y personas |

En este tema trabajarás con **ficheros de texto** (`.txt`, `.csv`, `.log`...): se pueden abrir con cualquier editor y son la forma más sencilla de guardar datos. Existen también ficheros binarios (imágenes, ejecutables) y bases de datos, que quedan fuera de este repositorio.

Las clases de este tema están en `java.nio.file` (*New Input/Output*), la API moderna de Java para ficheros:

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
```

> Existe una API antigua (`java.io.File`, `FileReader`, `FileWriter`) que verás en mucho código existente. Hace lo mismo con más líneas y peores mensajes de error. En código nuevo, usa `Path` y `Files`.

## 2. Rutas: Path

Un **`Path`** representa la **ubicación** de un fichero o carpeta. Crear un `Path` **no** crea el fichero ni comprueba que exista: es solo una "dirección".

```java
Path relativa = Path.of("datos", "notas.csv");          // datos/notas.csv
Path absoluta = Path.of("C:", "Users", "ana", "notas.csv");
```

| Tipo | Ejemplo | Se busca desde... |
|---|---|---|
| **Relativa** | `datos/notas.csv` | El **directorio de trabajo**: la carpeta desde la que ejecutas `java` |
| **Absoluta** | `C:\Users\ana\notas.csv`, `/home/ana/notas.csv` | La raíz del disco |

`Path.of` con varios trozos usa el separador correcto en cada sistema (`\` en Windows, `/` en Linux y macOS). Así el programa funciona en cualquier ordenador.

| Método | Qué devuelve | Ejemplo con `datos/2025/notas.csv` |
|---|---|---|
| `getFileName()` | El nombre final | `notas.csv` |
| `getParent()` | La carpeta que lo contiene | `datos/2025` |
| `resolve(otro)` | Una ruta "dentro" de esta | `Path.of("datos").resolve("notas.csv")` → `datos/notas.csv` |
| `toAbsolutePath()` | La ruta absoluta | `C:\...\datos\2025\notas.csv` |

**Preguntar al disco** (estos métodos son de `Files`):

| Método | Qué hace |
|---|---|
| `Files.exists(ruta)` | ¿Existe? |
| `Files.isDirectory(ruta)` / `isRegularFile(ruta)` | ¿Es una carpeta? / ¿Es un fichero? |
| `Files.size(ruta)` | Tamaño en bytes |

> **En los ejemplos y ejercicios de este tema**, para no llenar el repositorio de ficheros, todo se crea en una **carpeta temporal** del sistema con `Files.createTempDirectory("tema20")`, y se borra al terminar.

## 3. Leer y escribir un fichero completo

Para ficheros pequeños (hasta unos pocos megas), lo más cómodo es leer o escribir **todo de una vez**:

```java
Path ruta = Path.of("saludo.txt");

Files.writeString(ruta, "Hola\nAdiós\n");               // Crea el fichero (o lo SOBRESCRIBE)
String todo = Files.readString(ruta);                     // "Hola\nAdiós\n"

List<String> lineas = List.of("uno", "dos", "tres");
Files.write(ruta, lineas);                                // Cada elemento, una línea
List<String> leidas = Files.readAllLines(ruta);           // [uno, dos, tres]
```

| Método | Qué hace |
|---|---|
| `Files.writeString(ruta, texto)` | Escribe un `String` |
| `Files.write(ruta, lista)` | Escribe una colección de líneas |
| `Files.readString(ruta)` | Lee todo como un `String` |
| `Files.readAllLines(ruta)` | Lee todo como una `List<String>` (sin los saltos de línea) |

⚠️ Por defecto, **escribir sobrescribe** el fichero si ya existía. Para **añadir al final**, se indica una opción:

```java
Files.writeString(ruta, "otra línea\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
```

| Opción (`StandardOpenOption`) | Significado |
|---|---|
| `CREATE` | Crea el fichero si no existe |
| `APPEND` | Escribe al final, sin borrar lo que había |
| `CREATE_NEW` | Crea el fichero; si ya existe, **falla** (útil para no machacar nada) |
| `TRUNCATE_EXISTING` | Vacía el fichero antes de escribir (es lo que se hace por defecto) |

## 4. Las excepciones de los ficheros

Casi todos los métodos de `Files` declaran **`throws IOException`**, una excepción **checked** (tema 15): el compilador te obliga a capturarla o a declararla. Tiene sentido: aunque tu código sea perfecto, el fichero puede no existir, el disco puede estar lleno o puedes no tener permiso.

```java
try {
    String contenido = Files.readString(Path.of("no-existe.txt"));
} catch (NoSuchFileException e) {
    System.out.println("No existe: " + e.getMessage());     // El mensaje es la ruta
} catch (IOException e) {
    System.out.println("Error de lectura: " + e.getMessage());
}
```

| Excepción | Cuándo |
|---|---|
| `IOException` | La general de entrada/salida (superclase de las demás) |
| `NoSuchFileException` | El fichero o carpeta no existe |
| `FileAlreadyExistsException` | Se intenta crear algo que ya existe (`CREATE_NEW`, `createDirectory`, `copy`...) |
| `AccessDeniedException` | No hay permiso |
| `DirectoryNotEmptyException` | Se intenta borrar una carpeta que no está vacía |

Como `NoSuchFileException` es **subclase** de `IOException`, su `catch` va primero (tema 15).

**¿Capturar o declarar?** Igual que en el tema 15: captura donde puedas **hacer algo útil** (avisar al usuario, usar un valor por defecto). Un método de "bajo nivel" como `guardar(ruta)` suele **declarar** `throws IOException` y dejar que decida quien lo llama.

## 5. Leer línea a línea

Con ficheros grandes no conviene cargar todo en memoria. Un **`BufferedReader`** lee línea a línea: `readLine()` devuelve la siguiente línea, o **`null`** cuando se acaba el fichero.

```java
try (BufferedReader lector = Files.newBufferedReader(ruta)) {
    String linea = lector.readLine();
    while (linea != null) {                  // null = fin del fichero
        System.out.println(linea);
        linea = lector.readLine();
    }
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

- El lector es un **recurso** que hay que cerrar: por eso va en un **try-with-resources** (tema 15). Se cierra solo, haya error o no.
- Fíjate en la estructura del bucle: se lee **antes** del `while` y **al final** de cada vuelta. Así la condición del bucle es la que decide cuándo parar, sin `break`.

También puedes usar un **`Scanner`** sobre un fichero, igual que sobre el teclado o un texto (temas 05 y 15): `new Scanner(ruta)`.

## 6. Escribir línea a línea

Para escribir poco a poco, se usa un **`BufferedWriter`**:

```java
try (BufferedWriter escritor = Files.newBufferedWriter(ruta)) {
    escritor.write("Primera línea");
    escritor.newLine();                          // Salto de línea del sistema
    escritor.write("Segunda línea");
    escritor.newLine();
}
```

O un **`PrintWriter`**, que tiene los mismos métodos que `System.out`: `println`, `print` y `printf`.

```java
try (PrintWriter salida = new PrintWriter(Files.newBufferedWriter(ruta))) {
    salida.println("=== Informe ===");
    salida.printf("%-10s %5.2f%n", "Ana", 8.5);
}
```

- "*Buffered*" significa que se acumula el texto en memoria y se escribe al disco en bloques: es mucho más rápido que escribir carácter a carácter.
- Por eso es **imprescindible cerrar** el escritor: si no, lo último que hay en el búfer **puede no llegar al fichero**. Con try-with-resources no hay que preocuparse.
- `Files.newBufferedWriter(ruta, StandardOpenOption.CREATE, StandardOpenOption.APPEND)` añade al final.

## 7. Ficheros y streams

`Files.lines(ruta)` devuelve un **`Stream<String>`** con las líneas del fichero, que se leen a medida que el stream las necesita. Todo lo del tema 19 funciona igual:

```java
try (Stream<String> lineas = Files.lines(ruta)) {          // También hay que cerrarlo
    long errores = lineas.filter(l -> l.contains("ERROR")).count();
}
```

Y para listar el contenido de una carpeta, `Files.list(carpeta)` devuelve un `Stream<Path>`:

```java
try (Stream<Path> contenido = Files.list(carpeta)) {
    List<Path> logs = contenido
            .filter(p -> p.getFileName().toString().endsWith(".log"))
            .sorted()
            .toList();
}
```

⚠️ Un problema de los streams con ficheros: las lambdas **no pueden lanzar excepciones checked**. Si dentro de un `map` necesitas llamar a `Files.readString` (que lanza `IOException`), tendrás que capturarla dentro de la lambda o, mejor, sacar ese código a un método que la trate.

## 8. Carpetas y operaciones con ficheros

| Método | Qué hace |
|---|---|
| `Files.createDirectory(ruta)` | Crea una carpeta (falla si ya existe o si no existe la carpeta padre) |
| `Files.createDirectories(ruta)` | Crea la carpeta y todas las que falten por el camino. No falla si ya existe |
| `Files.createFile(ruta)` | Crea un fichero vacío (falla si ya existe) |
| `Files.copy(origen, destino)` | Copia (falla si el destino existe, salvo con `StandardCopyOption.REPLACE_EXISTING`) |
| `Files.move(origen, destino)` | Mueve o renombra |
| `Files.delete(ruta)` | Borra (falla si no existe o si es una carpeta con contenido) |
| `Files.deleteIfExists(ruta)` | Borra si existe; devuelve si lo ha borrado |
| `Files.list(carpeta)` | `Stream<Path>` con el contenido directo de la carpeta |
| `Files.walk(carpeta)` | `Stream<Path>` con todo lo que hay dentro, en todos los niveles |
| `Files.createTempDirectory(prefijo)` | Crea una carpeta temporal con un nombre único |

## 9. Guardar objetos: el formato CSV

Un fichero de texto solo guarda **texto**. Para guardar objetos hay que decidir un **formato**. El más sencillo y extendido es **CSV** (*Comma-Separated Values*): una línea por objeto y los atributos separados por un carácter (en España se suele usar `;` porque la coma es el separador decimal). La primera línea suele ser una **cabecera**.

```
nombre;edad;nota
Ana;15;8.5
Luis;16;6.25
```

**Guardar** = convertir cada objeto en una línea. **Cargar** = convertir cada línea en un objeto:

```java
record Alumno(String nombre, int edad, double nota) {
    String aCsv() {
        return nombre + ";" + edad + ";" + nota;
    }

    static Alumno desdeCsv(String linea) {
        String[] partes = linea.split(";");
        return new Alumno(partes[0], Integer.parseInt(partes[1]), Double.parseDouble(partes[2]));
    }
}

// Guardar
List<String> lineas = new ArrayList<>();
lineas.add("nombre;edad;nota");
for (Alumno a : alumnos) {
    lineas.add(a.aCsv());
}
Files.write(ruta, lineas);

// Cargar (saltando la cabecera)
List<Alumno> cargados = Files.readAllLines(ruta).stream()
        .skip(1)
        .map(Alumno::desdeCsv)
        .toList();
```

> Al escribir números con `+` o con `String.valueOf` se usa siempre el **punto** decimal (`8.5`), que es lo que espera `Double.parseDouble`. Si los escribes con `printf` o `String.format`, saldrán con la coma de la configuración regional y no podrás volver a leerlos con `parseDouble` (tema 05).

Un CSV "de verdad" tiene más complicaciones (textos que contienen el separador, comillas...). Para casos complejos existen librerías especializadas, o formatos como JSON.

## 10. Codificación de caracteres

Un fichero de texto guarda **bytes**, y la **codificación** dice qué bytes corresponden a cada carácter. Los métodos de `Files` usan **UTF-8** por defecto, que admite tildes, eñes, emojis y cualquier alfabeto. Desde Java 18, UTF-8 es también la codificación por defecto del resto de la API.

Si un programa antiguo te da un fichero con otra codificación (por ejemplo, ISO-8859-1), se indica al leerlo:

```java
Files.readString(ruta, StandardCharsets.ISO_8859_1);
```

Si al leer un fichero ves `Ã©` en lugar de `é`, casi siempre es un problema de codificación: el fichero se escribió con una y se está leyendo con otra.

## 11. Buenas prácticas

| ✅ Haz | ❌ Evita |
|---|---|
| Usar `Path` y `Files` (`java.nio.file`) | La API antigua `File`/`FileReader` en código nuevo |
| Abrir lectores, escritores y `Files.lines` en **try-with-resources** | Olvidar cerrarlos (fugas de recursos, datos sin escribir) |
| Construir rutas con `Path.of("a", "b")` o `resolve` | Concatenar con `"a" + "\\" + "b"` (solo funciona en Windows) |
| Capturar `IOException` donde puedas reaccionar | Un `catch (IOException e) { }` vacío |
| Comprobar con `Files.exists` cuando "no existe" sea un caso normal (primera ejecución) | Usar las excepciones para el flujo normal |
| Separar la lógica (calcular) de la entrada/salida (leer, guardar) | Mezclar `Files.readString` en medio de los cálculos |
| Guardar en un formato que puedas volver a leer (puntos decimales, separador fijo) | Guardar con `printf` y luego no poder parsearlo |

## 12. Errores típicos

| Error | Ejemplo | Qué pasa |
|---|---|---|
| No tratar la `IOException` | `Files.readString(ruta);` sin `try` ni `throws` | `unreported exception IOException; must be caught or declared to be thrown` |
| Ruta relativa desde otra carpeta | Ejecutar desde la raíz del proyecto un programa que busca `notas.csv` | `NoSuchFileException`: se busca en el directorio de trabajo, no junto al `.java` |
| Sobrescribir sin querer | `Files.writeString(ruta, nuevo)` para añadir una línea | Se pierde lo que había: usa `APPEND` |
| No cerrar el escritor | `BufferedWriter` sin `close()` | El fichero se queda vacío o incompleto |
| Comparar `readLine()` con `""` para el final | `while (!linea.equals(""))` | Una línea vacía no es el final; el final es `null` (y `null.equals` lanza `NullPointerException`) |
| Olvidar la cabecera del CSV | Parsear `"nombre;edad;nota"` como un alumno | `NumberFormatException` |
| Crear una carpeta que ya existe | `Files.createDirectory(ruta)` dos veces | `FileAlreadyExistsException`: usa `createDirectories` |
| Borrar una carpeta con contenido | `Files.delete(carpeta)` | `DirectoryNotEmptyException` |
| Escribir decimales con `printf` y leerlos con `parseDouble` | `8,50` | `NumberFormatException` |

## 13. Resumen

- **`Path`** representa una ruta (relativa al directorio de trabajo o absoluta). Se crea con `Path.of(...)` y no toca el disco.
- **`Files`** hace las operaciones: `readString`, `readAllLines`, `writeString`, `write` para ficheros completos; `StandardOpenOption.APPEND` para añadir.
- Casi todo lanza **`IOException`** (checked). Las más concretas: `NoSuchFileException`, `FileAlreadyExistsException`.
- Línea a línea: **`BufferedReader.readLine()`** (devuelve `null` al final), **`BufferedWriter`** y **`PrintWriter`** (`println`, `printf`). Siempre en **try-with-resources**.
- **`Files.lines`** y **`Files.list`** devuelven streams que también hay que cerrar.
- Carpetas: `createDirectories`, `list`, `walk`, `copy`, `move`, `delete`, `deleteIfExists`.
- Para guardar objetos, un formato como **CSV**: una línea por objeto, campos separados por `;`, cabecera opcional y números con punto decimal.
- Los ficheros se leen y escriben en **UTF-8** por defecto.

---

## 💻 Ejemplos de código

| Archivo | Qué muestra |
|---|---|
| [T20_01_RutasYPath.java](ejemplos/T20_01_RutasYPath.java) | Crear rutas, sus partes, rutas relativas y absolutas, y preguntar al disco |
| [T20_02_LeerYEscribirCompleto.java](ejemplos/T20_02_LeerYEscribirCompleto.java) | `writeString`, `readString`, `write`, `readAllLines` y `APPEND` |
| [T20_03_ExcepcionesDeFicheros.java](ejemplos/T20_03_ExcepcionesDeFicheros.java) | `NoSuchFileException`, `FileAlreadyExistsException` y `throws IOException` |
| [T20_04_LineaALinea.java](ejemplos/T20_04_LineaALinea.java) | `BufferedReader`, `BufferedWriter` y `PrintWriter` |
| [T20_05_FicherosYStreams.java](ejemplos/T20_05_FicherosYStreams.java) | `Files.lines`, `Files.list`, carpetas, copiar, mover y borrar |
| [T20_06_GuardarYCargarCsv.java](ejemplos/T20_06_GuardarYCargarCsv.java) | Guardar una lista de records en CSV y volver a cargarla |

> Todos los ejemplos trabajan en una carpeta temporal y la borran al terminar: puedes ejecutarlos tantas veces como quieras.

## ✏️ Ejercicios

Practica lo aprendido en los [ejercicios del tema 20](../../ejercicios/20-ficheros/README.md).

---

[⬅️ Tema anterior](../19-lambdas-y-streams/README.md) · [🏠 Índice](../../INDICE.md)
