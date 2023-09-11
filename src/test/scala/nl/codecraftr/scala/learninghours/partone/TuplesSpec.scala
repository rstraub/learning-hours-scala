package nl.codecraftr.scala.learninghours.partone

import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/** https://docs.scala-lang.org/tour/tuples.html
  */
class TuplesSpec extends AnyFlatSpec with Matchers {
  "tuples" should "define a heterogeneous collection" in {
    // TODO define a tuple with a name and an age and make the assertions pass

    // person._1 shouldBe "John"
    // person._2 shouldBe 42
  }

  it should "use swap to flip the tuple" in {
    // TODO use swap to flip the tuple and make the assertions pass

    // person shouldBe ("John", 42)
    // flipped shouldBe (42, "John")
  }

  // https://docs.scala-lang.org/tour/tuples.html#pattern-matching-on-tuples
  it should "be used with pattern matching to take apart the tuple" in {
    // TODO use destructuring to take the tuple apart and make the assertions pass

    // name shouldBe "John"
    // age shouldBe 42
  }

}
