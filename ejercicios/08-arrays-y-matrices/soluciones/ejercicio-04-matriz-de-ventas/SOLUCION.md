# Solución · Ejercicio 04 · Matriz de ventas

[⬅️ Enunciado](../../ejercicio-04-matriz-de-ventas/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

```
              columna (mes) →
           Ene Feb Mar Abr May Jun   totalVendedor[fila]
fila  Ana   12  15   9  20  18  22   →  96
(ven- Luis   8  11  14   9  13  10   →  65
dedor) ...
  ↓
totalMes    50  53  60  61  60  70      354
[columna]
```

Un solo recorrido de la matriz sirve para todo: cada celda suma en **su fila** y en **su columna**, y se compara con el máximo actual.

## Código explicado

**Totales y mejor celda en un único recorrido:**

```java
int[] totalVendedor = new int[ventas.length];       // 4
int[] totalMes = new int[ventas[0].length];         // 6
int totalGeneral = 0;
int filaMax = 0;
int columnaMax = 0;

for (int fila = 0; fila < ventas.length; fila++) {
    for (int columna = 0; columna < ventas[fila].length; columna++) {
        int valor = ventas[fila][columna];
        totalVendedor[fila] += valor;
        totalMes[columna] += valor;
        totalGeneral += valor;
        if (valor > ventas[filaMax][columnaMax]) {
            filaMax = fila;
            columnaMax = columna;
        }
    }
}
```

Los arrays de totales se crean con `new`, así que empiezan a 0: no hace falta inicializarlos.

**Mostrar la tabla:**

```java
System.out.printf("%-8s", "Vendedor");
for (String mes : meses) {
    System.out.printf("%6s", mes);
}
System.out.printf("%7s%n", "Total");

for (int fila = 0; fila < ventas.length; fila++) {
    System.out.printf("%-8s", vendedores[fila]);
    for (int columna = 0; columna < ventas[fila].length; columna++) {
        System.out.printf("%6d", ventas[fila][columna]);
    }
    System.out.printf("%7d%n", totalVendedor[fila]);
}
```

**Mejor vendedor y mejor mes:** son máximos sobre arrays normales (como en el tema). Se guarda la **posición**, y con ella se obtiene el nombre en `vendedores[...]` o `meses[...]`.

## ¿Por qué arrays paralelos?

Los nombres (`vendedores`, `meses`) no están dentro de la matriz porque la matriz es de `int` y los nombres son `String`. La posición une los datos: `vendedores[2]` es la fila 2 de `ventas`. En el [tema 11](../../../../teoria/11-clases-y-objetos/README.md) verás una forma más ordenada de agrupar datos de distinto tipo: los objetos.

## Errores comunes

- `new int[ventas.length]` para `totalMes` → tamaño 4 en lugar de 6: `ArrayIndexOutOfBoundsException`.
- Intercambiar índices: `ventas[columna][fila]`.
- Inicializar el máximo a 0 en lugar de con la primera celda: funciona aquí (no hay negativos), pero no es un hábito seguro.

## Código completo

📄 [Sol08_04_MatrizDeVentas.java](Sol08_04_MatrizDeVentas.java)
