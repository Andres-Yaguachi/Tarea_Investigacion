# Trabajo de Consulta: Integración Numérica mediante Simpson 1/3

## Introducción

Este documento explica la implementación del **Método de Simpson 1/3** para calcular integrales definidas de forma aproximada, utilizando conceptos de **Programación Funcional** en Scala, específicamente el uso de **funciones de orden superior**.

---

## Objetivos del Trabajo

- Aplicar conocimientos sobre funciones de orden superior
- Enviar una función como parámetro a otra función
- Implementar el método de Simpson 1/3 para integración numérica
- Calcular el error de aproximación en cada integral

---

## Fundamento Teórico: Método de Simpson 1/3

El **Método de Simpson 1/3** es una técnica de integración numérica que aproxima el valor de una integral definida mediante la siguiente fórmula:

```
∫[a to b] f(x)dx ≅ (b - a) × [f(a) + 4f(x̄) + f(b)] / 6
```

Donde:
- **a** y **b** son los límites de integración (inferior y superior)
- **f(x)** es la función a integrar
- **x̄** es el punto medio del intervalo: `x̄ = (a + b) / 2`

Este método funciona aproximando la curva de la función mediante una **parábola** que pasa por tres puntos: f(a), f(x̄) y f(b).

---

## Implementación en Scala

### 1. Función de Integración (Higher Order Function)

```scala
def integracion(f: Double => Double, a: Double, b: Double): Double =
  val x = (a + b) / 2.toDouble
  (b - a) * ((f(a) + 4 * f(x)) + f(b)) / 6
```

**Análisis de la función:**

- **Tipo de retorno:** `Double` - devuelve el valor aproximado de la integral
- **Parámetros:**
  - `f: Double => Double` - **Función de orden superior**: recibe como parámetro la función a integrar
  - `a: Double` - límite inferior de integración
  - `b: Double` - límite superior de integración

**Lógica:**
1. Calcula el punto medio `x = (a + b) / 2`
2. Evalúa la función en los tres puntos: f(a), f(x), f(b)
3. Aplica la fórmula de Simpson 1/3

---

### 2. Función de Cálculo de Error

```scala
def error(a: Double, b: Double): Double =
  Math.abs(a - b)
```

Esta función calcula el **error absoluto** entre el valor esperado y el valor obtenido:

```
Error = |valor_esperado - valor_obtenido|
```

---

## Ejercicios Resueltos

### Ejercicio 1: Función Polinómica

**Integral:** ∫[3 to 5] (-x² + 8x - 12)dx ≅ 7.33

```scala
def eje1(n: Double): Double =
  -Math.pow(n, 2) + 8 * n - 12

val res1 = integracion(eje1, 3, 5)
val err1 = error(7.33, res1)
```

---

### Ejercicio 2: Función Cuadrática Simple

**Integral:** ∫[0 to 2] 3x² dx ≅ 8

```scala
def eje2(n: Double): Double =
  3 * Math.pow(n, 2)

val res2 = integracion(eje2, 0, 2)
val err2 = error(8, res2)
```

---

### Ejercicio 3: Polinomio de Grado 4

**Integral:** ∫[-1 to 1] (x + 2x² - x³ + 5x⁴) dx ≅ 3.333

```scala
def eje3(n: Double): Double =
  n + 2 * Math.pow(n, 2) - Math.pow(n, 3) + 5 * Math.pow(n, 4)

val res3 = integracion(eje3, -1, 1)
val err3 = error(3.333, res3)
```

---

### Ejercicio 4: Función Racional

**Integral:** ∫[1 to 2] (2x + 1)/(x² + x) dx ≅ 1.09861

```scala
def eje4(n: Double): Double =
  (2 * n + 1) / (Math.pow(n, 2) + n)

val res4 = integracion(eje4, 1, 2)
val err4 = error(1.09861, res4)
```

---

### Ejercicio 5: Función Exponencial

**Integral:** ∫[0 to 1] eˣ dx ≅ 1.71828

```scala
def eje5(n: Double): Double =
  Math.pow(Math.E, n)

val res5 = integracion(eje5, 0, 1)
val err5 = error(1.71828, res5)
```

**Nota:** Se encontró un pequeño error de tipeo en el código original (`1.711828` debería ser `1.71828`).

---

### Ejercicio 6: Función con Raíz Cuadrada

**Integral:** ∫[2 to 3] 1/√(x-1) dx ≅ 0.828427

```scala
def eje6(n: Double): Double =
  1 / Math.sqrt(n - 1)

val res6 = integracion(eje6, 2, 3)
val err6 = error(0.828427, res6)
```

---

### Ejercicio 7: Función Trigonométrica (Arcotangente)

**Integral:** ∫[0 to 1] 1/(1 + x²) dx ≅ 0.785398

```scala
def eje7(n: Double): Double =
  1 / (1 + Math.pow(n, 2))

val res7 = integracion(eje7, 0, 1)
val err7 = error(0.785398, res7)
```

**Dato curioso:** Esta integral corresponde a `arctan(1) = π/4 ≅ 0.785398`

---

## Conceptos Clave de Programación Funcional

### 1. **Funciones de Orden Superior (Higher Order Functions)**

La función `integracion` es una **función de orden superior** porque:
- Recibe otra función como parámetro: `f: Double => Double`
- Puede trabajar con cualquier función que cumpla la firma `Double => Double`

### 2. **Funciones como Ciudadanos de Primera Clase**

En Scala, las funciones son valores que pueden:
- Pasarse como argumentos (como se hace en todos los ejercicios)
- Devolverse como resultados
- Asignarse a variables

### 3. **Inmutabilidad**

Todas las funciones definidas son **puras** y no modifican estado:
- Siempre producen el mismo resultado para los mismos argumentos
- No tienen efectos secundarios

### 4. **Expresiones sobre Declaraciones**

El código usa expresiones (valores calculados) en lugar de declaraciones imperativas:
```scala
val res1 = integracion(eje1, 3, 5)  // Expresión que se evalúa
```

---

## Ventajas del Método Implementado

1. **Reutilización:** La función `integracion` funciona con cualquier función matemática
2. **Composición:** Fácil de componer con otras operaciones matemáticas
3. **Legibilidad:** El código expresa claramente la fórmula matemática
4. **Testeable:** Cada función es pura y fácil de probar

---

## Conclusiones

- Se implementó exitosamente el método de Simpson 1/3 usando programación funcional
- Se utilizaron funciones de orden superior para lograr abstracción y reutilización
- Se aplicó el método a 7 integrales diferentes, demostrando su versatilidad
- El cálculo de errores permite validar la precisión de las aproximaciones

---

## Referencias

- Método de Simpson 1/3 para integración numérica
- Programación Funcional en Scala
- Higher Order Functions y funciones como parámetros

---

**Autor:** [Tu nombre]  
**Fecha de entrega:** Semana 7  
**Repositorio:** [URL del repositorio de GitHub]# Tarea_Investigacion
Transformar una formula matemática a una función de orden superior
