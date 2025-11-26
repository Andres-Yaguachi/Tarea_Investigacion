//Metodo de Simpson 1/3
def integracion(f: Double => Double, a: Double, b:Double): Double =
  val x = (a+b)/2.toDouble
  (b-a)*((f(a) + 4 * f(x)) + f(b))/6

def error(a: Double, b: Double):Double =
  Math.abs(a-b)

//Ejercicio 1
def eje1(n: Double): Double =
  -Math.pow(n,2) + 8*n - 12
val res1 = integracion(eje1, 3, 5)
val err1 = error(7.33, res1)

//Ejercicio 2
def eje2(n: Double):Double =
  3 * Math.pow(n,2)
val res2 = integracion(eje2, 0, 2)
val err2 = error(8, res2)

//Ejercicio 3
def eje3(n: Double):Double =
  n + 2*Math.pow(n,2) - Math.pow(n,3) + 5*Math.pow(n,4)
val res3 = integracion(eje3, -1, 1)
val err3 = error(3.333, res3)

//Ejercicio 4
def eje4(n: Double):Double =
  (2*n + 1)/(Math.pow(n,2) + n)
val res4 = integracion(eje4, 1 ,2)
val err4 = error(1.09861, res4)

//Ejercicio 5
def eje5(n: Double): Double =
  Math.pow(Math.E, n)
val res5 = integracion(eje5, 0, 1)
val err5 = error(1.711828, res5)

//Ejercicio 6
def eje6(n: Double): Double =
  1 / (Math.sqrt(n-1))
val res6 = integracion(eje6, 2, 3)
val err6 = error(0.828427, res6)

//Ejercicio 7
def eje7(n: Double): Double =
  1 / (1 + Math.pow(n,2))
val res7 = integracion(eje7, 0, 1)
val err7 = error(0.785398, res7)