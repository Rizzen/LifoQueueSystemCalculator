package main

object Main extends App {
  def zeroCallsPossibility: Double = 0.1
  val calc = new LifoQueueSystemCalculator(
    0.2,
    0.5,
    100,
    10)

//  val omega = calc.Omega(2, 3)
//  val z = 1.0 / (1.0 - omega)
//  val b = calc.producerFunction(z)
//  val uncond = calc.unconditionalMean(1)
//  val stat = (1 to 10).map(x => (x, calc.stationaryProbability(x)))
//                      .map(x => s"stationaryProbability of ${x._1} = ${x._2}")
  val s = calc.stationaryProbability(8)
  println(s)
//  println(s"Omega = $omega")
//  println(s"z = $z")
//  println(s"b*(z) = $b" )
//  println(s"unconditional mean = $uncond")
  //stat.foreach{println(_)}
  //println(s"stationaryProbability of (2) = $stat")
}