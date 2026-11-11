# Solución · Ejercicio 04 · Agenda sin duplicados

[⬅️ Enunciado](../../ejercicio-04-agenda-sin-duplicados/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

"¿Son iguales?" no tiene una única respuesta: **la decides tú** según el problema. Aquí, la identidad de un contacto es su teléfono. Para que la comparación funcione con formatos distintos, el teléfono se **normaliza** al crear el contacto (como las fracciones del tema 11): así `equals` solo tiene que comparar textos.

| Comparación | Qué mira | `c1` frente a `c2` |
|---|---|---|
| `c1 == c2` | ¿Es el **mismo objeto**? | `false` |
| `c1.equals(c2)` | ¿Representan **lo mismo**? (según nuestra regla) | `true` |

## Código explicado

**Normalizar en el constructor:**

```java
public Contacto(String nombre, String telefono) {
    this.nombre = nombre;
    this.telefono = telefono.replace(" ", "").replace("-", "").replace(".", "");
}
```

**equals, hashCode y toString:**

```java
@Override
public boolean equals(Object otro) {
    if (this == otro) {
        return true;
    }
    if (!(otro instanceof Contacto contacto)) {
        return false;                         // null, un String, otra clase...
    }
    return telefono.equals(contacto.telefono);
}

@Override
public int hashCode() {
    return Objects.hash(telefono);            // El MISMO atributo que en equals
}

@Override
public String toString() {
    return nombre + " · " + telefono;
}
```

- `instanceof` devuelve `false` con `null`, así que no hace falta comprobarlo aparte.
- El nombre **no** participa en `equals` ni en `hashCode`: dos contactos con distinto nombre y el mismo teléfono son iguales.

**La agenda reutiliza `equals`:**

```java
public boolean contiene(Contacto contacto) {
    boolean encontrado = false;
    for (int i = 0; i < cantidad && !encontrado; i++) {
        encontrado = contactos[i].equals(contacto);
    }
    return encontrado;
}

public boolean agregar(Contacto contacto) {
    boolean posible = cantidad < contactos.length && !contiene(contacto);
    if (posible) {
        contactos[cantidad] = contacto;
        cantidad++;
    }
    return posible;
}
```

## ¿Por qué hashCode, si no lo usamos?

Porque las colecciones de Java sí lo usan. En el [tema 16](../../../../teoria/16-colecciones/README.md) verás que un `HashSet<Contacto>` evita duplicados automáticamente... **solo** si `equals` y `hashCode` están bien escritos. Si dos objetos son `equals` pero tienen distinto `hashCode`, el `HashSet` los guardaría los dos.

## Errores comunes

- `public boolean equals(Contacto otro)` → no sobrescribe; `c1.equals("texto")` usaría el de `Object`.
- `hashCode` con `nombre` y `telefono` mientras `equals` solo usa `telefono` → dos objetos iguales con distinto `hashCode`.
- Comparar teléfonos con `==`.

## Código completo

📄 [Sol13_04_AgendaSinDuplicados.java](Sol13_04_AgendaSinDuplicados.java)
