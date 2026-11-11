# Solución · Ejercicio 01 · Instrumentos musicales

[⬅️ Enunciado](../../ejercicio-01-instrumentos-musicales/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Código explicado

```java
abstract static class Instrumento {
    private final String nombre;

    protected Instrumento(String nombre) {
        this.nombre = nombre;
    }

    public abstract String tocar();
    public abstract String getFamilia();

    public String presentar() {
        return nombre + " (" + getFamilia() + ") suena: ♪ " + tocar();
    }
}

static class Guitarra extends Instrumento {
    public Guitarra() {
        super("Guitarra");
    }

    @Override
    public String tocar() {
        return "Tlan, tlan, tlaaan";
    }

    @Override
    public String getFamilia() {
        return "cuerda";
    }
}
```

- `presentar()` está escrito en la clase abstracta **sin saber** cómo suena cada instrumento: confía en que cada subclase implementará `tocar()`. El compilador lo **garantiza**.
- El constructor de `Instrumento` es `protected`: solo lo usan las subclases (de todas formas, una clase abstracta no se puede instanciar).

## ¿Qué ganamos frente al tema 13?

| Sin `abstract` (tema 13) | Con `abstract` |
|---|---|
| `new Instrumento("?")` es posible | Error de compilación |
| `tocar()` necesitaba un cuerpo "de relleno" | Sin cuerpo |
| Si una subclase olvida `tocar()`, usa el de relleno sin avisar | **Error de compilación** |

## Código completo

📄 [Sol14_01_InstrumentosMusicales.java](Sol14_01_InstrumentosMusicales.java)
