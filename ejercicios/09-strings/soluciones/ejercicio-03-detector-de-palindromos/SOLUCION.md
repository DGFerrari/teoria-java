# Solución · Ejercicio 03 · Detector de palíndromos

[⬅️ Enunciado](../../ejercicio-03-detector-de-palindromos/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Comparar `"Dábale arroz a la zorra el abad"` con su inversa directamente daría `false` por las mayúsculas, las tildes y los espacios. Antes hay que **normalizar**:

| Paso | Resultado |
|---|---|
| Original | `Dábale arroz a la zorra el abad` |
| Minúsculas | `dábale arroz a la zorra el abad` |
| Sin tildes | `dabale arroz a la zorra el abad` |
| Solo letras y dígitos | `dabalearrozalazorraelabad` |

## Código explicado

**Normalizar:**

```java
String sinTildes = frase.toLowerCase()
        .replace('á', 'a').replace('é', 'e').replace('í', 'i')
        .replace('ó', 'o').replace('ú', 'u').replace('ü', 'u');

StringBuilder limpia = new StringBuilder();
for (char c : sinTildes.toCharArray()) {
    if (Character.isLetterOrDigit(c)) {
        limpia.append(c);
    }
}
String normalizada = limpia.toString();
```

Cada `replace` devuelve un `String` nuevo sobre el que se aplica el siguiente: es el **encadenamiento** de la teoría.

**Primera forma:**

```java
String alReves = new StringBuilder(normalizada).reverse().toString();
boolean esPalindromo = normalizada.equals(alReves);
```

**Segunda forma, desde los extremos:**

```java
int izquierda = 0;
int derecha = normalizada.length() - 1;
boolean coinciden = true;
while (izquierda < derecha && coinciden) {
    if (normalizada.charAt(izquierda) != normalizada.charAt(derecha)) {
        coinciden = false;
    }
    izquierda++;
    derecha--;
}
```

```
d a b a l e a r r o z a l a z o r r a e l a b a d
↑                                               ↑   izquierda = 0, derecha = 24
  ↑                                           ↑     izquierda = 1, derecha = 23
                         ...
```

Esta forma es **más eficiente**: solo recorre la mitad, no crea un texto nuevo y **para** en cuanto encuentra una diferencia. Con `"holamundo"` se detiene en la primera comparación (`h` frente a `o`).

Aquí se comparan `char` con `!=`, y eso **sí** es correcto: los `char` son tipos primitivos. El problema de `==` solo existe con objetos como `String`.

## Errores comunes

- Comparar `normalizada == alReves` → `false` aunque sea palíndromo.
- Olvidar `toString()` y comparar un `String` con un `StringBuilder` usando `equals` → siempre `false`.
- No quitar los espacios → `"anita lava la tina"` al revés es `"anit al aval atina"`.

## Código completo

📄 [Sol09_03_DetectorDePalindromos.java](Sol09_03_DetectorDePalindromos.java)
