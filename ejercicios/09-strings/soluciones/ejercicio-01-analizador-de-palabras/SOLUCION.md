# Solución · Ejercicio 01 · Analizador de palabras

[⬅️ Enunciado](../../ejercicio-01-analizador-de-palabras/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Código explicado

```java
System.out.println("Longitud: " + palabra.length());
System.out.println("Primera letra: " + palabra.charAt(0));
System.out.println("Última letra: " + palabra.charAt(palabra.length() - 1));
System.out.println("En mayúsculas: " + palabra.toUpperCase());
System.out.println("En minúsculas: " + palabra.toLowerCase());
System.out.println("Primera mitad: " + palabra.substring(0, palabra.length() / 2));
System.out.println("Posición de la primera 'a': " + palabra.toLowerCase().indexOf('a'));
System.out.println("¿Contiene \"gram\"? " + palabra.contains("gram"));
```

- `charAt(length() - 1)`: el último índice es uno menos que la longitud.
- `length() / 2` es una división **entera**: con 13 letras daría 6.
- `toLowerCase().indexOf('a')`: primero convertimos y luego buscamos, así también encuentra una `A` mayúscula. La palabra original no cambia (los `String` son inmutables).
- `toUpperCase` también convierte las letras con tilde: `ó` → `Ó`.

## Errores comunes

- `palabra.length` sin paréntesis → error de compilación.
- `palabra.charAt(palabra.length())` → `StringIndexOutOfBoundsException`.
- Si el usuario no escribe nada, `charAt(0)` falla. Podrías comprobarlo antes con `palabra.isEmpty()`.

## Código completo

📄 [Sol09_01_AnalizadorDePalabras.java](Sol09_01_AnalizadorDePalabras.java)
