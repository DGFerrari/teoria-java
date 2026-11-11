# Tema 17 · Genéricos

[⬅️ Tema anterior](../16-colecciones/README.md) · [🏠 Índice](../../INDICE.md) · [Siguiente tema ➡️](../18-enums-y-records/README.md)

En el tema 16 escribiste `List<String>` y `Map<String, Integer>` sin pararte mucho en esos `< >`. Son los **genéricos**: la forma de escribir una clase o un método **una sola vez** y que funcione con **cualquier tipo**, manteniendo la seguridad de que el compilador comprueba los tipos. En este tema aprenderás a crear tus propias clases, interfaces y métodos genéricos.

## 🎯 Objetivos

- Entender qué problema resuelven los genéricos.
- Crear **clases genéricas** con uno o varios **parámetros de tipo**.
- Escribir **métodos genéricos** y aprovechar la **inferencia de tipos**.
- Restringir los tipos admitidos con **tipos acotados** (`extends`).
- Definir e implementar **interfaces genéricas**.
- Usar los **comodines** `?`, `? extends` y `? super`.
- Conocer las **limitaciones** de los genéricos (borrado de tipos).

## 📚 Contenido

1. [El problema: una caja para cada tipo](#1-el-problema-una-caja-para-cada-tipo)
2. [Clases genéricas](#2-clases-genéricas)
3. [Varios parámetros de tipo](#3-varios-parámetros-de-tipo)
4. [Métodos genéricos](#4-métodos-genéricos)
5. [Tipos acotados](#5-tipos-acotados)
6. [Interfaces genéricas](#6-interfaces-genéricas)
7. [Comodines](#7-comodines)
8. [Limitaciones: el borrado de tipos](#8-limitaciones-el-borrado-de-tipos)
9. [Errores típicos](#9-errores-típicos)
10. [Resumen](#10-resumen)

---

## 1. El problema: una caja para cada tipo

Imagina una clase `Caja` que guarda un objeto. Si la quieres para textos, para números y para alumnos, tienes dos opciones malas:

**Opción A: una clase por tipo.** `CajaDeTexto`, `CajaDeEntero`, `CajaDeAlumno`... El mismo código copiado una y otra vez.

**Opción B: guardar `Object`.** Como todas las clases heredan de `Object` (tema 13), cabe cualquier cosa:

```java
class CajaDeObjetos {
    private Object contenido;
    void guardar(Object o) { contenido = o; }
    Object sacar() { return contenido; }
}

CajaDeObjetos caja = new CajaDeObjetos();
caja.guardar("Hola");
String texto = (String) caja.sacar();      // Hay que hacer casting
caja.guardar(42);                           // El compilador no protesta...
String otro = (String) caja.sacar();        // 💥 ClassCastException al EJECUTAR
```

El error aparece tarde, al ejecutar, y quizá en otra parte del programa. Así eran las colecciones de Java antes de 2004.

**La solución: genéricos.** Se escribe la clase una vez, con un **parámetro de tipo**, y quien la usa dice qué tipo quiere:

```java
Caja<String> caja = new Caja<>();
caja.guardar("Hola");
String texto = caja.sacar();     // Sin casting
caja.guardar(42);                // ❌ Error de COMPILACIÓN: se detecta antes de ejecutar
```

| | Con `Object` | Con genéricos |
|---|---|---|
| ¿Una sola clase para todos los tipos? | Sí | Sí |
| ¿Hace falta casting? | Sí | No |
| ¿Cuándo se detecta un tipo incorrecto? | Al ejecutar (`ClassCastException`) | Al compilar |

## 2. Clases genéricas

```java
class Caja<T> {                    // T es un "parámetro de tipo"
    private T contenido;

    void guardar(T contenido) {
        this.contenido = contenido;
    }

    T sacar() {
        return contenido;
    }

    boolean estaVacia() {
        return contenido == null;
    }
}
```

`T` es como un parámetro de un método, pero en lugar de un **valor** recibe un **tipo**. Dentro de la clase se usa como si fuera un tipo cualquiera. Al crear el objeto, se sustituye:

```java
Caja<String> cajaTexto = new Caja<>();     // Aquí, T = String
Caja<Integer> cajaNumero = new Caja<>();   // Aquí, T = Integer
Caja<Alumno> cajaAlumno = new Caja<>();    // Aquí, T = Alumno
```

- El `<>` vacío de la derecha es el **diamante**: el compilador deduce el tipo de la izquierda.
- Los tipos tienen que ser **clases**: `Caja<int>` no compila, se usa `Caja<Integer>` (tema 16, sección 3).

**Convenciones para los nombres** (una letra mayúscula):

| Letra | Significado habitual | Ejemplo en el JDK |
|---|---|---|
| `T` | *Type*, un tipo cualquiera | `Optional<T>` |
| `E` | *Element*, elemento de una colección | `List<E>`, `Set<E>` |
| `K`, `V` | *Key* y *Value* | `Map<K, V>` |
| `R` | *Result*, tipo de un resultado | `Function<T, R>` (tema 19) |

## 3. Varios parámetros de tipo

Una clase puede tener varios parámetros, separados por comas, como `Map<K, V>`:

```java
class Par<A, B> {
    private final A primero;
    private final B segundo;

    Par(A primero, B segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    A getPrimero() { return primero; }
    B getSegundo() { return segundo; }
}

Par<String, Integer> edad = new Par<>("Ana", 15);
Par<Double, Double> punto = new Par<>(3.5, -2.0);
String nombre = edad.getPrimero();     // El compilador sabe que es String
int anios = edad.getSegundo();         // ...y que esto es Integer (unboxing)
```

Los parámetros de tipo también se pueden "anidar": `Par<String, List<Integer>>`, `Map<String, Par<Integer, Integer>>`...

## 4. Métodos genéricos

Un método también puede tener sus propios parámetros de tipo, aunque su clase no sea genérica. Se declaran **antes del tipo de retorno**:

```java
static <T> void mostrarTodos(T[] elementos) {
    for (T e : elementos) {
        System.out.print(e + " ");
    }
    System.out.println();
}

static <T> T ultimo(List<T> lista) {
    return lista.get(lista.size() - 1);
}
```

Al llamarlos, **no hace falta indicar el tipo**: el compilador lo deduce de los argumentos (**inferencia de tipos**):

```java
mostrarTodos(new String[]{"a", "b"});       // T = String
mostrarTodos(new Integer[]{1, 2, 3});       // T = Integer
String s = ultimo(List.of("x", "y", "z"));  // T = String, devuelve String
```

Muchos métodos que ya conoces son genéricos: `List.of`, `Collections.max`, `Arrays.asList`...

## 5. Tipos acotados

A veces el método necesita **algo** del tipo. Por ejemplo, para sumar hacen falta números, y para buscar el mayor hace falta poder comparar. Con `extends` se **limita** qué tipos se admiten:

```java
// Solo tipos que sean Number (Integer, Double, Long...)
static <T extends Number> double sumar(List<T> numeros) {
    double total = 0;
    for (T n : numeros) {
        total += n.doubleValue();     // doubleValue() existe porque T es un Number
    }
    return total;
}

sumar(List.of(1, 2, 3));        // ✅ Integer es un Number
sumar(List.of(1.5, 2.5));       // ✅ Double es un Number
sumar(List.of("a", "b"));       // ❌ Error de compilación: String no es un Number
```

El caso más habitual: **cualquier tipo que se pueda comparar consigo mismo**.

```java
static <T extends Comparable<T>> T mayor(List<T> lista) {
    T resultado = lista.get(0);
    for (T e : lista) {
        if (e.compareTo(resultado) > 0) {    // compareTo existe porque T es Comparable
            resultado = e;
        }
    }
    return resultado;
}
```

Funciona con `String`, `Integer`, `Double`... y con **tus clases** que implementen `Comparable` (tema 14).

- En los genéricos, `extends` se usa **también para interfaces** (no se escribe `implements`).
- Se pueden exigir varias cosas con `&`: `<T extends Number & Comparable<T>>`.

## 6. Interfaces genéricas

Las interfaces también pueden ser genéricas. Ya conoces una: `Comparable<T>`.

```java
interface Repositorio<T> {
    void guardar(T elemento);
    T buscar(int posicion);
    int cantidad();
}
```

Quien la implementa puede **fijar** el tipo o **seguir siendo genérico**:

```java
// Fija el tipo: solo sirve para String
class RepositorioDeNombres implements Repositorio<String> {
    ...
    public void guardar(String elemento) { ... }
}

// Sigue siendo genérico: sirve para cualquier tipo
class RepositorioEnMemoria<T> implements Repositorio<T> {
    private final List<T> datos = new ArrayList<>();
    public void guardar(T elemento) { datos.add(elemento); }
    ...
}
```

Igual con las clases: `class Alumno implements Comparable<Alumno>` fija `T = Alumno`, y por eso su `compareTo` recibe un `Alumno` y no un `Object`.

## 7. Comodines

Esto sorprende a todo el mundo: aunque `Integer` es un `Number`, una `List<Integer>` **no es** una `List<Number>`.

```java
List<Integer> enteros = new ArrayList<>(List.of(1, 2, 3));
List<Number> numeros = enteros;    // ❌ No compila
```

Si se permitiera, podrías hacer `numeros.add(2.5)` y habrías metido un `Double` en una lista de enteros. Para escribir métodos flexibles existen los **comodines** (`?`, *wildcards*):

| Comodín | Se lee | Puedes... | Ejemplo |
|---|---|---|---|
| `List<?>` | Lista de "algo" | Leer como `Object` | Mostrar cualquier lista |
| `List<? extends Number>` | Lista de `Number` o de una subclase | **Leer** como `Number` | Sumar una lista de `Integer` o de `Double` |
| `List<? super Integer>` | Lista de `Integer` o de una superclase | **Añadir** `Integer` | Rellenar una `List<Number>` o `List<Object>` con enteros |

```java
static double total(List<? extends Number> numeros) {    // Acepta List<Integer>, List<Double>...
    double suma = 0;
    for (Number n : numeros) {
        suma += n.doubleValue();
    }
    return suma;
}

static void rellenar(List<? super Integer> destino, int cuantos) {   // Acepta List<Integer>, List<Number>, List<Object>
    for (int i = 1; i <= cuantos; i++) {
        destino.add(i);
    }
}
```

Regla para recordarlo: si el método **saca** datos de la colección, `extends`; si **mete** datos, `super`. (En inglés se resume como *PECS: Producer Extends, Consumer Super*.)

> Los comodines aparecen sobre todo en métodos de librerías. En tu propio código, empieza por los parámetros de tipo normales (`<T>`) y usa comodines cuando necesites esa flexibilidad.

## 8. Limitaciones: el borrado de tipos

Los genéricos solo existen **para el compilador**. Una vez comprobado que todo es correcto, el compilador **borra** la información de tipos (*type erasure*): en el programa compilado, `Caja<String>` y `Caja<Integer>` son la misma clase `Caja`. Eso explica algunas restricciones:

| No se puede | Ejemplo | Alternativa |
|---|---|---|
| Usar tipos primitivos | `Caja<int>` | `Caja<Integer>` |
| Crear un objeto del tipo `T` | `new T()` | Recibir el objeto ya creado |
| Crear un array de `T` | `new T[10]` | Usar una `List<T>` |
| Preguntar por el tipo concreto | `x instanceof List<String>` | `x instanceof List<?>` |
| Usar `T` en un miembro `static` de la clase | `static T valorPorDefecto;` | Un método genérico `static <T>` |

Por eso, en la práctica, las clases genéricas suelen guardar sus elementos en una **colección** (`List<T>`, `Map<K, V>`) y no en un array.

## 9. Errores típicos

| Error | Ejemplo | Qué pasa |
|---|---|---|
| Tipo primitivo como argumento | `List<double>` | Error de compilación |
| Declarar el `<T>` del método en el sitio equivocado | `static void <T> mostrar(T x)` | Error de compilación: va **antes** del tipo de retorno |
| Llamar a un método que `T` no tiene | `t.compareTo(otro)` con `<T>` sin acotar | `cannot find symbol`: añade `<T extends Comparable<T>>` |
| Esperar que `List<Integer>` sea `List<Number>` | `List<Number> n = enteros;` | `incompatible types`: usa `List<? extends Number>` |
| Usar el tipo "crudo" (*raw type*) | `List lista = new ArrayList();` | Compila con avisos, pero pierdes las comprobaciones |
| `new T()` o `new T[n]` | | Error de compilación |
| Usar `implements` en un tipo acotado | `<T implements Comparable<T>>` | Error: siempre es `extends` |

## 10. Resumen

- Los **genéricos** permiten escribir clases, interfaces y métodos que funcionan con **cualquier tipo**, sin casting y con errores detectados **al compilar**.
- **Clase genérica**: `class Caja<T>`. Se usa con `Caja<String> c = new Caja<>();`. Puede tener varios parámetros: `Par<A, B>`.
- **Método genérico**: `static <T> T ultimo(List<T> lista)`. El tipo se **infiere** de los argumentos.
- **Tipos acotados**: `<T extends Number>`, `<T extends Comparable<T>>` permiten usar los métodos de ese tipo.
- Las **interfaces genéricas** se implementan fijando el tipo (`implements Comparable<Alumno>`) o manteniéndolo (`implements Repositorio<T>`).
- `List<Integer>` **no es** `List<Number>`. Los **comodines** `? extends` (leer) y `? super` (añadir) dan flexibilidad.
- Por el **borrado de tipos**: nada de primitivos, `new T()`, `new T[]` ni `T` en miembros `static`.

---

## 💻 Ejemplos de código

| Archivo | Qué muestra |
|---|---|
| [T17_01_ProblemaSinGenericos.java](ejemplos/T17_01_ProblemaSinGenericos.java) | La caja de `Object`, su `ClassCastException` y la versión genérica |
| [T17_02_ClasesGenericas.java](ejemplos/T17_02_ClasesGenericas.java) | Clases con uno y dos parámetros de tipo, anidados y con colecciones |
| [T17_03_MetodosGenericos.java](ejemplos/T17_03_MetodosGenericos.java) | Métodos genéricos e inferencia de tipos |
| [T17_04_TiposAcotados.java](ejemplos/T17_04_TiposAcotados.java) | `<T extends Number>`, `<T extends Comparable<T>>` y un ordenador genérico |
| [T17_05_InterfacesGenericas.java](ejemplos/T17_05_InterfacesGenericas.java) | Una interfaz genérica implementada fijando el tipo y manteniéndolo |
| [T17_06_Comodines.java](ejemplos/T17_06_Comodines.java) | `?`, `? extends` y `? super` |

## ✏️ Ejercicios

Practica lo aprendido en los [ejercicios del tema 17](../../ejercicios/17-genericos/README.md).

---

[⬅️ Tema anterior](../16-colecciones/README.md) · [🏠 Índice](../../INDICE.md) · [Siguiente tema ➡️](../18-enums-y-records/README.md)
