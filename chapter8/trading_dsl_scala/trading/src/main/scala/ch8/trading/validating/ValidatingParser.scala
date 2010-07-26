// Listing 8.10 A Validating Parser that can add domain semantics to a parser

package ch8.trading.validating
package dsl

import scala.util.parsing.combinator._

trait ValidatingParser extends Parsers {
  def validate[T](p: => Parser[T])(
    validation: (T, Input) => ParseResult[T]): Parser[T] = Parser {
      in => p(in) match {
	   case s @ Success(x, in) => validation(x, in)
	   case fail => fail
      }
    }
}
