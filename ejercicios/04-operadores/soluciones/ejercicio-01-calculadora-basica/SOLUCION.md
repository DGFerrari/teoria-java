# Solución · Ejercicio 01 · Calculadora básica

[⬅️ Enunciado](../../ejercicio-01-calculadora-basica/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Código explicado

```java
int suma = a + b;                       // 27
int resta = a - b;                      // 19
int multiplicacion = a * b;             // 92
int cociente = a / b;                   // 5   (int / int → sin decimales)
int resto = a % b;                      // 3
double division = (double) a / b;       // 5.75
```

La división entera y el resto son las dos caras de la misma operación:

```
  23 | 4
  -20  5   ← cociente
   3       ← resto
```

Por eso siempre se cumple `cociente * b + resto == a`:

```java
System.out.println("Comprobación: " + cociente + " * " + b + " + " + resto + " = " + (cociente * b + resto));
```

Los paréntesis del final son necesarios: sin ellos, el `+` uniría los números como texto.

## Errores comunes

- `double division = a / b;` → guarda `5.0`. La división se hace en `int` antes de convertirse.
- `(double) (a / b)` → también `5.0`: el casting llega tarde, cuando ya se han perdido los decimales.
- Mostrar `"Suma: " + a + b` → `Suma: 234`.

## Código completo

📄 [Sol04_01_CalculadoraBasica.java](Sol04_01_CalculadoraBasica.java)
