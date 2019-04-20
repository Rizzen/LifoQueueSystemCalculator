package main
import vegas.DSL.ExtendedUnitSpecBuilder
import vegas._

class Plotter {
  def buildPlot(seq : Seq[Map[String, Any]], xName : String, yName : String): ExtendedUnitSpecBuilder = {
    val plot = Vegas("Graph").withData(seq)
                             .encodeX(xName)
                             .encodeY(yName)
                             .mark(Line)
    plot
  }
}
