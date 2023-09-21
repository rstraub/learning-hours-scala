package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color
import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color._

import scala.util.Try

private[errorhandling] object SentinelValues {
  def divideSentinel(dividend: Int, divisor: Int): Int =
    if (divisor == 0) -1 else dividend / divisor

  def parseNumSentinel(num: String): Int = Try(num.toInt).getOrElse(0)

  def parseDivideSentinel(dividend: String, divisor: String): Int = {
    val parsedNumToDivide = parseNumSentinel(dividend)
    val parsedDividend = parseNumSentinel(divisor)
    divideSentinel(parsedNumToDivide, parsedDividend)
  }

  def parseColorSentinel(colors: String): Color = {
    colors match {
      case "R" => Red
      case "G" => Green
      case _   => null
    }
  }
}
