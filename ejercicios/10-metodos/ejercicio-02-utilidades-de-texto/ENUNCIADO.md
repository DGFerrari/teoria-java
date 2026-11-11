# Ejercicio 02 · Utilidades de texto

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** métodos con `String`, un método que usa a otros, documentación Javadoc

## Enunciado

Vas a crear una pequeña "biblioteca" de métodos de texto. Completa los métodos de [`Ej10_02_UtilidadesDeTexto.java`](Ej10_02_UtilidadesDeTexto.java):

| Método | Qué hace | Ejemplo |
|---|---|---|
| `capitalizar(texto)` | Primera letra en mayúscula, resto en minúscula | `"jAVA"` → `"Java"` |
| `contarVocales(texto)` | Cuenta las vocales (con o sin tilde) | `"Murciélago"` → `5` |
| `invertir(texto)` | Le da la vuelta | `"hola"` → `"aloh"` |
| `esPalindromo(texto)` | ¿Se lee igual al revés? (ignora mayúsculas y espacios). **Debe usar `invertir`**. | `"Ana lava lana"` → `true` |
| `repetir(texto, veces, separador)` | Repite el texto con un separador entre medias | `("ja", 3, "-")` → `"ja-ja-ja"` |

Escribe también el **comentario Javadoc** de `repetir` con `@param` y `@return`.

## Salida esperada

```
capitalizar("jAVA") → Java
capitalizar("") → 
contarVocales("Murciélago") → 5
invertir("hola") → aloh
esPalindromo("Ana lava lana") → true
esPalindromo("Hola mundo") → false
repetir("ja", 3, "-") → ja-ja-ja
repetir("eco", 1, " ") → eco
```

## Pistas

<details>
<summary>Pista 1</summary>

`capitalizar("")` no puede hacer `substring(0, 1)` (daría error). Comprueba primero si el texto está vacío y, en ese caso, devuélvelo tal cual.

</details>

<details>
<summary>Pista 2</summary>

En `esPalindromo`, prepara primero el texto (`toLowerCase()` y `replace(" ", "")`) y compáralo con `invertir(textoPreparado)` usando `equals`.

</details>

<details>
<summary>Pista 3</summary>

En `repetir`, el separador va **entre** las repeticiones: antes de cada una salvo la primera. Usa un `StringBuilder`.

</details>

## Cómo ejecutarlo

```bash
java Ej10_02_UtilidadesDeTexto.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-utilidades-de-texto/SOLUCION.md).
