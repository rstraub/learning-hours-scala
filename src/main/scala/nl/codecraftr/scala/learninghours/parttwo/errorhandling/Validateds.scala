package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import cats.data.{Validated, ValidatedNel}
import cats.data.Validated.{Invalid, Valid}
import cats.implicits.toTraverseOps

private[errorhandling] object Validateds {
  sealed trait Color

  case object Red extends Color
  case object Green extends Color

  final case class ColorParseError(input: String) {
    override def toString: String = s"Invalid color: $input"
  }

  def parseColor(input: String): Validated[ColorParseError, Color] = {
    input match {
      case "R" => Valid(Red)
      case "G" => Valid(Green)
      case _   => Invalid(ColorParseError(input))
    }
  }

  def parseColors(input: String): ValidatedNel[ColorParseError, List[Color]] = {
    val colors = input.split(",").toList
    colors.map(parseColor).traverse(_.toValidatedNel)
  }
}
