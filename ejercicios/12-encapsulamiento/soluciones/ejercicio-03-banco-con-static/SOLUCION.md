# Solución · Ejercicio 03 · Banco con static

[⬅️ Enunciado](../../ejercicio-03-banco-con-static/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Pregúntate para cada dato: **¿es de cada cuenta o es del banco?**

| Dato | ¿De quién? | Declaración |
|---|---|---|
| Número, titular, saldo, movimientos | De **cada** cuenta | Atributos normales |
| Próximo número a asignar | Del **banco** | `private static int` |
| Cuántas cuentas hay | Del **banco** | `private static int` |
| Tipo de interés | Del **banco** (igual para todas) | `private static double` |

Si `tipoInteres` no fuera `static`, cambiarlo en una cuenta no afectaría a las demás, y habría que cambiarlo cuenta por cuenta.

## Código explicado

**Número automático:**

```java
public Cuenta(String titular, double saldoInicial) {
    this.numero = siguienteNumero;
    siguienteNumero++;
    cuentasCreadas++;
    this.titular = titular;
    if (saldoInicial >= 0) {
        this.saldo = saldoInicial;
    } else {
        System.out.println("  ⚠ Saldo inicial no válido, se usa 0");
        this.saldo = 0;
    }
    this.movimientos = 0;
}
```

**Transferir reutilizando las operaciones:**

```java
public boolean transferir(Cuenta destino, double cantidad) {
    boolean hecho = retirar(cantidad);       // retirar de ESTA cuenta (this)
    if (hecho) {
        destino.ingresar(cantidad);          // ingresar en la OTRA
    }
    return hecho;
}
```

Al reutilizar `retirar` e `ingresar`, la transferencia aplica automáticamente todas sus validaciones y cuenta los movimientos de las dos cuentas.

**Método `static` que valida:**

```java
public static void setTipoInteres(double nuevo) {
    if (nuevo >= 0 && nuevo <= 0.1) {
        tipoInteres = nuevo;
    } else {
        System.out.println("  ⚠ Tipo de interés no válido: " + nuevo);
    }
}
```

Se llama con el nombre de la clase: `Cuenta.setTipoInteres(0.03)`. Afecta a **todas** las cuentas a la vez.

## Errores comunes

- `private int siguienteNumero` sin `static` → todas las cuentas serían la 1000.
- Ingresar en el destino aunque la retirada haya fallado → se crearía dinero de la nada.
- Usar `this` dentro de un método `static` → error de compilación.

## Código completo

📄 [Sol12_03_BancoConStatic.java](Sol12_03_BancoConStatic.java)
