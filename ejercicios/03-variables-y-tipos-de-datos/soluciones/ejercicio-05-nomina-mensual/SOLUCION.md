# Solución · Ejercicio 05 · Nómina mensual

[⬅️ Enunciado](../../ejercicio-05-nomina-mensual/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

El orden es: **convertir → calcular → mostrar**. Antes de programar, conviene decidir el tipo de cada dato:

| Variable | Tipo | Motivo |
|---|---|---|
| `horas` | `int` | Horas completas |
| `precioHora`, `bruto`, `retencion`, `neto`, `netoAnual` | `double` | Dinero con decimales |
| `eurosCompletos` | `int` | Resultado de cortar |
| `netoRedondeado`, `centimosAnuales`, `porcentaje` | `long` | Lo que devuelve `Math.round` |
| Constantes | `final double` / `final int` | No cambian |

## Código explicado

**Constantes y conversión:**

```java
final double RETENCION_IRPF = 0.15;
final int PLUS_CATEGORIA_B = 50;
final int PAGAS_ANUALES = 14;

int horas = Integer.parseInt(horasTexto);              // "160"  → 160
double precioHora = Double.parseDouble(precioHoraTexto); // "12.5" → 12.5
```

**Cálculos** (se usan `var` donde el tipo es evidente):

```java
double bruto = horas * precioHora + PLUS_CATEGORIA_B;  // 160 * 12.5 + 50 = 2050.0
var retencion = bruto * RETENCION_IRPF;                // double: 307.5
var neto = bruto - retencion;                          // double: 1742.5
```

`horas * precioHora` mezcla `int` y `double`, así que el resultado es `double`. Al sumarle `50` (`int`) sigue siendo `double`.

**Cortar frente a redondear:**

```java
int eurosCompletos = (int) neto;           // 1742
long netoRedondeado = Math.round(neto);    // 1743 (x.5 redondea hacia arriba)
```

**Anual y céntimos:**

```java
double netoAnual = neto * PAGAS_ANUALES;               // 24395.0
long centimosAnuales = Math.round(netoAnual * 100);    // 2439500
```

Trabajar en céntimos con un entero es una técnica real para evitar la imprecisión de los `double` con el dinero. Usamos `long` porque en una empresa grande el total de céntimos podría pasar de 2 100 millones.

**El porcentaje:**

```java
long porcentaje = Math.round(RETENCION_IRPF * 100);   // 15
```

Sin `Math.round`, `RETENCION_IRPF * 100` es el `double` `15.0`. Con `(int)` también saldría 15 aquí, pero con otros porcentajes el resultado puede quedar justo por debajo: `0.29 * 100` da `28.999999999999996`, y `(int)` lo dejaría en 28. Redondear es lo seguro.

## Errores comunes

- **Sumar los textos:** `horasTexto * precioHoraTexto` no compila; hay que convertir primero.
- **Declarar `bruto` como `int`:** error `possible lossy conversion from double to int`.
- **`int netoRedondeado = Math.round(neto);`:** error, `Math.round` devuelve `long`.
- **Calcular los céntimos con `(long) (netoAnual * 100)`:** funciona con estos datos, pero puede perder un céntimo con otros.

## Código completo

📄 [Sol03_05_NominaMensual.java](Sol03_05_NominaMensual.java)
