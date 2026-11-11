# Solución · Ejercicio 05 · Parking

[⬅️ Enunciado](../../ejercicio-05-parking/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Cada pieza tiene su responsabilidad:

| Pieza | Sabe... |
|---|---|
| `Vehiculo` | Su matrícula y su hora de entrada, y cómo mostrarse |
| `Parking` | Qué plazas hay, quién ocupa cada una, las tarifas y lo recaudado |
| Métodos `static` de `Parking` | Convertir y validar horas (no dependen de ningún parking concreto) |
| `main` | Hablar con el usuario: menú, preguntas y mensajes |

Fíjate en que `Parking` **no** usa el `Scanner` ni muestra mensajes de error: devuelve códigos (`-1`, `-2`) y el `main` decide qué decir. Así la clase se podría reutilizar en una aplicación con ventanas o en una web.

## Código explicado

**Primera plaza libre, con bandera:**

```java
int aparcar(Vehiculo vehiculo) {
    int resultado;
    if (buscarPlaza(vehiculo.matricula) != -1) {
        resultado = -2;                        // Ya está dentro
    } else {
        int libre = -1;
        int i = 0;
        while (i < plazas.length && libre == -1) {
            if (plazas[i] == null) {
                libre = i;
            }
            i++;
        }
        if (libre != -1) {
            plazas[libre] = vehiculo;
            resultado = libre + 1;             // Para el usuario, las plazas empiezan en 1
        } else {
            resultado = -1;                    // Lleno
        }
    }
    return resultado;
}
```

`buscarPlaza` tiene que saltarse las plazas `null` antes de mirar la matrícula: `plazas[i] != null && plazas[i].matricula.equals(matricula)`. El cortocircuito de `&&` evita el `NullPointerException`.

**Retirar y cobrar:**

```java
double retirar(String matricula, int minutoSalida) {
    double importe = -1;
    int plaza = buscarPlaza(matricula);
    if (plaza != -1) {
        int minutos = minutoSalida - plazas[plaza].minutoEntrada;
        importe = Math.max(minutos * tarifaPorMinuto, importeMinimo);
        recaudado += importe;
        vehiculosAtendidos++;
        plazas[plaza] = null;                  // La plaza queda libre
    }
    return importe;
}
```

`Math.max` aplica el mínimo de forma elegante: si el cálculo da menos de 1 €, se cobra 1 €.

**Validar la hora** en orden, de lo más básico a lo más concreto:

```java
static boolean esHoraValida(String hora) {
    boolean formato = hora.length() == 5 && hora.charAt(2) == ':'
            && Character.isDigit(hora.charAt(0)) && Character.isDigit(hora.charAt(1))
            && Character.isDigit(hora.charAt(3)) && Character.isDigit(hora.charAt(4));
    return formato
            && Integer.parseInt(hora.substring(0, 2)) <= 23
            && Integer.parseInt(hora.substring(3)) <= 59;
}
```

Si `formato` es `false`, el cortocircuito impide llegar a los `parseInt`, que fallarían con un texto como `"9:15"`.

**Métodos `static` dentro de una clase:** `aHoraEnMinutos`, `aTextoHora` y `esHoraValida` no usan ningún atributo, así que son `static` y se llaman con el nombre de la clase: `Parking.aTextoHora(555)`. Es la misma idea que `Math.sqrt` o `Integer.parseInt`.

## Para mejorar

- Guardar un historial de vehículos atendidos (con un array o, mejor, un `ArrayList` del tema 16).
- Tarifas distintas según la hora o el tipo de vehículo (con herencia, tema 13).
- Proteger los atributos para que nadie pueda escribir `parking.recaudado = 1000000;` desde fuera: es justo lo que verás en el [tema 12 · Encapsulamiento](../../../../teoria/12-encapsulamiento/README.md).

## Código completo

📄 [Sol11_05_Parking.java](Sol11_05_Parking.java)
