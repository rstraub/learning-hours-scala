package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import cats.data.NonEmptyList
import cats.data.Validated.{Invalid, Valid}
import nl.codecraftr.scala.learninghours.parttwo.errorhandling.Validateds.{
  Green,
  ColorParseError,
  Red,
  parseColor,
  parseColors
}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

// https://typelevel.org/cats/datatypes/validated.html
class ValidatedsSpec extends AnyFlatSpec with Matchers {
  /*
    Validated is a data type that represents something possibly being Valid or Invalid.
    It is not part of Scala's standard lib, but comes from Cats - a library for functional programming in Scala.
   */

  // TODO - Q - What is the difference between Validated and Either?
  // A -
  // TODO - Q - When would you use what?
  // A -

  // TODO - we'll build a simple parser for colors
  "parseColor" should "return a color given a valid color name" in {
    parseColor("R") shouldBe Valid(Red)
    parseColor("G") shouldBe Valid(Green)
  }

  it should "return an invalid given an invalid color name" in {
    parseColor("X") shouldBe Invalid(ColorParseError("X"))
  }

  // TODO - this one is pretty hard, but it's a good exercise to get used to Validated
  // Tip - Validated has a handy toValidatedNel method which converts it into a ValidatedNel
  "parseColors" should "return a list of colors given a list of valid color names" in {
    parseColors("R,G") shouldBe Valid(List(Red, Green))
  }

  it should "return a list of invalids given multiple invalid name in the list" in {
    parseColors("X,R,Y") shouldBe Invalid(
      NonEmptyList.of(ColorParseError("X"), ColorParseError("Y"))
    )
  }

  // Phew... that was a lot, but now you know the basics of Functional Error Handling in Scala.
  // Thanks for attending!
}
