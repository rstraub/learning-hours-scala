package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import nl.codecraftr.scala.learninghours.parttwo.errorhandling.Options.{
  divideOptionally,
  parseDivideOptionally,
  parseOptionally
}
import nl.codecraftr.scala.learninghours.parttwo.errorhandling.SentinelValues.parseDivideSentinel
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/** For more information about Option, see:
  * https://www.scala-lang.org/api/current/scala/Option.html
  * https://www.scala-exercises.org/std_lib/options
  */
class OptionsSpec
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

  "divide" should "return the result of dividing two numbers" in {
    forAll { (n: Int, d: Int) =>
      whenever(d != 0) {
        divideOptionally(n, d) shouldBe Some(n / d)
      }
    }
  }

  it should "return None when dividing by 0" in {
    forAll { (n: Int) =>
      divideOptionally(n, 0) shouldBe None
    }
  }

  "parseOptionally" should "return the color when parsing a valid number" in {
    parseOptionally("1") shouldBe Some(1)
    parseOptionally("2") shouldBe Some(2)
  }

  it should "return None when parsing an invalid number" in {
    parseOptionally("B") shouldBe None
  }

  // TODO - Make the test pass and use Option for error handling
  // Tip - use pattern matching like we learned last time!
  it should "force handling the result" in {
    def printableNum(num: String) = parseOptionally(num) match {
      case Some(n) => s"The number is $n"
      case None    => s"Invalid number: $num"
    }

    printableNum("1") shouldBe "The number is 1"
    printableNum("Banana") shouldBe "Invalid number: Banana"
  }

  // TODO - Q What differences do you see between using exceptions/sentinel values and Option for error handling?
  // Tip focus on the type signature of the function and the way the caller has to handle the result
  /* A
    - We clearly see the partial nature of the function in the type signature.
  The caller knows that the function is not defined for all inputs, and has to handle the results.
    - We can exhaustively match on the result, and handle all cases.
    - Options are Referentially Transparent
   */

  /*
  We saw that Options communicate the partial nature of a function in the type signature more clearly than runtime exceptions or sentinel values.
  However, what makes them more powerful than checked exceptions is that they are composable and polymorphic.
  This is due to the fact that they are a Monad (esoteric term, you might hear every now and again, just good to know an Option is one)!
  https://en.wikipedia.org/wiki/Monad_(functional_programming)

  Options are incredibly powerful because they allow us to continue composing our programs in the presence of errors/absence of values.
  An option can be thought of as a collection of zero or one elements, and short-circuits whenever it encounters a None.
   */

  // TODO - Make the tests pass composing the functions you created earlier.
  // Be like a naive caller, do not handle the sentinel values in the new function.
  "composing divide/parseNum with sentinel values" should "chain the calls" in {
    parseDivideSentinel("2", "2") shouldBe 1
  }

  it should "not short-circuit when parsing an invalid number" in {
    parseDivideSentinel("2", "Banana") shouldBe -1
  }

  // TODO - Q What did you notice in this composition?
  // A - the incorrect value is propagated through the chain, causing the division to run on incorrect input

  // Off to a better way, let's do the same again, but now with Options
  "composing divide/parseNum with options" should "chain the calls" in {
    parseDivideOptionally("8", "2") shouldBe Some(4)
  }

  it should "short-circuit when parsing an invalid number to divide" in {
    parseDivideOptionally("Pineapple", "2") shouldBe None
  }

  it should "short-circuit when parsing an invalid number to divide by" in {
    parseDivideOptionally("2", "Banana") shouldBe None
  }

  // TODO - Q What did you notice in this improved composition?
  // Tip - print some text in each of the methods and see what is or isn't printed
  /* A
   - Divide optionally is never called if either of the numbers is invalid
   - The composition is short-circuited when an invalid number is encountered (number to divide or the one to divide by)
   - We can continue writing our program for the happy path, and handle the error at the end or somewhere else
   but we do so in a type-safe and referentially transparent way
   */

  /*
    That wraps up the chapter on Options.
    I encourage you to explore the API of Option, and try to use it in your own code!
    Next we'll look at Eithers!
   */
}
