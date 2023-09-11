package nl.codecraftr.scala.kata

import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class CanarySpec
    extends AnyWordSpec
    with Matchers
    with MockitoSugar
    with ScalaCheckPropertyChecks
    with BeforeAndAfter {

  before {
    println("fires before every test")
  }

  "scalatest" should {
    "run tests" in {
      true shouldBe true
    }
  }

  "scalacheck" should {
    "run property-based tests" in {
      forAll { (a: Int, b: Int) =>
        a + b shouldEqual b + a
      }
    }
  }
}
