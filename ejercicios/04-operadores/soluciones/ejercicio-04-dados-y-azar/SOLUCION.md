# Solución · Ejercicio 04 · Dados y azar

[⬅️ Enunciado](../../ejercicio-04-dados-y-azar/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Para cada valor aleatorio, antes de escribir el código, apunta su **rango** y comprueba si el límite superior está incluido:

| Valor | Rango | Llamada |
|---|---|---|
| Dado | 1 a 6 | `nextInt(1, 7)` |
| Número de carta | 1 a 12 | `nextInt(1, 13)` |
| Palo | 0 a 3 | `nextInt(4)` |
| Temperatura | −5.0 a 35.0 | `nextDouble(-5, 35)` |
| Código | 100 a 999 | `nextInt(999 - 100 + 1) + 100` |
| Moneda | true / false | `nextBoolean()` |

## Código explicado

**Dados:**

```java
int dado1 = random.nextInt(1, 7);
int dado2 = random.nextInt(1, 7);
int suma = dado1 + dado2;
boolean esDoble = dado1 == dado2;
boolean sumaPar = suma % 2 == 0;
```

**Código secreto con la fórmula general:**

```java
int codigo = random.nextInt(max - min + 1) + min;   // nextInt(900) + 100
```

`nextInt(900)` da de 0 a 899; al sumar 100, de 100 a 999. El `+ 1` es lo que hace que el `max` quede **incluido**.

**Separar cifras:**

```java
int centenas = codigo / 100;        // 582 / 100 = 5
int decenas = codigo / 10 % 10;     // 582 / 10 = 58 → 58 % 10 = 8
int unidades = codigo % 10;         // 582 % 10 = 2
```

En `codigo / 10 % 10` no hacen falta paréntesis: `/` y `%` tienen la misma prioridad y se evalúan de izquierda a derecha.

**Comprobaciones:**

```java
boolean dadosEnRango = dado1 >= 1 && dado1 <= 6 && dado2 >= 1 && dado2 <= 6;
boolean temperaturaEnRango = temperatura >= -5 && temperatura < 35;
```

Comprobar rangos así es una técnica real para **probar** programas aleatorios: no sabes qué número saldrá, pero sí qué propiedades debe cumplir.

Detalle: al redondear a un decimal, una temperatura de 34.97 se convierte en 35.0. Por eso comprobamos el rango con la temperatura **original** y usamos la redondeada solo para mostrarla.

## Errores comunes

- `nextInt(6)` para un dado → puede salir 0 y nunca 6.
- `nextInt(1, 6)` → nunca sale 6.
- `nextInt(max - min) + min` (sin `+ 1`) → nunca sale 999.
- Crear `new Random()` para cada número: funciona, pero es innecesario.

## Código completo

📄 [Sol04_04_DadosYAzar.java](Sol04_04_DadosYAzar.java)
