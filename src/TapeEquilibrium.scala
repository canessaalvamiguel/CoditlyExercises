/*
Link problem: https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
*/

object TapeEquilibrium {
  def solution(a: Array[Int]): Int = {
    var sumLeft: Long = a(0)
    var sumRight: Long = a.foldLeft(0)(_+_) - sumLeft
    var minimunDiff: Long = (sumRight - sumLeft).abs

    for (i <- 1 to a.size - 1) {
      sumRight -= a(i)
      sumLeft += a(i)
      var currentDiff = (sumRight - sumLeft).abs
      if(minimunDiff > currentDiff) minimunDiff = currentDiff
    }
    minimunDiff.toInt
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(3, 1, 2, 4, 3)))
  }
}
//How to get min by value only in Scala Map
//Map("a" -> 3.0, "b" -> 1.0, "c" -> 2.0).minBy(_._2)._1