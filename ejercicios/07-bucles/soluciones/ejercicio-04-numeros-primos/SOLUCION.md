# Solución · Ejercicio 04 · Números primos

[⬅️ Enunciado](../../ejercicio-04-numeros-primos/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Hay tres bucles, cada uno con un papel distinto:

| Bucle | Tipo | Por qué |
|---|---|---|
| Pedir el rango | `do-while` | Hay que preguntar al menos una vez |
| Recorrer el rango | `for` | Sabemos de dónde a dónde |
| Buscar divisores | `while` con bandera | Queremos parar en cuanto encontremos uno |

## Código explicado

**Validación del rango:**

```java
do {
    System.out.print("Inicio del rango: ");
    inicio = teclado.nextInt();
    System.out.print("Fin del rango: ");
    fin = teclado.nextInt();
    if (inicio < 1 || fin < inicio) {
        System.out.println("  El inicio debe ser al menos 1 y el fin no puede ser menor que el inicio.");
    }
} while (inicio < 1 || fin < inicio);
```

**Comprobar si un número es primo** (bucle interior):

```java
boolean esPrimo = numero > 1;           // 1 no es primo: la bandera empieza en false
int divisor = 2;
while (divisor * divisor <= numero && esPrimo) {
    if (numero % divisor == 0) {
        esPrimo = false;                // Encontrado un divisor: deja de buscar
    }
    divisor++;
}
```

Traza con `numero = 15`:

| `divisor` | `divisor²` ≤ 15 | `esPrimo` | `15 % divisor` | Resultado |
|---|---|---|---|---|
| 2 | 4 ✓ | true | 1 | sigue |
| 3 | 9 ✓ | true | 0 | `esPrimo = false` |
| 4 | — | **false** | — | sale del bucle |

Traza con `numero = 13`: prueba 2 y 3 (9 ≤ 13); con 4, 16 > 13 y sale. `esPrimo` sigue en `true`.

**¿Por qué hasta la raíz?** Si 36 = 4 × 9, uno de los dos factores es ≤ 6 (√36). Encontraremos el 4 antes de llegar al 9. Para comprobar 1 000 003, en lugar de casi un millón de divisiones hacemos unas mil.

**Mostrar 10 por línea:**

```java
if (esPrimo) {
    System.out.print(numero + " ");
    contador++;
    suma += numero;
    if (contador % 10 == 0) {
        System.out.println();
    }
}
```

Y tras el bucle exterior, si la última línea quedó a medias (`contador % 10 != 0`), cerramos con un `println()`.

## Errores comunes

- Considerar primo el 1 (si la bandera empieza en `true` sin comprobar `numero > 1`).
- Reutilizar `esPrimo` sin reiniciarla para cada número → en cuanto uno no es primo, ninguno de los siguientes lo será. Por eso se declara **dentro** del bucle exterior.
- Usar `divisor <= numero` → `numero % numero` es 0 y nada sería primo.

## Código completo

📄 [Sol07_04_NumerosPrimos.java](Sol07_04_NumerosPrimos.java)
