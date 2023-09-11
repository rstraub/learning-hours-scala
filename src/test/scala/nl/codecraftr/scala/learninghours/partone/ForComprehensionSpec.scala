package nl.codecraftr.scala.learninghours.partone

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ForComprehensionSpec extends AnyFlatSpec with Matchers {
  private case class Owner(name: String, pets: List[Pet])
  private case class Pet(
      name: String,
      age: Int,
      favoriteDish: Option[String] = None
  )

  private val joe =
    Owner("Joe", List(Pet("Garfield", 42, Some("Lasagne")), Pet("Nermal", 9)))
  private val jane =
    Owner(
      "Jane",
      List(
        Pet("Tom", 7, Some("Pizza")),
        Pet("Sylvester", 13),
        Pet("Tweety", 2, Some("Seeds"))
      )
    )

  "for comprehensions" should "be used to chain flatMaps and maps" in {
    // TODO extract the names of pets using a for comprehension
    // Tip: you can "desugar" a for comprehension in intellij to see what it looks like under the hood

    val result = for {
      owner <- List(joe, jane)
      pet <- owner.pets
    } yield pet.name
    result shouldBe List("Garfield", "Nermal", "Tom", "Sylvester", "Tweety")
  }

  it should "be used to filter too" in {
    // TODO extract the names of pets that are older than 10 and have a favorite dish using a for comprehension

    val result = for {
      owner <- List(joe, jane)
      pet <- owner.pets
      if pet.age > 10
      dish <- pet.favoriteDish
    } yield pet.name -> dish
    result shouldBe List(("Garfield" -> "Lasagne"))
  }
}
