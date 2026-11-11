# Solución · Ejercicio 04 · Lista de reproducción

[⬅️ Enunciado](../../ejercicio-04-lista-de-reproduccion/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

El array tiene huecos al final, y `cantidad` marca la frontera:

```
canciones →  [ Eye ][ Lose ][ Titan ][ null ]       capacidad = 4
                                       ↑
                                   cantidad = 3  (siguiente hueco libre)
```

Dos reglas que mantienen la lista siempre correcta:

1. Las canciones ocupan **siempre** las posiciones `0` a `cantidad - 1`, sin huecos.
2. Todos los recorridos van hasta `cantidad`, nunca hasta `canciones.length`.

## Código explicado

**Agregar en el primer hueco:**

```java
boolean agregar(Cancion cancion) {
    boolean hayHueco = cantidad < canciones.length;
    if (hayHueco) {
        canciones[cantidad] = cancion;
        cantidad++;
    }
    return hayHueco;
}
```

**Buscar la posición** (método auxiliar que reutilizan `buscar` y `eliminar`):

```java
int posicionDe(String titulo) {
    int posicion = -1;
    int i = 0;
    while (i < cantidad && posicion == -1) {
        if (canciones[i].titulo.equalsIgnoreCase(titulo)) {
            posicion = i;
        }
        i++;
    }
    return posicion;
}

Cancion buscar(String titulo) {
    int posicion = posicionDe(titulo);
    return posicion == -1 ? null : canciones[posicion];
}
```

Una clase puede tener métodos "de ayuda" para sí misma, aunque no los use el `main`.

**Eliminar desplazando:**

```java
boolean eliminar(String titulo) {
    int posicion = posicionDe(titulo);
    if (posicion != -1) {
        for (int i = posicion; i < cantidad - 1; i++) {
            canciones[i] = canciones[i + 1];
        }
        canciones[cantidad - 1] = null;
        cantidad--;
    }
    return posicion != -1;
}
```

```
Antes:   [ Eye ][ Lose ][ Titan ][ Strong ]   cantidad = 4
Después: [ Eye ][ Titan ][ Strong ][ null ]   cantidad = 3
```

**Más larga** con `null` como "todavía ninguna":

```java
Cancion masLarga() {
    Cancion mas = null;
    for (int i = 0; i < cantidad; i++) {
        if (mas == null || canciones[i].duracion > mas.duracion) {
            mas = canciones[i];
        }
    }
    return mas;
}
```

## ¿No hay una forma más fácil?

Sí: `ArrayList` (tema 16) hace todo esto por ti: crece sola, añade, busca y elimina desplazando. Pero programarlo a mano una vez te ayuda a entender qué hace por dentro y por qué eliminar del principio de una lista grande es más lento que del final.

## Errores comunes

- Recorrer hasta `canciones.length` → `NullPointerException` en las posiciones vacías.
- Olvidar `cantidad--` al eliminar → la última canción aparece duplicada.
- Comparar títulos con `==`.

## Código completo

📄 [Sol11_04_ListaDeReproduccion.java](Sol11_04_ListaDeReproduccion.java)
