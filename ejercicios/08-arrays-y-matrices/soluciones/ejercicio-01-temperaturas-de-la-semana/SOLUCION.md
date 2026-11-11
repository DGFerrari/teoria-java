# Solución · Ejercicio 01 · Temperaturas de la semana

[⬅️ Enunciado](../../ejercicio-01-temperaturas-de-la-semana/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Los dos arrays son **paralelos**: la posición `i` de `dias` y la posición `i` de `temperaturas` hablan del mismo día. Para recorrerlos juntos necesitamos el índice, así que usamos un `for` clásico. Para la suma solo necesitamos los valores: for-each.

## Código explicado

```java
for (int i = 0; i < dias.length; i++) {
    System.out.printf("%s: %.1f ºC%n", dias[i], temperaturas[i]);
}

double suma = 0;
for (double t : temperaturas) {
    suma += t;
}
double media = suma / temperaturas.length;

System.out.printf("Media de la semana: %.1f ºC%n", media);
System.out.printf("Primer día: %.1f ºC | Último día: %.1f ºC%n",
        temperaturas[0], temperaturas[temperaturas.length - 1]);
```

- La media divide entre `temperaturas.length`: si mañana añadimos más días, el código sigue funcionando.
- La suma da 125.9 y la media 17.9857..., que `%.1f` redondea a `18,0`.

## Errores comunes

- `i <= dias.length` → `ArrayIndexOutOfBoundsException` en la última vuelta.
- `temperaturas[temperaturas.length]` para el último → también fuera de rango.
- Declarar `suma` como `int` → error, porque las temperaturas son `double`.

## Código completo

📄 [Sol08_01_TemperaturasDeLaSemana.java](Sol08_01_TemperaturasDeLaSemana.java)
