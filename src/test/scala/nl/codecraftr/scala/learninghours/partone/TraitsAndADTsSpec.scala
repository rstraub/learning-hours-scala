package nl.codecraftr.scala.learninghours.partone

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TraitsAndADTsSpec extends AnyFlatSpec with Matchers {
  "traits" should "be used to create enums (product type ADT)" in {
    // TODO define a trait `Color` make the assertions pass
    // Tip put the colors in a companion object for easy importing!

//    Red.name shouldBe "Red"
//    Green.name shouldBe "Green"
  }

  it should "be possible to pattern match over ADTs" in {
    // TODO create a method `sentiment` and use pattern matching make the assertions pass

//    Color.sentiment(Red) shouldBe "I'm angry!"
//    Color.sentiment(Green) shouldBe "I'm jealous!"
//    Color.sentiment(new Color {
//      override def name: String = "Blue"
//    }) shouldBe "I'm ... new"
  }

  it should "improve pattern matching by making the trait sealed" in {
    // TODO make the trait sealed and regenerate the pattern matching code
    // What difference do you see?
    // What is the effect of using sealed?
    // What happens when you add a new color? Tip, add another color extending the trait, hit build and look at the warnings

//    Color.sentiment(Red) shouldBe "I'm angry!"
//    Color.sentiment(Green) shouldBe "I'm jealous!"
//    Color.sentiment(Yellow) shouldBe "I'm happy!"
  }

  "mixins" should "use traits to compose behavior" in {
    // TODO create a trait `Describable` with a `describe` method and make the assertions pass
    // Tip, mix in the behaviour on Color

//    Red.describe shouldBe "im Red"
//    Yellow.describe shouldBe "im Yellow"

    // TODO create a trait `Combinable` with a `combine` method and make the assertions pass
    // Tip, mix in the behaviour on Color
//    Red combine Yellow shouldBe "Red and Yellow"
  }
}
