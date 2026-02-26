# Calculadora Infix

Aplicación Java que evalúa expresiones en notación **infix** (la notación matemática estándar). El programa las convierte internamente a notación postfija y las evalúa usando una pila.

## Características

- Convierte expresiones infix a postfix automáticamente
- Soporta paréntesis y precedencia de operadores (`*`, `/` antes que `+`, `-`)
- Soporta números multi-dígito y decimales
- Permite elegir la implementación de pila al iniciar el programa
- Lee las expresiones desde el archivo `datos.txt`

## Arquitectura

El proyecto implementa los ADTs de **Pila** y **Lista** con la jerarquía completa:

```
Stack<T>  (interfaz)
  └── AbstractStack<T>  (clase abstracta)
        ├── StackArrayList<T>   — respaldado por java.util.ArrayList
        ├── StackArray<T>       — respaldado por arreglo nativo
        └── StackLinkedList<T>  — respaldado por ILinkedList

ILinkedList<T>  (interfaz)
  └── AbstractLinkedList<T>  (clase abstracta)
        ├── LinkedList<T>         — simplemente encadenada
        └── DoubleLinkedList<T>   — doblemente encadenada
```

### Patrones de diseño

- **Factory** — `StackFactory` y `ListFactory` crean la implementación elegida por el usuario
- **Singleton** — `Calculator` garantiza una sola instancia del evaluador

## Cómo ejecutar

```bash
mvn compile exec:java -Dexec.mainClass="org.example.Main"
```

Al iniciar, el programa pregunta:

```
Seleccione la implementación de pila:
1. ArrayList
2. Array (Vector)
3. Lista enlazada
Opción:
```

Si se elige **3. Lista enlazada**, pregunta además:

```
Seleccione la implementación de lista:
1. Simplemente encadenada
2. Doblemente encadenada
Opción:
```

Luego lee y evalúa cada expresión de `datos.txt`:

```
Línea 1: (10+20)*9 = 270.0
Línea 2: 1+2*9 = 19.0
...
```

## Formato de datos.txt

Una expresión infix por línea. Soporta espacios o sin espacios:

```
(10+20)*9
1+2*9
(1+2)*9
(5+3)*(2-1)
```

## Operadores soportados

| Operador | Operación      | Precedencia |
|----------|----------------|-------------|
| `*`      | Multiplicación | Alta        |
| `/`      | División       | Alta        |
| `+`      | Suma           | Baja        |
| `-`      | Resta          | Baja        |

Los paréntesis `( )` pueden usarse para forzar el orden de evaluación.

## Ejecutar tests

```bash
mvn test
```

85 tests cubriendo: `StackArray`, `StackArrayList`, `StackLinkedList`, `LinkedList`, `DoubleLinkedList`, `InfixParser`, `Parser`, y la evaluación completa end-to-end.
