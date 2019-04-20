package main

object Main extends App {
  def zeroCallsPossibility: Double = 0.1
  val calc = new LifoQueueSystemCalculator(
    0.5,
    10,
    0.5,
    100,
    10)

  val c = calc.Omega(1, 2)
  val z = 1.0 / (1.0 - c)
  val b = calc.producerFunction(z)
  //val d = (1 to 230).map(x=>calc.omega(x, 0)).sum
  //println(calc.stationaryProbability(1))
  //println(calc.unconditionalMean())
  println(s"Omega = $c")
  println(s"z = $z")
  println(s"b*(z) = $b" )
   //println(d)
}