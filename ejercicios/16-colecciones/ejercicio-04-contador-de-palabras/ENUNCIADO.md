# Ejercicio 04 · Contador de palabras

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐⭐⭐
**Conceptos:** `Map<String, Integer>` con el patrón contador, `getOrDefault`, recorrer con `entrySet`, mapas cuyos valores son listas, ordenar con `Comparable` y `Collections.sort`

## Enunciado

Analiza el comienzo del Quijote. En [`Ej16_04_ContadorDePalabras.java`](Ej16_04_ContadorDePalabras.java) el método `palabras(texto)` ya divide el texto en palabras. Completa:

| Método | Qué hace |
|---|---|
| `contar(palabras)` | `TreeMap` palabra → veces que aparece |
| `soloRepetidas(frecuencias)` | Un mapa nuevo con las palabras que aparecen más de una vez |
| `top(frecuencias, n)` | Las `n` palabras más frecuentes. Si empatan, en orden alfabético |
| `indicePorInicial(frecuencias)` | `TreeMap` inicial (en mayúscula) → lista de palabras que empiezan por ella |

Para `top`, la clase `Frecuencia` tiene que implementar `Comparable<Frecuencia>`: un mapa no se puede ordenar por sus valores, pero una **lista de objetos `Frecuencia`** sí.

En el `main`, muestra además la palabra **más larga** (si hay empate, la primera en orden alfabético).

## Salida esperada

```
Palabras: 33 | Distintas: 27
Repetidas: {de=4, en=2, no=2, un=2}
=== Top 3 ===
1. de (4)
2. en (2)
3. no (2)
=== Índice por inicial ===
A: acordarme, adarga, antigua, astillero
C: corredor, cuyo
D: de
E: en
F: flaco
G: galgo
H: ha, hidalgo
L: la, lanza, los, lugar
M: mancha, mucho
N: no, nombre
Q: que, quiero
R: rocín
T: tiempo
U: un
V: vivía
Y: y
Palabra más larga: acordarme (9 letras)
```

## Pistas

<details>
<summary>Pista 1</summary>

El patrón contador en una línea:

```java
frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
```

</details>

<details>
<summary>Pista 2</summary>

`compareTo` con dos criterios, como en el ranking del tema 14:

```java
int resultado = Integer.compare(otra.veces, veces);   // Al revés: de más a menos
if (resultado == 0) {
    resultado = palabra.compareTo(otra.palabra);
}
return resultado;
```

</details>

<details>
<summary>Pista 3</summary>

Para el índice, la primera vez que aparece una inicial hay que crear su lista:

```java
if (!indice.containsKey(inicial)) {
    indice.put(inicial, new ArrayList<>());
}
indice.get(inicial).add(palabra);
```

Si recorres las claves de `frecuencias` (que es un `TreeMap`), las palabras llegan ya ordenadas y cada lista queda en orden alfabético.

</details>

## Cómo ejecutarlo

```bash
java Ej16_04_ContadorDePalabras.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-04-contador-de-palabras/SOLUCION.md).
