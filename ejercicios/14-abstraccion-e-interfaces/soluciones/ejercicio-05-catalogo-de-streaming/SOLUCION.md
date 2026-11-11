# Solución · Ejercicio 05 · Catálogo de streaming

[⬅️ Enunciado](../../ejercicio-05-catalogo-de-streaming/ENUNCIADO.md) · [Ejercicios del tema](../../README.md)

## Cómo pensarlo

Cada herramienta del tema resuelve un problema concreto del diseño:

| Necesidad | Herramienta |
|---|---|
| Solo existen tres tipos de contenido | Interfaz **`sealed`** |
| Todos se pueden ordenar por duración | `Contenido extends Comparable<Contenido>` con `compareTo` **`default`** |
| Formatear minutos no depende de ningún objeto | Método **`static`** en la interfaz |
| Solo películas y series se pueden valorar | Interfaz de capacidad **`Valorable`** |
| Películas y series valoran igual | Clase **abstracta** `ConValoraciones` |
| Describir cada tipo sin olvidar ninguno | **`switch` exhaustivo** sin `default` |

## Código explicado

**Una interfaz que implementa otra:**

```java
sealed interface Contenido extends Comparable<Contenido> permits Pelicula, Serie, Podcast {
    String getTitulo();
    int getDuracionMinutos();

    @Override
    default int compareTo(Contenido otro) {
        return Integer.compare(getDuracionMinutos(), otro.getDuracionMinutos());
    }
}
```

Gracias a esto, `Arrays.sort(catalogo)` funciona aunque ninguna de las tres clases escriba `compareTo`.

**Herencia de clase + interfaz a la vez:**

```java
static final class Pelicula extends ConValoraciones implements Contenido { ... }
```

`Pelicula` hereda la lógica de valoraciones de `ConValoraciones` (que implementa `Valorable`) y además cumple el contrato `Contenido`. Es `final` porque así lo exige `sealed` (también podría ser `sealed` o `non-sealed`).

**El `switch` exhaustivo:**

```java
static String describir(Contenido c) {
    return switch (c) {
        case Pelicula p -> "🎬 Película de " + p.getDirector();
        case Serie s -> "📺 Serie de " + s.getTemporadas() + " temporadas (" + s.getEpisodios() + " episodios)";
        case Podcast p -> "🎙 Podcast con " + p.getPresentador();
    };
}
```

Sin `default`. Si mañana se añade `Documental` a `permits`, este `switch` deja de compilar hasta que se trate el caso nuevo.

**Media redondeada en estrellas:**

```java
default String estrellas() {
    int llenas = (int) Math.round(getMedia());
    return "★".repeat(llenas) + "☆".repeat(5 - llenas);
}
```

Up tiene media 3,5, que `Math.round` redondea a 4: `★★★★☆`.

## Para mejorar

- Una interfaz `Descargable` para los contenidos que se pueden ver sin conexión.
- Ordenar por valoración en lugar de por duración: con un `Comparator` (tema 19) se pueden tener varios órdenes sin tocar las clases.
- En el tema 18, `Podcast` podría ser un `record` en una sola línea.

## Código completo

📄 [Sol14_05_CatalogoDeStreaming.java](Sol14_05_CatalogoDeStreaming.java)
