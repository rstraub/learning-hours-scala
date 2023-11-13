package nl.codecraftr.scala.learninghours.partthree.acd

import nl.codecraftr.scala.learninghours.partthree.acd.Term.{
  LongTerm,
  ShortTerm
}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LoansReportSpec extends AnyFlatSpec with Matchers {
  private val report = LoansReport(
    Map(
      LoanId("1") -> Loan("The Lord of the Rings", "J.R.R Tolkien", ShortTerm),
      LoanId("2") -> Loan("Game of Thrones", "George RR Martin", LongTerm),
      LoanId("3") -> Loan("The Dark Tower", "Stephen King", LongTerm),
      LoanId("4") -> Loan("Dune", "Frank Herbert", ShortTerm)
    )
  )

  it should "should create lines of the report" in {
    report.lines shouldBe
      List(
        "Loans report:",
        "4 Books loaned out",
        "Short term loans:",
        "Loan '1' is 'The Lord of the Rings' by 'J.R.R Tolkien'",
        "Loan '4' is 'Dune' by 'Frank Herbert'",
        "Long term loans:",
        "Loan '2' is 'Game of Thrones' by 'George RR Martin'",
        "Loan '3' is 'The Dark Tower' by 'Stephen King'"
      )
  }

  it should "log the report" in {
    Logger.log(report.lines)
  }

  it should "write report to a file" in {
    Writer.write(report.lines)
  }
}
