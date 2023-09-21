package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ReferentialTransparencySpec extends AnyFlatSpec with Matchers {
  // TODO Q - discuss what referential transparency is
  // A - Referential transparency means that a function call can be replaced by its result without changing the meaning of the program.

  // TODO Q - discuss why referential transparency matters
  // A - Makes it easier to reason about the code, as you don't have to consider the context of the function call.

  // TODO Q - discuss what side effects are
  // A - Side effects are changes to the state of the program that are observable outside the called function.

  // TODO Q - discuss the impact of side effects
  // A - Side effects make it harder to reason about the code, as "when" something is called starts to matter.
  // This results in code that is less reusable and harder to test.

  // TODO Q - is the following function referentially transparent?
  // A - No, as it throws an error, the result of which is dependent on the context of the function call.
  private def parseException(colors: String) = {
    colors match {
      case "R" => Red
      case "G" => Green
      case _   => throw new IllegalArgumentException("Unknown color")
    }
  }

  // TODO - prove it by writing a test showcasing your answer
  it should "not be referentially transparent" in {
    parseException("R") shouldBe Red
    parseException("G") shouldBe Green

    // Surrounding the call with a try/catch, aka changing the context, ends up producing a different result.
    val catchResult =
      try parseException("B")
      catch {
        case _: IllegalArgumentException => Red
      }

    catchResult shouldBe Red

    assertThrows[IllegalArgumentException](parseException("B"))
  }

  // TODO Q - Discuss problems about exceptions for error handling (both checked and unchecked)
  // A - Checked exceptions are a pain to deal with, as they have to be handled or bubbled up.
  // Unchecked exceptions are easier to deal with, but can be forgotten about, resulting in unexpected behavior.
  // They are also not type safe, as they are not part of the function signature, i.e. the caller doesn't know about them.
  // Of course they are also not referentially transparent, as they change the result of the function call.

  // TODO Q - Discuss benefits of using exceptions for error handling
  // A - They allow us to factor out error handling logic into reusable patterns, such as try/catch/finally.
}
