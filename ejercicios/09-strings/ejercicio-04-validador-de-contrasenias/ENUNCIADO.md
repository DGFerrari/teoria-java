# Ejercicio 04 · Validador de contraseñas

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** recorrer un texto, `Character`, `contains`, `toLowerCase`, banderas, `do-while`, `StringBuilder`

## Enunciado

Completa [`Ej09_04_ValidadorDeContrasenias.java`](Ej09_04_ValidadorDeContrasenias.java) para que pida un **nombre de usuario** y después una **contraseña**, repitiendo la contraseña hasta que cumpla **todas** estas reglas:

| Regla | Mensaje si no se cumple |
|---|---|
| Al menos 8 caracteres | `- Debe tener al menos 8 caracteres` |
| Al menos una mayúscula | `- Falta una letra mayúscula` |
| Al menos una minúscula | `- Falta una letra minúscula` |
| Al menos un dígito | `- Falta un número` |
| Al menos un símbolo (ni letra, ni dígito, ni espacio) | `- Falta un símbolo` |
| Sin espacios | `- No puede contener espacios` |
| No contiene el usuario (sin importar mayúsculas) | `- No puede contener el nombre de usuario` |

Si no es válida, muestra **todas** las reglas que fallan. Cuando sea válida, muestra cuántos intentos han hecho falta.

## Salida esperada

```
Usuario: ana
Contraseña: hola
  Contraseña no válida:
  - Debe tener al menos 8 caracteres
  - Falta una letra mayúscula
  - Falta un número
  - Falta un símbolo
Contraseña: Ana12345!
  Contraseña no válida:
  - No puede contener el nombre de usuario
Contraseña: Segura#2024
Contraseña válida tras 3 intentos
```

## Pistas

<details>
<summary>Pista 1</summary>

Recorre la contraseña **una vez** y usa una bandera por tipo de carácter:

```java
boolean tieneMayuscula = false;
...
for (char c : contrasenia.toCharArray()) {
    if (Character.isUpperCase(c)) {
        tieneMayuscula = true;
    }
    ...
}
```

</details>

<details>
<summary>Pista 2</summary>

Ve guardando los mensajes de error en un `StringBuilder`. Si al final está vacío (`length() == 0`), la contraseña es válida.

</details>

<details>
<summary>Pista 3</summary>

Para comprobar el usuario sin importar mayúsculas: `contrasenia.toLowerCase().contains(usuario.toLowerCase())`.

</details>

## Cómo ejecutarlo

```bash
java Ej09_04_ValidadorDeContrasenias.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-validador-de-contrasenias/SOLUCION.md).
