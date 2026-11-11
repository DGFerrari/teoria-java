# Solución · Ejercicio 03 · Encuesta rota

[⬅️ Enunciado](../../ejercicio-03-encuesta-rota/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Qué pasaba

| Pregunta | Método | ¿Funciona? | Motivo |
|---|---|---|---|
| Nombre | `nextLine()` | ✅ | Es la primera lectura: no hay nada pendiente |
| Edad | `nextInt()` | ✅ | Se lleva el `15`, pero **deja el ⏎** |
| Ciudad | `nextLine()` | ❌ | Lee el ⏎ que dejó la edad → texto vacío |
| Hermanos | `nextInt()` | ✅ | Se salta el ⏎ inicial y lee el `2`; vuelve a dejar el ⏎ |
| Comida | `nextLine()` | ❌ | Lee el ⏎ que dejó hermanos → texto vacío |

Con el programa roto, además, al usuario solo le da tiempo a escribir la edad y los hermanos. Si escribe `San Sebastián` cuando el programa espera los hermanos, `nextInt()` falla con `InputMismatchException`.

## La solución

Un `nextLine()` extra **después de cada `nextInt()` que vaya seguido de un `nextLine()`**:

```java
int edad = teclado.nextInt();
teclado.nextLine();                 // Limpia el ⏎ pendiente

System.out.print("Ciudad: ");
String ciudad = teclado.nextLine(); // ✅
```

Y lo mismo tras `hermanos`.

La letra del grupo va después de un `nextLine()`, que sí consume su ⏎, así que no necesita limpieza:

```java
System.out.print("Grupo (letra): ");
char grupo = teclado.next().charAt(0);
```

## El resumen

```java
System.out.printf("%s (%d años) vive en %s.%n", nombre, edad, ciudad);
System.out.printf("Tiene %d hermanos y su comida favorita es: %s.%n", hermanos, comida);
System.out.printf("Grupo: %c%n", grupo);
```

## Otras formas de resolverlo

Con la **solución B** no hace falta limpiar nada: todo se lee con `nextLine()` y los números se convierten.

```java
int edad = Integer.parseInt(teclado.nextLine());
```

Es la opción más segura cuando mezclas muchos textos y números.

## Código completo

📄 [Sol05_03_EncuestaRota.java](Sol05_03_EncuestaRota.java)
