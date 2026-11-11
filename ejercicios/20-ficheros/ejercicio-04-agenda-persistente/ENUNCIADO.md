# Ejercicio 04 · Agenda persistente

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** guardar y cargar el estado de un objeto, `Files.exists` para la primera ejecución, CSV con cabecera, copia de seguridad con `Files.copy` y `REPLACE_EXISTING` + `record`, `TreeMap`

## Enunciado

Hasta ahora, todo lo que guardaban tus programas (como la agenda del tema 13) se perdía al terminar. Ahora la agenda se va a **guardar en un fichero** y a **recuperar** en la siguiente ejecución. Completa [`Ej20_04_AgendaPersistente.java`](Ej20_04_AgendaPersistente.java):

1. **`Contacto`** (record): `aCsv()` y `desdeCsv(linea)` con el formato `nombre;telefono;email`.
2. **`Agenda`**: guarda los contactos en un `TreeMap` por nombre.
   - `agregar(c)`: `false` si ya hay un contacto con ese nombre.
   - `eliminar(nombre)`, `cantidad()` y `todos()`.
   - `static cargar(ruta)`: si el fichero **no existe** (primera vez que se usa el programa), devuelve una agenda vacía; si existe, la rellena saltando la cabecera.
   - `guardar(ruta, copia)`: si ya había un fichero, primero lo **copia** en `copia` (sustituyendo la copia anterior); después escribe la cabecera y un contacto por línea.
3. En el `main`, simula **tres ejecuciones** del programa. En cada una, la agenda se crea **de cero** con `Agenda.cargar(fichero)`: la única forma de que los datos pasen de una sesión a otra es el fichero.

| Sesión | Qué hace |
|---|---|
| 1 | Carga (no hay fichero), añade Luis, Ana y Marta, y guarda |
| 2 | Carga, añade a Pablo, intenta añadir otra Ana, elimina a Luis y guarda |
| 3 | Carga y muestra los contactos, el fichero y la copia de seguridad |

## Salida esperada

```
=== Sesión 1 ===
Cargados: 0 contactos (no había fichero)
Guardados: 3 · ¿hay copia? false
=== Sesión 2 ===
Cargados: 3 contactos
¿Añadido Pablo? true
¿Añadida Ana otra vez? false
¿Eliminado Luis? true
Guardados: 3 · ¿hay copia? true
=== Sesión 3 ===
  Ana · 600123456 · ana@correo.es
  Marta · 622333444 · marta@correo.es
  Pablo · 633444555 · pablo@correo.es
--- agenda.csv ---
nombre;telefono;email
Ana;600123456;ana@correo.es
Marta;622333444;marta@correo.es
Pablo;633444555;pablo@correo.es
--- agenda.bak (versión anterior) ---
nombre;telefono;email
Ana;600123456;ana@correo.es
Luis;611222333;luis@correo.es
Marta;622333444;marta@correo.es
```

Los datos de los contactos: Luis `611222333` `luis@correo.es`, Ana `600123456` `ana@correo.es`, Marta `622333444` `marta@correo.es`, Pablo `633444555` `pablo@correo.es`. La "otra Ana" puede tener cualquier teléfono: no se añade.

## Pistas

<details>
<summary>Pista 1</summary>

Que el fichero no exista la primera vez **no es un error**, es lo normal: compruébalo con `Files.exists` en lugar de capturar `NoSuchFileException`.

</details>

<details>
<summary>Pista 2</summary>

```java
if (Files.exists(ruta)) {
    Files.copy(ruta, copia, StandardCopyOption.REPLACE_EXISTING);
}
```

Sin `REPLACE_EXISTING`, la segunda vez que se guarda, `copy` lanzaría `FileAlreadyExistsException`.

</details>

<details>
<summary>Pista 3</summary>

Como los contactos están en un `TreeMap`, al guardarlos recorriendo `contactos.values()` salen ordenados por nombre, aunque se añadieran en otro orden.

</details>

## Cómo ejecutarlo

```bash
java Ej20_04_AgendaPersistente.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-agenda-persistente/SOLUCION.md).
