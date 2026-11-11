# Solución · Ejercicio 04 · Validador de contraseñas

[⬅️ Enunciado](../../ejercicio-04-validador-de-contrasenias/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Hay dos niveles de bucle:

| Bucle | Tipo | Para qué |
|---|---|---|
| Pedir contraseñas | `do-while` | Al menos un intento; repetir mientras no sea válida |
| Recorrer la contraseña | for-each | Activar las banderas de cada tipo de carácter |

Con **un único recorrido** se averigua todo lo necesario sobre los caracteres. Las reglas de longitud y de usuario no necesitan recorrido: se comprueban con `length()` y `contains`.

## Código explicado

**Banderas en un único recorrido:**

```java
boolean tieneMayuscula = false;
boolean tieneMinuscula = false;
boolean tieneDigito = false;
boolean tieneSimbolo = false;
boolean tieneEspacio = false;

for (char c : contrasenia.toCharArray()) {
    if (Character.isUpperCase(c)) {
        tieneMayuscula = true;
    } else if (Character.isLowerCase(c)) {
        tieneMinuscula = true;
    } else if (Character.isDigit(c)) {
        tieneDigito = true;
    } else if (Character.isWhitespace(c)) {
        tieneEspacio = true;
    } else {
        tieneSimbolo = true;          // Ni letra, ni dígito, ni espacio
    }
}
```

Una bandera empieza en `false` y pasa a `true` en cuanto aparece **un** carácter de ese tipo. Una vez en `true`, ya no vuelve a `false`.

**Acumular los errores:**

```java
StringBuilder errores = new StringBuilder();
if (contrasenia.length() < LONGITUD_MINIMA) {
    errores.append("  - Debe tener al menos ").append(LONGITUD_MINIMA).append(" caracteres\n");
}
if (!tieneMayuscula) {
    errores.append("  - Falta una letra mayúscula\n");
}
// ... resto de reglas ...
if (contrasenia.toLowerCase().contains(usuario.toLowerCase())) {
    errores.append("  - No puede contener el nombre de usuario\n");
}
valida = errores.length() == 0;
```

Son `if` **sueltos** (no `else if`) porque queremos comprobar **todas** las reglas, no solo la primera que falle.

El `StringBuilder` cumple dos funciones: guarda los mensajes y, con su longitud, nos dice si ha habido algún error. No hace falta otra bandera.

## Errores comunes

- Usar `else if` entre las reglas → solo se muestra el primer error.
- `contrasenia.contains(usuario)` sin pasar a minúsculas → `Ana12345!` se aceptaría con el usuario `ana`.
- Leer la contraseña con `next()` → se cortaría en el primer espacio, y la regla de "sin espacios" nunca fallaría.

## Código completo

📄 [Sol09_04_ValidadorDeContrasenias.java](Sol09_04_ValidadorDeContrasenias.java)
