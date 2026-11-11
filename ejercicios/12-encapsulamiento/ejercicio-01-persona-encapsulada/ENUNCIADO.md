# Ejercicio 01 · Persona encapsulada

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** atributos `private`, getters, setters con validación, constructor que reutiliza los setters

## Enunciado

Completa la clase `Persona` de [`Ej12_01_PersonaEncapsulada.java`](Ej12_01_PersonaEncapsulada.java):

| Atributo | Regla |
|---|---|
| `nombre` | No puede ser `null` ni estar vacío (solo espacios). Se guarda sin espacios alrededor. |
| `edad` | Entre 0 y 150 |
| `email` | Tiene que contener una `@` |

1. Los tres atributos, `private`.
2. Getters de los tres.
3. Setters que **solo** cambian el valor si es válido. Si no lo es, muestran `  ⚠ <dato> no válido: <valor>` y conservan el anterior.
4. El constructor usa los setters. Para que el objeto nunca quede a medias, da antes unos valores por defecto: `"Sin nombre"`, `0` y `"sin-email@ejemplo.com"`.

El `main` ya está hecho.

## Salida esperada

```
Ana García (25 años) - ana@correo.com
  ⚠ Edad no válida: -3
  ⚠ Email no válido: correo-sin-arroba
  ⚠ Nombre no válido: "   "
Ana García (26 años) - ana.garcia@correo.com
  ⚠ Nombre no válido: ""
  ⚠ Edad no válida: 200
Sin nombre (0 años) - luis@correo.com
```

## Pistas

<details>
<summary>Pista 1</summary>

```java
public void setEdad(int edad) {
    if (edad >= 0 && edad <= 150) {
        this.edad = edad;
    } else {
        System.out.println("  ⚠ Edad no válida: " + edad);
    }
}
```

</details>

<details>
<summary>Pista 2</summary>

En el constructor, primero los valores por defecto y después los setters:

```java
this.nombre = "Sin nombre";
...
setNombre(nombre);
```

</details>

## Cómo ejecutarlo

```bash
java Ej12_01_PersonaEncapsulada.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-persona-encapsulada/SOLUCION.md).
