package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import scala.util.Try

private[errorhandling] object Options {
  def divideOptionally(dividend: Int, divisor: Int): Option[Int] = {
    println(s"divide optionally $dividend / $divisor}")
    if (divisor == 0) None else Some(dividend / divisor)
  }

  def parseOptionally(num: String): Option[Int] = {
    println(s"parse optionally $num")
    Try(num.toInt).toOption
  }

  def parseDivideOptionally(
      dividend: String,
      divisor: String
  ): Option[Int] = {
    println(s"parse divide optionally $dividend / $divisor")
    for {
      num <- parseOptionally(dividend)
      dividend <- parseOptionally(divisor)
      result <- divideOptionally(num, dividend)
    } yield result
  }
}
