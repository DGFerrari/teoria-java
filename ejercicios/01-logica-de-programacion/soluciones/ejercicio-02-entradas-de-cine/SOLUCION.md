# Solución · Ejercicio 02 · Entradas de cine

[⬅️ Enunciado](../../ejercicio-02-entradas-de-cine/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Antes de escribir código, separamos el problema en sus tres partes:

| Parte | Contenido |
|---|---|
| **Entrada** | número de entradas (3), precio de cada entrada (7.5), precio de las palomitas (6) |
| **Proceso** | 1) multiplicar entradas × precio · 2) sumar las palomitas |
| **Salida** | el precio de las entradas, el de las palomitas y el total |

## Pseudocódigo

```
INICIO
    numeroEntradas ← 3
    precioEntrada ← 7.5
    precioPalomitas ← 6
    totalEntradas ← numeroEntradas * precioEntrada
    totalGastado ← totalEntradas + precioPalomitas
    ESCRIBIR "Entradas: ", numeroEntradas, " x ", precioEntrada, " = ", totalEntradas
    ESCRIBIR "Palomitas: ", precioPalomitas
    ESCRIBIR "Total gastado: ", totalGastado
FIN
```

## Código explicado

```java
double totalEntradas = numeroEntradas * precioEntrada;   // 3 * 7.5 = 22.5
double totalGastado = totalEntradas + precioPalomitas;    // 22.5 + 6.0 = 28.5
```

- El orden importa: `totalGastado` usa `totalEntradas`, así que esta tiene que calcularse **antes**.
- Las variables son `double` porque los precios tienen decimales. Si usaras `int`, Java no te dejaría guardar 22.5.
- Al mostrar `precioPalomitas`, Java escribe `6.0` porque es un `double`: siempre muestra al menos un decimal.

```java
System.out.println("Palomitas: " + precioPalomitas + " euros");
System.out.println("Total gastado: " + totalGastado + " euros");
```

El `+` entre un texto y una variable **une** los dos en un solo texto.

## Errores comunes

- **Calcular el total antes que las entradas:** si escribes la línea de `totalGastado` primero, `totalEntradas` todavía no existe y Java da error.
- **Escribir los resultados a mano** (`"Total: 28.5"`): funciona con estos datos, pero si cambias el precio, el resultado ya no es correcto. El programa tiene que **calcular**.
- **Poner una coma decimal** (`7,5`): en Java los decimales se escriben con **punto** (`7.5`).

## Otras formas de resolverlo

Se podría calcular el total en una sola línea:

```java
double totalGastado = numeroEntradas * precioEntrada + precioPalomitas;
```

Funciona igual (la multiplicación se hace antes que la suma), pero entonces no tendríamos el precio de las entradas por separado para mostrarlo.

## Código completo

📄 [Sol01_02_EntradasDeCine.java](Sol01_02_EntradasDeCine.java)
