# Ejercicio 05 · Gestor de biblioteca

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema: `Map` de objetos, `Map` cuyos valores son listas y colas, `ArrayDeque` como cola FIFO, `LinkedHashMap` frente a `TreeMap` + clases, `switch` y banderas

## Enunciado

Una biblioteca presta libros a sus socios. Cada socio puede tener **como mucho 2 libros** a la vez y, si el libro que quiere está prestado, entra en una **lista de espera**. Completa la clase `Biblioteca` de [`Ej16_05_GestorDeBiblioteca.java`](Ej16_05_GestorDeBiblioteca.java). La clase `Libro` y el `main` ya están hechos.

**Las tres colecciones de `Biblioteca`:**

| Atributo | Tipo | Para qué |
|---|---|---|
| `catalogo` | `LinkedHashMap<String, Libro>` | Buscar un libro por su ISBN. Conserva el orden en que se dieron de alta |
| `prestamos` | `TreeMap<String, List<String>>` | Los ISBN que tiene cada socio. Los socios salen en orden alfabético |
| `esperas` | `HashMap<String, Deque<String>>` | La cola de espera de cada libro (primero en llegar, primero en recibirlo) |

**`prestar(socio, isbn)`**: comprueba **en este orden** y devuelve el mensaje correspondiente:

| Caso | Mensaje |
|---|---|
| El ISBN no está en el catálogo | `✘ No existe el libro 978-9` |
| El socio ya tiene ese libro | `✘ Ana ya tiene «Dune»` |
| El socio ya tiene 2 libros | `✘ Ana ya tiene 2 libros` |
| El libro está disponible | Se le presta: `✔ Ana se lleva «Dune»` |
| Está prestado y el socio ya está en su cola | `✘ Ana ya está esperando «Dune»` |
| Está prestado | Entra en la cola: `⏳ Luis espera «Dune» (posición 1)` |

**`devolver(socio, isbn)`**: si el libro no existe o el socio no lo tiene (`✘ Luis no tiene «El Quijote»`), no hace nada. Si lo tiene, lo devuelve y el libro pasa **automáticamente** al primero de la cola. Si ese socio ya tiene 2 libros, **pierde su turno** (sale de la cola) y se prueba con el siguiente. Cada paso se añade al mensaje en una línea nueva.

**`mostrarInforme()`**: los préstamos de cada socio (con los títulos) y el estado de cada libro, incluida su cola si no está vacía.

## Salida esperada

```
 1. ✔ Ana se lleva «Dune»
 2. ⏳ Luis espera «Dune» (posición 1)
 3. ⏳ Marta espera «Dune» (posición 2)
 4. ✘ No existe el libro 978-9
 5. ✔ Ana se lleva «El Quijote»
 6. ✘ Ana ya tiene 2 libros
 7. ✔ Marta se lleva «1984»
 8. ✔ Marta se lleva «Matilda»
 9. ✘ Luis no tiene «El Quijote»
10. ✔ Ana devuelve «Dune»
   → Pasa a Luis, que estaba esperando
11. ⏳ Ana espera «Dune» (posición 2)
12. ✔ Luis devuelve «Dune»
   (Marta pierde su turno: ya tiene 2 libros)
   → Pasa a Ana, que estaba esperando
13. ✘ Ana ya tiene «Dune»
14. ⏳ Luis espera «1984» (posición 1)
15. ✘ Operación desconocida: RENOVAR
=== Préstamos por socio ===
Ana: El Quijote, Dune
Luis: (ninguno)
Marta: 1984, Matilda
=== Catálogo ===
978-1 · El Quijote · Miguel de Cervantes → Ana
978-2 · Dune · Frank Herbert → Ana
978-3 · 1984 · George Orwell → Marta · en espera: [Luis]
978-4 · Matilda · Roald Dahl → Marta
978-5 · Momo · Michael Ende → disponible
```

## Pistas

<details>
<summary>Pista 1</summary>

Un método privado que crea la lista del socio la primera vez evita repetir ese `if` por todo el código:

```java
private List<String> librosDe(String socio) {
    if (!prestamos.containsKey(socio)) {
        prestamos.put(socio, new ArrayList<>());
    }
    return prestamos.get(socio);
}
```

</details>

<details>
<summary>Pista 2</summary>

`libro.getPrestadoA()` puede ser `null`. Para comparar sin riesgo de `NullPointerException`, llama a `equals` sobre el texto que seguro que existe: `socio.equals(libro.getPrestadoA())`.

</details>

<details>
<summary>Pista 3</summary>

Atender la cola al devolver, sin `break`:

```java
boolean entregado = false;
while (!cola.isEmpty() && !entregado) {
    String siguiente = cola.poll();
    if (librosDe(siguiente).size() < MAX_PRESTAMOS) {
        ...
        entregado = true;
    } else {
        ...
    }
}
```

</details>

<details>
<summary>Pista 4</summary>

Para construir un mensaje de varias líneas, usa un `StringBuilder` (tema 09) y añade `"\n   → ..."`.

</details>

## Cómo ejecutarlo

```bash
java Ej16_05_GestorDeBiblioteca.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-gestor-de-biblioteca/SOLUCION.md).
