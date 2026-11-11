# Solución · Ejercicio 02 · Intercambio de vasos

[⬅️ Enunciado](../../ejercicio-02-intercambio-de-vasos/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Una variable guarda **un solo valor**: al asignar uno nuevo, el anterior desaparece. Por eso el intento directo falla:

```java
vasoA = vasoB;   // vasoA = "leche"  (el "zumo" se ha perdido)
vasoB = vasoA;   // vasoB = "leche"  (copia la leche otra vez)
```

Traza del intento fallido:

| Paso | `vasoA` | `vasoB` |
|---|---|---|
| Inicio | zumo | leche |
| `vasoA = vasoB` | leche | leche |
| `vasoB = vasoA` | leche | leche ❌ |

## Parte A · Intercambio con auxiliar

```java
String auxiliar = vasoA;   // 1. Guardamos el zumo en el vaso vacío
vasoA = vasoB;             // 2. Echamos la leche en el vaso A
vasoB = auxiliar;          // 3. Echamos el zumo (guardado) en el vaso B
```

| Paso | `vasoA` | `vasoB` | `auxiliar` |
|---|---|---|---|
| Inicio | zumo | leche | — |
| 1 | zumo | leche | zumo |
| 2 | leche | leche | zumo |
| 3 | leche | zumo ✅ | zumo |

## Parte B · Rotación

```java
int auxiliarRotacion = x;  // Guardamos el 1
x = y;                     // x = 2
y = z;                     // y = 3
z = auxiliarRotacion;      // z = 1
```

La idea es la misma: guardar **primero** el valor que se va a sobrescribir antes que nadie lo haya copiado, y usarlo al final.

## Errores comunes

- **Declarar dos veces `auxiliar`** con tipos distintos (`String auxiliar` e `int auxiliar`): error `already defined`. Usa nombres distintos.
- **Orden incorrecto en la rotación:** si empiezas por `z = x`, pierdes el 3.

## Otras formas de resolverlo

Con números existe un truco sin variable auxiliar (`a = a + b; b = a - b; a = a - b;`), pero es más difícil de leer y puede desbordar con números grandes. La variable auxiliar es la forma clara y la que se usa siempre.

## Código completo

📄 [Sol03_02_IntercambioDeVasos.java](Sol03_02_IntercambioDeVasos.java)
