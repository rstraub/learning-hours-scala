package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import scala.util.Try

object Options {
  def divideOptionally(a: Int, b: Int): Option[Int] = {
    println(s"divide optionally $a / $b}")
    if (b == 0) None else Some(a / b)
  }

  def parseOptionally(num: String): Option[Int] = {
    println(s"parse optionally $num")
    Try(num.toInt).toOption
  }

  def parseDivideOptionally(
      numToDivide: String,
      divideBy: String
  ): Option[Int] = {
    println(s"parse divide optionally $numToDivide / $divideBy")
    for {
      num <- parseOptionally(numToDivide)
      dividend <- parseOptionally(divideBy)
      result <- divideOptionally(num, dividend)
    } yield result
  }
}
