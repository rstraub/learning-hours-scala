package nl.codecraftr.scala.learninghours.partone

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FunctionsSpec extends AnyFlatSpec with Matchers {
  "functions" should "be able to be assigned to variables" in {
    // TODO define a function `add` as a val and make the assertions pass

//    add(1, 2) shouldBe 3
  }

  it should "be possible to return functions (Higher-Order Function)" in {
    // TODO create a function `addX` and use it to add an arbitrary number to any number and make the assertions pass
    // Tip return a function that takes an Int and returns an Int, this is called a curried function

//    addX(5)(2) shouldBe 7
//    addTwo(3) shouldBe 5
//    addTwo(9) shouldBe 11
  }

  it should "be possible to pass functions as arguments" in {
    // TODO define a function `addAndThen` and make the assertions pass

//    addAndThen(1, 2, _ * 2) shouldBe 6
//    addAndThen(2, 4, _ / 2) shouldBe 3
  }
}
