package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color
import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color.{
  Green,
  Red
}
import nl.codecraftr.scala.learninghours.parttwo.errorhandling.SentinelValues.parseDivideSentinel
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/** For more information about Option, see:
  * https://www.scala-lang.org/api/current/scala/Option.html
  * https://www.scala-exercises.org/std_lib/options
  */
class OptionSpec
    extends AnyFlatSpec
    with Matchers
    with ScalaCheckPropertyChecks {
  /*
    Option is a data type that represents the presence or absence of a value.
    It can be used to represent something optional, instead of using null, but is has more uses.
    We can also use Option for error handling, as we will see in this chapter.
   */

  // We can use Option for so-called partial functions, i.e. functions that are not defined for all inputs.
  // TODO - Make the tests pass, using Option for error handling

  private def divide(a: Int, b: Int): Option[Int] =
    if (b == 0) None else Some(a / b)

  "divide" should "return the result of dividing two numbers" in {
    forAll { (n: Int, d: Int) =>
      whenever(d != 0) {
        divide(n, d) shouldBe Some(n / d)
      }
    }
  }

  it should "return None when dividing by 0" in {
    forAll { (n: Int) =>
      divide(n, 0) shouldBe None
    }
  }

  private def parseOptionally(colors: String): Option[Color] = {
    colors match {
      case "R" => Some(Red)
      case "G" => Some(Green)
      case _   => None
    }
  }

  "parseOptionally" should "return the color when parsing a valid color" in {
    parseOptionally("R") shouldBe Some(Red)
    parseOptionally("G") shouldBe Some(Green)
  }

  it should "return None when parsing an invalid color" in {
    parseOptionally("B") shouldBe None
  }

  // TODO - Make the test pass and use Option for error handling
  // Tip - use pattern matching like we learned last time!
  it should "force handling the result" in {
    def printableColor(color: String) = parseOptionally(color) match {
      case Some(color) => s"The color is $color"
      case None        => s"Invalid color: $color"
    }

    printableColor("R") shouldBe "The color is Red"
    printableColor("Banana") shouldBe "Invalid color: Banana"
  }

  // TODO - Q What differences do you see between using exceptions/sentinel values and Option for error handling?
  // Tip focus on the type signature of the function and the way the caller has to handle the result
  /* A
    - We clearly see the partial nature of the function in the type signature.
  The caller knows that the function is not defined for all inputs, and has to handle the results.
    - We can exhaustively match on the result, and handle all cases.
   */

  /*
  We saw that Options communicate the partial nature of a function in the type signature more clearly than runtime exceptions or sentinel values.
  However, what makes them more powerful than checked exceptions is that they are composable and polymorphic.
  This is due to the fact that they are a Monad (esoteric term, you might hear every now and again, just good to know an Option is one)!
  https://en.wikipedia.org/wiki/Monad_(functional_programming)

  Options are incredibly powerful because they allow us to continue composing our programs in the presence of errors/absence of values.
  An option can be thought of as a collection of zero or one elements, and short-circuits whenever it encounters a None.
   */

  // TODO - Fix the assertions and find the cause
  "composing divide/parseNum with sentinel values" should "chain the calls" in {
    parseDivideSentinel("2", "2") shouldBe 1
  }

  it should "not short-circuit when parsing an invalid number" in {
    parseDivideSentinel("2", "Banana") shouldBe -1
  }

  // TODO - Q What did you notice in this composition?
  // A - the incorrect value is propagated through the chain, causing the division to run on incorrect input

  // Off to a better way, let's do the same again, but now with Options
}
