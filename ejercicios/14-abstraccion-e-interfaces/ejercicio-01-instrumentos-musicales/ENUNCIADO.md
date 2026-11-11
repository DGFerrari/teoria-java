# Ejercicio 01 · Instrumentos musicales

[⬅️ Ejercicios del tema](../README.md)

**Dificultad:** ⭐
**Conceptos:** clase abstracta, métodos abstractos, métodos normales que usan los abstractos

## Enunciado

Completa [`Ej14_01_InstrumentosMusicales.java`](Ej14_01_InstrumentosMusicales.java):

1. Convierte `Instrumento` en una clase **abstracta** con dos métodos **abstractos**: `tocar()` (devuelve el sonido) y `getFamilia()` (cuerda, tecla, percusión...).
2. Crea `Guitarra`, `Piano` y `Bateria`, que hereden de `Instrumento` e implementen los dos métodos.
3. El método `presentar()` de `Instrumento` (ya escrito) usa los dos métodos abstractos.

## Salida esperada

```
Guitarra (cuerda) suena: ♪ Tlan, tlan, tlaaan
Piano (tecla) suena: ♪ Plin, plon, plin
Batería (percusión) suena: ♪ Pum, tchs, pum-pum, tchs
```

## Pistas

<details>
<summary>Pista 1</summary>

```java
abstract static class Instrumento {
    ...
    public abstract String tocar();
    public abstract String getFamilia();
}
```

Un método abstracto termina en `;` y no tiene llaves.

</details>

<details>
<summary>Pista 2</summary>

Cada subclase necesita un constructor que llame a `super(nombre)`, y los dos métodos con `@Override`.

</details>

## Cómo ejecutarlo

```bash
java Ej14_01_InstrumentosMusicales.java
```

> ⚠️ La plantilla **no compila** hasta que crees las tres subclases, porque el `main` ya las usa.

---

✅ ¿Terminado? Compara con la [solución](../soluciones/ejercicio-01-instrumentos-musicales/SOLUCION.md).
