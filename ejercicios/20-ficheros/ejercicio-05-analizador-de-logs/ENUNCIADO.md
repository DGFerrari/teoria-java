# Ejercicio 05 · Analizador de logs

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema: `Files.list`, `Files.lines`, `PrintWriter`, `createDirectories`, `copy` + enums, records, `Optional`, streams, `groupingBy`, `EnumMap`, `TreeMap` y excepciones

## Enunciado

Los servidores guardan lo que pasa en ficheros de **log**, uno por día. Cada línea tiene este formato:

```
2026-11-10 09:15:02 ERROR [pagos] Tarjeta rechazada
   fecha     hora   nivel módulo      mensaje
```

El `main` de [`Ej20_05_AnalizadorDeLogs.java`](Ej20_05_AnalizadorDeLogs.java) crea una carpeta `logs` con tres ficheros `.log` (con alguna línea incorrecta) y un `leeme.txt` que no es un log. Completa el analizador:

1. **`Entrada.parsear(linea)`**: `Optional` con la entrada, o vacío si la línea no tiene el formato o el nivel no es `INFO`, `AVISO` o `ERROR`.
2. **`listarLogs(carpeta)`**: los ficheros `.log` de la carpeta, ordenados.
3. **`leerEntradas(fichero)`**: lee las líneas no vacías y devuelve una `Lectura` con las entradas válidas y el número de líneas descartadas.
4. **`escribirResumen(destino, porFichero, descartadas)`**: escribe `resumen.txt` con:
   - Una línea por fichero: `"%-14s %2d entradas · errores: %d%n"`.
   - El total de entradas válidas y de líneas descartadas.
   - Cuántas hay de cada nivel (un `EnumMap` con los tres niveles).
   - Los errores por módulo (un `TreeMap`).
   - El primer error encontrado.
5. **`copiarConErrores(porFichero, destino)`**: crea la carpeta `errores` y copia en ella los ficheros que tienen **al menos un** `ERROR`.
6. En el `main`: lista, lee (si un fichero falla, avisa y sigue con los demás), escribe el resumen, muéstralo y copia los ficheros con errores.

## Salida esperada

```
Ficheros .log: [lunes.log, martes.log, miercoles.log]
=== RESUMEN DE LOGS ===
lunes.log       4 entradas · errores: 1
martes.log      3 entradas · errores: 0
miercoles.log   4 entradas · errores: 2
Total: 11 entradas válidas · 2 líneas descartadas
Por nivel: {INFO=6, AVISO=2, ERROR=3}
Errores por módulo: {almacen=1, pagos=1, web=1}
Primer error: 2026-11-09 09:15:02 [pagos] Tarjeta rechazada
Copiados a errores/: [lunes.log, miercoles.log]
¿Existe errores/martes.log? false
```

Las 2 líneas descartadas son `línea corrupta sin formato` (martes) y la de nivel `DEBUG` (miércoles).

## Pistas

<details>
<summary>Pista 1</summary>

`split(" ", 5)` divide como mucho en 5 trozos: el quinto es "todo lo demás", así que el mensaje conserva sus espacios.

```java
"2026-11-10 09:15:02 ERROR [pagos] Tarjeta rechazada".split(" ", 5)
// → [2026-11-10, 09:15:02, ERROR, [pagos], Tarjeta rechazada]
```

</details>

<details>
<summary>Pista 2</summary>

`Files.list` y `Files.lines` devuelven streams que mantienen el fichero o la carpeta abiertos: van siempre en un try-with-resources. Para no tener problemas, recoge el resultado en una lista dentro del `try` y trabaja con la lista después.

</details>

<details>
<summary>Pista 3</summary>

Para que el `EnumMap` tenga los tres niveles aunque alguno no aparezca, recorre `Nivel.values()` y cuenta cada uno. Para los errores por módulo: `filter(nivel == ERROR)` y `groupingBy(Entrada::modulo, TreeMap::new, Collectors.counting())`.

</details>

<details>
<summary>Pista 4</summary>

Un `TreeMap<Path, List<Entrada>>` mantiene los ficheros ordenados por nombre: `Path` implementa `Comparable`. Con `porFichero.values().stream().flatMap(List::stream)` obtienes todas las entradas de todos los ficheros en un solo stream.

</details>

## Cómo ejecutarlo

```bash
java Ej20_05_AnalizadorDeLogs.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-analizador-de-logs/SOLUCION.md).
