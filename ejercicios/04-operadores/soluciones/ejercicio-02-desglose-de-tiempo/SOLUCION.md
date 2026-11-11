# Solución · Ejercicio 02 · Desglose de tiempo

[⬅️ Enunciado](../../ejercicio-02-desglose-de-tiempo/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Es como repartir monedas: primero las más grandes y, con lo que sobra, las siguientes. En cada paso `/` da la cantidad y `%` lo que sobra.

## Traza con 200 000 segundos

| Paso | Operación | Resultado | Sobra |
|---|---|---|---|
| Días | `200000 / 86400` | **2** | `200000 % 86400` = 27 200 |
| Horas | `27200 / 3600` | **7** | `27200 % 3600` = 2 000 |
| Minutos | `2000 / 60` | **33** | `2000 % 60` = **20** |

## Código explicado

```java
int dias = segundosTotales / SEGUNDOS_DIA;
int resto = segundosTotales % SEGUNDOS_DIA;

int horas = resto / SEGUNDOS_HORA;
resto = resto % SEGUNDOS_HORA;          // o: resto %= SEGUNDOS_HORA;

int minutos = resto / SEGUNDOS_MINUTO;
int segundos = resto % SEGUNDOS_MINUTO;
```

Reutilizamos la variable `resto` en lugar de crear `resto1`, `resto2`...: en cada paso solo nos interesa lo que queda por repartir.

## Otras formas de resolverlo

Se puede calcular cada unidad directamente desde el total, sin `resto`:

```java
int horas = segundosTotales / SEGUNDOS_HORA % 24;
int minutos = segundosTotales / SEGUNDOS_MINUTO % 60;
int segundos = segundosTotales % 60;
```

Por ejemplo, `200000 / 60` son 3 333 minutos en total, y `% 60` se queda con los que no llegan a formar una hora: 33. Es más corto, pero la versión con `resto` se entiende mejor al principio.

## Errores comunes

- Calcular las horas como `segundosTotales / SEGUNDOS_HORA` → da **55** (todas las horas, incluidas las que ya forman días).
- Usar `double`: obtendrías `2.3148...` días en lugar de 2 días y un resto.

## Código completo

📄 [Sol04_02_DesgloseDeTiempo.java](Sol04_02_DesgloseDeTiempo.java)
