# Ejercicio 02 · Bombilla inteligente

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐⭐
**Conceptos:** estado privado que solo cambia con métodos con reglas, getters `is...`, atributo `final`, `boolean` como respuesta

## Enunciado

Completa la clase `Bombilla` de [`Ej12_02_BombillaInteligente.java`](Ej12_02_BombillaInteligente.java). Ningún atributo tiene setter "libre": solo cambian con estos métodos.

| Atributo | Detalle |
|---|---|
| `ubicacion` | `final`: no cambia nunca |
| `encendida` | Empieza en `false` |
| `brillo` | De 0 a 100. Empieza en 50 |
| `vecesEncendida` | Cuántas veces se ha pasado de apagada a encendida |

| Método | Regla |
|---|---|
| `encender()` | Si estaba apagada, la enciende y suma 1 a `vecesEncendida`. Si ya estaba encendida, no hace nada |
| `apagar()` | La apaga |
| `setBrillo(valor)` | Solo si está **encendida** y el valor está entre 0 y 100. Devuelve si lo ha cambiado |
| `subirBrillo(paso)` / `bajarBrillo(paso)` | Solo si está encendida. Sin pasarse de 100 ni bajar de 0 |
| `isEncendida()`, `getBrillo()`, `getVecesEncendida()`, `getUbicacion()` | Getters |
| `toString()` | `"Salón: ENCENDIDA al 80%"` o `"Salón: apagada"` |

## Salida esperada

```
Salón: apagada
¿Brillo a 80 con la bombilla apagada? false
Salón: ENCENDIDA al 50%
Salón: ENCENDIDA al 100%
¿Brillo a 150? false
Salón: ENCENDIDA al 65%
Salón: apagada
Salón: ENCENDIDA al 65%
Veces encendida: 2
```

## Pistas

<details>
<summary>Pista 1</summary>

Para no pasarse de los límites: `brillo = Math.min(100, brillo + paso);` y `brillo = Math.max(0, brillo - paso);`.

</details>

<details>
<summary>Pista 2</summary>

En `encender`, el contador solo sube si **antes** estaba apagada:

```java
if (!encendida) {
    encendida = true;
    vecesEncendida++;
}
```

</details>

## Cómo ejecutarlo

```bash
java Ej12_02_BombillaInteligente.java
```

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-02-bombilla-inteligente/SOLUCION.md).
