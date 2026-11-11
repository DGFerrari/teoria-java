# Solución · Ejercicio 05 · Cajero automático

[⬅️ Enunciado](../../ejercicio-05-cajero-automatico/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

El programa se divide en bloques que ya has resuelto por separado:

| Bloque | Técnica | Visto en |
|---|---|---|
| Cantidad aleatoria | `nextInt(1, MAXIMO + 1)` | Ejercicio 04 |
| Desglose | `/` y `%` en cascada | Ejercicio 02 |
| Dinero en céntimos | `long` + `Math.round` | Tema 03 |
| Actualizar saldo y contador | `-=` y `++` | Teoría, sección 3 y 4 |
| Comprobaciones | Relacionales y lógicos | Ejercicio 03 |

## Traza del desglose (cantidad = 387)

| Pieza | Operación | Cuántas | Resto |
|---|---|---|---|
| 50 | `387 / 50`, `387 % 50` | 7 | 37 |
| 20 | `37 / 20`, `37 % 20` | 1 | 17 |
| 10 | `17 / 10`, `17 % 10` | 1 | 7 |
| 5 | `7 / 5`, `7 % 5` | 1 | 2 |
| 2 | `2 / 2`, `2 % 2` | 1 | 0 |
| 1 | `0` | 0 | — |

## Código explicado

**Desglose** reutilizando `resto` con `%=`:

```java
int billetes50 = cantidad / 50;
int resto = cantidad % 50;
int billetes20 = resto / 20;
resto %= 20;
// ... igual con 10, 5 y 2 ...
int monedas1 = resto;        // Lo que queda ya son monedas de 1
```

**Comisión en céntimos:**

```java
long comisionCentimos = Math.round(cantidad * 100 * PORCENTAJE_COMISION);   // 38700 * 0.02 = 774
```

**Validez antes de modificar el saldo:**

```java
long cargoTotalCentimos = cantidad * 100L + comisionCentimos;
boolean operacionValida = cantidad >= 1 && cantidad <= MAXIMO_RETIRADA && cargoTotalCentimos <= saldoCentimos;
```

Si la calculáramos después del `-=`, compararíamos con el saldo ya reducido y el resultado no tendría sentido.

**Actualizar estado:**

```java
saldoCentimos -= cargoTotalCentimos;   // 100000 - 39474 = 60526
operaciones++;
```

**Mostrar euros:**

```java
System.out.println("Comisión (2%): " + comisionCentimos / 100.0 + " euros");   // 7.74
System.out.println("Saldo restante: " + saldoCentimos / 100.0 + " euros");      // 605.26
```

Con `/ 100` (entero) saldría `605` y se perderían los céntimos.

**Las dos últimas preguntas:**

```java
boolean saldoBajo = saldoCentimos < 700 * 100;
boolean multiploDeDiez = cantidad % 10 == 0;
```

Fíjate en que 700 euros también se pasa a céntimos antes de comparar. Comparar euros con céntimos es un error lógico difícil de ver.

## ¿Por qué no usar double para el saldo?

Prueba a hacer `1000.0 - 387 - 7.74` en Java: el resultado puede mostrar algo como `605.2599999999999`. En los bancos reales nunca se usa `double` para el dinero; se usan enteros (céntimos) o `BigDecimal`.

## Errores comunes

- `cantidad * 100 * PORCENTAJE_COMISION` sin redondear → `double`, no se puede guardar en `long`.
- Restar la cantidad en euros de un saldo en céntimos (`saldoCentimos -= cantidad`).
- Olvidar el `+ 1` en el límite del aleatorio → nunca sale 500.

## Código completo

📄 [Sol04_05_CajeroAutomatico.java](Sol04_05_CajeroAutomatico.java)
