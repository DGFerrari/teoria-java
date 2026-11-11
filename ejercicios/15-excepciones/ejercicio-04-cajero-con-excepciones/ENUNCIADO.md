# Ejercicio 04 · Cajero con excepciones

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** excepciones propias, checked (`extends Exception`) frente a unchecked (`extends RuntimeException`), `throw`, `throws`, varios `catch`, `finally`

## Enunciado

Un cajero procesa una serie de retiradas con una tarjeta. Los errores **no se devuelven con mensajes ni con `boolean`**: se lanzan como excepciones. Completa [`Ej15_04_CajeroConExcepciones.java`](Ej15_04_CajeroConExcepciones.java):

**1. Tres excepciones propias** (como `static class` dentro de la clase principal):

| Excepción | Tipo | Dato que guarda | Mensaje |
|---|---|---|---|
| `SaldoInsuficienteException` | checked | `double faltan` | `Saldo insuficiente: faltan 250,00 €` |
| `PinIncorrectoException` | checked | `int intentosRestantes` | `PIN incorrecto. Intentos restantes: 2` |
| `TarjetaBloqueadaException` | unchecked | (solo el mensaje) | El que reciba el constructor |

**2. `Tarjeta.retirar(pin, cantidad)`** declara con `throws` las dos checked y aplica estas reglas en orden:

1. Si la tarjeta está bloqueada → `TarjetaBloqueadaException("Tarjeta bloqueada")`.
2. Si el PIN no coincide → suma un fallo. Al **tercer** fallo la tarjeta se bloquea y lanza `TarjetaBloqueadaException("Tarjeta bloqueada por demasiados intentos fallidos")`. Si aún no es el tercero, lanza `PinIncorrectoException` con los intentos que quedan.
3. PIN correcto → los fallos vuelven a 0.
4. Si la cantidad supera el saldo → `SaldoInsuficienteException(cantidad - saldo)`.
5. Si todo va bien, descuenta la cantidad.

**3. En el `main`**, procesa las operaciones (formato `pin;cantidad`). La cantidad se convierte con `Double.parseDouble`, que puede lanzar `NumberFormatException`. Usa un `catch` para cada tipo de error y un `finally` que cuente las operaciones procesadas. Cuando a `PinIncorrectoException` le quede 1 intento, muestra además un aviso (usa `getIntentosRestantes()`).

## Salida esperada

```
Op 1 [PIN 1234, 50] ✔ Retirados 50,00 €. Saldo: 250,00 €
Op 2 [PIN 1234, 500] ✘ Saldo insuficiente: faltan 250,00 €. Máximo disponible: 250,00 €
Op 3 [PIN 0000, 20] ✘ PIN incorrecto. Intentos restantes: 2
Op 4 [PIN 1234, abc] ✘ Cantidad no válida: abc
Op 5 [PIN 1111, 10] ✘ PIN incorrecto. Intentos restantes: 1
   ⚠ Último intento antes del bloqueo
Op 6 [PIN 2222, 10] ⛔ Tarjeta bloqueada por demasiados intentos fallidos
Op 7 [PIN 3333, 10] ⛔ Tarjeta bloqueada
Op 8 [PIN 1234, 10] ⛔ Tarjeta bloqueada
=== Operaciones procesadas: 8 | Correctas: 1 ===
Saldo final: 250,00 € | Tarjeta bloqueada: sí
```

Fíjate en la operación 4: el error ocurre **al convertir la cantidad**, antes de llamar a `retirar`, así que no cuenta como fallo de PIN.

## Pistas

<details>
<summary>Pista 1</summary>

Una excepción propia con un dato extra:

```java
static class PinIncorrectoException extends Exception {
    private final int intentosRestantes;

    public PinIncorrectoException(int intentosRestantes) {
        super("PIN incorrecto. Intentos restantes: " + intentosRestantes);
        this.intentosRestantes = intentosRestantes;
    }
    ...
}
```

</details>

<details>
<summary>Pista 2</summary>

Si escribes `throw new PinIncorrectoException(...)` sin añadir `throws` a la cabecera del método, el compilador te avisa: *unreported exception ... must be caught or declared to be thrown*. Con `TarjetaBloqueadaException` no pasa porque es unchecked.

</details>

<details>
<summary>Pista 3</summary>

Declara `pin` y `textoCantidad` **fuera** del `try` para poder usarlos dentro de los `catch`.

</details>

## Cómo ejecutarlo

```bash
java Ej15_04_CajeroConExcepciones.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-cajero-con-excepciones/SOLUCION.md).
