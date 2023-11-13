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
  private lazy val amountOfLoans = loans.size
  // Calculation
  private lazy val shortTermLoans = loans.filter(_._2.term == ShortTerm).toList
  // Calculation
  private lazy val longTermLoans = loans.filter(_._2.term == LongTerm).toList

  // Calculation
  def lines: List[String] = {
    val loanCountLine = s"$amountOfLoans Books loaned out"

    val shortTermLines = "Short term loans:" :: termLines(shortTermLoans)
    val longTermLines = "Long term loans:" :: termLines(longTermLoans)

    "Loans report:" :: loanCountLine :: shortTermLines ++ longTermLines
  }

  // Calculation
  private def termLines(loans: List[(LoanId, Loan)]) =
    loans
      .map { case (id, loan) =>
        loanLine(id, loan)
      }

  // Calculation
  private def loanLine(id: LoanId, loan: Loan) =
    s"Loan '${id.value}' is '${loan.book}' by '${loan.renter}'"
}

object Logger {
  // Action
  def log(lines: List[String]): Unit =
    lines.foreach(println)
}

// Action
object Writer {
  // Action
  def write(lines: List[String]): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("target/report.txt"))
    lines.foreach(pw.println)
    pw.close()
  }
}
