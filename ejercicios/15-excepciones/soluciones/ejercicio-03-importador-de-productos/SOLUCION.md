# Solución · Ejercicio 03 · Importador de productos

[⬅️ Enunciado](../../ejercicio-03-importador-de-productos/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Cada pieza hace **una** cosa y deja que el error suba hasta quien sabe qué hacer con él:

```mermaid
sequenceDiagram
    participant M as main
    participant D as Producto.desdeLinea
    participant C as constructor de Producto
    M->>D: desdeLinea("P-005;Cable HDMI;-3;50")
    D->>C: new Producto(..., -3.0, 50)
    C--xD: IllegalArgumentException("El precio debe ser positivo")
    D--xM: (no la captura: sigue subiendo)
    Note over M: catch → "Línea 5 ✘ ..." y pasa a la siguiente línea
```

- El **constructor** no sabe nada de líneas ni de números de línea: solo garantiza que no existan productos incorrectos.
- **`desdeLinea`** traduce texto a producto, pero tampoco sabe mostrar errores.
- El **`main`** es quien conoce el número de línea y decide continuar con la siguiente.

## Código explicado

**Validar con `throw`:**

```java
public Producto(String codigo, String nombre, double precio, int stock) {
    if (!esCodigoValido(codigo)) {
        throw new IllegalArgumentException("Código no válido: " + codigo);
    }
    if (nombre.isBlank()) {
        throw new IllegalArgumentException("El nombre no puede estar vacío");
    }
    if (precio <= 0) {
        throw new IllegalArgumentException("El precio debe ser positivo: " + precio);
    }
    if (stock < 0) {
        throw new IllegalArgumentException("El stock no puede ser negativo: " + stock);
    }
    ...
}
```

Comparado con el tema 12 (mensajes y valores por defecto), ahora es **imposible** crear un producto incorrecto: el `new` falla y quien lo llama se entera.

**Traducir y dejar propagar:**

```java
public static Producto desdeLinea(String linea) {
    String[] campos = linea.split(";");
    if (campos.length != 4) {
        throw new IllegalArgumentException("Faltan campos");
    }
    double precio = Double.parseDouble(campos[2]);     // Si falla, NumberFormatException sube
    int stock = Integer.parseInt(campos[3]);
    return new Producto(campos[0].strip(), campos[1].strip(), precio, stock);
}
```

**Capturar en el sitio adecuado, con el orden correcto:**

```java
for (int i = 0; i < lineas.length; i++) {
    try {
        importados[numImportados] = Producto.desdeLinea(lineas[i]);
        numImportados++;
    } catch (NumberFormatException e) {
        System.out.println("Línea " + (i + 1) + " ✘ Número no válido (" + e.getMessage() + ")");
        errores++;
    } catch (IllegalArgumentException e) {
        System.out.println("Línea " + (i + 1) + " ✘ " + e.getMessage());
        errores++;
    }
}
```

Si `desdeLinea` lanza, la asignación no se completa y `numImportados++` no se ejecuta: el hueco se reutiliza con el siguiente producto válido.

## Errores comunes

- Poner primero `catch (IllegalArgumentException e)` → no compila (el segundo `catch` sería inalcanzable).
- Capturar dentro del constructor → el producto se crearía igualmente, con datos incorrectos.
- Un único `try` alrededor de **todo** el bucle → el primer error detiene la importación entera.

## Código completo

📄 [Sol15_03_ImportadorDeProductos.java](Sol15_03_ImportadorDeProductos.java)
