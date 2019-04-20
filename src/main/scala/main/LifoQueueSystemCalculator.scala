package main

class LifoQueueSystemCalculator(zeroCallStatePossibility : Double,
                                staticCallLength : Double,
                                maxCallLength : Int,
                                bufferSize : Int) {
  def omega(k : Int, i : Int) : Double = {
    if ((k + i) > bufferSize)
      0.0
    else
      //1.0 / bufferSize
      0.01
  }

  def Omega(i : Int, j : Int): Double = {
    val lower = j - i
    val upper = bufferSize - i
    var sum = 0.0
    for (a <- lower to upper) {
      val o = omega(a, j)
      sum = sum + o
    }
    sum
  }

  def lengthProbability(length : Int) : Double = {
    length match {
      case x if 1 to 10 contains x => 0.1
      case _ => 0
    }
  }

  def producerFunction(z : Double) : Double = {
    var sum = 0.0
    for (a <- 1 to maxCallLength) {
      val zpow = math.pow(z, a - 1)
      val l = lengthProbability(a)
      sum = sum + (zpow * l)
    }
    sum
  }

  def currentStateSingleCallPossibility(currentCallsCount : Int) : Double = {
    Omega(currentCallsCount, currentCallsCount + 1)
  }

  def stationaryProbability (number : Int) : Double = {
    val d = unconditionalMean(number)
    if (number == 0)
      zeroCallStatePossibility
    else if (number == 1) {
      val omega = Omega(0, 1)
      (d - 1) * zeroCallStatePossibility * omega
    }
    else {
      var sum: Double = 0.0
      for (a <- 0 until number){
        val omega = Omega(a, number)
        sum = sum + (stationaryProbability(a) * omega)
      }
      (d - 1) * sum
    }
  }

  def unconditionalMean (i : Int) : Double = {
    val ai = currentStateSingleCallPossibility(i)
    val z = 1 / (1 - ai)
    val bStar = producerFunction(z)
    1 / ai * (bStar - 1) + 1
  }
}