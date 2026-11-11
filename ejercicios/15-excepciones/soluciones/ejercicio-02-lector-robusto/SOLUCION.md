# Solución · Ejercicio 02 · Lector robusto

[⬅️ Enunciado](../../ejercicio-02-lector-robusto/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Código explicado

```java
static int leerNota(Scanner teclado, String mensaje) {
    int nota = 0;
    boolean valida = false;
    while (!valida) {
        System.out.print(mensaje);
        String linea = teclado.nextLine().strip();
        try {
            nota = Integer.parseInt(linea);
            if (nota < 0 || nota > 10) {
                System.out.println("  ✘ La nota tiene que estar entre 0 y 10");
            } else {
                valida = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("  ✘ \"" + linea + "\" no es un número");
        }
    }
    return nota;
}
```

Dos tipos de error, dos herramientas:

| Error | ¿Se puede comprobar antes con un `if`? | Herramienta |
|---|---|---|
| No es un número | Difícil (habría que revisar carácter a carácter) | `try`/`catch` de `NumberFormatException` |
| Fuera de rango | Fácil | `if` |

La línea se guarda en `linea` **antes** del `try`, para poder mostrarla en el mensaje del `catch`.

Como el método valida por dentro, el `main` queda limpio: tres llamadas y una media, sin preocuparse de los errores.

## Errores comunes

- Leer con `nextInt()`: con texto, lanza `InputMismatchException` **y deja el texto en el teclado**, lo que provoca un bucle infinito si no se limpia.
- Poner el `while` dentro del `try` (en lugar del `try` dentro del `while`): al primer error se sale del bucle.
- `return` dentro del `try` para salir del bucle: en este repositorio usamos la bandera.

## Código completo

📄 [Sol15_02_LectorRobusto.java](Sol15_02_LectorRobusto.java)
