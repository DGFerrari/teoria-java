# Solución · Ejercicio 01 · Preséntate

[⬅️ Enunciado](../../ejercicio-01-presentate/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Es un programa de pura **secuencia**: una línea de salida por cada `println`, en el mismo orden. Lo interesante del ejercicio está en **cómo se ejecuta**.

## Código explicado

```java
System.out.println("Edad: 15 años");
System.out.println("Ciudad: Valencia");
System.out.println("Lo que más me gusta: la música");
System.out.println("Quiero aprender Java para: hacer videojuegos");
System.out.println("==============================");
```

## Las dos formas de ejecutar

| Forma | Comandos | ¿Crea `.class`? |
|---|---|---|
| Un paso | `java Ej02_01_Presentate.java` | No (compila en memoria) |
| Dos pasos | `javac Ej02_01_Presentate.java` → `java Ej02_01_Presentate` | Sí |

En la forma de dos pasos, `javac` traduce el código a **bytecode** y lo guarda en `Ej02_01_Presentate.class`. Luego `java` arranca la JVM y le dice qué **clase** ejecutar (por eso no se pone la extensión).

El repositorio tiene un `.gitignore` que evita que los `.class` se suban a Git por error.

## Errores comunes

- `java Ej02_01_Presentate.class` → `ClassNotFoundException`. Sin extensión.
- Renombrar el archivo sin cambiar el nombre de la clase (o al revés) → `class Ej02_01_Presentate is public, should be declared in a file named...`
- Ejecutar `javac` desde otra carpeta → `file not found`. Tienes que estar en la carpeta del archivo (o poner la ruta).

## Código completo

📄 [Sol02_01_Presentate.java](Sol02_01_Presentate.java)
