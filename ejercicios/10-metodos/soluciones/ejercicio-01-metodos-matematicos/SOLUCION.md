# Solución · Ejercicio 01 · Métodos matemáticos

[⬅️ Enunciado](../../ejercicio-01-metodos-matematicos/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Código explicado

```java
static double areaRectangulo(double base, double altura) {
    return base * altura;
}

static double perimetroRectangulo(double base, double altura) {
    return 2 * (base + altura);
}

static boolean esMultiplo(int numero, int divisor) {
    return numero % divisor == 0;
}

static int maximoDeTres(int a, int b, int c) {
    int maximo = a;
    if (b > maximo) {
        maximo = b;
    }
    if (c > maximo) {
        maximo = c;
    }
    return maximo;
}

static double celsiusAFahrenheit(double celsius) {
    return celsius * 9 / 5 + 32;
}
```

- Ninguno de estos métodos **muestra** nada: solo **calculan y devuelven**. Así se pueden usar en cualquier contexto (mostrar, guardar, comparar...).
- En `celsiusAFahrenheit` no hay problema de división entera, porque `celsius` es `double`.
- `maximoDeTres` usa el mismo patrón que el máximo de un array: empezar con el primero y compararlo con los demás. La alternativa `Math.max(a, Math.max(b, c))` también es correcta.

## Errores comunes

- Escribir `System.out.println(base * altura);` en lugar de `return`: el método seguiría devolviendo 0.
- `if (numero % divisor == 0) return true; else return false;` funciona, pero es una forma larga de escribir `return numero % divisor == 0;`.
- Iniciar el máximo en 0: con tres números negativos devolvería 0.

## Código completo

📄 [Sol10_01_MetodosMatematicos.java](Sol10_01_MetodosMatematicos.java)
