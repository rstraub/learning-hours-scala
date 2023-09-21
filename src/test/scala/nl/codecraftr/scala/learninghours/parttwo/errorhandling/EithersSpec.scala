package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import nl.codecraftr.scala.learninghours.parttwo.errorhandling.Eithers._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/*
 https://www.scala-lang.org/api/2.13.12/scala/util/Either.html
 https://www.scala-exercises.org/cats/either
 */
class EithersSpec extends AnyFlatSpec with Matchers {
  /*
    Either is a data type that represents something that can be one of two things.
    It is similar to Option, but it can also retain the another thing, such as the cause of an error.
    It is also similar to Try, but is more flexible in the types it can contain.
    Try distinguishes between Success, being a T and Error being a Throwable,
    whereas Either distinguishes Left/Right which can be anything.

    Either is also Right-biased, which means that it will always execute operations on the right side (map/flatMap/filter/etc).

    When used for error-handling, the convention is to use Left for errors and Right for successful results,
    as the Right side is "right" or correct side.
   */

  // TODO - make these pass
  "parseInput" should "hold name given some text" in {
    parseInput("John") shouldBe Left("John")
  }

  it should "hold age given parseable int" in {
    parseInput("42") shouldBe Right(42)
  }

  // This is what makes Eithers more flexible than Try

  // TODO - fix these, using parseInput
  // Tip - you can fold on the Either
  "greetAny" should "print a nice message given a name" in {
    greetAny("John") shouldBe "Hello, John!"
  }

  it should "print a nice message given an age" in {
    greetAny("42") shouldBe "In ten years you'll be 52 years old!"
  }

  // TODO - fix these tests and express errors as ADT's
  // Tip - again, Eithers can be used in for comprehensions
  // Tip - Options have a handy toRight method which converts it into an Either
  "traverseHierarchy" should "return manager of an employee" in {
    val employee =
      Employee("John", Some(Department("Sales", Some(Manager("Jane")))))

    traverseHierarchy(employee) shouldBe Right(Manager("Jane"))
  }

  it should "return a helpful error if the employee does not have a department" in {
    val employee = Employee("John", None)

    traverseHierarchy(employee) shouldBe Left(EmployeeHasNoDepartment)
  }

  it should "return a helpful error if the department does not have a manager" in {
    val employee = Employee("John", Some(Department("Sales", None)))

    traverseHierarchy(employee) shouldBe Left(DepartmentHasNoManager)
  }

  // TODO - Q in what cases would you use Eithers over Options?
  // A -
  // TODO - Q in what cases would you use Eithers over Try?
  // A -

  // I recommend you to explore Eithers on your own outside of this session,
  // the Cats library has a lot of useful functions for Eithers which are worth exploring

  // Lastly, we'll look at Validated
}
