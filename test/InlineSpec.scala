package ch.epfl

import org.scalatest.{ FlatSpec, ShouldMatchers }
import ch.epfl.inline._

class InlineSpec extends FlatSpec with ShouldMatchers {

  "inlineLift" should "work on simple inlines values" in {

    treeString(inlineLift(Inline(40))) should be("""Typed(Literal(Constant(40)), TypeTree())""")
  }

  /* "Inline" should "work with simple values" in {
    val x = List(1, 2, 3)
    x should be(List(1, 2, 3))
  }

  it should "inline def-constructs properly" in {
    def myDef(a: Int with Inline) = a

    myDef(5)
  }

  it should "inline the if construct if the arguments are static" in {
    def myDef(x: Int with Inline) =
      if(x > 3) "Yey!" else "Nope!"

    treeString(sinline(myDef(2))) should be("""Typed(Literal(Constant("Nope!")), TypeTree())""")
  }

  it should "inline match-constructs" in {
    def myDef(a: Int with Inline) =
      a match {
        case 2 => "Yey!"
        _ => "Nope!"
      }


      treeString(sinline(myDef(2))) should be("""Typed(Literal(Constant("Yey!")), TypeTree())""")
  }

  it should "be able to eliminate local collections" in {
    def myDef = {
      val list = 42 :: 4 :: Nil

      list(1)
    }

    treeString(sinline(myDef())) should be("""Typed(Literal(Constant(42)), TypeTree())""")
  }

  it should "be able to eliminate local collections even if they contain arguments" = {
    def myDef(a: Int with Inline) = {
      val list = 42 :: a :: Nil

      list(1)
    }

    treeString(sinline(myDef(101010))) should be("""Typed(Literal(Constant(101010)), TypeTree())""")
  }

  it should "be able to inline defs within defs" in {
    def myDef1(a: Int with Inline) =
      if(a >= 3) myDef2(42) else myDef2(89)
    def myDef2(b: Int with Inline) =
      b

    treeString(sinline(myDef1(2))) should be("""Typed(Literal(Constant(89)), TypeTree())""")
    treeString(sinline(myDef1(15))) should be("""Typed(Literal(Constant(42)), TypeTree())""")
  } */
}
