# Ejercicio 05 · Piedra, papel o tijera

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema (`if`/`else if`, anidados, ternario, `switch` moderno con `String`, `equalsIgnoreCase`) + `Scanner`, `Random` y `printf`

## Enunciado

Programa **una ronda** de piedra, papel o tijera contra el ordenador. Completa [`Ej06_05_PiedraPapelTijera.java`](Ej06_05_PiedraPapelTijera.java):

1. El usuario escribe su jugada: `piedra`, `papel` o `tijera`. Debe funcionar con **cualquier combinación de mayúsculas** (`Piedra`, `PAPEL`...).
2. Si la jugada no es válida, muestra `Jugada no válida: X` y no sigas.
3. El ordenador elige al azar un número del 0 al 2, que se convierte en jugada con un **`switch` como expresión** (0 = piedra, 1 = papel, 2 = tijera).
4. Decide el resultado:
   - Si son iguales → **empate**.
   - Piedra gana a tijera, tijera gana a papel y papel gana a piedra.
5. Con otro `switch`, asigna los **puntos**: victoria 3, empate 1, derrota 0.
6. Muestra el resultado con `printf` y una frase final elegida con un **ternario**: `¡Bien jugado!` si has sumado algún punto, `Otra vez será...` si no.

## Salida de ejemplo

(La jugada del ordenador es aleatoria.)

```
Tu jugada (piedra, papel o tijera): Piedra
Tú:        piedra
Ordenador: tijera
Resultado: VICTORIA (+3 puntos)
¡Bien jugado!
```

```
Tu jugada (piedra, papel o tijera): lagarto
Jugada no válida: lagarto
```

## Pistas

<details>
<summary>Pista 1</summary>

Convierte la jugada a minúsculas nada más leerla: `String jugador = teclado.nextLine().trim().toLowerCase();`. A partir de ahí puedes compararla con `equals` o usarla en un `switch`. (`trim()` quita los espacios que el usuario haya puesto sin querer al principio o al final.)

</details>

<details>
<summary>Pista 2</summary>

Para validar:

```java
boolean jugadaValida = jugador.equals("piedra") || jugador.equals("papel") || jugador.equals("tijera");
```

</details>

<details>
<summary>Pista 3</summary>

Solo hay **tres** combinaciones en las que gana el jugador. Escríbelas en una única condición con `||` y `&&`:

```java
boolean ganaJugador = (jugador.equals("piedra") && ordenador.equals("tijera"))
        || (...)
        || (...);
```

Si no es empate y no gana el jugador, gana el ordenador.

</details>

<details>
<summary>Pista 4</summary>

Para probar siempre la misma jugada del ordenador, crea el generador con semilla: `new Random(1)`.

</details>

## Cómo ejecutarlo

```bash
java Ej06_05_PiedraPapelTijera.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-piedra-papel-tijera/SOLUCION.md).
