# Solución · Ejercicio 03 · Fracciones

[⬅️ Enunciado](../../ejercicio-03-fracciones/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

La clave del ejercicio está en el **constructor**: si toda fracción se guarda **siempre** simplificada y con el signo en el numerador, el resto de métodos se vuelven muy sencillos, porque no tienen que preocuparse de simplificar.

Es una idea muy útil en POO: el objeto se encarga de estar **siempre en un estado correcto**. Lo verás a fondo en el tema 12.

## Código explicado

**Constructor que normaliza:**

```java
Fraccion(int numerador, int denominador) {
    int divisor = mcd(Math.abs(numerador), Math.abs(denominador));
    numerador /= divisor;
    denominador /= divisor;
    if (denominador < 0) {          // El signo siempre arriba
        numerador = -numerador;
        denominador = -denominador;
    }
    this.numerador = numerador;
    this.denominador = denominador;
}
```

Trabajamos con los **parámetros** y al final los guardamos en los atributos con `this`.

**Operaciones que devuelven un objeto nuevo:**

```java
Fraccion multiplicar(Fraccion otra) {
    return new Fraccion(numerador * otra.numerador, denominador * otra.denominador);
}
```

- `numerador` es el de **este** objeto (`this.numerador`) y `otra.numerador` el del que recibimos.
- Un objeto puede acceder a los atributos de **otro objeto de su misma clase**.
- Como no se modifica nada, `a` sigue valiendo `1/2` al final.

**Igualdad:**

```java
boolean esIgualA(Fraccion otra) {
    return numerador == otra.numerador && denominador == otra.denominador;
}
```

Gracias a la normalización, `6/8` y `3/4` se guardan igual. ¿Por qué no `a == c`? Porque `==` compara **referencias**: son dos objetos distintos aunque representen el mismo número. En el tema 13 verás cómo escribir el `equals` "oficial".

**`valorDecimal`** necesita un casting para no hacer división entera: `return (double) numerador / denominador;`.

## Errores comunes

- Modificar `this` en las operaciones (`this.numerador = ...`) → `a` cambiaría después de cada cálculo.
- `numerador / denominador` en `valorDecimal` → `3 / 4 = 0`.
- Calcular el `mcd` con números negativos → el resultado puede salir negativo. Por eso se usa `Math.abs`.

## Código completo

📄 [Sol11_03_Fracciones.java](Sol11_03_Fracciones.java)
