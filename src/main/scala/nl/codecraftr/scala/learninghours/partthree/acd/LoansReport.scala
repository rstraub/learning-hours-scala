package nl.codecraftr.scala.learninghours.partthree.acd

case class LoanId(value: String) extends AnyVal

case class LoansReport(loans: Map[LoanId, Loan]) {
  def lines: List[String] = {
    val loanCountLine = s"${loans.size} Book loaned out"
    val loanLines = loans.map { case (id, loan) =>
      s"Loan '${id.value}' is '${loan.book}' by '${loan.renter}'"
    }.toList

    "Loans report:" :: loanCountLine :: loanLines
  }
}

case class Loan(book: String, renter: String)
