# Solución · Ejercicio 02 · Estadísticas de notas

[⬅️ Enunciado](../../ejercicio-02-estadisticas-de-notas/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

El programa recorre el array **tres** veces:

| Recorrido | Para qué | Bucle |
|---|---|---|
| 1 | Rellenar desde el teclado | `for` (necesita el índice para guardar) |
| 2 | Suma, máximo, mínimo, aprobados | `for` (necesita el índice para saber **qué alumno**) |
| 3 | Mostrar los que superan la media | `for` (también necesita el índice) |

El tercero no se puede juntar con el segundo: hasta que no se termina de sumar, **no se conoce la media**.

## Código explicado

**Crear y rellenar:**

```java
double[] notas = new double[cantidad];
for (int i = 0; i < notas.length; i++) {
    System.out.print("Nota del alumno " + (i + 1) + ": ");
    notas[i] = teclado.nextDouble();
}
```

**Estadísticas** (máximo y mínimo empiezan con la primera nota):

```java
double suma = 0;
int posMaxima = 0;
int posMinima = 0;
int aprobados = 0;
for (int i = 0; i < notas.length; i++) {
    suma += notas[i];
    if (notas[i] > notas[posMaxima]) {
        posMaxima = i;
    }
    if (notas[i] < notas[posMinima]) {
        posMinima = i;
    }
    if (notas[i] >= 5) {
        aprobados++;
    }
}
```

Fíjate en el truco: en lugar de guardar el valor máximo **y** su posición, guardamos **solo la posición**. El valor siempre está en `notas[posMaxima]`.

**Segundo recorrido:**

```java
for (int i = 0; i < notas.length; i++) {
    if (notas[i] > media) {
        System.out.printf("alumno %d (%.2f) ", i + 1, notas[i]);
    }
}
```

## Errores comunes

- Crear el array **antes** de leer la cantidad → no se sabe el tamaño.
- Mostrar `i` en lugar de `i + 1` → el primer alumno sería el "alumno 0".
- Intentar calcular quién supera la media en el mismo bucle que la suma → la media todavía no existe.

## Código completo

📄 [Sol08_02_EstadisticasDeNotas.java](Sol08_02_EstadisticasDeNotas.java)
