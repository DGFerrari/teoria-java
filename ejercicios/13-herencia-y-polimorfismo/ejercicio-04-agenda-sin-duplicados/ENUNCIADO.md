# Ejercicio 04 · Agenda sin duplicados

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** sobrescribir `equals(Object)`, `hashCode` y `toString`; `instanceof` con patrón; `==` frente a `equals`; usar `equals` para evitar duplicados

## Enunciado

En una agenda, dos contactos son **el mismo** si tienen el **mismo teléfono**, aunque estén escritos de forma distinta (`600 123 456`, `600-123-456`...) o con otro nombre.

Completa [`Ej13_04_AgendaSinDuplicados.java`](Ej13_04_AgendaSinDuplicados.java):

**`Contacto`**

- El constructor guarda el teléfono **normalizado**: sin espacios, guiones ni puntos (`"600 123 456"` → `"600123456"`).
- `equals(Object otro)`: `true` si el otro es un `Contacto` con el mismo teléfono normalizado.
- `hashCode()`: coherente con `equals` (usa `Objects.hash`).
- `toString()`: `"Ana García · 600123456"`.

**`Agenda`**

- `agregar(contacto)`: si ya hay un contacto **igual** (según `equals`), no lo añade y devuelve `false`.
- `contiene(contacto)`: busca con `equals`.
- `mostrar()`: lista numerada.

## Salida esperada

```
c1 == c2: false
c1.equals(c2): true
Mismo hashCode: true
c1.equals(null): false
c1.equals("600123456"): false
Añadir Ana: true
Añadir Luis: true
Añadir "Ana García" (mismo teléfono que Ana): false
Añadir Marta: true
Añadir Luis con otro formato: false
¿Está el 622.333.444? true
=== Agenda (3 contactos) ===
1. Ana · 600123456
2. Luis · +34611222333
3. Marta · 622333444
```

## Pistas

<details>
<summary>Pista 1</summary>

Normalizar: `telefono.replace(" ", "").replace("-", "").replace(".", "")`.

</details>

<details>
<summary>Pista 2</summary>

Estructura habitual de `equals`:

```java
@Override
public boolean equals(Object otro) {
    if (this == otro) {
        return true;
    }
    if (!(otro instanceof Contacto contacto)) {
        return false;
    }
    return telefono.equals(contacto.telefono);
}
```

</details>

<details>
<summary>Pista 3</summary>

El parámetro de `equals` **tiene que ser** `Object`. Si lo declaras como `Contacto`, `@Override` dará un error, y sin `@Override` estarías sobrecargando (y `c1.equals("texto")` usaría el de `Object`).

</details>

## Cómo ejecutarlo

```bash
java Ej13_04_AgendaSinDuplicados.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-agenda-sin-duplicados/SOLUCION.md).
