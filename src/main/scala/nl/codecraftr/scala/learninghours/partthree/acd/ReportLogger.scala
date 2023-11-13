package nl.codecraftr.scala.learninghours.partthree.acd

import nl.codecraftr.scala.learninghours.partthree.acd.Term.{
  LongTerm,
  ShortTerm
}

// Domain representation
case class LoanId(value: String) extends AnyVal
case class Loan(book: String, renter: String, term: Term)
sealed trait Term
object Term {
  case object ShortTerm extends Term {
    override def toString = "Short term"
  }
  case object LongTerm extends Term {
    override def toString = "Long term"
  }
}

// Other stuff (could improve, but at least its not in the domain!!)
object ReportLogger {
  def log(loans: Map[LoanId, Loan]): Unit = {
    println("Loans report:")
    println(s"${loans.size} Books loaned out")
    println(s"$ShortTerm loans:")

    loans
      .filter(_._2.term == ShortTerm)
      .map { case (id, loan) =>
        s"Loan '${id.value}' is '${loan.book}' by '${loan.renter}'"
      }
      .foreach(println)

    println(s"$LongTerm loans:")
    loans
      .filter(_._2.term == LongTerm)
      .map { case (id, loan) =>
        s"Loan '${id.value}' is '${loan.book}' by '${loan.renter}'"
      }
      .foreach(println)
  }
}
