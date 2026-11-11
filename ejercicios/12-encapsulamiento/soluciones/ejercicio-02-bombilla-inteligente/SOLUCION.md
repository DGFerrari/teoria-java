# Solución · Ejercicio 02 · Bombilla inteligente

[⬅️ Enunciado](../../ejercicio-02-bombilla-inteligente/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

En lugar de setters "tontos" (`setEncendida(true)`, `setVecesEncendida(7)`), la clase ofrece **acciones** con significado: `encender`, `apagar`, `subirBrillo`. Cada una aplica las reglas del dispositivo. Así es imposible, por ejemplo, que `vecesEncendida` no cuadre con lo que ha pasado.

| Atributo | ¿Getter? | ¿Setter? | Cómo cambia |
|---|---|---|---|
| `ubicacion` | Sí | No (`final`) | Nunca |
| `encendida` | `isEncendida()` | No | `encender()` / `apagar()` |
| `brillo` | Sí | `setBrillo` con reglas | También `subirBrillo` / `bajarBrillo` |
| `vecesEncendida` | Sí | No | Solo dentro de `encender()` |

## Código explicado

```java
public void encender() {
    if (!encendida) {
        encendida = true;
        vecesEncendida++;
    }
}

public boolean setBrillo(int valor) {
    boolean posible = encendida && valor >= 0 && valor <= 100;
    if (posible) {
        brillo = valor;
    }
    return posible;
}

public void subirBrillo(int paso) {
    if (encendida) {
        brillo = Math.min(100, brillo + paso);    // Tope en 100
    }
}

@Override
public String toString() {
    return ubicacion + ": " + (encendida ? "ENCENDIDA al " + brillo + "%" : "apagada");
}
```

Fíjate en que, al apagar y volver a encender, la bombilla **recuerda** su brillo (65 %). El estado se conserva porque está guardado en el objeto.

## Errores comunes

- Contar en `encender()` aunque ya estuviera encendida → `vecesEncendida` sería 3.
- Permitir cambiar el brillo con la bombilla apagada.
- `brillo += paso` sin límite → 120 %.

## Código completo

📄 [Sol12_02_BombillaInteligente.java](Sol12_02_BombillaInteligente.java)
