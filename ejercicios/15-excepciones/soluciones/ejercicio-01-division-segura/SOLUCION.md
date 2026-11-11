# Solución · Ejercicio 01 · División segura

[⬅️ Enunciado](../../ejercicio-01-division-segura/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Código explicado

```java
try {
    System.out.print("Dividendo: ");
    int dividendo = Integer.parseInt(teclado.nextLine().strip());
    System.out.print("Divisor: ");
    int divisor = Integer.parseInt(teclado.nextLine().strip());
    System.out.println(dividendo + " / " + divisor + " = " + dividendo / divisor + " (resto " + dividendo % divisor + ")");
} catch (NumberFormatException e) {
    System.out.println("✘ Eso no es un número entero: " + e.getMessage());
} catch (ArithmeticException e) {
    System.out.println("✘ No se puede dividir entre cero");
} finally {
    System.out.println("Fin de la operación");
}
```

| Caso | ¿Qué línea falla? | ¿Qué catch se ejecuta? |
|---|---|---|
| 17 y 4 | Ninguna | Ninguno |
| 17 y 0 | `dividendo / divisor` | `ArithmeticException` |
| "diecisiete" | El primer `parseInt` | `NumberFormatException` (el divisor ni se pide) |

`finally` se ejecuta en los **tres** casos.

## Otras formas de resolverlo

La división entre 0 se puede **evitar** en lugar de capturar: `if (divisor == 0) { ... } else { ... }`. Es incluso mejor práctica, porque se trata de un caso fácil de prever. Aquí la capturamos para practicar.

## Errores comunes

- Declarar `dividendo` dentro del `try` y usarlo después → no existe fuera.
- Un solo `catch (Exception e)` para todo → el mensaje no puede distinguir los dos errores.

## Código completo

📄 [Sol15_01_DivisionSegura.java](Sol15_01_DivisionSegura.java)
