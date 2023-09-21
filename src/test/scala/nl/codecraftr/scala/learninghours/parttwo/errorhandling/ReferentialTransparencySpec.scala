package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color
import nl.codecraftr.scala.learninghours.partone.scalafeatures.Color._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ReferentialTransparencySpec extends AnyFlatSpec with Matchers {
  // TODO Q - discuss what referential transparency is
  // A -

  // TODO Q - discuss why referential transparency matters
  // A -

  // TODO Q - discuss what side effects are
  // A -

  // TODO Q - discuss the impact of side effects
  // A -

  // TODO Q - is the following function referentially transparent?
  // A -
  private def parseExceptionally(color: String): Color = {
    color match {
      case "R" => Red
      case "G" => Green
      case _   => throw new IllegalArgumentException("Unknown color")
    }
  }

  // TODO - prove it by writing a test showcasing your answer
  it should "not be referentially transparent" in {
    parseExceptionally("R") shouldBe Red
    parseExceptionally("G") shouldBe Green

    // Surrounding the call with a try/catch, aka changing the context, ends up producing a different result.
    val catchResult =
      try parseExceptionally("B")
      catch {
        case _: IllegalArgumentException => Red
      }

    catchResult shouldBe Red

    assertThrows[IllegalArgumentException](parseExceptionally("B"))
  }

  // TODO Q - Discuss problems about exceptions for error handling (both checked and unchecked)
  // A -

  // TODO Q - Discuss benefits of using exceptions for error handling
  // A -

  // Off to the next chapter - Sentinel Values!
}
