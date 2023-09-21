package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color
import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color._

import scala.util.Try

object SentinelValues {
  def divideSentinel(a: Int, b: Int): Int = if (b == 0) -1 else a / b

  def parseNumSentinel(num: String): Int = Try(num.toInt).getOrElse(0)

  def parseDivideSentinel(numToDivide: String, dividend: String): Int = {
    val parsedNumToDivide = parseNumSentinel(numToDivide)
    val parsedDividend = parseNumSentinel(dividend)
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
