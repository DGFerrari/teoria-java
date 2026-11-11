# Solución · Ejercicio 04 · Métodos de pago

[⬅️ Enunciado](../../ejercicio-04-metodos-de-pago/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Hay tres niveles, cada uno con su responsabilidad:

| Nivel | Responsabilidad |
|---|---|
| `MetodoPago` (interfaz) | **Qué** puede hacer cualquier forma de pago, más dos utilidades (`costeTotal`, `elMasBarato`) |
| `PagoConSaldo` (abstracta) | **Cómo** funcionan los pagos con saldo: comprobar y descontar |
| `PayPal`, `Bizum` | **Qué les hace distintos**: su comisión y su límite |

La `Tarjeta` no tiene saldo, sino crédito: por eso implementa la interfaz directamente, sin pasar por `PagoConSaldo`.

## Código explicado

**Método `static` en la interfaz** (trabaja con cualquier `MetodoPago`):

```java
static MetodoPago elMasBarato(MetodoPago[] metodos, double importe) {
    MetodoPago elegido = null;
    for (MetodoPago m : metodos) {
        if (m.puedePagar(importe)
                && (elegido == null || m.calcularComision(importe) < elegido.calcularComision(importe))) {
            elegido = m;
        }
    }
    return elegido;
}
```

**La parte común, una sola vez:**

```java
@Override
public boolean puedePagar(double importe) {
    return importe > 0 && importe <= limitePorOperacion() && costeTotal(importe) <= saldo;
}

@Override
public boolean pagar(double importe) {
    boolean posible = puedePagar(importe);
    if (posible) {
        saldo -= costeTotal(importe);
    }
    return posible;
}
```

`costeTotal` es el `default` de la interfaz y llama a `calcularComision`, que **no** está implementado en `PagoConSaldo`: lo pone cada subclase. Por eso `PagoConSaldo` tiene que ser abstracta.

**Bizum: solo lo específico:**

```java
@Override
public double calcularComision(double importe) {
    return 0;
}

@Override
protected double limitePorOperacion() {
    return 1000;
}
```

## Traza

| Compra | Bizum (saldo) | PayPal (saldo 300) | Visa (disponible) | Elegido |
|---|---|---|---|---|
| 49,99 | ✔ 500 → comisión 0 | ✔ comisión 2,05 | ✔ comisión 0,75 | Bizum |
| 250 | ✔ 450,01 → 0 | ✔ 8,85 | ✔ 3,75 | Bizum |
| 800 | ✘ saldo 200,01 | ✘ | ✔ 12,00 | Visa |
| 1200 | ✘ límite y saldo | ✘ | ✘ 1218 > 688 | Ninguno |

## Para mejorar

Si mañana se añade `ApplePay`, basta con escribir una clase nueva. `elMasBarato` y el `main` funcionarán sin tocar nada: es la ventaja de programar contra interfaces.

## Código completo

📄 [Sol14_04_MetodosDePago.java](Sol14_04_MetodosDePago.java)
