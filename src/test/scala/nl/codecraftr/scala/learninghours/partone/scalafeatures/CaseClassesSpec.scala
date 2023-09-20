package nl.codecraftr.scala.learninghours.partone.scalafeatures

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/** */
class CaseClassesSpec extends AnyFlatSpec with Matchers {
  private case class Cat(name: String, color: String) {
    def describe: String = (name, color) match {
      case ("Garfield", "Ginger") => "im garfield, and I'm Ginger!"
      case (_, "Grey")            => "im grey!"
      case _                      => "im just a cat"
    }
  }

  "case classes" should "have a copy, equals, hashCode and toString by default" in {
    // TODO create a case class Cat and make the assertions pass

    val cat = Cat("Garfield", "Ginger")
    val cat2 = cat.copy(name = "Nermal")
    val cat3 = Cat("Garfield", "Ginger")

    cat == cat2 shouldBe false
    cat == cat3 shouldBe true
    cat.hashCode == cat3.hashCode shouldBe true
    cat.toString shouldBe "Cat(Garfield,Ginger)"
  }

  // Answer the following questions in your group:
  // When would and wouldn't you use a class?
  // What visibility do case class properties have by default?

  it should "allow destructuring" in {
    // TODO destructure the cat and make the assertions pass
    // Tip: use the `unapply` method on `Cat`

    val cat = Cat("Garfield", "Ginger")
    val (name, color) = Cat.unapply(cat).get

    name shouldBe "Garfield"
    color shouldBe "Ginger"
  }

  it should "be possible to use pattern matching on case classes" in {
    val garfield = Cat("Garfield", "Ginger")
    val greyCat = Cat("Nermal", "Grey")
    val justACat = Cat("Tom", "Brown")

    // TODO use destructuring with pattern matching to make the assertions pass

    garfield.describe shouldBe "im garfield, and I'm Ginger!"
    greyCat.describe shouldBe "im grey!"
    justACat.describe shouldBe "im just a cat"
  }
}
