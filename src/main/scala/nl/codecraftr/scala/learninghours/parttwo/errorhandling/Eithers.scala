package nl.codecraftr.scala.learninghours.parttwo.errorhandling


private[errorhandling] object Eithers {
  case class Employee(name: String, department: Option[Department])
  case class Department(name: String, manager: Option[Manager])
  case class Manager(name: String)

  sealed trait EmployeeErrors
  case object EmployeeHasNoDepartment extends EmployeeErrors
  case object DepartmentHasNoManager extends EmployeeErrors

  def parseInput(input: String): Either[String, Int] = ???

  def greetAny(input: String): String = ???

  def traverseHierarchy(employee: Employee): Either[EmployeeErrors, Manager] =
    ???
}
