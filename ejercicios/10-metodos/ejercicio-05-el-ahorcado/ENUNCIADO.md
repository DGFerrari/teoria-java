# Ejercicio 05 · El ahorcado

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐⭐
**Conceptos:** todo el tema (dividir un programa en métodos, parámetros, `return`, arrays como parámetro) + `String`, `char[]`, bucles con banderas, `switch` y `Random`

## Enunciado

Programa el juego del **ahorcado**. El ordenador elige una palabra al azar de una lista y el jugador tiene que adivinarla letra a letra antes de cometer **6 fallos**.

El `main` ya está escrito en [`Ej10_05_ElAhorcado.java`](Ej10_05_ElAhorcado.java) y se lee como un resumen del juego. Tu trabajo es escribir los **métodos** que usa:

| Método | Qué hace |
|---|---|
| `elegirPalabra(palabras, random)` | Devuelve una palabra al azar del array |
| `crearProgreso(palabra)` | Devuelve un `char[]` del tamaño de la palabra, lleno de `'_'` |
| `mostrarProgreso(progreso)` | Muestra el progreso con espacios: `_ a _ a _ _` |
| `dibujarAhorcado(fallos)` | Dibuja el muñeco según los fallos (0 a 6), con un `switch` |
| `leerLetra(teclado, usadas)` | Pide una letra hasta que sea **una sola letra** y **no se haya usado**; la devuelve en minúscula |
| `revelar(palabra, progreso, letra)` | **Modifica** `progreso` destapando la letra en todas sus posiciones; devuelve cuántas ha destapado |
| `estaCompleta(progreso)` | `true` si ya no queda ningún `'_'` (con bandera, sin `break` ni `return` dentro del bucle) |

## Salida de ejemplo

```
=== EL AHORCADO ===

  +---+
      |
      |
      |
     ===
Palabra: _ _ _ _ _ _ _ _
Letras usadas: 
Fallos: 0 de 6
Letra: e
  ¡Bien! La 'e' aparece 1 vez/veces.
...
Letra: ab
  Escribe una sola letra.
Letra: e
  Ya has usado la 'e'.
...
¡Has ganado! La palabra era: variable
```

## Pistas

<details>
<summary>Pista 1</summary>

Para guardar las letras usadas basta un `String` al que se le van añadiendo (`usadas += letra`). Para saber si una letra ya se usó: `usadas.indexOf(letra) != -1`.

</details>

<details>
<summary>Pista 2</summary>

`leerLetra` es un bucle con bandera, como la validación del tema 07:

```java
boolean valida = false;
char letra = ' ';
while (!valida) {
    String entrada = teclado.nextLine().strip().toLowerCase();
    if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
        ...
    } else if (...) {
        ...
    } else {
        letra = entrada.charAt(0);
        valida = true;
    }
}
return letra;
```

</details>

<details>
<summary>Pista 3</summary>

`dibujarAhorcado` puede usar un `switch` moderno con un bloque de texto en cada caso, o construir el dibujo línea a línea con ternarios: `(fallos >= 1 ? "O" : " ")`.

</details>

## Cómo ejecutarlo

```bash
java Ej10_05_ElAhorcado.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-05-el-ahorcado/SOLUCION.md).
