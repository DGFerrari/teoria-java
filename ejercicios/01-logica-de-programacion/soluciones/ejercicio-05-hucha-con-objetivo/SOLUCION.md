# Solución · Ejercicio 05 · Hucha con objetivo

[⬅️ Enunciado](../../ejercicio-05-hucha-con-objetivo/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Este ejercicio usa **las tres estructuras** a la vez:

- **Secuencia:** preparar las variables, hacer el bucle y, después, mostrar el resultado.
- **Repetición:** una vuelta del bucle es una semana.
- **Decisión:** dentro del bucle (¿toca capricho?) y al final (¿he llegado?).

Variables:

| Variable | Tipo de variable | Valor inicial | Cambio en cada vuelta |
|---|---|---|---|
| `semana` | Contador | 1 | +1 |
| `hucha` | Acumulador | 0 | + `aportacion` (y −8 si toca) |
| `aportacion` | Valor variable | 10 | +5 |

## Pseudocódigo

```
INICIO
    objetivo ← 100
    maxSemanas ← 12
    hucha ← 0
    semana ← 1
    aportacion ← 10
    MIENTRAS semana <= maxSemanas Y hucha < objetivo HACER
        hucha ← hucha + aportacion
        SI semana es múltiplo de 4 ENTONCES
            hucha ← hucha - 8
            ESCRIBIR "Semana ", semana, ": meto ", aportacion, " -> capricho (-8) -> hucha = ", hucha
        SINO
            ESCRIBIR "Semana ", semana, ": meto ", aportacion, " -> hucha = ", hucha
        FIN SI
        aportacion ← aportacion + 5
        semana ← semana + 1
    FIN MIENTRAS
    SI hucha >= objetivo ENTONCES
        ESCRIBIR "Objetivo cumplido en ", semana - 1, " semanas"
    SINO
        ESCRIBIR "No has llegado. Te faltan ", objetivo - hucha, " euros"
    FIN SI
FIN
```

## Traza (objetivo = 100)

| Semana | Aportación | ¿Capricho? | Hucha | ¿Sigue? (`semana+1 <= 12` y `hucha < 100`) |
|---|---|---|---|---|
| 1 | 10 | No | 10 | Sí |
| 2 | 15 | No | 25 | Sí |
| 3 | 20 | No | 45 | Sí |
| 4 | 25 | Sí (−8) | 62 | Sí |
| 5 | 30 | No | 92 | Sí |
| 6 | 35 | No | 127 | **No** (127 no es < 100) |

Al salir, `semana` vale **7**, así que las semanas usadas son `semana - 1 = 6`.

## Código explicado

**La condición compuesta** sustituye al `break`:

```java
while (semana <= maxSemanas && hucha < objetivo) {
```

El bucle solo continúa si **las dos** cosas son ciertas. En cuanto una sea falsa (se acaban las semanas **o** llegamos al objetivo), termina. Así, leyendo solo esta línea, ya sabes todas las formas en que el bucle puede acabar.

**La decisión del capricho**, dentro del bucle:

```java
if (semana % 4 == 0) {
    hucha = hucha - capricho;
    ...
}
```

`semana % 4` es el resto de dividir entre 4. Solo es 0 en las semanas 4, 8 y 12.

**La decisión final**, fuera del bucle:

```java
if (hucha >= objetivo) {
    System.out.println("Objetivo cumplido en " + (semana - 1) + " semanas");
} else {
    System.out.println("No has llegado. Te faltan " + (objetivo - hucha) + " euros");
}
```

Los paréntesis en `(semana - 1)` son necesarios: sin ellos, Java uniría primero el texto con `semana` y luego intentaría "restar" a un texto, lo que da error.

¿Por qué preguntamos por la hucha y no por la semana? Porque si el objetivo se alcanza **justo** en la semana 12, las dos condiciones se vuelven falsas a la vez. Mirar la hucha es lo único que dice con seguridad si hemos llegado.

## Errores comunes

- **Usar `||` (O) en lugar de `&&` (Y):** el bucle seguiría mientras se cumpla *cualquiera* de las dos, y no pararía al llegar al objetivo.
- **Mostrar `semana` en lugar de `semana - 1`** al final: diría 7 semanas.
- **Subir la aportación antes de meterla:** la primera semana meterías 15 en lugar de 10.
- **Olvidar los paréntesis** en `(objetivo - hucha)` dentro del `println`.

## Otras formas de resolverlo

Se puede usar una variable `boolean conseguido` que se pone a `true` dentro del bucle cuando `hucha >= objetivo`, y escribir `while (semana <= maxSemanas && !conseguido)`. El símbolo `!` significa "no". Es igual de válido y a veces más legible cuando la condición de parada es complicada.

## Código completo

📄 [Sol01_05_HuchaConObjetivo.java](Sol01_05_HuchaConObjetivo.java)
