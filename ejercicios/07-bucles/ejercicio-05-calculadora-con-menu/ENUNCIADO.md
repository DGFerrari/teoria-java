# Ejercicio 05 · Calculadora con menú

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema (`do-while`, `while`, validación con `hasNextInt`/`hasNextDouble`, contadores, acumuladores, máximo, banderas) + `switch` y `printf`

## Enunciado

Programa una calculadora que funcione con un **menú repetitivo**. Completa [`Ej07_05_CalculadoraConMenu.java`](Ej07_05_CalculadoraConMenu.java):

```
===== CALCULADORA =====
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
0. Salir
```

1. El menú se muestra **una y otra vez** hasta que el usuario elija `0` (`do-while`).
2. La opción se lee **validando el tipo**: si se escribe algo que no es un número entero, se avisa y se vuelve a pedir.
3. Para las opciones 1–4, se piden dos números **validando que sean decimales** válidos.
4. La división entre 0 se considera un **error**: se avisa y no cuenta como operación.
5. Una opción que no existe (por ejemplo `7`) muestra `Opción no válida`.
6. Al salir, se muestran las **estadísticas** de la sesión:
   - operaciones realizadas,
   - errores (divisiones entre 0),
   - opciones no válidas,
   - suma de todos los resultados,
   - resultado más alto,
   - media de los resultados.
   Si no se ha hecho ninguna operación, en lugar del máximo y la media se muestra `No se ha realizado ninguna operación`.

> 📏 Sin `break` fuera del `switch`, y sin `continue`.

## Salida esperada (resumida)

(Lo que escribe el usuario: `1`, `8`, `2`, `4`, `9`, `0`, `3`, `abc`, `2,5`, `4`, `7`, `0`.)

```
===== CALCULADORA =====
...
Opción: 1
Primer número: 8
Segundo número: 2
Resultado: 10,00
...
Opción: 4
Primer número: 9
Segundo número: 0
Error: no se puede dividir entre 0
...
Opción: 3
Primer número: abc
  'abc' no es un número válido. Otra vez: 2,5
Segundo número: 4
Resultado: 10,00
...
Opción: 7
Opción no válida
...
Opción: 0

===== ESTADÍSTICAS =====
Operaciones realizadas: 2
Errores: 1
Opciones no válidas: 1
Suma de resultados: 20,00
Resultado más alto: 10,00
Media de resultados: 10,00
¡Hasta pronto!
```

## Pistas

<details>
<summary>Pista 1</summary>

Estructura general:

```java
int opcion;
do {
    // mostrar menú
    // leer opción (validada)
    switch (opcion) {
        case 1, 2, 3, 4 -> { ... }
        case 0 -> { }            // No hace nada: el do-while terminará
        default -> { ... }
    }
} while (opcion != 0);
// estadísticas
```

</details>

<details>
<summary>Pista 2</summary>

Para validar un decimal (en el sistema en español, con coma):

```java
while (!teclado.hasNextDouble()) {
    System.out.print("  '" + teclado.next() + "' no es un número válido. Otra vez: ");
}
double a = teclado.nextDouble();
```

</details>

<details>
<summary>Pista 3</summary>

El máximo no se puede inicializar con el primer valor porque no sabes cuándo llegará. Usa una bandera: si `operaciones == 0` (antes de incrementarla), el resultado actual **es** el máximo; si no, compáralo.

</details>

## Cómo ejecutarlo

```bash
java Ej07_05_CalculadoraConMenu.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-calculadora-con-menu/SOLUCION.md).
