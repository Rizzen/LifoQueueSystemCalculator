package main


object Main extends App {
  def zeroCallsPossibility: Double = 0.1
  val calc = new LifoQueueSystemCalculator(
    0.2,
    0.5,
    100,
    10)
  val plotter = new Plotter

//  val omega = calc.Omega(2, 3)
//  val z = 1.0 / (1.0 - omega)
//  val b = calc.producerFunction(z)
//  val uncond = calc.unconditionalMean(1)
  val stat = (1 to 8).map(x => Map("i" -> x.toString, "Pi" -> calc.stationaryProbability(x)))
  val s = calc.stationaryProbability(8)
  val plot = plotter.buildPlot(stat, "i", "Pi")
  println(plot.toJson)
  //println(s)
//  println(s"Omega = $omega")
//  println(s"z = $z")
//  println(s"b*(z) = $b" )
//  println(s"unconditional mean = $uncond")
  //stat.foreach{println(_)}
  //println(s"stationaryProbability of (2) = $stat")
}