package nl.codecraftr.scala.learninghours.parttwo.errorhandling

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class EitherSpec extends AnyFlatSpec with Matchers {
  /*
    Either is a data type that represents something that can be one of two things.
    It is similar to Option, but it can also retain the another thing, such as the cause of an error.
    It is also similar to Try, but is more flexible in the types it can contain.
    Try distinguishes between Success, being a T and Error being a Throwable,
    whereas Either distinguishes Left/Right which can be anything.

    Either is also Right-biased, which means that it will always execute operations on the right side (map/flatMap/filter/etc).

    When used for error-handling, the convention is to use Left for errors and Right for successful results,
    as the Right side is "right" or correct side.
   */

}
