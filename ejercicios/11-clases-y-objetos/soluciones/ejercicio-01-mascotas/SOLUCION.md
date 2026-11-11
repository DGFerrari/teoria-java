# Solución · Ejercicio 01 · Mascotas

[⬅️ Enunciado](../../ejercicio-01-mascotas/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Código explicado

**La clase:**

```java
static class Mascota {
    String nombre;
    String especie;
    int edad;

    String presentarse() {
        return "Soy " + nombre + ", un " + especie + " de " + edad + " años";
    }

    void cumplirAnios() {
        edad++;
    }

    boolean esJoven() {
        return edad < 2;
    }
}
```

Dentro de los métodos, `nombre`, `especie` y `edad` son los atributos del objeto **sobre el que se llama** el método. Por eso `toby.presentarse()` y `misi.presentarse()` dan resultados distintos con el mismo código.

**Usar los objetos:**

```java
Mascota toby = new Mascota();
toby.nombre = "Toby";
toby.especie = "perro";
toby.edad = 3;

System.out.println(toby.presentarse());
System.out.println("¿" + toby.nombre + " es joven? " + toby.esJoven());
```

`cumplirAnios()` cambia **solo** la edad de la mascota sobre la que se llama: las otras no se enteran.

## Errores comunes

- Poner `static` en los métodos de `Mascota` → no pueden usar los atributos: `non-static variable cannot be referenced from a static context`.
- Olvidar el `new` → `variable toby might not have been initialized`.
- Mostrar `toby` directamente → sale algo como `Ej11_01_Mascotas$Mascota@1b6d3586`. Para eso está `toString` (ejercicio 02).

## Código completo

📄 [Sol11_01_Mascotas.java](Sol11_01_Mascotas.java)
