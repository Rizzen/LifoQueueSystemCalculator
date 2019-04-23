package main

object Main extends App {
  def zeroCallsPossibility: Double = 0.1
  val calc = new LifoQueueSystemCalculator(
    0.2,
    0.5,
    100,
    10)
  val plotter = new Plotter

  val stat = (1 to 8).map(x => Map("i" -> x.toString, "Pi" -> calc.stationaryProbability(x)))
  val s = calc.stationaryProbability(8)
  val plot = plotter.buildPlot(stat, "i", "Pi")
  println(plot.toJson)
}