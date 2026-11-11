# Ejercicio 02 · Dispositivos

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** definir interfaces, implementar varias a la vez, métodos `default`, interfaces como tipo, `instanceof` con interfaces

## Enunciado

En [`Ej14_02_Dispositivos.java`](Ej14_02_Dispositivos.java) ya tienes dos interfaces:

```java
interface Encendible {
    void encender();
    void apagar();
    boolean estaEncendido();
}

interface Recargable {
    int getBateria();
    void cargar(int porcentaje);
    default boolean necesitaCarga() { ... }   // TODO
}
```

1. Completa el método `default` `necesitaCarga()`: `true` si la batería está por debajo del 20 %.
2. Crea las clases:

| Clase | Implementa | Detalles |
|---|---|---|
| `Lampara` | `Encendible` | Nada más |
| `Movil` | `Encendible` y `Recargable` | No se puede encender con 0 % de batería. La carga no pasa de 100 |
| `PowerBank` | `Recargable` | La carga no pasa de 100 |

Todas tienen un `toString()` con su estado. El `main` ya está hecho.

## Salida esperada

```
Lámpara: encendida
Móvil: apagado, batería 0% (necesita carga)
PowerBank: batería 15% (necesita carga)
--- Cargando todos los recargables un 50% ---
Lámpara: encendida
Móvil: encendido, batería 50%
PowerBank: batería 65%
--- Apagando todos los encendibles ---
Lámpara: apagada
Móvil: apagado, batería 50%
PowerBank: batería 65%
```

## Pistas

<details>
<summary>Pista 1</summary>

`necesitaCarga()` puede llamar a `getBateria()` aunque sea abstracto: cuando se ejecute, ya habrá un objeto concreto que lo implemente.

</details>

<details>
<summary>Pista 2</summary>

El `main` recorre un `Object[]` y usa `instanceof Recargable r` / `instanceof Encendible e` para saber qué puede hacer cada objeto.

</details>

## Cómo ejecutarlo

```bash
java Ej14_02_Dispositivos.java
```

> ⚠️ La plantilla **no compila** hasta que crees las tres clases.

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-dispositivos/SOLUCION.md).
