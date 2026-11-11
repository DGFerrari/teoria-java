# Solución · Ejercicio 03 · Calculadora con switch

[⬅️ Enunciado](../../ejercicio-03-calculadora-con-switch/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Tres decisiones diferentes, con la herramienta más adecuada para cada una:

| Decisión | Herramienta | Motivo |
|---|---|---|
| ¿Qué operación? | `switch` | Una variable comparada con valores exactos |
| ¿Se divide entre 0? | `if` dentro del caso | Condición dentro de un caso concreto |
| ¿Con o sin decimales? | Ternario | Elegir entre dos valores |

## Código explicado

**El switch** (como instrucción, porque algunos casos no producen resultado):

```java
switch (operador) {
    case '+' -> resultado = a + b;
    case '-' -> resultado = a - b;
    case '*' -> resultado = a * b;
    case '/', '%' -> {
        if (b == 0) {
            System.out.println("Error: no se puede dividir entre 0");
            hayError = true;
        } else {
            resultado = operador == '/' ? a / b : a % b;
        }
    }
    case '^' -> resultado = Math.pow(a, b);
    default -> {
        System.out.println("Operador no válido: " + operador);
        hayError = true;
    }
}
```

- `/` y `%` comparten la comprobación del 0, así que van en el mismo `case` separados por coma. Dentro, un ternario decide cuál de las dos operaciones hacer.
- Con `double`, `a / 0` no da error (da `Infinity`), así que **tenemos que comprobarlo nosotros**.

**El formato:**

```java
String formatoA = a == Math.floor(a) ? "%.0f" : "%.2f";
```

`Math.floor(8.0)` es `8.0`, igual al número: es entero. `Math.floor(3.125)` es `3.0`, distinto: tiene decimales. Se elige un formato para `a`, otro para `b` y otro para el resultado, y con `String.format` se convierte cada número en texto. Cuando aprendas métodos (tema 10), podrás escribir esta lógica una sola vez y reutilizarla.

## Errores comunes

- `case "+"` con comillas dobles: es un `String`, no un `char` → error de compilación.
- Olvidar `hayError = true` → se muestra el error **y además** `a / b = 0`.
- Comprobar `b == 0` fuera del `switch`, para todas las operaciones: `5 + 0` daría error sin motivo.

## Código completo

📄 [Sol06_03_CalculadoraConSwitch.java](Sol06_03_CalculadoraConSwitch.java)
