package nl.codecraftr.scala.learninghours.partthree.acd

case class LoanId(value: String) extends AnyVal

case class LoansReport(trackOrigins: Map[LoanId, Loan])

case class Loan(book: String, renter: String)

