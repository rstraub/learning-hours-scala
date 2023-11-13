package nl.codecraftr.scala.learninghours.partthree.acd

import nl.codecraftr.scala.learninghours.partthree.acd.Term.{
  LongTerm,
  ShortTerm
}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LoansReportSpec extends AnyFlatSpec with Matchers {
  // Q - Discuss (and mark in code using comments) which parts are Actions/Calculations/Data
  // A - TODO

  // Q - How would you test the loans report output?
  // A - TODO

  // Q - How could we add a new output form with the current representation?
  // A - TODO

  private val loans =
    Map(
      LoanId("1") -> Loan("The Lord of the Rings", "J.R.R Tolkien", ShortTerm),
      LoanId("2") -> Loan("Game of Thrones", "George RR Martin", LongTerm),
      LoanId("3") -> Loan("The Dark Tower", "Stephen King", LongTerm),
      LoanId("4") -> Loan("Dune", "Frank Herbert", ShortTerm)
    )


  it should "should create lines of the report" in {
    val expected =
      """
            |"Loans report:",
            |        "4 Books loaned out",
            |        "Short term loans:",
            |        "Loan '1' is 'The Lord of the Rings' by 'J.R.R Tolkien'",
            |        "Loan '4' is 'Dune' by 'Frank Herbert'",
            |        "Long term loans:",
            |        "Loan '2' is 'Game of Thrones' by 'George RR Martin'",
            |        "Loan '3' is 'The Dark Tower' by 'Stephen King'"
            |""".stripMargin

    ReportLogger.log(loans)
  }

  // Q - Reflect your lessons in the code: separate concerns (ACD)
  // Tip: drive your implementation using tests (you can reuse the expected output)

  // Q - Also export the report to a file. Retain the same format as the console output.
}
