package ch.epfl.inline

import language.experimental.macros
import scala.reflect.macros.blackbox.Context
import scala.reflect.interpreter._

case class Inline[T](value: T) {
  def map[B](f: T => B): Inline[B] = Inline(f(value))
}

object InlineMacros {
  /* removes Inline from a value, hence forcing it to a value */
  def inlineLift[T](c: Context)(value: c.Expr[Inline[T]]): c.Expr[T] = {
    import c.universe._

    val v = interpret(c)(value.tree).asInstanceOf[Inline[T]].value

    c.Expr[T](v)
  }

  def treeString[T](c: Context)(body: c.Expr[T]): c.Expr[String] = {
    import c.universe._

    c.Expr[String](q"${showRaw(body.tree)}")
  }
}
