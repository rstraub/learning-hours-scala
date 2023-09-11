package nl.codecraftr.scala.learninghours.partone

import nl.codecraftr.scala.learninghours.partone.Color._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

sealed trait Color extends Describable with Combinable {
  val name: String
}

trait Describable {
  val name: String
  def describe: String = s"im $name"
}

trait Combinable {
  val name: String
  def combine(color: Color): String = s"$name and ${color.name}"
}

object Color {
  case object Red extends Color {
    override val name: String = "Red"
  }

  case object Green extends Color {
    override val name: String = "Green"
  }

  case object Yellow extends Color {
    override val name: String = "Yellow"
  }

  def sentiment(color: Color): String = color match {
    case Red    => "I'm angry!"
    case Green  => "I'm jealous!"
    case Yellow => "I'm happy!"
    case _      => "I'm ... new"
  }
}

class TraitsAndADTsSpec extends AnyFlatSpec with Matchers {
  "traits" should "be used to create enums (product type ADT)" in {
    // TODO define a trait `Color` make the assertions pass
    // Tip put the colors in a companion object for easy importing!

    Red.name shouldBe "Red"
    Green.name shouldBe "Green"
  }

  it should "be possible to pattern match over ADTs" in {
    // TODO create a method `sentiment` and use pattern matching make the assertions pass

    Color.sentiment(Red) shouldBe "I'm angry!"
    Color.sentiment(Green) shouldBe "I'm jealous!"
    Color.sentiment(new Color {
      override val name: String = "Blue"
    }) shouldBe "I'm ... new"
  }

  it should "improve pattern matching by making the trait sealed" in {
    // TODO make the trait sealed and regenerate the pattern matching code
    // What difference do you see?
    // What is the effect of using sealed?
    // What happens when you add a new color? Tip, add another color extending the trait, hit build and look at the warnings

    Color.sentiment(Red) shouldBe "I'm angry!"
    Color.sentiment(Green) shouldBe "I'm jealous!"
    Color.sentiment(Yellow) shouldBe "I'm happy!"
  }

  "mixins" should "use traits to compose behavior" in {
    // TODO create a trait `Describable` with a `describe` method and make the assertions pass
    // Tip, mix in the behaviour on Color

    Red.describe shouldBe "im Red"
    Yellow.describe shouldBe "im Yellow"

    // TODO create a trait `Combinable` with a `combine` method and make the assertions pass
    // Tip, mix in the behaviour on Color
    Red combine Yellow shouldBe "Red and Yellow"
  }
}
