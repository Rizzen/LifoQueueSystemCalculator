package main

class LifoQueueSystemCalculator(zeroCallStatePossibility : Double,
                                staticCallLength : Double,
                                singleCallPossibility : Double,
                                maxCallLength : Int,
                                bufferSize : Int) {

  // returns call length for current moment
  private def callLength(i : Double) : Double = staticCallLength

  def omega(k : Int, j : Int) : Double = {
    if ((k + j) > bufferSize)
      0.0
    else
      1.0 / bufferSize
  }

  def Omega(i : Int, j : Int): Double = {
    val lower = j - i
    val upper = bufferSize - i
    var sum = 0.0
    for (a <- lower to upper) {
      sum = sum + omega(a, j)
    }
    sum
  }

   // ai
  private def currentStateSingleCallPossibility(currentCallsCount : Int) : Double = singleCallPossibility

  def lengthProbability(length : Int) : Double = {
    length match {
      case x if 1 to 10 contains x => 0.1
      case _ => 0
    }
  }

  def producerFunction(z : Double) : Double = {
    var sum = 0.0
    for (a <- 1 to maxCallLength){
      val zpow = math.pow(z, a - 1)
      val l = lengthProbability(a)
      sum = sum + (zpow * l)
    }
    sum
  }

  def stationaryProbability (number : Int) : Double = {
    val d = unconditionalMean()
    if (number == 0)
      zeroCallStatePossibility
    else if (number == 1)
      (d - 1) * zeroCallStatePossibility * 1 / number
    else {
      var sum: Double = 0.0
      for (a <- 0 until number){
        sum = sum + (stationaryProbability(a) * (1/number))
      }
      (d - 1) * sum
    }
  }

  def unconditionalMean () : Double = {
    val a = 1 / currentStateSingleCallPossibility(0)
    val bStar = callLength(1 / (1 - currentStateSingleCallPossibility(0)))
    a * (bStar - 1) + 1
  }
}
