package nl.codecraftr.scala.learninghours.partone.scalafeatures

sealed trait Color extends Describable with Combinable {
  val name: String
}

trait Describable {
  val name: String
  def describe: String = s"im $name"
}

trait Combinable {
  val name: String
  def combine(other: Combinable): String = s"$name and ${other.name}"
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
