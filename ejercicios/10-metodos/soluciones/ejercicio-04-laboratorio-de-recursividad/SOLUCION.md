# Solución · Ejercicio 04 · Laboratorio de recursividad

[⬅️ Enunciado](../../ejercicio-04-laboratorio-de-recursividad/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Todos los métodos siguen el mismo esquema:

```java
static Tipo metodo(problema) {
    if (problema es mínimo) {
        return solución directa;                     // Caso base
    } else {
        return combinar(algo, metodo(problema más pequeño));   // Caso recursivo
    }
}
```

| Método | Caso base | Cómo se "achica" el problema |
|---|---|---|
| `factorial` | `n <= 1` | `n - 1` |
| `potencia` | `exponente == 0` | `exponente - 1` |
| `sumarCifras`, `contarCifras` | `n < 10` | `n / 10` (quita una cifra) |
| `mcd` | `b == 0` | `(b, a % b)` |
| `invertir` | longitud ≤ 1 | Quitar el último carácter |
| `esPalindromo` | longitud ≤ 1 | Quitar el primero y el último |
| `sumarDesde` | `indice == datos.length` | `indice + 1` |

## Código explicado

**Cifras:**

```java
static int sumarCifras(int n) {
    if (n < 10) {
        return n;
    } else {
        return n % 10 + sumarCifras(n / 10);    // 2025 → 5 + sumarCifras(202)
    }
}
```

**Euclides:**

```java
static int mcd(int a, int b) {
    if (b == 0) {
        return a;
    } else {
        return mcd(b, a % b);
    }
}
```

Es uno de los algoritmos más antiguos que se conocen (unos 2 300 años) y sigue siendo el que se usa.

**Palíndromo con dos casos base:**

```java
static boolean esPalindromo(String texto) {
    if (texto.length() <= 1) {
        return true;                                       // Nada que comparar
    } else if (texto.charAt(0) != texto.charAt(texto.length() - 1)) {
        return false;                                      // Extremos distintos: ya sabemos la respuesta
    } else {
        return esPalindromo(texto.substring(1, texto.length() - 1));
    }
}
```

```
esPalindromo("reconocer")   r == r ✓
esPalindromo("econoce")     e == e ✓
esPalindromo("conoc")       c == c ✓
esPalindromo("ono")         o == o ✓
esPalindromo("n")           longitud 1 → true
```

**Recursividad sobre un array** con un índice que avanza:

```java
static int sumarDesde(int[] datos, int indice) {
    if (indice == datos.length) {
        return 0;                                  // No quedan elementos
    } else {
        return datos[indice] + sumarDesde(datos, indice + 1);
    }
}
```

El array no se "achica": lo que avanza es el índice. Es la versión recursiva de un `for`.

## Errores comunes

- Olvidar el caso base o ponerlo mal (`n == 1` en factorial, y llamar con 0) → `StackOverflowError`.
- Llamar con el mismo problema (`factorial(n)` en lugar de `factorial(n - 1)`) → también `StackOverflowError`.
- `invertir` sumando dos `char` → `charAt(...) + charAt(...)` da un número. Uno de los lados debe ser un `String`.

## Código completo

📄 [Sol10_04_LaboratorioDeRecursividad.java](Sol10_04_LaboratorioDeRecursividad.java)
