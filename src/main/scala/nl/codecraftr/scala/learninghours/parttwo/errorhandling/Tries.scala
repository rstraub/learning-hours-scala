package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import scala.util.{Failure, Success, Try}

private[errorhandling] object Tries {
  case class Age(value: Int) extends AnyVal {
    override def toString: String = value.toString
  }

  object Age {
    val minAge = 0
    val maxAge = 120
    def from(age: Int): Try[Age] =
      if (age >= minAge && age <= maxAge) Success(Age(age))
      else Failure(new IllegalArgumentException("Age must be between 0-120"))
  }

  def parseAge(age: String): Try[Int] = Try(age.toInt)

  def announce(name: String, age: String): Try[String] =
    for {
      parsed <- parseAge(age)
      validated <- Age.from(parsed)
    } yield s"$name is $validated years old"
}
