# Ejercicio 03 · Banco con static

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐
**Conceptos:** atributos y métodos `static`, identificadores automáticos, atributos `final`, operaciones que validan, un objeto que opera con otro

## Enunciado

Completa la clase `Cuenta` de [`Ej12_03_BancoConStatic.java`](Ej12_03_BancoConStatic.java):

**De la clase (`static`), compartido por todas las cuentas:**

| Miembro | Detalle |
|---|---|
| `siguienteNumero` | Empieza en 1000. Cada cuenta nueva recibe el número actual y lo incrementa |
| `cuentasCreadas` | Cuántas cuentas se han creado |
| `tipoInteres` | Empieza en 0.02 (2 %). `setTipoInteres` solo acepta valores entre 0 y 0.1; si no, muestra `  ⚠ Tipo de interés no válido: X` |

**De cada cuenta:**

| Miembro | Detalle |
|---|---|
| `numero`, `titular` | `final` |
| `saldo` | Sin setter. Si el saldo inicial es negativo, se muestra `  ⚠ Saldo inicial no válido, se usa 0` y se usa 0 |
| `movimientos` | Cuántas operaciones **correctas** se han hecho (ingresos, retiradas e intereses) |
| `ingresar`, `retirar` | Devuelven `boolean`. No se puede ingresar ni retirar una cantidad ≤ 0, ni retirar más del saldo |
| `transferir(destino, cantidad)` | Retira de esta cuenta e ingresa en la otra. Devuelve si se ha hecho |
| `aplicarInteres()` | Suma al saldo el `saldo × tipoInteres` |
| `toString()` | `"Cuenta 1000 (Ana): 721,00 € - 2 movimientos"` |

## Salida esperada

```
  ⚠ Saldo inicial no válido, se usa 0
Transferencia de 300 de Ana a Luis: true
Luis retira 1000: false
  ⚠ Tipo de interés no válido: 0.5
Tipo de interés: 3%
Cuenta 1000 (Ana): 721,00 € - 2 movimientos
Cuenta 1001 (Luis): 566,50 € - 2 movimientos
Cuenta 1002 (Marta): 82,40 € - 2 movimientos
Cuentas creadas: 3
```

## Pistas

<details>
<summary>Pista 1</summary>

```java
private static int siguienteNumero = 1000;

public Cuenta(String titular, double saldoInicial) {
    this.numero = siguienteNumero;
    siguienteNumero++;
    ...
}
```

</details>

<details>
<summary>Pista 2</summary>

`transferir` reutiliza `retirar` e `ingresar`. Solo ingresa en el destino si la retirada ha salido bien:

```java
boolean hecho = retirar(cantidad);
if (hecho) {
    destino.ingresar(cantidad);
}
return hecho;
```

</details>

## Cómo ejecutarlo

```bash
java Ej12_03_BancoConStatic.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-03-banco-con-static/SOLUCION.md).
