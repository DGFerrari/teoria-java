# Solución · Ejercicio 03 · Métodos con arrays

[⬅️ Enunciado](../../ejercicio-03-metodos-con-arrays/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Los siete métodos se reparten en tres grupos según cómo tratan el array:

| Grupo | Métodos | ¿Cambia el array? |
|---|---|---|
| **Modifica** el array recibido | `rellenarAleatorio` | Sí (por eso es `void`) |
| **Consulta** el array | `mostrar`, `media`, `posicionDelMaximo`, `contarMayoresQue` | No |
| **Crea** un array nuevo | `filtrarPares` | No: devuelve otro |

## Código explicado

**Modificar el array recibido:**

```java
static void rellenarAleatorio(int[] datos, Random random, int min, int max) {
    for (int i = 0; i < datos.length; i++) {
        datos[i] = random.nextInt(min, max + 1);
    }
}
```

El parámetro `datos` apunta al **mismo** array que la variable del `main`, así que no hace falta devolver nada.

**Sobrecarga que reutiliza:**

```java
static void mostrar(int[] datos) {
    StringBuilder texto = new StringBuilder("[");
    for (int i = 0; i < datos.length; i++) {
        if (i > 0) {
            texto.append(", ");
        }
        texto.append(datos[i]);
    }
    texto.append("]");
    System.out.println(texto);
}

static void mostrar(int[] datos, String titulo) {
    System.out.print(titulo + ": ");
    mostrar(datos);                     // Llama a la otra versión
}
```

**Crear un array nuevo en dos pasos:**

```java
static int[] filtrarPares(int[] datos) {
    int cantidad = 0;
    for (int dato : datos) {            // 1º: ¿cuántos hay? (para saber el tamaño)
        if (dato % 2 == 0) {
            cantidad++;
        }
    }
    int[] pares = new int[cantidad];
    int siguiente = 0;                  // Siguiente hueco libre en "pares"
    for (int dato : datos) {            // 2º: copiarlos
        if (dato % 2 == 0) {
            pares[siguiente] = dato;
            siguiente++;
        }
    }
    return pares;
}
```

Hacen falta dos recorridos porque el tamaño de un array se fija al crearlo. Con un `ArrayList` (tema 16) bastaría con uno.

## Errores comunes

- `return datos;` al final de `rellenarAleatorio` sin necesidad (y con tipo `void` no compila).
- Usar el índice `i` del array original para escribir en `pares` → `ArrayIndexOutOfBoundsException` o huecos con 0.
- Repetir el código de `mostrar` en la versión con título en lugar de llamarla.

## Código completo

📄 [Sol10_03_MetodosConArrays.java](Sol10_03_MetodosConArrays.java)
