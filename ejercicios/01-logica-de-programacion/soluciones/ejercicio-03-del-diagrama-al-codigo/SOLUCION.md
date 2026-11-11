# Solución · Ejercicio 03 · Del diagrama al código

[⬅️ Enunciado](../../ejercicio-03-del-diagrama-al-codigo/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Al leer un diagrama de flujo, cada forma se traduce a una instrucción:

| Forma del diagrama | Pseudocódigo | Java |
|---|---|---|
| Paralelogramo "Leer" | `LEER edad` | `int edad = 30;` (de momento, valor fijo) |
| Rectángulo | `precio ← 3` | `precio = 3;` |
| Rombo | `SI edad < 12 ENTONCES` | `if (edad < 12) {` |
| Paralelogramo "Escribir" | `ESCRIBIR precio` | `System.out.println(...)` |

Lo importante es ver que los tres caminos de la edad **se vuelven a juntar** antes del rombo de "¿esFestivo?". Eso significa que la segunda decisión se hace **siempre**, después de la primera: son dos `if` seguidos.

## Pseudocódigo

```
INICIO
    LEER edad, esFestivo
    SI edad < 12 ENTONCES
        precio ← 3
    SINO SI edad >= 65 ENTONCES
        precio ← 2
    SINO
        precio ← 5
    FIN SI
    SI esFestivo ENTONCES
        precio ← precio + 1
    FIN SI
    ESCRIBIR precio
FIN
```

## Código explicado

```java
if (edad < 12) {
    precio = 3;
} else if (edad >= 65) {
    precio = 2;
} else {
    precio = 5;
}
```

Las condiciones se comprueban en orden. Con `edad = 70`: `70 < 12` es falso, `70 >= 65` es verdadero → `precio = 2` y el resto se ignora. El `else` final recoge "todo lo demás" (de 12 a 64 años).

```java
if (esFestivo) {
    precio = precio + 1;
}
```

Este `if` está **fuera** del anterior, así que se ejecuta con cualquier edad. No tiene `else` porque, si no es festivo, no hay que hacer nada.

## Comprobación de los casos límite

| `edad` | ¿`< 12`? | ¿`>= 65`? | Base | Festivo | Final |
|---|---|---|---|---|---|
| 12 | No | No | 5 | No | **5** |
| 65 | No | Sí | 2 | Sí | **3** |

Los **casos límite** (12 y 65) son donde más errores aparecen. Si hubieras escrito `edad <= 12`, un niño de 12 años pagaría 3 en lugar de 5.

## Errores comunes

- **Meter el `if (esFestivo)` dentro del `else`**: entonces el recargo solo se aplicaría a los adultos.
- **Usar varios `if` sueltos para la edad** en lugar de `else if`: con `if (edad < 12)` y luego `if (edad >= 65)` y luego un `else`, el `else` solo va con el último `if` y un niño acabaría pagando 5.
- **Escribir `if (esFestivo = true)`**: con un solo `=` es una asignación, no una comparación. Basta con `if (esFestivo)`.

## Código completo

📄 [Sol01_03_DelDiagramaAlCodigo.java](Sol01_03_DelDiagramaAlCodigo.java)
