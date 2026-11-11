# Solución · Ejercicio 02 · Tarifas de envío

[⬅️ Enunciado](../../ejercicio-02-tarifas-de-envio/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Dibuja los tramos en una recta:

```
   ❌    |  3.50  |  6.00  |  9.50  |  14.00  |   ❌
 ────────0────────1────────5────────10────────20─────────
```

Primero descartamos lo que no es válido; después, como los tramos van en orden, cada `else if` solo necesita el límite **superior**: si hemos llegado a esa línea, ya sabemos que el peso es mayor que el límite anterior.

## Código explicado

```java
if (peso <= 0) {
    System.out.println("Peso no válido");
} else if (peso > 20) {
    System.out.println("No se admiten paquetes de más de 20 kg");
} else {
    double precio;
    if (peso <= 1) {
        precio = 3.50;
    } else if (peso <= 5) {
        precio = 6.00;
    } else if (peso <= 10) {
        precio = 9.50;
    } else {
        precio = 14.00;
    }
    System.out.printf("Precio del envío: %.2f euros%n", precio);
}
```

Separar los errores del cálculo del precio tiene una ventaja: el `printf` aparece **una sola vez**. Dentro del `else`, Java comprueba que `precio` reciba valor en los cuatro caminos.

## Errores comunes

- Escribir `peso < 1` en lugar de `peso <= 1`: un paquete de 1 kg exacto pagaría 6 €.
- Escribir las condiciones completas (`peso > 1 && peso <= 5`): funciona, pero es redundante y más fácil equivocarse en algún límite.
- Poner los tramos en orden inverso sin cambiar las condiciones: `if (peso <= 20)` primero atraparía todos los pesos.

## Código completo

📄 [Sol06_02_TarifasDeEnvio.java](Sol06_02_TarifasDeEnvio.java)
