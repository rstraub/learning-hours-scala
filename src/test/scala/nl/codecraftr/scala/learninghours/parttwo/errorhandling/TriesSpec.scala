package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import nl.codecraftr.scala.learninghours.parttwo.errorhandling.Tries.Age.{
  maxAge,
  minAge
}
import nl.codecraftr.scala.learninghours.parttwo.errorhandling.Tries.{
  Age,
  parseAge,
  announce
}
import org.scalacheck.Gen
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.util.{Failure, Success}

/*
    https://www.scala-lang.org/api/2.13.12/scala/util/Try.html
 */
class TriesSpec
    extends AnyFlatSpec
    with Matchers
    with ScalaCheckPropertyChecks {
  /*
    Try is a data type that represents the result of an operation that may fail.
    It is similar to Option, but it can also contain the exception that was thrown,
    and results in either a Success of type T or a Failure of a Throwable.

    We can use Try on anything that throws an exception
   */

  // TODO - Make the tests pass, using Try for error handling
  // Tip - use the apply method on Try in your implementation
  "tryParseAge" should "return the a Success with the age given a valid number" in {
    parseAge("18") shouldBe Success(18)
  }

  it should "return a Failure given an invalid number" in {
    parseAge("eighteen") match {
      case Failure(e) => e shouldBe a[NumberFormatException]
      case Success(_) => fail("Should have returned a Failure")
    }
  }

  // TODO - implement the Age.from method using Try
  // Return a Success or Failure based on the condition
  "age" should "return a Success when it is between 0-120" in {
    val ages = Gen.choose(minAge, maxAge)
    forAll(ages) { (n: Int) =>
      Age.from(n) shouldBe Success(Age(n))
    }
  }

  it should "return a Failure when it is not between 0-120" in {
    Age.from(maxAge + 1) shouldBe a[Failure[_]]
    Age.from(minAge - 1) shouldBe a[Failure[_]]
  }

  // TODO compose the methods you created earlier to parse and validate an age in the announce method
  // Tip - use the for-comprehension syntax
  "announce" should "return a Successful announcement given a valid number in accepted age range" in {
    announce("John", "18") shouldBe Success("John is 18 years old")
  }

  it should "return a Failure given an invalid number" in {
    announce("John", "eighteen") match {
      case Failure(e) => e shouldBe a[NumberFormatException]
      case Success(_) => fail("Should have returned a Failure")
    }
  }

  it should "return a Failure given an invalid age" in {
    announce("John", "121") match {
      case Failure(e) => e shouldBe a[IllegalArgumentException]
      case Success(_) => fail("Should have returned a Failure")
    }
  }

  // TODO - Q When would you choose a Try over an Option?
  // A -

  /*
  As you can see, Try is a useful data type that can be used for error handling, and is similar in many ways to Option.
  Try is also usable in for comprehensions, which makes it very powerful for composing operations.

  Let's move on to Either, which is another data type that can be used for error handling.
   */
}
