package ch.epfl

import scala.annotation.StaticAnnotation
import language.experimental.macros
import scala.reflect.macros.blackbox.Context

package object inline {
  def inlineLift[T](value: Inline[T]): T = macro InlineMacros.inlineLift[T]
  def treeString[T](body: T): String = macro InlineMacros.treeString[T]
}
