# Solución · Ejercicio 01 · Animales

[⬅️ Enunciado](../../ejercicio-01-animales/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Código explicado

```java
static class Perro extends Animal {
    private final String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);       // La parte de Animal la inicializa Animal
        this.raza = raza;          // La parte propia, la subclase
    }

    public String ladrar() {
        return nombre + " dice ¡Guau!";   // nombre es protected: se usa directamente
    }

    public String getRaza() {
        return raza;
    }
}

static class Gato extends Animal {
    private final boolean casero;

    public Gato(String nombre, int edad, boolean casero) {
        super(nombre, edad);
        this.casero = casero;
    }

    public String maullar() {
        return casero ? nombre + " dice ¡Miau!" : nombre + " dice ¡MIAU! (y se escapa por la ventana)";
    }

    public boolean isCasero() {
        return casero;
    }
}
```

- Ninguna subclase repite `nombre`, `edad`, `describir()` ni `cumplirAnios()`: los **heredan**.
- Cada subclase solo escribe **lo que la diferencia**.
- El atributo nuevo es `private`: es un detalle de la subclase.

## Errores comunes

- Volver a declarar `nombre` en `Perro` → se crearía **otro** atributo que "tapa" al de `Animal`, y `describir()` mostraría el de `Animal` (vacío).
- Olvidar `super(nombre, edad)` → error: `Animal` no tiene constructor sin parámetros.
- Poner `super(...)` después de `this.raza = raza;` → error: debe ser la primera instrucción.

## Código completo

📄 [Sol13_01_Animales.java](Sol13_01_Animales.java)
