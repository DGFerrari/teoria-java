# Solución · Ejercicio 02 · Canciones

[⬅️ Enunciado](../../ejercicio-02-canciones/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Código explicado

**Constructores encadenados:**

```java
Cancion(String titulo, String artista, int duracionSegundos) {
    this.titulo = titulo;
    this.artista = artista;
    this.duracionSegundos = duracionSegundos;
    this.reproducciones = 0;
}

Cancion(String titulo, String artista) {
    this(titulo, artista, 0);
}
```

Toda la lógica de inicialización está en **un solo** constructor. El corto solo aporta el valor que falta. Si mañana hubiera que inicializar otro atributo, se cambiaría en un único sitio.

**Duración formateada** con `/`, `%` y `%02d`:

```java
String duracionFormateada() {
    if (duracionSegundos == 0) {
        return "?:??";
    } else {
        return String.format("%d:%02d", duracionSegundos / 60, duracionSegundos % 60);
    }
}
```

`%02d` rellena con un 0 a la izquierda: 5 segundos se muestran como `05`.

**toString** reutiliza `duracionFormateada()`:

```java
@Override
public String toString() {
    return titulo + " - " + artista + " [" + duracionFormateada() + "] (" + reproducciones + " reproducciones)";
}
```

## Errores comunes

- `titulo = titulo;` sin `this` → el atributo se queda en `null`.
- Poner `this(...)` en la segunda línea del constructor → error de compilación: `call to this must be first statement`.
- Escribir `public string toString()` (minúscula) o sin `public` → no se usa al imprimir (o no compila con `@Override`).

## Código completo

📄 [Sol11_02_Canciones.java](Sol11_02_Canciones.java)
