package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color
import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SentinelValuesSpec extends AnyFlatSpec with Matchers {
  /*
  Sentinel values are values that are used to represent an error state.
  Some examples are:
  - Using `null` to represent error state
  - Using special values like `-1` or `"error"` to represent error state
  This makes error handling referentially transparent, but has some major downsides.
   */

  private def divide(a: Int, b: Int): Int = if (b == 0) -1 else a / b

  // TODO - Make the tests pass, using sentinel values to represent error state
  "divide" should "return the result of dividing two numbers" in {
    divide(10, 2) shouldBe 5
  }

  it should "return -1 when dividing by 0" in {
    divide(1, 0) shouldBe -1
  }

  private def parseSentinel(colors: String): Color = {
    colors match {
      case "R" => Red
      case "G" => Green
      case _   => null
    }
  }

  "parseSentinel" should "return the color when parsing a valid color" in {
    parseSentinel("R") shouldBe Red
    parseSentinel("G") shouldBe Green
  }

  it should "return null when parsing an invalid color" in {
    parseSentinel("B") shouldBe null
  }

  // TODO Q - Discuss problems about sentinel values for error handling
  /* A -
    - Not part of the type signature, i.e. the caller doesn't know about them
    - Allows errors to silently propagate up, causing unexpected behavior in distant parts of the code
    - Caller cannot "just call" such a function, but needs to adhere to implicit policy
    - Leads to duplication, no general mechanism to deal with them
    - Doesn't work for polymorphic functions (those with type params, like `def max[A](xs: Seq[A]) = ???`), cannot invent a new sentinel value for every type
   */
}
