# Solución · Ejercicio 01 · Saludo personalizado

[⬅️ Enunciado](../../ejercicio-01-saludo-personalizado/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

| Entrada | Proceso | Salida |
|---|---|---|
| nombre (texto), edad (entero) | edad + 10, edad × 365 | saludo y dos frases |

## Código explicado

```java
System.out.print("¿Cuántos años tienes? ");
int edad = teclado.nextInt();

int edadEnDiezAnios = edad + 10;
int diasVividos = edad * 365;

System.out.printf("Hola, %s.%n", nombre);
System.out.printf("Dentro de 10 años tendrás %d años.%n", edadEnDiezAnios);
System.out.printf("Has vivido aproximadamente %,d días.%n", diasVividos);
```

- `print` (sin `ln`) en la pregunta deja el cursor en la misma línea, y lo que escribe el usuario aparece al lado.
- `%,d` añade el separador de miles según la configuración del sistema: `5.475` en español, `5,475` en inglés.
- Cada `printf` termina en `%n`; sin él, todo saldría en una sola línea.

## Errores comunes

- Leer la edad con `nextLine()` y guardarla en un `int` → error de compilación (`String cannot be converted to int`).
- Escribir `quince` cuando se pide la edad → `InputMismatchException`.
- Leer la edad **antes** que el nombre (`nextInt` y luego `nextLine`) → el nombre sale vacío. Lo resolverás en el ejercicio 03.

## Código completo

📄 [Sol05_01_SaludoPersonalizado.java](Sol05_01_SaludoPersonalizado.java)
