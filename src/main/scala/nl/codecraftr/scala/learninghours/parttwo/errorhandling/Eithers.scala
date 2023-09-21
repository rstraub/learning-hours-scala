package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import cats.implicits._

private[errorhandling] object Eithers {
  case class Employee(name: String, department: Option[Department])
  case class Department(name: String, manager: Option[Manager])
  case class Manager(name: String)

  sealed trait EmployeeErrors
  case object EmployeeHasNoDepartment extends EmployeeErrors
  case object DepartmentHasNoManager extends EmployeeErrors

  def parseInput(input: String): Either[String, Int] =
    try {
      input.toInt.asRight
    } catch {
      case _: NumberFormatException => input.asLeft
    }

  def greetAny(input: String): String =
    parseInput(input).fold(
      s => s"Hello, $s!",
      i => s"In ten years you'll be ${i + 10} years old!"
    )

  def traverseHierarchy(employee: Employee): Either[EmployeeErrors, Manager] =
    for {
      department <- employee.department.toRight(EmployeeHasNoDepartment)
      manager <- department.manager.toRight(DepartmentHasNoManager)
    } yield manager
}
