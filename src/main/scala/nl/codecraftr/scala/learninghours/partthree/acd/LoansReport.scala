package nl.codecraftr.scala.learninghours.partthree.acd

import nl.codecraftr.scala.learninghours.partthree.acd.Term.{
  LongTerm,
  ShortTerm
}

// Data, Domain representation
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

case class LoansReport(loans: Map[LoanId, Loan] /* Data */ ) {
  // Calculation
  def lines: List[String] = {
    val loanCountLine = s"${loans.size} Books loaned out"

    val shortTermLines = termLines(ShortTerm)
    val longTermLines = termLines(LongTerm)

    "Loans report:" :: loanCountLine :: shortTermLines ++ longTermLines
  }

  private def termLines(term: Term) =
    s"$term loans:" :: loans
      .filter(_._2.term == term)
      .map { case (id, loan) =>
        loanLine(id, loan)
      }
      .toList

  private def loanLine(id: LoanId, loan: Loan) =
    s"Loan '${id.value}' is '${loan.book}' by '${loan.renter}'"
}

// Action
object Logger {
  def log(lines: List[String]): Unit =
    lines.foreach(println)
}

// Action
object Writer {
  def write(lines: List[String]): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("target/report.txt"))
    lines.foreach(pw.println)
    pw.close()
  }
}
