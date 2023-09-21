package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import cats.data.{Validated, ValidatedNel}

private[errorhandling] object Validateds {
  sealed trait Color

  case object Red extends Color
  case object Green extends Color

  final case class ColorParseError(input: String) {
    override def toString: String = s"Invalid color: $input"
  }

  def parseColor(input: String): Validated[ColorParseError, Color] = ???

  def parseColors(input: String): ValidatedNel[ColorParseError, List[Color]] =
    ???
}
