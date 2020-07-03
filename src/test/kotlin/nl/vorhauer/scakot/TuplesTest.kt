package nl.vorhauer.scakot

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import scala.Product

class TuplesTest : WordSpec() {

  init {
    "Tuple1" should {
      "support factory" {
        val t = tuple("ScaKot is cool")
        t._1 shouldBe "ScaKot is cool"
        t.productElement(0) shouldBe "ScaKot is cool"
        t.productArity() shouldBe 1
        t.productElementName(0) shouldBe "_1"
      }
      "support unapply" {
        val t = tuple("ScaKot is cool")
        val (x) = t
        x shouldBe "ScaKot is cool"
      }
    }

    "Tuple2" should {
      "support factory" {
        val t = tuple("Cool", 42)
        t._1 shouldBe "Cool"
        t._2 shouldBe 42

        check(t, "Cool", 42) shouldBe true
      }

      "support unapply" {
        val t = tuple("Cool", 42)
        val (x1, x2) = t
        x1 shouldBe "Cool"
        x2 shouldBe 42
      }

      "support conversion to Pair" {
        val t = tuple("Cool", 42)
        val p = t.pair()
        p.first shouldBe "Cool"
        p.second shouldBe 42
      }
    }

    "Tuple3" should {
      "support factory" {
        val t = tuple("String", 42, false)
        t._1() shouldBe "String"
        t._2() shouldBe 42
        t._3() shouldBe false

        check(t, "String", 42, false) shouldBe true

        val (v1, v2, v3) = t
        v1 shouldBe "String"
        v2 shouldBe 42
        v3 shouldBe false
      }
    }

    "Tuple4" should {
      val t = tuple("String", 42, false, 5.4)
      check(t, "String", 42, false, 5.4) shouldBe true
    }

    "Tuple5" should {
      val t = tuple("String", 5, false, 4.5, "Five")
      check(t, "String", 5, false, 4.5, "Five") shouldBe true
    }
  }

  private fun check(p: Product, vararg args: Any): Boolean {
    return if (p.productArity() != args.size) false else !(args.mapIndexed { i, e -> p.productElement(i) == e }.contains(false))
  }
}
