# Solución · Ejercicio 01 · Ficha de personaje

[⬅️ Enunciado](../../ejercicio-01-ficha-de-personaje/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Para cada dato, pregúntate: ¿es texto o un carácter? ¿Es número entero o decimal? ¿Cómo de grande puede ser? ¿Es un sí/no?

| Dato | Tipo | Por qué |
|---|---|---|
| Nombre | `String` | Texto de varias letras |
| Clase | `char` | Una sola letra |
| Nivel | `int` | Entero pequeño |
| Vida | `double` | Tiene decimales |
| Oro | `long` | Entero que no cabe en `int` |
| Envenenada | `boolean` | Sí o no |

## Código explicado

```java
char clase = 'M';                 // Comillas SIMPLES
int nivel = 12;
double vida = 87.5;
long oro = 3_500_000_000L;        // Sin la L: "integer number too large"
boolean envenenada = false;       // Sin comillas
```

- Los `_` del número son opcionales y solo ayudan a leerlo.
- Aunque el dato se pueda guardar en un `String` (`"12"`), no es buena idea: con un texto no podrías hacer cálculos (subir de nivel, restar vida...).

## Errores comunes

- `char clase = "M";` → error: `"M"` es un `String`.
- `long oro = 3500000000;` → error: el literal se interpreta como `int` y no cabe.
- `boolean envenenada = "false";` → error: `"false"` es texto, no un valor lógico.

## Código completo

📄 [Sol03_01_FichaDePersonaje.java](Sol03_01_FichaDePersonaje.java)
