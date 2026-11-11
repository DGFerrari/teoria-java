# Ejercicio 03 · Boletín desde CSV

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** leer un CSV saltando la cabecera, convertir cada línea en un `record`, tolerar líneas incorrectas, escribir un informe con `PrintWriter`/`printf` y un CSV con `Files.write`

## Enunciado

Un profesor tiene las notas en `notas.csv` (el `main` lo crea). Algunas líneas tienen errores. Completa [`Ej20_03_BoletinDesdeCsv.java`](Ej20_03_BoletinDesdeCsv.java):

```
nombre;matematicas;lengua;ingles
Ana;8.5;7;9
Luis;4;5.5;3.5
Marta;9.25;8.75;10
Pablo;siete;6;8
Sara;6;4.5;5
Hugo;5;6
```

1. **`Alumno.desdeCsv(linea)`**: convierte una línea en un alumno. Si no tiene 4 campos, lanza `IllegalArgumentException("faltan campos")`; si una nota no es un número, `parseDouble` lanzará `NumberFormatException`.
2. **`leerAlumnos(ruta)`**: lee todas las líneas menos la cabecera. Una línea incorrecta **no detiene** la lectura: se avisa indicando su número de línea en el fichero (la cabecera es la línea 1) y se sigue.
3. **`escribirBoletin(destino, alumnos)`**: un informe de texto con `PrintWriter`. Formatos: `"%-8s %5s %5s %5s %6s%n"` para la cabecera y `"%-8s %5.2f %5.2f %5.2f %6.2f %s%n"` para cada alumno (con `✔` o `✘`).
4. **`escribirAprobados(destino, alumnos)`**: un CSV `nombre;media` solo con los aprobados (media ≥ 5), con la media redondeada a 2 decimales y con **punto decimal**, para que otro programa pueda leerlo.
5. En el `main`, muestra el contenido de los dos ficheros generados.

## Salida esperada

```
⚠ Línea 5 ignorada: nota no válida (Pablo;siete;6;8)
⚠ Línea 7 ignorada: faltan campos (Hugo;5;6)
Alumnos leídos: 4
--- boletin.txt ---
=== BOLETÍN DE NOTAS ===
Alumno    Mat. Leng. Ingl.  Media
Ana       8,50  7,00  9,00   8,17 ✔
Luis      4,00  5,50  3,50   4,33 ✘
Marta     9,25  8,75 10,00   9,33 ✔
Sara      6,00  4,50  5,00   5,17 ✔
Media de la clase: 6,75
--- aprobados.csv ---
nombre;media
Ana;8.17
Marta;9.33
Sara;5.17
```

Fíjate en la diferencia: el **boletín** es para personas (coma decimal, columnas alineadas); el **CSV** es para programas (punto decimal, separador fijo).

## Pistas

<details>
<summary>Pista 1</summary>

Recorre las líneas con un índice que empiece en 1 para saltar la cabecera. Así también sabes el número de línea para el aviso (`i + 1`).

</details>

<details>
<summary>Pista 2</summary>

`NumberFormatException` es una `IllegalArgumentException`: captúrala primero para dar el mensaje "nota no válida".

</details>

<details>
<summary>Pista 3</summary>

```java
try (PrintWriter salida = new PrintWriter(Files.newBufferedWriter(destino))) {
    salida.println("=== BOLETÍN DE NOTAS ===");
    salida.printf(...);
}
```

</details>

<details>
<summary>Pista 4</summary>

Para redondear a 2 decimales sin `printf`: `Math.round(media * 100) / 100.0`. Al concatenarlo con `+` se escribe con punto.

</details>

## Cómo ejecutarlo

```bash
java Ej20_03_BoletinDesdeCsv.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-boletin-desde-csv/SOLUCION.md).
