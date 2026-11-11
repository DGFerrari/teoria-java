# Solución · Ejercicio 02 · Suma de pares

[⬅️ Enunciado](../../ejercicio-02-suma-de-pares/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

| Variable | Patrón | Inicio | En cada par |
|---|---|---|---|
| `suma` | Acumulador | 0 | `+= i` |
| `cantidad` | Contador | 0 | `++` |

El contador sirve para dos cosas: contar los pares **y** saber si el número actual es el primero que mostramos.

## Código explicado

```java
for (int i = 1; i <= n; i++) {
    if (i % 2 == 0) {
        if (cantidad > 0) {
            System.out.print(" + ");    // Separador ANTES de cada número salvo el primero
        }
        System.out.print(i);
        suma += i;
        cantidad++;
    }
}
```

Traza con `N = 6`:

| `i` | ¿Par? | `cantidad` antes | Se muestra | `suma` | `cantidad` después |
|---|---|---|---|---|---|
| 1 | No | 0 | — | 0 | 0 |
| 2 | Sí | 0 | `2` | 2 | 1 |
| 3 | No | 1 | — | 2 | 1 |
| 4 | Sí | 1 | ` + 4` | 6 | 2 |
| 5 | No | 2 | — | 6 | 2 |
| 6 | Sí | 2 | ` + 6` | 12 | 3 |

Después del bucle:

```java
if (cantidad > 0) {
    System.out.println(" = " + suma);
    System.out.println("Hay " + cantidad + " números pares entre 1 y " + n);
} else {
    System.out.println("No hay números pares entre 1 y " + n);
}
```

## Otras formas de resolverlo

Un `for (int i = 2; i <= n; i += 2)` recorre directamente los pares y no necesita el `if`. Es más eficiente, pero el enunciado pedía practicar el `%`.

También existe una fórmula: la suma de los `k` primeros pares es `k × (k + 1)`. Con N = 10, k = 5 → 30.

## Errores comunes

- Mostrar el `+` **después** de cada número → `2 + 4 + 6 + 8 + 10 + = 30`.
- Usar `println` dentro del bucle → un número por línea.
- Mostrar el resultado dentro del bucle → aparece varias veces.

## Código completo

📄 [Sol07_02_SumaDePares.java](Sol07_02_SumaDePares.java)
