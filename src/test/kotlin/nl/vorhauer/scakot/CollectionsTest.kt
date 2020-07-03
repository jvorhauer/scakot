package nl.vorhauer.scakot

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import scala.collection.immutable.List
import scala.collection.immutable.Set
import scala.collection.mutable.Map

class CollectionsTest: WordSpec() {

  init {
    "List" should {
      "support empty" {
        val l: List<String> = list()
        l.isEmpty shouldBe true
        l.size() shouldBe 0
      }

      "support vararg construction" {
        val l = list("One", "Two", "Three")
        l.isEmpty shouldBe false
        l.size() shouldBe 3
        l.apply(0) shouldBe "One"
        l.get(1) shouldBe some("Two")
        l.get(3) shouldBe none()
      }

      "support conversion from Kotlin list" {
        val l = listOf("One", "Two", "Three")
        val sl = list(l)
        sl.isEmpty shouldBe false
        sl.size() shouldBe 3
        sl.apply(0) shouldBe "One"
      }
    }

    "Set" should {
      "support empty" {
        val s: Set<String> = set()
        s.isEmpty shouldBe true
        s.size() shouldBe 0
      }

      "support vararg construction" {
        val s = set("One", "Two", "Three")
        s.isEmpty shouldBe false
        s.size() shouldBe 3
        s.isTraversableAgain shouldBe true
      }
    }


    "Map" should {
      "support empty" {
        val m: Map<String, Int> = map()
        m.isEmpty shouldBe true
      }

      "support create from vararg of pairs" {
        val m = map(Pair("One", 1), Pair("Two", 2), Pair("Three", 3))
        m.isEmpty shouldBe false
        m.size() shouldBe 3
        m.apply("One") shouldBe 1
        m.get("Two") shouldBe some(2)
        m.get("Hi") shouldBe none()
      }

      "support create from vararg of tuple2s" {
        val m = map(tuple("One", 1), tuple("Two", 2), tuple("Three", 3))
        m.isEmpty shouldBe false
        m.size() shouldBe 3
        m.apply("One") shouldBe 1
        m.get("Two") shouldBe some(2)
        m.get("Hi") shouldBe none()
      }
    }
  }
}
