# Solución · Ejercicio 01 · Días de la semana

[⬅️ Enunciado](../../ejercicio-01-dias-de-la-semana/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Un enum no es solo una lista de nombres: es una **clase** con un número fijo de objetos. Por eso puede tener métodos, y dentro de ellos `this` es la constante concreta (`Dia.VIERNES.siguiente()` → `this` es `VIERNES`).

| Necesito... | Herramienta |
|---|---|
| Recorrer todos los días | `Dia.values()` |
| Saber la posición de un día | `ordinal()` (0 para `LUNES`) |
| El nombre como texto | `name()` |
| Pasar de texto a día | `Dia.valueOf("JUEVES")` |

## Código explicado

**Comparar constantes con `==`:**

```java
boolean esFinDeSemana() {
    return this == SABADO || this == DOMINGO;
}
```

Dentro del enum se puede escribir `SABADO` sin `Dia.` delante.

**Dar la vuelta a la semana con el resto:**

```java
Dia avanzar(int cuantos) {
    Dia[] dias = values();
    return dias[(ordinal() + cuantos) % dias.length];
}
```

Desde `VIERNES` (posición 4), 10 días después: `(4 + 10) % 7 = 0` → `LUNES`.

**La abreviatura a partir del nombre:**

```java
return name().charAt(0) + name().substring(1, 3).toLowerCase();
```

`charAt(0)` es un `char`; al sumarlo a un `String` se concatena.

**De texto a constante:**

```java
try {
    Dia dia = Dia.valueOf(entrada.toUpperCase());
    ...
} catch (IllegalArgumentException e) {
    ...
}
```

## Errores comunes

- Comparar con `equals` o con `name().equals("SABADO")` → funciona, pero con enums lo correcto y más claro es `==`.
- `values()[ordinal() + 1]` sin el resto → `ArrayIndexOutOfBoundsException` al pedir el siguiente del `DOMINGO`.
- `Dia.valueOf("jueves")` sin `toUpperCase()` → `IllegalArgumentException`.

## Código completo

📄 [Sol18_01_DiasDeLaSemana.java](Sol18_01_DiasDeLaSemana.java)
