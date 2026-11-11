# Solución · Ejercicio 01 · Receta en orden

[⬅️ Enunciado](../../ejercicio-01-receta-en-orden/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

El ejercicio trata de la **secuencia**: cada paso necesita que los anteriores estén hechos. Una forma sencilla de ordenarlos es buscar las **dependencias** de cada paso:

| Paso | ¿Qué necesita antes? |
|---|---|
| Cortar una rebanada de pan | Nada, es el primero |
| Meter el pan en la tostadora | Tener el pan cortado |
| Sacar el pan de la tostadora | Haberlo metido |
| Rallar medio tomate | Nada (puede ir en cualquier momento antes de untar) |
| Untar el tomate sobre el pan | Tener el tomate rallado y el pan tostado |
| Echar aceite y sal | Tener el tomate untado |
| Comer la tostada | Todo lo anterior |

## Pseudocódigo

```
INICIO
    ESCRIBIR "=== Tostada con tomate ==="
    ESCRIBIR "1. Cortar una rebanada de pan"
    ESCRIBIR "2. Meter el pan en la tostadora y esperar"
    ESCRIBIR "3. Rallar medio tomate"
    ESCRIBIR "4. Sacar el pan de la tostadora"
    ESCRIBIR "5. Untar el tomate sobre el pan"
    ESCRIBIR "6. Echar un chorrito de aceite y una pizca de sal"
    ESCRIBIR "7. Comer la tostada"
    ESCRIBIR "¡Buen provecho!"
FIN
```

Rallar el tomate mientras el pan se tuesta es lo más eficiente, pero también sería correcto rallarlo antes de meter el pan o justo después de sacarlo.

## Código explicado

Cada `ESCRIBIR` del pseudocódigo se convierte en un `System.out.println(...)`:

```java
System.out.println("2. Meter el pan en la tostadora y esperar");
System.out.println("3. Rallar medio tomate");
```

- El texto va entre **comillas dobles** `" "`.
- Cada instrucción termina en **punto y coma** `;`.
- Java ejecuta las líneas **de arriba abajo**, así que el orden del código es el orden de la salida.

## Errores comunes

- **Olvidar el `;`** al final de la línea: Java da un error de compilación (`';' expected`).
- **Usar comillas simples** `'Texto'`: en Java las comillas simples son para un solo carácter, no para textos.
- **Escribir `system.out.println`** en minúscula: Java distingue mayúsculas y minúsculas; es `System`.

## Otras formas de resolverlo

Cualquier orden que respete las dependencias de la tabla es válido. Lo que no es válido es, por ejemplo, untar el tomate antes de rallarlo.

## Código completo

📄 [Sol01_01_RecetaEnOrden.java](Sol01_01_RecetaEnOrden.java)
