package nl.codecraftr.scala.learninghours.partthree.acd

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LoansReportSpec extends AnyFlatSpec with Matchers {
  it should "should create lines of the report" in {
    val report = LoansReport(
      Map(
        LoanId("1") -> Loan("The Lord of the Rings", "J.R.R Tolkien"),
        LoanId("2") -> Loan("Game of Thrones", "George RR Martin")
      )
    )

    val result = report.lines

    result shouldBe
      List(
        "Loans report:",
        "2 Book loaned out",
        "Loan '1' is 'The Lord of the Rings' by 'J.R.R Tolkien'",
        "Loan '2' is 'Game of Thrones' by 'George RR Martin'"
      )
  }


}
