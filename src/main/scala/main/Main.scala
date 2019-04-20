package main

object Main extends App {
  def zeroCallsPossibility: Double = 0.1
  val calc = new LifoQueueSystemCalculator(
    0.5,
    10,
    0.5,
    100,
    100)

  val c = calc.Omega(2, 3)
  val z = 1.0 / (1.0 - c)
  val b = calc.producerFunction(z)

  println(s"Omega = $c")
  println(s"z = $z")
  println(s"b*(z) = $b" )
}