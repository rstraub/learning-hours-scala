package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import scala.util.Try

private[errorhandling] object Tries {
  case class Age(value: Int) extends AnyVal {
    override def toString: String = value.toString
  }

  object Age {
    val minAge = 0
    val maxAge = 120
    def from(age: Int): Try[Age] = ???
  }

  def parseAge(age: String): Try[Int] = ???

  def announce(name: String, age: String): Try[String] = ???
}
