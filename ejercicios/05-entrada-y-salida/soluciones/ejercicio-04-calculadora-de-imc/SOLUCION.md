# Solución · Ejercicio 04 · Calculadora de IMC

[⬅️ Enunciado](../../ejercicio-04-calculadora-de-imc/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

| Entrada | Proceso | Salida |
|---|---|---|
| nombre, peso, alturaCm | metros, altura², IMC, pesos mínimo y máximo, ¿en rango? | informe con formato |

El orden de lectura importa: el nombre (`nextLine`) va **primero**, así no hay salto de línea pendiente.

## Código explicado

**Entrada:**

```java
System.out.print("Nombre: ");
String nombre = teclado.nextLine();
System.out.print("Peso (kg): ");
double peso = teclado.nextDouble();
System.out.print("Altura (cm): ");
int alturaCm = teclado.nextInt();
```

**Proceso:**

```java
double alturaM = alturaCm / 100.0;                 // 178 / 100.0 = 1.78
double alturaAlCuadrado = Math.pow(alturaM, 2);    // 3.1684
double imc = peso / alturaAlCuadrado;              // 72.5 / 3.1684 = 22.88...
double pesoMinimo = IMC_MINIMO * alturaAlCuadrado; // 58.61...
double pesoMaximo = IMC_MAXIMO * alturaAlCuadrado; // 78.89...
boolean enRango = imc >= IMC_MINIMO && imc <= IMC_MAXIMO;
```

Guardar `alturaAlCuadrado` en una variable evita repetir el cálculo tres veces y hace las fórmulas más legibles.

**Salida:**

```java
System.out.printf("Altura: %.2f m%n", alturaM);
System.out.printf("IMC: %.1f%n", imc);
System.out.printf("Peso saludable para tu altura: de %.1f a %.1f kg%n", pesoMinimo, pesoMaximo);
System.out.printf("¿IMC en rango saludable? %b%n", enRango);
```

## Un detalle sobre el redondeo

El `boolean` se calcula con el IMC **real** (22.88...), no con el que se muestra (22,9). Normalmente no importa, pero con un IMC de 24.93 se mostraría `24,9` y el resultado sería `false`. Mostrar redondeado y calcular con el valor exacto es lo correcto; solo hay que saber que puede pasar.

## Errores comunes

- `alturaCm / 100` → 1 (división entera) y un IMC de 72.5.
- `peso / alturaM * alturaM` → por la precedencia, divide y luego multiplica: da el peso otra vez. Hacen falta paréntesis o `Math.pow`.
- Escribir `72.5` en un sistema en español → `InputMismatchException`.

## Código completo

📄 [Sol05_04_CalculadoraDeImc.java](Sol05_04_CalculadoraDeImc.java)
