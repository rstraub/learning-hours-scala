package nl.codecraftr.scala.learninghours.partone

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/** https://docs.scala-lang.org/tour/singleton-objects.html
  * https://docs.scala-lang.org/overviews/scala-book/companion-objects.html#inner-main
  */
class ObjectsSpec extends AnyFlatSpec with Matchers {
  private case class Person(name: String, age: Int, gender: String) {
    private def secret: String = "psst, I like turtles"
  }

  "objects" should "create singletons" in {
    // Answer the following questions in your group:
    // What is the difference between an object and a class?
    // What happens with state in an object?
    // What makes mutating state in an object dangerous?

    // TODO define a calculator objects with a calculate method and make the assertions pass
    // TODO print something in the object body and inspect when that is executed

    // Calculator.add(1, 2) shouldBe 3
  }

  "companion objects" should "offer methods/variables for a corresponding class" in {
    // TODO define a companion object for the Person class and make the assertions pass
    // Make the `from` method determine the gender

    // Person.from("John", 42) shouldBe Person("John", 42, "Male")
    // Person.from("Jane", 37) shouldBe Person("Jane", 37, "Female")
  }

  it should "be able to access private variables/methods in its corresponding class" in {
    // TODO
    // Define a method `talkTo` on the companion object for the Person class
    // Call the `secret` method from with `talkTo`

    // Person.talkTo(Person("John", 42, "Male")) shouldBe "John has a secret: psst, I like turtles"
  }
}
