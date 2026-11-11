# Solución · Ejercicio 04 · Pila genérica

[⬅️ Enunciado](../../ejercicio-04-pila-generica/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

La pila no necesita saber **qué** guarda: solo cómo entrar y salir. Por eso es el ejemplo perfecto de clase genérica. La misma clase sirve para invertir un texto (`Pila<Character>`) y para evaluar expresiones (`Pila<Double>`).

Traza de `3 4 + 2 *`:

| Elemento | Acción | Pila después |
|---|---|---|
| `3` | Apilar | [3.0] |
| `4` | Apilar | [3.0, 4.0] |
| `+` | Desapilar 4 y 3, apilar 3 + 4 | [7.0] |
| `2` | Apilar | [7.0, 2.0] |
| `*` | Desapilar 2 y 7, apilar 7 × 2 | [14.0] |
| Fin | Queda un elemento → resultado | |

## Código explicado

**La pila:**

```java
static class Pila<T> {
    private final List<T> elementos = new ArrayList<>();

    void apilar(T elemento) {
        elementos.add(elemento);
    }

    T desapilar() {
        comprobarQueNoEstaVacia();
        return elementos.remove(elementos.size() - 1);
    }
    ...
}
```

Usar el **final** de la lista como cima hace que apilar y desapilar sean rápidos: no hay que desplazar nada. `remove(int)` devuelve el elemento borrado, así que sirve directamente como resultado.

El método privado `comprobarQueNoEstaVacia()` evita repetir el mismo `if` en `desapilar` y en `cima`.

**`toString` reutilizando el de la lista:**

```java
String lista = elementos.toString();                    // "[uno, dos, tres]"
texto = lista.substring(0, lista.length() - 1) + " ← cima]";
```

**Evaluar con un `switch`:**

```java
for (String elemento : expresion.split(" ")) {
    switch (elemento) {
        case "+", "-", "*", "/" -> {
            double derecha = pila.desapilar();
            double izquierda = pila.desapilar();
            pila.apilar(operar(izquierda, elemento, derecha));
        }
        default -> pila.apilar(Double.parseDouble(elemento));
    }
}
```

Los dos tipos de error salen solos de la estructura:

- `1 +` → al llegar al `+` solo hay un número: el segundo `desapilar()` lanza `PilaVaciaException`.
- `2 3 4` → al terminar quedan tres números: `evaluarRPN` lanza `IllegalArgumentException`.

## Errores comunes

- Operar `derecha - izquierda` → `5 1 2 + 4 * + 3 -` daría `-14` en lugar de `14`.
- `new T[capacidad]` → no compila.
- Hacer que `desapilar` devuelva `null` cuando está vacía → con `Pila<Double>`, el unboxing a `double` lanzaría un `NullPointerException` mucho menos claro.

## Código completo

📄 [Sol17_04_PilaGenerica.java](Sol17_04_PilaGenerica.java)
