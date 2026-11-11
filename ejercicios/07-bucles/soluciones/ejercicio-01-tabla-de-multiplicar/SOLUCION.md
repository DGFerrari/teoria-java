# Solución · Ejercicio 01 · Tabla de multiplicar

[⬅️ Enunciado](../../ejercicio-01-tabla-de-multiplicar/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Código explicado

```java
for (int i = 1; i <= 10; i++) {
    System.out.printf("%2d x %2d = %2d%n", numero, i, numero * i);
}
```

| Pieza | Valor | Por qué |
|---|---|---|
| Inicialización | `int i = 1` | La tabla empieza en 1 |
| Condición | `i <= 10` | Incluye el 10 |
| Actualización | `i++` | De uno en uno |

`i` cumple dos papeles: **controla** el bucle y **forma parte** del cálculo (`numero * i`).

## Errores comunes

- `i < 10` → falta la línea del 10.
- `int i = 0` → aparece `7 x 0 = 0`.
- Con números de más cifras (tabla del 15), `%2d` se queda corto para el resultado: el ancho es un **mínimo**, así que no se corta, pero se descuadra. Puedes usar `%3d`.

## Código completo

📄 [Sol07_01_TablaDeMultiplicar.java](Sol07_01_TablaDeMultiplicar.java)
