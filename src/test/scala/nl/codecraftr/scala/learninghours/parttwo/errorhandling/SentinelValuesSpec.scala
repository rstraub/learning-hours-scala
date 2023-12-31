package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color._
import nl.codecraftr.scala.learninghours.parttwo.errorhandling.SentinelValues.{
  divideSentinel,
  parseColorSentinel,
  parseNumSentinel
}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class SentinelValuesSpec
    extends AnyWordSpec
    with Matchers
    with ScalaCheckPropertyChecks {
  /*
  Sentinel values are values that are used to represent an error state.
  Some examples are:
  - Using `null` to represent error state
  - Using special values like `-1` or `"error"` to represent error state
  This makes error handling referentially transparent, but has some major downsides.
   */

  // TODO - Make the tests pass, using sentinel values to represent error state

  "divide" should {
    "return the result of dividing two numbers" in {
      forAll { (n: Int, d: Int) =>
        whenever(d != 0) {
          divideSentinel(n, d) shouldBe n / d
        }
      }
    }

    "return -1 when dividing by 0" in {
      forAll { (n: Int) =>
        divideSentinel(n, 0) shouldBe -1
      }
    }
  }

  "parseNum" should {
    "return the number when parsing a valid number" in {
      parseNumSentinel("1") shouldBe 1
    }

    "return 0 when parsing an invalid number" in {
      parseNumSentinel("a") shouldBe 0
    }
  }

  "parseSentinel" should {
    "return the color when parsing a valid color" in {
      parseColorSentinel("R") shouldBe Red
      parseColorSentinel("G") shouldBe Green
    }

    "return null when parsing an invalid color" in {
      parseColorSentinel("B") shouldBe null
    }
  }

  // TODO Q - Discuss problems about sentinel values for error handling
  /* A -

   */

  // Off to the next chapter - Option!
}
